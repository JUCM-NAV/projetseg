package one2one;

import java.io.PrintStream;
import java.util.ArrayList;

import ucm.performance.ExternalOperation;

/**
 * <!-- begin-user-doc --> Producing ExternalOperation declarations <!-- end-user-doc -->
 * 
 * @see one2one
 * @generated
 */

public class ExternalOperationConverter implements AbstractConverter {
    ExternalOperation externalOpn;
    // constructors
    public ExternalOperationConverter(ExternalOperation pr) {
	this.externalOpn = pr;
    }

    // prints XML representation of object to output file -- implement this!!
    public void Convert(PrintStream ps, ArrayList source, ArrayList target) {
	String id = "id=\"" + "e" + externalOpn.getId() + "\" ";
	String name = "name=\"" + externalOpn.getName() + "\" ";
	String description;
	String opTime = "opTime=\"" + externalOpn.getOpTime()+ "\" "; 
	String multiplicity;
	String schedPolicy;
	if (externalOpn.getDescription() != null) {
	    description = "description=\"" + externalOpn.getDescription() + "\" ";
	} else
	    description = "";
	if (externalOpn.getMultiplicity() != null) {
	    multiplicity = "multiplicity=\"" + externalOpn.getMultiplicity() + "\" ";
	} else {
	    multiplicity = "";
	}
	if (externalOpn.getSchedPolicy() != null) {
	    schedPolicy = "schedPolicy=\"" + externalOpn.getSchedPolicy() + "\" ";
	} else {
	    schedPolicy = "";
	}
	String traceabilityLink = "traceabilityLink=\"" + externalOpn.getId() + "\" ";
	String resStr = "<ExternalOperation "
	    + id + name + opTime + description + multiplicity + schedPolicy + traceabilityLink
            +  "/>";
        ps.println("        " + resStr);
        ps.flush();
        
	

        
        
    }
}