package seg.jUCMNav.model.commands.delete.internal;

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.gef.commands.Command;

import seg.jUCMNav.model.commands.JUCMNavCommand;
import ucm.map.ComponentRef;
import ucm.map.UCMmap;
import ucm.map.PathNode;
import ucm.map.RespRef;
import urn.URNspec;
import urncore.ComponentElement;
import urncore.Responsibility;

/**
 * This class unlinks a Map from its ComponentRef->ComponentElement and RespRef->Responsibility references. It will also remove the map from its URNspec.
 * 
 * Intended to be used only by DeleteMapCommand, as PluginBindings might subsist.   
 * 
 * @author jkealey
 *  
 */
public class DeleteMapRefDefLinksCommand extends Command implements JUCMNavCommand {

    // its references to definitions.
    private Hashtable htReferences;

    // the map to delete
    private UCMmap map;

    // the URNspec in which it is contained
    private URNspec urn;
    
    private int mapPosition;
    

    /**
     * @param m
     *            the map to delete
     */
    public DeleteMapRefDefLinksCommand(UCMmap m) {
        setMap(m);
        setLabel("DeleteRefDefLinks");//$NON-NLS-1$
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute() {
        return getMap() != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute() {
        // also set the relations
        urn = getMap().getUrndefinition().getUrnspec();
        htReferences = new Hashtable();
        for (Iterator iter = map.getCompRefs().iterator(); iter.hasNext();) {
            ComponentRef comp = (ComponentRef) iter.next();
            htReferences.put(comp, comp.getCompDef());
        }

        for (Iterator iter = map.getNodes().iterator(); iter.hasNext();) {
            PathNode node = (PathNode) iter.next();
            if (node instanceof RespRef)
                htReferences.put(node, ((RespRef) node).getRespDef());
        }
        
        mapPosition = getMap().getUrndefinition().getSpecDiagrams().indexOf(getMap());
        redo();
    }

    public UCMmap getMap() {
        return map;
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo() {
        testPreConditions();
        
        // remove map
        urn.getUrndef().getSpecDiagrams().remove(getMap());

        // break relations
        for (Iterator iter = map.getCompRefs().iterator(); iter.hasNext();) {
            ComponentRef comp = (ComponentRef) iter.next();
            comp.setCompDef(null);
        }

        for (Iterator iter = map.getNodes().iterator(); iter.hasNext();) {
            PathNode node = (PathNode) iter.next();
            if (node instanceof RespRef)
                ((RespRef) node).setRespDef(null);
        }
        
        testPostConditions();
    }

    public void setMap(UCMmap map) {
        this.map = map;
    }

    /**
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPostConditions()
     */
    public void testPostConditions() {
        // lists could be empty but not null
        assert getMap() != null && urn != null : "post something is null"; //$NON-NLS-1$
        assert !urn.getUrndef().getSpecDiagrams().contains(getMap()) : "post map still in model"; //$NON-NLS-1$

        // verify no more references
        for (Iterator iter = map.getCompRefs().iterator(); iter.hasNext();) {
            ComponentRef comp = (ComponentRef) iter.next();
            assert comp.getCompDef() == null : "post compRef still references definition"; //$NON-NLS-1$
        }

        for (Iterator iter = map.getNodes().iterator(); iter.hasNext();) {
            PathNode node = (PathNode) iter.next();
            if (node instanceof RespRef)
                assert ((RespRef) node).getRespDef() == null : "post respref still references definition"; //$NON-NLS-1$
        }
    }

    /**
     * 
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPreConditions()
     */
    public void testPreConditions() {

        // lists could be empty but not null
        assert getMap() != null && urn != null : "pre something is null"; //$NON-NLS-1$
        assert urn.getUrndef().getSpecDiagrams().contains(getMap()) : "pre map in model"; //$NON-NLS-1$
        // verify that all elements have references; (for legal ucm)
        for (Iterator iter = map.getCompRefs().iterator(); iter.hasNext();) {
            ComponentRef comp = (ComponentRef) iter.next();
            assert comp.getCompDef() != null : "pre compRef doesn't reference definition"; //$NON-NLS-1$
        }

        for (Iterator iter = map.getNodes().iterator(); iter.hasNext();) {
            PathNode node = (PathNode) iter.next();
            if (node instanceof RespRef)
                assert ((RespRef) node).getRespDef() != null : "post respref doesn't reference definition"; //$NON-NLS-1$
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo() {
        testPostConditions();

        super.undo();

        // re-add map
        urn.getUrndef().getSpecDiagrams().add(mapPosition, getMap());

        // re-add references
        for (Iterator iter = map.getCompRefs().iterator(); iter.hasNext();) {
            ComponentRef comp = (ComponentRef) iter.next();
            comp.setCompDef((ComponentElement) htReferences.get(comp));
        }

        for (Iterator iter = map.getNodes().iterator(); iter.hasNext();) {
            PathNode node = (PathNode) iter.next();
            if (node instanceof RespRef)
                ((RespRef) node).setRespDef((Responsibility) htReferences.get(node));
        }
        testPreConditions();
    }

}