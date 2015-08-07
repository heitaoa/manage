package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.DboDntTousu;

public class  DboDntTousuDao  extends BaseDao {

	public static void fill(ResultSet rs, DboDntTousu dbodnttousu) throws SQLException {
		dbodnttousu.setId(rs.getInt("id"));//
		dbodnttousu.setUid(rs.getInt("uid"));//
		dbodnttousu.setName(rs.getString("name"));//
		dbodnttousu.setPhone(rs.getString("phone"));//
		dbodnttousu.setEmail(rs.getString("email"));//
		dbodnttousu.setPort(rs.getString("port"));//
		dbodnttousu.setAddress(rs.getString("address"));//
		dbodnttousu.setHao(rs.getString("hao"));//
		dbodnttousu.setLc(rs.getString("lc"));//
		dbodnttousu.setFdj(rs.getString("fdj"));//
		dbodnttousu.setCj(rs.getString("cj"));//
		dbodnttousu.setSerial(rs.getInt("serial"));//
		dbodnttousu.setBuydate(rs.getTimestamp("buydate"));//
		dbodnttousu.setSsssname(rs.getString("ssssname"));//
		dbodnttousu.setSssstel(rs.getString("sssstel"));//
		dbodnttousu.setXladdress(rs.getInt("xladdress"));//
		dbodnttousu.setCarstate(rs.getInt("carstate"));//
		dbodnttousu.setProblem(rs.getString("problem"));//
		dbodnttousu.setSuqiu(rs.getString("suqiu"));//
		dbodnttousu.setTitle(rs.getString("title"));//
		dbodnttousu.setContent(rs.getString("content"));//
		dbodnttousu.setAddtime(rs.getTimestamp("addtime"));//
		dbodnttousu.setState(rs.getInt("state"));//
		dbodnttousu.setImage(rs.getString("image"));//
		dbodnttousu.setImagename(rs.getString("imagename"));//
		dbodnttousu.setCause(rs.getString("cause"));//
		dbodnttousu.setTid(rs.getInt("tid"));//
	}

