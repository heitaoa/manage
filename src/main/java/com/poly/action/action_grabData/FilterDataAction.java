package com.poly.action.action_grabData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.TbApplyCount;
import car_beans.TbApplyInfo;
import car_daos.DBConnect;
import car_daos.DBConnectionManager;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalognewDao;
import car_daos.TbApplyCountDao;

import com.poly.action.MyActionSupport;
import com.poly.bean.BaoMingDataEntity;
import com.poly.service.PhoneAreaService;
import com.poly.util.syncapplyinfo.ConvertData;
import com.poly.util.syscardata.SysCarData;

/**
 * 将报名数据进行定时去重
 * 
 * @author fxh
 *
 */
public class FilterDataAction extends MyActionSupport {
	// 去重数据
	public void filterData() {
		System.err.println("对tb_data_baoming表数据去重begin---");
		Long beginTime = System.currentTimeMillis();
		try {
			List<Integer> idList = findRepeat();
        	deleteRepeat(idList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		System.err.println("对tb_data_baoming表数据去重end---");
		Long endtime = System.currentTimeMillis();
		System.out.println("对tb_data_baoming表数据去重用时：" + (endtime - beginTime) / 1000 + "秒");
	}

	static List<Integer> findRepeat() {
		DBConnect dbc = null;
		List<Integer> idList = new ArrayList<Integer>();
		String sql = "select id from (select min(id) max_id,phone,brand,serial from  tb_data_baoming where  baoming_date > date_sub(curdate(), INTERVAL 1 DAY) group by phone,brand,serial having count(*)>1) a,tb_data_baoming b where a.phone=b.phone and a.brand=b.brand and a.serial=b.serial and b.id>a.max_id and b.isDelete = 0 and b.return_visit_state=0;";
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				idList.add(rs.getInt("id"));
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
		return idList;

	}

	static void deleteRepeat(List<Integer> idList) {
		String sql = "update tb_data_baoming set isDelete = 1,return_visit_content= '重复报名，系统自动去重',return_visit_time = now() where id = ?";
		Connection con = null;

		try {
			con = DBConnectionManager.getInstance().getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(sql);
			for (int i = 0; i < idList.size(); i++) {
				pst.setInt(1, idList.get(i));
				pst.addBatch();
				if (i % 1000 == 0) {
					pst.executeBatch();
					con.commit();
					pst.clearBatch();
				}
			}
			pst.executeBatch();
			con.commit();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
