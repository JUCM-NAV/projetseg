package seg.jUCMNav.model.util;

import grl.Actor;
import grl.IntentionalElement;

import java.util.Iterator;

import seg.jUCMNav.editparts.PathNodeEditPart;
import seg.jUCMNav.model.ModelCreationFactory;
import seg.jUCMNav.strategies.EvaluationStrategyManager;
import ucm.map.PathNode;
import ucm.map.UCMmap;
import urn.URNspec;
import urncore.IURNDiagram;
import urncore.Metadata;
import urncore.URNmodelElement;

public class MetadataHelper {

    /**
     * Adds metadata to an element. Modifies if the name already exists.
     * 
     * @param urnspec
     *            the urnspec containing everything
     * @param elem
     *            the element
     * @param name
     *            the name of the metadata to add
     * @param value
     *            the value to add
     */
    public static void addMetaData(URNspec urnspec, URNmodelElement elem, String name, String value) {
        Metadata md = getMetaDataObj(elem, name);
        if (md == null) {
            Metadata data = (Metadata) ModelCreationFactory.getNewObject(urnspec, Metadata.class);
            data.setName(name);
            data.setValue(value);
            elem.getMetadata().add(data);
        } else {
            md.setValue(value);
        }
    }

    /**
     * Removes all metadata of specified name from an element.
     * 
     * @param elem
     *            the element
     * @param name
     *            the name of the metadata to remove
     */
    public static void removeMetaData(URNmodelElement elem, String name) {
        for (Iterator iter = elem.getMetadata().iterator(); iter.hasNext();) {
            Metadata data = (Metadata) iter.next();
            if (data.getName() != null && data.getName().equals(name)) {
                iter.remove();
                // elem.getMetadata().remove(data);
            }
        }
    }

    /**
     * Returns an element's metadata.
     * 
     * @param elem
     *            the element
     * @param name
     *            the name of the metadata
     * @return the value of the metadata
     */
    public static String getMetaData(URNmodelElement elem, String name) {

        for (Iterator iter = elem.getMetadata().iterator(); iter.hasNext();) {
            Metadata data = (Metadata) iter.next();
            if (data.getName() != null && data.getName().equals(name))
                return data.getValue();
        }

        return null;
    }

    /**
     * Returns an element's metadata object
     * 
     * @param elem
     *            the element
     * @param name
     *            the name of the metadata
     * @return the metadata object
     */
    public static Metadata getMetaDataObj(URNmodelElement elem, String name) {

        for (Iterator iter = elem.getMetadata().iterator(); iter.hasNext();) {
            Metadata data = (Metadata) iter.next();
            if (data.getName() != null && data.getName().equals(name))
                return data;
        }

        return null;
    }

    /**
     * Removes the run-time metadata elements created during GRL evaluation and/or UCM execution
     * 
     * @param model
     *            the URNspec instance
     */
    public static synchronized void cleanRunTimeMetadata(URNspec model) {
        if (model != null) {
            // Remove run-time evaluation metadata attached to actors
            for (Iterator iter = model.getGrlspec().getActors().iterator(); iter.hasNext();) {
                Actor actor = (Actor) iter.next();
                MetadataHelper.removeMetaData(actor, EvaluationStrategyManager.METADATA_NUMEVAL);
                MetadataHelper.removeMetaData(actor, EvaluationStrategyManager.METADATA_QUALEVAL);
            }
            // Remove run-time evaluation metadata attached to intentional elements
            for (Iterator iter2 = model.getGrlspec().getIntElements().iterator(); iter2.hasNext();) {
                IntentionalElement ie = (IntentionalElement) iter2.next();
                MetadataHelper.removeMetaData(ie, EvaluationStrategyManager.METADATA_NUMEVAL);
                MetadataHelper.removeMetaData(ie, EvaluationStrategyManager.METADATA_QUALEVAL);
            }
            // Remove run-time evaluation metadata attached to path nodes
            for (Iterator iter3 = model.getUrndef().getSpecDiagrams().iterator(); iter3.hasNext();) {
                IURNDiagram diagram = (IURNDiagram) iter3.next();
                if (diagram instanceof UCMmap) {
                    for (Iterator iterIn = diagram.getNodes().iterator(); iterIn.hasNext();) {
                        PathNode pn = (PathNode) iterIn.next();
                        MetadataHelper.removeMetaData(pn, PathNodeEditPart.METADATA_HITS);
                    }
                }
            }
        }
    }

    /**
     * Indicates whether the named metadata was inserted at run-time (e.g. for GRL evaluation)
     * 
     * @param name
     *            name of the metadata
     * @return true if the metadata was inserted at run-time
     */
    public static boolean isRuntimeMetadata(String name) {
        return (name == EvaluationStrategyManager.METADATA_NUMEVAL || name == EvaluationStrategyManager.METADATA_QUALEVAL || name == PathNodeEditPart.METADATA_HITS);
    }
}
