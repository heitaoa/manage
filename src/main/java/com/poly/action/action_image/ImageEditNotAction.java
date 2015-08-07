package com.poly.action.action_image;

import java.util.HashMap;
import java.util.List;

import car_beans.DboImgNewtitle;

import com.poly.action.MyActionSupport;
import com.poly.bean.ImageEntity;
import com.poly.service.ImageEditNotService;
import com.poly.service.ImageNotService;

public class ImageEditNotAction extends MyActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8759398487922835620L;

	private ImageEntity imageEntity ;
	
	private int editTitleId;
	
	private int imageId;
	
	private int editOverType = 0;
	
	private HashMap<String, Object> imgTitleMap;
	
	private HashMap<String, Object> imgPageMap;
	
	private List<HashMap<String, Object>> imgPageList;
	
	private int page = 1;
	
	private int clicktype = 0;
	
	private String cartype;
	
	private int batchSave = 0;
	
	
	public String carImageEdit(){
		imgTitleMap = ImageNotService.getInstance().getTitleById(editTitleId+"");
		imgPageList = ImageNotService.getInstance().getImagePage(editTitleId+"");
		imgPageMap = new HashMap<String, Object>();
		if(imageId != 0){
			imgPageMap = ImageEditNotService.getInstance().getImageInfo(imageId);
		}
		if(session.get("changeCarpage")!=null){
			page = Integer.parseInt(session.get("changeCarpage").toString());
		}
		return SUCCESS;
	}
	
	
	public String saveImage() throws Exception{
		if(batchSave == 1){//����ʱ����1
			String[] path = imageEntity.getImagePath().split(",");
			for(int i= 0 ;i < path.length;i++){
				imageEntity.setImagePath(path[i]);
				imageId = ImageEditNotService.getInstance().addImage(imageEntity);
			}
			editOverType = 1;
			imageId = 0;
		}else{
			if(imageEntity.getImageId()==0){
				imageId = ImageEditNotService.getInstance().addImage(imageEntity);
				editOverType = 1;//��ӵ���1
			}else{
				ImageEditNotService.getInstance().updateImage(imageEntity);
				imageId = imageEntity.getImageId();
				editOverType = 2;//���µ���2
			}
			if(clicktype == 2){
				imageId = 0;
			}
		}
		editTitleId = imageEntity.getTitleid();
		return SUCCESS;
	}
	
	private String cartypeName;
	
	private DboImgNewtitle titleBean;
	
	public String carTitleEdit(){
		cartypeName = ImageEditNotService.getInstance().getImgName(Integer.parseInt(cartype));
		if(titleBean == null){
			titleBean = new DboImgNewtitle();
		}
		page = Integer.parseInt(session.get("page").toString());
		return SUCCESS;
	}
	
	public String saveTitle() throws Exception{
		titleBean.setAddadmin(session.get("userid").toString());
		ImageEditNotService.getInstance().addTitle(titleBean);
		cartypeName = ImageEditNotService.getInstance().getImgName(titleBean.getCatalogid());
		cartype = titleBean.getCatalogid()+"";
		editOverType = 1;//��ӵ���1
		return SUCCESS;
	}
	
	public String updateTitle(){
		DboImgNewtitle oldtitleBean = ImageEditNotService.getInstance().carTitleChange(titleBean.getId());
		//oldtitleBean.setType(titleBean.getType());
		oldtitleBean.setTitle(titleBean.getTitle());
		oldtitleBean.setKeywords(titleBean.getKeywords());
		titleBean = oldtitleBean;
		ImageEditNotService.getInstance().updateTitle(titleBean);
		cartypeName = ImageEditNotService.getInstance().getImgName(titleBean.getCatalogid());
		cartype = titleBean.getCatalogid()+"";
		editOverType = 2;//���µ���2
		return SUCCESS;
	}
	
	public String carTitleChange(){
		titleBean = ImageEditNotService.getInstance().carTitleChange(editTitleId);
		cartypeName = ImageEditNotService.getInstance().getImgName(titleBean.getCatalogid());
		cartype = titleBean.getCatalogid()+"";
		return SUCCESS;
	}
	

	public ImageEntity getImageEntity() {
		return imageEntity;
	}

	public void setImageEntity(ImageEntity imageEntity) {
		this.imageEntity = imageEntity;
	}

	public int getEditTitleId() {
		return editTitleId;
	}

	public void setEditTitleId(int editTitleId) {
		this.editTitleId = editTitleId;
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


	public HashMap<String, Object> getImgTitleMap() {
		return imgTitleMap;
	}


	public void setImgTitleMap(HashMap<String, Object> imgTitleMap) {
		this.imgTitleMap = imgTitleMap;
	}


	public List<HashMap<String, Object>> getImgPageList() {
		return imgPageList;
	}


	public void setImgPageList(List<HashMap<String, Object>> imgPageList) {
		this.imgPageList = imgPageList;
	}


	public int getEditOverType() {
		return editOverType;
	}


	public void setEditOverType(int editOverType) {
		this.editOverType = editOverType;
	}
	
	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getClicktype() {
		return clicktype;
	}


	public void setClicktype(int clicktype) {
		this.clicktype = clicktype;
	}


	public String getCartype() {
		return cartype;
	}


	public void setCartype(String cartype) {
		this.cartype = cartype;
	}


	public String getCartypeName() {
		return cartypeName;
	}


	public void setCartypeName(String cartypeName) {
		this.cartypeName = cartypeName;
	}

	public DboImgNewtitle getTitleBean() {
		return titleBean;
	}

	public void setTitleBean(DboImgNewtitle titleBean) {
		this.titleBean = titleBean;
	}

	public int getBatchSave() {
		return batchSave;
	}


	public void setBatchSave(int batchSave) {
		this.batchSave = batchSave;
	}
	

}
