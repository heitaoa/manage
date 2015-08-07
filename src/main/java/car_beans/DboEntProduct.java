package car_beans;
import java.util.*;

public class  DboEntProduct  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//
	private int e_id;//企业id
	private int isdelete;//
	private int typeid;//产品型号id
	private int type;//0，null-整件，1—配件
	private int isrecommended;//
	private int pricessort;//
	private int sortid;//
	private long price;//产品报价
	private long offersprice;//优惠价
	private String name;//产品名
	private String photo;//产品图片
	private Date adddate;//发布日期
	private Date updatedate;//更新日期
	private String perunit;//数量+单位
	private String remarks;//备注
	private String introduce;//产品介绍
	private String directions;//产品说明书
	private String standards;//配置规格
	private String discountinfo;//
	private Date hotdate;//
	private int isdiscountdef;//
	private long bitautoprice;//

	private DboCarCatalognew carType;//
	public void setCarType(DboCarCatalognew carType)
	{
		this.carType=carType;
	}
	public DboCarCatalognew getCarType()
	{
		return carType;
	}
	private int rowspan;//
	public void setRowspan(int rowspan)
	{
		this.rowspan=rowspan;
	}
	public int getRowspan()
	{
		return rowspan;
	}

	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setE_id(int e_id)
	{
		this.e_id=e_id;
		COLUMN_FLAG[1] = true;
	}
	public int getE_id()
	{
		return e_id;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[2] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setTypeid(int typeid)
	{
		this.typeid=typeid;
		COLUMN_FLAG[3] = true;
	}
	public int getTypeid()
	{
		return typeid;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[4] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setIsrecommended(int isrecommended)
	{
		this.isrecommended=isrecommended;
		COLUMN_FLAG[5] = true;
	}
	public int getIsrecommended()
	{
		return isrecommended;
	}
	public void setPricessort(int pricessort)
	{
		this.pricessort=pricessort;
		COLUMN_FLAG[6] = true;
	}
	public int getPricessort()
	{
		return pricessort;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[7] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setPrice(long price)
	{
		this.price=price;
		COLUMN_FLAG[8] = true;
	}
	public long getPrice()
	{
		return price;
	}
	public void setOffersprice(long offersprice)
	{
		this.offersprice=offersprice;
		COLUMN_FLAG[9] = true;
	}
	public long getOffersprice()
	{
		return offersprice;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[10] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setPhoto(String photo)
	{
		this.photo=photo;
		COLUMN_FLAG[11] = true;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[12] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setUpdatedate(Date updatedate)
	{
		this.updatedate=updatedate;
		COLUMN_FLAG[13] = true;
	}
	public Date getUpdatedate()
	{
		return updatedate;
	}
	public void setPerunit(String perunit)
	{
		this.perunit=perunit;
		COLUMN_FLAG[14] = true;
	}
	public String getPerunit()
	{
		return perunit;
	}
	public void setRemarks(String remarks)
	{
		this.remarks=remarks;
		COLUMN_FLAG[15] = true;
	}
	public String getRemarks()
	{
		return remarks;
	}
	public void setIntroduce(String introduce)
	{
		this.introduce=introduce;
		COLUMN_FLAG[16] = true;
	}
	public String getIntroduce()
	{
		return introduce;
	}
	public void setDirections(String directions)
	{
		this.directions=directions;
		COLUMN_FLAG[17] = true;
	}
	public String getDirections()
	{
		return directions;
	}
	public void setStandards(String standards)
	{
		this.standards=standards;
		COLUMN_FLAG[18] = true;
	}
	public String getStandards()
	{
		return standards;
	}
	public void setDiscountinfo(String discountinfo)
	{
		this.discountinfo=discountinfo;
		COLUMN_FLAG[19] = true;
	}
	public String getDiscountinfo()
	{
		return discountinfo;
	}
	public void setHotdate(Date hotdate)
	{
		this.hotdate=hotdate;
		COLUMN_FLAG[20] = true;
	}
	public Date getHotdate()
	{
		return hotdate;
	}
	public void setIsdiscountdef(int isdiscountdef)
	{
		this.isdiscountdef=isdiscountdef;
		COLUMN_FLAG[21] = true;
	}
	public int getIsdiscountdef()
	{
		return isdiscountdef;
	}
	public void setBitautoprice(long bitautoprice)
	{
		this.bitautoprice=bitautoprice;
		COLUMN_FLAG[22] = true;
	}
	public long getBitautoprice()
	{
		return bitautoprice;
	}
}
