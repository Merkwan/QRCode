package com.hhuQd.test;

import com.hhuQd.dao.QingJiaRecordDao;
import com.hhuQd.entity.QJrecord;
import com.hhuQd.entity.QingJiaRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class QingJiaRecordDaoTest {
    QingJiaRecordDao qingJiaRecordDao=new QingJiaRecordDao();
    QJrecord qJrecord=new QJrecord(12,1706030227,"王明","离校",null,"2020-01-01",1,123456);
    QingJiaRecord qingJiaRecord=new QingJiaRecord(20,"1706030227","2020-05-15",1,"离校","王明");
    @Test
    public void save() {
        qingJiaRecordDao.save(qJrecord);
    }

    @Test
    public void queryStudentQJrecord() {
        qingJiaRecordDao.queryStudentQJrecord(qJrecord.getStudentno());
    }

    @Test
    public void queryForPageItems() {
        qingJiaRecordDao.queryForPageItems(1,5,2);
    }

    @Test
    public void queryForPageTotalCount() {
        qingJiaRecordDao.queryForPageTotalCount(2);
    }

    @Test
    public void updateQresult() {
        qingJiaRecordDao.updateQresult(qJrecord.getQid(),qJrecord.getQresult());
    }

    @Test
    public void deleteAll() {
        qingJiaRecordDao.deleteAll(2);
    }
}