package com.poly.action.car_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;
import car_beans.DboPkztInfo;
import car_daos.DBConnect;
import car_daos.DboCarCatalognewDao;
import car_daos.DboPkztInfoDao;

import com.poly.action.MyActionSupport;
import com.poly.util.FieldUtil;
import com.redis.RedisManager;
import com.redis.RedisParseUtil;

public class CarPkInfo extends MyActionSupport{
	
	private List<DboCarCatalognew> brandList;
	private int brandId;
	private int seriesId1;
	private int seriesId2;
	private String carimg1;
	private String carimg2;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	private String t7;
	private String t8;
	private String t9;
	private String t10;
	private String t11;
	private String t12;
	private String t13;
	
	
	public String execute(){
		String pathLevel1=" pathlevel=1 and onsale=1 and isdelete=0";
		 brandList=DboCarCatalognewDao.where(pathLevel1);
		 String[] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		 List<DboCarCatalognew> lst1=new ArrayList<DboCarCatalognew>();
		 for(int i=0;i<abc.length;i++){
			 for(int j=0;j<brandList.size();j++){
				 if(abc[i].equals(brandList.get(j).getLname())){
					 lst1.add(brandList.get(j));
				 }
			 }
		 }
		 brandList=lst1;
		return SUCCESS;
	}
	
	public void GetCarPkSeries() throws IOException{
		String series=" fatherid="+brandId+" and onsale=1  and isdelete=0";
		List<DboCarCatalognew> seriesList=DboCarCatalognewDao.where(series);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(seriesList);
		//String jsonp=request.getParameter("jsonpcallback");
		out.print(json.toString()); 
		out.close();
	}
	
