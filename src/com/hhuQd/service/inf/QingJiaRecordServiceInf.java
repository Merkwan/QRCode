package com.hhuQd.service.inf;

import com.hhuQd.entity.Page;
import com.hhuQd.entity.QingJiaRecord;


public interface QingJiaRecordServiceInf {
    public Page<QingJiaRecord> page(int pageNo, int pageSize,String cid);

    public int  isAgreeeQingJia(int id,int qresult);

    public boolean deleteAll(String cid);

    int queryCount(int cid);
}
