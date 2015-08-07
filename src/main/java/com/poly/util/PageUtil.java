package com.poly.util;

/**
 * mysql 分页工具类
 * @author niuhaidong
 *
 * 2015年5月7日
 */
public class PageUtil {
	/**
	 * 根据总记录数，计算页数（默认每页10条）
	 * @param count
	 * @return
	 */
	public static int calPages(int count) {
		int pages = 1;
		pages = count /10;
		
		if(count % 10 > 0) {
			pages ++;
		}
		if(pages == 0) {
			pages = 1;
		}
		return pages;
	}
	
	/**
	 * 根据第几页，计算mysql limit 的第一个参数开始索引（默认每页10条）
	 * @param count
	 * @return
	 */
	public static int calStartIndex(int page) {
		int startIndex = 0;
		if(page<=0) {
			page = 1;
		}
		return (page-1) * 10 ;
	} 
}