	public static List<DboDntTousu> find() {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_tousu";
		List<DboDntTousu> list = new ArrayList<DboDntTousu>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntTousu dbodnttousu = new DboDntTousu();
				fill(rs, dbodnttousu);
				list.add(dbodnttousu);
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


	public static List<DboDntTousu> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from dbo_dnt_tousu where "+subsql+"";
		List<DboDntTousu> list = new ArrayList<DboDntTousu>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				DboDntTousu dbodnttousu = new DboDntTousu();
				fill(rs, dbodnttousu);
				list.add(dbodnttousu);
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
		String sql = "select count(*) from dbo_dnt_tousu where "+subsql+"";
		
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
		String sql = "delete from dbo_dnt_tousu where "+subsql+"";
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
		String sql = "delete from dbo_dnt_tousu where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(DboDntTousu dbodnttousu) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into dbo_dnt_tousu(`id`,`uid`,`name`,`phone`,`email`,`port`,`address`,`hao`,`lc`,`fdj`,`cj`,`serial`,`buydate`,`ssssname`,`sssstel`,`xladdress`,`carstate`,`problem`,`suqiu`,`title`,`content`,`addtime`,`state`,`image`,`imagename`,`cause`,`tid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodnttousu.getId());
		dbc.setInt(2, dbodnttousu.getUid());
		dbc.setString(3, dbodnttousu.getName());
		dbc.setString(4, dbodnttousu.getPhone());
		dbc.setString(5, dbodnttousu.getEmail());
		dbc.setString(6, dbodnttousu.getPort());
		dbc.setString(7, dbodnttousu.getAddress());
		dbc.setString(8, dbodnttousu.getHao());
		dbc.setString(9, dbodnttousu.getLc());
		dbc.setString(10, dbodnttousu.getFdj());
		dbc.setString(11, dbodnttousu.getCj());
		dbc.setInt(12, dbodnttousu.getSerial());
		dbc.setTimestamp(13, new Timestamp(dbodnttousu.getBuydate().getTime()));
		dbc.setString(14, dbodnttousu.getSsssname());
		dbc.setString(15, dbodnttousu.getSssstel());
		dbc.setInt(16, dbodnttousu.getXladdress());
		dbc.setInt(17, dbodnttousu.getCarstate());
		dbc.setString(18, dbodnttousu.getProblem());
		dbc.setString(19, dbodnttousu.getSuqiu());
		dbc.setString(20, dbodnttousu.getTitle());
		dbc.setString(21, dbodnttousu.getContent());
		dbc.setTimestamp(22, new Timestamp(dbodnttousu.getAddtime().getTime()));
		dbc.setInt(23, dbodnttousu.getState());
		dbc.setString(24, dbodnttousu.getImage());
		dbc.setString(25, dbodnttousu.getImagename());
		dbc.setString(26, dbodnttousu.getCause());
		dbc.setInt(27, dbodnttousu.getTid());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,DboDntTousu dbodnttousu) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into dbo_dnt_tousu(`id`,`uid`,`name`,`phone`,`email`,`port`,`address`,`hao`,`lc`,`fdj`,`cj`,`serial`,`buydate`,`ssssname`,`sssstel`,`xladdress`,`carstate`,`problem`,`suqiu`,`title`,`content`,`addtime`,`state`,`image`,`imagename`,`cause`,`tid`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, dbodnttousu.getId());
		dbc.setInt(2, dbodnttousu.getUid());
		dbc.setString(3, dbodnttousu.getName());
		dbc.setString(4, dbodnttousu.getPhone());
		dbc.setString(5, dbodnttousu.getEmail());
		dbc.setString(6, dbodnttousu.getPort());
		dbc.setString(7, dbodnttousu.getAddress());
		dbc.setString(8, dbodnttousu.getHao());
		dbc.setString(9, dbodnttousu.getLc());
		dbc.setString(10, dbodnttousu.getFdj());
		dbc.setString(11, dbodnttousu.getCj());
		dbc.setInt(12, dbodnttousu.getSerial());
		dbc.setTimestamp(13, new Timestamp(dbodnttousu.getBuydate().getTime()));
		dbc.setString(14, dbodnttousu.getSsssname());
		dbc.setString(15, dbodnttousu.getSssstel());
		dbc.setInt(16, dbodnttousu.getXladdress());
		dbc.setInt(17, dbodnttousu.getCarstate());
		dbc.setString(18, dbodnttousu.getProblem());
		dbc.setString(19, dbodnttousu.getSuqiu());
		dbc.setString(20, dbodnttousu.getTitle());
		dbc.setString(21, dbodnttousu.getContent());
		dbc.setTimestamp(22, new Timestamp(dbodnttousu.getAddtime().getTime()));
		dbc.setInt(23, dbodnttousu.getState());
		dbc.setString(24, dbodnttousu.getImage());
		dbc.setString(25, dbodnttousu.getImagename());
		dbc.setString(26, dbodnttousu.getCause());
		dbc.setInt(27, dbodnttousu.getTid());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,DboDntTousu dbodnttousu) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update dbo_dnt_tousu set ");
		boolean flag = false;
		if(dbodnttousu.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",id=?");
			}else{
				sb.append("id=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",uid=?");
			}else{
				sb.append("uid=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",email=?");
			}else{
				sb.append("email=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",port=?");
			}else{
				sb.append("port=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",address=?");
			}else{
				sb.append("address=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",hao=?");
			}else{
				sb.append("hao=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",lc=?");
			}else{
				sb.append("lc=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",fdj=?");
			}else{
				sb.append("fdj=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",cj=?");
			}else{
				sb.append("cj=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",serial=?");
			}else{
				sb.append("serial=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",buydate=?");
			}else{
				sb.append("buydate=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",ssssname=?");
			}else{
				sb.append("ssssname=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",sssstel=?");
			}else{
				sb.append("sssstel=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",xladdress=?");
			}else{
				sb.append("xladdress=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",carstate=?");
			}else{
				sb.append("carstate=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",problem=?");
			}else{
				sb.append("problem=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",suqiu=?");
			}else{
				sb.append("suqiu=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",title=?");
			}else{
				sb.append("title=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",content=?");
			}else{
				sb.append("content=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",addtime=?");
			}else{
				sb.append("addtime=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",state=?");
			}else{
				sb.append("state=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",image=?");
			}else{
				sb.append("image=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",imagename=?");
			}else{
				sb.append("imagename=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",cause=?");
			}else{
				sb.append("cause=?");
				flag=true;
			}
		}
		if(dbodnttousu.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",tid=?");
			}else{
				sb.append("tid=?");
				flag=true;
			}
		}
		sb.append(" where id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(dbodnttousu.COLUMN_FLAG[0]){
			dbc.setInt(k, dbodnttousu.getId());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[1]){
			dbc.setInt(k, dbodnttousu.getUid());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[2]){
			dbc.setString(k, dbodnttousu.getName());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[3]){
			dbc.setString(k, dbodnttousu.getPhone());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[4]){
			dbc.setString(k, dbodnttousu.getEmail());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[5]){
			dbc.setString(k, dbodnttousu.getPort());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[6]){
			dbc.setString(k, dbodnttousu.getAddress());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[7]){
			dbc.setString(k, dbodnttousu.getHao());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[8]){
			dbc.setString(k, dbodnttousu.getLc());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[9]){
			dbc.setString(k, dbodnttousu.getFdj());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[10]){
			dbc.setString(k, dbodnttousu.getCj());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[11]){
			dbc.setInt(k, dbodnttousu.getSerial());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[12]){
			dbc.setTimestamp(k, new Timestamp(dbodnttousu.getBuydate().getTime()));k++;
		}
		if(dbodnttousu.COLUMN_FLAG[13]){
			dbc.setString(k, dbodnttousu.getSsssname());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[14]){
			dbc.setString(k, dbodnttousu.getSssstel());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[15]){
			dbc.setInt(k, dbodnttousu.getXladdress());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[16]){
			dbc.setInt(k, dbodnttousu.getCarstate());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[17]){
			dbc.setString(k, dbodnttousu.getProblem());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[18]){
			dbc.setString(k, dbodnttousu.getSuqiu());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[19]){
			dbc.setString(k, dbodnttousu.getTitle());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[20]){
			dbc.setString(k, dbodnttousu.getContent());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[21]){
			dbc.setTimestamp(k, new Timestamp(dbodnttousu.getAddtime().getTime()));k++;
		}
		if(dbodnttousu.COLUMN_FLAG[22]){
			dbc.setInt(k, dbodnttousu.getState());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[23]){
			dbc.setString(k, dbodnttousu.getImage());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[24]){
			dbc.setString(k, dbodnttousu.getImagename());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[25]){
			dbc.setString(k, dbodnttousu.getCause());k++;
		}
		if(dbodnttousu.COLUMN_FLAG[26]){
			dbc.setInt(k, dbodnttousu.getTid());k++;
		}
		dbc.setInt(k, dbodnttousu.getId());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(DboDntTousu dbodnttousu) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, dbodnttousu);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}