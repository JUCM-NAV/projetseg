/**
 * 
 */
package seg.jUCMNav.model.commands.delete;

import grl.Evaluation;
import grl.EvaluationStrategy;
import grl.kpimodel.KPIInformationConfig;

import java.util.Iterator;

import org.eclipse.gef.commands.CompoundCommand;

import seg.jUCMNav.Messages;
import seg.jUCMNav.model.commands.delete.internal.RemoveEvaluationStrategyCommand;

/**
 * This command delete a strategy. It generate command to delete all evaluations, and all kpiinformationconfigs and delete the strategy after.
 * 
 * @author Jean-Fran�ois Roy, pchen
 * 
 */
public class DeleteStrategyCommand extends CompoundCommand {

    public DeleteStrategyCommand(EvaluationStrategy strategy) {
        setLabel(Messages.getString("DeleteEvaluationStrategyCommand.deleteEvaluationStrategy")); //$NON-NLS-1$

        for (Iterator iter = strategy.getEvaluations().iterator(); iter.hasNext();) {
            Evaluation eval = (Evaluation) iter.next();
            add(new DeleteEvaluationCommand(eval));
        }

        for (Iterator iter = strategy.getKpiInfoConfig().iterator(); iter.hasNext();) {
            KPIInformationConfig config = (KPIInformationConfig) iter.next();
            add(new DeleteKPIInformationConfigCommand(config));
        }

        add(new RemoveEvaluationStrategyCommand(strategy));
    }

}
