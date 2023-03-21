package com.hhuQd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompare {
        public String qdate,qrtime;
    public int compareResult(String endtime) throws ParseException {
        Date date=new Date();
        SimpleDateFormat timeformat1=new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat timeformat2=new SimpleDateFormat("yyyy-MM-dd");
        qdate=timeformat2.format(date);
        qrtime=timeformat1.format(date);
        Date date1=timeformat1.parse(qrtime);
        Date date2=timeformat1.parse(endtime);
        return date1.compareTo(date2);
    }
}
