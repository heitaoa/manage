package car_daos;
import java.sql.*;
import java.util.*;

import com.poly.util.DeleteCarParamFileUtil;

import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboImgContent;

public class  DboImgContentDao  extends BaseDao {

	public static void fill(ResultSet rs, DboImgContent dboimgcontent) throws SQLException {
		dboimgcontent.setId(rs.getInt("id"));//�Զ�����id
		dboimgcontent.setTitleid(rs.getInt("titleid"));//ͼƬ����id
		dboimgcontent.setTitle(rs.getString("title"));//С����
		dboimgcontent.setKeywords(rs.getString("keywords"));//�ؼ���
		dboimgcontent.setPath(rs.getString("path"));//����·��
		dboimgcontent.setAdddate(rs.getTimestamp("adddate"));//���ʱ��
		dboimgcontent.setLastupdate(rs.getTimestamp("lastupdate"));//����޸�ʱ��
		dboimgcontent.setSortid(rs.getInt("sortid"));//����
		dboimgcontent.setIsdelete(rs.getInt("isdelete"));//0��
		dboimgcontent.setContentpage(rs.getInt("contentpage"));//
		dboimgcontent.setSerialtype(rs.getLong("serialtype"));//
		dboimgcontent.setTotopdate(rs.getLong("totopdate"));//
		dboimgcontent.setCatalogid(rs.getInt("catalogid"));//
		dboimgcontent.setType(rs.getInt("type"));//
		dboimgcontent.setBackcatalogid(rs.getInt("backcatalogid"));//
		dboimgcontent.setComefrom(rs.getString("comefrom"));//
	}

	public static List<DboImgContent> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_content";
		List<DboImgContent> list = new ArrayList<DboImgContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgContent dboimgcontent = new DboImgContent();
				fill(rs, dboimgcontent);
				list.add(dboimgcontent);
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


	public static List<DboImgContent> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_img_content where "+subsql+"";
		List<DboImgContent> list = new ArrayList<DboImgContent>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboImgContent dboimgcontent = new DboImgContent();
				fill(rs, dboimgcontent);
				list.add(dboimgcontent);
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
		String sql = "select count(*) from dbo_img_content where "+subsql+"";
		
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
		String sql = "delete from dbo_img_content where "+subsql+"";
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
		String sql = "delete from dbo_img_content where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboImgContent dboimgcontent) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_img_content(`id`,`titleid`,`title`,`keywords`,`path`,`adddate`,`lastupdate`,`sortid`,`isdelete`,`contentpage`,`serialtype`,`totopdate`,`catalogid`,`type`,`backcatalogid`,`comefrom`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgcontent.getId());
		dbc.setInt(2, dboimgcontent.getTitleid());
		dbc.setString(3, dboimgcontent.getTitle());
		dbc.setString(4, dboimgcontent.getKeywords());
		dbc.setString(5, dboimgcontent.getPath());
		dbc.setTimestamp(6, new Timestamp(dboimgcontent.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(dboimgcontent.getLastupdate().getTime()));
		dbc.setInt(8, dboimgcontent.getSortid());
		dbc.setInt(9, dboimgcontent.getIsdelete());
		dbc.setInt(10, dboimgcontent.getContentpage());
		dbc.setLong(11, dboimgcontent.getSerialtype());
		dbc.setLong(12, dboimgcontent.getTotopdate());
		dbc.setInt(13, dboimgcontent.getCatalogid());
		dbc.setInt(14, dboimgcontent.getType());
		dbc.setInt(15, dboimgcontent.getBackcatalogid());
		dbc.setString(16, dboimgcontent.getComefrom());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		DeleteCarParamFileUtil.deleteTuKuPriceFile(dboimgcontent.getId()+"","imgContent");
		return result;
	}

