package car_beans;
import java.util.*;

public class  DboPubSubjectdata  implements java.io.Serializable{

	public String KEY = "dataid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false};
	private int dataid;//����id
	private int sid;//ר��id
	private int mid;//ģ��id
	private String photo;//ͼƬ
	private String photourl;//ͼƬ����
	private String photoclass;//ͼƬ��ʽ
	private String text;//����
	private String texturl;//��������
	private String textclass;//������ʽ
	private String title;//����
	private String titleurl;//��������
	private String titleclass;//������ʽ


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
