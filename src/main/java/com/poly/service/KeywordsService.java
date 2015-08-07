package com.poly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import car_beans.TbKeywords;
import car_daos.TbKeywordsDao;

public class KeywordsService {
	public static final Map<String, Object> KEYWORDSSERVICE_MAP = new HashMap<String, Object>();
	public static final ExecutorService SERVICE = Executors
			.newCachedThreadPool();

	public static Map<String, Object> getMap() {
		Object obj = KEYWORDSSERVICE_MAP.get("queryAllKeywords");
		if (obj == null) {
			queryAllKeywords();
		}
		return KEYWORDSSERVICE_MAP;
	}

	@SuppressWarnings("unchecked")
	public static List<TbKeywords> queryAllKeywords() {
		List<TbKeywords> keywords = (List<TbKeywords>) KEYWORDSSERVICE_MAP
				.get("queryAllKeywords");
		if (keywords == null) {
			keywords = TbKeywordsDao.find();
			for (TbKeywords kw : keywords) {
				if (kw.getId() > id) {
					id = kw.getId();
				}
				KEYWORDSSERVICE_MAP.put(kw.getKeyword(), kw);
			}
			id++;
			KEYWORDSSERVICE_MAP.put("queryAllKeywords", keywords);
		}
		return keywords;
	}

	private static int id;

	public static int getInsertId() {
		return id++;
	}

	public static boolean hasThisKeyword(String keyword) {
		return (getMap().get(keyword) != null);
	}

	public static void saveKeyword(final TbKeywords keyword) {
		keyword.setId(getInsertId());
		getMap().put(keyword.getKeyword(), keyword);
		SERVICE.execute(new Runnable() {
			@Override
			public void run() {
				try {
					TbKeywordsDao.save(keyword);

					updateList(1, keyword);
				} catch (Exception e) {
					e.printStackTrace();
					getMap().remove(keyword.getKeyword());
				}
			}
		});
	}

	public static void updateKeyword(final TbKeywords keyword) {
		final TbKeywords oldObject = (TbKeywords) getMap().get(
				keyword.getKeyword());
		getMap().put(keyword.getKeyword(), keyword);
		SERVICE.execute(new Runnable() {
			@Override
			public void run() {
				try {
					TbKeywordsDao.update(keyword);

					updateList(2, keyword);
				} catch (Exception e) {
					e.printStackTrace();
					getMap().put(keyword.getKeyword(), oldObject);
				}
			}
		});
	}

	public static void deleteById(int id) {
		TbKeywords keyword = getTbKeywordById(id);
		if (keyword != null) {
			try {
				TbKeywordsDao.delete(" id=" + id);
				getMap().remove(keyword.getKeyword());
				updateList(3, keyword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static TbKeywords getTbKeywordById(int id) {
		List<TbKeywords> keywords = (List<TbKeywords>) getMap().get(
				"queryAllKeywords");
		for (TbKeywords kw : keywords) {
			if (id == kw.getId()) {
				return kw;
			}
		}

		return null;
	}

	/**
	 * add 1
	 * 
	 * update 2
	 * 
	 * delete 3
	 * 
	 * @param type
	 * @param keyword
	 */
	public static void updateList(int type, TbKeywords keyword) {
		synchronized (KEYWORDSSERVICE_MAP) {
			@SuppressWarnings("unchecked")
			List<TbKeywords> keywords = (List<TbKeywords>) KEYWORDSSERVICE_MAP
					.get("queryAllKeywords");
			switch (type) {
			case 1:
				keywords.add(keyword);
				break;
			case 2:
				for (int i = 0; i < keywords.size(); i++) {
					if (keywords.get(i).getKeyword()
							.equals(keyword.getKeyword())) {
						keywords.set(i, keyword);
						break;
					}
				}
				break;
			case 3:
				for (int i = 0; i < keywords.size(); i++) {
					if (keywords.get(i).getKeyword()
							.equals(keyword.getKeyword())) {
						keywords.remove(i);
						break;
					}
				}

				break;
			}
		}
	}
}
