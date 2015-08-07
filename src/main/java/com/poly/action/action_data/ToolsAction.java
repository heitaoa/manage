package com.poly.action.action_data;

import com.poly.action.MyActionSupport;
import com.poly.service.Tools;

public class ToolsAction extends MyActionSupport{
	private int type;
	public String execute(){
		//if(type==1){//业务人员
//			new Tools().saveSevice();
		//}else if(type==2){//推广人员；
//			new Tools().savePromo();
		//}else if(type==3){//客服
//			new Tools().saveCs();
			//new Tools().saveOtherCs();//其他分站销售给予客服节点
		//}
		//new Tools().saveSeviceForTq();
		new Tools().saveSeviceForTqToManager();
		return SUCCESS;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
