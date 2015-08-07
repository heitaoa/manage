package com.poly.service;

import java.util.Date;
import java.util.List;

import car_beans.DboCarCatalog;
import car_beans.DboCarCatalognew;
import car_beans.DboCarQuestions;
import car_daos.DboCarCatalogDao;
import car_daos.DboCarCatalognewDao;
import car_daos.DboCarQuestionsDao;

public class CarQuestionService {
	public static final CarQuestionService instance = new CarQuestionService();
	public static CarQuestionService getInstance(){
		return instance;
	}
	DboCarQuestionsDao questionsDao = new DboCarQuestionsDao();
	DboCarCatalognewDao carCatalogDao = new DboCarCatalognewDao();
	public void addCarQuestion(int serialId){
		List<DboCarCatalognew> cars = carCatalogDao.where("catalogid="+serialId);
		if(cars.size()>0){
			DboCarCatalognew car = cars.get(0);
			int pathlevel = car.getPathlevel();
			if(pathlevel==2){
				for(int i = 0;i < 6;i++){
					DboCarQuestions questions = new DboCarQuestions();
					questions.setAddtime(new Date());
					questions.setSerialid(serialId);
					questions.setNickname("315车友");
					questions.setAnswertime(new Date());;
					questions.setMsgtype(i+1);
					try {
						questionsDao.save(questions);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
