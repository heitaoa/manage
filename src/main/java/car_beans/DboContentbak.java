package car_beans;
import java.util.*;

public class  DboContentbak  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private int cid;//dbo_new_content.id
	private String contentstr;//
	private Date adddate;//
	private int isdesc;//
	private String description;//内容描述
	private String photo;//
	private int newsid;//dbo_new_news.id
	private int isfirst;//是否第一页 0不是 1是


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCid(int cid)
	{
		this.cid=cid;
		COLUMN_FLAG[1] = true;
	}
	public int getCid()
	{
		return cid;
	}
	public void setContentstr(String contentstr)
	{
		this.contentstr=contentstr;
		COLUMN_FLAG[2] = true;
	}
	public String getContentstr()
	{
		return contentstr;
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
	public void setIsdesc(int isdesc)
	{
		this.isdesc=isdesc;
		COLUMN_FLAG[4] = true;
	}
	public int getIsdesc()
	{
		return isdesc;
	}
	public void setDescription(String description)
	{
		this.description=description;
		COLUMN_FLAG[5] = true;
	}
	public String getDescription()
	{
		return description;
	}
	public void setPhoto(String photo)
	{
		this.photo=photo;
		COLUMN_FLAG[6] = true;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setNewsid(int newsid)
	{
		this.newsid=newsid;
		COLUMN_FLAG[7] = true;
	}
	public int getNewsid()
	{
		return newsid;
	}
	public void setIsfirst(int isfirst)
	{
		this.isfirst=isfirst;
		COLUMN_FLAG[8] = true;
	}
	public int getIsfirst()
	{
		return isfirst;
	}
}
