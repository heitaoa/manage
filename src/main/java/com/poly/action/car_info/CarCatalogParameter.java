package com.poly.action.car_info;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.DboCarAutohomeprop;
import car_beans.DboCarCatalognew;
import car_beans.DboCarInfo;
import car_daos.BaseDao;
import car_daos.DBConnect;
import car_daos.DboCarAutohomepropDao;
import car_daos.DboCarCatalognewDao;
import car_daos.DboCarInfoDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.service.NewsAdmService;
import com.poly.util.DeleteCarParamFileUtil;
import com.poly.util.FieldUtil;
import com.poly.util.GetPy;
import com.poly.util.ImageFormatMethod;
import com.redis.RedisDao;
import com.redis.RedisParseUtil;

import freemarker.template.TemplateModelException;

public class CarCatalogParameter extends MyActionSupport{

	private int id;
	private DboCarCatalognew carCatalog;
	private String live;
	private String sale;
	private String eName;
	private String carkey;
	private String pengzhuanglevel;
	private String baoyangfeiyong;
	private String disadvantage;
	private String advantage;
	private String iyear;
	private String xiangti;
	private String bsq;
	private String jibie;
	private String madein;
	private String leixing;
	private String fadongji;
	private String pailiang;
	private String photo;
	private String chetuanphoto;
	private String pinpai;
	private String qudao;
	private int car_type;
	private int danwei;
	private String mainphoto;

	public int getDanwei() {
		return danwei;
	}

	public void setDanwei(int danwei) {
		this.danwei = danwei;
	}

	public int getCar_type() {
		return car_type;
	}

	public void setCar_type(int car_type) {
		this.car_type = car_type;
	}

	public String getQudao() {
		return qudao;
	}

