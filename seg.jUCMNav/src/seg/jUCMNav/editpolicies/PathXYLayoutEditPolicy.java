/*
 * Created on 2005-02-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package seg.jUCMNav.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import seg.jUCMNav.model.commands.CreateNodeCommand;
import seg.jUCMNav.model.ucm.EndPoint;
import seg.jUCMNav.model.ucm.Node;
import seg.jUCMNav.model.ucm.Path;
import seg.jUCMNav.model.ucm.Responsibility;
import seg.jUCMNav.model.ucm.SizedElement;
import seg.jUCMNav.model.ucm.StartPoint;

/**
 * Created 2005-02-22
 * 
 * @author Etienne Tremblay
 */
public class PathXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * 
	 */
	public PathXYLayoutEditPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	protected Command createAddCommand(EditPart child, Object constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) {
		Object	newObjectType = null;
		if(request.getNewObject() != null)
			newObjectType = request.getNewObjectType();
		Command	createCommand = null;
		
		if( newObjectType == Node.class 
			|| newObjectType == Responsibility.class 
			|| newObjectType == StartPoint.class
			|| newObjectType == EndPoint.class)
		{
			CreateNodeCommand create = new CreateNodeCommand();
			create.setPath((Path)getHost().getModel());
			create.setLocation(request.getLocation());
			create.setNode( (SizedElement)request.getNewObject() );
			create.setLabel("Create a node");
			createCommand = create;
		}
		
		return createCommand;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	protected Command getDeleteDependantCommand(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
