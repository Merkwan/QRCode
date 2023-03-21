package com.hhuQd.test;

import com.hhuQd.service.QdRecordService;
import org.junit.Test;

import static org.junit.Assert.*;

public class QdRecordServiceTest {
    QdRecordService qdRecordService=new QdRecordService();
    @Test
    public void queryStudentQDRecord() {
        System.out.println(qdRecordService.queryStudentQDRecord(1706030226));
    }

    @Test
    public void queryDataBycid() {
        System.out.println(qdRecordService.queryDataBycid("258465"));
    }

    @Test
    public void publish_sign() {
        System.out.println(qdRecordService.publish_sign("1","05:25:30"));
    }

    @Test
    public void isSign() {
        System.out.println(qdRecordService.isSign("河海小老弟","2020-01-01","12:00:00"));
    }

    @Test
    public void page() {
        System.out.println(qdRecordService.page(1,2,1,"1"));
    }

    @Test
    public void deleteAll() {
        System.out.println(qdRecordService.deleteAll(1,"1"));
    }

    @Test
    public void queryCount() {
        System.out.println(qdRecordService.queryCount(1,1));
    }
}