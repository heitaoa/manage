package car_beans;
import java.util.*;

public class  DboDeaDealerinfo  implements java.io.Serializable{

	public String KEY = "infoid";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int infoid;//��ҵ��Ϣ������id
	private int eid;//��ҵid
	private int isdelete;//ɾ����ʶ��0--������1--��ɾ��
	private String address;//��ҵ��ַ
	private String intro;//��ҵ����
	private String zipcode;//�ʱ�
	private String faq;//����
	private String webaddress;//��ַ
	private String email;//����
	private String salephone;//���۵绰
	private String traffic;//��ͨ����
	private String speech;//�쵼�´�
	private String honor;//��������
	private String mapinfo;//��ͼ��Ϣ
	private String h_lat;//��λ-��γ
	private String h_lng;//��λ-����
	private String qq;//
	private String wangwang;//
	private String sinaweibo;//
	private String afterphone;//
	private String helpphone;//
	private String navurl;//


	public void setInfoid(int infoid)
	{
		this.infoid=infoid;
		COLUMN_FLAG[0] = true;
	}
	public int getInfoid()
	{
		return infoid;
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
	public void setIsdelete(int isdelete)
	{
		this.isdelete=isdelete;
		COLUMN_FLAG[2] = true;
	}
	public int getIsdelete()
	{
		return isdelete;
	}
	public void setAddress(String address)
	{
		this.address=address;
		COLUMN_FLAG[3] = true;
	}
	public String getAddress()
	{
		return address;
	}
	public void setIntro(String intro)
	{
		this.intro=intro;
		COLUMN_FLAG[4] = true;
	}
	public String getIntro()
	{
		return intro;
	}
	public void setZipcode(String zipcode)
	{
		this.zipcode=zipcode;
		COLUMN_FLAG[5] = true;
	}
	public String getZipcode()
	{
		return zipcode;
	}
	public void setFaq(String faq)
	{
		this.faq=faq;
		COLUMN_FLAG[6] = true;
	}
	public String getFaq()
	{
		return faq;
	}
	public void setWebaddress(String webaddress)
	{
		this.webaddress=webaddress;
		COLUMN_FLAG[7] = true;
	}
	public String getWebaddress()
	{
		return webaddress;
	}
	public void setEmail(String email)
	{
		this.email=email;
		COLUMN_FLAG[8] = true;
	}
	public String getEmail()
	{
		return email;
	}
	public void setSalephone(String salephone)
	{
		this.salephone=salephone;
		COLUMN_FLAG[9] = true;
	}
	public String getSalephone()
	{
		return salephone;
	}
	public void setTraffic(String traffic)
	{
		this.traffic=traffic;
		COLUMN_FLAG[10] = true;
	}
	public String getTraffic()
	{
		return traffic;
	}
	public void setSpeech(String speech)
	{
		this.speech=speech;
		COLUMN_FLAG[11] = true;
	}
	public String getSpeech()
	{
		return speech;
	}
	public void setHonor(String honor)
	{
		this.honor=honor;
		COLUMN_FLAG[12] = true;
	}
	public String getHonor()
	{
		return honor;
	}
	public void setMapinfo(String mapinfo)
	{
		this.mapinfo=mapinfo;
		COLUMN_FLAG[13] = true;
	}
	public String getMapinfo()
	{
		return mapinfo;
	}
	public void setH_lat(String h_lat)
	{
		this.h_lat=h_lat;
		COLUMN_FLAG[14] = true;
	}
	public String getH_lat()
	{
		return h_lat;
	}
	public void setH_lng(String h_lng)
	{
		this.h_lng=h_lng;
		COLUMN_FLAG[15] = true;
	}
	public String getH_lng()
	{
		return h_lng;
	}
	public void setQq(String qq)
	{
		this.qq=qq;
		COLUMN_FLAG[16] = true;
	}
	public String getQq()
	{
		return qq;
	}
	public void setWangwang(String wangwang)
	{
		this.wangwang=wangwang;
		COLUMN_FLAG[17] = true;
	}
	public String getWangwang()
	{
		return wangwang;
	}
	public void setSinaweibo(String sinaweibo)
	{
		this.sinaweibo=sinaweibo;
		COLUMN_FLAG[18] = true;
	}
	public String getSinaweibo()
	{
		return sinaweibo;
	}
	public void setAfterphone(String afterphone)
	{
		this.afterphone=afterphone;
		COLUMN_FLAG[19] = true;
	}
	public String getAfterphone()
	{
		return afterphone;
	}
	public void setHelpphone(String helpphone)
	{
		this.helpphone=helpphone;
		COLUMN_FLAG[20] = true;
	}
	public String getHelpphone()
	{
		return helpphone;
	}
	public void setNavurl(String navurl)
	{
		this.navurl=navurl;
		COLUMN_FLAG[21] = true;
	}
	public String getNavurl()
	{
		return navurl;
	}
}
