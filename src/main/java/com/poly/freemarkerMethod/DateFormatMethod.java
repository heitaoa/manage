package com.poly.freemarkerMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class DateFormatMethod implements TemplateMethodModel {

	public static void main(String[] args) {
		String objStr = "2015-02-11&nbsp10:33:33";
		objStr = objStr.replace("&nbsp", " ");
		System.out.println(objStr);
	}

	@Override
	public Object exec(List args) throws TemplateModelException {
		if (args == null || args.size() < 1) {
			return "暂无";
			// throw new TemplateModelException("Wrong arguments number");
		}
		String path = "";
		Object obj = args.get(0);

		String fmt = null;
		if (args.size() > 1)
			fmt = args.get(1) != null ? (String) args.get(1) : null;
		if (fmt == null)
			fmt = "yyyy-MM-dd";

		String flag = null;
		if (args.size() > 2)
			flag = args.get(2) != null ? (String) args.get(2) : null;

		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		String res = "";

		if (obj instanceof String) {
			// System.out.println("String  --> " + obj);
			String objStr = (String) obj;
			objStr = objStr.replace("&nbsp", " ");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if (objStr.length() == 16)
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if (objStr.length() == 19)
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date fdate = format.parse(objStr);
				res = sdf.format(fdate);
				if (flag != null && flag.equals("news"))
					res = res.replaceAll("/0", "/");
				return res;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}

		if (obj instanceof Date) {
			res = sdf.format((Date) obj);
			if (flag != null && flag.equals("news"))
				res = res.replace("/0", "/");
			return res;
		}

		// if(pic == null || pic.equals("NULL")||pic.length() == 0){
		// return MyConfig.err_img;
		// }
		// if(pic.startsWith("http")){
		// return pic;
		// }
		// int w = Integer.valueOf((String) args.get(1));
		// int h = Integer.valueOf((String) args.get(2));
		// path = UrlChangeUtil.FormatCom(pic, w, h);
		return "";
	}
}
