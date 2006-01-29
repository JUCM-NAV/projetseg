/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ucm.map.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import ucm.map.Connect;
import ucm.map.MapPackage;

import urncore.NodeLabel;
import urncore.IURNContainerRef;
import urncore.IURNDiagram;
import urncore.UrncorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConnectImpl extends PathNodeImpl implements Connect {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConnectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return MapPackage.eINSTANCE.getConnect();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case MapPackage.CONNECT__FROM_LINKS:
                    return ((InternalEList)getFromLinks()).basicAdd(otherEnd, msgs);
                case MapPackage.CONNECT__TO_LINKS:
                    return ((InternalEList)getToLinks()).basicAdd(otherEnd, msgs);
                case MapPackage.CONNECT__DIAGRAM:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, MapPackage.CONNECT__DIAGRAM, msgs);
                case MapPackage.CONNECT__CONT_REF:
                    if (contRef != null)
                        msgs = ((InternalEObject)contRef).eInverseRemove(this, UrncorePackage.IURN_CONTAINER_REF__NODES, IURNContainerRef.class, msgs);
                    return basicSetContRef((IURNContainerRef)otherEnd, msgs);
                case MapPackage.CONNECT__SUCC:
                    return ((InternalEList)getSucc()).basicAdd(otherEnd, msgs);
                case MapPackage.CONNECT__PRED:
                    return ((InternalEList)getPred()).basicAdd(otherEnd, msgs);
                case MapPackage.CONNECT__LABEL:
                    if (label != null)
                        msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MapPackage.CONNECT__LABEL, null, msgs);
                    return basicSetLabel((NodeLabel)otherEnd, msgs);
                default:
                    return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
            }
        }
        if (eContainer != null)
            msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case MapPackage.CONNECT__FROM_LINKS:
                    return ((InternalEList)getFromLinks()).basicRemove(otherEnd, msgs);
                case MapPackage.CONNECT__TO_LINKS:
                    return ((InternalEList)getToLinks()).basicRemove(otherEnd, msgs);
                case MapPackage.CONNECT__DIAGRAM:
                    return eBasicSetContainer(null, MapPackage.CONNECT__DIAGRAM, msgs);
                case MapPackage.CONNECT__CONT_REF:
                    return basicSetContRef(null, msgs);
                case MapPackage.CONNECT__SUCC:
                    return ((InternalEList)getSucc()).basicRemove(otherEnd, msgs);
                case MapPackage.CONNECT__PRED:
                    return ((InternalEList)getPred()).basicRemove(otherEnd, msgs);
                case MapPackage.CONNECT__LABEL:
                    return basicSetLabel(null, msgs);
                default:
                    return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
            }
        }
        return eBasicSetContainer(null, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
        if (eContainerFeatureID >= 0) {
            switch (eContainerFeatureID) {
                case MapPackage.CONNECT__DIAGRAM:
                    return eContainer.eInverseRemove(this, UrncorePackage.IURN_DIAGRAM__NODES, IURNDiagram.class, msgs);
                default:
                    return eDynamicBasicRemoveFromContainer(msgs);
            }
        }
        return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case MapPackage.CONNECT__FROM_LINKS:
                return getFromLinks();
            case MapPackage.CONNECT__TO_LINKS:
                return getToLinks();
            case MapPackage.CONNECT__ID:
                return getId();
            case MapPackage.CONNECT__NAME:
                return getName();
            case MapPackage.CONNECT__DESCRIPTION:
                return getDescription();
            case MapPackage.CONNECT__X:
                return new Integer(getX());
            case MapPackage.CONNECT__Y:
                return new Integer(getY());
            case MapPackage.CONNECT__DIAGRAM:
                return getDiagram();
            case MapPackage.CONNECT__CONT_REF:
                if (resolve) return getContRef();
                return basicGetContRef();
            case MapPackage.CONNECT__SUCC:
                return getSucc();
            case MapPackage.CONNECT__PRED:
                return getPred();
            case MapPackage.CONNECT__LABEL:
                return getLabel();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case MapPackage.CONNECT__FROM_LINKS:
                getFromLinks().clear();
                getFromLinks().addAll((Collection)newValue);
                return;
            case MapPackage.CONNECT__TO_LINKS:
                getToLinks().clear();
                getToLinks().addAll((Collection)newValue);
                return;
            case MapPackage.CONNECT__ID:
                setId((String)newValue);
                return;
            case MapPackage.CONNECT__NAME:
                setName((String)newValue);
                return;
            case MapPackage.CONNECT__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case MapPackage.CONNECT__X:
                setX(((Integer)newValue).intValue());
                return;
            case MapPackage.CONNECT__Y:
                setY(((Integer)newValue).intValue());
                return;
            case MapPackage.CONNECT__DIAGRAM:
                setDiagram((IURNDiagram)newValue);
                return;
            case MapPackage.CONNECT__CONT_REF:
                setContRef((IURNContainerRef)newValue);
                return;
            case MapPackage.CONNECT__SUCC:
                getSucc().clear();
                getSucc().addAll((Collection)newValue);
                return;
            case MapPackage.CONNECT__PRED:
                getPred().clear();
                getPred().addAll((Collection)newValue);
                return;
            case MapPackage.CONNECT__LABEL:
                setLabel((NodeLabel)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case MapPackage.CONNECT__FROM_LINKS:
                getFromLinks().clear();
                return;
            case MapPackage.CONNECT__TO_LINKS:
                getToLinks().clear();
                return;
            case MapPackage.CONNECT__ID:
                setId(ID_EDEFAULT);
                return;
            case MapPackage.CONNECT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case MapPackage.CONNECT__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case MapPackage.CONNECT__X:
                setX(X_EDEFAULT);
                return;
            case MapPackage.CONNECT__Y:
                setY(Y_EDEFAULT);
                return;
            case MapPackage.CONNECT__DIAGRAM:
                setDiagram((IURNDiagram)null);
                return;
            case MapPackage.CONNECT__CONT_REF:
                setContRef((IURNContainerRef)null);
                return;
            case MapPackage.CONNECT__SUCC:
                getSucc().clear();
                return;
            case MapPackage.CONNECT__PRED:
                getPred().clear();
                return;
            case MapPackage.CONNECT__LABEL:
                setLabel((NodeLabel)null);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case MapPackage.CONNECT__FROM_LINKS:
                return fromLinks != null && !fromLinks.isEmpty();
            case MapPackage.CONNECT__TO_LINKS:
                return toLinks != null && !toLinks.isEmpty();
            case MapPackage.CONNECT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case MapPackage.CONNECT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case MapPackage.CONNECT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case MapPackage.CONNECT__X:
                return x != X_EDEFAULT;
            case MapPackage.CONNECT__Y:
                return y != Y_EDEFAULT;
            case MapPackage.CONNECT__DIAGRAM:
                return getDiagram() != null;
            case MapPackage.CONNECT__CONT_REF:
                return contRef != null;
            case MapPackage.CONNECT__SUCC:
                return succ != null && !succ.isEmpty();
            case MapPackage.CONNECT__PRED:
                return pred != null && !pred.isEmpty();
            case MapPackage.CONNECT__LABEL:
                return label != null;
        }
        return eDynamicIsSet(eFeature);
    }

} //ConnectImpl
