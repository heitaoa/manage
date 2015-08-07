package com.poly.service;

import java.util.HashMap;
import java.util.List;

import com.poly.dao.subDaos.TbApplyPhonesSubDao;

public class SendMsgService {
	public static final SendMsgService instance = new SendMsgService();
	public static SendMsgService getInstance(){
		return instance;
	}
	TbApplyPhonesSubDao tbApplyPhonesSubDao = new TbApplyPhonesSubDao();
	public int sendMsg(List<HashMap<String, String>> msgs){
		return tbApplyPhonesSubDao.sendMsg(msgs);
	}
}
