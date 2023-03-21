package com.hhuQd.test;

import com.hhuQd.entity.Page;
import com.hhuQd.entity.QJrecord;
import com.hhuQd.entity.QingJiaRecord;
import com.hhuQd.service.QingJiaRecordService;
import org.junit.Test;

import static org.junit.Assert.*;

public class QingJiaRecordServiceTest {
    QingJiaRecordService qingJiaRecordService=new QingJiaRecordService();

    @Test
    public void save() {
        QJrecord qJrecord=new QJrecord(1,1706030228,"张晓","很忙",null,"2020-01-23",1,254694);
        qingJiaRecordService.save(qJrecord);
    }

    @Test
    public void queryStudentQJrecord() {
        System.out.println(qingJiaRecordService.queryStudentQJrecord(12112020));
    }

    @Test
    public void page(){
        System.out.println(qingJiaRecordService.page(2,3,"1"));
    }

    @Test
    public void isAgreeeQingJia(){
        System.out.println(qingJiaRecordService.isAgreeeQingJia(1706030229,1));
    }
    @Test
    public void deleteAll() {
        System.out.println(qingJiaRecordService.deleteAll("1"));
    }

    @Test
    public void queryCount() {
        System.out.println(qingJiaRecordService.queryCount(2));
    }
}