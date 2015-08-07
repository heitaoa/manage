package car_beans;
import java.util.*;

public class  DboPubSubjectdata  implements java.io.Serializable{

	public String KEY = "dataid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false};
	private int dataid;//数据id
	private int sid;//专题id
	private int mid;//模板id
	private String photo;//图片
	private String photourl;//图片链接
	private String photoclass;//图片样式
	private String text;//文字
	private String texturl;//文字链接
	private String textclass;//文字样式
	private String title;//标题
	private String titleurl;//标题链接
	private String titleclass;//标题样式


	public void setDataid(int dataid)
	{
		this.dataid=dataid;
		COLUMN_FLAG[0] = true;
	}
	public int getDataid()
	{
		return dataid;
	}
	public void setSid(int sid)
	{
		this.sid=sid;
		COLUMN_FLAG[1] = true;
	}
	public int getSid()
	{
		return sid;
	}
	public void setMid(int mid)
	{
		this.mid=mid;
		COLUMN_FLAG[2] = true;
	}
	public int getMid()
	{
		return mid;
	}
	public void setPhoto(String photo)
	{
		this.photo=photo;
		COLUMN_FLAG[3] = true;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setPhotourl(String photourl)
	{
		this.photourl=photourl;
		COLUMN_FLAG[4] = true;
	}
	public String getPhotourl()
	{
		return photourl;
	}
	public void setPhotoclass(String photoclass)
	{
		this.photoclass=photoclass;
		COLUMN_FLAG[5] = true;
	}
	public String getPhotoclass()
	{
		return photoclass;
	}
	public void setText(String text)
	{
		this.text=text;
		COLUMN_FLAG[6] = true;
	}
	public String getText()
	{
		return text;
	}
	public void setTexturl(String texturl)
	{
		this.texturl=texturl;
		COLUMN_FLAG[7] = true;
	}
	public String getTexturl()
	{
		return texturl;
	}
	public void setTextclass(String textclass)
	{
		this.textclass=textclass;
		COLUMN_FLAG[8] = true;
	}
	public String getTextclass()
	{
		return textclass;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[9] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitleurl(String titleurl)
	{
		this.titleurl=titleurl;
		COLUMN_FLAG[10] = true;
	}
	public String getTitleurl()
	{
		return titleurl;
	}
	public void setTitleclass(String titleclass)
	{
		this.titleclass=titleclass;
		COLUMN_FLAG[11] = true;
	}
	public String getTitleclass()
	{
		return titleclass;
	}
}
