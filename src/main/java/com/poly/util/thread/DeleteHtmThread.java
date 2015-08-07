package com.poly.util.thread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import car_daos.DboDelForIdFileDao;

import com.poly.sftp.MyRemoteUtil;

public class DeleteHtmThread extends Thread {
	private String htmName;
	private int server;
	public String getHtmName() {
		return htmName;
	}

	public void setHtmName(String htmName) {
		this.htmName = htmName;
	}

	public int getServer() {
		return server;
	}

	public void setServer(int server) {
		this.server = server;
	}
	
	public DeleteHtmThread(String htmName) {
		this.htmName = htmName;
	}

	public void run() {
		synchronized (DeleteHtmThread.class) {
			Set<Integer> list = new HashSet<Integer>();
			list = DboDelForIdFileDao.inImgContent(htmName);
			Iterator<Integer> iterList = list.iterator();
			String commStr = "";
			int num = 0;
			server = MyRemoteUtil.www315;
			while(iterList.hasNext()){
				htmName = iterList.next()+"";
				commStr += //"/home/tq/del.sh " +MyRemoteUtil.che_html+" "+ MyRemoteUtil.getFilePath("tuku/index_temp.htm") + " \n"+
						"/home/tq/del.sh " +MyRemoteUtil.che_html+" "+ MyRemoteUtil.getFilePath("tuku/brand/0-"+htmName+".htm") + " \n"+
						"/home/tq/del.sh " +MyRemoteUtil.che_html+" "+ MyRemoteUtil.getFilePath("tuku/carpic/"+htmName+"-*.htm") + " \n"+
						"/home/tq/del.sh " +MyRemoteUtil.che_html+" "+ MyRemoteUtil.getFilePath("tuku/serial/"+htmName+".htm") + " \n"+
						"/home/tq/del.sh " +MyRemoteUtil.che_html+" "+  MyRemoteUtil.getFilePath("tuku/serialtypeimg/*-"+htmName+"-*.htm") + " \n";
				num++;
				if(num==3){
					MyRemoteUtil.exeCommand(commStr, server);
					num=0;
					commStr="";
				}
			}
			if(commStr!=""){
				MyRemoteUtil.exeCommand(commStr, server);
			}
		}
	}  
	
}
