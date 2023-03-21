package com.hhuQd.dao.inf;

import java.util.List;

public interface QingJiaRecordDaoInf {
    public List<Object[]> queryForPageItems(int begin, int pageSize,int cid);

    public int updateQresult(int id,int qresult);

    public int deleteAll(int cid);

    public Integer queryForPageTotalCount(int cid);
}
