package car_beans;
import java.util.*;

public class  DboPubAd  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//���λid
	private int city;//����վ
	private String html;//���ҳ��
	private int adwidth;//�����
	private int adheight;//���߶�
	private String adtype;//���λ����
	private int adplace;//
	private double adprice;//���λ�۸�
	private long predictexposure;//Ԥ���ع�
	private long predictclick;//Ԥ�����
	private double predictcpc;//Ԥ��cpc
	private double predictcpl;//Ԥ��cpl


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[1] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setHtml(String html)
	{
		this.html=html;
		COLUMN_FLAG[2] = true;
	}
	public String getHtml()
	{
		return html;
	}
	public void setAdwidth(int adwidth)
	{
		this.adwidth=adwidth;
		COLUMN_FLAG[3] = true;
	}
	public int getAdwidth()
	{
		return adwidth;
	}
	public void setAdheight(int adheight)
	{
		this.adheight=adheight;
		COLUMN_FLAG[4] = true;
	}
	public int getAdheight()
	{
		return adheight;
	}
	public void setAdtype(String adtype)
	{
		this.adtype=adtype;
		COLUMN_FLAG[5] = true;
	}
	public String getAdtype()
	{
		return adtype;
	}
	public void setAdplace(int adplace)
	{
		this.adplace=adplace;
		COLUMN_FLAG[6] = true;
	}
	public int getAdplace()
	{
		return adplace;
	}
	public void setAdprice(double adprice)
	{
		this.adprice=adprice;
		COLUMN_FLAG[7] = true;
	}
	public double getAdprice()
	{
		return adprice;
	}
	public void setPredictexposure(long predictexposure)
	{
		this.predictexposure=predictexposure;
		COLUMN_FLAG[8] = true;
	}
	public long getPredictexposure()
	{
		return predictexposure;
	}
	public void setPredictclick(long predictclick)
	{
		this.predictclick=predictclick;
		COLUMN_FLAG[9] = true;
	}
	public long getPredictclick()
	{
		return predictclick;
	}
	public void setPredictcpc(double predictcpc)
	{
		this.predictcpc=predictcpc;
		COLUMN_FLAG[10] = true;
	}
	public double getPredictcpc()
	{
		return predictcpc;
	}
	public void setPredictcpl(double predictcpl)
	{
		this.predictcpl=predictcpl;
		COLUMN_FLAG[11] = true;
	}
	public double getPredictcpl()
	{
		return predictcpl;
	}
}
