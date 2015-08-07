package com.poly.dao.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_daos.DBConnect;
import car_daos.TbDataGivingDao;

public class GivingDao extends TbDataGivingDao {
	public Map<String,Map<String,String>> getGiftsByProNum(String pro_num){
		Map<String,Map<String,String>> result = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,String>> gifts = new HashMap<String,Map<String,String>>();
		Map<String,Map<String,Integer>> packs = new HashMap<String,Map<String,Integer>>();
		String sql = "select giving_code from tb_data_trans_info where pro_num = ?";
		DBConnect dbc = null;
		try {
			dbc = new DBConnect(sql.toString());
			dbc.setString(1, pro_num);
			ResultSet rs = dbc.executeQuery();
			List<String>codes = new ArrayList<String>();
			while(rs.next()){
				codes.add(rs.getString("giving_code"));
			}
			String codesStr = "";
			for(int i=codes.size();i>0;i--){
				if(i>1){
					codesStr += codes.get(i-1)+",";
				}else{
					codesStr += codes.get(i-1);
				}
			}
			String [] codesArr = codesStr.split(",");
			sql = "select * from tb_data_gift";
			dbc.prepareStatement(sql);
			ResultSet rs1 = dbc.executeQuery();
			while(rs1.next()){
				int id = rs1.getInt("gift_id");
				String name = rs1.getString("gift_name");
				String price = rs1.getString("gift_price");
				Map<String,String> gift = new HashMap<String,String>();
				gift.put("name", name);
				gift.put("price", price);
				gifts.put(id+"", gift);
			}
			sql = "select package_id from tb_data_package";
			dbc.prepareStatement(sql);
			ResultSet rs2 = dbc.executeQuery();
			List<Integer> packageIds = new ArrayList<Integer>();
			while(rs2.next()){
				int id = rs2.getInt("package_id");
				packageIds.add(id);
			}
			for(Integer id:packageIds){
				sql = "select * from tb_data_packgift where package_id = ?";
				dbc.prepareStatement(sql);
				dbc.setInt(1, id);
				ResultSet rs3 = dbc.executeQuery();
				Map<String,Integer> pack = new  HashMap<String,Integer>();
				while(rs3.next()){
					int giftId = rs3.getInt("gift_id");
					int num = rs3.getInt("gift_num");
					pack.put(giftId+"", num);
				}
				packs.put(id+"", pack);
			}
			for(int i=0;i<codesArr.length;i++){
				String code = codesArr[i];
				String[] c = code.split("-");
				if("1".equals(c[0])){
					String id = c[1];
					Map<String,Integer> gs = packs.get(id);
					for(String gid:gs.keySet()){
						Map<String,String>rg = result.get(gid);
						if(rg==null){
							rg = new HashMap<String,String>();
							rg.put("name",gifts.get(gid).get("name"));
							Double sum = Double.parseDouble(gifts.get(gid).get("price"))*gs.get(gid);
							rg.put("sum", sum.toString());
							rg.put("num", gs.get(gid).toString());
							result.put(gid, rg);
						}else{
							Double sum = Double.parseDouble(gifts.get(gid).get("price"))*gs.get(gid);
							sum = sum + Double.parseDouble(rg.get("sum"));
							Integer num = gs.get(gid);
							num = num + Integer.parseInt(rg.get("num"));
							rg.put("sum", sum.toString());
							rg.put("num", num.toString());
							result.put(gid, rg);
						}
					}
				}else if("0".equals(c[0])){
					String id = c[1];
					Map<String,String>gift = gifts.get(id);
					Map<String,String>rg = result.get(id);
					if(rg==null){
						rg = new HashMap<String,String>();
						rg.put("name", gift.get("name"));
						rg.put("num", "1");
						rg.put("sum", gift.get("price"));
						result.put(id+"", rg);
					}else{
						Double sum = Double.parseDouble(gift.get("price"));
						sum = sum +Double.parseDouble(rg.get("sum"));
						rg.put("sum", sum.toString());
						Integer num = Integer.parseInt(rg.get("num"))+1;
						rg.put("num", num.toString());
						result.put(id+"", rg);
					}
				}
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
		return result;
	}
}
