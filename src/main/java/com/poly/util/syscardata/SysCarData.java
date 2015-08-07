package com.poly.util.syscardata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import car_beans.DboCarAutohomeprop;
import car_beans.DboCarCatalognew;

public class SysCarData {
	
	static Connection conn194 = null;	
	
	static Connection conn113 = null;
	
	static public DBConnect dbc113 = null;
	
	static public DBConnect194 dbc194 = null;

	static List<DboCarCatalognew> pingpaiList = null;
	static List<DboCarCatalognew> chexingList = null;
	static List<DboCarCatalognew> chexiList = null;
	
	static DboCarCatalognewDao194 dboCarCatalognewDao194 = null;
	static DboCarCatalognewDao dboCarCatalognewDao = null;
	
	static {
		dboCarCatalognewDao194 = new DboCarCatalognewDao194();
		dboCarCatalognewDao = new DboCarCatalognewDao();
		
	}
	
	static void init() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			conn249 = DriverManager.getConnection("jdbc:mysql://192.168.1.249:3306/yichedata?useUnicode=true&characterEncoding=UTF-8", "main", "main");
//			conn113 = DriverManager.getConnection("jdbc:mysql://182.254.131.113:3306/car_315?useUnicode=true&characterEncoding=UTF-8", "admin", "root178ZXC");
//			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chetuan?useUnicode=true&characterEncoding=UTF-8", "root", "");
			conn194 = DriverManager.getConnection("jdbc:mysql://182.254.147.194:3306/car?useUnicode=true&characterEncoding=UTF-8", "admin", "root178ZXC");
			dbc113 = new DBConnect();
			dbc194 = new DBConnect194();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		syncCar();
		syncAuto();

		
	}
	
	
	public static void syncCar(){
		//品牌
		System.out.println("-------start--------");
		List<DboCarCatalognew> insertbrandList = dboCarCatalognewDao.where(" old_catalogid = 0 and isdelete =0 and pathlevel = 1");
		for(int i=0;i<insertbrandList.size();i++){
			DboCarCatalognew car315 = insertbrandList.get(i);
			int oldid = car315.getCatalogid();
			int newid = 0;
			int fatherid=0;
			try{
				List<DboCarCatalognew> checklist = dboCarCatalognewDao194.where(" catalogid =" + oldid  );
				if(checklist.size()>0){
				    newid = selNextval();	
				}else{
					newid = car315.getCatalogid();				
				}
				car315.setOld_catalogid(newid);
				dboCarCatalognewDao.update(dbc113,car315);
				 
				car315.setCatalogid(newid);
				fatherid =  getFatherId194(car315);
				car315.setFatherid(fatherid);
				dboCarCatalognewDao194.save(dbc194,car315);
				System.out.println("品牌：------>315id:"+oldid+"------>cheid:"+newid+"------>fatherid:"+fatherid);
				 
			}catch (Exception e){
				e.printStackTrace();
			}			
		}
		
		//车系
		
		List<DboCarCatalognew> insertchexiList = dboCarCatalognewDao.where(dbc113," old_catalogid = 0 and isdelete =0 and pathlevel = 2");
		for(int i=0;i<insertchexiList.size();i++){
			DboCarCatalognew car315 = insertchexiList.get(i);
			int oldid = car315.getCatalogid();
			int newid = 0;
			int fatherid=0;
			try{
				List<DboCarCatalognew> checklist = dboCarCatalognewDao194.where(" catalogid =" + oldid  );
				if(checklist.size()>0){
				    newid = selNextval();	
				}else{
					newid = car315.getCatalogid();				
				}
				car315.setOld_catalogid(newid);
				dboCarCatalognewDao.update(dbc113,car315);
				 
				car315.setCatalogid(newid);
				fatherid =  getFatherId194(car315);
				car315.setFatherid(fatherid);
				dboCarCatalognewDao194.save(dbc194,car315);
				System.out.println("车系：------>315id:"+oldid+"------>cheid:"+newid+"------>fatherid:"+fatherid);
				 
			}catch (Exception e){
				e.printStackTrace();
			}			
		}
		
		//车型
		
				List<DboCarCatalognew> insertchexingList = dboCarCatalognewDao.where(" old_catalogid = 0 and isdelete =0 and pathlevel = 3");
				for(int i=0;i<insertchexingList.size();i++){
					DboCarCatalognew car315 = insertchexingList.get(i);
					int oldid = car315.getCatalogid();
					int newid = 0;
					int fatherid=0;
					try{
						List<DboCarCatalognew> checklist = dboCarCatalognewDao194.where(" catalogid =" + oldid  );
						if(checklist.size()>0){
						    newid = selNextval();	
						}else{
							newid = car315.getCatalogid();				
						}
						car315.setOld_catalogid(newid);
						dboCarCatalognewDao.update(dbc113,car315);
						 
						car315.setCatalogid(newid);
						fatherid =  getFatherId194(car315);
						car315.setFatherid(fatherid);
						dboCarCatalognewDao194.save(dbc194,car315);
						System.out.println("车型：------>315id:"+oldid+"------>cheid:"+newid+"------>fatherid:"+fatherid);
						 
					}catch (Exception e){
						e.printStackTrace();
					}			
				}
	}
	
	
	public static void syncAuto(){
		System.out.println("--------------------start----------------");
		
		String sql = "SELECT  a.catalogid idche,a.catalogname,c.catalogid id315 from dbo_car_catalognew a " + 
		             "left join dbo_car_autohomeprop b on a.catalogid = b.carid " +
                     "left join dbo_car_catalognew_315 c on c.old_catalogid=a.catalogid " +
                     "WHERE a.isdelete=0 and b.autohomecarid is null ";
		try{
			DboCarAutohomepropDao dao = new DboCarAutohomepropDao();
			DboCarAutohomepropDao194 dao194 = new DboCarAutohomepropDao194();
			PreparedStatement ps= conn194.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int id315=0;
			int idche=0;
			while(rs.next()){
				id315=rs.getInt("id315");
				idche=rs.getInt("idche");
				List<DboCarAutohomeprop> list315 = dao.where(dbc113, " carid="+id315);
				if(list315.size()>0){
					DboCarAutohomeprop car = list315.get(0);
					car.setCarid(idche);
					dao194.save(dbc194, car);
					System.out.println("插入：---------------->315id:"+id315+"--------------->cheid:"+idche);
				}
			
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static int getFatherId194(DboCarCatalognew car315){
		
		int fatherid=0;
		if(car315.getPathlevel() != 1){
			List<DboCarCatalognew> list = dboCarCatalognewDao.where(" catalogid = "+car315.getFatherid());
			if(list.size()>0){
				fatherid =  list.get(0).getOld_catalogid();
			}else{
				System.out.println("未找到FatherID的记录："+car315.getCatalogid());
			}
			
		}
		return fatherid;
	}
	
	public static int selNextval(){

		int result=0;
		try {
			
			String sql = "select _nextval('dbo_car_catalognew ')";
			dbc194.prepareStatement(sql);
			ResultSet rs = dbc194.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return result;
	}
	
}
