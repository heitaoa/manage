package car_beans;
import java.util.*;

public class  DboImgNewtitle  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//�Զ�����id
	private int catalogid;//Ŀ¼id
	private int totop;//��������
	private int tosink;//���ȴ���
	private Date toptime;//��󱻶�ʱ��
	private Date sinktime;//��󱻲�ʱ��
	private int contentid;//Ĭ�ϵ�ͼƬ����id
	private int qqcatalogid;//��Ѷ����Ŀ¼id
	private int type;//�������0��ʾ�ǳ��ͣ�
	private int isdelete;//0����
	private String title;//����
	private String keywords;//�ؼ���
	private String addadmin;//��Ӳ�������Ա�û���
	private String updateadmin;//�޸Ĳ�������Ա�û���
	private String deladmin;//ɾ����������Ա�û���
	private Date adddate;//���ʱ��
	private Date lastupdate;//����޸�ʱ��


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCatalogid(int catalogid)
	{
		this.catalogid=catalogid;
		COLUMN_FLAG[1] = true;
	}
	public int getCatalogid()
	{
		return catalogid;
	}
	public void setTotop(int totop)
	{
		this.totop=totop;
		COLUMN_FLAG[2] = true;
	}
	public int getTotop()
	{
		return totop;
	}
	public void setTosink(int tosink)
	{
		this.tosink=tosink;
		COLUMN_FLAG[3] = true;
	}
	public int getTosink()
	{
		return tosink;
	}
	public void setToptime(Date toptime)
	{
		this.toptime=toptime;
		COLUMN_FLAG[4] = true;
	}
	public Date getToptime()
	{
		return toptime;
	}
	public void setSinktime(Date sinktime)
	{
		this.sinktime=sinktime;
		COLUMN_FLAG[5] = true;
	}
	public Date getSinktime()
	{
		return sinktime;
	}
	public void setContentid(int contentid)
	{
		this.contentid=contentid;
		COLUMN_FLAG[6] = true;
	}
	public int getContentid()
	{
		return contentid;
	}
	public void setQqcatalogid(int qqcatalogid)
	{
		this.qqcatalogid=qqcatalogid;
		COLUMN_FLAG[7] = true;
	}
	public int getQqcatalogid()
	{
		return qqcatalogid;
	}
	public void setType(int type)
	{
		this.type=type;
		COLUMN_FLAG[8] = true;
	}
	public int getType()
	{
		return type;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[9] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
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
	public void setKeywords(String keywords)
	{
		this.keywords=keywords;
		COLUMN_FLAG[11] = true;
	}
	public String getKeywords()
	{
		return keywords;
	}
	public void setAddadmin(String addadmin)
	{
		this.addadmin=addadmin;
		COLUMN_FLAG[12] = true;
	}
	public String getAddadmin()
	{
		return addadmin;
	}
	public void setUpdateadmin(String updateadmin)
	{
		this.updateadmin=updateadmin;
		COLUMN_FLAG[13] = true;
	}
	public String getUpdateadmin()
	{
		return updateadmin;
	}
	public void setDeladmin(String deladmin)
	{
		this.deladmin=deladmin;
		COLUMN_FLAG[14] = true;
	}
	public String getDeladmin()
	{
		return deladmin;
	}
	public void setAdddate(Date adddate)
	{
		this.adddate=adddate;
		COLUMN_FLAG[15] = true;
	}
	public Date getAdddate()
	{
		return adddate;
	}
	public void setLastupdate(Date lastupdate)
	{
		this.lastupdate=lastupdate;
		COLUMN_FLAG[16] = true;
	}
	public Date getLastupdate()
	{
		return lastupdate;
	}
}
