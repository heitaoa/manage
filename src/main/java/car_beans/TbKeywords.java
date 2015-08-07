package car_beans;
import java.util.*;

public class  TbKeywords  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false};
	private int id;//
	private String keyword;//¹Ø¼ü×Ö
	private String url;//Ìø×ªµØÖ·
	private String desc;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setKeyword(String keyword)
	{
		this.keyword=keyword;
		COLUMN_FLAG[1] = true;
	}
	public String getKeyword()
	{
		return keyword;
	}
	public void setUrl(String url)
	{
		this.url=url;
		COLUMN_FLAG[2] = true;
	}
	public String getUrl()
	{
		return url;
	}
	public void setDesc(String desc)
	{
		this.desc=desc;
		COLUMN_FLAG[3] = true;
	}
	public String getDesc()
	{
		return desc;
	}
}
