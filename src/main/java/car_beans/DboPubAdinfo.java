package car_beans;
import java.util.*;

public class  DboPubAdinfo  implements java.io.Serializable{

	public String KEY = "adinfoid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false};
	private int adinfoid;//���Ԫ��id
	private int adid;//���λid
	private String adimg;//���ͼƬ
	private long adexposure;//����ع�
	private long adclick;//�����
	private String adurl;//������ӵ�ַ
	private int isdelete;//�Ƿ�ɾ����0����δɾ������1����ɾ��
	private int isshow;//�Ƿ���ʾ����0������ʾ����1��������ʾ
	private int isdefault;//�Ƿ���Ĭ�Ϲ�桰0�����ǣ���1������
	private String adftl;//���λģ��


	public void setAdinfoid(int adinfoid)
	{
		this.adinfoid=adinfoid;
		COLUMN_FLAG[0] = true;
	}
	public int getAdinfoid()
	{
		return adinfoid;
	}
	public void setAdid(int adid)
	{
		this.adid=adid;
		COLUMN_FLAG[1] = true;
	}
	public int getAdid()
	{
		return adid;
	}
	public void setAdimg(String adimg)
	{
		this.adimg=adimg;
		COLUMN_FLAG[2] = true;
	}
	public String getAdimg()
	{
		return adimg;
	}
	public void setAdexposure(long adexposure)
	{
		this.adexposure=adexposure;
		COLUMN_FLAG[3] = true;
	}
	public long getAdexposure()
	{
		return adexposure;
	}
	public void setAdclick(long adclick)
	{
		this.adclick=adclick;
		COLUMN_FLAG[4] = true;
	}
	public long getAdclick()
	{
		return adclick;
	}
	public void setAdurl(String adurl)
	{
		this.adurl=adurl;
		COLUMN_FLAG[5] = true;
	}
	public String getAdurl()
	{
		return adurl;
	}
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[6] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setIsshow(int isshow)
	{
		this.isshow=isshow;
		COLUMN_FLAG[7] = true;
	}
	public int getIsshow()
	{
		return isshow;
	}
	public void setIsdefault(int isdefault)
	{
		this.isdefault=isdefault;
		COLUMN_FLAG[8] = true;
	}
	public int getIsdefault()
	{
		return isdefault;
	}
	public void setAdftl(String adftl)
	{
		this.adftl=adftl;
		COLUMN_FLAG[9] = true;
	}
	public String getAdftl()
	{
		return adftl;
	}
}
