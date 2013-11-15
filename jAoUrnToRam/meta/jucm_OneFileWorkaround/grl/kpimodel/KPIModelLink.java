/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jucm_OneFileWorkaround.grl.kpimodel;

import jucm_OneFileWorkaround.grl.GRLspec;

import jucm_OneFileWorkaround.urncore.GRLmodelElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KPI Model Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getKpiInformationElementSrc <em>Kpi Information Element Src</em>}</li>
 *   <li>{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getRefs <em>Refs</em>}</li>
 *   <li>{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getGrlspec <em>Grlspec</em>}</li>
 *   <li>{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getIndDest <em>Ind Dest</em>}</li>
 * </ul>
 * </p>
 *
 * @see jucm_OneFileWorkaround.grl.kpimodel.KpimodelPackage#getKPIModelLink()
 * @model
 * @generated
 */
public interface KPIModelLink extends GRLmodelElement {
	/**
	 * Returns the value of the '<em><b>Kpi Information Element Src</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link jucm_OneFileWorkaround.grl.kpimodel.KPIInformationElement#getKpiModelLinksSrc <em>Kpi Model Links Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kpi Information Element Src</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kpi Information Element Src</em>' reference.
	 * @see #setKpiInformationElementSrc(KPIInformationElement)
	 * @see jucm_OneFileWorkaround.grl.kpimodel.KpimodelPackage#getKPIModelLink_KpiInformationElementSrc()
	 * @see jucm_OneFileWorkaround.grl.kpimodel.KPIInformationElement#getKpiModelLinksSrc
	 * @model opposite="kpiModelLinksSrc" required="true"
	 * @generated
	 */
	KPIInformationElement getKpiInformationElementSrc();

	/**
	 * Sets the value of the '{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getKpiInformationElementSrc <em>Kpi Information Element Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kpi Information Element Src</em>' reference.
	 * @see #getKpiInformationElementSrc()
	 * @generated
	 */
	void setKpiInformationElementSrc(KPIInformationElement value);

	/**
	 * Returns the value of the '<em><b>Refs</b></em>' reference list.
	 * The list contents are of type {@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLinkRef}.
	 * It is bidirectional and its opposite is '{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLinkRef#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs</em>' reference list.
	 * @see jucm_OneFileWorkaround.grl.kpimodel.KpimodelPackage#getKPIModelLink_Refs()
	 * @see jucm_OneFileWorkaround.grl.kpimodel.KPIModelLinkRef#getLink
	 * @model opposite="link"
	 * @generated
	 */
	EList<KPIModelLinkRef> getRefs();

	/**
	 * Returns the value of the '<em><b>Grlspec</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link jucm_OneFileWorkaround.grl.GRLspec#getKpiModelLinks <em>Kpi Model Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grlspec</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grlspec</em>' container reference.
	 * @see #setGrlspec(GRLspec)
	 * @see jucm_OneFileWorkaround.grl.kpimodel.KpimodelPackage#getKPIModelLink_Grlspec()
	 * @see jucm_OneFileWorkaround.grl.GRLspec#getKpiModelLinks
	 * @model opposite="kpiModelLinks" required="true"
	 * @generated
	 */
	GRLspec getGrlspec();

	/**
	 * Sets the value of the '{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getGrlspec <em>Grlspec</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grlspec</em>' container reference.
	 * @see #getGrlspec()
	 * @generated
	 */
	void setGrlspec(GRLspec value);

	/**
	 * Returns the value of the '<em><b>Ind Dest</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link jucm_OneFileWorkaround.grl.kpimodel.Indicator#getKpiModelLinksDest <em>Kpi Model Links Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ind Dest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ind Dest</em>' reference.
	 * @see #setIndDest(Indicator)
	 * @see jucm_OneFileWorkaround.grl.kpimodel.KpimodelPackage#getKPIModelLink_IndDest()
	 * @see jucm_OneFileWorkaround.grl.kpimodel.Indicator#getKpiModelLinksDest
	 * @model opposite="kpiModelLinksDest" required="true"
	 * @generated
	 */
	Indicator getIndDest();

	/**
	 * Sets the value of the '{@link jucm_OneFileWorkaround.grl.kpimodel.KPIModelLink#getIndDest <em>Ind Dest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ind Dest</em>' reference.
	 * @see #getIndDest()
	 * @generated
	 */
	void setIndDest(Indicator value);

} // KPIModelLink
