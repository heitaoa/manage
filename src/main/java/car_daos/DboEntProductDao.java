package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboEntProduct;

public class  DboEntProductDao  extends BaseDao {

	public static void fill(ResultSet rs, DboEntProduct dboentproduct) throws SQLException {
		dboentproduct.setId(rs.getInt("id"));//
		dboentproduct.setE_id(rs.getInt("e_id"));//企业id
		dboentproduct.setIsdelete(rs.getInt("isdelete"));//
		dboentproduct.setTypeid(rs.getInt("typeid"));//产品型号id
		dboentproduct.setType(rs.getInt("type"));//0，null-整件，1—配件
		dboentproduct.setIsrecommended(rs.getInt("isrecommended"));//
		dboentproduct.setPricessort(rs.getInt("pricessort"));//
		dboentproduct.setSortid(rs.getInt("sortid"));//
		dboentproduct.setPrice(rs.getLong("price"));//产品报价
		dboentproduct.setOffersprice(rs.getLong("offersprice"));//优惠价
		dboentproduct.setName(rs.getString("name"));//产品名
		dboentproduct.setPhoto(rs.getString("photo"));//产品图片
		dboentproduct.setAdddate(rs.getTimestamp("adddate"));//发布日期
		dboentproduct.setUpdatedate(rs.getTimestamp("updatedate"));//更新日期
		dboentproduct.setPerunit(rs.getString("perunit"));//数量+单位
		dboentproduct.setRemarks(rs.getString("remarks"));//备注
		dboentproduct.setIntroduce(rs.getString("introduce"));//产品介绍
		dboentproduct.setDirections(rs.getString("directions"));//产品说明书
		dboentproduct.setStandards(rs.getString("standards"));//配置规格
		dboentproduct.setDiscountinfo(rs.getString("discountinfo"));//
		dboentproduct.setHotdate(rs.getTimestamp("hotdate"));//
		dboentproduct.setIsdiscountdef(rs.getInt("isdiscountdef"));//
		dboentproduct.setBitautoprice(rs.getLong("bitautoprice"));//
	}

