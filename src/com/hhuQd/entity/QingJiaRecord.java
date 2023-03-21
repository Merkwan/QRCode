package com.hhuQd.entity;

import java.util.List;

public class QingJiaRecord {
    int qid,qresult;
    String sno,qdate,qreason,sname;

    public QingJiaRecord() {
    }

    public QingJiaRecord(int qid, String sno, String qdate, int qresult, String qreason,String sname) {
        this.qid = qid;
        this.sno = sno;
        this.qdate = qdate;
        this.qresult = qresult;
        this.qreason = qreason;
        this.sname=sname;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getQdate() {
        return qdate;
    }

    public void setQdate(String qdate) {
        this.qdate = qdate;
    }

    public int getQresult() {
        return qresult;
    }

    public void setQresult(int qresult) {
        this.qresult = qresult;
    }

    public String getQreason() {
        return qreason;
    }

    public void setQreason(String qreason) {
        this.qreason = qreason;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


    @Override
    public String toString() {
        return "QingJiaTable{" +
                "qid=" + qid +
                ", sno='" + sno + '\'' +
                ", qdate='" + qdate + '\'' +
                ", qresult='" + qresult + '\'' +
                ", qreason='" + qreason + '\'' +
                ", sname='" + sname + '\''+
                '}';
    }
}
