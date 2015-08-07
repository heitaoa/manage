package com.redis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import redis.clients.jedis.Jedis;


public class RedisParseUtil {

	// insert#tb_manager#id#
	// id=3,name=admin,password=123456,level=1,agency_id=1#

	// "0006insert0010tb_manager0002id0087 0009agency_id=000110002id=000130005level=000110004name=0005admin0008password=0006123456"

	// ����һ��str���ض�Ӧ��redis string
	public static String formatData(String str) {
		return String.format("%04d", str.length()) + str;
	}

	//
	public static String formatData(String k, String v) {
		return formatData(k) + "=" + formatData(v);
	}

	public static String addData(String str, String add) {
		return str + formatData(add);
	}

	// ����������������
	public static String formatBaseData(Object obj) {
		if (obj instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = (Date) obj;
			return formatData(sdf.format(date));
		}
		return formatData(String.valueOf(obj));
	}

	// ����bean�����redis str
	public static String formatData(Object bean) {
		StringBuffer sb = new StringBuffer();
		String[] fieldNames = getFiledName(bean);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = getFieldValueByName(fieldNames[i], bean);
			sb.append(formatData(fieldNames[i]));
			sb.append("=");
			sb.append(formatBaseData(value[i]));
		}
		String sbStr = sb.toString();
		return formatData(sbStr);
	}

	// std::string scDataMgr::GetStr()
	// {
	// return m_data;
	// }

	public static void main(String[] args) {

		String k = "agency_id";
		String v = "1";

//		Manager m = new Manager();
//		m.setId(1);
//		m.setName("sdsss");
//
//		System.out.println(System.currentTimeMillis() + "-------->" + formatData(m));
	}

	// ��redis��ȡ�������ݽ�����List
	public static List<String> Parse(String str) {
		List<String> list = new ArrayList<String>();
		int idx = 0;
		while (idx + 4 < str.length()) {
			String tmp = str.substring(idx, idx + 4);
			int len = Integer.valueOf(tmp);
			if (len < 0) {
				break;
			}
			if (idx + 4 + len > str.length()) {
				break;
			}
			String value = str.substring(idx + 4, idx + 4 + len);
			list.add(value);
			idx = idx + 4 + len;
		}
		return list;
	}

	//
	// bool scDataMgr::Parse(std::string &vl,std::vector<std::string> &vct)
	// {
	// int idx = 0;
	// while (idx + 4 < vl.length())
	// {
	// std::string tmp = vl.substr(idx,4);
	// int len = atoi(tmp.c_str());
	// if (len <= 0)
	// {
	// break;
	// }
	// if (idx + 4 + len > vl.length())
	// {
	// break;
	// }
	// std::string tmpvl = vl.substr(idx + 4,len);
	// vct.push_back(tmpvl);
	// idx = idx + 4 + len;
	// }
	// return true;
	// }

	/**
	 * ������������ȡ����ֵ
	 * */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			// log.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * ��ȡ����������
	 * */
	private static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
//			System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/**
	 * 
	 * 
	 */
	public static void jedisPublish(String fun,String chart,String id) {
		String funLength="";
		if(fun.length()>0&&fun.length()<10){
			funLength="000"+fun.length();
		}else if(fun.length()>9&& fun.length()<100){
			funLength="00"+fun.length();
		}else if(fun.length()>99&& fun.length()<1000){
			funLength="0"+fun.length();
		}else{
			funLength=String.valueOf(fun.length());
		}
		String chartLength="";
		if(chart.length()>0&&chart.length()<10){
			chartLength="000"+chart.length();
		}else if(chart.length()>9&& chart.length()<100){
			chartLength="00"+chart.length();
		}else if(chart.length()>99&& chart.length()<1000){
			chartLength="0"+chart.length();
		}else{
			chartLength=String.valueOf(chart.length());
		}
		String idLength="";
		if(id.length()>0&&id.length()<10){
			idLength="000"+id.length();
		}else if(id.length()>9&& id.length()<100){
			idLength="00"+id.length();
		}else if(id.length()>99&& id.length()<1000){
			idLength="0"+id.length();
		}else{
			idLength=String.valueOf(id.length());
		}
		Jedis jedis=RedisManager.getJedisObject();
		jedis.publish("key_queue_event", funLength+fun+chartLength+chart+idLength+id);
		RedisManager.recycleJedisOjbect(jedis);
	}
}
