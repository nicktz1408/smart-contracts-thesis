/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.ObligationState;
import org.xtext.example.mydsl.myDsl.ObligationWrapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Obligation State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ObligationStateImpl#getObligationVariable <em>Obligation Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObligationStateImpl extends SituationImpl implements ObligationState
{
  /**
   * The cached value of the '{@link #getObligationVariable() <em>Obligation Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObligationVariable()
   * @generated
   * @ordered
   */
  protected ObligationWrapper obligationVariable;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObligationStateImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.OBLIGATION_STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ObligationWrapper getObligationVariable()
  {
    if (obligationVariable != null && obligationVariable.eIsProxy())
    {
      InternalEObject oldObligationVariable = (InternalEObject)obligationVariable;
      obligationVariable = (ObligationWrapper)eResolveProxy(oldObligationVariable);
      if (obligationVariable != oldObligationVariable)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyDslPackage.OBLIGATION_STATE__OBLIGATION_VARIABLE, oldObligationVariable, obligationVariable));
      }
    }
    return obligationVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObligationWrapper basicGetObligationVariable()
  {
    return obligationVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setObligationVariable(ObligationWrapper newObligationVariable)
  {
    ObligationWrapper oldObligationVariable = obligationVariable;
    obligationVariable = newObligationVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.OBLIGATION_STATE__OBLIGATION_VARIABLE, oldObligationVariable, obligationVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.OBLIGATION_STATE__OBLIGATION_VARIABLE:
        if (resolve) return getObligationVariable();
        return basicGetObligationVariable();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.OBLIGATION_STATE__OBLIGATION_VARIABLE:
        setObligationVariable((ObligationWrapper)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.OBLIGATION_STATE__OBLIGATION_VARIABLE:
        setObligationVariable((ObligationWrapper)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.OBLIGATION_STATE__OBLIGATION_VARIABLE:
        return obligationVariable != null;
    }
    return super.eIsSet(featureID);
  }

} //ObligationStateImpl
