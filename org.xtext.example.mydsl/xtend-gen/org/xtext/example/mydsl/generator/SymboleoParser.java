/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.generator;

import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xtext.example.mydsl.myDsl.And;
import org.xtext.example.mydsl.myDsl.AtomicExpressionDate;
import org.xtext.example.mydsl.myDsl.AtomicExpressionDouble;
import org.xtext.example.mydsl.myDsl.AtomicExpressionEnum;
import org.xtext.example.mydsl.myDsl.AtomicExpressionFalse;
import org.xtext.example.mydsl.myDsl.AtomicExpressionInt;
import org.xtext.example.mydsl.myDsl.AtomicExpressionParameter;
import org.xtext.example.mydsl.myDsl.AtomicExpressionString;
import org.xtext.example.mydsl.myDsl.AtomicExpressionTrue;
import org.xtext.example.mydsl.myDsl.Comparison;
import org.xtext.example.mydsl.myDsl.ContractEvent;
import org.xtext.example.mydsl.myDsl.ContractState;
import org.xtext.example.mydsl.myDsl.Div;
import org.xtext.example.mydsl.myDsl.Equality;
import org.xtext.example.mydsl.myDsl.Event;
import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.FunctionCall;
import org.xtext.example.mydsl.myDsl.IntervalExpression;
import org.xtext.example.mydsl.myDsl.IntervalFunction;
import org.xtext.example.mydsl.myDsl.Minus;
import org.xtext.example.mydsl.myDsl.Multi;
import org.xtext.example.mydsl.myDsl.NegatedPAtom;
import org.xtext.example.mydsl.myDsl.NegatedPrimaryExpression;
import org.xtext.example.mydsl.myDsl.ObligationEvent;
import org.xtext.example.mydsl.myDsl.ObligationState;
import org.xtext.example.mydsl.myDsl.OneArgMathFunction;
import org.xtext.example.mydsl.myDsl.OneArgStringFunction;
import org.xtext.example.mydsl.myDsl.Or;
import org.xtext.example.mydsl.myDsl.OtherFunction;
import org.xtext.example.mydsl.myDsl.PAnd;
import org.xtext.example.mydsl.myDsl.PAtomDateLiteral;
import org.xtext.example.mydsl.myDsl.PAtomDoubleLiteral;
import org.xtext.example.mydsl.myDsl.PAtomEnum;
import org.xtext.example.mydsl.myDsl.PAtomFunction;
import org.xtext.example.mydsl.myDsl.PAtomIntLiteral;
import org.xtext.example.mydsl.myDsl.PAtomPredicate;
import org.xtext.example.mydsl.myDsl.PAtomPredicateFalseLiteral;
import org.xtext.example.mydsl.myDsl.PAtomPredicateTrueLiteral;
import org.xtext.example.mydsl.myDsl.PAtomRecursive;
import org.xtext.example.mydsl.myDsl.PAtomStringLiteral;
import org.xtext.example.mydsl.myDsl.PAtomVariable;
import org.xtext.example.mydsl.myDsl.PComparison;
import org.xtext.example.mydsl.myDsl.PEquality;
import org.xtext.example.mydsl.myDsl.PFContractResumed;
import org.xtext.example.mydsl.myDsl.PFContractSuspended;
import org.xtext.example.mydsl.myDsl.PFContractTerminated;
import org.xtext.example.mydsl.myDsl.PFObligationDischarged;
import org.xtext.example.mydsl.myDsl.PFObligationResumed;
import org.xtext.example.mydsl.myDsl.PFObligationSuspended;
import org.xtext.example.mydsl.myDsl.PFObligationTerminated;
import org.xtext.example.mydsl.myDsl.PFObligationTriggered;
import org.xtext.example.mydsl.myDsl.POr;
import org.xtext.example.mydsl.myDsl.Plus;
import org.xtext.example.mydsl.myDsl.PointAtomContractEvent;
import org.xtext.example.mydsl.myDsl.PointAtomObligationEvent;
import org.xtext.example.mydsl.myDsl.PointAtomParameterDotExpression;
import org.xtext.example.mydsl.myDsl.PointAtomPowerEvent;
import org.xtext.example.mydsl.myDsl.PointExpression;
import org.xtext.example.mydsl.myDsl.PointFunction;
import org.xtext.example.mydsl.myDsl.PowerEvent;
import org.xtext.example.mydsl.myDsl.PowerFunction;
import org.xtext.example.mydsl.myDsl.PowerState;
import org.xtext.example.mydsl.myDsl.PredicateFunction;
import org.xtext.example.mydsl.myDsl.PredicateFunctionCannotBeAssigned;
import org.xtext.example.mydsl.myDsl.PredicateFunctionHappens;
import org.xtext.example.mydsl.myDsl.PredicateFunctionHappensAfter;
import org.xtext.example.mydsl.myDsl.PredicateFunctionHappensWithin;
import org.xtext.example.mydsl.myDsl.PredicateFunctionIsEqual;
import org.xtext.example.mydsl.myDsl.PredicateFunctionIsOwner;
import org.xtext.example.mydsl.myDsl.PredicateFunctionOccurs;
import org.xtext.example.mydsl.myDsl.PredicateFunctionSHappensBefore;
import org.xtext.example.mydsl.myDsl.PredicateFunctionSHappensBeforeEvent;
import org.xtext.example.mydsl.myDsl.PredicateFunctionWHappensBefore;
import org.xtext.example.mydsl.myDsl.PredicateFunctionWHappensBeforeEvent;
import org.xtext.example.mydsl.myDsl.PrimaryExpressionFunctionCall;
import org.xtext.example.mydsl.myDsl.PrimaryExpressionRecursive;
import org.xtext.example.mydsl.myDsl.Proposition;
import org.xtext.example.mydsl.myDsl.Ref;
import org.xtext.example.mydsl.myDsl.Situation;
import org.xtext.example.mydsl.myDsl.SituationExpression;
import org.xtext.example.mydsl.myDsl.ThreeArgDateFunction;
import org.xtext.example.mydsl.myDsl.ThreeArgStringFunction;
import org.xtext.example.mydsl.myDsl.Timevalue;
import org.xtext.example.mydsl.myDsl.TimevalueInt;
import org.xtext.example.mydsl.myDsl.TimevalueVariable;
import org.xtext.example.mydsl.myDsl.TwoArgMathFunction;
import org.xtext.example.mydsl.myDsl.TwoArgStringFunction;
import org.xtext.example.mydsl.myDsl.VariableDotExpression;
import org.xtext.example.mydsl.myDsl.VariableEvent;
import org.xtext.example.mydsl.myDsl.VariableRef;

