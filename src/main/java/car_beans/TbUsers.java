package car_beans;
import java.util.*;

public class  TbUsers  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private String userid;//用户名
	private int isdelete;//用户状态 0-使用 1-删除
	private int prov;//分管地域 -省
	private int city;//分管地域-市
	private String brands;//分管品牌
	private Date addtime;//添加时间
	private String ulevel;//用户权限  0-系统管理员 1-大客户回访人员  2-客服 3-销售  4-总站编辑 5-分站编辑  6-分站管理员
	private String detail;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
		COLUMN_FLAG[1] = true;
	}
	public String getUserid()
	{
		return userid;
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
	public void setProv(int prov)
	{
		this.prov=prov;
		COLUMN_FLAG[3] = true;
	}
	public int getProv()
	{
		return prov;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[4] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setBrands(String brands)
	{
		this.brands=brands;
		COLUMN_FLAG[5] = true;
	}
	public String getBrands()
	{
		return brands;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[6] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setUlevel(String ulevel)
	{
		this.ulevel=ulevel;
		COLUMN_FLAG[7] = true;
	}
	public String getUlevel()
	{
		return ulevel;
	}
	public void setDetail(String detail)
	{
		this.detail=detail;
		COLUMN_FLAG[8] = true;
	}
	public String getDetail()
	{
		return detail;
	}
}
