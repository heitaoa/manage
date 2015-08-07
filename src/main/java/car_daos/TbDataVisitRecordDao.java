package car_daos;
import java.sql.*;
import java.util.*;
import car_beans.*;
import car_daos.DBConnect;
import car_beans.TbDataVisitRecord;

public class  TbDataVisitRecordDao  extends BaseDao {

	public static void fill(ResultSet rs, TbDataVisitRecord tbdatavisitrecord) throws SQLException {
		tbdatavisitrecord.setRecord_id(rs.getInt("record_id"));//����id
		tbdatavisitrecord.setPro_num(rs.getString("pro_num"));//��Ŀ���
		tbdatavisitrecord.setPhone(rs.getString("phone"));//�ֻ���
		tbdatavisitrecord.setName(rs.getString("name"));//����
		tbdatavisitrecord.setBaoming_id(rs.getInt("baoming_id"));//����id
		tbdatavisitrecord.setReturn_visit_state(rs.getInt("return_visit_state"));//�ط�״̬ 0-δ�ط� 1-һ�� 2-���� 3-���� 4- ����
		tbdatavisitrecord.setIs_key_cus(rs.getInt("is_key_cus"));//�ͻ����� 0-��ͨ�ͻ� 1-�ص�ͻ�
		tbdatavisitrecord.setPhoneerror(rs.getInt("phoneerror"));//�绰�ܷ��ͨ  0-�ѽ�ͨ 1-δ��ͨ
		tbdatavisitrecord.setReturn_visit_time(rs.getTimestamp("return_visit_time"));//�ط�ʱ��
		tbdatavisitrecord.setReturn_visit_content(rs.getString("return_visit_content"));//�ط�����
		tbdatavisitrecord.setReturn_visit_man(rs.getString("return_visit_man"));//�ط�������
		tbdatavisitrecord.setTuisong_flag(rs.getInt("tuisong_flag"));//�Ƿ����� 0- δ���� 1- ������
		tbdatavisitrecord.setAttend_type(rs.getInt("attend_type"));//���ŷ�ʽ 0-�޲�����1-�μӣ����ŵ� 2-�μӣ����е� 3-�μӣ���ȷ�� 4-���ܲμ� 5-���μ�
		tbdatavisitrecord.setAttend_date(rs.getString("attend_date"));//��������
		tbdatavisitrecord.setPhone_state(rs.getInt("phone_state"));//�ֻ�״̬ 0-��Ч 1-��Ч 2-�ظ�����
		tbdatavisitrecord.setIs_jp(rs.getInt("is_jp"));//�Ƿ��о�Ʒ  0-�� 1-��
		tbdatavisitrecord.setJp_car(rs.getString("jp_car"));//��Ʒ��ϵ
		tbdatavisitrecord.setIs_buycar(rs.getInt("is_buycar"));//�Ƿ񹺳� 0-�� 1-��
		tbdatavisitrecord.setBuy_state(rs.getInt("buy_state"));//������� 0-�³�ȫ�� 1-�³����� 2-�û�ȫ�� 3-��������
		tbdatavisitrecord.setPhoneerror_count(rs.getInt("phoneerror_count"));//�绰δ��������
		tbdatavisitrecord.setIs_reach(rs.getInt("is_reach"));//�Ƿ񵽵�
		tbdatavisitrecord.setIs_trans(rs.getInt("is_trans"));//�Ƿ�ɽ�
		tbdatavisitrecord.setIs_invite(rs.getInt("is_invite"));//�Ƿ���Լ
		tbdatavisitrecord.setBrand(rs.getInt("brand"));//Ʒ��id
		tbdatavisitrecord.setSerial(rs.getInt("serial"));//������ϵid
		tbdatavisitrecord.setModel(rs.getInt("model"));//����id
		tbdatavisitrecord.setPhone_prov(rs.getInt("phone_prov"));//�ֻ�ʡ
		tbdatavisitrecord.setPhone_city(rs.getInt("phone_city"));//�ֻ���
		tbdatavisitrecord.setIp(rs.getString("ip"));//ip��ַ
		tbdatavisitrecord.setProv(rs.getInt("prov"));//����ʡ��
		tbdatavisitrecord.setCity(rs.getInt("city"));//��������
		tbdatavisitrecord.setBuycar_emergency(rs.getInt("buycar_emergency"));//0-δ֪ 1-���� 2-2���� 3-һ������ 4-3������ 5-3�������� 6 -��ʱ
		tbdatavisitrecord.setPp_state(rs.getString("pp_state"));//����״̬
		tbdatavisitrecord.setPz_city(rs.getString("pz_city"));//���ճ���
		tbdatavisitrecord.setBuy_ys(rs.getString("buy_ys"));//����Ԥ��
		tbdatavisitrecord.setBuy_bsx(rs.getInt("buy_bsx"));//������ 0-�Զ� 1-�ֶ� 2-����
		tbdatavisitrecord.setBuy_pl(rs.getString("buy_pl"));//����
		tbdatavisitrecord.setBuy_color(rs.getString("buy_color"));//��ɫ
		tbdatavisitrecord.setKnow_yh(rs.getString("know_yh"));//4s�˽��Ż�
		tbdatavisitrecord.setP_job(rs.getInt("p_job"));//ְҵ 0-���� 1-˽�� 2-����
		tbdatavisitrecord.setP_weixin(rs.getString("p_weixin"));//΢��
		tbdatavisitrecord.setP_qq(rs.getString("p_qq"));//qq
		tbdatavisitrecord.setBaoming_date(rs.getTimestamp("baoming_date"));//����ʱ��
		tbdatavisitrecord.setBz(rs.getString("bz"));//��ע
		tbdatavisitrecord.setRequire(rs.getInt("require"));//�������(0-����,2-���գ�3-����)
		tbdatavisitrecord.setResearch(rs.getInt("research"));//�Ƿ���ܵ��� 0-��ѡ�� 1-�� 2-��
		tbdatavisitrecord.setNot_store_reason(rs.getString("not_store_reason"));//δ����ԭ��
		tbdatavisitrecord.setLose_reason(rs.getInt("lose_reason"));//ʧ��ԭ�� 0-��ѡ�� 1-�۸񲻵�λ 2-4s����� 3-û���ֳ� 4-�ͻ���Ʒ�Ƚ��� 5-4s������Զ 6-����û���� 7-����û�ĵ� 8-����ղ����� 9-С�ַ����ܵ�
		tbdatavisitrecord.setSatisfy(rs.getInt("satisfy"));//��������� 0-δѡ�� 1-���� 2-һ�� 3-������
		tbdatavisitrecord.setAdvise(rs.getString("advise"));//���������
		tbdatavisitrecord.setSatisfy_date(rs.getTimestamp("satisfy_date"));//���������ʱ��
		tbdatavisitrecord.setSatisfy_state(rs.getInt("satisfy_state"));//���� 0-δ���� 1-������
	}

