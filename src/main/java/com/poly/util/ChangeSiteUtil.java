package com.poly.util;

public class ChangeSiteUtil {
	public static int getSite(int oldSite){
		int newSite = 1;
		switch (oldSite) {
		case 2:
			newSite = 12;
			break;
		case 3:
			newSite = 2;
			break;
		case 4:
			newSite = 7;
			break;
		case 5:
			newSite = 11;
			break;
		case 6:
			newSite = 3;
			break;
		case 7:
			newSite = 9;
			break;
		case 9:
			newSite = 5;
			break;
		case 10:
			newSite = 6;
			break;
		case 11:
			newSite = 10;
			break;
		case 12:
			newSite = 4;
			break;	
		
		default:
			newSite = oldSite;
			break;
		}
		return newSite;
	}

}
