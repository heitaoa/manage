package com.poly.action.action_tousu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import net.sf.json.JSONArray;
import car_beans.DboCarCatalognew;
import car_beans.DboDntTousu;
import car_beans.DboDntTousuDetail;

import com.poly.action.MyActionSupport;
import com.poly.freemarkerMethod.ImageFormatMethod;
import com.poly.service.SaleFavoredService;
import com.poly.service.TousuService;
import com.poly.util.DeleteTosuDetailUtil;
import com.poly.util.SendMsgUtil;
import com.redis.RedisDao;

import de.innosystec.unrar.unpack.decode.Decode;
import freemarker.template.TemplateModelException;

public class TousuAction extends MyActionSupport {
	private int prov = -1;
	private int city = -1;
	private int brandId = -1;
	private int chexiId = -1;
	private int state = -2;// 头部审核状态
	private int state2 = -1;// 中部审核状态
	private String beginDate = "";// 开始时间
	private String endDate = "";// 结束时间
	private String name = "";
	private String phone = "";
	private String keyword = "";// 关键字
	private int page = 1;
	private int pages = 1;
	private int rows = 20;
	private int count = 0;
	private List<Map<String, String>> tousuList;

	// 投诉查询
	public String manage() {
		if (page < 0)
			page = 1;
		int start = (page - 1) * rows;
		tousuList = TousuService.getInstance().queryToutu(state, beginDate,
				endDate, name, phone, keyword, brandId, chexiId, prov, city,
				start, rows);
		if (tousuList.size() > 0)
			count = Integer.valueOf(tousuList.get(0).get("count"));
		if (count % rows == 0)
			pages = count / rows;
		else
			pages = count / rows + 1;
		return SUCCESS;
	}

	// 查看投诉详情
	public void queryTousuDetail() throws IOException {
		String tousuid = request.getParameter("tousuid");
		Map<String, Object> map = TousuService.getInstance().queryTousuDetail(
				Integer.valueOf(tousuid));
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");

	}

	// 获取 品牌/车系列表
	public void queryCarInfo() throws IOException {
		String fatherid = request.getParameter("fatherid");
		List<DboCarCatalognew> brands = SaleFavoredService.getInstance()
				.getCarBrandByFatherId(Integer.valueOf(fatherid));
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(brands);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
	}

