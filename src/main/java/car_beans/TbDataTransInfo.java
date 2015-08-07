package car_beans;
import java.util.*;

public class  TbDataTransInfo  implements java.io.Serializable{

	public String KEY = "id";
	public boolean[] COLUMN_FLAG = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	private int id;//id
	private String pro_num;//项目编号
	private String name;//姓名
	private String phone;//电话
	private String plate;//车牌号
	private String addr;//地址
	private int model;//成交车型
	private Date trans_date;//交易日期
	private String trans_price;//成交价格
	private String engine_num;//发动机编号
	private String vin_num;//vin车架号
	private String giving_code;//赠品code(0-1,0-2,1-1,1-2)逗号隔开，“-”号之前表示赠品类型，0表示礼包，1表示礼品，“-”号之后表示赠品id
	private String giving_name;//赠品名称
	private int is_giving_send;//赠品是否送出(0-未送出，1-已送出)
	private int qiandao_id;//签到id
	private String sale_man;//签单销售
	private String giving_total_price;//礼品总价
	private int gift_examine_state;//礼品审核状态(0-未审核，1-审核通过，2-驳回）


	public void setId(int id)
	{
		this.id=id;
		COLUMN_FLAG[0] = true;
	}
	public int getId()
	{
		return id;
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
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[2] = true;
	}
	public String getName()
	{
		return name;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		COLUMN_FLAG[3] = true;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPlate(String plate)
	{
		this.plate=plate;
		COLUMN_FLAG[4] = true;
	}
	public String getPlate()
	{
		return plate;
	}
	public void setAddr(String addr)
	{
		this.addr=addr;
		COLUMN_FLAG[5] = true;
	}
	public String getAddr()
	{
		return addr;
	}
	public void setModel(int model)
	{
		this.model=model;
		COLUMN_FLAG[6] = true;
	}
	public int getModel()
	{
		return model;
	}
	public void setTrans_date(Date trans_date)
	{
		this.trans_date=trans_date;
		COLUMN_FLAG[7] = true;
	}
	public Date getTrans_date()
	{
		return trans_date;
	}
	public void setTrans_price(String trans_price)
	{
		this.trans_price=trans_price;
		COLUMN_FLAG[8] = true;
	}
	public String getTrans_price()
	{
		return trans_price;
	}
	public void setEngine_num(String engine_num)
	{
		this.engine_num=engine_num;
		COLUMN_FLAG[9] = true;
	}
	public String getEngine_num()
	{
		return engine_num;
	}
	public void setVin_num(String vin_num)
	{
		this.vin_num=vin_num;
		COLUMN_FLAG[10] = true;
	}
	public String getVin_num()
	{
		return vin_num;
	}
	public void setGiving_code(String giving_code)
	{
		this.giving_code=giving_code;
		COLUMN_FLAG[11] = true;
	}
	public String getGiving_code()
	{
		return giving_code;
	}
	public void setGiving_name(String giving_name)
	{
		this.giving_name=giving_name;
		COLUMN_FLAG[12] = true;
	}
	public String getGiving_name()
	{
		return giving_name;
	}
	public void setIs_giving_send(int is_giving_send)
	{
		this.is_giving_send=is_giving_send;
		COLUMN_FLAG[13] = true;
	}
	public int getIs_giving_send()
	{
		return is_giving_send;
	}
	public void setQiandao_id(int qiandao_id)
	{
		this.qiandao_id=qiandao_id;
		COLUMN_FLAG[14] = true;
	}
	public int getQiandao_id()
	{
		return qiandao_id;
	}
	public void setSale_man(String sale_man)
	{
		this.sale_man=sale_man;
		COLUMN_FLAG[15] = true;
	}
	public String getSale_man()
	{
		return sale_man;
	}
	public void setGiving_total_price(String giving_total_price)
	{
		this.giving_total_price=giving_total_price;
		COLUMN_FLAG[16] = true;
	}
	public String getGiving_total_price()
	{
		return giving_total_price;
	}
	public void setGift_examine_state(int gift_examine_state)
	{
		this.gift_examine_state=gift_examine_state;
		COLUMN_FLAG[17] = true;
	}
	public int getGift_examine_state()
	{
		return gift_examine_state;
	}
}
