package com.poly.action.action_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.TbDataGift;
import car_beans.TbDataPackage;
import car_beans.TbDataPackgift;
import car_daos.TbDataPackgiftDao;

import com.poly.action.MyActionSupport;
import com.poly.service.ProjectService;

public class GiftAction extends MyActionSupport {
	
	ProjectService projectService = ProjectService.getInstance();
	
	private List<TbDataGift> giftList;
	private int gift_id;
	private String gift_name = "";
	private String gift_price = "";
	
	private List<TbDataPackage> packageList;
	
	private String packgiftStr = "";
	private int package_id;
	private String package_name = "";
	private String package_detail = "";
	private String package_price = "";
	
	private int tab = 0;
	
	public String execute(){
		giftList = projectService.getGiftList();
		packageList = ProjectService.getPackageList();
		return SUCCESS;
	}
	
	public void add() throws Exception{
		TbDataGift tbDataGift = new TbDataGift();
		tbDataGift.setGift_name(gift_name);
		tbDataGift.setGift_price(gift_price);
		
		String result = projectService.addGift(tbDataGift);
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(result);
	}
	
	public void del() throws IOException{
		int result = projectService.delGift(gift_id);
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(result + "");
	}
	
	public void addPackage() throws Exception{
		String result = "1";
		
		TbDataPackage tbDataPackage = new TbDataPackage();
		tbDataPackage.setAddtime(new Date());
		tbDataPackage.setPackage_detail(package_detail);
		tbDataPackage.setPackage_name(package_name);
		tbDataPackage.setPackage_price(package_price);
		package_id = projectService.addPackage(tbDataPackage);
		
		if (package_id==0) {
			result = "礼包名称已经存在，请重新填写！";
		}else if (package_id==-1) {
			result = "提交失败！";
		}else {
			String[] arr = packgiftStr.split("-");
			TbDataPackgift tbDataPackgift = new TbDataPackgift();
			for (int i = 0; i < arr.length; i++) {
				String[] arr2 = arr[i].split("!");
				String[] arr3 = arr2[0].split("_");
				tbDataPackgift.setPackage_id(package_id);
				tbDataPackgift.setGift_id(Integer.parseInt(arr3[0]));
				tbDataPackgift.setGift_num(Integer.parseInt(arr2[1]));
				TbDataPackgiftDao.save(tbDataPackgift);
			}
		}
		
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(result + "");
	}
	
	public void getGift() throws IOException{
		giftList = projectService.getGiftList();
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(giftList);
		out.print(json.toString());
	}
	
	public void delPackage() throws IOException {
		int result = projectService.delPackage(package_id);
		response.setContentType("text/html;charset=gbk");
		response.getWriter().write(result + "");
	}

	public List<TbDataGift> getGiftList() {
		return giftList;
	}

	public void setGiftList(List<TbDataGift> giftList) {
		this.giftList = giftList;
	}
	
	public String getGift_name() {
		return gift_name;
	}

	public void setGift_name(String gift_name) {
		this.gift_name = gift_name;
	}

	public String getGift_price() {
		return gift_price;
	}

	public void setGift_price(String gift_price) {
		this.gift_price = gift_price;
	}

	public int getGift_id() {
		return gift_id;
	}

	public void setGift_id(int gift_id) {
		this.gift_id = gift_id;
	}

	public List<TbDataPackage> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<TbDataPackage> packageList) {
		this.packageList = packageList;
	}

	public String getPackgiftStr() {
		return packgiftStr;
	}

	public void setPackgiftStr(String packgiftStr) {
		this.packgiftStr = packgiftStr;
	}

	public int getPackage_id() {
		return package_id;
	}

	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getPackage_detail() {
		return package_detail;
	}

	public void setPackage_detail(String package_detail) {
		this.package_detail = package_detail;
	}

	public String getPackage_price() {
		return package_price;
	}

	public void setPackage_price(String package_price) {
		this.package_price = package_price;
	}

	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}
	
}
