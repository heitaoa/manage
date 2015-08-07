package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDeaHqnews;

public class  DboDeaHqnewsDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDeaHqnews dbodeahqnews) throws SQLException {
		dbodeahqnews.setId(rs.getInt("id"));//
		dbodeahqnews.setTitle(rs.getString("title"));//标题
		dbodeahqnews.setDes(rs.getString("des"));//导语
		dbodeahqnews.setSerialid(rs.getInt("serialid"));//
		dbodeahqnews.setCarids(rs.getString("carids"));//车型$官方指导价$优惠幅度;车型$官方指导价$优惠幅度；
		dbodeahqnews.setStarttime(rs.getTimestamp("starttime"));//促销开始时间
		dbodeahqnews.setEndtime(rs.getTimestamp("endtime"));//
		dbodeahqnews.setSalemessage(rs.getString("salemessage"));//其他优惠信息
		dbodeahqnews.setBigpic(rs.getString("bigpic"));//车型大图
		dbodeahqnews.setPic1(rs.getString("pic1"));//四张小图
		dbodeahqnews.setPic2(rs.getString("pic2"));//四张小图
		dbodeahqnews.setPic3(rs.getString("pic3"));//四张小图
		dbodeahqnews.setPic4(rs.getString("pic4"));//四张小图
		dbodeahqnews.setIsaddress(rs.getInt("isaddress"));//
		dbodeahqnews.setIsmap(rs.getInt("ismap"));//
		dbodeahqnews.setIsdelete(rs.getInt("isdelete"));//
		dbodeahqnews.setAdddate(rs.getTimestamp("adddate"));//提交时间
		dbodeahqnews.setNewid(rs.getInt("newid"));//关联到dea_news中的id
		dbodeahqnews.setSaleprice(rs.getDouble("saleprice"));//优惠金额
		dbodeahqnews.setEid(rs.getInt("eid"));//
		dbodeahqnews.setIsaddphone(rs.getInt("isaddphone"));//
		dbodeahqnews.setNews315(rs.getInt("news315"));//审核标识
	}

	public static List<DboDeaHqnews> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_hqnews";
		List<DboDeaHqnews> list = new ArrayList<DboDeaHqnews>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaHqnews dbodeahqnews = new DboDeaHqnews();
				fill(rs, dbodeahqnews);
				list.add(dbodeahqnews);
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


	public static List<DboDeaHqnews> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dea_hqnews where "+subsql+"";
		List<DboDeaHqnews> list = new ArrayList<DboDeaHqnews>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDeaHqnews dbodeahqnews = new DboDeaHqnews();
				fill(rs, dbodeahqnews);
				list.add(dbodeahqnews);
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
		String sql = "select count(*) from dbo_dea_hqnews where "+subsql+"";
		
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
		String sql = "delete from dbo_dea_hqnews where "+subsql+"";
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
		String sql = "delete from dbo_dea_hqnews where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDeaHqnews dbodeahqnews) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dea_hqnews(`id`,`title`,`des`,`serialid`,`carids`,`starttime`,`endtime`,`salemessage`,`bigpic`,`pic1`,`pic2`,`pic3`,`pic4`,`isaddress`,`ismap`,`isdelete`,`adddate`,`newid`,`saleprice`,`eid`,`isaddphone`,`news315`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeahqnews.getId());
		dbc.setString(2, dbodeahqnews.getTitle());
		dbc.setString(3, dbodeahqnews.getDes());
		dbc.setInt(4, dbodeahqnews.getSerialid());
		dbc.setString(5, dbodeahqnews.getCarids());
		dbc.setTimestamp(6, new Timestamp(dbodeahqnews.getStarttime().getTime()));
		dbc.setTimestamp(7, new Timestamp(dbodeahqnews.getEndtime().getTime()));
		dbc.setString(8, dbodeahqnews.getSalemessage());
		dbc.setString(9, dbodeahqnews.getBigpic());
		dbc.setString(10, dbodeahqnews.getPic1());
		dbc.setString(11, dbodeahqnews.getPic2());
		dbc.setString(12, dbodeahqnews.getPic3());
		dbc.setString(13, dbodeahqnews.getPic4());
		dbc.setInt(14, dbodeahqnews.getIsaddress());
		dbc.setInt(15, dbodeahqnews.getIsmap());
		dbc.setInt(16, dbodeahqnews.getIsdelete());
		dbc.setTimestamp(17, new Timestamp(dbodeahqnews.getAdddate().getTime()));
		dbc.setInt(18, dbodeahqnews.getNewid());
		dbc.setDouble(19, dbodeahqnews.getSaleprice());
		dbc.setInt(20, dbodeahqnews.getEid());
		dbc.setInt(21, dbodeahqnews.getIsaddphone());
		dbc.setInt(22, dbodeahqnews.getNews315());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDeaHqnews dbodeahqnews) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dea_hqnews(`id`,`title`,`des`,`serialid`,`carids`,`starttime`,`endtime`,`salemessage`,`bigpic`,`pic1`,`pic2`,`pic3`,`pic4`,`isaddress`,`ismap`,`isdelete`,`adddate`,`newid`,`saleprice`,`eid`,`isaddphone`,`news315`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodeahqnews.getId());
		dbc.setString(2, dbodeahqnews.getTitle());
		dbc.setString(3, dbodeahqnews.getDes());
		dbc.setInt(4, dbodeahqnews.getSerialid());
		dbc.setString(5, dbodeahqnews.getCarids());
		dbc.setTimestamp(6, new Timestamp(dbodeahqnews.getStarttime().getTime()));
		dbc.setTimestamp(7, new Timestamp(dbodeahqnews.getEndtime().getTime()));
		dbc.setString(8, dbodeahqnews.getSalemessage());
		dbc.setString(9, dbodeahqnews.getBigpic());
		dbc.setString(10, dbodeahqnews.getPic1());
		dbc.setString(11, dbodeahqnews.getPic2());
		dbc.setString(12, dbodeahqnews.getPic3());
		dbc.setString(13, dbodeahqnews.getPic4());
		dbc.setInt(14, dbodeahqnews.getIsaddress());
		dbc.setInt(15, dbodeahqnews.getIsmap());
		dbc.setInt(16, dbodeahqnews.getIsdelete());
		dbc.setTimestamp(17, new Timestamp(dbodeahqnews.getAdddate().getTime()));
		dbc.setInt(18, dbodeahqnews.getNewid());
		dbc.setDouble(19, dbodeahqnews.getSaleprice());
		dbc.setInt(20, dbodeahqnews.getEid());
		dbc.setInt(21, dbodeahqnews.getIsaddphone());
		dbc.setInt(22, dbodeahqnews.getNews315());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDeaHqnews dbodeahqnews) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dea_hqnews set ");
		boolean flag = false;
		if(dbodeahqnews.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",des=?");
			}else{
				sb.append("des=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",serialid=?");
			}else{
				sb.append("serialid=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",carids=?");
			}else{
				sb.append("carids=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",starttime=?");
			}else{
				sb.append("starttime=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",endtime=?");
			}else{
				sb.append("endtime=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",salemessage=?");
			}else{
				sb.append("salemessage=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",bigpic=?");
			}else{
				sb.append("bigpic=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",pic1=?");
			}else{
				sb.append("pic1=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",pic2=?");
			}else{
				sb.append("pic2=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",pic3=?");
			}else{
				sb.append("pic3=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",pic4=?");
			}else{
				sb.append("pic4=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",isaddress=?");
			}else{
				sb.append("isaddress=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",ismap=?");
			}else{
				sb.append("ismap=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",newid=?");
			}else{
				sb.append("newid=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",saleprice=?");
			}else{
				sb.append("saleprice=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",eid=?");
			}else{
				sb.append("eid=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",isaddphone=?");
			}else{
				sb.append("isaddphone=?");
				flag=true;
			}
		}
		if(dbodeahqnews.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",news315=?");
			}else{
				sb.append("news315=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodeahqnews.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodeahqnews.getId());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[1]){
			dbc.setString(k, dbodeahqnews.getTitle());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[2]){
			dbc.setString(k, dbodeahqnews.getDes());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[3]){
			dbc.setInt(k, dbodeahqnews.getSerialid());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[4]){
			dbc.setString(k, dbodeahqnews.getCarids());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dbodeahqnews.getStarttime().getTime()));k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dbodeahqnews.getEndtime().getTime()));k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[7]){
			dbc.setString(k, dbodeahqnews.getSalemessage());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[8]){
			dbc.setString(k, dbodeahqnews.getBigpic());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[9]){
			dbc.setString(k, dbodeahqnews.getPic1());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[10]){
			dbc.setString(k, dbodeahqnews.getPic2());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[11]){
			dbc.setString(k, dbodeahqnews.getPic3());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[12]){
			dbc.setString(k, dbodeahqnews.getPic4());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[13]){
			dbc.setInt(k, dbodeahqnews.getIsaddress());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[14]){
			dbc.setInt(k, dbodeahqnews.getIsmap());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[15]){
			dbc.setInt(k, dbodeahqnews.getIsdelete());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[16]){
			dbc.setTimestamp(k, new Timestamp(dbodeahqnews.getAdddate().getTime()));k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[17]){
			dbc.setInt(k, dbodeahqnews.getNewid());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[18]){
			dbc.setDouble(k, dbodeahqnews.getSaleprice());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[19]){
			dbc.setInt(k, dbodeahqnews.getEid());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[20]){
			dbc.setInt(k, dbodeahqnews.getIsaddphone());k++;
		}
		if(dbodeahqnews.COLUMN_FLAG[21]){
			dbc.setInt(k, dbodeahqnews.getNews315());k++;
		}
		dbc.setInt(k, dbodeahqnews.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDeaHqnews dbodeahqnews) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodeahqnews);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}