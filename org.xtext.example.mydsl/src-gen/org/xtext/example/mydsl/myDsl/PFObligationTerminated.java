/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PF Obligation Terminated</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PFObligationTerminated#getNorm <em>Norm</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPFObligationTerminated()
 * @model
 * @generated
 */
public interface PFObligationTerminated extends PowerFunction
{
  /**
   * Returns the value of the '<em><b>Norm</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Norm</em>' reference.
   * @see #setNorm(ObligationWrapper)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPFObligationTerminated_Norm()
   * @model
   * @generated
   */
  ObligationWrapper getNorm();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PFObligationTerminated#getNorm <em>Norm</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Norm</em>' reference.
   * @see #getNorm()
   * @generated
   */
  void setNorm(ObligationWrapper value);

} // PFObligationTerminated