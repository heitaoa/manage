package car_beans;
import java.util.*;

public class  DboPubMould  implements java.io.Serializable{

	public String KEY = "mouldid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int mouldid;//模型id
	private String mouldname;//模板名称
	private String mouldphoto;//模板图片
	private String mouldhtml;//模板代码
	private String mouldftl;//模板ftl


	public void setMouldid(int mouldid)
	{
		this.mouldid=mouldid;
		COLUMN_FLAG[0] = true;
	}
	public int getMouldid()
	{
		return mouldid;
	}
	public void setMouldname(String mouldname)
	{
		this.mouldname=mouldname;
		COLUMN_FLAG[1] = true;
	}
	public String getMouldname()
	{
		return mouldname;
	}
	public void setMouldphoto(String mouldphoto)
	{
		this.mouldphoto=mouldphoto;
		COLUMN_FLAG[2] = true;
	}
	public String getMouldphoto()
	{
		return mouldphoto;
	}
	public void setMouldhtml(String mouldhtml)
	{
		this.mouldhtml=mouldhtml;
		COLUMN_FLAG[3] = true;
	}
	public String getMouldhtml()
	{
		return mouldhtml;
	}
	public void setMouldftl(String mouldftl)
	{
		this.mouldftl=mouldftl;
		COLUMN_FLAG[4] = true;
	}
	public String getMouldftl()
	{
		return mouldftl;
	}
}
