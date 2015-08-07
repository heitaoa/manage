package com.poly.util;

import java.util.List;

import com.poly.util.MyConfig;
import com.poly.util.UrlChangeUtil;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class ImageFormatMethod implements TemplateMethodModel{

	@Override
	public Object exec(List args) throws TemplateModelException {
		if (args.size() < 3) {
			throw new TemplateModelException("Wrong arguments");
		}
		String path = "";
		String pic = (String) args.get(0);
		if(pic.equals("NULL")||pic.length() == 0){
			return MyConfig.err_img;
		}
		if(pic.startsWith("http")){
			return pic;
		}
		int w = Integer.valueOf((String) args.get(1));
		int h = Integer.valueOf((String) args.get(2));
		path = UrlChangeUtil.FormatCom(pic, w, h);
		return path;
	}

}
