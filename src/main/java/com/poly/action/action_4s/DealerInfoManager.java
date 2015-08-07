package com.poly.action.action_4s;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.If;

import net.sf.json.JSONArray;
import car_beans.DboAreCatalog;
import car_beans.DboCarCatalog;
import car_beans.DboCarCatalognew;
import car_beans.DboDeaDealerinfo;
import car_beans.DboDeaDealers;
import car_beans.DboDntUserlevel;
import car_beans.DboDntUsers;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalogDao;
import car_daos.DboCarCatalognewDao;
import car_daos.DboDeaDealerinfoDao;
import car_daos.DboDeaDealersDao;
import car_daos.DboDntUserlevelDao;
import car_daos.DboDntUsersDao;

import com.poly.util.MD5;
import com.poly.action.MyActionSupport;
import com.poly.bean.newNews;
import com.poly.service.TreeService;
import com.poly.util.ObjectToMapUtil;
import com.redis.RedisDao;

public class DealerInfoManager extends MyActionSupport{

	private Map<String, List<Map<String, String>>> brandMap;
	private Map<String,List<DboAreCatalog>> areaMap;
	private Map<String,List<DboAreCatalog>> cityMap;
	private String[] zimuStr={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private List<Map<String, String>> dealers;
	private int pages=1;
	private int page=1;
	private int usernameType=0;//用户名类型
	private String username;//用户名
	private int cityid=0;//城市
	private int mainBrandid=0;//品牌
	private int islast=0;//是否过期
	private int userType=0;
	private int cityFatherid=0;
	private int main_area;
	private int main_city;
	public String execute() throws UnsupportedEncodingException{
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		brandMap=TreeService.getInstance().brandTree();
		List<DboAreCatalog> areLists=DboAreCatalogDao.where(" fatherid=0 and isdelete=0") ;
		if(main_city==0){
			cityid=main_area;
		}else{
			cityid=main_city;
		}
		areaMap=new HashMap<String, List<DboAreCatalog>>();
		for(int i=0;i<zimuStr.length;i++){
			List<DboAreCatalog> temp=new ArrayList<DboAreCatalog>(); 
			for(int g=0;g<areLists.size();g++){ 
				if(areLists.get(g).getLname()!=null&&areLists.get(g).getLname().length()>0){
					String lname=areLists.get(g).getLname().trim();
					String zimu=zimuStr[i];
					if(zimu.indexOf(lname)!=-1){
						temp.add(areLists.get(g));
					}
				}
				if(g==areLists.size()-1){ 
					if(temp!=null&&temp.size()>0){
						areaMap.put(zimuStr[i],temp);
					}
				}
			}
		}
		cityMap=new HashMap<String, List<DboAreCatalog>>();
		if(cityid!=0){
			List<DboAreCatalog> areCatalogs=DboAreCatalogDao.where(" catalogid="+cityid+" and isdelete=0");
			int fatherid=areCatalogs.get(0).getFatherid();
			if(fatherid!=0){
				cityFatherid=fatherid;
				List<DboAreCatalog> cityLists=DboAreCatalogDao.where(" fatherid="+areCatalogs.get(0).getFatherid()+" and isdelete=0") ;
				for(int i=0;i<zimuStr.length;i++){
					List<DboAreCatalog> temp=new ArrayList<DboAreCatalog>(); 
					for(int g=0;g<cityLists.size();g++){ 
						if(cityLists.get(g).getLname()!=null&&cityLists.get(g).getLname().length()>0){
							String lname=cityLists.get(g).getLname().trim();
							String zimu=zimuStr[i];
							if(zimu.indexOf(lname)!=-1){
								temp.add(cityLists.get(g));
							}
						}
						if(g==cityLists.size()-1){ 
							if(temp!=null&&temp.size()>0){
								cityMap.put(zimuStr[i],temp);
							}
						}
					}
				}
			}else{
				List<DboAreCatalog> cityLists=DboAreCatalogDao.where(" fatherid="+cityid+" and isdelete=0") ;
				for(int i=0;i<zimuStr.length;i++){
					List<DboAreCatalog> temp=new ArrayList<DboAreCatalog>(); 
					for(int g=0;g<cityLists.size();g++){ 
						if(cityLists.get(g).getLname()!=null&&cityLists.get(g).getLname().length()>0){
							String lname=cityLists.get(g).getLname().trim();
							String zimu=zimuStr[i];
							if(zimu.indexOf(lname)!=-1){
								temp.add(cityLists.get(g));
							}
						}
						if(g==cityLists.size()-1){ 
							if(temp!=null&&temp.size()>0){
								cityMap.put(zimuStr[i],temp);
							}
						}
					}
				}
			}
		}
		String ssql=" isdelete=0";
		if(username!=null&&username.length()>0){
			
			if(usernameType==0){
				ssql=ssql+" and username like '%"+username+"%'";
			}else{
				ssql=ssql+" and ename like '%"+username+"%'";
			}
		}
		
		if(cityid==0){
			
		}else{
			String citySql=" fatherid= "+cityid;
			List<DboAreCatalog> citys=DboAreCatalogDao.where(citySql);
			String citysString="";
			if(citys!=null&&citys.size()>0){
				for(int i=0;i<citys.size();i++){
					citysString=citysString+citys.get(i).getCatalogid()+",";
				}
			}
			if(citysString.length()>0){
				ssql=ssql+" and areaid in ("+citysString+cityid+")";
			}else{
				ssql=ssql+" and areaid in ("+cityid+")";
			}
		}
		if(userType==0){
			
		}else if(userType==1){
			ssql=ssql+" and paylevel !=5";
		}else if(userType==2){
			ssql=ssql+" and paylevel =5 and istmp=1";
		}else {
			ssql=ssql+" and paylevel =5 and istmp=0";
		}
		if(islast==0){
			
		}else{
			ssql=ssql+" and expirationdate <'"+sdf.format(now)+"'";
		}
		List<DboDeaDealers> alldealers=new ArrayList<DboDeaDealers>();
		alldealers=DboDeaDealersDao.where(ssql);
		if(mainBrandid!=0){
			List<DboDeaDealers> temps=new ArrayList<DboDeaDealers>();
			for(int i=0;i<alldealers.size();i++){
				String mainBrandStr=alldealers.get(i).getMainbrand();
				String[] brandIds=mainBrandStr.split(",");
				for(int j=0;j<brandIds.length;j++){
					if(brandIds[j]!=null&&brandIds[j].length()>0){
						if(Integer.parseInt(brandIds[j])==mainBrandid){
							temps.add(alldealers.get(i));
							break;
						}
					}
				}
			}
			alldealers=temps;
		}
		
		if(alldealers.size()%10==0){
			pages=alldealers.size()/10;
		}else{
			pages=(alldealers.size()/10)+1;
		}
		int start=(page-1)*10;
		int end=page*10;
		dealers=new ArrayList<Map<String, String>>(); 
		for(int i=start;i<end;i++){
			if(i<alldealers.size()){
				dealers.add(ObjectToMapUtil.changeToMap(alldealers.get(i)));
			}
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
		System.out.println(ssql);
		return SUCCESS;
	}
	public int getMain_area() {
		return main_area;
	}

	public void setMain_area(int main_area) {
		this.main_area = main_area;
	}

	public int getMain_city() {
		return main_city;
	}

	public void setMain_city(int main_city) {
		this.main_city = main_city;
	}
	private int brandId;
	public void GetIwayListByBrandId() throws IOException{
		Map<String, List<Map<String,String>>> dMap=TreeService.getInstance().serialTree(brandId);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json=JSONArray.fromObject(dMap);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	private int eid;
	public void DeleteDealerInfoByEid() throws IOException{
		List<DboDeaDealers> dealers=DboDeaDealersDao.where(" eid="+eid);
		
		String dSql=" update dbo_dea_dealers set isdelete=1 where eid ="+eid;
		DBConnect dbc = null;
		List<Object> tList=new ArrayList<Object>();
		boolean flag=true;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(dSql);
			dbc.executeUpdate();
			dbc.close();
			RedisDao.UpdateDealerIsdeleteByEid(eid,dealers.get(0).getUsername(),dealers.get(0).getDomain(),dealers.get(0).getAreaid(),dealers.get(0).getIs4s(),dealers.get(0).getPaylevel(),dealers.get(0).getIway(),dealers.get(0).getMainbrand());
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		tList.add(flag);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json=JSONArray.fromObject(tList);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	
	public void ReSetPWByEid() throws IOException{
		List<DboDntUsers> users=DboDntUsersDao.where(" username='"+username+"'");
		String password=MD5.toMD5("315che");
		String upSql="update dbo_dnt_users set password='"+password+"' where username='"+username+"'";
		DBConnect dbc = null;
		List<Object> tList=new ArrayList<Object>();
		boolean flag=true;
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(upSql);
			dbc.executeUpdate();
			dbc.close();
			RedisDao.UpdateUserPassWordByEid(users.get(0).getUid(),password);
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		tList.add(flag);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json=JSONArray.fromObject(tList);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	
	
	
	private DboDeaDealers updealer;
	private int updateType=0;
	private int areaflag=0;
	public int getAreaflag() {
		return areaflag;
	}

	public void setAreaflag(int areaflag) {
		this.areaflag = areaflag;
	}

	private List<DboCarCatalognew> mainbrand;
	
	private String[] diways;
	private String eidStr;
	public String UpDateDealerinfoBy(){
		brandMap=TreeService.getInstance().brandTree();
		List<DboAreCatalog> areLists=DboAreCatalogDao.where(" fatherid=0 and isdelete=0") ;
		areaMap=new HashMap<String, List<DboAreCatalog>>();
		for(int i=0;i<zimuStr.length;i++){
			List<DboAreCatalog> temp=new ArrayList<DboAreCatalog>(); 
			for(int g=0;g<areLists.size();g++){ 
				if(areLists.get(g).getLname()!=null&&areLists.get(g).getLname().length()>0){
					String lname=areLists.get(g).getLname().trim();
					String zimu=zimuStr[i];
					if(zimu.indexOf(lname)!=-1){
						temp.add(areLists.get(g));
					}
				}
				if(g==areLists.size()-1){ 
					if(temp!=null&&temp.size()>0){
						areaMap.put(zimuStr[i],temp);
					}
				}
			}
		}
		if(updateType==1){
			String dSql=" eid="+eid;
			List<DboDeaDealers> dealers =DboDeaDealersDao.where(dSql);
			updealer=dealers.get(0); 
			for(int i=0;i<areLists.size();i++){
				if(areLists.get(i).getCatalogid()==updealer.getAreaid()){
					areaflag=1;
				}
			}
			mainbrand=DboCarCatalognewDao.where(" catalogid in("+updealer.getMainbrand()+")");
			diways=updealer.getIway().split(",");
			List<DboAreCatalog> dareLists=DboAreCatalogDao.where(" catalogid="+updealer.getAreaid()+" and isdelete=0") ;
			
			List<DboAreCatalog> careLists=new ArrayList<DboAreCatalog>();
			if(areaflag==0){
				cityFatherid=dareLists.get(0).getFatherid();
				careLists=DboAreCatalogDao.where(" fatherid="+dareLists.get(0).getFatherid()+" and isdelete=0");
			}else{
				careLists=DboAreCatalogDao.where(" fatherid="+dareLists.get(0).getCatalogid()+" and isdelete=0");
			}
			cityMap=new HashMap<String, List<DboAreCatalog>>();
			for(int i=0;i<zimuStr.length;i++){
				List<DboAreCatalog> temp=new ArrayList<DboAreCatalog>(); 
				for(int g=0;g<careLists.size();g++){ 
					if(careLists.get(g).getLname()!=null&&careLists.get(g).getLname().length()>0){
						String lname=careLists.get(g).getLname().trim();
						String zimu=zimuStr[i];
						if(zimu.indexOf(lname)!=-1){
							temp.add(careLists.get(g));
						}
					}
					if(g==careLists.size()-1){ 
						if(temp!=null&&temp.size()>0){
							cityMap.put(zimuStr[i],temp);
						}
					}
				}
			}
			
		}
		eidStr=String.valueOf(eid);
		return SUCCESS;
	}
	public String getEidStr() {
		return eidStr;
	}
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}
	private String ename;
	private String shortename;
	private String mainBrandStr;
	private String iwayStr;
	private int is4s;
	private int areaid;
	//private String telephoneStr;
	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String expirationdate;
	private String passWord;
	private int ishaotuban;
	private int issuppervip;
	public void AddDealerInfo1() throws IOException, ParseException{
		
		ename=URLDecoder.decode(ename, "utf-8");
		shortename=URLDecoder.decode(shortename, "utf-8");
		iwayStr=URLDecoder.decode(iwayStr, "utf-8");
		List<Object> tList=new ArrayList<Object>();
		int paylevel=0;
		boolean flag=true;
		String msg="";
		if(updateType==1){
			
				List<DboDeaDealers> olddeaDealers=DboDeaDealersDao.where(" eid="+eid);
				String uSql=" update dbo_dea_dealers set ename='"+ename+"' ,shortename='"+shortename+"' ,mainbrand='"+mainBrandStr.substring(0,mainBrandStr.length()-1)+"' , iway='"+iwayStr.substring(0,iwayStr.length()-1)+"' , ";
				uSql=uSql+" is4s="+is4s+" , areaid="+areaid+", telephone='"+telephone+"', ";
				if(userType==1){
					uSql=uSql+" paylevel=0";
				}else if(userType==2){
					uSql=uSql+" paylevel=5 , istmp=1 ,expirationdate='"+expirationdate+" 00:00:00'";
					paylevel=5;
				}else {
					uSql=uSql+" paylevel=5 , istmp=0 ,expirationdate='"+expirationdate+" 00:00:00'";
					paylevel=5;
				}
				uSql=uSql+" ,issupervip="+issuppervip+", ishaotuban="+ishaotuban+" where eid="+eid; 
				DBConnect dbc = null; 
				try {
					dbc = new DBConnect();
					dbc.prepareStatement(uSql);
					dbc.executeUpdate();
					dbc.close();
					List<DboDeaDealers> deaDealers=DboDeaDealersDao.where(" eid="+eid);
					int jinbi=deaDealers.get(0).getJinbi();
					RedisDao.UpdateDealerInfosByEid(eid, areaid, is4s, paylevel, iwayStr.substring(0,iwayStr.length()-1), mainBrandStr.substring(0,mainBrandStr.length()-1),jinbi,olddeaDealers.get(0),deaDealers.get(0));
				} catch (Exception e) {
					e.printStackTrace();
					msg="更新失败";
					flag=false;
				} finally {
					try {
						if (dbc != null)
							dbc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
		}else{
			List<DboDntUsers> users=DboDntUsersDao.where(" username='"+username+"'");
			if(users.size()>0){
				flag=false;
				msg="用户名重复";
			}else{
				DboDeaDealers insetDealers=new DboDeaDealers();
				insetDealers.setUsername(username);
				insetDealers.setAreaid(areaid);
				insetDealers.setEname(ename);
				insetDealers.setShortename(shortename);
				insetDealers.setMainbrand(mainBrandStr.substring(0,mainBrandStr.length()-1));
				insetDealers.setIway(iwayStr.substring(0,iwayStr.length()-1));
				if(userType==1){
					insetDealers.setPaylevel(0);
				}else if (userType==2){
					insetDealers.setPaylevel(5);
					insetDealers.setIstmp(1);
				}else if (userType==3){
					insetDealers.setPaylevel(5);
					insetDealers.setIstmp(0);
				}
				insetDealers.setIs4s(is4s);
				insetDealers.setIsdelete(0);
				insetDealers.setJinbi(10);
				insetDealers.setAdddate(new Date());
				insetDealers.setPushdate(new Date());
				insetDealers.setTelephone(telephone);
				insetDealers.setLastlogintime(new Date());
				insetDealers.setIshaotuban(ishaotuban);
				insetDealers.setIssupervip(issuppervip);
				expirationdate=expirationdate+" 00:00:00";
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=sdf.parse(expirationdate);
				insetDealers.setExpirationdate(date);
				try {
					eid=InsertInfo(insetDealers);
					insetDealers.setEid(eid);
					DboDeaDealerinfo dinfo=new DboDeaDealerinfo();
					dinfo.setEid(eid);
					dinfo.setIsdelete(0);
					dinfo.setAddress(" ");
					dinfo.setIntro(" ");
					dinfo.setH_lat("0");
					dinfo.setH_lng("0");
					DboDeaDealerinfoDao.save(dinfo);
					DboDntUsers users2=new DboDntUsers();
					users2.setUsername(username);
					users2.setNickname(username);
					users2.setPassword(passWord);
					users2.setJoindate(new Date());
					users2.setLastactivity(new Date());
					users2.setLastpost(new Date());
					users2.setLastvisit(new Date());
					int uid=InsertUinfo(users2);
					users2.setUid(uid);
					Map<String, String> aaMap= ObjectToMapUtil.changeToMap(users2);
					DboDntUserlevel userlevel=new DboDntUserlevel();
					userlevel.setUid(uid);
					userlevel.setEid(eid);
					userlevel.setUlevel(1);
					userlevel.setIsdelete(0);
					Map<String,String> bb=ObjectToMapUtil.changeToMap(userlevel);
					DboDntUserlevelDao.save(userlevel); 
					Map<String, String> mp=ObjectToMapUtil.changeToMap(insetDealers);
					RedisDao.inSertDealersByEid(insetDealers,mp);
					Map<String, String> mp1=ObjectToMapUtil.changeToMap(dinfo);
					RedisDao.insertDealerInfoByEid(mp1,eid);
					RedisDao.UpdateDealerInfoByUid(uid,username,aaMap);
					RedisDao.UpdateUserLevelByUid(uid,eid,bb);
					flag=true; 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					flag=false;
					msg="更新失败";
					e.printStackTrace();
				}
			}
		}
		tList.add(flag);
		if(!flag&&updateType!=1){
			tList.add(msg);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json=JSONArray.fromObject(tList);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
		
	}
	
	public int getIssuppervip() {
		return issuppervip;
	}
	public void setIssuppervip(int issuppervip) {
		this.issuppervip = issuppervip;
	}
	public int InsertUinfo(DboDntUsers dbodntusers){
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
			String sql = "insert into dbo_dnt_users(`uid`,`username`,`nickname`,`password`,`secques`,`spaceid`,`gender`,`adminid`,`groupid`,`groupexpiry`,`extgroupids`,`regip`,`joindate`,`lastip`,`lastvisit`,`lastactivity`,`lastpost`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con = DBConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dbodntusers.getUid());
			pstmt.setString(2, dbodntusers.getUsername());
			pstmt.setString(3, dbodntusers.getNickname());
			pstmt.setString(4, dbodntusers.getPassword());
			pstmt.setString(5, dbodntusers.getSecques());
			pstmt.setInt(6, dbodntusers.getSpaceid());
			pstmt.setInt(7, dbodntusers.getGender());
			pstmt.setInt(8, dbodntusers.getAdminid());
			pstmt.setInt(9, dbodntusers.getGroupid());
			pstmt.setInt(10, dbodntusers.getGroupexpiry());
			pstmt.setString(11, dbodntusers.getExtgroupids());
			pstmt.setString(12, dbodntusers.getRegip());
			pstmt.setTimestamp(13, new Timestamp(dbodntusers.getJoindate().getTime()));
			pstmt.setString(14, dbodntusers.getLastip());
			pstmt.setTimestamp(15, new Timestamp(dbodntusers.getLastvisit().getTime()));
			pstmt.setTimestamp(16, new Timestamp(dbodntusers.getLastactivity().getTime()));
			pstmt.setTimestamp(17, new Timestamp(dbodntusers.getLastpost().getTime()));
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
				result = rs.getInt(1);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return result;
	}
	
	public int InsertInfo(DboDeaDealers dbodeadealers){
		
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
		String sql = "insert into dbo_dea_dealers(`eid`,`paylevel`,`areaid`,`modelid`,`shortename`,`mainbrand`,`username`,`ename`,`domain`,`indexhotnewssetting`,`isdelete`,`adddate`,`areaids`,`telephone`,`expirationdate`,`isbitauto`,`is4s`,`isbitautoprice`,`seposttableid`,`address`,`addbbs`,`maxpushid`,`pushdate`,`bmbasiccount`,`iway`,`issenior`,`remarks`,`isvip`,`jinbi`,`isfinishinfo`,`isfirstbindmobile`,`lastlogintime`,`ishaotuban`,`istmp`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		con = DBConnectionManager.getInstance().getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dbodeadealers.getEid());
		pstmt.setInt(2, dbodeadealers.getPaylevel());
		pstmt.setInt(3, dbodeadealers.getAreaid());
		pstmt.setInt(4, dbodeadealers.getModelid());
		pstmt.setString(5, dbodeadealers.getShortename());
		pstmt.setString(6, dbodeadealers.getMainbrand());
		pstmt.setString(7, dbodeadealers.getUsername());
		pstmt.setString(8, dbodeadealers.getEname());
		pstmt.setString(9, dbodeadealers.getDomain());
		pstmt.setInt(10, dbodeadealers.getIndexhotnewssetting());
		pstmt.setInt(11, dbodeadealers.getIsdelete());
		pstmt.setTimestamp(12, new Timestamp(dbodeadealers.getAdddate().getTime()));
		pstmt.setString(13, dbodeadealers.getAreaids());
		pstmt.setString(14, dbodeadealers.getTelephone());
		pstmt.setTimestamp(15, new Timestamp(dbodeadealers.getExpirationdate().getTime()));
		pstmt.setInt(16, dbodeadealers.getIsbitauto());
		pstmt.setInt(17, dbodeadealers.getIs4s());
		pstmt.setInt(18, dbodeadealers.getIsbitautoprice());
		pstmt.setInt(19, dbodeadealers.getSeposttableid());
		pstmt.setString(20, dbodeadealers.getAddress());
		pstmt.setInt(21, dbodeadealers.getAddbbs());
		pstmt.setInt(22, dbodeadealers.getMaxpushid());
		pstmt.setTimestamp(23, new Timestamp(dbodeadealers.getPushdate().getTime()));
		pstmt.setInt(24, dbodeadealers.getBmbasiccount());
		pstmt.setString(25, dbodeadealers.getIway());
		pstmt.setInt(26, dbodeadealers.getIssenior());
		pstmt.setString(27, dbodeadealers.getRemarks());
		pstmt.setInt(28, dbodeadealers.getIsvip());
		pstmt.setInt(29, dbodeadealers.getJinbi());
		pstmt.setInt(30, dbodeadealers.getIsfinishinfo());
		pstmt.setInt(31, dbodeadealers.getIsfirstbindmobile());
		pstmt.setTimestamp(32, new Timestamp(dbodeadealers.getLastlogintime().getTime()));
		pstmt.setInt(33, dbodeadealers.getIshaotuban());
		pstmt.setInt(34, dbodeadealers.getIstmp());
		pstmt.executeUpdate();
		rs = pstmt.getGeneratedKeys();
		if(rs.next())
			result = rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getIshaotuban() {
		return ishaotuban;
	}

	public void setIshaotuban(int ishaotuban) {
		this.ishaotuban = ishaotuban;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getShortename() {
		return shortename;
	}

	public void setShortename(String shortename) {
		this.shortename = shortename;
	}

	public String getMainBrandStr() {
		return mainBrandStr;
	}

	public void setMainBrandStr(String mainBrandStr) {
		this.mainBrandStr = mainBrandStr;
	}

	public String getIwayStr() {
		return iwayStr;
	}

	public void setIwayStr(String iwayStr) {
		this.iwayStr = iwayStr;
	}

	public int getIs4s() {
		return is4s;
	}

	public void setIs4s(int is4s) {
		this.is4s = is4s;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	

	public String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String[] getDiways() {
		return diways;
	}

	public void setDiways(String[] diways) {
		this.diways = diways;
	}

	public List<DboCarCatalognew> getMainbrand() {
		return mainbrand;
	}

	public void setMainbrand(List<DboCarCatalognew> mainbrand) {
		this.mainbrand = mainbrand;
	}

	public DboDeaDealers getUpdealer() {
		return updealer;
	}

	public void setUpdealer(DboDeaDealers updealer) {
		this.updealer = updealer;
	}

	public int getUpdateType() {
		return updateType;
	}

	public void setUpdateType(int updateType) {
		this.updateType = updateType;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Map<String, List<DboAreCatalog>> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, List<DboAreCatalog>> cityMap) {
		this.cityMap = cityMap;
	}

	public int getCityFatherid() {
		return cityFatherid;
	}

	public void setCityFatherid(int cityFatherid) {
		this.cityFatherid = cityFatherid;
	}

	public List<Map<String, String>> getDealers() {
		return dealers;
	}

	public void setDealers(List<Map<String, String>> dealers) {
		this.dealers = dealers;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	private int areaId;
	public void GetCityListByAreaId() throws IOException{
		Map<String, List<DboAreCatalog>> cityMap=new HashMap<String, List<DboAreCatalog>>();
		List<DboAreCatalog> areaLists=DboAreCatalogDao.where(" fatherid="+areaId+" and isdelete=0");
		for(int i=0;i<zimuStr.length;i++){
			List<DboAreCatalog> temp=new ArrayList<DboAreCatalog>(); 
			for(int g=0;g<areaLists.size();g++){ 
				if(areaLists.get(g).getLname()!=null&&areaLists.get(g).getLname().length()>0){
					String lname=areaLists.get(g).getLname().trim();
					String zimu=zimuStr[i];
					if(zimu.indexOf(lname)!=-1){
						temp.add(areaLists.get(g));
					}
				}
				if(g==areaLists.size()-1){ 
					if(temp!=null&&temp.size()>0){
						cityMap.put(zimuStr[i],temp);
					}
				}
			}
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json=JSONArray.fromObject(cityMap);
		String jsonp=request.getParameter("jsonpcallback");
		out.print(jsonp+"("+json.toString()+")");
	}
	
	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String[] getZimuStr() {
		return zimuStr;
	}
	public void setZimuStr(String[] zimuStr) {
		this.zimuStr = zimuStr;
	}
	public Map<String, List<DboAreCatalog>> getAreaMap() {
		return areaMap;
	}
	public void setAreaMap(Map<String, List<DboAreCatalog>> areaMap) {
		this.areaMap = areaMap;
	}
	public Map<String, List<Map<String, String>>> getBrandMap() {
		return brandMap;
	}
	public void setBrandMap(Map<String, List<Map<String, String>>> brandMap) {
		this.brandMap = brandMap;
	}
}
