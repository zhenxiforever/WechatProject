package com.bilibala.manage.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.bilibala.manage.dao.po.Result;


public class JsonUtil extends com.bilibala.common.util.JsonUtil {

	
	public static String object2json(Result obj){
		JSONObject json = new JSONObject();
		try {
			customObject2json(json,obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public static void output(HttpServletResponse response,Result rtn){
		try {
			String json = object2json(rtn);
			log.info("回应数据[" + json + "]");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void output(HttpServletResponse response,String json){
		try {
			log.info("回应数据[" + json + "]");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得分页大小
	 * @param json
	 * @return
	 */
	public static int getPageSize(JSONObject json){
		if (json == null){
			return 20;
		}
		else{
			try {
				return json.getInt("page_size");
			} catch (JSONException e) {
				return 20;
			}
		}
	}
	
	/***
	 * 取得分页的页号
	 * @param json
	 * @return
	 * @throws JSONException
	 */
	public static int getPageNumber(JSONObject json){
		if (json == null){
			return 1;
		}
		else{
			try{
				return json.getInt("page_number");
			}
			catch(JSONException ex){
				return 1;
			}
		}
	}
}