	public void GetCarPkInfo() throws IOException{
		String pkStr=" carid1="+seriesId1+" and carid2="+seriesId2;
		List<DboPkztInfo> pkList=new ArrayList<DboPkztInfo>();
		List<DboPkztInfo> pkList1=DboPkztInfoDao.where(pkStr);
		int flag=0;
		if(pkList1.size()>0){
			pkList=pkList1;
		}else{
			String pkStr2=" carid1="+seriesId2+" and carid2="+seriesId1;
			List<DboPkztInfo> pkList2=DboPkztInfoDao.where(pkStr2);
			if(pkList2.size()>0){
				pkList=pkList2;
				flag=1;
			}
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("flag", flag);
		map.put("data", pkList);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		//String jsonp=request.getParameter("jsonpcallback");
		out.print(json.toString()); 
		out.close();
	}
	
	
	public String UpDatePkInfo() throws IOException{
		String pkStr=" carid1="+seriesId1+" and carid2="+seriesId2;
		List<DboPkztInfo> pkList1=DboPkztInfoDao.where(pkStr);
		if(pkList1.size()>0){
			DboPkztInfo pkInfo=new DboPkztInfo();
			pkInfo.setId(pkList1.get(0).getId());
			pkInfo.setPrefacetitle(t1);
			pkInfo.setPrefacecontent(t2);
			pkInfo.setApptitle(t3);
			pkInfo.setAppcontent1(t4);
			pkInfo.setAppcontent2(t5);
			pkInfo.setSeattitle(t6);
			pkInfo.setSeatcontent1(t7);
			pkInfo.setSeatcontent2(t8);
			pkInfo.setCtrltitle(t9);
			pkInfo.setCtrlcontent1(t10);
			pkInfo.setCtrlcontent2(t11);
			pkInfo.setSummarycontent(t12);
			pkInfo.setSummarycontent(t13);
			carimg1=carimg1.substring(1, carimg1.length()-1);
			String appimgpath11="";
			if(carimg1.split("@").length>0){
				appimgpath11=carimg1.split("@")[0];
			}
			if(!FieldUtil.isEmpty(appimgpath11)){
				pkInfo.setAppimgpath11(appimgpath11);
			}
			String appimgpath12="";
			if(carimg1.split("@").length>1){
				appimgpath12=carimg1.split("@")[1];
			}
			if(!FieldUtil.isEmpty(appimgpath12)){
				pkInfo.setAppimgpath12(appimgpath12);
			}
			String appimgpath13="";
			if(carimg1.split("@").length>2){
				appimgpath13=carimg1.split("@")[2];
			}
			if(!FieldUtil.isEmpty(appimgpath13)){
				pkInfo.setAppimgpath13(appimgpath13);
			}
			String appimgpath14="";
			if(carimg1.split("@").length>3){
				appimgpath14=carimg1.split("@")[3];
			}
			if(!FieldUtil.isEmpty(appimgpath14)){
				pkInfo.setAppimgpath14(appimgpath14);
			}
			String seatimgpath11="";
			if(carimg1.split("@").length>4){
				seatimgpath11=carimg1.split("@")[4];
			}
			if(!FieldUtil.isEmpty(seatimgpath11)){
				pkInfo.setSeatimgpath11(seatimgpath11);
			}
			String seatimgpath12="";
			if(carimg1.split("@").length>5){
				seatimgpath12=carimg1.split("@")[5];
			}
			if(!FieldUtil.isEmpty(seatimgpath12)){
				pkInfo.setSeatimgpath12(seatimgpath12);
			}
			String seatimgpath13="";
			if(carimg1.split("@").length>6){
				seatimgpath13=carimg1.split("@")[6];
			}
			if(!FieldUtil.isEmpty(seatimgpath13)){
				pkInfo.setSeatimgpath13(seatimgpath13);
			}
			String ctrlimgpath11="";
			if(carimg1.split("@").length>7){
				ctrlimgpath11=carimg1.split("@")[7];
			}
			if(!FieldUtil.isEmpty(ctrlimgpath11)){
				pkInfo.setCtrlimgpath11(ctrlimgpath11);
			}
			String ctrlimgpath12="";
			if(carimg1.split("@").length>8){
				ctrlimgpath12=carimg1.split("@")[8];
			}
			if(!FieldUtil.isEmpty(ctrlimgpath12)){
				pkInfo.setCtrlimgpath12(ctrlimgpath12);
			}
			String seatimgpath15="";
			if(carimg1.split("@").length>9){
				seatimgpath15=carimg1.split("@")[9];
			}
			if(!FieldUtil.isEmpty(seatimgpath15)){
				pkInfo.setSeatimgpath15(seatimgpath15);
			}
			carimg2=carimg2.substring(1, carimg2.length()-1);
			String appimgpath21="";
			if(carimg2.split("@").length>0){
				appimgpath21=carimg2.split("@")[0];
			}
			if(!FieldUtil.isEmpty(appimgpath21)){
				pkInfo.setAppimgpath21(appimgpath21);
			}
			String appimgpath22="";
			if(carimg2.split("@").length>1){
				appimgpath22=carimg2.split("@")[1];
			}
			if(!FieldUtil.isEmpty(appimgpath22)){
				pkInfo.setAppimgpath22(appimgpath22);
			}
			String appimgpath23="";
			if(carimg2.split("@").length>2){
				appimgpath23=carimg2.split("@")[2];
			}
			if(!FieldUtil.isEmpty(appimgpath23)){
				pkInfo.setAppimgpath23(appimgpath23);
			}
			String appimgpath24="";
			if(carimg2.split("@").length>3){
				appimgpath24=carimg2.split("@")[3];
			}
			if(!FieldUtil.isEmpty(appimgpath24)){
				pkInfo.setAppimgpath24(appimgpath24);
			}
			String seatimgpath21="";
			if(carimg2.split("@").length>4){
				seatimgpath21=carimg2.split("@")[4];
			}
			if(!FieldUtil.isEmpty(seatimgpath21)){
				pkInfo.setSeatimgpath21(seatimgpath21);
			}
			String seatimgpath22="";
			if(carimg2.split("@").length>5){
				seatimgpath22=carimg2.split("@")[5];
			}
			if(!FieldUtil.isEmpty(seatimgpath22)){
				pkInfo.setSeatimgpath22(seatimgpath22);
			}
			String seatimgpath23="";
			if(carimg2.split("@").length>6){
				seatimgpath23=carimg2.split("@")[6];
			}
			if(!FieldUtil.isEmpty(seatimgpath23)){
				pkInfo.setSeatimgpath23(seatimgpath23);
			}
			String ctrlimgpath21="";
			if(carimg2.split("@").length>7){
				ctrlimgpath21=carimg2.split("@")[7];
			}
			if(!FieldUtil.isEmpty(ctrlimgpath21)){
				pkInfo.setCtrlimgpath21(ctrlimgpath21);
			}
			String ctrlimgpath22="";
			if(carimg2.split("@").length>8){
				ctrlimgpath22=carimg2.split("@")[8];
			}
			if(!FieldUtil.isEmpty(ctrlimgpath22)){
				pkInfo.setCtrlimgpath22(ctrlimgpath22);
			}
			String seatimgpath25="";
			if(carimg2.split("@").length>9){
				seatimgpath25=carimg2.split("@")[9];
			}
			if(!FieldUtil.isEmpty(seatimgpath25)){
				pkInfo.setSeatimgpath25(seatimgpath25);
			}
			DboPkztInfoDao.update(pkInfo);
			setAjax("1");
		}else{
			String pkStr2=" carid1="+seriesId2+" and carid2="+seriesId1;
			List<DboPkztInfo> pkList2=DboPkztInfoDao.where(pkStr2);
			if(pkList2.size()>0){
				DboPkztInfo pkInfo=new DboPkztInfo();
				pkInfo.setId(pkList2.get(0).getId());
				pkInfo.setPrefacetitle(t1);
				pkInfo.setPrefacecontent(t2);
				pkInfo.setApptitle(t3);
				pkInfo.setAppcontent2(t4);
				pkInfo.setAppcontent1(t5);
				pkInfo.setSeattitle(t6);
				pkInfo.setSeatcontent2(t7);
				pkInfo.setSeatcontent1(t8);
				pkInfo.setCtrltitle(t9);
				pkInfo.setCtrlcontent2(t10);
				pkInfo.setCtrlcontent1(t11);
				pkInfo.setSummarycontent(t12);
				pkInfo.setSummarycontent(t13);
				carimg2=carimg2.substring(1, carimg2.length()-1);
				String appimgpath11="";
				if(carimg2.split("@").length>0){
					appimgpath11=carimg2.split("@")[0];
				}
				if(!FieldUtil.isEmpty(appimgpath11)){
					pkInfo.setAppimgpath11(appimgpath11);
				}
				String appimgpath12="";
				if(carimg2.split("@").length>1){
					appimgpath12=carimg2.split("@")[1];
				}
				if(!FieldUtil.isEmpty(appimgpath12)){
					pkInfo.setAppimgpath12(appimgpath12);
				}
				String appimgpath13="";
				if(carimg2.split("@").length>2){
					appimgpath13=carimg2.split("@")[2];
				}
				if(!FieldUtil.isEmpty(appimgpath13)){
					pkInfo.setAppimgpath13(appimgpath13);
				}
				String appimgpath14="";
				if(carimg2.split("@").length>3){
					appimgpath14=carimg2.split("@")[3];
				}
				if(!FieldUtil.isEmpty(appimgpath14)){
					pkInfo.setAppimgpath14(appimgpath14);
				}
				String seatimgpath11="";
				if(carimg2.split("@").length>4){
					seatimgpath11=carimg2.split("@")[4];
				}
				if(!FieldUtil.isEmpty(seatimgpath11)){
					pkInfo.setSeatimgpath11(seatimgpath11);
				}
				String seatimgpath12="";
				if(carimg2.split("@").length>5){
					seatimgpath12=carimg2.split("@")[5];
				}
				if(!FieldUtil.isEmpty(seatimgpath12)){
					pkInfo.setSeatimgpath12(seatimgpath12);
				}
				String seatimgpath13="";
				if(carimg2.split("@").length>6){
					seatimgpath13=carimg2.split("@")[6];
				}
				if(!FieldUtil.isEmpty(seatimgpath13)){
					pkInfo.setSeatimgpath13(seatimgpath13);
				}
				String ctrlimgpath11="";
				if(carimg2.split("@").length>7){
					ctrlimgpath11=carimg2.split("@")[7];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath11)){
					pkInfo.setCtrlimgpath11(ctrlimgpath11);
				}
				String ctrlimgpath12="";
				if(carimg2.split("@").length>8){
					ctrlimgpath12=carimg2.split("@")[8];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath12)){
					pkInfo.setCtrlimgpath12(ctrlimgpath12);
				}
				String seatimgpath15="";
				if(carimg2.split("@").length>9){
					seatimgpath15=carimg2.split("@")[9];
				}
				if(!FieldUtil.isEmpty(seatimgpath15)){
					pkInfo.setSeatimgpath15(seatimgpath15);
				}
				carimg1=carimg1.substring(1, carimg1.length()-1);
				String appimgpath21="";
				if(carimg1.split("@").length>0){
					appimgpath21=carimg1.split("@")[0];
				}
				if(!FieldUtil.isEmpty(appimgpath21)){
					pkInfo.setAppimgpath21(appimgpath21);
				}
				String appimgpath22="";
				if(carimg1.split("@").length>1){
					appimgpath22=carimg1.split("@")[1];
				}
				if(!FieldUtil.isEmpty(appimgpath22)){
					pkInfo.setAppimgpath22(appimgpath22);
				}
				String appimgpath23="";
				if(carimg1.split("@").length>2){
					appimgpath23=carimg1.split("@")[2];
				}
				if(!FieldUtil.isEmpty(appimgpath23)){
					pkInfo.setAppimgpath23(appimgpath23);
				}
				String appimgpath24="";
				if(carimg1.split("@").length>3){
					appimgpath24=carimg1.split("@")[3];
				}
				if(!FieldUtil.isEmpty(appimgpath24)){
					pkInfo.setAppimgpath24(appimgpath24);
				}
				String seatimgpath21="";
				if(carimg1.split("@").length>4){
					seatimgpath21=carimg1.split("@")[4];
				}
				if(!FieldUtil.isEmpty(seatimgpath21)){
					pkInfo.setSeatimgpath21(seatimgpath21);
				}
				String seatimgpath22="";
				if(carimg1.split("@").length>5){
					seatimgpath22=carimg1.split("@")[5];
				}
				if(!FieldUtil.isEmpty(seatimgpath22)){
					pkInfo.setSeatimgpath22(seatimgpath22);
				}
				String seatimgpath23="";
				if(carimg1.split("@").length>6){
					seatimgpath23=carimg1.split("@")[6];
				}
				if(!FieldUtil.isEmpty(seatimgpath23)){
					pkInfo.setSeatimgpath23(seatimgpath23);
				}
				String ctrlimgpath21="";
				if(carimg1.split("@").length>7){
					ctrlimgpath21=carimg1.split("@")[7];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath21)){
					pkInfo.setCtrlimgpath21(ctrlimgpath21);
				}
				String ctrlimgpath22="";
				if(carimg1.split("@").length>8){
					ctrlimgpath22=carimg1.split("@")[8];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath22)){
					pkInfo.setCtrlimgpath22(ctrlimgpath22);
				}
				String seatimgpath25="";
				if(carimg1.split("@").length>9){
					seatimgpath25=carimg1.split("@")[9];
				}
				if(!FieldUtil.isEmpty(seatimgpath25)){
					pkInfo.setSeatimgpath25(seatimgpath25);
				}
				DboPkztInfoDao.update(pkInfo);
				setAjax("1");
			}else{
				DboPkztInfo pkInfo=new DboPkztInfo();
				pkInfo.setCarid1(seriesId1);
				pkInfo.setCarid2(seriesId2);
				pkInfo.setPrefacetitle(t1);
				pkInfo.setPrefacecontent(t2);
				pkInfo.setApptitle(t3);
				pkInfo.setAppcontent2(t5);
				pkInfo.setSeattitle(t6);
				pkInfo.setSeatcontent1(t7);
				pkInfo.setSeatcontent2(t8);
				pkInfo.setCtrltitle(t9);
				pkInfo.setCtrlcontent1(t10);
				pkInfo.setCtrlcontent2(t11);
				pkInfo.setSummarycontent(t12);
				pkInfo.setSummarycontent(t13);
				carimg1=carimg1.substring(1, carimg1.length()-1);
				String appimgpath11="";
				if(carimg1.split("@").length>0){
					appimgpath11=carimg1.split("@")[0];
				}
				if(!FieldUtil.isEmpty(appimgpath11)){
					pkInfo.setAppimgpath11(appimgpath11);
				}
				String appimgpath12="";
				if(carimg1.split("@").length>1){
					appimgpath12=carimg1.split("@")[1];
				}
				if(!FieldUtil.isEmpty(appimgpath12)){
					pkInfo.setAppimgpath12(appimgpath12);
				}
				String appimgpath13="";
				if(carimg1.split("@").length>2){
					appimgpath13=carimg1.split("@")[2];
				}
				if(!FieldUtil.isEmpty(appimgpath13)){
					pkInfo.setAppimgpath13(appimgpath13);
				}
				String appimgpath14="";
				if(carimg1.split("@").length>3){
					appimgpath14=carimg1.split("@")[3];
				}
				if(!FieldUtil.isEmpty(appimgpath14)){
					pkInfo.setAppimgpath14(appimgpath14);
				}
				String seatimgpath11="";
				if(carimg1.split("@").length>4){
					seatimgpath11=carimg1.split("@")[4];
				}
				if(!FieldUtil.isEmpty(seatimgpath11)){
					pkInfo.setSeatimgpath11(seatimgpath11);
				}
				String seatimgpath12="";
				if(carimg1.split("@").length>5){
					seatimgpath12=carimg1.split("@")[5];
				}
				if(!FieldUtil.isEmpty(seatimgpath12)){
					pkInfo.setSeatimgpath12(seatimgpath12);
				}
				String seatimgpath13="";
				if(carimg1.split("@").length>6){
					seatimgpath13=carimg1.split("@")[6];
				}
				if(!FieldUtil.isEmpty(seatimgpath13)){
					pkInfo.setSeatimgpath13(seatimgpath13);
				}
				String ctrlimgpath11="";
				if(carimg1.split("@").length>7){
					ctrlimgpath11=carimg1.split("@")[7];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath11)){
					pkInfo.setCtrlimgpath11(ctrlimgpath11);
				}
				String ctrlimgpath12="";
				if(carimg1.split("@").length>8){
					ctrlimgpath12=carimg1.split("@")[8];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath12)){
					pkInfo.setCtrlimgpath12(ctrlimgpath12);
				}
				String seatimgpath15="";
				if(carimg1.split("@").length>9){
					seatimgpath15=carimg1.split("@")[9];
				}
				if(!FieldUtil.isEmpty(seatimgpath15)){
					pkInfo.setSeatimgpath15(seatimgpath15);
				}
				carimg2=carimg2.substring(1, carimg2.length()-1);
				String appimgpath21="";
				if(carimg2.split("@").length>0){
					appimgpath21=carimg2.split("@")[0];
				}
				if(!FieldUtil.isEmpty(appimgpath21)){
					pkInfo.setAppimgpath21(appimgpath21);
				}
				String appimgpath22="";
				if(carimg2.split("@").length>1){
					appimgpath22=carimg2.split("@")[1];
				}
				if(!FieldUtil.isEmpty(appimgpath22)){
					pkInfo.setAppimgpath22(appimgpath22);
				}
				String appimgpath23="";
				if(carimg2.split("@").length>2){
					appimgpath23=carimg2.split("@")[2];
				}
				if(!FieldUtil.isEmpty(appimgpath23)){
					pkInfo.setAppimgpath23(appimgpath23);
				}
				String appimgpath24="";
				if(carimg2.split("@").length>3){
					appimgpath24=carimg2.split("@")[3];
				}
				if(!FieldUtil.isEmpty(appimgpath24)){
					pkInfo.setAppimgpath24(appimgpath24);
				}
				String seatimgpath21="";
				if(carimg2.split("@").length>4){
					seatimgpath21=carimg2.split("@")[4];
				}
				if(!FieldUtil.isEmpty(seatimgpath21)){
					pkInfo.setSeatimgpath21(seatimgpath21);
				}
				String seatimgpath22="";
				if(carimg2.split("@").length>5){
					seatimgpath22=carimg2.split("@")[5];
				}
				if(!FieldUtil.isEmpty(seatimgpath22)){
					pkInfo.setSeatimgpath22(seatimgpath22);
				}
				String seatimgpath23="";
				if(carimg2.split("@").length>6){
					seatimgpath23=carimg2.split("@")[6];
				}
				if(!FieldUtil.isEmpty(seatimgpath23)){
					pkInfo.setSeatimgpath23(seatimgpath23);
				}
				String ctrlimgpath21="";
				if(carimg2.split("@").length>7){
					ctrlimgpath21=carimg2.split("@")[7];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath21)){
					pkInfo.setCtrlimgpath21(ctrlimgpath21);
				}
				String ctrlimgpath22="";
				if(carimg2.split("@").length>8){
					ctrlimgpath22=carimg2.split("@")[8];
				}
				if(!FieldUtil.isEmpty(ctrlimgpath22)){
					pkInfo.setCtrlimgpath22(ctrlimgpath22);
				}
				String seatimgpath25="";
				if(carimg2.split("@").length>9){
					seatimgpath25=carimg2.split("@")[9];
				}
				if(!FieldUtil.isEmpty(seatimgpath25)){
					pkInfo.setSeatimgpath25(seatimgpath25);
				}
				pkInfo.setAdddate(new Date()); 
				pkInfo.setUptime(new Date());
				DBConnect dbc = null;
				String max="SELECT MAX(id) FROM dbo_pkzt_info";
				int MaxId=0;
				try {
					dbc = new DBConnect(max);
					ResultSet rs = dbc.executeQuery();
					while (rs.next()) {
						MaxId=rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (dbc != null)
							dbc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				pkInfo.setId(MaxId+1);
				try {
					DboPkztInfoDao.save(pkInfo);
					//RedisParseUtil.jedisPublish("insert", "dbo_pkzt_info", String.valueOf(MaxId));
					setAjax("1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					setAjax("0");
				}
				
			}
		}
		String pathLevel1=" pathlevel=1 and onsale=1 and isdelete=0";
		 brandList=DboCarCatalognewDao.where(pathLevel1);
		 String[] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		 List<DboCarCatalognew> lst1=new ArrayList<DboCarCatalognew>();
		 for(int i=0;i<abc.length;i++){
			 for(int j=0;j<brandList.size();j++){
				 if(abc[i].equals(brandList.get(j).getLname())){
					 lst1.add(brandList.get(j));
				 }
			 } 
		 }
		 brandList=lst1;
		 return SUCCESS;
	}
	
	public List<DboCarCatalognew> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<DboCarCatalognew> brandList) {
		this.brandList = brandList;
	}
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	public int getSeriesId1() {
		return seriesId1;
	}

	public void setSeriesId1(int seriesId1) {
		this.seriesId1 = seriesId1;
	}

	public int getSeriesId2() {
		return seriesId2;
	}

	public void setSeriesId2(int seriesId2) {
		this.seriesId2 = seriesId2;
	}
	
	public String getCarimg1() {
		return carimg1;
	}

	public void setCarimg1(String carimg1) {
		this.carimg1 = carimg1;
	}

	public String getCarimg2() {
		return carimg2;
	}

	public void setCarimg2(String carimg2) {
		this.carimg2 = carimg2;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	public String getT6() {
		return t6;
	}

	public void setT6(String t6) {
		this.t6 = t6;
	}

	public String getT7() {
		return t7;
	}

	public void setT7(String t7) {
		this.t7 = t7;
	}

	public String getT8() {
		return t8;
	}

	public void setT8(String t8) {
		this.t8 = t8;
	}

	public String getT9() {
		return t9;
	}

	public void setT9(String t9) {
		this.t9 = t9;
	}

	public String getT10() {
		return t10;
	}

	public void setT10(String t10) {
		this.t10 = t10;
	}

	public String getT11() {
		return t11;
	}

	public void setT11(String t11) {
		this.t11 = t11;
	}

	public String getT12() {
		return t12;
	}

	public void setT12(String t12) {
		this.t12 = t12;
	}

	public String getT13() {
		return t13;
	}

	public void setT13(String t13) {
		this.t13 = t13;
	}


}
