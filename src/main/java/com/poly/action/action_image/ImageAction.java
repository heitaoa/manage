package com.poly.action.action_image;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import car_beans.TbImgTypinfo;

import com.poly.action.MyActionSupport;
import com.poly.bean.ChangeSortEntity;
import com.poly.bean.ImageCompareBean;
import com.poly.service.ImageEditService;
import com.poly.service.ImageService;
import com.poly.sftp.MyRemoteUtil;
import com.poly.util.DeleteCarParamFileUtil;
import com.poly.util.ImageFormatMethod;
import com.redis.RedisParseUtil;

//���۹���
public class ImageAction extends MyActionSupport {

	private static final long serialVersionUID = -6076528379332629253L;
	
	private int page = 1;
	private int totalPage;
	private int rows = 10;
	private int count;
	
	private String carTypeArr;
	
	private List<HashMap<String, Object>> imgTitleList;
	
	
	private List<HashMap<String, Object>> imgPageList;
	
	private List<HashMap<String, Object>> addadminList;
	
	private String clickIsParent;
	
	public String execute() {

		return SUCCESS;
	}
	
	private String seltree;
	
	private String delHtm = null;
	
	
	public String getDelHtm() {
		return delHtm;
	}


	public void setDelHtm(String delHtm) {
		this.delHtm = delHtm;
	}

	private static int server;
	public void refreshPage() throws Exception{
		if(delHtm!=null){
			//DeleteCarParamFileUtil.RemoveFileByCarParam("tuku"+delHtm);
			
			server = MyRemoteUtil.www315;
			String commStr = "rm -rf " + delHtm + " \n";
			MyRemoteUtil.exeCommand(commStr, server);
			System.out.println("tuku"+commStr+"-----------------------------------------------------------------------------DEL");
			
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("true");
			out.close();
		}
	}
	
	
	public String carImageManage(){
		int start = rows * (page - 1);
		addadminList = ImageService.getInstance().getAddadmin();
		imgTitleList = ImageService.getInstance().getTitleInfo(carTypeArr,start,rows);
		imgPageList = ImageService.getInstance().getImagePage(imgTitleList);
		if(imgTitleList.size()>0){
			count = (Integer) imgTitleList.get(0).get("count");
		}
		totalPage = count / rows;
		if (count % rows != 0) {
			totalPage++;
		}
		session.put("carTypeArr", carTypeArr);
		session.put("page", page);
		if(seltree != null){
			session.put("seltree", seltree);
		}
		return SUCCESS;
	}
	
	private String titleId;
	
	private int beforepage;
	
	private ImageFormatMethod imageFormat = new ImageFormatMethod();
	
	private List<TbImgTypinfo> imgTypelist;
	
	
	private List<String> comparelist;
	
	private int type;
	
	public String changeCarImage(){
		int start = rows * (page - 1);
		imgPageList = ImageService.getInstance().getImageChangePage(titleId,start,rows);
		
		if(imgPageList.size()>0){
			count = (Integer) imgPageList.get(0).get("count");
		}
		totalPage = count / rows;
		if (count % rows != 0) {
			totalPage++;
		}
		carTypeArr = session.get("carTypeArr").toString();
		beforepage = Integer.parseInt(session.get("page").toString());
		List<HashMap<String, Object>> imgAllPageList = ImageService.getInstance().getAllImageChangePage(titleId);
		imgPageList = ImageService.getInstance().addSort(imgPageList, imgAllPageList);
		session.put("titleId", titleId);
		session.put("changeCarpage", page);
		ImageCompareBean imageCompareBean = new ImageCompareBean();
		if(type == 1){
			comparelist = imageCompareBean.getWaiguan();
		}else if(type == 2){
			comparelist = imageCompareBean.getZuoyi();
		}else if(type == 3){
			comparelist = imageCompareBean.getZhongkong();
		}else if(type == 4){
			comparelist = imageCompareBean.getQita();
		}
		imgTypelist = ImageEditService.getInstance().getAllimgType(type+"");
		return SUCCESS;
	}
	
	public String updateContentTitle() throws UnsupportedEncodingException{
		String title = URLDecoder.decode(request.getParameter("title"), "utf-8");
		String id = URLDecoder.decode(request.getParameter("id"), "utf-8");
		ImageEditService.getInstance().updateContentTitle(title, Integer.parseInt(id));
		RedisParseUtil.jedisPublish("update", "dbo_img_content", id);
		setAjax("1");
		return AJAX;
	}
	
	private int deleteid;
	
	private List<Integer> deleteArr;

