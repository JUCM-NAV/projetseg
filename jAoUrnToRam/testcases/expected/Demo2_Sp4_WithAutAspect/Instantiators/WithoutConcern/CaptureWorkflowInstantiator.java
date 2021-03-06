package Demo2_Sp4_WithAutAspect.Instantiators.WithoutConcern;

import ram.reactiveworkflow.*;
import ram.workflow.*;

public class CaptureWorkflowInstantiator extends WorkflowInstantiator{
    public Workflow workflow=new Workflow();
    public ConditionalExecutionNode _OrFork70=new ConditionalExecutionNode();
    public EndNode _Captured=new EndNode();
    public StartupNode _Capture=new StartupNode();
    public CustomizableNode _ValidateWitnessInfo=createCustomizableNode("Demo2_Sp4_WithAutAspect.Steps.WithoutConcern.CaptureLocationType_ValidateWitness.ValidateWitnessInfo");
    public CustomizableNode _PhoneDataRequest=createCustomizableNode("Demo2_Sp4_WithAutAspect.Steps.WithoutConcern.CaptureWitnessInfo.PhoneDataRequest");
    public InputNode _ValidateWitness=new InputNode();
    public CustomizableNode _FakeCrisisNotification=createCustomizableNode("Demo2_Sp4_WithAutAspect.Steps.WithoutConcern.CaptureLocationType_ValidateWitness.FakeCrisisNotification");
    public EndNode _FakeCrisis=new EndNode();
    public InputNode _CaptureWitnessInfo=new InputNode();
    public CustomizableNode _CrisisInfoRequest=createCustomizableNode("Demo2_Sp4_WithAutAspect.Steps.WithoutConcern.CaptureWitnessInfo.CrisisInfoRequest");
    public InputNode _CaptureLocationType=new InputNode();
    public StubNode _AspectMarker812=new StubNode();
    public StubNode _AspectMarker813=new StubNode();
    public StubNode _AspectMarker814=new StubNode();
    public ParallelExecutionNode _AndFork1180=new ParallelExecutionNode();
    public SynchronizationNode _AndJoin1188=new SynchronizationNode();
    public CustomizableNode _ProcessCaptureWitnessInfo=createCustomizableNode("Demo2_Sp4_WithAutAspect.Steps.WithoutConcern.CaptureWitnessInfo.ProcessCaptureWitnessInfo");
    public CustomizableNode _ProcessCaptureLocationType=createCustomizableNode("Demo2_Sp4_WithAutAspect.Steps.WithoutConcern.CaptureLocationType_ValidateWitness.ProcessCaptureLocationType");

    public void link(){
        linkNodesToNextNodes();
        linkNodesToWorkflow();
        linkStartNodesToWorkflow();
    }

    public void linkNodesToNextNodes(){
        _OrFork70.addNextNode("witnessInfoNotVerified",_FakeCrisisNotification);
        _OrFork70.addNextNode("else",_Captured);
        _Capture.addNextNode(_CaptureWitnessInfo);
        _ValidateWitnessInfo.addNextNode(_AndJoin1188);
        _PhoneDataRequest.addNextNode(_ValidateWitness);
        _ValidateWitness.addNextNode(_AspectMarker813,"1");
        _FakeCrisisNotification.addNextNode(_FakeCrisis);
        _CaptureWitnessInfo.addNextNode(_AspectMarker812,"1");
        _CrisisInfoRequest.addNextNode(_CaptureLocationType);
        _CaptureLocationType.addNextNode(_AspectMarker814,"1");
        _AspectMarker812.addNextNode("1",_ProcessCaptureWitnessInfo);
        _AspectMarker813.addNextNode("1",_ValidateWitnessInfo);
        _AspectMarker814.addNextNode("1",_ProcessCaptureLocationType);
        _AndFork1180.addNextNode(_PhoneDataRequest);
        _AndFork1180.addNextNode(_CrisisInfoRequest);
        _AndJoin1188.addNextNode(_OrFork70);
        _ProcessCaptureWitnessInfo.addNextNode(_AndFork1180);
        _ProcessCaptureLocationType.addNextNode(_AndJoin1188);
    }

    public void linkNodesToWorkflow(){
        workflow.addNode(_OrFork70);
        workflow.addNode(_Captured);
        workflow.addNode(_Capture);
        workflow.addNode(_ValidateWitnessInfo);
        workflow.addNode(_PhoneDataRequest);
        workflow.addNode(_ValidateWitness);
        workflow.addNode(_FakeCrisisNotification);
        workflow.addNode(_FakeCrisis);
        workflow.addNode(_CaptureWitnessInfo);
        workflow.addNode(_CrisisInfoRequest);
        workflow.addNode(_CaptureLocationType);
        workflow.addNode(_AspectMarker812);
        workflow.addNode(_AspectMarker813);
        workflow.addNode(_AspectMarker814);
        workflow.addNode(_AndFork1180);
        workflow.addNode(_AndJoin1188);
        workflow.addNode(_ProcessCaptureWitnessInfo);
        workflow.addNode(_ProcessCaptureLocationType);
    }

    public void linkStartNodesToWorkflow(){
        workflow.addStartupNode(_Capture,false);
    }

    public void bind(Demo2_Sp4_WithAutAspect.Instantiators.WithoutConcern.AuthenticationWorkflowInstantiator p_Authentication){

        Binding l_AspectMarker812_PluginBinding=new Binding(p_Authentication.workflow);
        _AspectMarker812.addBinding(l_AspectMarker812_PluginBinding);
        _AspectMarker812.addInBinding(l_AspectMarker812_PluginBinding,"1",p_Authentication._IsAlreadyAuthenticated);
        _AspectMarker812.addOutBinding(l_AspectMarker812_PluginBinding,p_Authentication._AuthenticationVerified,"1");

        Binding l_AspectMarker813_PluginBinding=new Binding(p_Authentication.workflow);
        _AspectMarker813.addBinding(l_AspectMarker813_PluginBinding);
        _AspectMarker813.addInBinding(l_AspectMarker813_PluginBinding,"1",p_Authentication._IsAlreadyAuthenticated);
        _AspectMarker813.addOutBinding(l_AspectMarker813_PluginBinding,p_Authentication._AuthenticationVerified,"1");

        Binding l_AspectMarker814_PluginBinding=new Binding(p_Authentication.workflow);
        _AspectMarker814.addBinding(l_AspectMarker814_PluginBinding);
        _AspectMarker814.addInBinding(l_AspectMarker814_PluginBinding,"1",p_Authentication._IsAlreadyAuthenticated);
        _AspectMarker814.addOutBinding(l_AspectMarker814_PluginBinding,p_Authentication._AuthenticationVerified,"1");
    }
}
