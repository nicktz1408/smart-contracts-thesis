package org.xtext.example.mydsl.generator;

import org.xtext.example.mydsl.myDsl.BaseEntity;

class ContractData {
	String contractName;
	BaseEntity entity;
	
	public ContractData(String contractName, BaseEntity entity) {
		this.contractName = contractName;
		this.entity = entity;
	}
	
	public String getContractName() {
		return this.contractName;
	}
	
	public BaseEntity getEntity() {
		return this.entity;
	}
}
