package com.poly.util.syncapplyinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.util.StringUtils;

import car_beans.DboCarCatalognew;

public class ConvertData {
	
	static Connection conn194 = null;
	
	static Connection conn249 = null;
	
	static Connection conn113 = null;
	
	public static int SIZE = 100;
	public static int MAX = 300000;
	
	
	static List<DboCarCatalognew> pingpaiList = null;
	static List<DboCarCatalognew> chexingList = null;
	static List<DboCarCatalognew> chexiList = null;
	
	static {
		DboCarCatalognewDao dboCarCatalognewDao = new DboCarCatalognewDao();
		String pingpaiSql = "  fatherid = 0 and isdelete=0";
		pingpaiList = dboCarCatalognewDao.where(pingpaiSql);
		String chexingSql = "  pathlevel = 3 and isdelete=0 ";
		chexingList = dboCarCatalognewDao.where(chexingSql);
		String chexiSql = " pathlevel = 2  and isdelete=0";
		chexiList = dboCarCatalognewDao.where(chexiSql);

	}

	static void init() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		//	conn249 = DriverManager.getConnection("jdbc:mysql://192.168.1.249:3306/yichedata?useUnicode=true&characterEncoding=UTF-8", "main", "main");
			conn113 = DriverManager.getConnection("jdbc:mysql://115.159.56.197:3306/car_315?useUnicode=true&characterEncoding=UTF-8", "admin", "root178ZXC");
			//conn113 = DriverManager.getConnection("jdbc:mysql://182.254.131.113:3306/car_315?useUnicode=true&characterEncoding=UTF-8", "admin", "root178ZXC");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetuan?useUnicode=true&characterEncoding=UTF-8", "root", "");
			conn194 = DriverManager.getConnection("jdbc:mysql://182.254.147.194:3306/car?useUnicode=true&characterEncoding=UTF-8", "admin", "root178ZXC");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		init();
		//MAX=100;
		//SIZE=100;
		boolean flag = true;
		for(int i=0;i<MAX/SIZE&&flag;i++){
			List<HashMap<String, String>> list = findOldData(i*SIZE,100);
			if(list.size()<100){
				flag = false;
			}
			for(HashMap<String, String> map:list){
				String pingpai = map.get("pinpai");
				String chexing = map.get("chexing");
				String modelid = map.get("modelid");
				int brandid =0;
				if(pingpai!=null){
					brandid = getPingpaiId(pingpai, map);
				}else{
					System.out.println("品牌为空："+map.get("id"));
				}
				int conflg = convertId(modelid,map);
				
				if(chexing != null && conflg==0){
					int chexingid = getChexingId(chexing, brandid, map);
				}else{
					//System.out.println("车型为空："+map.get("id"));
				}
			}
			insertOrUpdate(list);
		}
		
	}
	
	
	
	
	

	private static void insertOrUpdate(List<HashMap<String, String>> list) {
		for(HashMap<String, String> map:list){
			StringBuffer sql = new StringBuffer();
			String query = "select * from tb_data_baoming where oldid="+map.get("id");
			try{
				PreparedStatement pstmt = conn113.prepareStatement(query.toString());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					if (rs.getString("return_visit_time") != null) {
						if(map.get("return_visit_time") == null){
							  // System.out.println("跳过id："+map.get("id"));
						    	continue;
						}
						if (rs.getString("return_visit_time").compareToIgnoreCase(map.get("return_visit_time")) >= 0) {
							continue;
						}
						}
					if(rs.getString("return_visit_time") == null && map.get("return_visit_time") == null ) {
						continue;
					}
					sql = sql.append("update tb_data_baoming set   brand=?,   serial=?,   model=?,   name=?,   phone=?,  prov=?,   city=?,   baoming_date=?,   car_info=?,phone_prov=?,   phone_city=?,  ip=?,  "
							+ "return_visit_state=?,  is_key_cus=?,  phoneerror=?,  return_visit_time=?,  return_visit_content=?,  remarks=?,   return_visit_man=?,   tuisong_flag=?,   isDelete=?,  attend_type=?,   attend_date=?,  "
							+ " phone_state=?,  is_buycar=?,  phoneerror_count=?,  area=?,   real_type=?,   constacterror=?,  "
							+ " constacterror_count=?  where oldid=?");
					
				}else{
					sql = sql.append("INSERT INTO tb_data_baoming ( brand, serial, model, name, phone, prov, city, "
							+ "baoming_date, car_info, phone_prov, phone_city, ip, return_visit_state, is_key_cus, phoneerror,"
							+ " return_visit_time, return_visit_content, remarks, return_visit_man, tuisong_flag, isDelete, attend_type, attend_date, "
							+ "phone_state, is_buycar, phoneerror_count, area, real_type, constacterror, constacterror_count, oldid "
							+ " ) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,? ,?)");
				}
				System.out.println("处理记录id："+map.get("id"));
				PreparedStatement pstmtupdate = conn113.prepareStatement(sql.toString());
				if(map.get("pinpai_new")!=null){
					pstmtupdate.setInt(1, Integer.parseInt(map.get("pinpai_new")));
				}else{
					pstmtupdate.setInt(1, 0);
				}
				if(map.get("chexi_new")!=null){
					pstmtupdate.setInt(2, Integer.parseInt(map.get("chexi_new")));
				}else{
					pstmtupdate.setNull(2, java.sql.Types.INTEGER);
				}
				if(map.get("chexing_new")!=null){
					pstmtupdate.setInt(3, Integer.parseInt(map.get("chexing_new")));
				}else{
					pstmtupdate.setNull(3, java.sql.Types.INTEGER);
				}
				pstmtupdate.setString(4, map.get("name"));
				pstmtupdate.setString(5, map.get("phone"));
				if(map.get("prov")!=null && !map.get("prov").equals("") ){
					pstmtupdate.setInt(6, Integer.parseInt(map.get("prov")));
				}else{
					pstmtupdate.setNull(6, java.sql.Types.INTEGER);
				}
				if(map.get("city")!=null && !map.get("city").equals("")){
					pstmtupdate.setInt(7, Integer.parseInt(map.get("city")));
				}else{
					pstmtupdate.setNull(7, java.sql.Types.INTEGER);
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(map.get("appdate"));
				Timestamp tt=new Timestamp(date.getTime());
				pstmtupdate.setTimestamp(8, tt);
				
				pstmtupdate.setString(9, map.get("car_info"));
				
				if(map.get("phone_prov")!=null && !map.get("phone_prov").equals("")){
					pstmtupdate.setInt(10, Integer.parseInt(map.get("phone_prov")));
				}else{
					pstmtupdate.setNull(10, java.sql.Types.INTEGER);
				}
				
				if(map.get("phone_city")!=null  && !map.get("phone_city").equals("")){
					pstmtupdate.setInt(11, Integer.parseInt(map.get("phone_city")));
				}else{
					pstmtupdate.setNull(11, java.sql.Types.INTEGER);
				}
				
				pstmtupdate.setString(12, map.get("ip"));
				
				if(map.get("return_visit_state")!=null){
					pstmtupdate.setInt(13, Integer.parseInt(map.get("return_visit_state")));
				}else{
					pstmtupdate.setNull(13, java.sql.Types.INTEGER);
				}
				pstmtupdate.setInt(14, Integer.parseInt(map.get("is_key_cus")));
				
				if(map.get("phoneerror")!=null){
					pstmtupdate.setInt(15, Integer.parseInt(map.get("phoneerror")));
				}else{
					pstmtupdate.setNull(15, java.sql.Types.INTEGER);
				}
				
				if(map.get("return_visit_time")!=null){
					date = sdf.parse(map.get("return_visit_time"));
					pstmtupdate.setTimestamp(16, new Timestamp(date.getTime()));
				}else{
					pstmtupdate.setNull(16,java.sql.Types.TIMESTAMP);
				}
				pstmtupdate.setString(17, map.get("return_visit_content"));
				pstmtupdate.setString(18, map.get("remarks"));
				pstmtupdate.setString(19, map.get("return_visit_man"));
				
				if(map.get("tuisong_flag")!=null){
					pstmtupdate.setInt(20, Integer.parseInt(map.get("tuisong_flag")));
				}else{
					pstmtupdate.setNull(20, java.sql.Types.INTEGER);
				}
				if(map.get("isDelete")!=null){
					pstmtupdate.setInt(21, Integer.parseInt(map.get("isDelete")));
				}else{
					pstmtupdate.setNull(21, java.sql.Types.INTEGER);
				}
				
				if(map.get("is_attend")!=null){
					int befor = Integer.parseInt(map.get("is_attend"));
					int after =0;
					if(befor==1){
						after = 1;
					}else if(befor == 2){
						after = 5;
					}
					pstmtupdate.setInt(22, after);
				}else{
					pstmtupdate.setNull(22, java.sql.Types.INTEGER);
				}
				
				if(map.get("look_time")!=null){
					//date = sdfdate.parse(map.get("look_time"));
					pstmtupdate.setString(23,map.get("look_time"));
				}else{
					pstmtupdate.setNull(23,java.sql.Types.VARCHAR);
				}
				
				if(map.get("phone_state")!=null){
					pstmtupdate.setInt(24, Integer.parseInt(map.get("phone_state")));
				}else{
					pstmtupdate.setNull(24, java.sql.Types.INTEGER);
				}
				if(map.get("isbuy")!=null){
					int befor = Integer.parseInt(map.get("isbuy"));
					int after =0;
					if(befor==1){
						after = 1;
					}else if(befor == 2 || befor == 0 ){
						after = 0;
					}
					pstmtupdate.setInt(25, after);
				}else{
					pstmtupdate.setNull(25, java.sql.Types.INTEGER);
				}
				
				if(map.get("phone_count")!=null){
					pstmtupdate.setInt(26, Integer.parseInt(map.get("phone_count")));
				}else{
					pstmtupdate.setNull(26, java.sql.Types.INTEGER);
				}
				if(map.get("area")!=null){
					pstmtupdate.setInt(27, Integer.parseInt(map.get("area")));
				}else{
					pstmtupdate.setNull(27, java.sql.Types.INTEGER);
				}
				
				if(map.get("type")!=null){
					int befor = Integer.parseInt(map.get("type"));
					int after =0;
					if(befor==0 || befor == 1 || befor == 2 || befor == 3){
						after = 0;
					}else if(befor == 15 || befor == 16 || befor == 17 ){
						after = 1;
					}else{
						after = befor;
					}
					pstmtupdate.setInt(28, after);
				}else{
					pstmtupdate.setNull(28, java.sql.Types.INTEGER);
				}
				
				if(map.get("constacterror")!=null){
					pstmtupdate.setInt(29, Integer.parseInt(map.get("constacterror")));
				}else{
					pstmtupdate.setInt(29, 0);
				}

				if(map.get("constacterror_count")!=null){
					pstmtupdate.setInt(30, Integer.parseInt(map.get("constacterror_count")));
				}else{
					pstmtupdate.setInt(30, 0);
				}

				pstmtupdate.setInt(31, Integer.parseInt(map.get("id")));
			
				pstmtupdate.executeUpdate();
				pstmtupdate.close();
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
		
	}

	//��ȡ194���
	private static List<HashMap<String, String>> findOldData(int from,int size) {
		StringBuffer sql = new StringBuffer();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String aftertime = sdf.format(date);
		String beforetime = sdf.format(new Date(date.getTime()-6*60*60*1000));
		 sql = sql.append("SELECT DISTINCT a.*,b.catalogname pinpai,c.catalogname chexing")
				  .append(" from tb_apply_info a")
				  .append(" left JOIN dbo_car_catalognew b on a.carid=b.catalogid and b.fatherid = 0")
                  .append(" left JOIN dbo_car_catalognew c on a.modelid=c.catalogid and c.pathlevel = 3 where ((a.appdate >= '"+beforetime+"' and a.appdate < '"+aftertime+"') or (a.return_visit_time >= '"+beforetime+"' and a.return_visit_time < '"+aftertime+"'))") //
                 // .append(" left JOIN dbo_car_catalognew c on a.modelid=c.catalogid and c.pathlevel = 3 where id = 2222747") //
                  .append(" ORDER BY a.id ASC LIMIT "+from+","+size);
		HashMap<String, String> map = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			PreparedStatement pstmt = conn194.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("pinpai", rs.getString("pinpai"));
				map.put("chexing", rs.getString("chexing"));
				map.put("id", rs.getString("id"));
				map.put("carid", rs.getString("carid"));
				map.put("modelid", rs.getString("modelid"));
				map.put("name", rs.getString("name"));
				map.put("phone", rs.getString("phone"));
				map.put("sex", rs.getString("sex"));
				map.put("prov", rs.getString("prov"));
				map.put("city", rs.getString("city"));
				map.put("appdate", rs.getString("appdate"));
				map.put("type", rs.getString("type"));
				map.put("isSendSms", rs.getString("isSendSms"));
				map.put("left_num", rs.getString("left_num"));
				map.put("is_attend", rs.getString("is_attend"));
				map.put("look_time", rs.getString("look_time"));
				map.put("isbuy", rs.getString("isbuy"));
				map.put("buy_time", rs.getString("buy_time"));
				map.put("is_key_cus", rs.getString("is_key_cus"));
				map.put("phone_state", rs.getString("phone_state"));
				map.put("order_time", rs.getString("order_time"));
				map.put("order_state", rs.getString("order_state"));
				map.put("return_visit_state", rs.getString("return_visit_state"));
				map.put("return_visit_time", rs.getString("return_visit_time"));
				map.put("return_visit_man", rs.getString("return_visit_man"));
				map.put("return_visit_content", rs.getString("return_visit_content"));
				map.put("again_return_visit", rs.getString("again_return_visit"));
				map.put("remarks", rs.getString("remarks"));
				map.put("car_info", rs.getString("car_info"));
				map.put("ip", rs.getString("ip"));
				map.put("isDelete", rs.getString("isDelete"));
				map.put("phone_prov", rs.getString("phone_prov"));
				map.put("phone_city", rs.getString("phone_city"));
				map.put("tuisong_flag", rs.getString("tuisong_flag"));
				map.put("cus_intention", rs.getString("cus_intention"));
				map.put("area", rs.getString("area"));
				map.put("phoneerror", rs.getString("phoneerror"));
				map.put("phone_count", rs.getString("phone_count"));
				list.add(map);
				
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return list;
	}
	
	// ���Ʒ��ID
		static int getPingpaiId(String pingpai,Map<String,String> map) {
			String pingpainew = pingpai.toLowerCase().trim();
			int id = 0;
			for (DboCarCatalognew dboCarCatalognew : pingpaiList) {
				int cid = dboCarCatalognew.getCatalogid();
				String cname = dboCarCatalognew.getCatalogname() == null ? ""
						: dboCarCatalognew.getCatalogname().toLowerCase().trim();
				if (pingpainew.equals(cname)) {
					id = cid;
					break;
				}
				if (cname.contains(pingpainew) || pingpainew.contains(cname)) {
					id = cid;
					break;
				}
			}
			map.put("pinpai_new", ""+id);
			return id;
		}
		
		static int convertId(String chexing,Map map){
			int flag =0;
			
			String query = "select * from dbo_car_catalognew_315 where old_catalogid="+chexing;
			
			try {
				PreparedStatement pstmt = conn194.prepareStatement(query.toString());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					
					map.put("chexi_new", ""+rs.getInt("fatherid"));
					map.put("chexing_new", ""+rs.getInt("catalogid"));
					flag =1;
				}
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return flag;
		}

		// ��ó���ID
		static int getChexingId(String chexing, int brandid,Map<String,String> map) {
			String chexingnew = chexing.toLowerCase();
			int id = 0;
			int cxid=0;
			int brid=0;
			if (id == 0) {
				for (DboCarCatalognew dboCarCatalognew : chexiList) {
					int fatherid = dboCarCatalognew.getCatalogid();
					String cname = (dboCarCatalognew.getCatalogname() == null ? ""
							: dboCarCatalognew.getCatalogname()).toLowerCase();
					String byname = (dboCarCatalognew.getByname() == null ? ""
							: dboCarCatalognew.getByname()).toLowerCase();
					if (cname.equals((chexingnew)) || byname.equals(chexingnew)) {
						for (DboCarCatalognew dboCarCatalognewx : chexingList) {
							if (dboCarCatalognewx.getFatherid() == fatherid) {
								id = dboCarCatalognewx.getFatherid();
								cxid=dboCarCatalognewx.getCatalogid();
								brid=dboCarCatalognew.getFatherid();
								break;
							}
						}

					}

				}
			}
			if (id == 0) {
				for (DboCarCatalognew dboCarCatalognew : chexiList) {
					int fatherid = dboCarCatalognew.getCatalogid();
					String cname = (dboCarCatalognew.getCatalogname() == null ? ""
							: dboCarCatalognew.getCatalogname()).toLowerCase();
					String byname = (dboCarCatalognew.getByname() == null ? ""
							: dboCarCatalognew.getByname()).toLowerCase();
					if (cname.contains((chexingnew)) || byname.contains(chexingnew)
							|| chexingnew.contains(cname)) {
						for (DboCarCatalognew dboCarCatalognewx : chexingList) {
							if (dboCarCatalognewx.getFatherid() == fatherid) {
								id = dboCarCatalognewx.getFatherid();
								cxid=dboCarCatalognewx.getCatalogid();
								brid=dboCarCatalognew.getFatherid();
								break;
							}
						}

					}
				}
			}
			if (id == 0) {
				for (DboCarCatalognew dboCarCatalognew : chexiList) {
					int fatherid = dboCarCatalognew.getCatalogid();
					String cname = (dboCarCatalognew.getCatalogname() == null ? ""
							: dboCarCatalognew.getCatalogname()).toLowerCase();
					String byname = (dboCarCatalognew.getByname() == null ? ""
							: dboCarCatalognew.getByname()).toLowerCase();
					if (cname.contains((chexingnew)) || byname.contains(chexingnew)) {
						for (DboCarCatalognew dboCarCatalognewx : chexingList) {
							if (dboCarCatalognewx.getFatherid() == fatherid) {
								id = dboCarCatalognewx.getFatherid();
								cxid=dboCarCatalognewx.getCatalogid();
								brid=dboCarCatalognew.getFatherid();
								break;
							}
						}

					}
				}

			}
			if (id == 0) {
				String tempName = "";
				if (chexingnew.length() > 2)
					tempName = chexingnew.substring(0, chexingnew.length() - 1);
				if (!"".equals(tempName)) {
					for (DboCarCatalognew dboCarCatalognew : chexiList) {
						int fatherid = dboCarCatalognew.getCatalogid();
						String cname = (dboCarCatalognew.getCatalogname() == null ? ""
								: dboCarCatalognew.getCatalogname()).toLowerCase();
						String byname = (dboCarCatalognew.getByname() == null ? ""
								: dboCarCatalognew.getByname()).toLowerCase();

						if (cname.equals((tempName)) || byname.equals(tempName)) {
							for (DboCarCatalognew dboCarCatalognewx : chexingList) {
								if (dboCarCatalognewx.getFatherid() == fatherid) {
									brid=dboCarCatalognew.getFatherid();
									id = dboCarCatalognewx.getFatherid();
									cxid=dboCarCatalognewx.getCatalogid();
									break;
								}
							}

						}
					}
				}

			}
			if (id == 0) {
				for (DboCarCatalognew dboCarCatalognew : chexingList) {
					int cid = dboCarCatalognew.getCatalogid();
					String cname = (dboCarCatalognew.getCatalogname() == null ? ""
							: dboCarCatalognew.getCatalogname()).toLowerCase();
					String byname = (dboCarCatalognew.getByname() == null ? ""
							: dboCarCatalognew.getByname()).toLowerCase();
					if (cname.contains((chexingnew)) || byname.contains(chexingnew)) {
						id = dboCarCatalognew.getFatherid();
						cxid=dboCarCatalognew.getCatalogid();
						brid=dboCarCatalognew.getFatherid();
						break;
					}

				}
			}
			if (id == 0)
				System.err.println(chexing);
			if (id == 0) {
				id = getBrand(brandid);
			}
			if(brandid==0){
				map.put("pinpai_new", ""+brid);
			}
			map.put("chexi_new", ""+id);
			map.put("chexing_new", ""+cxid);

			return id;
		}
		
		// ���Ʒ��id ��㷵�ظ�����
		static int getBrand(int id) {
			int result = 0;
			DBConnect dbc = null;
			List<Integer> idList = new ArrayList<Integer>();
			String sql = "SELECT catalogid  from dbo_car_catalognew where isdelete = 0 AND fatherid = "+ id;
			try {
				dbc = new DBConnect(sql);
				ResultSet rs = dbc.executeQuery();
				while (rs.next()) {
					idList.add(rs.getInt("catalogid"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (dbc != null) {
					try {
						dbc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if (idList.size() > 0)
				result = idList.get(0);
			return result;
		}

	
    
	
	

}
