package com.miles.gson.filter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * gson转换的过滤器：只转换被设置的属性列表
 * @author miles
 *
 */
public class GsonInclusion implements ExclusionStrategy {
	private List<String>	inclusionFields;//要被转换的属性名称集合

	/**
	 * 添加只需要被转换的属性名称
	 * 
	 * @param fieldName 属性名称的可变数组
	 * @return
	 */
	public GsonInclusion addInclusionFields(String... fieldName) {
		if (inclusionFields == null) {
			inclusionFields = new ArrayList<String>();
		}
		if (fieldName != null && fieldName.length > 0) {
			for (int i = 0; i < fieldName.length; i++) {
				inclusionFields.add(fieldName[i]);
			}
		}
		return this;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		String fieldName = f.getName();
		if (inclusionFields.contains(fieldName)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// FIXME Auto-generated method stub
		return false;
	}

	public List<String> getinclusionFields() {
		return inclusionFields;
	}

	public void setinclusionFields(List<String> inclusionFields) {
		this.inclusionFields = inclusionFields;
	}

}
