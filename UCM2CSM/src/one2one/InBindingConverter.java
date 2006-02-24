package one2one;

import java.io.PrintStream;

import ucm.map.InBinding;

/**
 * <!-- begin-user-doc -->
 * Creates the CSM representation(inbinding) of the In-Connection object
 * <!-- end-user-doc -->
 * @see one2one 
 * @generated
 */
public class InBindingConverter implements AbstractConverter{
	private InBinding in_bind;
	// constructors
    public InBindingConverter(InBinding in_bind){
       this.in_bind = in_bind;
    }
    
    // prints XML representation of object to output file
	public void Convert(PrintStream ps){
		        
	    // object attributes
	    String Object_attributes = "<inbinding id=\"" + "si" + in_bind.getBinding() + "\"" + " " +
                                    "start=\"" + "h" + in_bind.getStartPoint()  + "\"" + " " + 
                                    "in=\"" + "h" + in_bind.getStubEntry() +"\"/>";
		        
	    // output to file
	    ps.println("            " + Object_attributes);
	    ps.flush();                    
 }
		    


}