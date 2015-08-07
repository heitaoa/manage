package car_beans;
import java.util.*;

public class  DboDeaHqprice  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private int hqid;//关联dbo_dea_hqnews的id
	private int carid;//车型
	private Date adddate;//
	private int isdelete;//
	private int eid;//
	private double facprice;//官方价
	private double price;//最终价格
	private double lowprice;//优惠幅度


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setHqid(int hqid)
	{
		this.hqid=hqid;
		COLUMN_FLAG[1] = true;
	}
	public int getHqid()
	{
		return hqid;
	}
	public void setCarid(int carid)
	{
		this.carid=carid;
		COLUMN_FLAG[2] = true;
	}
	public int getCarid()
	{
		return carid;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[3] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[5] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setFacprice(double facprice)
	{
		this.facprice=facprice;
		COLUMN_FLAG[6] = true;
	}
	public double getFacprice()
	{
		return facprice;
	}
	public void setPrice(double price)
	{
		this.price=price;
		COLUMN_FLAG[7] = true;
	}
	public double getPrice()
	{
		return price;
	}
	public void setLowprice(double lowprice)
	{
		this.lowprice=lowprice;
		COLUMN_FLAG[8] = true;
	}
	public double getLowprice()
	{
		return lowprice;
	}
}
