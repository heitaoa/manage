package com.poly.action.action_4s;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.DboDeaDealers;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalognewDao;
import car_daos.DboDeaDealersDao;

import com.poly.action.MyActionSupport;
import com.poly.service.TreeService;
import com.poly.util.ObjectToMapUtil;

public class SiteDealerManager extends MyActionSupport{
	
	private Map<String, List<Map<String, String>>> brandMap;
	private String[] zimuStr={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private int usernameType;
	private String username;
	private int userType;
	private List<DboDeaDealers> dealerall;
	private int mainBrandid;
	private int islast;
	private int page=1;
	private int pages=1;
	private List<Map<String, String>> dealers;
	public String execute(){
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		brandMap=TreeService.getInstance().brandTree();
		String siteName=(String)request.getSession().getAttribute("site_name");
		List<DboAreCatalog> ares=DboAreCatalogDao.where(" isdelete=0 and catalogname like '%"+siteName.substring(0,siteName.length()-1)+"%'");
		List<DboAreCatalog> sAreCatalogs=DboAreCatalogDao.where(" isdelete=0 and fatherid="+ares.get(0).getCatalogid());
		String sAreId="";
		for(int i=0;i<sAreCatalogs.size();i++){
			sAreId=sAreId+","+sAreCatalogs.get(i).getCatalogid();
		}
		String cSql=" areaid in("+ares.get(0).getCatalogid();
		if(sAreId!=null&&sAreId.length()>0){
			cSql=cSql+sAreId;
		}
		cSql=cSql+") and isdelete=0";
		if(username!=null&&username.length()>0){
			if(usernameType==0){
				cSql=cSql+" and username like '%"+username+"%'";
			}else{
				cSql=cSql+" and ename like '%"+username+"%'";
			}
		}
		if(userType==0){
			
		}else if(userType==1){
			cSql=cSql+" and paylevel !=5";
		}else if(userType==2){
			cSql=cSql+" and paylevel =5 and istmp=1";
		}else {
			cSql=cSql+" and paylevel =5 and istmp=0";
		}
		if(islast==0){
			
		}else{
			cSql=cSql+" and expirationdate <'"+sdf.format(now)+"'";
		}
		dealerall=DboDeaDealersDao.where(cSql);
		if(mainBrandid!=0){
			List<DboDeaDealers> temps=new ArrayList<DboDeaDealers>();
			for(int i=0;i<dealerall.size();i++){
				String  mainBrandids=dealerall.get(i).getMainbrand();
				String[] ids=mainBrandids.split(",");
				for(int j=0;j<ids.length;j++){
					if(ids[j]!=null&&ids[j].length()>0){
						if(Integer.parseInt(ids[j])==mainBrandid){
							temps.add(dealerall.get(i));
							break;
						}
					}
				}
			}
			dealerall=temps;
		}
		if(dealerall.size()%10==0){
			pages=dealerall.size()/10;
		}else{
			pages=(dealerall.size()/10)+1;
		}
		int start=(page-1)*10;
		int end=page*10;
		List<DboDeaDealers> temp=new ArrayList<DboDeaDealers>();
		for(int i=start;i<end;i++){
			if(i<dealerall.size()){
				temp.add(dealerall.get(i));
			}
		}
		dealerall=temp;
		dealers=new ArrayList<Map<String,String>>();
		for(int i=0;i<dealerall.size();i++){
			Map<String, String> tMap=ObjectToMapUtil.changeToMap(dealerall.get(i));
			dealers.add(tMap);
		}
		for(int i=0;i<dealers.size();i++){
			List<DboAreCatalog> are=DboAreCatalogDao.where(" catalogid="+dealers.get(i).get("areaid"));
			if(are.size()>0){
				if(are.get(0).getFatherid()!=0){
					List<DboAreCatalog> fatherare=DboAreCatalogDao.where(" catalogid="+are.get(0).getFatherid());
					if(fatherare.size()>0){
						dealers.get(i).put("areaName",fatherare.get(0).getCatalogname()+are.get(0).getByname());
					}else{
						dealers.get(i).put("areaName", are.get(0).getByname());
					}
					
				}else{
					dealers.get(i).put("areaName", are.get(0).getByname());
				}
				
			}else{
				dealers.get(i).put("areaName", "");
			}
			String mainBrandString=dealers.get(i).get("mainbrand");
			if(mainBrandString!=null&&mainBrandString.length()>0){
				List<DboCarCatalognew> carCatalogs=DboCarCatalognewDao.where(" catalogid in("+mainBrandString+")");
				String mainBrandNameString=""; 
				if(carCatalogs.size()>0){
					for(int j=0;j<carCatalogs.size();j++){
						mainBrandNameString=mainBrandNameString+carCatalogs.get(j).getCatalogname()+",";
					}
					mainBrandNameString=mainBrandNameString.substring(0,mainBrandNameString.length()-1);
				}
				dealers.get(i).put("mainBrandName", mainBrandNameString);
			}else{
				dealers.get(i).put("mainBrandName", "");
			}
		}
		for(int i=0;i<dealers.size();i++){
			dealers.get(i).put("expirationdate",dealers.get(i).get("expirationdate").replaceAll("&nbsp", " "));
		}
		return SUCCESS;
	}
	public List<Map<String, String>> getDealers() {
		return dealers;
	}
	public void setDealers(List<Map<String, String>> dealers) {
		this.dealers = dealers;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Map<String, List<Map<String, String>>> getBrandMap() {
		return brandMap;
	}
	public void setBrandMap(Map<String, List<Map<String, String>>> brandMap) {
		this.brandMap = brandMap;
	}
	public String[] getZimuStr() {
		return zimuStr;
	}
	public void setZimuStr(String[] zimuStr) {
		this.zimuStr = zimuStr;
	}
	public int getUsernameType() {
		return usernameType;
	}
	public void setUsernameType(int usernameType) {
		this.usernameType = usernameType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getMainBrandid() {
		return mainBrandid;
	}
	public void setMainBrandid(int mainBrandid) {
		this.mainBrandid = mainBrandid;
	}
	public int getIslast() {
		return islast;
	}
	public void setIslast(int islast) {
		this.islast = islast;
	}
	
}
