/**
 * 
 */
package seg.jUCMNav.model.commands.create;

import org.eclipse.gef.commands.Command;

import seg.jUCMNav.model.ModelCreationFactory;
import seg.jUCMNav.model.commands.JUCMNavCommand;
import seg.jUCMNav.scenarios.ScenarioUtils;
import ucm.scenario.Variable;
import urn.URNspec;

/**
 * This command adds a global variable 
 * 
 * @author jkealey
 *
 */
public class CreateVariableCommand extends Command implements JUCMNavCommand {

    private URNspec urn;
    private Variable var;
    private String type;
    private String name;
    /**
     * 
     */
    public CreateVariableCommand(URNspec urn, String type) {
        this.urn = urn;
        this.type = type;
        setLabel("Create Variable");
    }

    public CreateVariableCommand(URNspec urn, String type, String name) {
        this.urn = urn;
        this.type = type;
        this.name = name;
        setLabel("Create Variable");
    }

    
    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute() {
        return urn != null && type != null && (type == ScenarioUtils.sTypeBoolean || type == ScenarioUtils.sTypeInteger || type == ScenarioUtils.sTypeEnumeration);
    }
    
    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute() {
    	var = (Variable) ModelCreationFactory.getNewObject(urn, Variable.class, 0, type);
    	if (name!=null) var.setName(name);
        redo();
    }

    /**
     * 
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo() {
        testPreConditions();
        urn.getUcmspec().getVariables().add(var);
        testPostConditions();
    }
    
    /* (non-Javadoc)
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPreConditions()
     */
    public void testPostConditions() {
        assert urn != null && urn.getUcmspec() != null && var != null && type!=null  : "post not null"; //$NON-NLS-1$
        assert urn.getUcmspec().getVariables().contains(var): "post var not in model"; //$NON-NLS-1$
        assert var.getType().equals(this.type) : "post type not set"; //$NON-NLS-1$
    }

    /* (non-Javadoc)
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPostConditions()
     */
    public void testPreConditions() {
        assert urn != null && urn.getUcmspec() != null && var != null && type!=null : "pre not null"; //$NON-NLS-1$
        assert !urn.getUcmspec().getVariables().contains(var) : "pre var not in model"; //$NON-NLS-1$
        assert var.getType().equals(this.type) : "pre type not set"; //$NON-NLS-1$
    }


    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo() {
        testPostConditions();
        urn.getUcmspec().getVariables().remove(var);
        testPreConditions();
    }
}