@SuppressWarnings("all")
public class SymboleoParser {
  public Object SymboleoParser() {
    return null;
  }

  public boolean sanitizeDotExpressionString(final ArrayList<String> ids) {
    return ids.remove("request");
  }

  public String generateDotExpressionString(final Ref argRef, final String thisString) {
    final ArrayList<String> ids = new ArrayList<String>();
    Ref ref = argRef;
    while ((ref instanceof VariableDotExpression)) {
      {
        ids.add(((VariableDotExpression) ref).getTail());
        ref = ((VariableDotExpression) ref).getRef();
      }
    }
    if ((ref instanceof VariableRef)) {
      ids.add(((VariableRef) ref).getVariable());
    }
    ids.add(thisString);
    this.sanitizeDotExpressionString(ids);
    for (final String id : ids) {
      {
        System.out.println(id);
        if ((id == "request")) {
          ids.remove(id);
        }
      }
    }
    return IterableExtensions.join(ListExtensions.<String>reverse(ids), ".").substring(1);
  }

  public String generateEventVariableString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      return this.generateDotExpressionString(((VariableEvent)event).getVariable(), "");
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _eventName = ((PowerEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append("(powers.");
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _eventName = ((ObligationEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append("(obligations.");
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _eventName = ((ContractEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append("(self)");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateTimeValueString(final Timevalue tv) {
    boolean _matched = false;
    if (tv instanceof TimevalueInt) {
      _matched=true;
      return Integer.valueOf(((TimevalueInt)tv).getValue()).toString();
    }
    if (!_matched) {
      if (tv instanceof TimevalueVariable) {
        _matched=true;
        return this.generateDotExpressionString(((TimevalueVariable)tv).getVariable(), "");
      }
    }
    return null;
  }

  public String generatePointExpresionString(final PointExpression point) {
    boolean _matched = false;
    if (point instanceof PointFunction) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _name = ((PointFunction)point).getName();
      _builder.append(_name);
      _builder.append("(");
      String _generatePointExpresionString = this.generatePointExpresionString(((PointFunction)point).getArg());
      _builder.append(_generatePointExpresionString);
      _builder.append(", ");
      String _generateTimeValueString = this.generateTimeValueString(((PointFunction)point).getValue());
      _builder.append(_generateTimeValueString);
      _builder.append(", ");
      String _timeUnit = ((PointFunction)point).getTimeUnit();
      _builder.append(_timeUnit);
      _builder.append(")");
      return _builder.toString();
    }
    if (!_matched) {
      if (point instanceof PointAtomParameterDotExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateDotExpressionString = this.generateDotExpressionString(((PointAtomParameterDotExpression)point).getVariable(), "");
        _builder.append(_generateDotExpressionString);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomObligationEvent) {
        _matched=true;
        Event _obligationEvent = ((PointAtomObligationEvent)point).getObligationEvent();
        final ObligationEvent e = ((ObligationEvent) _obligationEvent);
        StringConcatenation _builder = new StringConcatenation();
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append("(obligations.");
        String _name = e.getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomContractEvent) {
        _matched=true;
        Event _contractEvent = ((PointAtomContractEvent)point).getContractEvent();
        final ContractEvent e = ((ContractEvent) _contractEvent);
        StringConcatenation _builder = new StringConcatenation();
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append("(self)");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomPowerEvent) {
        _matched=true;
        Event _powerEvent = ((PointAtomPowerEvent)point).getPowerEvent();
        final PowerEvent e = ((PowerEvent) _powerEvent);
        StringConcatenation _builder = new StringConcatenation();
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append("(powers.");
        String _name = e.getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateIntervalExpresionArgString(final IntervalExpression interval) {
    String _switchResult = null;
    boolean _matched = false;
    if (interval instanceof IntervalFunction) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Interval(");
      String _generatePointExpresionString = this.generatePointExpresionString(((IntervalFunction)interval).getArg1());
      _builder.append(_generatePointExpresionString);
      _builder.append(", ");
      String _generatePointExpresionString_1 = this.generatePointExpresionString(((IntervalFunction)interval).getArg2());
      _builder.append(_generatePointExpresionString_1);
      _builder.append(")");
      return _builder.toString();
    }
    if (!_matched) {
      if (interval instanceof SituationExpression) {
        _matched=true;
        _switchResult = this.generateSituation(((SituationExpression)interval).getSituation());
      }
    }
    return _switchResult;
  }

  public String generateSituation(final Situation situation) {
    boolean _matched = false;
    if (situation instanceof ObligationState) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _stateName = ((ObligationState)situation).getStateName();
      _builder.append(_stateName);
      _builder.append("(obligations.");
      String _name = ((ObligationState)situation).getObligationVariable().getName();
      _builder.append(_name);
      _builder.append(")");
      return _builder.toString();
    }
    if (!_matched) {
      if (situation instanceof PowerState) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _stateName = ((PowerState)situation).getStateName();
        _builder.append(_stateName);
        _builder.append("(powers.");
        String _name = ((PowerState)situation).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (situation instanceof ContractState) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _stateName = ((ContractState)situation).getStateName();
        _builder.append(_stateName);
        _builder.append("(self)");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generatePredicateFunctionString(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Happens(");
      String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
      _builder.append(_generateEventVariableString);
      _builder.append(")");
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("WhappensBefore(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionWHappensBefore)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("ShappensBefore(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionSHappensBefore)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("HappensWithin(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generateIntervalExpresionArgString = this.generateIntervalExpresionArgString(((PredicateFunctionHappensWithin)predicate).getInterval().getIntervalExpression());
        _builder.append(_generateIntervalExpresionArgString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBeforeEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("WhappensBeforeE(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)predicate).getEvent1());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generateEventVariableString_1 = this.generateEventVariableString(((PredicateFunctionWHappensBeforeEvent)predicate).getEvent2());
        _builder.append(_generateEventVariableString_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBeforeEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("ShappensBeforeE(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBeforeEvent)predicate).getEvent1());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generateEventVariableString_1 = this.generateEventVariableString(((PredicateFunctionSHappensBeforeEvent)predicate).getEvent2());
        _builder.append(_generateEventVariableString_1);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("HappensAfter(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionHappensAfter)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionOccurs) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Occurs(");
        String _generateSituation = this.generateSituation(((PredicateFunctionOccurs)predicate).getSituation());
        _builder.append(_generateSituation);
        _builder.append(", ");
        String _generateIntervalExpresionArgString = this.generateIntervalExpresionArgString(((PredicateFunctionOccurs)predicate).getInterval().getIntervalExpression());
        _builder.append(_generateIntervalExpresionArgString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateOtherFunction(final OtherFunction func) {
    boolean _matched = false;
    if (func instanceof PredicateFunctionIsEqual) {
      _matched=true;
      String _arg1 = ((PredicateFunctionIsEqual)func).getArg1();
      String _plus = ("IsEqual(" + _arg1);
      String _plus_1 = (_plus + ", ");
      String _arg2 = ((PredicateFunctionIsEqual)func).getArg2();
      String _plus_2 = (_plus_1 + _arg2);
      return (_plus_2 + ")");
    }
    if (!_matched) {
      if (func instanceof PredicateFunctionIsOwner) {
        _matched=true;
        String _arg1 = ((PredicateFunctionIsOwner)func).getArg1();
        String _plus = ("IsOwner(" + _arg1);
        String _plus_1 = (_plus + ", ");
        String _arg2 = ((PredicateFunctionIsOwner)func).getArg2();
        String _plus_2 = (_plus_1 + _arg2);
        return (_plus_2 + ")");
      }
    }
    if (!_matched) {
      if (func instanceof PredicateFunctionCannotBeAssigned) {
        _matched=true;
        String _arg1 = ((PredicateFunctionCannotBeAssigned)func).getArg1();
        String _plus = ("CannotBeAssigned(" + _arg1);
        return (_plus + ")");
      }
    }
    return null;
  }

  public String generatePropositionString(final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generatePropositionString = this.generatePropositionString(((POr)proposition).getLeft());
      String _plus = (_generatePropositionString + " or ");
      String _generatePropositionString_1 = this.generatePropositionString(((POr)proposition).getRight());
      return (_plus + _generatePropositionString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PAnd)proposition).getLeft());
        String _plus = (_generatePropositionString + " and ");
        String _generatePropositionString_1 = this.generatePropositionString(((PAnd)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PEquality)proposition).getLeft());
        String _op = ((PEquality)proposition).getOp();
        String _plus = (_generatePropositionString + _op);
        String _generatePropositionString_1 = this.generatePropositionString(((PEquality)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PComparison)proposition).getLeft());
        String _op = ((PComparison)proposition).getOp();
        String _plus = (_generatePropositionString + _op);
        String _generatePropositionString_1 = this.generatePropositionString(((PComparison)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PAtomRecursive)proposition).getInner());
        String _plus = ("(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((NegatedPAtom)proposition).getNegated());
        String _plus = ("not(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generatePredicateFunctionString(((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomFunction) {
        _matched=true;
        return this.generateOtherFunction(((PAtomFunction)proposition).getFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomEnum) {
        _matched=true;
        String _enumeration = ((PAtomEnum)proposition).getEnumeration();
        String _plus = (_enumeration + "(");
        String _enumItem = ((PAtomEnum)proposition).getEnumItem();
        String _plus_1 = (_plus + _enumItem);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomVariable) {
        _matched=true;
        return this.generateDotExpressionString(((PAtomVariable)proposition).getVariable(), "");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateTrueLiteral) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateFalseLiteral) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDoubleLiteral) {
        _matched=true;
        return Double.valueOf(((PAtomDoubleLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomIntLiteral) {
        _matched=true;
        return Integer.valueOf(((PAtomIntLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDateLiteral) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Date(\"");
        String _string = ((PAtomDateLiteral)proposition).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomStringLiteral) {
        _matched=true;
        return ((PAtomStringLiteral)proposition).getValue();
      }
    }
    return null;
  }

  public String generatePowerAction(final PowerFunction pf) {
    boolean _matched = false;
    if (pf instanceof PFObligationSuspended) {
      _matched=true;
      String _name = ((PFObligationSuspended)pf).getNorm().getName();
      String _plus = ("Suspended(obligations." + _name);
      return (_plus + ")");
    }
    if (!_matched) {
      if (pf instanceof PFObligationResumed) {
        _matched=true;
        String _name = ((PFObligationResumed)pf).getNorm().getName();
        String _plus = ("Resumed(obligations." + _name);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (pf instanceof PFObligationDischarged) {
        _matched=true;
        String _name = ((PFObligationDischarged)pf).getNorm().getName();
        String _plus = ("Discharged(obligations." + _name);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (pf instanceof PFObligationTerminated) {
        _matched=true;
        String _name = ((PFObligationTerminated)pf).getNorm().getName();
        String _plus = ("Terminated(obligations." + _name);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (pf instanceof PFObligationTriggered) {
        _matched=true;
        String _name = ((PFObligationTriggered)pf).getNorm().getName();
        String _plus = ("Triggered(obligations." + _name);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (pf instanceof PFContractSuspended) {
        _matched=true;
        return "Suspended(self)";
      }
    }
    if (!_matched) {
      if (pf instanceof PFContractResumed) {
        _matched=true;
        return "Resumed(self)";
      }
    }
    if (!_matched) {
      if (pf instanceof PFContractTerminated) {
        _matched=true;
        return "Terminated(self)";
      }
    }
    return null;
  }

  public String generateFunctionCall(final PrimaryExpressionFunctionCall argFunctionCallExp, final String thisString) {
    final FunctionCall functionCall = argFunctionCallExp.getFunction();
    boolean _matched = false;
    if (functionCall instanceof TwoArgMathFunction) {
      _matched=true;
      String _name = ((TwoArgMathFunction)functionCall).getName();
      String _plus = (_name + "(");
      String _generateExpressionString = this.generateExpressionString(((TwoArgMathFunction)functionCall).getArg1(), thisString);
      String _plus_1 = (_plus + _generateExpressionString);
      String _plus_2 = (_plus_1 + ",");
      String _generateExpressionString_1 = this.generateExpressionString(((TwoArgMathFunction)functionCall).getArg2(), thisString);
      String _plus_3 = (_plus_2 + _generateExpressionString_1);
      return (_plus_3 + ")");
    }
    if (!_matched) {
      if (functionCall instanceof OneArgMathFunction) {
        _matched=true;
        String _name = ((OneArgMathFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgMathFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof ThreeArgStringFunction) {
        _matched=true;
        String _name = ((ThreeArgStringFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        String _plus_2 = (_plus_1 + ",");
        String _generateExpressionString_1 = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg2(), thisString);
        String _plus_3 = (_plus_2 + _generateExpressionString_1);
        String _plus_4 = (_plus_3 + ",");
        String _generateExpressionString_2 = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg3(), thisString);
        String _plus_5 = (_plus_4 + _generateExpressionString_2);
        return (_plus_5 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof TwoArgStringFunction) {
        _matched=true;
        String _name = ((TwoArgStringFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((TwoArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        String _plus_2 = (_plus_1 + ",");
        String _generateExpressionString_1 = this.generateExpressionString(((TwoArgStringFunction)functionCall).getArg2(), thisString);
        String _plus_3 = (_plus_2 + _generateExpressionString_1);
        return (_plus_3 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof OneArgStringFunction) {
        _matched=true;
        String _name = ((OneArgStringFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof ThreeArgDateFunction) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Date.add(");
        String _generateExpressionString = this.generateExpressionString(((ThreeArgDateFunction)functionCall).getArg1(), thisString);
        _builder.append(_generateExpressionString);
        _builder.append(", ");
        String _generateExpressionString_1 = this.generateExpressionString(((ThreeArgDateFunction)functionCall).getValue(), thisString);
        _builder.append(_generateExpressionString_1);
        _builder.append(", ");
        String _timeUnit = ((ThreeArgDateFunction)functionCall).getTimeUnit();
        _builder.append(_timeUnit);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateExpressionString(final Expression argExpression, final String thisString) {
    boolean _matched = false;
    if (argExpression instanceof Or) {
      _matched=true;
      String _generateExpressionString = this.generateExpressionString(((Or)argExpression).getLeft(), thisString);
      String _plus = (_generateExpressionString + " or ");
      String _generateExpressionString_1 = this.generateExpressionString(((Or)argExpression).getRight(), thisString);
      return (_plus + _generateExpressionString_1);
    }
    if (!_matched) {
      if (argExpression instanceof And) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((And)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " and ");
        String _generateExpressionString_1 = this.generateExpressionString(((And)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Equality) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Equality)argExpression).getLeft(), thisString);
        String _op = ((Equality)argExpression).getOp();
        String _plus = (_generateExpressionString + _op);
        String _generateExpressionString_1 = this.generateExpressionString(((Equality)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Comparison) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Comparison)argExpression).getLeft(), thisString);
        String _op = ((Comparison)argExpression).getOp();
        String _plus = (_generateExpressionString + _op);
        String _generateExpressionString_1 = this.generateExpressionString(((Comparison)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Plus) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Plus)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " + ");
        String _generateExpressionString_1 = this.generateExpressionString(((Plus)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Minus) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Minus)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " - ");
        String _generateExpressionString_1 = this.generateExpressionString(((Minus)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Multi) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Multi)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " * ");
        String _generateExpressionString_1 = this.generateExpressionString(((Multi)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Div) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Div)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " / ");
        String _generateExpressionString_1 = this.generateExpressionString(((Div)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof PrimaryExpressionRecursive) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((PrimaryExpressionRecursive)argExpression).getInner(), thisString);
        String _plus = ("(" + _generateExpressionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof PrimaryExpressionFunctionCall) {
        _matched=true;
        return this.generateFunctionCall(((PrimaryExpressionFunctionCall)argExpression), thisString);
      }
    }
    if (!_matched) {
      if (argExpression instanceof NegatedPrimaryExpression) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((NegatedPrimaryExpression)argExpression).getExpression(), thisString);
        String _plus = ("not (" + _generateExpressionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionTrue) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionFalse) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionDouble) {
        _matched=true;
        return Double.valueOf(((AtomicExpressionDouble)argExpression).getValue()).toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionInt) {
        _matched=true;
        return Integer.valueOf(((AtomicExpressionInt)argExpression).getValue()).toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionDate) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Date(\"");
        String _string = ((AtomicExpressionDate)argExpression).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionEnum) {
        _matched=true;
        String _enumeration = ((AtomicExpressionEnum)argExpression).getEnumeration();
        String _plus = (_enumeration + "(");
        String _enumItem = ((AtomicExpressionEnum)argExpression).getEnumItem();
        String _plus_1 = (_plus + _enumItem);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionString) {
        _matched=true;
        String _value = ((AtomicExpressionString)argExpression).getValue();
        String _plus = ("\"" + _value);
        return (_plus + "\"");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionParameter) {
        _matched=true;
        return this.generateDotExpressionString(((AtomicExpressionParameter)argExpression).getValue(), thisString);
      }
    }
    return null;
  }
}