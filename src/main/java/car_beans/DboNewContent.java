package car_beans;
import java.util.*;

public class  DboNewContent  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//�Զ�����id
	private int newsid;//����(new_news)���Զ�����id
	private int areaid;//�������id
	private int carcatalogid;//���ͷ���id
	private String newstitle;//����
	private String newskeywords;//�ؼ���
	private String newscontent;//����
	private Date adddate;//���ʱ��
	private Date lastupdate;//������ʱ��
	private int sortid;//����
	private int isdelete;//0����
	private String titleimgpath;//
	private int serialid;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setNewsid(int newsid)
	{
		this.newsid=newsid;
		COLUMN_FLAG[1] = true;
	}
	public int getNewsid()
	{
		return newsid;
	}
	public void setAreaid(int areaid)
	{
		this.areaid=areaid;
		COLUMN_FLAG[2] = true;
	}
	public int getAreaid()
	{
		return areaid;
	}
	public void setCarcatalogid(int carcatalogid)
	{
		this.carcatalogid=carcatalogid;
		COLUMN_FLAG[3] = true;
	}
	public int getCarcatalogid()
	{
		return carcatalogid;
	}
	public void setNewstitle(String newstitle)
	{
		this.newstitle=newstitle;
		COLUMN_FLAG[4] = true;
	}
	public String getNewstitle()
	{
		return newstitle;
	}
	public void setNewskeywords(String newskeywords)
	{
		this.newskeywords=newskeywords;
		COLUMN_FLAG[5] = true;
	}
	public String getNewskeywords()
	{
		return newskeywords;
	}
	public void setNewscontent(String newscontent)
	{
		this.newscontent=newscontent;
		COLUMN_FLAG[6] = true;
	}
	public String getNewscontent()
	{
		return newscontent;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[7] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[8] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
	}
	public void setSortid(int sortid)
	{
		this.sortid=sortid;
		COLUMN_FLAG[9] = true;
	}
	public int getSortid()
	{
		return sortid;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[10] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setTitleimgpath(String titleimgpath)
	{
		this.titleimgpath=titleimgpath;
		COLUMN_FLAG[11] = true;
	}
	public String getTitleimgpath()
	{
		return titleimgpath;
	}
	public void setSerialid(int serialid)
	{
		this.serialid=serialid;
		COLUMN_FLAG[12] = true;
	}
	public int getSerialid()
	{
		return serialid;
	}
}
