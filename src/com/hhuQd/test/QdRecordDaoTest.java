package com.hhuQd.test;

import com.hhuQd.dao.QdRecordDao;
import com.hhuQd.entity.QdRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class QdRecordDaoTest {
    QdRecordDao qdRecordDao=new QdRecordDao();
    QdRecord   qdRecord=new QdRecord("1706030227","张三",2020-05-15","10:05:20","12:00:00",1,3);
    @Test
    public void queryStudentQDRecord() {
        System.out.println(qdRecordDao.queryStudentQDRecord(qdRecord.getSno()));
    }

    @Test
    public void queryDataByteacherId() {
        String tid="215512";
        System.out.println(qdRecordDao.queryDataByteacherId(tid));
    }

    @Test
    public void creat_signinfo() {
        //System.out.println(qdRecordDao.creat_signinfo());
    }

    @Test
    public void changeSign() {
        System.out.println(qdRecordDao.changeSign(1,"115202","2020-01-02","10:10:10"));
    }

    @Test
    public void isSign() {
        System.out.println(qdRecordDao.isSign("12231","2020-01-02"));
    }

    @Test
    public void selectSno() {
        System.out.println(qdRecordDao.selectSno("河海小老弟"));
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(qdRecordDao.queryForPageTotalCount(1,2));
    }

    @Test
    public void queryForPageItems() {
        System.out.println(qdRecordDao.queryForPageItems(1,10,0,2));
    }

    @Test
    public void isPost() {
        System.out.println(qdRecordDao.isPost("2020-10-10"));
    }

    @Test
    public void deleteAll() {
        System.out.println(qdRecordDao.deleteAll(1,1));
    }
}