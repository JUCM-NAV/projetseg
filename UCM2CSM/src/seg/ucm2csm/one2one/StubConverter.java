package seg.ucm2csm.one2one;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.core.resources.IMarker;

import ucm.map.InBinding;
import ucm.map.OutBinding;
import ucm.map.PathNode;
import ucm.map.PluginBinding;
import ucm.map.Stub;

/**
 * Creates the CSM representation(Step) of the Stub object Component-Ref object.
 * 
 * @see seg.ucm2csm.one2one
 */
public class StubConverter implements AbstractConverter {

    private Stub stub;

    private StepAttributes stepAttribs = new StepAttributes();

    // constructors
    public StubConverter(Stub stub) {
        this.stub = stub;
    }

    // prints XML representation of object to output file
    public void Convert(PrintStream ps, ArrayList source, ArrayList target, Vector warnings) {
        // ?js ((PluginBinding) stub.getBindings().get(0)).getProbability();

        // TODO: predecessor/successor (from parameters source/target) may be
        // (correctly) pointing at newly inserted (CSM) DummySequences
        // while PluginBinding still points at the elements referred within the
        // UCM structure.

        // object attributes
        String predecessorWithCommas = (String) source.toString().subSequence(1, (source.toString().length() - 1));
        String predecessor = predecessorWithCommas.replaceAll(",", "");
        if (this.stub.getPred().size() > 1) {
            warnings.add(new CsmExportWarning("Stub " + this.stub.getName() + " has more than one predecessor", this.stub));
        }
        String successorWithCommas = (String) target.toString().subSequence(1, (target.toString().length() - 1));
        String successor = successorWithCommas.replaceAll(",", "");
        if (this.stub.getSucc().size() > 1) {
            warnings.add(new CsmExportWarning("Stub " + this.stub.getName() + " has more than one successor", this.stub));
        }
        String name = null;
        if (this.stub.getBindings().size() == 0) {
            warnings.add(new CsmExportWarning("Stub " + this.stub.getName() + " has no bindings", this.stub, IMarker.SEVERITY_ERROR));
            name = this.stub.isDynamic() ? this.stub.getName() : this.stub.getName() + "/" + "ERROR_NO_BINDING";
        } else {
            name = this.stub.isDynamic() ? this.stub.getName() : this.stub.getName() + "/" + ((PluginBinding) (this.stub.getBindings().get(0))).getPlugin().getName();
        }

        String mandatory_attribute = "<Step id=\"" + "h" + this.stub.getId() + "\" " + "name=\"" + name + "\" " + "predecessor=\"" + predecessor + "\" "
                + "successor=\"" + successor + "\" ";
        ps.print("            " + mandatory_attribute);

        // optional attributes
        this.stepAttribs.OptionalAttributes(this.stub, ps);
        ps.println("> <!-- Stub -->");

        // Dynamic Stub
        if (this.stub.isDynamic()) {
            String stubId = this.stub.getId();
            String fake_stubId = "fs_" + stubId;
            String plugBind_head = "<Refinement parent=\"" + "h" + stubId + "\" sub=\"" + fake_stubId + "\" >";

            String plugBind_tail = "</Refinement>";
            // String oneTab = " ";
            // String twoTab = " ";
            String threeTab = "                ";
            String fourTab = "                    ";
            ps.println(threeTab + plugBind_head);

            /**
             * All bindings should have the same cardinality. We're using the first binding one as "skeleton" for all of them. The proper binding of the maps
             * should be checked. JS
             */
            if (this.stub.getBindings().size() != 0) {
                PluginBinding pb = (PluginBinding) this.stub.getBindings().get(0);
                int nthIn = 0;
                for (Iterator inBindingIterator = pb.getIn().iterator(); inBindingIterator.hasNext();) {
                    InBinding ib = (InBinding) inBindingIterator.next();
                    String inBind = "<InBinding start=\"" + fake_stubId + "_start_" + nthIn + "\" " + "in=\"h"
                            + ((PathNode) ib.getStubEntry().getSource()).getId() + "\" />";
                    ps.println(fourTab + inBind);
                    nthIn++;
                }
                int nthOut = 0;
                for (Iterator outBindingIterator = pb.getOut().iterator(); outBindingIterator.hasNext();) {
                    OutBinding ob = (OutBinding) outBindingIterator.next();
                    String outBind = "<OutBinding end=\"" + fake_stubId + "_end_" + nthOut + "\" " + "out=\"h"
                            + ((PathNode) ob.getStubExit().getTarget()).getId() + "\" />";
                    ps.println(fourTab + outBind);
                    nthOut++;
                }
            }

            ps.println(threeTab + plugBind_tail);
            // PluginBindings will be output as branches in another map
            // Static Stub
        } else {
            // process bindings as CSM refinements
            for (Iterator iter = this.stub.getBindings().iterator(); iter.hasNext();) {
                PluginBinding binding = (PluginBinding) iter.next();
                PluginBindingConverter bind_obj = new PluginBindingConverter(binding);
                bind_obj.Convert(ps, source, target, warnings);
            }
        }

        // output to file
        String closing_attribute = "</Step>";
        ps.println("            " + closing_attribute);
        ps.flush();
    }
}