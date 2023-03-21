package com.hhuQd.service.inf;

import com.hhuQd.entity.Page;
import com.hhuQd.entity.QdRecord;

public interface QdRecordServiceInf {

    public boolean publish_sign(String cid,String endtime);

    //public int changeSign(int flag,String sno);

    public int isSign(String weixinnick,String qdate,String qrtime);

    Page<QdRecord> page(int pageNo, int pageSize, int result,String cid);

    public boolean deleteAll(int result,String cid);

    int queryCount(int qdstate,int cid);
}
