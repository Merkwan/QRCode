package com.hhuQd.dao.inf;

import com.hhuQd.entity.QdRecord;

import java.util.List;
import java.util.Objects;

public interface QdRecordDaoInf {
    public int creat_signinfo(Object[] sno,Object[] sname,Object[] qdate,Object[] qtime,Object[] endtimes);

    public int changeSign(int flag,String sno,String qdate,String qrtime);

    public String isSign(String sno,String qdate);

    public String selectSno(String weixinnick);

    Object queryForPageTotalCount(int resultnum,int cid);

    List<Object[]> queryForPageItems(int begin, int pageSize, int resultnum, int cid);

    public int isPost(String qdate);

    int deleteAll(int result,int cid);
}