	public static int save(DBConnect dbc,DboImgContent dboimgcontent) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_img_content(`id`,`titleid`,`title`,`keywords`,`path`,`adddate`,`lastupdate`,`sortid`,`isdelete`,`contentpage`,`serialtype`,`totopdate`,`catalogid`,`type`,`backcatalogid`,`comefrom`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dboimgcontent.getId());
		dbc.setInt(2, dboimgcontent.getTitleid());
		dbc.setString(3, dboimgcontent.getTitle());
		dbc.setString(4, dboimgcontent.getKeywords());
		dbc.setString(5, dboimgcontent.getPath());
		dbc.setTimestamp(6, new Timestamp(dboimgcontent.getAdddate().getTime()));
		dbc.setTimestamp(7, new Timestamp(dboimgcontent.getLastupdate().getTime()));
		dbc.setInt(8, dboimgcontent.getSortid());
		dbc.setInt(9, dboimgcontent.getIsdelete());
		dbc.setInt(10, dboimgcontent.getContentpage());
		dbc.setLong(11, dboimgcontent.getSerialtype());
		dbc.setLong(12, dboimgcontent.getTotopdate());
		dbc.setInt(13, dboimgcontent.getCatalogid());
		dbc.setInt(14, dboimgcontent.getType());
		dbc.setInt(15, dboimgcontent.getBackcatalogid());
		dbc.setString(16, dboimgcontent.getComefrom());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		DeleteCarParamFileUtil.deleteTuKuPriceFile(dboimgcontent.getId()+"","imgContent");
		return result;
	}

	public static int update(DBConnect dbc,DboImgContent dboimgcontent) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_img_content set ");
		boolean flag = false;
		if(dboimgcontent.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",titleid=?");
			}else{
				sb.append("titleid=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",keywords=?");
			}else{
				sb.append("keywords=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",path=?");
			}else{
				sb.append("path=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",adddate=?");
			}else{
				sb.append("adddate=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",lastupdate=?");
			}else{
				sb.append("lastupdate=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",sortid=?");
			}else{
				sb.append("sortid=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",isdelete=?");
			}else{
				sb.append("isdelete=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",contentpage=?");
			}else{
				sb.append("contentpage=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",serialtype=?");
			}else{
				sb.append("serialtype=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",totopdate=?");
			}else{
				sb.append("totopdate=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",catalogid=?");
			}else{
				sb.append("catalogid=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",type=?");
			}else{
				sb.append("type=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",backcatalogid=?");
			}else{
				sb.append("backcatalogid=?");
				flag=true;
			}
		}
		if(dboimgcontent.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",comefrom=?");
			}else{
				sb.append("comefrom=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dboimgcontent.COLUMN_FLAG[0]){
			dbc.setInt(k, dboimgcontent.getId());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[1]){
			dbc.setInt(k, dboimgcontent.getTitleid());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[2]){
			dbc.setString(k, dboimgcontent.getTitle());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[3]){
			dbc.setString(k, dboimgcontent.getKeywords());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[4]){
			dbc.setString(k, dboimgcontent.getPath());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[5]){
			dbc.setTimestamp(k, new Timestamp(dboimgcontent.getAdddate().getTime()));k++;
		}
		if(dboimgcontent.COLUMN_FLAG[6]){
			dbc.setTimestamp(k, new Timestamp(dboimgcontent.getLastupdate().getTime()));k++;
		}
		if(dboimgcontent.COLUMN_FLAG[7]){
			dbc.setInt(k, dboimgcontent.getSortid());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[8]){
			dbc.setInt(k, dboimgcontent.getIsdelete());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[9]){
			dbc.setInt(k, dboimgcontent.getContentpage());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[10]){
			dbc.setLong(k, dboimgcontent.getSerialtype());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[11]){
			dbc.setLong(k, dboimgcontent.getTotopdate());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[12]){
			dbc.setInt(k, dboimgcontent.getCatalogid());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[13]){
			dbc.setInt(k, dboimgcontent.getType());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[14]){
			dbc.setInt(k, dboimgcontent.getBackcatalogid());k++;
		}
		if(dboimgcontent.COLUMN_FLAG[15]){
			dbc.setString(k, dboimgcontent.getComefrom());k++;
		}
		dbc.setInt(k, dboimgcontent.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboImgContent dboimgcontent) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dboimgcontent);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}