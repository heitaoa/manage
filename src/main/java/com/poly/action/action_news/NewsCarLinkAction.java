package com.poly.action.action_news;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import car_beans.DboAreCatalog;
import car_beans.DboCarCatalognew;
import car_beans.DboEntProduct;
import car_beans.DboSubContent;
import car_daos.DboAreCatalogDao;
import car_daos.DboCarCatalognewDao;
import car_daos.DboEntProductDao;

import com.poly.action.MyActionSupport;
import com.poly.dao.SeqDao;
import com.poly.service.SubContentService;
import com.poly.util.HtmlGenerator;
import com.redis.RedisDao;

//���۹���
public class NewsCarLinkAction extends MyActionSupport {

	// ͼƬ����
	// List<Map<String, String>> cartype =
	// RedisDao.getImgTitleContentByCatalogid(catalogid);

	private int catalogid;

	private DboCarCatalognew brand;

	private DboCarCatalognew serie;

	private String priceRang;// �۸�����

	private int picNum;

	@Override
	public String execute() {

		DboCarCatalognew catalog = getCatalogById(catalogid);

		if (catalog == null) {
			setAjax("û���ҵ���Ӧ��ϵ");
			return AJAX;
		}

		if (catalog.getPathlevel() != 2) {
			setAjax("��ѡ��ϵ");
			return AJAX;
		}

		serie = catalog;

		brand = getCatalogById(serie.getFatherid());

		List<DboEntProduct> productList = getProduct(serie.getCatalogid());
		if (productList != null && productList.size() > 1) {
			long low = productList.get(0).getPrice();
			long top = productList.get(productList.size() - 1).getPrice();

			DecimalFormat df = new DecimalFormat("#.00");
			this.priceRang = df.format(low / 10000) + " ~ " + df.format(top / 10000) + "Ԫ";
		}

		List<Map<String, String>> cartype = RedisDao.getImgTitleContentByCatalogid(serie.getCatalogid());
		picNum = cartype.size();

		return "ajax_car_link";
	}

	private List<DboEntProduct> getProduct(int serei_id) {
		// select * from dbo_ent_product where typeid in (select catalogid from
		// dbo_car_catalognew where fatherid > 0 and pathlevel = 2) ORDER BY
		// price ASC limit 0, 100;
		String subsql = "typeid in (select catalogid from dbo_car_catalognew where fatherid = " + serei_id + " and pathlevel = 2)  ORDER BY price ASC limit 0, 100";
		return DboEntProductDao.where(subsql);
	}

	private DboCarCatalognew getCatalogById(int catalogid) {

		String subsql = " catalogid = " + catalogid;
		List<DboCarCatalognew> catalogList = DboCarCatalognewDao.where(subsql);
		if (catalogList != null && catalogList.size() > 0) {
			DboCarCatalognew catalog = catalogList.get(0);
			return catalog;
		}
		return null;
	}

	public int getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}

	public DboCarCatalognew getBrand() {
		return brand;
	}

	public void setBrand(DboCarCatalognew brand) {
		this.brand = brand;
	}

	public DboCarCatalognew getSerie() {
		return serie;
	}

	public void setSerie(DboCarCatalognew serie) {
		this.serie = serie;
	}

	public String getPriceRang() {
		return priceRang;
	}

	public void setPriceRang(String priceRang) {
		this.priceRang = priceRang;
	}

	public int getPicNum() {
		return picNum;
	}

	public void setPicNum(int picNum) {
		this.picNum = picNum;
	}

}
