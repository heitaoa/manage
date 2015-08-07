package car_daos;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class  DboDelForIdFileDao  extends BaseDao {

	synchronized static Set<Integer> findImgContent(String htmName) {
		DBConnect dbc = null;
		String sql = "select w.catalogid,w.fatherid,(select n.fatherid from dbo_car_catalognew n where n.catalogid = w.fatherid) as brandid from dbo_car_catalognew w where fatherid = (select fatherid from dbo_car_catalognew where catalogid = (select catalogid from dbo_img_content where id = "+htmName+")) and isdelete !=1;";
		Set<Integer> list = new HashSet<Integer>();
		
		try {
			list.add(Integer.parseInt(htmName));
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("catalogid"));
				list.add(rs.getInt("fatherid"));
				list.add(rs.getInt("brandid"));
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
	
	synchronized static Set<Integer> findCarCatalogNew(String htmName) {
		DBConnect dbc = null;
		String sql = "select catalogid,fatherid from dbo_car_catalognew where catalogid="+htmName+" or fatherid="+htmName+" and isdelete!=1";
		Set<Integer> list = new HashSet<Integer>();
		
		try {
			dbc = new DBConnect(sql);
			ResultSet rs = dbc.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("catalogid"));
				list.add(rs.getInt("fatherid"));
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

	/*
	 * @param htmName 传入任意id(id,catalogid,titleid)
	 * @return 返回的id用于删除静态页 --根据车系
	 */
	public static Set<Integer> inCarCatalogNew(String htmName) {
		Set<Integer> list = new HashSet<Integer>();
		list.addAll(findCarCatalogNew(htmName));
		Set<Integer> carCatalogNewList = new HashSet<Integer>();
		//循环一层
		if(!list.isEmpty()){
			Iterator<Integer> iterList = list.iterator();
			while(iterList.hasNext()){
				String strNext = iterList.next()+"";
				carCatalogNewList.addAll(findCarCatalogNew(strNext));
			}
		}
		list.addAll(carCatalogNewList);
		return list;
	}
	

 
	/* 
	 * @param htmName 传入任意id(id,catalogid,titleid)
	 * @return 返回的id用于删除静态页 --根据图片信息表
	 */
	public static Set<Integer> inImgContent(String htmName) {
		Set<Integer> list = new HashSet<Integer>();
		list.addAll(findImgContent(htmName));
		return list;
	}
	
	
}