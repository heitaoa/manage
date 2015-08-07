package com.poly.util;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class JsonUtil {

	public static String toJsonString(Object obj) {
		JsonConfig config = new JsonConfig();
		JSONArray jsonArray = JSONArray.fromObject(obj, config);
		return jsonArray.toString();
	}
}
