package com.poly.action.action_image;

import java.util.HashMap;
import java.util.List;

import car_beans.DboImgTitle;
import car_beans.TbImgTypinfo;

import com.poly.action.MyActionSupport;
import com.poly.bean.ImageCompareBean;
import com.poly.bean.ImageEntity;
import com.poly.service.ImageEditService;
import com.poly.service.ImageService;
import com.poly.util.ImageFormatMethod;
import com.redis.RedisParseUtil;

public class ImageEditAction extends MyActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5443789650218504235L;

	ImageEditService imageEditService;
	
	ImageService imageService;
	
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
	
	private List<TbImgTypinfo> imgTypelist;
	
	
	private List<String> comparelist;
	
	private ImageFormatMethod imageFormat = new ImageFormatMethod();
	
	public String carImageEdit(){
		imgTitleMap = ImageService.getInstance().getTitleById(editTitleId+"");
		imgPageList = ImageService.getInstance().getImagePage(editTitleId+"");
		imgPageMap = new HashMap<String, Object>();
		if(imageId != 0){
			imgPageMap = ImageEditService.getInstance().getImageInfo(imageId);
		}
		if(session.get("changeCarpage")!=null){
			page = Integer.parseInt(session.get("changeCarpage").toString());
		}
		int type = Integer.parseInt(imgTitleMap.get("type").toString());
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
		imgTypelist = ImageEditService.getInstance().getAllimgType(imgTitleMap.get("type").toString());
		return SUCCESS;
	}
	
	
	public String saveImage() throws Exception{
		if(batchSave == 1){//����ʱ����1
			String[] path = imageEntity.getImagePath().split(",");
			String[] typeInfo = imageEntity.getImageTypeInfo().split(",");
			for(int i= 0 ;i < path.length;i++){
				imageEntity.setImagePath(path[i]);
				imageEntity.setTitle(typeInfo[i]);
				imageId = ImageEditService.getInstance().addImage(imageEntity);
				RedisParseUtil.jedisPublish("insert", "dbo_img_content", imageId+"");
			}
			editOverType = 1;
			imageId = 0;
		}else{
			if(imageEntity.getImageId()==0){
				imageEntity.setTitle(imageEntity.getImageTypeInfo());
				imageId = ImageEditService.getInstance().addImage(imageEntity);
				RedisParseUtil.jedisPublish("insert", "dbo_img_content", imageId+"");
				editOverType = 1;//��ӵ���1
			}else{
				imageEntity.setTitle(imageEntity.getImageTypeInfo());
				ImageEditService.getInstance().updateImage(imageEntity);
				imageId = imageEntity.getImageId();
				RedisParseUtil.jedisPublish("update", "dbo_img_content", imageId+"");
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
	
	private DboImgTitle titleBean;
	
	public String carTitleEdit(){
		cartypeName = ImageEditService.getInstance().getCarName(Integer.parseInt(cartype));
		if(titleBean == null){
			titleBean = new DboImgTitle();
		}
		page = Integer.parseInt(session.get("page").toString());
		return SUCCESS;
	}
	
	public String saveTitle() throws Exception{
		titleBean.setAddadmin(session.get("userid").toString());
		int id = ImageEditService.getInstance().addTitle(titleBean);
		RedisParseUtil.jedisPublish("insert", "dbo_img_title", id+"");
		cartypeName = ImageEditService.getInstance().getCarName(titleBean.getCatalogid());
		cartype = titleBean.getCatalogid()+"";
		editOverType = 1;//��ӵ���1
		return SUCCESS;
	}
	
	public String updateTitle(){
		DboImgTitle oldtitleBean = ImageEditService.getInstance().carTitleChange(titleBean.getId());
		oldtitleBean.setType(titleBean.getType());
		oldtitleBean.setTitle(titleBean.getTitle());
		oldtitleBean.setKeywords(titleBean.getKeywords());
		oldtitleBean.setColor(titleBean.getColor());
		titleBean = oldtitleBean;
		ImageEditService.getInstance().updateTitle(titleBean);
		RedisParseUtil.jedisPublish("update", "dbo_img_title", titleBean.getId()+"");
		cartypeName = ImageEditService.getInstance().getCarName(titleBean.getCatalogid());
		cartype = titleBean.getCatalogid()+"";
		editOverType = 2;//���µ���2
		return SUCCESS;
	}
	
	public String carTitleChange(){
		titleBean = ImageEditService.getInstance().carTitleChange(editTitleId);
		cartypeName = ImageEditService.getInstance().getCarName(titleBean.getCatalogid());
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


	public DboImgTitle getTitleBean() {
		return titleBean;
	}


	public void setTitleBean(DboImgTitle titleBean) {
		this.titleBean = titleBean;
	}


	public int getBatchSave() {
		return batchSave;
	}


	public void setBatchSave(int batchSave) {
		this.batchSave = batchSave;
	}


	public List<TbImgTypinfo> getImgTypelist() {
		return imgTypelist;
	}


	public void setImgTypelist(List<TbImgTypinfo> imgTypelist) {
		this.imgTypelist = imgTypelist;
	}


	public ImageFormatMethod getImageFormat() {
		return imageFormat;
	}


	public void setImageFormat(ImageFormatMethod imageFormat) {
		this.imageFormat = imageFormat;
	}


	public List<String> getComparelist() {
		return comparelist;
	}


	public void setComparelist(List<String> comparelist) {
		this.comparelist = comparelist;
	}

}