	// 更新投诉状态
	public void tousuUpdate() throws IOException {
		String tousuid = request.getParameter("tousuid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String state = request.getParameter("state");
		String imgpath = request.getParameter("imgpath");
		String imgname = request.getParameter("imgname");
		String phone = request.getParameter("phone");
		
		DboDntTousu dboDntTousu = new DboDntTousu();
		dboDntTousu.setImage(getHanzi(imgpath));
		dboDntTousu.setImagename(getHanzi(imgname));
		dboDntTousu.setId(Integer.valueOf(tousuid));
		dboDntTousu.setTitle(title);
		dboDntTousu.setContent(content);
		dboDntTousu.setState(Integer.valueOf(state));
		int result = TousuService.getInstance().updateTtousu(dboDntTousu);
		
		//投诉状态是 -1 删除页面
		//phone = "18621059671";
		if("-1".equals(state)){
			DeleteTosuDetailUtil.deleteOneTousuDetail(tousuid);
			RedisDao.deleteTousuDetail(tousuid);
		}
		if("1".equals(state)){
			SendMsgUtil.SendMsg("亲，您好！您所投诉的问题，中国汽车消费网工作人员已反馈给厂家有关部门，对方表示会在一个工作日内与您取得联系，并作妥善处理。"+
				"如欲了解最新进展，请关注“汽车投诉（qichets）”微信号。", phone);
		}
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	// 查询投诉回复详情
	public void queryTousuComment() throws IOException {
		String tousuid = request.getParameter("tousuid");
		List<DboDntTousuDetail> list = TousuService.getInstance()
				.queryTousuComment(tousuid);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
	}

	// 保存投诉回复
	public void saveTousuComment() throws IOException {
		String tousuid = request.getParameter("tousuid");
		String content = request.getParameter("comment");
		DboDntTousuDetail dboDntTousuDetail = new DboDntTousuDetail();
		dboDntTousuDetail.setContent(content);
		dboDntTousuDetail.setTousuid(Integer.valueOf(tousuid));
		dboDntTousuDetail.setAddtime(new Date());
		int result = TousuService.getInstance().saveTousuDetail(
				dboDntTousuDetail);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	// 批量更新投诉状态
	public void batchUpdateTousu() throws IOException {
		String ids = request.getParameter("ids");
		String state = request.getParameter("state");
		List<DboDntTousu> tousuList = new ArrayList<DboDntTousu>();
		//List<Integer> deleteList = new ArrayList<Integer>();
		DboDntTousu tousu = null;
		if (ids != null && !"".equals(ids)) {
			String[] idArray = ids.split("#");
			for (String id : idArray) {
				if (!"".equals(id)) {
					tousu = new DboDntTousu();
					tousu.setState(Integer.valueOf(state));
					tousu.setId(Integer.valueOf(id));
					tousu.setPhone(TousuService.getInstance().queryTousuDetail(Integer.valueOf(id)).get("phone").toString());
					tousuList.add(tousu);
					
					//if("-1".equals(state)){
					//	deleteList.add(Integer.valueOf(id));
					//}
					
				}
			}
		}
		if (tousuList.size() > 0)
			TousuService.getInstance().batchUpdateTousu(tousuList);
		
		if (tousuList.size() > 0){
			if(1==Integer.valueOf(state)){
				for (DboDntTousu dboDntTousu : tousuList) {
					String phone = dboDntTousu.getPhone();
					//phone = "18621059671";
					SendMsgUtil.SendMsg("亲，您好！您所投诉的问题，中国汽车消费网工作人员已反馈给厂家有关部门，对方表示会在一个工作日内与您取得联系，并作妥善处理。"+
							"如欲了解最新进展，请关注“汽车投诉（qichets）”微信号。", phone);
				}
			}
		}
		
		//投诉状态是 -1 删除页面
		//if(deleteList.size() > 0){
		//	DeleteTosuDetailUtil.deleteMutiTousuDetail(deleteList);
		//}
				
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(1);
	}

	private int tousuid;

	// 导出单条投诉记录
	public void tousuDownload() throws Exception {
		String newName = getFileName();
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ newName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		String fi = getTemplate("tousutemplate.xls");
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		Map<String, Object> map = TousuService.getInstance().queryTousuDetail(Integer.valueOf(tousuid));
		createEXCEL(wb,sheet,map,map.get("id").toString(),0);
		wb.write(response.getOutputStream());
	}

	public void tousuBatchDownload() throws FileNotFoundException, IOException {
		String newName = getFileName();
		response.setContentType("application/msexcel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ newName);
		response.addHeader("Pargam", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		String fi = getTemplate("tousutemplate.xls");
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		List<Map<String, Object>> tousuList = TousuService.getInstance().queryToutuTotal(state, beginDate, endDate, name, phone, keyword, brandId, chexiId, prov, city);
		for(int j = 0 ; j < tousuList.size() ;j++){
			Map<String, Object> map = tousuList.get(j);
			createEXCEL(wb,sheet,map,map.get("id").toString(),j);
		}
		wb.write(response.getOutputStream());
	}

	
	void createEXCEL(HSSFWorkbook wb,HSSFSheet sheet,Map<String, Object> map,String tousuid,int j) throws FileNotFoundException, IOException{
		List<DboDntTousuDetail> list = TousuService.getInstance()
				.queryTousuComment(tousuid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		HSSFRow row = null;
		HSSFCell cell = null;
		for (int k = 0; k < 14; k++) {
			int i = k + j*14;
			switch (k) {
			case 0:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("投诉信息:"+(j+1));
				break;
			case 1:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("姓名:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("name")));
				//cell = row.createCell(2);
				//cell.setCellValue("");
				cell = row.createCell(3);
				cell.setCellValue("手机号:");
				cell = row.createCell(4);
				cell.setCellValue(getCell(map.get("phone")));
				cell = row.createCell(5);
				cell.setCellValue("邮箱:");
				cell = row.createCell(6);
				cell.setCellValue(getCell(map.get("email")));
				break;

			case 2:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("身份证:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("port")));
				//cell = row.createCell(2);
				//cell.setCellValue("");
				cell = row.createCell(3);
				cell.setCellValue("地区:");
				cell = row.createCell(4);
				cell.setCellValue(getCell(map.get("prov") + ">>"
						+ map.get("city")));
				cell = row.createCell(5);
				cell.setCellValue("详细地址:");
				cell = row.createCell(6);
				cell.setCellValue(getCell(map.get("address")));
				break;

			case 3:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("车型:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("pinpai") + ">>"
						+ map.get("chexi")));
				//cell = row.createCell(2);
				//cell.setCellValue("");
				cell = row.createCell(3);
				cell.setCellValue("车牌:");
				cell = row.createCell(4);
				cell.setCellValue(getCell(map.get("hao")));
				cell = row.createCell(5);
				cell.setCellValue("里程:");
				cell = row.createCell(6);
				cell.setCellValue(getCell(map.get("lc")));
				break;

			case 4:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("发动机号:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("fdj")));
				//cell = row.createCell(2);
				//cell.setCellValue("");
				cell = row.createCell(3);
				cell.setCellValue("车架号:");
				cell = row.createCell(4);
				cell.setCellValue(getCell(map.get("cj")));
				cell = row.createCell(5);
				cell.setCellValue("购买时间:");
				cell = row.createCell(6);
				cell.setCellValue(getCell(map.get("buydate")));
				break;

			case 5:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("4S店:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("ssssname")));
				//cell = row.createCell(2);
				//cell.setCellValue("");
				cell = row.createCell(3);
				cell.setCellValue("4s电话:");
				cell = row.createCell(4);
				cell.setCellValue(getCell(map.get("sssstel")));
				cell = row.createCell(5);
				cell.setCellValue("车辆状态:");
				cell = row.createCell(6);
				cell.setCellValue(getCell(map.get("carstate")));
				break;

			case 6:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("投诉对象:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("problem")));
				//cell = row.createCell(2);
				//cell.setCellValue("");
				cell = row.createCell(3);
				cell.setCellValue("投诉诉求:");
				cell = row.createCell(4);
				cell.setCellValue(getCell(map.get("suqiu")));
				cell = row.createCell(5);
				cell.setCellValue("投诉时间:");
				cell = row.createCell(6);
				cell.setCellValue(getCell(map.get("addtime")));
				break;

			case 7:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("标题:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("title")));
				break;

			case 8:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("投诉内容:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("content")));
				break;

			case 9:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("图片:");
				cell = row.createCell(1);
				cell.setCellValue(map.get("images").toString());
				break;
			case 10:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("流程状态:");
				cell = row.createCell(1);
				cell.setCellValue(getCell(map.get("state_")));
				break;
			case 11:
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue("回复详情:");
				cell = row.createCell(1);
				String str = "";
				for (DboDntTousuDetail detail : list) {
					str += sdf.format(detail.getAddtime()) + "   "
							+ detail.getContent() + "\r\n";
				}
				cell.setCellValue(str);
				break;
			case 12:
				row = sheet.createRow(i);
				break;
			case 13:
				row = sheet.createRow(i);
				break;
			}
		}
		
	}
	String getCell(Object obj) {
		String cell = "";
		if (obj != null)
			cell = obj.toString();
		return cell;
	}

	String getTemplate(String templateName) {
		String fi = TousuAction.class.getResource("/").getPath()
				.replace("classes/", "template")
				+ "/excel/" + templateName;
		return fi;
	}

	String getFileName() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-ddhhmmss");
		Calendar calendar = Calendar.getInstance();
		String now = sdf1.format(calendar.getTime());
		String filename = "投诉详情" + now + ".xls";
		String newName = "";
		try {
			if (request.getHeader("User-Agent").toLowerCase()
					.indexOf("firefox") > 0) {
				newName = new String(filename.getBytes("UTF-8"), "ISO8859-1");
			} else {
				if (request.getHeader("User-Agent").toUpperCase()
						.indexOf("MSIE") > 0)
					newName = URLEncoder.encode(filename, "UTF-8");
				else if (request.getHeader("User-Agent").toUpperCase()
						.indexOf("CHROME") > 0)
					newName = new String(filename.getBytes("UTF-8"),
							"ISO8859-1");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return newName;
	}
	
	private String iway = "";
	private int type = 0;//0-按渠道 1-按车系 2-按品牌
	private List<Map<String, Object>> tongjiList = null;
	int totalCount = 0;//统计总数
	public String tongji(){
		if(type == 0){
			//tongjiList = new ArrayList<Map<String,Object>>();
			tongjiList = TousuService.getInstance().queryTousuByIway(beginDate, endDate, prov, city, brandId, chexiId, iway);
			for (Map<String, Object> map : tongjiList) {
				totalCount += Integer.valueOf(map.get("count").toString());
			}
		}else if(type == 1){
			tongjiList = TousuService.getInstance().queryTousuSerialBySerial(beginDate, endDate, prov, city, iway, chexiId, brandId);
			for (Map<String, Object> map : tongjiList) {
				totalCount += Integer.valueOf(map.get("count").toString());
			}
		}else if(type == 2){
			tongjiList = TousuService.getInstance().queryTousuBySerial(beginDate,endDate,prov,city,brandId,chexiId,iway);
			for (Map<String, Object> map : tongjiList) {
				List<Map<String, Object>> list = (List<Map<String, Object>>)map.get("info");
				for (Map<String, Object> map2 : list) {
					totalCount += Integer.valueOf(map2.get("count").toString());
				}
			}
		}else if(type == 3){
			Map<String, Object> objMap = TousuService.getInstance().queryTousuSerialByDuixiang(beginDate, endDate, prov, city, brandId, chexiId, iway);
			totalCount = Integer.valueOf(objMap.get("totalCount").toString());
			tongjiList = (List<Map<String, Object>>)objMap.get("info");
			
		}
		return SUCCESS;
	}
	
	// 更具品牌获取渠道
	public void queryCarInfoByBrand() throws IOException {
		String brandid = request.getParameter("brandid");
		List<Map<String, String>> iways = TousuService.getInstance()
				.queryIwayByBrandId(Integer.valueOf(brandid));
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(iways);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
	}
	
	
	// 更具品牌获取渠道
	public void queryCarInfoByIway() throws IOException {
		String iway = URLDecoder.decode(request.getParameter("iway"), "utf-8");
		List<DboCarCatalognew> serials = TousuService.getInstance()
				.queryCarInfoByIway(iway);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(serials);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
	}
	
	public void imgDelete() throws Exception {
		ImageFormatMethod imageFormat = new ImageFormatMethod();
		Map<String,Object> map = new HashMap<String,Object>();
		String id = request.getParameter("imgid");
		//String imgname = request.getParameter("imgname");
		String imgpath = request.getParameter("imgpath");
		
		String new_imgname = "";
		String new_imgpath = "";
		
		List<String> images = new ArrayList<String>();
		
		String[] imgArray = imgpath.split(",");
		if(imgArray.length >1){
		
			for(int i=0;i<imgArray.length;i++){
				String img = imgArray[i];
				if (!"".equals(img.trim())) {
					List<Object> photoList = new ArrayList<Object>();
					photoList.add(img.trim());
					photoList.add("0");
					photoList.add("0");
					if(Integer.parseInt(id) != i){
						images.add(imageFormat.exec(photoList).toString());
						new_imgname += (img.substring(img.lastIndexOf('/')+1,img.length()) +",");
						new_imgpath += (img+",");
					}
				}
				
			}
			new_imgname = new_imgname.substring(0,new_imgname.length()-1);
			new_imgpath = new_imgpath.substring(0,new_imgpath.length()-1);
		}
		
		map.put("image", new_imgpath);
		map.put("imagename", new_imgname);
		map.put("images", images);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
		
	}
	
	public void imgAdd() throws Exception {
		ImageFormatMethod imageFormat = new ImageFormatMethod();
		Map<String,Object> map = new HashMap<String,Object>();
		//String imgname = request.getParameter("imgname");
		//String path = request.getParameter("path");
		//String imgname = URLDecoder.decode(request.getParameter("imgname"), "utf-8");
		String path = URLDecoder.decode(request.getParameter("path"), "utf-8");
		String imgpath = request.getParameter("imgpath");
		
		if(null==imgpath||"".equals(imgpath)){
			imgpath = path;
		}else{
			if(imgpath.length()>0){
				if(",".equals(imgpath.substring(imgpath.length()-1))){
					imgpath = imgpath + path;
				}else{
					imgpath = imgpath +","+ path;
				}
			}
		}
		
		String new_imgname = "";
		String new_imgpath = "";
		
		List<String> images = new ArrayList<String>();
		
		String[] imgArray = imgpath.split(",");
		if(imgArray.length > 0){
		
			for(int i=0;i<imgArray.length;i++){
				String img = imgArray[i];
				if (!"".equals(img.trim())) {
					List<Object> photoList = new ArrayList<Object>();
					photoList.add(img.trim());
					photoList.add("0");
					photoList.add("0");
					
					images.add(imageFormat.exec(photoList).toString());
					new_imgname += (img.substring(img.lastIndexOf('/')+1,img.length()) +",");
					new_imgpath += (img+",");
					
				}
				
			}
			new_imgname = new_imgname.substring(0,new_imgname.length()-1);
			new_imgpath = new_imgpath.substring(0,new_imgpath.length()-1);
		}
		
		map.put("image", new_imgpath);
		map.put("imagename", new_imgname);
		map.put("images", images);
		
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(map);
		String jsonp = request.getParameter("jsonpcallback");
		out.print(jsonp + "(" + json.toString() + ")");
		
		
	}
	
	
	String getHanzi(String str){
		try {
			return URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public int getProv() {
		return prov;
	}

	public void setProv(int prov) {
		this.prov = prov;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getChexiId() {
		return chexiId;
	}

	public void setChexiId(int chexiId) {
		this.chexiId = chexiId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getState2() {
		return state2;
	}

	public void setState2(int state2) {
		this.state2 = state2;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<Map<String, String>> getTousuList() {
		return tousuList;
	}

	public void setTousuList(List<Map<String, String>> tousuList) {
		this.tousuList = tousuList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTousuid() {
		return tousuid;
	}

	public void setTousuid(int tousuid) {
		this.tousuid = tousuid;
	}

	public String getIway() {
		return iway;
	}

	public void setIway(String iway) {
		this.iway = iway;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Map<String, Object>> getTongjiList() {
		return tongjiList;
	}

	public void setTongjiList(List<Map<String, Object>> tongjiList) {
		this.tongjiList = tongjiList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