	public String deleteImageContent(){
		ImageService.getInstance().deleteImageContent(deleteid);
		RedisParseUtil.jedisPublish("delete", "dbo_img_content", deleteid+"");
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	public String deleteImageContentBatch(){
		ImageService.getInstance().deleteImageContentBatch(deleteArr);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	private String comefrom;
	
	public String setComefrom(){
		ImageService.getInstance().setComefrom(comefrom, deleteid);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	public String setComefromBatch(){
		ImageService.getInstance().setComefromBatch(comefrom, deleteArr);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	public String deleteImageTitle(){
		return SUCCESS;
	}
	
	private ChangeSortEntity changeSortEntity;
	
	public String changeSort(){
		ImageService.getInstance().changeSort(changeSortEntity);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	private String editTitleId;
	
	private HashMap<String, Object> imgTitleMap;
	
	private int imageId = 0;
	
	private HashMap<String, Object> imgPageMap;
	
	public String carImageEdit(){
		imgTitleMap = ImageService.getInstance().getTitleById(editTitleId);
		imgPageList = ImageService.getInstance().getImagePage(editTitleId);
		imgPageMap = new HashMap<String, Object>();
		if(imageId != 0){
			imgPageMap = ImageEditService.getInstance().getImageInfo(imageId);
		}
		if(session.get("changeCarpage")!=null){
			page = Integer.parseInt(session.get("changeCarpage").toString());
		}
		return SUCCESS;
	}
	
	private List<String> imgTitle;
	
	private String cartype;
	
	public String deleteTitle(){
		carTypeArr = cartype;
		ImageService.getInstance().deleteTitle(imgTitle);
		return SUCCESS;
	}
	
	
	public void sortBatchInit() throws IOException{
		String titleid = URLDecoder.decode(request.getParameter("titleid"), "utf-8");
		List<HashMap<String, Object>> list = ImageService.getInstance().getSortImage(titleid);
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
	}
	
	
	public void sortBatch() throws IOException{
		String sortArrayStr = URLDecoder.decode(request.getParameter("sortArray"), "utf-8");
		String[] sortArray = sortArrayStr.replace("[", "").replace("]", "").split(",");
		for(int i = 0;i<sortArray.length;i++){
			String id = sortArray[i].replace("\"", "");
			ImageService.getInstance().updateSort(id, sortArray.length-i);
			RedisParseUtil.jedisPublish("update", "dbo_img_content", id);
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(true);
	}
	
	
	public void imagechouqu() throws IOException{
		String carid = URLDecoder.decode(request.getParameter("carid"), "utf-8");
		int result = ImageService.getInstance().imagechouqu(carid);
		boolean flag = false;
		if(result == 1000){
			flag = true;
		}
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.print(flag);
	}
	
	public String getCarTypeArr() {
		return carTypeArr;
	}


	public void setCarTypeArr(String carTypeArr) {
		this.carTypeArr = carTypeArr;
	}


	public List<HashMap<String, Object>> getImgTitleList() {
		return imgTitleList;
	}


	public void setImgTitleList(List<HashMap<String, Object>> imgTitleList) {
		this.imgTitleList = imgTitleList;
	}


	public List<HashMap<String, Object>> getImgPageList() {
		return imgPageList;
	}


	public void setImgPageList(List<HashMap<String, Object>> imgPageList) {
		this.imgPageList = imgPageList;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public List<HashMap<String, Object>> getAddadminList() {
		return addadminList;
	}


	public void setAddadminList(List<HashMap<String, Object>> addadminList) {
		this.addadminList = addadminList;
	}


	public String getTitleId() {
		return titleId;
	}


	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}


	public int getBeforepage() {
		return beforepage;
	}


	public void setBeforepage(int beforepage) {
		this.beforepage = beforepage;
	}


	public int getDeleteid() {
		return deleteid;
	}


	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}


	public ChangeSortEntity getChangeSortEntity() {
		return changeSortEntity;
	}


	public void setChangeSortEntity(ChangeSortEntity changeSortEntity) {
		this.changeSortEntity = changeSortEntity;
	}


	public List<Integer> getDeleteArr() {
		return deleteArr;
	}


	public void setDeleteArr(List<Integer> deleteArr) {
		this.deleteArr = deleteArr;
	}


	public String getComefrom() {
		return comefrom;
	}


	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}


	public String getEditTitleId() {
		return editTitleId;
	}


	public void setEditTitleId(String editTitleId) {
		this.editTitleId = editTitleId;
	}


	public HashMap<String, Object> getImgTitleMap() {
		return imgTitleMap;
	}


	public void setImgTitleMap(HashMap<String, Object> imgTitleMap) {
		this.imgTitleMap = imgTitleMap;
	}


	public int getImageId() {
		return imageId;
	}


	public void setImageId(int imageId) {
		this.imageId = imageId;
	}


	public HashMap<String, Object> getImgPageMap() {
		return imgPageMap;
	}


	public void setImgPageMap(HashMap<String, Object> imgPageMap) {
		this.imgPageMap = imgPageMap;
	}


	public String getClickIsParent() {
		return clickIsParent;
	}


	public void setClickIsParent(String clickIsParent) {
		this.clickIsParent = clickIsParent;
	}


	public List<String> getImgTitle() {
		return imgTitle;
	}


	public void setImgTitle(List<String> imgTitle) {
		this.imgTitle = imgTitle;
	}


	public String getCartype() {
		return cartype;
	}


	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	
	public String getSeltree() {
		return seltree;
	}

	public void setSeltree(String seltree) {
		this.seltree = seltree;
	}

	public ImageFormatMethod getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(ImageFormatMethod imageFormat) {
		this.imageFormat = imageFormat;
	}

	public List<TbImgTypinfo> getImgTypelist() {
		return imgTypelist;
	}

	public void setImgTypelist(List<TbImgTypinfo> imgTypelist) {
		this.imgTypelist = imgTypelist;
	}

	public List<String> getComparelist() {
		return comparelist;
	}

	public void setComparelist(List<String> comparelist) {
		this.comparelist = comparelist;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



}
