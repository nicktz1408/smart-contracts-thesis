/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAtom Recursive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.PAtomRecursive#getInner <em>Inner</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomRecursive()
 * @model
 * @generated
 */
public interface PAtomRecursive extends Proposition
{
  /**
   * Returns the value of the '<em><b>Inner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inner</em>' containment reference.
   * @see #setInner(Proposition)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getPAtomRecursive_Inner()
   * @model containment="true"
   * @generated
   */
  Proposition getInner();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.PAtomRecursive#getInner <em>Inner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inner</em>' containment reference.
   * @see #getInner()
   * @generated
   */
  void setInner(Proposition value);

} // PAtomRecursive
