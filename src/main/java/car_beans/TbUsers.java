package car_beans;
import java.util.*;

public class  TbUsers  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int id;//
	private String userid;//�û���
	private int isdelete;//�û�״̬ 0-ʹ�� 1-ɾ��
	private int prov;//�ֹܵ��� -ʡ
	private int city;//�ֹܵ���-��
	private String brands;//�ֹ�Ʒ��
	private Date addtime;//���ʱ��
	private String ulevel;//�û�Ȩ��  0-ϵͳ����Ա 1-��ͻ��ط���Ա  2-�ͷ� 3-����  4-��վ�༭ 5-��վ�༭  6-��վ����Ա
	private String detail;//


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
		COLUMN_FLAG[1] = true;
	}
	public String getUserid()
	{
		return userid;
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
	public void setProv(int prov)
	{
		this.prov=prov;
		COLUMN_FLAG[3] = true;
	}
	public int getProv()
	{
		return prov;
	}
	public void setCity(int city)
	{
		this.city=city;
		COLUMN_FLAG[4] = true;
	}
	public int getCity()
	{
		return city;
	}
	public void setBrands(String brands)
	{
		this.brands=brands;
		COLUMN_FLAG[5] = true;
	}
	public String getBrands()
	{
		return brands;
	}
	public void setAddtime(Date addtime)
	{
		this.addtime=addtime;
		COLUMN_FLAG[6] = true;
	}
	public Date getAddtime()
	{
		return addtime;
	}
	public void setUlevel(String ulevel)
	{
		this.ulevel=ulevel;
		COLUMN_FLAG[7] = true;
	}
	public String getUlevel()
	{
		return ulevel;
	}
	public void setDetail(String detail)
	{
		this.detail=detail;
		COLUMN_FLAG[8] = true;
	}
	public String getDetail()
	{
		return detail;
	}
}
