package com.poly.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具，获取页码list
 * @author cfj
 * 2015年6月4号
 */
public class PageUtilNew {
	
	/**
	 * 获取分页列表
	 * @param ipage  当前页
	 * @param ipages 总页数
	 * @param ipageLength 表格中允许显示的页码长度
	 * @return
	 */
	public static List<String> getPageListNew(int ipage, int ipages, int ipageLength){
		List<String> pList = new ArrayList<String>();
		if (ipages<ipageLength) {
			for (int i = 1; i < ipages + 1; i++) {
				pList.add(String.valueOf(i));
			}
		}else {
			if (ipage<=ipageLength) {
				for (int i = 1; i < ipageLength + 1; i++) {
					pList.add(String.valueOf(i));
				}
			}else if (ipages-ipage>=ipageLength - 1) {
				for (int i = ipage; i < ipage + ipageLength; i++) {
					pList.add(String.valueOf(i));
				}
			}else {
				for (int i = ipages - ipageLength + 1; i < ipages + 1; i++) {
					pList.add(String.valueOf(i));
				}
			}
		}
		return pList;
	}
}
