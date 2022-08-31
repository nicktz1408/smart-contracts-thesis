package org.xtext.example.mydsl.generator;

import java.util.ArrayList;

import org.xtext.example.mydsl.myDsl.BaseEntity;
import org.xtext.example.mydsl.myDsl.Entity;

public class EntityUtils {
	ArrayList <BaseEntity> entities;
	
	public EntityUtils(ArrayList <BaseEntity> entities) {
		this.entities = entities;
	}
	
	public BaseEntity getEntityByName(String entityName) {
		for(int i = 0; i < entities.size(); i++) {
			BaseEntity entity = entities.get(i);
			
			if(entity.getName().equals(entityName)) {
				return entity;
			}
		}
		
		return null;
	}
	
	public boolean removeEntityByName(String entityName) {
		for(int i = 0; i < entities.size(); i++) {
			BaseEntity entity = entities.get(i);
			
			if(entity.getName().equals(entityName)) {
				entities.remove(i);
				return true;
			}
		}
		
		return false;
	}
}
