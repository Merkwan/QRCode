package com.hhuQd.service;

import java.util.List;

import com.hhuQd.dao.TeacherClassDao;
import com.hhuQd.entity.Classes;

public class TeacherClassService {

	private TeacherClassDao tcd = new TeacherClassDao();

	public List<Classes> queryByTeacherId(int teacherId) {
		return tcd.queryByTeacherId(teacherId);
	}
}