	public static List<DboEntProduct> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_ent_product";
		List<DboEntProduct> list = new ArrayList<DboEntProduct>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboEntProduct dboentproduct = new DboEntProduct();
				fill(rs, dboentproduct);
				list.add(dboentproduct);
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
		return list;
		
	}


	public static List<DboEntProduct> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_ent_product where "+subsql+"";
		List<DboEntProduct> list = new ArrayList<DboEntProduct>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboEntProduct dboentproduct = new DboEntProduct();
				fill(rs, dboentproduct);
				list.add(dboentproduct);
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
		return list;
		
	}

	public static int whereCount(String subsql) {
		DBConnect dbc = null;
		int result = EXECUTE_FAIL;
		String sql = "select count(*) from dbo_ent_product where "+subsql+"";
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return EXECUTE_FAIL;
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


	public static int delete(String subsql) {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "delete from dbo_ent_product where "+subsql+"";
		try {
			dbc = new DBConnect();
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			dbc.close();
			result = EXECUTE_SUCCESSS;
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

	public static int delete(DBConnect dbc,String subsql) {
		int result = EXECUTE_FAIL;
		String sql = "delete from dbo_ent_product where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboEntProduct dboentproduct) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_ent_product(`id`,`e_id`,`isdelete`,`typeid`,`type`,`isrecommended`,`pricessort`,`sortid`,`price`,`offersprice`,`name`,`photo`,`adddate`,`updatedate`,`perunit`,`remarks`,`introduce`,`directions`,`standards`,`discountinfo`,`hotdate`,`isdiscountdef`,`bitautoprice`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboentproduct.getId());
		dbc.setInt(2, dboentproduct.getE_id());
		dbc.setInt(3, dboentproduct.getIsdelete());
		dbc.setInt(4, dboentproduct.getTypeid());
		dbc.setInt(5, dboentproduct.getType());
		dbc.setInt(6, dboentproduct.getIsrecommended());
		dbc.setInt(7, dboentproduct.getPricessort());
		dbc.setInt(8, dboentproduct.getSortid());
		dbc.setLong(9, dboentproduct.getPrice());
		dbc.setLong(10, dboentproduct.getOffersprice());
		dbc.setString(11, dboentproduct.getName());
		dbc.setString(12, dboentproduct.getPhoto());
		dbc.setTimestamp(13, new Timestamp(dboentproduct.getAdddate().getTime()));
		dbc.setTimestamp(14, new Timestamp(dboentproduct.getUpdatedate().getTime()));
		dbc.setString(15, dboentproduct.getPerunit());
		dbc.setString(16, dboentproduct.getRemarks());
		dbc.setString(17, dboentproduct.getIntroduce());
		dbc.setString(18, dboentproduct.getDirections());
		dbc.setString(19, dboentproduct.getStandards());
		dbc.setString(20, dboentproduct.getDiscountinfo());
		dbc.setTimestamp(21, new Timestamp(dboentproduct.getHotdate().getTime()));
		dbc.setInt(22, dboentproduct.getIsdiscountdef());
		dbc.setLong(23, dboentproduct.getBitautoprice());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboEntProduct dboentproduct) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_ent_product(`id`,`e_id`,`isdelete`,`typeid`,`type`,`isrecommended`,`pricessort`,`sortid`,`price`,`offersprice`,`name`,`photo`,`adddate`,`updatedate`,`perunit`,`remarks`,`introduce`,`directions`,`standards`,`discountinfo`,`hotdate`,`isdiscountdef`,`bitautoprice`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboentproduct.getId());
		dbc.setInt(2, dboentproduct.getE_id());
		dbc.setInt(3, dboentproduct.getIsdelete());
		dbc.setInt(4, dboentproduct.getTypeid());
		dbc.setInt(5, dboentproduct.getType());
		dbc.setInt(6, dboentproduct.getIsrecommended());
		dbc.setInt(7, dboentproduct.getPricessort());
		dbc.setInt(8, dboentproduct.getSortid());
		dbc.setLong(9, dboentproduct.getPrice());
		dbc.setLong(10, dboentproduct.getOffersprice());
		dbc.setString(11, dboentproduct.getName());
		dbc.setString(12, dboentproduct.getPhoto());
		dbc.setTimestamp(13, new Timestamp(dboentproduct.getAdddate().getTime()));
		dbc.setTimestamp(14, new Timestamp(dboentproduct.getUpdatedate().getTime()));
		dbc.setString(15, dboentproduct.getPerunit());
		dbc.setString(16, dboentproduct.getRemarks());
		dbc.setString(17, dboentproduct.getIntroduce());
		dbc.setString(18, dboentproduct.getDirections());
		dbc.setString(19, dboentproduct.getStandards());
		dbc.setString(20, dboentproduct.getDiscountinfo());
		dbc.setTimestamp(21, new Timestamp(dboentproduct.getHotdate().getTime()));
		dbc.setInt(22, dboentproduct.getIsdiscountdef());
		dbc.setLong(23, dboentproduct.getBitautoprice());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboEntProduct dboentproduct) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_ent_product set ");
		boolean flag = false;
		if(dboentproduct.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",e_id=?");
			}else{
				sb.append("e_id=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",typeid=?");
			}else{
				sb.append("typeid=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",isrecommended=?");
			}else{
				sb.append("isrecommended=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",pricessort=?");
			}else{
				sb.append("pricessort=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",price=?");
			}else{
				sb.append("price=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",offersprice=?");
			}else{
				sb.append("offersprice=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",photo=?");
			}else{
				sb.append("photo=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",updatedate=?");
			}else{
				sb.append("updatedate=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",perunit=?");
			}else{
				sb.append("perunit=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",remarks=?");
			}else{
				sb.append("remarks=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",introduce=?");
			}else{
				sb.append("introduce=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",directions=?");
			}else{
				sb.append("directions=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",standards=?");
			}else{
				sb.append("standards=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",discountinfo=?");
			}else{
				sb.append("discountinfo=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",hotdate=?");
			}else{
				sb.append("hotdate=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",isdiscountdef=?");
			}else{
				sb.append("isdiscountdef=?");
				flag=true;
			}
		}
		if(dboentproduct.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",bitautoprice=?");
			}else{
				sb.append("bitautoprice=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboentproduct.COLUMN_FLAG[0]){
			dbc.setInt(k, dboentproduct.getId());k++;
		}
		if(dboentproduct.COLUMN_FLAG[1]){
			dbc.setInt(k, dboentproduct.getE_id());k++;
		}
		if(dboentproduct.COLUMN_FLAG[2]){
			dbc.setInt(k, dboentproduct.getIsdelete());k++;
		}
		if(dboentproduct.COLUMN_FLAG[3]){
			dbc.setInt(k, dboentproduct.getTypeid());k++;
		}
		if(dboentproduct.COLUMN_FLAG[4]){
			dbc.setInt(k, dboentproduct.getType());k++;
		}
		if(dboentproduct.COLUMN_FLAG[5]){
			dbc.setInt(k, dboentproduct.getIsrecommended());k++;
		}
		if(dboentproduct.COLUMN_FLAG[6]){
			dbc.setInt(k, dboentproduct.getPricessort());k++;
		}
		if(dboentproduct.COLUMN_FLAG[7]){
			dbc.setInt(k, dboentproduct.getSortid());k++;
		}
		if(dboentproduct.COLUMN_FLAG[8]){
			dbc.setLong(k, dboentproduct.getPrice());k++;
		}
		if(dboentproduct.COLUMN_FLAG[9]){
			dbc.setLong(k, dboentproduct.getOffersprice());k++;
		}
		if(dboentproduct.COLUMN_FLAG[10]){
			dbc.setString(k, dboentproduct.getName());k++;
		}
		if(dboentproduct.COLUMN_FLAG[11]){
			dbc.setString(k, dboentproduct.getPhoto());k++;
		}
		if(dboentproduct.COLUMN_FLAG[12]){
			dbc.setTimestamp(k, new Timestamp(dboentproduct.getAdddate().getTime()));k++;
		}
		if(dboentproduct.COLUMN_FLAG[13]){
			dbc.setTimestamp(k, new Timestamp(dboentproduct.getUpdatedate().getTime()));k++;
		}
		if(dboentproduct.COLUMN_FLAG[14]){
			dbc.setString(k, dboentproduct.getPerunit());k++;
		}
		if(dboentproduct.COLUMN_FLAG[15]){
			dbc.setString(k, dboentproduct.getRemarks());k++;
		}
		if(dboentproduct.COLUMN_FLAG[16]){
			dbc.setString(k, dboentproduct.getIntroduce());k++;
		}
		if(dboentproduct.COLUMN_FLAG[17]){
			dbc.setString(k, dboentproduct.getDirections());k++;
		}
		if(dboentproduct.COLUMN_FLAG[18]){
			dbc.setString(k, dboentproduct.getStandards());k++;
		}
		if(dboentproduct.COLUMN_FLAG[19]){
			dbc.setString(k, dboentproduct.getDiscountinfo());k++;
		}
		if(dboentproduct.COLUMN_FLAG[20]){
			dbc.setTimestamp(k, new Timestamp(dboentproduct.getHotdate().getTime()));k++;
		}
		if(dboentproduct.COLUMN_FLAG[21]){
			dbc.setInt(k, dboentproduct.getIsdiscountdef());k++;
		}
		if(dboentproduct.COLUMN_FLAG[22]){
			dbc.setLong(k, dboentproduct.getBitautoprice());k++;
		}
		dbc.setInt(k, dboentproduct.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboEntProduct dboentproduct) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboentproduct);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int DboEntProductCount(){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_ent_product where eid = ?";
	
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static int DboEntProductCountBye_id(int e_id){
		DBConnect dbc = null;
		String sql = "select count(*) from dbo_ent_product where e_id = ?";
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, e_id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (dbc != null)
					dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<DboEntProduct> SelectBye_id3(int e_id){
		DBConnect dbc = null;
		String sql = "select b.catalogid b_catalogid,b.catalogname b_catalogname,b.fatherid b_fatherid,b.byname b_byname,b.path b_path,b.islive b_islive,b.onsale b_onsale,b.iyear b_iyear,b.iway b_iway,b.madein b_madein,b.xiangti b_xiangti,b.jibie b_jibie,b.leixing b_leixing,b.bsq b_bsq,b.pailiang b_pailiang,b.photo b_photo,b.serialname b_serialname,b.newsid b_newsid,b.isdelete b_isdelete,b.adddate b_adddate,b.lastupdate b_lastupdate,b.addadmin b_addadmin,b.updateadmin b_updateadmin,b.deladmin b_deladmin,b.sortid b_sortid,b.factorytel b_factorytel,b.carkey b_carkey,b.englishname b_englishname,b.maincatalogid b_maincatalogid,b.ishaverelation b_ishaverelation,b.lname b_lname,b.pathlevel b_pathlevel,b.hotlevel b_hotlevel,b.fadongji b_fadongji,b.baoyangfeiyong b_baoyangfeiyong,b.pengzhuanglevel b_pengzhuanglevel,b.guanurl b_guanurl,b.wayname b_wayname,a.id a_id,a.e_id a_e_id,a.isdelete a_isdelete,a.typeid a_typeid,a.type a_type,a.isrecommended a_isrecommended,a.pricessort a_pricessort,a.sortid a_sortid,a.price a_price,a.offersprice a_offersprice,a.name a_name,a.photo a_photo,a.adddate a_adddate,a.updatedate a_updatedate,a.perunit a_perunit,a.remarks a_remarks,a.introduce a_introduce,a.directions a_directions,a.standards a_standards,a.discountinfo a_discountinfo,a.hotdate a_hotdate,a.isdiscountdef a_isdiscountdef,a.bitautoprice a_bitautoprice from dbo_ent_product a,dbo_car_catalognew b where a . typeid = b . catalogid  and a . e_id = ?   ";
		List<DboEntProduct> list = new ArrayList<DboEntProduct>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, e_id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboEntProduct dboentproduct = new DboEntProduct();
				dboentproduct.setId(rs.getInt("a_id"));
				dboentproduct.setE_id(rs.getInt("a_e_id"));
				dboentproduct.setIsdelete(rs.getInt("a_isdelete"));
				dboentproduct.setTypeid(rs.getInt("a_typeid"));
				dboentproduct.setType(rs.getInt("a_type"));
				dboentproduct.setIsrecommended(rs.getInt("a_isrecommended"));
				dboentproduct.setPricessort(rs.getInt("a_pricessort"));
				dboentproduct.setSortid(rs.getInt("a_sortid"));
				dboentproduct.setPrice(rs.getLong("a_price"));
				dboentproduct.setOffersprice(rs.getLong("a_offersprice"));
				dboentproduct.setName(rs.getString("a_name"));
				dboentproduct.setPhoto(rs.getString("a_photo"));
				dboentproduct.setAdddate(rs.getTimestamp("a_adddate"));
				dboentproduct.setUpdatedate(rs.getTimestamp("a_updatedate"));
				dboentproduct.setPerunit(rs.getString("a_perunit"));
				dboentproduct.setRemarks(rs.getString("a_remarks"));
				dboentproduct.setIntroduce(rs.getString("a_introduce"));
				dboentproduct.setDirections(rs.getString("a_directions"));
				dboentproduct.setStandards(rs.getString("a_standards"));
				dboentproduct.setDiscountinfo(rs.getString("a_discountinfo"));
				dboentproduct.setHotdate(rs.getTimestamp("a_hotdate"));
				dboentproduct.setIsdiscountdef(rs.getInt("a_isdiscountdef"));
				dboentproduct.setBitautoprice(rs.getLong("a_bitautoprice"));
				DboCarCatalognew dbocarcatalognew1 = new DboCarCatalognew();
				dbocarcatalognew1.setCatalogid(rs.getInt("b_catalogid"));
				dbocarcatalognew1.setCatalogname(rs.getString("b_catalogname"));
				dbocarcatalognew1.setFatherid(rs.getInt("b_fatherid"));
				dbocarcatalognew1.setByname(rs.getString("b_byname"));
				dbocarcatalognew1.setPath(rs.getString("b_path"));
				dbocarcatalognew1.setIslive(rs.getInt("b_islive"));
				dbocarcatalognew1.setOnsale(rs.getInt("b_onsale"));
				dbocarcatalognew1.setIyear(rs.getInt("b_iyear"));
				dbocarcatalognew1.setIway(rs.getString("b_iway"));
				dbocarcatalognew1.setMadein(rs.getInt("b_madein"));
				dbocarcatalognew1.setXiangti(rs.getInt("b_xiangti"));
				dbocarcatalognew1.setJibie(rs.getInt("b_jibie"));
				dbocarcatalognew1.setLeixing(rs.getInt("b_leixing"));
				dbocarcatalognew1.setBsq(rs.getInt("b_bsq"));
				dbocarcatalognew1.setPailiang(rs.getInt("b_pailiang"));
				dbocarcatalognew1.setPhoto(rs.getString("b_photo"));
				dbocarcatalognew1.setSerialname(rs.getString("b_serialname"));
				dbocarcatalognew1.setNewsid(rs.getInt("b_newsid"));
				dbocarcatalognew1.setIsdelete(rs.getInt("b_isdelete"));
				dbocarcatalognew1.setAdddate(rs.getTimestamp("b_adddate"));
				dbocarcatalognew1.setLastupdate(rs.getTimestamp("b_lastupdate"));
				dbocarcatalognew1.setAddadmin(rs.getString("b_addadmin"));
				dbocarcatalognew1.setUpdateadmin(rs.getString("b_updateadmin"));
				dbocarcatalognew1.setDeladmin(rs.getString("b_deladmin"));
				dbocarcatalognew1.setSortid(rs.getInt("b_sortid"));
				dbocarcatalognew1.setFactorytel(rs.getString("b_factorytel"));
				dbocarcatalognew1.setCarkey(rs.getString("b_carkey"));
				dbocarcatalognew1.setEnglishname(rs.getString("b_englishname"));
				dbocarcatalognew1.setMaincatalogid(rs.getInt("b_maincatalogid"));
				dbocarcatalognew1.setIshaverelation(rs.getInt("b_ishaverelation"));
				dbocarcatalognew1.setLname(rs.getString("b_lname"));
				dbocarcatalognew1.setPathlevel(rs.getInt("b_pathlevel"));
				dbocarcatalognew1.setHotlevel(rs.getInt("b_hotlevel"));
				dbocarcatalognew1.setFadongji(rs.getInt("b_fadongji"));
				dbocarcatalognew1.setBaoyangfeiyong(rs.getInt("b_baoyangfeiyong"));
				dbocarcatalognew1.setPengzhuanglevel(rs.getInt("b_pengzhuanglevel"));
				dbocarcatalognew1.setGuanurl(rs.getString("b_guanurl"));
				dbocarcatalognew1.setWayname(rs.getString("b_wayname"));
				dboentproduct.setCarType(dbocarcatalognew1);
				list.add(dboentproduct);
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
		return list;
	}

	public static List<DboEntProduct> SelectBye_id(int e_id){
		DBConnect dbc = null;
		String sql = "select a.id a_id,a.e_id a_e_id,a.isdelete a_isdelete,a.typeid a_typeid,a.type a_type,a.isrecommended a_isrecommended,a.pricessort a_pricessort,a.sortid a_sortid,a.price a_price,a.offersprice a_offersprice,a.name a_name,a.photo a_photo,a.adddate a_adddate,a.updatedate a_updatedate,a.perunit a_perunit,a.remarks a_remarks,a.introduce a_introduce,a.directions a_directions,a.standards a_standards,a.discountinfo a_discountinfo,a.hotdate a_hotdate,a.isdiscountdef a_isdiscountdef,a.bitautoprice a_bitautoprice,b.catalogid b_catalogid,b.catalogname b_catalogname,b.fatherid b_fatherid,b.byname b_byname,b.path b_path,b.islive b_islive,b.onsale b_onsale,b.iyear b_iyear,b.iway b_iway,b.madein b_madein,b.xiangti b_xiangti,b.jibie b_jibie,b.leixing b_leixing,b.bsq b_bsq,b.pailiang b_pailiang,b.photo b_photo,b.serialname b_serialname,b.newsid b_newsid,b.isdelete b_isdelete,b.adddate b_adddate,b.lastupdate b_lastupdate,b.addadmin b_addadmin,b.updateadmin b_updateadmin,b.deladmin b_deladmin,b.sortid b_sortid,b.factorytel b_factorytel,b.carkey b_carkey,b.englishname b_englishname,b.maincatalogid b_maincatalogid,b.ishaverelation b_ishaverelation,b.lname b_lname,b.pathlevel b_pathlevel,b.hotlevel b_hotlevel,b.fadongji b_fadongji,b.baoyangfeiyong b_baoyangfeiyong,b.pengzhuanglevel b_pengzhuanglevel,b.guanurl b_guanurl,b.wayname b_wayname from dbo_ent_product a,dbo_car_catalognew b where a . typeid = b . catalogid  and a . e_id = ?   ";
		List<DboEntProduct> list = new ArrayList<DboEntProduct>();
	
		try {
			dbc = new DBConnect(sql);
			dbc.setInt(1, e_id);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboEntProduct dboentproduct = new DboEntProduct();
				dboentproduct.setId(rs.getInt("a_id"));
				dboentproduct.setE_id(rs.getInt("a_e_id"));
				dboentproduct.setIsdelete(rs.getInt("a_isdelete"));
				dboentproduct.setTypeid(rs.getInt("a_typeid"));
				dboentproduct.setType(rs.getInt("a_type"));
				dboentproduct.setIsrecommended(rs.getInt("a_isrecommended"));
				dboentproduct.setPricessort(rs.getInt("a_pricessort"));
				dboentproduct.setSortid(rs.getInt("a_sortid"));
				dboentproduct.setPrice(rs.getLong("a_price"));
				dboentproduct.setOffersprice(rs.getLong("a_offersprice"));
				dboentproduct.setName(rs.getString("a_name"));
				dboentproduct.setPhoto(rs.getString("a_photo"));
				dboentproduct.setAdddate(rs.getTimestamp("a_adddate"));
				dboentproduct.setUpdatedate(rs.getTimestamp("a_updatedate"));
				dboentproduct.setPerunit(rs.getString("a_perunit"));
				dboentproduct.setRemarks(rs.getString("a_remarks"));
				dboentproduct.setIntroduce(rs.getString("a_introduce"));
				dboentproduct.setDirections(rs.getString("a_directions"));
				dboentproduct.setStandards(rs.getString("a_standards"));
				dboentproduct.setDiscountinfo(rs.getString("a_discountinfo"));
				dboentproduct.setHotdate(rs.getTimestamp("a_hotdate"));
				dboentproduct.setIsdiscountdef(rs.getInt("a_isdiscountdef"));
				dboentproduct.setBitautoprice(rs.getLong("a_bitautoprice"));
				DboCarCatalognew dbocarcatalognew1 = new DboCarCatalognew();
				dbocarcatalognew1.setCatalogid(rs.getInt("b_catalogid"));
				dbocarcatalognew1.setCatalogname(rs.getString("b_catalogname"));
				dbocarcatalognew1.setFatherid(rs.getInt("b_fatherid"));
				dbocarcatalognew1.setByname(rs.getString("b_byname"));
				dbocarcatalognew1.setPath(rs.getString("b_path"));
				dbocarcatalognew1.setIslive(rs.getInt("b_islive"));
				dbocarcatalognew1.setOnsale(rs.getInt("b_onsale"));
				dbocarcatalognew1.setIyear(rs.getInt("b_iyear"));
				dbocarcatalognew1.setIway(rs.getString("b_iway"));
				dbocarcatalognew1.setMadein(rs.getInt("b_madein"));
				dbocarcatalognew1.setXiangti(rs.getInt("b_xiangti"));
				dbocarcatalognew1.setJibie(rs.getInt("b_jibie"));
				dbocarcatalognew1.setLeixing(rs.getInt("b_leixing"));
				dbocarcatalognew1.setBsq(rs.getInt("b_bsq"));
				dbocarcatalognew1.setPailiang(rs.getInt("b_pailiang"));
				dbocarcatalognew1.setPhoto(rs.getString("b_photo"));
				dbocarcatalognew1.setSerialname(rs.getString("b_serialname"));
				dbocarcatalognew1.setNewsid(rs.getInt("b_newsid"));
				dbocarcatalognew1.setIsdelete(rs.getInt("b_isdelete"));
				dbocarcatalognew1.setAdddate(rs.getTimestamp("b_adddate"));
				dbocarcatalognew1.setLastupdate(rs.getTimestamp("b_lastupdate"));
				dbocarcatalognew1.setAddadmin(rs.getString("b_addadmin"));
				dbocarcatalognew1.setUpdateadmin(rs.getString("b_updateadmin"));
				dbocarcatalognew1.setDeladmin(rs.getString("b_deladmin"));
				dbocarcatalognew1.setSortid(rs.getInt("b_sortid"));
				dbocarcatalognew1.setFactorytel(rs.getString("b_factorytel"));
				dbocarcatalognew1.setCarkey(rs.getString("b_carkey"));
				dbocarcatalognew1.setEnglishname(rs.getString("b_englishname"));
				dbocarcatalognew1.setMaincatalogid(rs.getInt("b_maincatalogid"));
				dbocarcatalognew1.setIshaverelation(rs.getInt("b_ishaverelation"));
				dbocarcatalognew1.setLname(rs.getString("b_lname"));
				dbocarcatalognew1.setPathlevel(rs.getInt("b_pathlevel"));
				dbocarcatalognew1.setHotlevel(rs.getInt("b_hotlevel"));
				dbocarcatalognew1.setFadongji(rs.getInt("b_fadongji"));
				dbocarcatalognew1.setBaoyangfeiyong(rs.getInt("b_baoyangfeiyong"));
				dbocarcatalognew1.setPengzhuanglevel(rs.getInt("b_pengzhuanglevel"));
				dbocarcatalognew1.setGuanurl(rs.getString("b_guanurl"));
				dbocarcatalognew1.setWayname(rs.getString("b_wayname"));
				dboentproduct.setCarType(dbocarcatalognew1);
				list.add(dboentproduct);
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
		return list;
	}
}