	public static List<TbDataVisitRecord> find() {
		DBConnect dbc = null;
		String sql = "select * from tb_data_visit_record";
		List<TbDataVisitRecord> list = new ArrayList<TbDataVisitRecord>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataVisitRecord tbdatavisitrecord = new TbDataVisitRecord();
				fill(rs, tbdatavisitrecord);
				list.add(tbdatavisitrecord);
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


	public static List<TbDataVisitRecord> where(String subsql) {
		DBConnect dbc = null;
		String sql = "select * from tb_data_visit_record where "+subsql+"";
		List<TbDataVisitRecord> list = new ArrayList<TbDataVisitRecord>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				TbDataVisitRecord tbdatavisitrecord = new TbDataVisitRecord();
				fill(rs, tbdatavisitrecord);
				list.add(tbdatavisitrecord);
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
		String sql = "select count(*) from tb_data_visit_record where "+subsql+"";
		
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
		String sql = "delete from tb_data_visit_record where "+subsql+"";
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
		String sql = "delete from tb_data_visit_record where "+subsql+"";
		try {
			dbc.prepareStatement(sql);
			dbc.executeUpdate();
			result = EXECUTE_SUCCESSS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int save(TbDataVisitRecord tbdatavisitrecord) throws Exception {
		int result = EXECUTE_FAIL;
		DBConnect dbc = null;
		String sql = "insert into tb_data_visit_record(`record_id`,`pro_num`,`phone`,`name`,`baoming_id`,`return_visit_state`,`is_key_cus`,`phoneerror`,`return_visit_time`,`return_visit_content`,`return_visit_man`,`tuisong_flag`,`attend_type`,`attend_date`,`phone_state`,`is_jp`,`jp_car`,`is_buycar`,`buy_state`,`phoneerror_count`,`is_reach`,`is_trans`,`is_invite`,`brand`,`serial`,`model`,`phone_prov`,`phone_city`,`ip`,`prov`,`city`,`buycar_emergency`,`pp_state`,`pz_city`,`buy_ys`,`buy_bsx`,`buy_pl`,`buy_color`,`know_yh`,`p_job`,`p_weixin`,`p_qq`,`baoming_date`,`bz`,`require`,`research`,`not_store_reason`,`lose_reason`,`satisfy`,`advise`,`satisfy_date`,`satisfy_state`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc = new DBConnect();
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatavisitrecord.getRecord_id());
		dbc.setString(2, tbdatavisitrecord.getPro_num());
		dbc.setString(3, tbdatavisitrecord.getPhone());
		dbc.setString(4, tbdatavisitrecord.getName());
		dbc.setInt(5, tbdatavisitrecord.getBaoming_id());
		dbc.setInt(6, tbdatavisitrecord.getReturn_visit_state());
		dbc.setInt(7, tbdatavisitrecord.getIs_key_cus());
		dbc.setInt(8, tbdatavisitrecord.getPhoneerror());
		dbc.setTimestamp(9, new Timestamp(tbdatavisitrecord.getReturn_visit_time().getTime()));
		dbc.setString(10, tbdatavisitrecord.getReturn_visit_content());
		dbc.setString(11, tbdatavisitrecord.getReturn_visit_man());
		dbc.setInt(12, tbdatavisitrecord.getTuisong_flag());
		dbc.setInt(13, tbdatavisitrecord.getAttend_type());
		dbc.setString(14, tbdatavisitrecord.getAttend_date());
		dbc.setInt(15, tbdatavisitrecord.getPhone_state());
		dbc.setInt(16, tbdatavisitrecord.getIs_jp());
		dbc.setString(17, tbdatavisitrecord.getJp_car());
		dbc.setInt(18, tbdatavisitrecord.getIs_buycar());
		dbc.setInt(19, tbdatavisitrecord.getBuy_state());
		dbc.setInt(20, tbdatavisitrecord.getPhoneerror_count());
		dbc.setInt(21, tbdatavisitrecord.getIs_reach());
		dbc.setInt(22, tbdatavisitrecord.getIs_trans());
		dbc.setInt(23, tbdatavisitrecord.getIs_invite());
		dbc.setInt(24, tbdatavisitrecord.getBrand());
		dbc.setInt(25, tbdatavisitrecord.getSerial());
		dbc.setInt(26, tbdatavisitrecord.getModel());
		dbc.setInt(27, tbdatavisitrecord.getPhone_prov());
		dbc.setInt(28, tbdatavisitrecord.getPhone_city());
		dbc.setString(29, tbdatavisitrecord.getIp());
		dbc.setInt(30, tbdatavisitrecord.getProv());
		dbc.setInt(31, tbdatavisitrecord.getCity());
		dbc.setInt(32, tbdatavisitrecord.getBuycar_emergency());
		dbc.setString(33, tbdatavisitrecord.getPp_state());
		dbc.setString(34, tbdatavisitrecord.getPz_city());
		dbc.setString(35, tbdatavisitrecord.getBuy_ys());
		dbc.setInt(36, tbdatavisitrecord.getBuy_bsx());
		dbc.setString(37, tbdatavisitrecord.getBuy_pl());
		dbc.setString(38, tbdatavisitrecord.getBuy_color());
		dbc.setString(39, tbdatavisitrecord.getKnow_yh());
		dbc.setInt(40, tbdatavisitrecord.getP_job());
		dbc.setString(41, tbdatavisitrecord.getP_weixin());
		dbc.setString(42, tbdatavisitrecord.getP_qq());
		dbc.setTimestamp(43, new Timestamp(tbdatavisitrecord.getBaoming_date().getTime()));
		dbc.setString(44, tbdatavisitrecord.getBz());
		dbc.setInt(45, tbdatavisitrecord.getRequire());
		dbc.setInt(46, tbdatavisitrecord.getResearch());
		dbc.setString(47, tbdatavisitrecord.getNot_store_reason());
		dbc.setInt(48, tbdatavisitrecord.getLose_reason());
		dbc.setInt(49, tbdatavisitrecord.getSatisfy());
		dbc.setString(50, tbdatavisitrecord.getAdvise());
		dbc.setTimestamp(51, new Timestamp(tbdatavisitrecord.getSatisfy_date().getTime()));
		dbc.setInt(52, tbdatavisitrecord.getSatisfy_state());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int save(DBConnect dbc,TbDataVisitRecord tbdatavisitrecord) throws Exception {
		int result = EXECUTE_FAIL;
		String sql = "insert into tb_data_visit_record(`record_id`,`pro_num`,`phone`,`name`,`baoming_id`,`return_visit_state`,`is_key_cus`,`phoneerror`,`return_visit_time`,`return_visit_content`,`return_visit_man`,`tuisong_flag`,`attend_type`,`attend_date`,`phone_state`,`is_jp`,`jp_car`,`is_buycar`,`buy_state`,`phoneerror_count`,`is_reach`,`is_trans`,`is_invite`,`brand`,`serial`,`model`,`phone_prov`,`phone_city`,`ip`,`prov`,`city`,`buycar_emergency`,`pp_state`,`pz_city`,`buy_ys`,`buy_bsx`,`buy_pl`,`buy_color`,`know_yh`,`p_job`,`p_weixin`,`p_qq`,`baoming_date`,`bz`,`require`,`research`,`not_store_reason`,`lose_reason`,`satisfy`,`advise`,`satisfy_date`,`satisfy_state`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		dbc.prepareStatement(sql);
		dbc.setInt(1, tbdatavisitrecord.getRecord_id());
		dbc.setString(2, tbdatavisitrecord.getPro_num());
		dbc.setString(3, tbdatavisitrecord.getPhone());
		dbc.setString(4, tbdatavisitrecord.getName());
		dbc.setInt(5, tbdatavisitrecord.getBaoming_id());
		dbc.setInt(6, tbdatavisitrecord.getReturn_visit_state());
		dbc.setInt(7, tbdatavisitrecord.getIs_key_cus());
		dbc.setInt(8, tbdatavisitrecord.getPhoneerror());
		dbc.setTimestamp(9, new Timestamp(tbdatavisitrecord.getReturn_visit_time().getTime()));
		dbc.setString(10, tbdatavisitrecord.getReturn_visit_content());
		dbc.setString(11, tbdatavisitrecord.getReturn_visit_man());
		dbc.setInt(12, tbdatavisitrecord.getTuisong_flag());
		dbc.setInt(13, tbdatavisitrecord.getAttend_type());
		dbc.setString(14, tbdatavisitrecord.getAttend_date());
		dbc.setInt(15, tbdatavisitrecord.getPhone_state());
		dbc.setInt(16, tbdatavisitrecord.getIs_jp());
		dbc.setString(17, tbdatavisitrecord.getJp_car());
		dbc.setInt(18, tbdatavisitrecord.getIs_buycar());
		dbc.setInt(19, tbdatavisitrecord.getBuy_state());
		dbc.setInt(20, tbdatavisitrecord.getPhoneerror_count());
		dbc.setInt(21, tbdatavisitrecord.getIs_reach());
		dbc.setInt(22, tbdatavisitrecord.getIs_trans());
		dbc.setInt(23, tbdatavisitrecord.getIs_invite());
		dbc.setInt(24, tbdatavisitrecord.getBrand());
		dbc.setInt(25, tbdatavisitrecord.getSerial());
		dbc.setInt(26, tbdatavisitrecord.getModel());
		dbc.setInt(27, tbdatavisitrecord.getPhone_prov());
		dbc.setInt(28, tbdatavisitrecord.getPhone_city());
		dbc.setString(29, tbdatavisitrecord.getIp());
		dbc.setInt(30, tbdatavisitrecord.getProv());
		dbc.setInt(31, tbdatavisitrecord.getCity());
		dbc.setInt(32, tbdatavisitrecord.getBuycar_emergency());
		dbc.setString(33, tbdatavisitrecord.getPp_state());
		dbc.setString(34, tbdatavisitrecord.getPz_city());
		dbc.setString(35, tbdatavisitrecord.getBuy_ys());
		dbc.setInt(36, tbdatavisitrecord.getBuy_bsx());
		dbc.setString(37, tbdatavisitrecord.getBuy_pl());
		dbc.setString(38, tbdatavisitrecord.getBuy_color());
		dbc.setString(39, tbdatavisitrecord.getKnow_yh());
		dbc.setInt(40, tbdatavisitrecord.getP_job());
		dbc.setString(41, tbdatavisitrecord.getP_weixin());
		dbc.setString(42, tbdatavisitrecord.getP_qq());
		dbc.setTimestamp(43, new Timestamp(tbdatavisitrecord.getBaoming_date().getTime()));
		dbc.setString(44, tbdatavisitrecord.getBz());
		dbc.setInt(45, tbdatavisitrecord.getRequire());
		dbc.setInt(46, tbdatavisitrecord.getResearch());
		dbc.setString(47, tbdatavisitrecord.getNot_store_reason());
		dbc.setInt(48, tbdatavisitrecord.getLose_reason());
		dbc.setInt(49, tbdatavisitrecord.getSatisfy());
		dbc.setString(50, tbdatavisitrecord.getAdvise());
		dbc.setTimestamp(51, new Timestamp(tbdatavisitrecord.getSatisfy_date().getTime()));
		dbc.setInt(52, tbdatavisitrecord.getSatisfy_state());
		dbc.executeUpdate();
		result = EXECUTE_SUCCESSS;
		return result;
	}

	public static int update(DBConnect dbc,TbDataVisitRecord tbdatavisitrecord) throws Exception {
		int result = EXECUTE_FAIL;
		StringBuffer sb = new StringBuffer();
		sb.append("update tb_data_visit_record set ");
		boolean flag = false;
		if(tbdatavisitrecord.COLUMN_FLAG[0]){
			if(flag){
				sb.append(",record_id=?");
			}else{
				sb.append("record_id=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[1]){
			if(flag){
				sb.append(",pro_num=?");
			}else{
				sb.append("pro_num=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[2]){
			if(flag){
				sb.append(",phone=?");
			}else{
				sb.append("phone=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[3]){
			if(flag){
				sb.append(",name=?");
			}else{
				sb.append("name=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[4]){
			if(flag){
				sb.append(",baoming_id=?");
			}else{
				sb.append("baoming_id=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[5]){
			if(flag){
				sb.append(",return_visit_state=?");
			}else{
				sb.append("return_visit_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[6]){
			if(flag){
				sb.append(",is_key_cus=?");
			}else{
				sb.append("is_key_cus=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[7]){
			if(flag){
				sb.append(",phoneerror=?");
			}else{
				sb.append("phoneerror=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[8]){
			if(flag){
				sb.append(",return_visit_time=?");
			}else{
				sb.append("return_visit_time=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[9]){
			if(flag){
				sb.append(",return_visit_content=?");
			}else{
				sb.append("return_visit_content=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[10]){
			if(flag){
				sb.append(",return_visit_man=?");
			}else{
				sb.append("return_visit_man=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[11]){
			if(flag){
				sb.append(",tuisong_flag=?");
			}else{
				sb.append("tuisong_flag=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[12]){
			if(flag){
				sb.append(",attend_type=?");
			}else{
				sb.append("attend_type=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[13]){
			if(flag){
				sb.append(",attend_date=?");
			}else{
				sb.append("attend_date=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[14]){
			if(flag){
				sb.append(",phone_state=?");
			}else{
				sb.append("phone_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[15]){
			if(flag){
				sb.append(",is_jp=?");
			}else{
				sb.append("is_jp=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[16]){
			if(flag){
				sb.append(",jp_car=?");
			}else{
				sb.append("jp_car=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[17]){
			if(flag){
				sb.append(",is_buycar=?");
			}else{
				sb.append("is_buycar=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[18]){
			if(flag){
				sb.append(",buy_state=?");
			}else{
				sb.append("buy_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[19]){
			if(flag){
				sb.append(",phoneerror_count=?");
			}else{
				sb.append("phoneerror_count=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[20]){
			if(flag){
				sb.append(",is_reach=?");
			}else{
				sb.append("is_reach=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[21]){
			if(flag){
				sb.append(",is_trans=?");
			}else{
				sb.append("is_trans=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[22]){
			if(flag){
				sb.append(",is_invite=?");
			}else{
				sb.append("is_invite=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[23]){
			if(flag){
				sb.append(",brand=?");
			}else{
				sb.append("brand=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[24]){
			if(flag){
				sb.append(",serial=?");
			}else{
				sb.append("serial=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[25]){
			if(flag){
				sb.append(",model=?");
			}else{
				sb.append("model=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[26]){
			if(flag){
				sb.append(",phone_prov=?");
			}else{
				sb.append("phone_prov=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[27]){
			if(flag){
				sb.append(",phone_city=?");
			}else{
				sb.append("phone_city=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[28]){
			if(flag){
				sb.append(",ip=?");
			}else{
				sb.append("ip=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[29]){
			if(flag){
				sb.append(",prov=?");
			}else{
				sb.append("prov=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[30]){
			if(flag){
				sb.append(",city=?");
			}else{
				sb.append("city=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[31]){
			if(flag){
				sb.append(",buycar_emergency=?");
			}else{
				sb.append("buycar_emergency=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[32]){
			if(flag){
				sb.append(",pp_state=?");
			}else{
				sb.append("pp_state=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[33]){
			if(flag){
				sb.append(",pz_city=?");
			}else{
				sb.append("pz_city=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[34]){
			if(flag){
				sb.append(",buy_ys=?");
			}else{
				sb.append("buy_ys=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[35]){
			if(flag){
				sb.append(",buy_bsx=?");
			}else{
				sb.append("buy_bsx=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[36]){
			if(flag){
				sb.append(",buy_pl=?");
			}else{
				sb.append("buy_pl=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[37]){
			if(flag){
				sb.append(",buy_color=?");
			}else{
				sb.append("buy_color=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[38]){
			if(flag){
				sb.append(",know_yh=?");
			}else{
				sb.append("know_yh=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[39]){
			if(flag){
				sb.append(",p_job=?");
			}else{
				sb.append("p_job=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[40]){
			if(flag){
				sb.append(",p_weixin=?");
			}else{
				sb.append("p_weixin=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[41]){
			if(flag){
				sb.append(",p_qq=?");
			}else{
				sb.append("p_qq=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[42]){
			if(flag){
				sb.append(",baoming_date=?");
			}else{
				sb.append("baoming_date=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[43]){
			if(flag){
				sb.append(",bz=?");
			}else{
				sb.append("bz=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[44]){
			if(flag){
				sb.append(",require=?");
			}else{
				sb.append("require=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[45]){
			if(flag){
				sb.append(",research=?");
			}else{
				sb.append("research=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[46]){
			if(flag){
				sb.append(",not_store_reason=?");
			}else{
				sb.append("not_store_reason=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[47]){
			if(flag){
				sb.append(",lose_reason=?");
			}else{
				sb.append("lose_reason=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[48]){
			if(flag){
				sb.append(",satisfy=?");
			}else{
				sb.append("satisfy=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[49]){
			if(flag){
				sb.append(",advise=?");
			}else{
				sb.append("advise=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[50]){
			if(flag){
				sb.append(",satisfy_date=?");
			}else{
				sb.append("satisfy_date=?");
				flag=true;
			}
		}
		if(tbdatavisitrecord.COLUMN_FLAG[51]){
			if(flag){
				sb.append(",satisfy_state=?");
			}else{
				sb.append("satisfy_state=?");
				flag=true;
			}
		}
		sb.append(" where record_id=?");
		dbc = new DBConnect();
		dbc.prepareStatement(sb.toString());
		int k=1;
		if(tbdatavisitrecord.COLUMN_FLAG[0]){
			dbc.setInt(k, tbdatavisitrecord.getRecord_id());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[1]){
			dbc.setString(k, tbdatavisitrecord.getPro_num());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[2]){
			dbc.setString(k, tbdatavisitrecord.getPhone());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[3]){
			dbc.setString(k, tbdatavisitrecord.getName());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[4]){
			dbc.setInt(k, tbdatavisitrecord.getBaoming_id());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[5]){
			dbc.setInt(k, tbdatavisitrecord.getReturn_visit_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[6]){
			dbc.setInt(k, tbdatavisitrecord.getIs_key_cus());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[7]){
			dbc.setInt(k, tbdatavisitrecord.getPhoneerror());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[8]){
			dbc.setTimestamp(k, new Timestamp(tbdatavisitrecord.getReturn_visit_time().getTime()));k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[9]){
			dbc.setString(k, tbdatavisitrecord.getReturn_visit_content());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[10]){
			dbc.setString(k, tbdatavisitrecord.getReturn_visit_man());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[11]){
			dbc.setInt(k, tbdatavisitrecord.getTuisong_flag());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[12]){
			dbc.setInt(k, tbdatavisitrecord.getAttend_type());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[13]){
			dbc.setString(k, tbdatavisitrecord.getAttend_date());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[14]){
			dbc.setInt(k, tbdatavisitrecord.getPhone_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[15]){
			dbc.setInt(k, tbdatavisitrecord.getIs_jp());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[16]){
			dbc.setString(k, tbdatavisitrecord.getJp_car());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[17]){
			dbc.setInt(k, tbdatavisitrecord.getIs_buycar());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[18]){
			dbc.setInt(k, tbdatavisitrecord.getBuy_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[19]){
			dbc.setInt(k, tbdatavisitrecord.getPhoneerror_count());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[20]){
			dbc.setInt(k, tbdatavisitrecord.getIs_reach());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[21]){
			dbc.setInt(k, tbdatavisitrecord.getIs_trans());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[22]){
			dbc.setInt(k, tbdatavisitrecord.getIs_invite());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[23]){
			dbc.setInt(k, tbdatavisitrecord.getBrand());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[24]){
			dbc.setInt(k, tbdatavisitrecord.getSerial());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[25]){
			dbc.setInt(k, tbdatavisitrecord.getModel());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[26]){
			dbc.setInt(k, tbdatavisitrecord.getPhone_prov());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[27]){
			dbc.setInt(k, tbdatavisitrecord.getPhone_city());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[28]){
			dbc.setString(k, tbdatavisitrecord.getIp());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[29]){
			dbc.setInt(k, tbdatavisitrecord.getProv());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[30]){
			dbc.setInt(k, tbdatavisitrecord.getCity());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[31]){
			dbc.setInt(k, tbdatavisitrecord.getBuycar_emergency());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[32]){
			dbc.setString(k, tbdatavisitrecord.getPp_state());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[33]){
			dbc.setString(k, tbdatavisitrecord.getPz_city());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[34]){
			dbc.setString(k, tbdatavisitrecord.getBuy_ys());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[35]){
			dbc.setInt(k, tbdatavisitrecord.getBuy_bsx());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[36]){
			dbc.setString(k, tbdatavisitrecord.getBuy_pl());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[37]){
			dbc.setString(k, tbdatavisitrecord.getBuy_color());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[38]){
			dbc.setString(k, tbdatavisitrecord.getKnow_yh());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[39]){
			dbc.setInt(k, tbdatavisitrecord.getP_job());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[40]){
			dbc.setString(k, tbdatavisitrecord.getP_weixin());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[41]){
			dbc.setString(k, tbdatavisitrecord.getP_qq());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[42]){
			dbc.setTimestamp(k, new Timestamp(tbdatavisitrecord.getBaoming_date().getTime()));k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[43]){
			dbc.setString(k, tbdatavisitrecord.getBz());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[44]){
			dbc.setInt(k, tbdatavisitrecord.getRequire());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[45]){
			dbc.setInt(k, tbdatavisitrecord.getResearch());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[46]){
			dbc.setString(k, tbdatavisitrecord.getNot_store_reason());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[47]){
			dbc.setInt(k, tbdatavisitrecord.getLose_reason());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[48]){
			dbc.setInt(k, tbdatavisitrecord.getSatisfy());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[49]){
			dbc.setString(k, tbdatavisitrecord.getAdvise());k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[50]){
			dbc.setTimestamp(k, new Timestamp(tbdatavisitrecord.getSatisfy_date().getTime()));k++;
		}
		if(tbdatavisitrecord.COLUMN_FLAG[51]){
			dbc.setInt(k, tbdatavisitrecord.getSatisfy_state());k++;
		}
		dbc.setInt(k, tbdatavisitrecord.getRecord_id());
		dbc.executeUpdate();
		dbc.close();
		result = EXECUTE_SUCCESSS;
		return result;
	}
	public static int update(TbDataVisitRecord tbdatavisitrecord) {
		int result = EXECUTE_FAIL;
		try {
			DBConnect dbc = new DBConnect();
			result = update(dbc, tbdatavisitrecord);
			dbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}