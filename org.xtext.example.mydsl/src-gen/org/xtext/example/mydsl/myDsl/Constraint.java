/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Constraint#getContsr <em>Contsr</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends Command
{
  /**
   * Returns the value of the '<em><b>Contsr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contsr</em>' containment reference.
   * @see #setContsr(Proposition)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getConstraint_Contsr()
   * @model containment="true"
   * @generated
   */
  Proposition getContsr();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Constraint#getContsr <em>Contsr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contsr</em>' containment reference.
   * @see #getContsr()
   * @generated
   */
  void setContsr(Proposition value);

} // Constraint
