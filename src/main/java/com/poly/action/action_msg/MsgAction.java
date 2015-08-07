package com.poly.action.action_msg;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;




import com.poly.dao.OrderSubDao;
import com.poly.dao.SendEmailDao;
import com.poly.util.SendMsgUtil;


public class MsgAction {

	/**
	 * 发送该分站每日推送量给分站经理
	 * @throws SQLException 
	 */
	public void sendDailyMsgToManager() throws SQLException {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(c.getTime());
		//String date = "2015-06-01";
		SendEmailDao sendEmailDao = new SendEmailDao();
		OrderSubDao orderSubDao = new OrderSubDao();
		//int num = orderSubDao.getAllllPorderByDay(date);
		int num = 0;
		String allmsg = "";
		
		int hd = 0;
		String hd_msg = "";
		
		int hn = 0;
		String hn_msg = "";
		
		int hz = 0;
		String hz_msg = "";
		
		int hb = 0;
		String hb_msg = "";
		
		int hx = 0;
		String hx_msg = "";
		
		int db = 0;
		String db_msg = "";
		
		
		List<Map<String, Object>> substationinfo = sendEmailDao.getSubstationInfo();
		for (Map<String, Object> map : substationinfo) {
			String aid = (String)map.get("ORG_COMMENT");
			String orgname = (String)map.get("ORG_NAME");
			int bbid = (Integer)map.get("ORG_ID");
			String bid = bbid +"";
			String dis_id = (String)map.get("DIS_ID");
			
			int nummap = orderSubDao.getAllPorderByDay(
					date, aid);
			
			num += nummap;
			
			String msg1 = orgname+"接受报名信息"+nummap+"条;";
			
			List<Map<String, Object>> maps = orderSubDao.getPorderByDay(bid,aid,date);
			
			String msg = orgname+"经理，您好！昨日贵分站共接受报名信息"+nummap+"条 其中";
			
			if(maps.size()>0){
				for (Map<String, Object> map2 : maps) {
					msg = msg + map2.get("catalogname") + map2.get("cot") +"条 ";
				}
				msg = msg + "。请知晓，谢谢";
			}else{
				msg = orgname+"经理，您好！昨日贵分站共接受报名信息0条。请知晓，谢谢";
			}
			
	//		map.put("msg1", msg1);
	//		map.put("nummap", nummap);
			
			allmsg += msg1;
			
			List<Map<String, Object>> submanagerinfo = sendEmailDao.getSubManagerInfo(bid);
			
			if(submanagerinfo.size()>0){
				Map<String, Object> submap = submanagerinfo.get(0);
				System.err.println("phone:" + submap.get("phone").toString() + " msg:"+msg);
				SendMsgUtil.SendMsg(msg, submap.get("phone").toString());//发送短信util
			}
		
			if("1".equals(dis_id)){
				hd += nummap;
				hd_msg += msg1;
			}
			
			if("2".equals(dis_id)){
				hn += nummap;
				hn_msg += msg1;
			}
			
			if("3".equals(dis_id)){
				hz += nummap;
				hz_msg += msg1;
			}
			
			if("4".equals(dis_id)){
				hb += nummap;
				hb_msg += msg1;
			}
			
			if("5".equals(dis_id)){
				hx += nummap;
				hx_msg += msg1;
			}
			
			if("6".equals(dis_id)){
				db += nummap;
				db_msg += msg1;
			}
			
		}
		
		String allmsg2 = "";
		
		if(num == 0){
			 allmsg2 = "昨日各分站共接受报名信息"+num+"条。";
		}else{
			allmsg2 = "昨日各分站共接受报名信息"+num+"条 其中"+allmsg;
		}
		System.err.println(" allmsg:"+allmsg2+"请知晓，谢谢！");
		SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢", "13701866666");
		SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢", "13761696639");
		
		List<Map<String, Object>> areaInfo = sendEmailDao.getAreaInfo();
		
		for(Map<String, Object> map:areaInfo){
			String dis = (String)map.get("dis");
			String phone = (String)map.get("phone");
			
			if(dis.contains("1")){
				String areamsg = "昨日华东区共接受报名信息"+hd+"条 其中";
				areamsg += (hd_msg+"请知晓，谢谢！");
				if(hd == 0){
					areamsg = "昨日华东区共接受报名信息"+hd+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("2")){
				String areamsg = "昨日华南区共接受报名信息"+hn+"条 其中";
				areamsg += (hn_msg+"请知晓，谢谢！");
				if(hn == 0){
					areamsg = "昨日华南区共接受报名信息"+hn+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("3")){
				String areamsg = "昨日华中区共接受报名信息"+hz+"条 其中";
				areamsg += (hz_msg+"请知晓，谢谢！");
				if(hz == 0){
					areamsg = "昨日华中区共接受报名信息"+hz+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("4")){
				String areamsg = "昨日华北区共接受报名信息"+hb+"条 其中";
				areamsg += (hb_msg+"请知晓，谢谢！");
				if(hb == 0){
					areamsg = "昨日华北区共接受报名信息"+hb+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("5")){
				String areamsg = "昨日西部区共接受报名信息"+hx+"条 其中";
				areamsg += (hx_msg+"请知晓，谢谢！");
				if(hx == 0){
					areamsg = "昨日西部区共接受报名信息"+hx+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("6")){
				String areamsg = "昨日东北区共接受报名信息"+db+"条 其中";
				areamsg += (db_msg+"请知晓，谢谢！");
				if(db == 0){
					areamsg = "昨日东北区共接受报名信息"+db+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
		}
	}
	
	/**
	 * 发送该分站每周推送量给分站经理
	 * @throws SQLException 
	 */
	public void sendWeeklyMsgToManager() throws SQLException {
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.DATE, -7);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String  startdate = sdf.format(c.getTime());
//		String enddate = sdf.format(new Date());
//		
//		SendEmailDao sendEmailDao = new SendEmailDao();
//		OrderSubDao orderSubDao = new OrderSubDao();
//		List<Map<String, Object>> managerinfo = sendEmailDao.getManagerInfo();
//		int num = orderSubDao.getAllllPorderByWeek(startdate,enddate);
//		String allmsg = "上周各分站共接受报名信息"+num+"条 其中";
//		for (Map<String, Object> map : managerinfo) {
//			try {
//				String name = (String)map.get("name");
//				String phone = (String)map.get("phone");
//				String aid = (String)map.get("aid");
//				String orgname = (String)map.get("orgname");
//				String bid = "";
//				
//				int nummap = orderSubDao.getAllPorderByWeek(
//						startdate,enddate, aid);
//				
//				String msg = orgname+"经理，您好！上周贵分站共接受报名信息"+nummap+"条 其中";
//				
////				if("1".equals(aid) || "9".equals(aid)){
////					bid = sendEmailDao.getAreaidInfo(aid);;
////				}
//				String msg1 = orgname+"接受报名信息"+nummap+"条";
//				List<Map<String, Object>> maps = orderSubDao.getPorderByWeek(bid,aid,startdate,enddate);
//					
//				if(maps.size()>0){
//					for (Map<String, Object> map2 : maps) {
//						msg = msg + map2.get("catalogname") + map2.get("cot") +"条 ";
//					}
//					msg = msg + "。请知晓，谢谢";
//				}else{
//					msg = orgname+"经理，您好！上周贵分站共接受报名信息0条。请知晓，谢谢";
//				}
//				
//				System.err.println("phone:" + phone + " msg:"+msg);
////				phone = "18621059671";
//				SendMsgUtil.SendMsg(msg, phone);//发送短信util
//				if(!"张群智".equals(name)){
//					allmsg += (msg1+";");
//				}//发送短信util
//			} catch (Exception e) {
//				System.out.println(map.get("name") + "出问题了");
//			}
//		}
//		if(num == 0){
//			 allmsg = "上周各分站共接受报名信息"+num+"条。请知晓，谢谢！";
//		}
//		System.err.println(" allmsg:"+allmsg+"请知晓，谢谢！");
//		SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢！", "13701866666");
//		SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢！", "13761696639");
//		//SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢", "18621059671");
		
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String  startdate = sdf.format(c.getTime());
		String enddate = sdf.format(new Date());
//		String startdate = "2015-06-01";
//		String enddate = "2015-06-07";
		SendEmailDao sendEmailDao = new SendEmailDao();
		OrderSubDao orderSubDao = new OrderSubDao();
		int num = 0;
		String allmsg = "";
		
		int hd = 0;
		String hd_msg = "";
		
		int hn = 0;
		String hn_msg = "";
		
		int hz = 0;
		String hz_msg = "";
		
		int hb = 0;
		String hb_msg = "";
		
		int hx = 0;
		String hx_msg = "";
		
		int db = 0;
		String db_msg = "";
		
		
		List<Map<String, Object>> substationinfo = sendEmailDao.getSubstationInfo();
		for (Map<String, Object> map : substationinfo) {
			String aid = (String)map.get("ORG_COMMENT");
			String orgname = (String)map.get("ORG_NAME");
			int bbid = (Integer)map.get("ORG_ID");
			String bid = bbid +"";
			String dis_id = (String)map.get("DIS_ID");
			
			int nummap =  orderSubDao.getAllPorderByWeek(
					startdate,enddate, aid);
			
			num += nummap;
			
			String msg1 = orgname+"接受报名信息"+nummap+"条;";
			
			List<Map<String, Object>> maps = orderSubDao.getPorderByWeek(bid,aid,startdate,enddate);
			
			String msg = orgname+"经理，您好！上周贵分站共接受报名信息"+nummap+"条 其中";
			
			if(maps.size()>0){
				for (Map<String, Object> map2 : maps) {
					msg = msg + map2.get("catalogname") + map2.get("cot") +"条 ";
				}
				msg = msg + "。请知晓，谢谢";
			}else{
				msg = orgname+"经理，您好！上周贵分站共接受报名信息0条。请知晓，谢谢";
			}
			
//			map.put("msg1", msg1);
//			map.put("nummap", nummap);
			
			allmsg += msg1;
			
			List<Map<String, Object>> submanagerinfo = sendEmailDao.getSubManagerInfo(bid);
			
			if(submanagerinfo.size()>0){
				Map<String, Object> submap = submanagerinfo.get(0);
				System.err.println("phone:" + submap.get("phone").toString() + " msg:"+msg);
				SendMsgUtil.SendMsg(msg, submap.get("phone").toString());//发送短信util
			}
		
			if("1".equals(dis_id)){
				hd += nummap;
				hd_msg += msg1;
			}
			
			if("2".equals(dis_id)){
				hn += nummap;
				hn_msg += msg1;
			}
			
			if("3".equals(dis_id)){
				hz += nummap;
				hz_msg += msg1;
			}
			
			if("4".equals(dis_id)){
				hb += nummap;
				hb_msg += msg1;
			}
			
			if("5".equals(dis_id)){
				hx += nummap;
				hx_msg += msg1;
			}
			
			if("6".equals(dis_id)){
				db += nummap;
				db_msg += msg1;
			}
			
		}
		String allmsg2 = "";
		if(num == 0){
			 allmsg2 = "上周各分站共接受报名信息"+num+"条。";
		}else{
			allmsg2 = "上周各分站共接受报名信息"+num+"条 其中"+allmsg;
		}
		System.err.println(" allmsg:"+allmsg2+"请知晓，谢谢！");
		SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢", "13701866666");
		SendMsgUtil.SendMsg(allmsg+"请知晓，谢谢", "13761696639");
		
		List<Map<String, Object>> areaInfo = sendEmailDao.getAreaInfo();
		
		for(Map<String, Object> map:areaInfo){
			String dis = (String)map.get("dis");
			String phone = (String)map.get("phone");
			
			if(dis.contains("1")){
				String areamsg = "上周华东区共接受报名信息"+hd+"条 其中";
				areamsg += (hd_msg+"请知晓，谢谢！");
				if(hd == 0){
					areamsg = "上周华东区共接受报名信息"+hd+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("2")){
				String areamsg = "上周华南区共接受报名信息"+hn+"条 其中";
				areamsg += (hn_msg+"请知晓，谢谢！");
				if(hn == 0){
					areamsg = "上周华南区共接受报名信息"+hn+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("3")){
				String areamsg = "上周华中区共接受报名信息"+hz+"条 其中";
				areamsg += (hz_msg+"请知晓，谢谢！");
				if(hz == 0){
					areamsg = "上周华中区共接受报名信息"+hz+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("4")){
				String areamsg = "上周华北区共接受报名信息"+hb+"条 其中";
				areamsg += (hb_msg+"请知晓，谢谢！");
				if(hb == 0){
					areamsg = "上周华北区共接受报名信息"+hb+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("5")){
				String areamsg = "上周西部区共接受报名信息"+hx+"条 其中";
				areamsg += (hx_msg+"请知晓，谢谢！");
				if(hx == 0){
					areamsg = "上周西部区共接受报名信息"+hx+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
			if(dis.contains("6")){
				String areamsg = "上周东北区共接受报名信息"+db+"条 其中";
				areamsg += (db_msg+"请知晓，谢谢！");
				if(db == 0){
					areamsg = "上周东北区共接受报名信息"+db+"条。请知晓，谢谢！";
				}
				System.err.println(" araemsg:"+areamsg);
				SendMsgUtil.SendMsg(areamsg,phone);
			}
			
		}
		
		
	}
}
