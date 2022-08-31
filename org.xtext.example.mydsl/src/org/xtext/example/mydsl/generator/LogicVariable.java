package org.xtext.example.mydsl.generator;

import java.util.ArrayList;

import org.xtext.example.mydsl.myDsl.Expression;

public class LogicVariable {
	String variableName;
	String entityName;
	ArrayList<Param> params = new ArrayList<>();

	public LogicVariable(String variableName, String entityName) {
		this.variableName = variableName;
		this.entityName = entityName;
	}
	
	public String getVariableName() {
		return this.variableName;
	}
	
	public String getEntityName() {
		return this.entityName;
	}
	
	public void addParam(String name, Expression value) {
		params.add(new Param(name, value));
	}
	
	public ArrayList<Param> getParams() {
		return this.params;
	}
	
	class Param {
		String name;
		Expression value;
		
		public Param(String name, Expression value) {
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return this.name;
		}
		
		public Expression getValue() {
			return this.value;
		}
	}
}
