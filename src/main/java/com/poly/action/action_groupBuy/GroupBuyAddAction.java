package com.poly.action.action_groupBuy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;
import car_beans.TbApplyInfo;

import com.poly.action.MyActionSupport;
import com.poly.service.AppInfoService;
import com.poly.service.SaleFavoredService;

public class GroupBuyAddAction extends MyActionSupport{
	private TbApplyInfo tbApplyInfo ;
	public void addGroupBuy() throws Exception{
		TbApplyInfo tbInfo = new TbApplyInfo();
		tbInfo.setName(tbApplyInfo.getName());
		tbInfo.setPhone(tbApplyInfo.getPhone());
		tbInfo.setType(tbApplyInfo.getType());
		tbInfo.setProv(tbApplyInfo.getProv());
		tbInfo.setCity(tbApplyInfo.getCity());
		tbInfo.setModelid(tbApplyInfo.getModelid());
		tbInfo.setIssendsms(1);
		tbInfo.setAppdate(new Date());
		System.err.println(tbApplyInfo);
		int result = -1;
		result = AppInfoService.getInstance().addGroupBuy(tbInfo);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}
	public TbApplyInfo getTbApplyInfo() {
		return tbApplyInfo;
	}
	public void setTbApplyInfo(TbApplyInfo tbApplyInfo) {
		this.tbApplyInfo = tbApplyInfo;
	}
}
