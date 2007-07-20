package seg.jUCMNav.kpi.ws;

import grl.Evaluation;
import grl.EvaluationStrategy;
import grl.IntentionalElement;
import grl.kpimodel.Indicator;
import grl.kpimodel.KPIEvalValueSet;

import java.util.ArrayList;
import java.util.List;

import seg.jUCMNav.kpi.KPIValueResources;
import seg.jUCMNav.strategies.EvaluationStrategyManager;
import seg.jUCMNav.views.preferences.KPIMonitoringPreferences;

/**
 * @author pchen
 * 
 */
public class KPIValueWSResources implements KPIValueResources {

    public KPIValueWSResources() {
    }

    public void requestKPIValues(List evalObjects) {
        try {
            if (evalObjects != null && evalObjects.size() > 0) {
                // For testing = "http://localhost:9080/KPIValueWebServiceBeanService/KPIValueWebServiceBean"
                String wsAddress = KPIMonitoringPreferences.getWebServiceAddress();
                KPIValueWebServiceBean port = new KPIValueWebServiceBeanProxy(wsAddress).getKPIValueWebServiceBean();

                List kpiEntities = new ArrayList();
                for (int i = 0; i < evalObjects.size(); i++) {
                    KpiEntity kpiEntity = new KpiEntity();
                    EvaluationStrategy strategy = ((Evaluation) evalObjects.get(i)).getStrategies();
                    IntentionalElement intElem = ((Evaluation) evalObjects.get(i)).getIntElement();
                    if (!(intElem instanceof Indicator)) {
                        continue;
                    }

                    kpiEntity.setStrategyName(strategy.getName());
                    kpiEntity.setIndicatorName(intElem.getName());
                    kpiEntities.add(kpiEntity);
                }

                KpiEntity[] result = port.retrieveKPIValues((KpiEntity[]) kpiEntities.toArray(new KpiEntity[0]));

                EvaluationStrategyManager strategyManager = EvaluationStrategyManager.getInstance();
                for (int i = 0; i < result.length; i++) {
                    // System.out.println("Result" + i + ": " + ((KpiEntity) result[i]).getIndicatorName() + " - " + ((KpiEntity) result[i]).getKpiValue());
                    KPIEvalValueSet kpiEvalValueSet = ((Evaluation) evalObjects.get(i)).getKpiEvalValueSet();
                    kpiEvalValueSet.setEvaluationValue(Double.parseDouble(((KpiEntity) result[i]).getKpiValue()));

                    strategyManager.calculateIndicatorEvalLevel((Evaluation) evalObjects.get(i));
                }

                strategyManager.calculateEvaluation();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
