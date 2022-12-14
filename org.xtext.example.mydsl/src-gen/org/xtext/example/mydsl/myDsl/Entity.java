/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Entity#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Entity#getIdVariable <em>Id Variable</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Entity#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends BaseEntity
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(EntityType)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getEntity_Type()
   * @model containment="true"
   * @generated
   */
  EntityType getType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Entity#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(EntityType value);

  /**
   * Returns the value of the '<em><b>Id Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id Variable</em>' reference.
   * @see #setIdVariable(Variable)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getEntity_IdVariable()
   * @model
   * @generated
   */
  Variable getIdVariable();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Entity#getIdVariable <em>Id Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id Variable</em>' reference.
   * @see #getIdVariable()
   * @generated
   */
  void setIdVariable(Variable value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.Variable}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getEntity_Variables()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getVariables();

} // Entity
