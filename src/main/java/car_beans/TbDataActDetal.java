package car_beans;
import java.util.*;

public class  TbDataActDetal  implements java.io.Serializable{

	public String KEY = "detail_id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false};
	private int detail_id;//�����id
	private String pro_num;//��Ŀ���
	private String detal_executor;//ִ����
	private String detal_assist_person;//����������Ա
	private Date detai_acti_date;//�����
	private int detail_time_interval;//ʱ��
	private String detail_traffic_expense;//��ͽ�ͨ��
	private String detail_acti_sub;//���Ա����
	private String detail_acti_report;//��ܽ�


	public void setDetail_id(int detail_id)
	{
		this.detail_id=detail_id;
		COLUMN_FLAG[0] = true;
	}
	public int getDetail_id()
	{
		return detail_id;
	}
	public void setPro_num(String pro_num)
	{
		this.pro_num=pro_num;
		COLUMN_FLAG[1] = true;
	}
	public String getPro_num()
	{
		return pro_num;
	}
	public void setDetal_executor(String detal_executor)
	{
		this.detal_executor=detal_executor;
		COLUMN_FLAG[2] = true;
	}
	public String getDetal_executor()
	{
		return detal_executor;
	}
	public void setDetal_assist_person(String detal_assist_person)
	{
		this.detal_assist_person=detal_assist_person;
		COLUMN_FLAG[3] = true;
	}
	public String getDetal_assist_person()
	{
		return detal_assist_person;
	}
	public void setDetai_acti_date(Date detai_acti_date)
	{
		this.detai_acti_date=detai_acti_date;
		COLUMN_FLAG[4] = true;
	}
	public Date getDetai_acti_date()
	{
		return detai_acti_date;
	}
	public void setDetail_time_interval(int detail_time_interval)
	{
		this.detail_time_interval=detail_time_interval;
		COLUMN_FLAG[5] = true;
	}
	public int getDetail_time_interval()
	{
		return detail_time_interval;
	}
	public void setDetail_traffic_expense(String detail_traffic_expense)
	{
		this.detail_traffic_expense=detail_traffic_expense;
		COLUMN_FLAG[6] = true;
	}
	public String getDetail_traffic_expense()
	{
		return detail_traffic_expense;
	}
	public void setDetail_acti_sub(String detail_acti_sub)
	{
		this.detail_acti_sub=detail_acti_sub;
		COLUMN_FLAG[7] = true;
	}
	public String getDetail_acti_sub()
	{
		return detail_acti_sub;
	}
	public void setDetail_acti_report(String detail_acti_report)
	{
		this.detail_acti_report=detail_acti_report;
		COLUMN_FLAG[8] = true;
	}
	public String getDetail_acti_report()
	{
		return detail_acti_report;
	}
}
