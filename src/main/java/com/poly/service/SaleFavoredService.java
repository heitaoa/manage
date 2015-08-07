package com.poly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.poly.dao.subDaos.TbCarGroupbuyDaoSubDao;

import car_beans.DboCarCatalognew;
import car_beans.DboDeaDealers;
import car_beans.TbCarGroupbuy;
import car_daos.DboCarCatalognewDao;
import car_daos.DboDeaDealersDao;
import car_daos.TbCarGroupbuyDao;


public class SaleFavoredService {
	public enum StationType{
		sh("1","上海站"),
		bj("2","北京站"),
		gz("3","广州站"),
		nj("4","南京站"),
		wh("5","武汉站"),
		cd("6","成都站"),
		sy("7","沈阳站"),
		dl("8","大连站"),
		hf("9","合肥站"),
		hz("10","杭州站"),
		sz("11","苏州站"),
		xz("12","徐州站");
		private String id;
		private String type;
		private StationType(String id,String type) {
			this.id = id;
			this.type = type;
		}
		public static StationType getEnum(String id){
			for (StationType st : StationType.values()) {
				if (st.getId().equals(id)) {
					return st;
				}
			}
			return null;
		}
		public String getId() {
			return id;
		}
		public String getType() {
			return type;
		}
		
		
	}
	public static final SaleFavoredService instance = new SaleFavoredService();
	public static SaleFavoredService getInstance() {
		return instance;
	}
	DboCarCatalognewDao dboCarCatalognewDao = new DboCarCatalognewDao();
	TbCarGroupbuyDao tbCarGroupbuyDao = new TbCarGroupbuyDao();
	DboDeaDealersDao dboDeaDealersDao =  new DboDeaDealersDao();
	TbCarGroupbuyDaoSubDao tbCarGroupbuyDaoSubDao = new TbCarGroupbuyDaoSubDao();
	public List<HashMap<String, Object>> getCarBrand2(){
		//String sql = "fatherid = 0 and isdelete = 0 order by lname";
		//return dboCarCatalognewDao.where(sql);
		return tbCarGroupbuyDaoSubDao.getCarBrand();
	}
	public List<DboCarCatalognew> getCarBrand(){
		String sql = "fatherid = 0 order by lname";
		return dboCarCatalognewDao.where(sql);
		//return tbCarGroupbuyDaoSubDao.getCarBrand();
	}
	public List<DboCarCatalognew> getCarBrandByFatherId(int fatherid){
		String sql = "isdelete = 0 and  fatherid = "+fatherid+"  order by lname";
		return dboCarCatalognewDao.where(sql);
	}
	public List<DboCarCatalognew> getCarBrandByFatherId2(int fatherid){
		String sql = "isdelete = 0 and onsale = 1 and  fatherid = "+fatherid+"  order by lname";
		return dboCarCatalognewDao.where(sql);
	}
	public List<DboCarCatalognew> getCarBrandByFatherIdx(String name){
		String sql = "iway = '"+name+"' and pathlevel = 2  ORDER BY lname ";
		return dboCarCatalognewDao.where(sql);
	}
	public List<DboCarCatalognew> getCarBrandByFatherIdx2(String name){
		String sql = "iway = '"+name+"' and pathlevel = 2 and isdelete = 0 ORDER BY lname ";
		return dboCarCatalognewDao.where(sql);
	}
	public List<DboCarCatalognew> getCarByFatherId(int fatherid){
		return dboCarCatalognewDao.where(" fatherid ="+fatherid);
		//return tbCarGroupbuyDaoSubDao.getCarBrandByFatherId(fatherid);
	}
	
	public int saveCarGroupBuy(TbCarGroupbuy tbCarGroupbuy) throws Exception{
		return tbCarGroupbuyDao.save(tbCarGroupbuy);
	}
	
	public List<HashMap<String, Object>> getDeaDealers(int start, int rows, String dea){
		return tbCarGroupbuyDaoSubDao.getDeaDealers(start, rows, dea);
	}
	
	public List<HashMap<String, Object>> getAllCarGroup(int start,int rows,String keywords,int type,String pinpai,String stationId,String isdelete){
		return tbCarGroupbuyDaoSubDao.getAllCarGroup(start, rows,keywords,type,pinpai,stationId,isdelete);
	}
	

	public Map<String,Object> getCarGroupById(int id){
		return tbCarGroupbuyDaoSubDao.getCarGroupById(id);
	}
	
	public int updateCarGroupBuy(TbCarGroupbuy tbcargroupbuy){
		return tbCarGroupbuyDao.update(tbcargroupbuy);
	}
	
	public String getIway (int catalogid){
		String iways = "";
		List<DboCarCatalognew> iway =  dboCarCatalognewDao.where(" catalogid = "+catalogid);
		if(iway.size()>0)
			iways =  iway.get(0).getIway()==null?"":iway.get(0).getIway();
		return iways;
	}
	public void updateGroupState(int id,int state){
		tbCarGroupbuyDaoSubDao.updateGroupState(id, state);
	}
	public void updateGroupState2(int id){
		tbCarGroupbuyDaoSubDao.updateGroupState2(id);
	}
	public HashMap<String, String> getPre(String id ){
		return tbCarGroupbuyDaoSubDao.getPre(id);
	}
}
