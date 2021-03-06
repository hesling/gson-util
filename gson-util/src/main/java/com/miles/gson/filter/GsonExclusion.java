package com.miles.gson.filter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * gson转换器的过滤器：转换的时候不转换被指定的属性名称
 * @author miles
 *
 */
public class GsonExclusion implements ExclusionStrategy{
	private List<String> exclusionFields;//要被排除的属性名称集合
	
	/**
	 * 添加需要被排除的属性名称
	 * @param fieldName
	 * @return
	 */
	public GsonExclusion addExclusionField(String ... fieldName){
		if(exclusionFields==null){
			exclusionFields=new ArrayList<String>();
		}
		if(fieldName!=null && fieldName.length>0){
			for(int i=0;i<fieldName.length;i++){
				exclusionFields.add(fieldName[i]);
			}
		}
		return this;
	}
	
	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		String fieldName=f.getName();
		if(exclusionFields.contains(fieldName)){
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// FIXME Auto-generated method stub
		return false;
	}

	public List<String> getExclusionFields() {
		return exclusionFields;
	}

	public void setExclusionFields(List<String> exclusionFields) {
		this.exclusionFields = exclusionFields;
	}

}
