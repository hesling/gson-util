package com.miles.gson.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miles.gson.filter.GsonExclusion;
import com.miles.gson.filter.GsonInclusion;

/**
 * gson的工具类
 * @author miles
 *
 */
public class GsonUtil {
	/**
	 * 将一个对象转成json字符串并指定需要排除的属性名称列表
	 * 如果没有指定属性名称集合，则将会全部转换
	 * 默认时间会以yyyy-MM-dd HH:mm:ss的格式进行转换
	 * @param obj
	 * @return
	 */
	public static String toJsonExclude(Object obj,String ... exclusionFields){
		
		//创建GsonBuilder
		GsonBuilder builder=new GsonBuilder();
		
		//设置时间格式
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//设置需要被排除的属性列表
		if(exclusionFields!=null && exclusionFields.length>0){
			GsonExclusion gsonFilter=new GsonExclusion();
			gsonFilter.addExclusionField(exclusionFields);
			builder.setExclusionStrategies(gsonFilter);
		}
		
		//创建Gson并进行转换
		Gson gson=builder.create();
		return gson.toJson(obj);
	}
	/**
	 * 将一个对象转成json字符串并指定需要需要转换的属性名称列表
	 * 如果没有指定属性名称集合，则将会全部转换
	 * 默认时间会以yyyy-MM-dd HH:mm:ss的格式进行转换
	 * @param obj
	 * @return
	 */
	public static String toJsonInclude(Object obj,String ... includeFields){
		//创建GsonBuilder
		GsonBuilder builder=new GsonBuilder();
		
		//设置时间格式
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//设置需要转换的属性名称
		if(includeFields!=null && includeFields.length>0){
			GsonInclusion gsonFilter=new GsonInclusion();
			gsonFilter.addInclusionFields(includeFields);
			builder.setExclusionStrategies(gsonFilter);
		}
		
		//创建Gson并进行转换
		Gson gson=builder.create();
		return gson.toJson(obj);
	}
}
