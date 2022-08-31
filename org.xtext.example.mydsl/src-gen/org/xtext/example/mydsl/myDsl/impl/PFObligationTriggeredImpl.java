/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.ObligationWrapper;
import org.xtext.example.mydsl.myDsl.PFObligationTriggered;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PF Obligation Triggered</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.PFObligationTriggeredImpl#getNorm <em>Norm</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PFObligationTriggeredImpl extends PowerFunctionImpl implements PFObligationTriggered
{
  /**
   * The cached value of the '{@link #getNorm() <em>Norm</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNorm()
   * @generated
   * @ordered
   */
  protected ObligationWrapper norm;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PFObligationTriggeredImpl()
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
    return MyDslPackage.Literals.PF_OBLIGATION_TRIGGERED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ObligationWrapper getNorm()
  {
    if (norm != null && norm.eIsProxy())
    {
      InternalEObject oldNorm = (InternalEObject)norm;
      norm = (ObligationWrapper)eResolveProxy(oldNorm);
      if (norm != oldNorm)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyDslPackage.PF_OBLIGATION_TRIGGERED__NORM, oldNorm, norm));
      }
    }
    return norm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObligationWrapper basicGetNorm()
  {
    return norm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNorm(ObligationWrapper newNorm)
  {
    ObligationWrapper oldNorm = norm;
    norm = newNorm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.PF_OBLIGATION_TRIGGERED__NORM, oldNorm, norm));
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
      case MyDslPackage.PF_OBLIGATION_TRIGGERED__NORM:
        if (resolve) return getNorm();
        return basicGetNorm();
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
      case MyDslPackage.PF_OBLIGATION_TRIGGERED__NORM:
        setNorm((ObligationWrapper)newValue);
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
      case MyDslPackage.PF_OBLIGATION_TRIGGERED__NORM:
        setNorm((ObligationWrapper)null);
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
      case MyDslPackage.PF_OBLIGATION_TRIGGERED__NORM:
        return norm != null;
    }
    return super.eIsSet(featureID);
  }

} //PFObligationTriggeredImpl
