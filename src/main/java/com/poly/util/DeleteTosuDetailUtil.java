package com.poly.util;

import java.util.List;

import sun.text.normalizer.IntTrie;

import com.poly.sftp.MyRemoteUtil;

public class DeleteTosuDetailUtil {
	public static void deleteOneTousuDetail(String tousuId){
		if(tousuId == null || "".equals(tousuId))
			return;
		String commStr = "rm -rf " + MyConfig.html_che_path + "tousu/tousudetail/" +tousuId+ "/";
		try {
			System.out.println("===tousuDeleteOne cmd :"+commStr);
			MyRemoteUtil.exeCommand(commStr, MyRemoteUtil.www315);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteMutiTousuDetail(List<Integer> list){
		if(list == null || list.size() == 0)
			return;
		String commStr = "";
		for (Integer tousuId : list) {
			commStr += "rm -rf " + MyConfig.html_che_path + "tousu/tousudetail/" +tousuId+ "/" + " \n";
		}
		if("".equals(commStr) || commStr.length() < 5)
			return;
		try {
			System.out.println("===tousuDeleteMuti cmd :"+commStr);
			//MyRemoteUtil.exeCommand(commStr, MyRemoteUtil.www315);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
