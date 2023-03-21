package com.hhuQd.service;

import java.util.List;

import com.hhuQd.dao.ClassesDao;
import com.hhuQd.entity.Classes;

public class ClassService {

	private ClassesDao ddao = new ClassesDao();

	public List<Classes> queryAll() {
		return ddao.queryAll();
	}

	/**
	 * 保存字典数据
	 * 
	 * @param d
	 */
	public void saveDictionary(Classes d) {
		// 首先进行一些判断
		// 如果已经有相同的数据了，则不能够保存
		boolean result = ddao.queryByParam(d);
		if (result == true) {
			throw new RuntimeException("已经重复的数据请勿重复添加");
		}

		ddao.save(d);

	}

	public List<String> getYuan() {
		return ddao.getYuan();
	}



	public List<String> getZY() {
		// TODO Auto-generated method stub
		return ddao.getZY();
	}

	public List<String> getNJ() {
		// TODO Auto-generated method stub
		return ddao.getNJ();
	}

	public List<String> getBJ() {
		// TODO Auto-generated method stub
		return ddao.getBJ();
	}

	public  List<Classes>  getBJAll() {
		return ddao.getBJAll();
	}
	

	public List<Object[]> getClassStuCount() {
		return ddao.getClassStuCount();
	}

}
