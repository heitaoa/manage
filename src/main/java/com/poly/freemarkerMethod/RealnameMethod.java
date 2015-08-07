package com.poly.freemarkerMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.redis.Redis2Dao;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class RealnameMethod implements TemplateMethodModel {

	@Override
	public Object exec(List args) {
		String realname = "";
		try {
			if (args.size() < 1) {

				throw new TemplateModelException(">>> >>> Wrong arguments");
			}
			String username = (String) args.get(0);
			if (username == null || username.length() < 2)
				return null;
			//System.out.println("username----------->" + username);

			Map<String, String> map = Redis2Dao.getAllEditorByUsername(username);

			//System.out.println("map.size());----------->" + map.size());

//			for (Entry ent : map.entrySet()) {
//				System.out.println(ent.getKey() + "<>" + ent.getValue());
//			}

			if (map==null || map.isEmpty()) {
				//System.out.println("map.isEmpty()==========");
				return username;
			} else {
				//System.out.println("map.isEmpty()=====no=====");
			}
			realname = map.get("realname");
			//System.out.println("realname------>>" + realname);
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return realname;
	}

	public static void main(String[] args) {
		List llll = new ArrayList();
		llll.add("sunyongle");
		
		new RealnameMethod().exec(llll);
	}

}
