package car_beans;
import java.util.*;

public class  TbForeignRelation  implements java.io.Serializable{

	public boolean[] COLUMN_FLAG = {false,false,false,false,false};
	private String main_table;//����
	private String main_column;//��λ��
	private String foreign_table;//Ӧ�ñ�
	private String foreign_column;//����λ��
	private String name;//�����Ӧ��bean����������


	public void setMain_table(String main_table)
	{
		this.main_table=main_table;
		COLUMN_FLAG[0] = true;
	}
	public String getMain_table()
	{
		return main_table;
	}
	public void setMain_column(String main_column)
	{
		this.main_column=main_column;
		COLUMN_FLAG[1] = true;
	}
	public String getMain_column()
	{
		return main_column;
	}
	public void setForeign_table(String foreign_table)
	{
		this.foreign_table=foreign_table;
		COLUMN_FLAG[2] = true;
	}
	public String getForeign_table()
	{
		return foreign_table;
	}
	public void setForeign_column(String foreign_column)
	{
		this.foreign_column=foreign_column;
		COLUMN_FLAG[3] = true;
	}
	public String getForeign_column()
	{
		return foreign_column;
	}
	public void setName(String name)
	{
		this.name=name;
		COLUMN_FLAG[4] = true;
	}
	public String getName()
	{
		return name;
	}
}
