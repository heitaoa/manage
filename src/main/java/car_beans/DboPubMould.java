package car_beans;
import java.util.*;

public class  DboPubMould  implements java.io.Serializable{

	public String KEY = "mouldid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private int mouldid;//ģ��id
	private String mouldname;//ģ������
	private String mouldphoto;//ģ��ͼƬ
	private String mouldhtml;//ģ�����
	private String mouldftl;//ģ��ftl


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
