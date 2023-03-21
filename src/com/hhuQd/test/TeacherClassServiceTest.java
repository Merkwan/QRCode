package com.hhuQd.test;

import com.hhuQd.service.TeacherClassService;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherClassServiceTest {
    TeacherClassService teacherClassService=new TeacherClassService();
    @Test
    public void queryByTeacherId() {
        teacherClassService.queryByTeacherId(258456);
    }
}