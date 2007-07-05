package seg.ucm2csm.one2one;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Vector;

import ucm.map.AndFork;

/**
 * Creates the CSM representation(And-Fork) of the AndFork object.
 * 
 * @see seg.ucm2csm.one2one
 */

public class AndForkConverter implements AbstractConverter {

    private AndFork andForkNode;

    private PathConnAttributes patthConnAttribs = new PathConnAttributes();

    // constructors
    public AndForkConverter(AndFork af) {
        this.andForkNode = af;
    }

    // prints XML representation of object to output file
    public void Convert(PrintStream ps, ArrayList source, ArrayList target, Vector warnings) {

        // object attributes
        String id_attribute = "<Fork id=\"" + "h" + this.andForkNode.getId() + "\" ";
        String traceabilityLink = "traceabilityLink=\"" + this.andForkNode.getId() + "\" ";
        ps.print("            " + id_attribute + traceabilityLink);

        String closing_attribute = "/>";

        // optional attributes
        this.patthConnAttribs.OptionalAttributes(this.andForkNode, ps, source, target);

        ps.println(closing_attribute);
        ps.flush();
    }

}