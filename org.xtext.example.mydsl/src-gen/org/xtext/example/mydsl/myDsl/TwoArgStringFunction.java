/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Two Arg String Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.TwoArgStringFunction#getArg2 <em>Arg2</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTwoArgStringFunction()
 * @model
 * @generated
 */
public interface TwoArgStringFunction extends FunctionCall
{
  /**
   * Returns the value of the '<em><b>Arg2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg2</em>' containment reference.
   * @see #setArg2(Expression)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getTwoArgStringFunction_Arg2()
   * @model containment="true"
   * @generated
   */
  Expression getArg2();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.TwoArgStringFunction#getArg2 <em>Arg2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg2</em>' containment reference.
   * @see #getArg2()
   * @generated
   */
  void setArg2(Expression value);

} // TwoArgStringFunction
