package car_beans;
import java.util.*;

public class  TbDataPromoMethod  implements java.io.Serializable{

	public String KEY = "promo_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false};
	private int promo_id;//推广方案id
	private String pro_num;//项目编号
	private String promo_channel;//推广渠道
	private String promo_url;//url
	private String promo_pageid;//页面标识
	private Date promo_date;//推广日期
	private String promo_remarks;//url


	public void setPromo_id(int promo_id)
	{
		this.promo_id=promo_id;
		COLUMN_FLAG[0] = true;
	}
	public int getPromo_id()
	{
		return promo_id;
	}
	public void setPro_num(String pro_num)
	{
		this.pro_num=pro_num;
		COLUMN_FLAG[1] = true;
	}
	public String getPro_num()
	{
		return pro_num;
	}
	public void setPromo_channel(String promo_channel)
	{
		this.promo_channel=promo_channel;
		COLUMN_FLAG[2] = true;
	}
	public String getPromo_channel()
	{
		return promo_channel;
	}
	public void setPromo_url(String promo_url)
	{
		this.promo_url=promo_url;
		COLUMN_FLAG[3] = true;
	}
	public String getPromo_url()
	{
		return promo_url;
	}
	public void setPromo_pageid(String promo_pageid)
	{
		this.promo_pageid=promo_pageid;
		COLUMN_FLAG[4] = true;
	}
	public String getPromo_pageid()
	{
		return promo_pageid;
	}
	public void setPromo_date(Date promo_date)
	{
		this.promo_date=promo_date;
		COLUMN_FLAG[5] = true;
	}
	public Date getPromo_date()
	{
		return promo_date;
	}
	public void setPromo_remarks(String promo_remarks)
	{
		this.promo_remarks=promo_remarks;
		COLUMN_FLAG[6] = true;
	}
	public String getPromo_remarks()
	{
		return promo_remarks;
	}
}
