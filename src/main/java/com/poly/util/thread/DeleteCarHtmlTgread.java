package com.poly.util.thread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import car_daos.DboDelForIdFileDao;
import cdn.MyCdnUtil;

import com.poly.service.NewsAdmService;
import com.poly.service.ImageNotService.carImg;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.DeleteCarParamFileUtil;

public class DeleteCarHtmlTgread extends Thread{
	
	private String englishname;
	private int id;

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DeleteCarHtmlTgread(String englishname,int id) {
		this.englishname = englishname;
		this.id=id;
	}
	
	public void run() {
		synchronized (DeleteCarHtmlTgread.class) {
			
			try {
				NewsAdmService.delNewsHtmlByCarcatalogid(id);
				DeleteCarParamFileUtil.RemoveFileByCarParam("auto/index.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("auto/model/brand/");
				DeleteCarParamFileUtil.RemoveFileByCarParam("auto/"+englishname+"/articles*.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("che/"+englishname+"/index.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("che/"+id+".htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("che/"+id+"/");
				DeleteCarParamFileUtil.RemoveFileByCarParam("sun/groupon/gbm_"+englishname+".htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("auto/series/"+englishname+".htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("auto/"+englishname+"/detail*.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("che/model/"+id+"/index.htm");
				//DeleteCarParamFileUtil.RemoveFileByCarParam("price/index_temp.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("price/brand/0-"+id+".htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("price/series/"+id+"-0-0.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("price/gradesearch/");
				DeleteCarParamFileUtil.RemoveFileByCarParam("price/outputsearch/");
				DeleteCarParamFileUtil.RemoveFileByCarParam("price/paramsearch/");
				DeleteCarParamFileUtil.RemoveFileByCarParam("price/pricesearch/");
				//DeleteCarParamFileUtil.RemoveFileByCarParam("sun/index_temp.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("html_dealer/4s/list/"+id+"/");
				//DeleteCarParamFileUtil.RemoveFileByCarParam("tuku/index_temp.htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("tuku/brand/0-"+id+".htm");
				DeleteCarParamFileUtil.RemoveFileByCarParam("tuku/serial/"+id+".htm");
				String[] url1={"http://sun.315che.com/"+englishname+"/","http://auto.315che.com/"+englishname+"/articles.htm","http://che.315che.com/"+englishname+"/","http://che.315che.com/"+id+"/","http://auto.315che.com/"+englishname+"/","http://auto.315che.com/"+englishname+"/detail.htm","http://price.315che.com/brand/0-"+id+".htm","http://price.315che.com/series/"+id+"-0-0.htm","http://pic.315che.com/brand/0-"+id+".htm","http://pic.315che.com/serial/"+id+".htm"};
				MyCdnUtil.flushCdn(url1);
				System.out.println("endDate------------------>"+System.currentTimeMillis());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}  
	
}
