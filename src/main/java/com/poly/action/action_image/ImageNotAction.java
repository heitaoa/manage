package com.poly.action.action_image;

import java.util.HashMap;
import java.util.List;

import com.poly.action.MyActionSupport;
import com.poly.bean.ChangeSortEntity;
import com.poly.service.ImageEditService;
import com.poly.service.ImageNotService;

//���۹���
public class ImageNotAction extends MyActionSupport {

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
	
	
	public String carImageManage(){
		int start = rows * (page - 1);
		addadminList = ImageNotService.getInstance().getAddadmin();
		imgTitleList = ImageNotService.getInstance().getTitleInfo(carTypeArr,start,rows);
		imgPageList = ImageNotService.getInstance().getImagePage(imgTitleList);
		if(imgTitleList.size()>0){
			count = (Integer) imgTitleList.get(0).get("count");
		}
		totalPage = count / rows;
		if (count % rows != 0) {
			totalPage++;
		}
		session.put("carTypeArr", carTypeArr);
		session.put("page", page);
		return SUCCESS;
	}
	
	private String titleId;
	
	private int beforepage;
	
	public String changeCarImage(){
		int start = rows * (page - 1);
		imgPageList = ImageNotService.getInstance().getImageChangePage(titleId,start,rows);
		
		if(imgPageList.size()>0){
			count = (Integer) imgPageList.get(0).get("count");
		}
		totalPage = count / rows;
		if (count % rows != 0) {
			totalPage++;
		}
		carTypeArr = session.get("carTypeArr").toString();
		beforepage = Integer.parseInt(session.get("page").toString());
		List<HashMap<String, Object>> imgAllPageList = ImageNotService.getInstance().getAllImageChangePage(titleId);
		imgPageList = ImageNotService.getInstance().addSort(imgPageList, imgAllPageList);
		session.put("titleId", titleId);
		session.put("changeCarpage", page);
		return SUCCESS;
	}
	
	
	private int deleteid;
	
	private List<Integer> deleteArr;

	public String deleteImageContent(){
		ImageNotService.getInstance().deleteImageContent(deleteid);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	public String deleteImageContentBatch(){
		ImageNotService.getInstance().deleteImageContentBatch(deleteArr);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	private String comefrom;
	
	public String setComefrom(){
		ImageNotService.getInstance().setComefrom(comefrom, deleteid);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	public String setComefromBatch(){
		ImageNotService.getInstance().setComefromBatch(comefrom, deleteArr);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	public String deleteImageTitle(){
		return SUCCESS;
	}
	
	private ChangeSortEntity changeSortEntity;
	
	public String changeSort(){
		ImageNotService.getInstance().changeSort(changeSortEntity);
		titleId = session.get("titleId").toString();
		page = Integer.parseInt(session.get("changeCarpage").toString());
		return SUCCESS;
	}
	
	private String editTitleId;
	
	private HashMap<String, Object> imgTitleMap;
	
	private int imageId = 0;
	
	private HashMap<String, Object> imgPageMap;
	
	public String carImageEdit(){
		imgTitleMap = ImageNotService.getInstance().getTitleById(editTitleId);
		imgPageList = ImageNotService.getInstance().getImagePage(editTitleId);
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
		ImageNotService.getInstance().deleteTitle(imgTitle);
		return SUCCESS;
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




}