	public void setQudao(String qudao) {
		this.qudao = qudao;
	}

	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}

	public String  execute(){
		return SUCCESS;
	}
	
	public void CarCatalogParameterA() throws IOException{
		String cSql="catalogid = "+id;
		List<DboCarCatalognew> list=DboCarCatalognewDao.where(cSql);
		carCatalog=list.get(0);
		List<DboCarInfo> carlist=DboCarInfoDao.where(cSql);
		if(carlist.size()>0){
			carCatalog.setCarInfo(carlist.get(0));
		}else{
			int carInfoId=SeqDao.getNextId("dbo_car_info");
			DboCarInfo carInfo=new DboCarInfo();
			carInfo.setId(carInfoId);
			carInfo.setCatalogid(id);
			try{
				DboCarInfoDao.save(carInfo);
			}catch(Exception e){
				e.printStackTrace();
			}
			List<DboCarInfo> carlist2=DboCarInfoDao.where(cSql);
			carCatalog.setCarInfo(carlist2.get(0));
		}
		String dSql="carid = "+carCatalog.getCatalogid();
		DboCarAutohomeprop carMan=new DboCarAutohomeprop();
		List<DboCarAutohomeprop> list2=DboCarAutohomepropDao.where(dSql);
		if(carCatalog.getPathlevel()==3){
			if(list2.size()>0){
				carMan=list2.get(0);
			}else{
				int cid=SeqDao.getNextId("dbo_car_autohomeprop");
				carMan.setId(cid);
				carMan.setCarid(id);
				carMan.setP1(carCatalog.getCatalogname());
				carMan.setCar_type(0);
				try{
					DboCarAutohomepropDao.save(carMan);
					//RedisParseUtil.jedisPublish("inster", "dbo_car_autohomeprop", Integer.toString(cid));
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		ImageFormatMethod iMethod=new ImageFormatMethod();
		List<String> pList=new ArrayList<String>();
		if(carCatalog.getPathlevel()==1){
			pList.add(carCatalog.getPhoto());
			pList.add("0");
			pList.add("0");
		}else {
			pList.add(carCatalog.getPhoto());
			pList.add("130");
			pList.add("130");
		}
		
		List<String> pList1=new ArrayList<String>();
		pList1.add(carCatalog.getCarbrandphoto());
		pList1.add("130");
		pList1.add("130");
		List<String> pList2=new ArrayList<String>();
		pList2.add(carCatalog.getChetuanphoto());
		pList2.add("130");
		pList2.add("130");
		try {
			if(pList.get(0)!=null){
				String path=(String)iMethod.exec(pList);
				carCatalog.setPhoto(path);
			} 
			if(pList1.get(0)!=null){
				String path1=(String)iMethod.exec(pList1);
				carCatalog.setCarbrandphoto(path1);
			}
			if(pList2.get(0)!=null){
				String path2=(String)iMethod.exec(pList2);
				carCatalog.setChetuanphoto(path2);
			}
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList map=new ArrayList(); 
		map.add(carCatalog);
		map.add(carMan);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		//String jsonp=request.getParameter("jsonpcallback");
		out.print(json.toString());
		out.close();
	}
	
	public String SaveA(){
		try{
			DboCarCatalognew catalog=new DboCarCatalognew();
			List<DboCarCatalognew> oldCatalognews=DboCarCatalognewDao.where(" catalogid="+id);
			if(!FieldUtil.isEmpty(live)){
				catalog.setIslive(Integer.parseInt(live));
			}
			if(!FieldUtil.isEmpty(sale)){
				catalog.setOnsale(Integer.parseInt(sale));
			}
			if(!FieldUtil.isEmpty(eName)){
				catalog.setEnglishname(eName);
			}
			if(!FieldUtil.isEmpty(photo)){
				catalog.setPhoto(photo); 
			}
			if(!FieldUtil.isEmpty(mainphoto)){
				catalog.setCarbrandphoto(mainphoto);
			}
			catalog.setCatalogid(id);
			DboCarCatalognewDao.update(catalog);
			List<DboCarCatalognew> newCatalognews=DboCarCatalognewDao.where(" catalogid="+id);
			RedisDao.UpDateCatalognowBySaveA(id,Integer.parseInt(live),Integer.parseInt(sale),eName,photo,mainphoto,oldCatalognews.get(0),newCatalognews.get(0));
			int pathLevel=newCatalognews.get(0).getPathlevel();
			System.out.println("startDate1-------------->"+System.currentTimeMillis());
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(newCatalognews.get(0).getFatherid());
				//NewsAdmService.delNewsHtmlByCarcatalogid(id);
				DeleteCarParamFileUtil.deleteFile(newCatalognews.get(0).getFatherid(), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}else{
				Map<String, String> Brand=RedisDao.getCatalognewById(newCatalognews.get(0).getFatherid());
				//NewsAdmService.delNewsHtmlByCarcatalogid(newCatalognews.get(0).getFatherid());
				DeleteCarParamFileUtil.deleteFile(newCatalognews.get(0).getFatherid(), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}
			
			//RedisParseUtil.jedisPublish("update", "dbo_car_catalognew", String.valueOf(id));
			System.out.println("endDate1-------------->"+System.currentTimeMillis());
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
public String getMainphoto() {
		return mainphoto;
	}

	public void setMainphoto(String mainphoto) {
		this.mainphoto = mainphoto;
	}

	//	//live:live,
//	sale:sale,
//	eName:eName,
//	carkey:carkey,
//	pengzhuanglevel:pengzhuanglevel,
//	baoyangfeiyong:baoyangfeiyong,
//	disadvantage:disadvantage,
//	advantage:advantage
	public String SaveB(){
		try{
			DboCarCatalognew catalog=new DboCarCatalognew();
			List<DboCarCatalognew> oldCarCatalognews=DboCarCatalognewDao.where(" catalogid="+id);
			if(!FieldUtil.isEmpty(live)){
				catalog.setIslive(Integer.parseInt(live));
			}
			if(!FieldUtil.isEmpty(sale)){
				catalog.setOnsale(Integer.parseInt(sale));
			}
			if(!FieldUtil.isEmpty(eName)){	
				catalog.setEnglishname(eName);
			}
			if(!FieldUtil.isEmpty(carkey)){
				catalog.setCarkey(carkey);
			}
			if(!FieldUtil.isEmpty(leixing)){
				catalog.setLeixing(Integer.parseInt(leixing));
			}
			if(!FieldUtil.isEmpty(jibie)){
				catalog.setJibie(Integer.parseInt(jibie));
			}
			if(!FieldUtil.isEmpty(pengzhuanglevel)){
				catalog.setPengzhuanglevel(Integer.parseInt(pengzhuanglevel));
			}
			if(!FieldUtil.isEmpty(baoyangfeiyong)){
				catalog.setBaoyangfeiyong(Integer.parseInt(baoyangfeiyong));
			}
			if(!FieldUtil.isEmpty(photo)){
				catalog.setPhoto(photo);
			}
			if(!FieldUtil.isEmpty(chetuanphoto)){
				catalog.setChetuanphoto(chetuanphoto);
			}
			if(!FieldUtil.isEmpty(qudao)){
				catalog.setIway(qudao);
			}
			catalog.setCatalogid(id);
			String szm="";
			if(!FieldUtil.isEmpty(qudao)){
				szm=GetPy.getGBKpy(qudao).toUpperCase().substring(0,1);
				catalog.setWayname(szm);
			}
			DboCarCatalognewDao.update(catalog);
			List<DboCarCatalognew> newCatalognews=DboCarCatalognewDao.where(" catalogid="+id);
			RedisDao.UpDateCatalognowBySaveB(id, live, sale, eName, carkey, leixing,jibie,pengzhuanglevel,baoyangfeiyong ,photo,qudao,oldCarCatalognews.get(0), newCatalognews.get(0));
			//RedisParseUtil.jedisPublish("update", "dbo_car_catalognew", String.valueOf(id));
			//String szm=GetPy.getGBKpy(qudao).toUpperCase().substring(0,1);
			String fSql="update dbo_car_catalognew set iway = '"+ qudao+"' , wayname = '" + szm+"' where fatherid = "+id;
			BaseDao.execute(fSql);
			RedisDao.UpDateCatalognowBySaveBqudao(id, qudao, szm, oldCarCatalognews.get(0), newCatalognews.get(0));
//			List<DboCarCatalognew> flist=DboCarCatalognewDao.where(" fatherid= "+id);
//			List<Integer> carids=new ArrayList<Integer>();
//			for(int i=0;i<flist.size();i++){
//				//RedisParseUtil.jedisPublish("update", "dbo_car_catalognew", String.valueOf(flist.get(i).getCatalogid()));
//				carids.add(flist.get(i).getCatalogid());
//			}
			String autoSql="update dbo_car_autohomeprop a,dbo_car_catalognew b set a.iway=b.iway where a.carid=b.catalogid and b.fatherid= "+id;
			BaseDao.execute(autoSql);
			RedisDao.UpDateAutohomepropBySaveBqudao(id, qudao);
//			for(int j=0;j<carids.size();j++){
//				RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(carids.get(j)));
//			}
//			String autohomeinfo="update dbo_car_autohomeprop set iway = '"+qudao+"' where carid="+id;
//			BaseDao.execute(autohomeinfo);
//			List<DboCarAutohomeprop> aotolist=DboCarAutohomepropDao.where(" carid= "+id);
//			RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(aotolist.get(0).getId()));
			String sSql="catalogid = "+id;
			DboCarInfo carInfo=DboCarInfoDao.where(sSql).get(0);
			DboCarInfo carinfo=new DboCarInfo();
			if(!FieldUtil.isEmpty(advantage)){
				carinfo.setAdvantage(advantage);
			}
			if(!FieldUtil.isEmpty(disadvantage)){
				carinfo.setDisadvantage(disadvantage);
			}
			carinfo.setId(carInfo.getId());
			DboCarInfoDao.update(carinfo);
			int pathLevel=newCatalognews.get(0).getPathlevel();
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(newCatalognews.get(0).getFatherid());
				//NewsAdmService.delNewsHtmlByCarcatalogid(id);
				DeleteCarParamFileUtil.deleteFile(newCatalognews.get(0).getFatherid(), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}else{
				Map<String, String> Brand=RedisDao.getCatalognewById(newCatalognews.get(0).getFatherid());
				//NewsAdmService.delNewsHtmlByCarcatalogid(newCatalognews.get(0).getFatherid());
				DeleteCarParamFileUtil.deleteFile(newCatalognews.get(0).getFatherid(), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}
			//RedisParseUtil.jedisPublish("update", "dbo_car_info", String.valueOf(carInfo.getId()));
			setAjax("1");
		}catch(Exception e){
			e.printStackTrace();
			setAjax("0");
		}
		return AJAX;
	}
	
public String getChetuanphoto() {
		return chetuanphoto;
	}

	public void setChetuanphoto(String chetuanphoto) {
		this.chetuanphoto = chetuanphoto;
	}

	//	id:id,
//	live:live,
//	sale:sale,
//	eName:eName,
//	iyear:iyear,
//	xiangti:xiangti,
//	bsq:bsq,
//	jibie:jibie,
//	madein:madein,
//	leixing:leixing,
//	fadongji:fadongji,
//	pailiang:pailiang
	public String SaveC(){
		try{
			DboCarCatalognew catalog=new DboCarCatalognew();
			List<DboCarCatalognew> oldCarCatalognews=DboCarCatalognewDao.where(" catalogid="+id);
				catalog.setIslive(Integer.parseInt(live));
			
			
				catalog.setOnsale(Integer.parseInt(sale));
			
				catalog.setIyear(Integer.parseInt(iyear));
			
				catalog.setXiangti(Integer.parseInt(xiangti));
			
				catalog.setBsq(Integer.parseInt(bsq));
			
				catalog.setJibie(Integer.parseInt(jibie));
			
				catalog.setMadein(Integer.parseInt(madein));
			
				catalog.setLeixing(Integer.parseInt(leixing));
			
				catalog.setFadongji(Integer.parseInt(fadongji));
			
				catalog.setEnglishname(eName);
			
				catalog.setPailiang(Integer.parseInt(pailiang));
			
			if(!FieldUtil.isEmpty(photo)){
				catalog.setPhoto(photo);
			}
			if(!FieldUtil.isEmpty(qudao)){
				catalog.setIway(qudao);
				String szm=GetPy.getGBKpy(qudao).toUpperCase().substring(0,1);
				catalog.setWayname(szm);
			}
			catalog.setCatalogid(id);
			DboCarCatalognewDao.update(catalog);
			List<DboCarCatalognew> newCatalognews=DboCarCatalognewDao.where(" catalogid="+id);
			RedisDao.UpDateCatalognowBySaveC(id, live, sale,iyear,xiangti,bsq,jibie,madein,leixing,fadongji,eName,pailiang, photo, qudao, oldCarCatalognews.get(0), newCatalognews.get(0));
			//RedisParseUtil.jedisPublish("update", "dbo_car_catalognew", String.valueOf(id));
			List<DboCarAutohomeprop> autohomeList=DboCarAutohomepropDao.where(" carid = "+id);
			int autohomeId=0;
			if(autohomeList.size()>0){
				autohomeId=autohomeList.get(0).getId();
			}else{
				DboCarAutohomeprop car=new DboCarAutohomeprop();
				int cid=SeqDao.getNextId("dbo_car_autohomeprop");
				String ids=String.valueOf(id);
				List<DboCarCatalognew> cList=DboCarCatalognewDao.where("catalogid ="+id);
				String name=cList.get(0).getCatalogname();
				car.setId(cid);
				car.setP1(name);
				car.setCarid(id);
				try{
					DboCarAutohomepropDao.save(car);
					autohomeId=cid;
					//RedisParseUtil.jedisPublish("inster", "dbo_car_autohomeprop", ids);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			DboCarAutohomeprop autohome=new DboCarAutohomeprop();
			autohome.setId(autohomeId);
			if(danwei!=0){
				if(danwei==1){
					autohome.setP209("T");
				}else if(danwei==2){
					autohome.setP209("L");
				}
			}
			autohome.setP3(pinpai);
			autohome.setIway(qudao);
			autohome.setCar_type(car_type);
			DboCarAutohomepropDao.update(autohome);
			RedisDao.UpDateAutohomepropBySaveC(id, autohome);
			int pathLevel=newCatalognews.get(0).getPathlevel();
			if(pathLevel==1){
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}else if(pathLevel==2){
				Map<String, String> Brand=RedisDao.getCatalognewById(newCatalognews.get(0).getFatherid());
				
				DeleteCarParamFileUtil.deleteFile(newCatalognews.get(0).getFatherid(), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}else{
				Map<String, String> Brand=RedisDao.getCatalognewById(newCatalognews.get(0).getFatherid());
				//NewsAdmService.delNewsHtmlByCarcatalogid(newCatalognews.get(0).getFatherid());
				DeleteCarParamFileUtil.deleteFile(newCatalognews.get(0).getFatherid(), Brand.get("englishname"));
				DeleteCarParamFileUtil.deleteFile(id, newCatalognews.get(0).getEnglishname());
			}
			//RedisParseUtil.jedisPublish("update", "dbo_car_autohomeprop", String.valueOf(autohomeId));
			setAjax("1");
		}catch(Exception e){
			setAjax("0");
		}
		return AJAX;
	}
	
	public DboCarCatalognew getCarCatalog(){
		return carCatalog;
	}
	public void setCarCatalog(DboCarCatalognew carCatalog){
		this.carCatalog=carCatalog;
	}
	
	public String getIyear(){
		return iyear;
	}
	public void setIyear(String iyear){
		this.iyear=iyear;
	}
	
	public String getXiangti(){
		return xiangti;
	}
	public void setXiangti(String xiangti){
		this.xiangti=xiangti;
	}
	public String getBsq(){
		return bsq;
	}
	public void setBsq(String bsq){
		this.bsq=bsq;
	}
	public String getJibie(){
		return jibie;
	}
	public void setJibie(String jibie){
		this.jibie=jibie;
	}
	public String getMadein(){
		return madein;
	}
	public void setMadein(String madein){
		this.madein=madein;
	}
	public String getLeixing(){
		return leixing;
	}
	public void setLeixing(String leixing){
		this.leixing=leixing;
	}
	public String getFadongji(){
		return fadongji;
	}
	public void setFadongji(String fadongji){
		this.fadongji=fadongji;
	}
	public String getPailiang(){
		return pailiang;
	}
	public void setPailiang(String pailiang){
		this.pailiang=pailiang;
	}
	
	
	public String getAdvantage(){
		return advantage;
	}
	public void setAdvantage(String advantage){
		this.advantage=advantage;
	}
	
	public String getDisadvantage(){
		return disadvantage;
	}
	public void setDisadvantage(String disadvantage){
		this.disadvantage=disadvantage;
	}
	
	public String getBaoyangfeiyong(){
		return baoyangfeiyong;
	}
	public void setBaoyangfeiyong(String baoyangfeiyong){
		this.baoyangfeiyong=baoyangfeiyong;
	}
	
	public String getPengzhuanglevel(){
		return pengzhuanglevel;
	}
	public void setPengzhuanglevel(String pengzhuanglevel){
		this.pengzhuanglevel=pengzhuanglevel;
	}
	
	public String getCarkey(){
		return carkey;
	}
	public void setCarkey(String carkey){
		this.carkey=carkey;
	}
	
	public String getEName(){
		return eName;
	}
	public void setEName(String eName){
		this.eName=eName;
	}
	
	public String getLive(){
		return live;
	}
	public void setLive(String live){
		this.live=live;
	}
	
	public String getSale(){
		return sale;
	}
	public void setSale(String sale){
		this.sale=sale;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}	
}
