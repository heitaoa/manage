package car_beans;
import java.util.*;

public class  DboDeaNews  implements java.io.Serializable{

	public String KEY = "newsid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int newsid;//����������id
	private int eid;//��ҵid
	private int typeid;//���ŷ���id23����Ѷ������24����ҵ���ŵȵ�
	private int views;//�����
	private int hotsortid;//�ȵ���������id
	private Date adddate;//�������
	private Date publishdate;//��������
	private Date hotdate;//�Ƽ�����
	private int isdelete;//ɾ����ʶ��0--������1--��ɾ����2--δ����
	private int ishot;//�Ƿ��Ƽ�
	private String title;//���ű���
	private String newscontent;//
	private int bbstopicpostid;//

	private DboNewCatalog catalog;//
	public void setCatalog(DboNewCatalog catalog)
	{
		this.catalog=catalog;
	}
	public DboNewCatalog getCatalog()
	{
		return catalog;
	}

	public void setNewsid(int newsid)
	{
		this.newsid=newsid;
		COLUMN_FLAG[0] = true;
	}
	public int getNewsid()
	{
		return newsid;
	}
	public void setEid(int eid)
	{
		this.eid=eid;
		COLUMN_FLAG[1] = true;
	}
	public int getEid()
	{
		return eid;
	}
	public void setTypeid(int typeid)
	{
		this.typeid=typeid;
		COLUMN_FLAG[2] = true;
	}
	public int getTypeid()
	{
		return typeid;
	}
	public void setViews(int views)
	{
		this.views=views;
		COLUMN_FLAG[3] = true;
	}
	public int getViews()
	{
		return views;
	}
	public void setHotsortid(int hotsortid)
	{
		this.hotsortid=hotsortid;
		COLUMN_FLAG[4] = true;
	}
	public int getHotsortid()
	{
		return hotsortid;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[5] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setPublishdate(Date publishdate)
	{
		this.publishdate=publishdate;
		COLUMN_FLAG[6] = true;
	}
	public Date getPublishdate()
	{
		return publishdate;
	}
	public void setHotdate(Date hotdate)
	{
		this.hotdate=hotdate;
		COLUMN_FLAG[7] = true;
	}
	public Date getHotdate()
	{
		return hotdate;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[8] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setIshot(int ishot)
	{
		this.ishot=ishot;
		COLUMN_FLAG[9] = true;
	}
	public int getIshot()
	{
		return ishot;
	}
	public void setTitle(String title)
	{
		this.title=title;
		COLUMN_FLAG[10] = true;
	}
	public String getTitle()
	{
		return title;
	}
	public void setNewscontent(String newscontent)
	{
		this.newscontent=newscontent;
		COLUMN_FLAG[11] = true;
	}
	public String getNewscontent()
	{
		return newscontent;
	}
	public void setBbstopicpostid(int bbstopicpostid)
	{
		this.bbstopicpostid=bbstopicpostid;
		COLUMN_FLAG[12] = true;
	}
	public int getBbstopicpostid()
	{
		return bbstopicpostid;
	}
}
