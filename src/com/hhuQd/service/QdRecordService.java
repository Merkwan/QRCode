package com.hhuQd.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import com.hhuQd.dao.QdRecordDao;

import com.hhuQd.dao.StudentDao;
import com.hhuQd.entity.Page;
import com.hhuQd.entity.QdRecord;

import com.hhuQd.entity.Student;
import com.hhuQd.service.inf.QdRecordServiceInf;

public class QdRecordService implements QdRecordServiceInf {
	private QdRecordDao qddao = new QdRecordDao();
	private StudentDao sdao = new StudentDao();
	
//	public void saveRecord(QdRecord q, int cid) {
//
//		// 进行一系列的校验逻辑
//
//		// 这个学生是否存在
//		String sno = q.getSno();
//
//		Student dbs = sdao.queryBySNO(sno);
//		if (dbs == null) {// 根据学生的编号找不到学生
//			throw new RuntimeException("学生信息不存在");
//		}
//
//		// 学生是否属于当前考勤的班级
//		// 学生的班级数据 == 当前考勤的班级的编号
//		int dbcid = dbs.getCid();// 通过学生编号获取到的学生在数据库中的 归属班级编号
//		if (dbcid != cid) {
//			throw new RuntimeException("此学生不属于当前签到班级");
//		}
//
//		// 【
//		// 只可以签到一次【当前签到时间 > 今天最后一次签到时间 两个小时】
//		// 】
//
//		boolean result = qddao.getQDData(q.getSno(), q.getQdate(), q
//				.getLinetime());
//		if (result == true) {
//			throw new RuntimeException("当堂课已成功签到,请勿重复签到");
//		}
//
//		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
//		SimpleDateFormat f2 = new SimpleDateFormat("HH:mm:ss");
//
//		q.setQdate(f1.format(new Date()));
//		q.setQtime(f2.format(new Date()));
//		q.setLinetime(q.getLinetime());
//
//		qddao.saveRecord(q);
//
//	}
	
	public List<QdRecord> queryStudentQDRecord(int stuno) {
		return qddao.queryStudentQDRecord(stuno);
	}
	
	public List<Object[]> queryDataBycid(String teacherId) {
		
		return qddao.queryDataByteacherId(teacherId);
		
	}

	@Override
	public boolean publish_sign(String cid,String endtime) {
		//获取当前日期
		Date date=new Date();
		//System.out.println(date);
		SimpleDateFormat yearMonDay=new SimpleDateFormat("yyyy-MM-dd");
		String qdate=yearMonDay.format(date);
		if(qddao.isPost(qdate)>0)
			return true;
		//QdRecordDao1 QdRecordDao=new QdRecordDaoImpl();
		StudentDao studentDao=new StudentDao();
		List<Student> snolist=studentDao.querySno(Integer.parseInt(cid));
		Object[] snos=new Object[snolist.size()];
		Object[] snames=new Object[snolist.size()];
		Object[] qdates=new Object[snos.length];
		Object[] qtimes=new Object[snos.length];
		Object[] endtimes=new Object[snos.length];
		for(int i=0;i<snos.length;i++){
			snos[i]=snolist.get(i).getSno();
			snames[i]=snolist.get(i).getSname();
			qdates[i]=qdate;
			qtimes[i]="00:00:00";
			endtimes[i]=endtime+":59";
		}
		int k=qddao.creat_signinfo(snos,snames,qdates,qtimes,endtimes);
		if (k>=0){
			return true;
		}
		else return false;
	}

	/*
	 * 查询是否签到并更新签到
	 *
	 * */
	@Override
	public int isSign(String weixinnick,String qdate,String qrtime){
		QdRecord qdRecord=new QdRecord();
		String sno=qddao.selectSno(weixinnick);
		qdRecord.setSno(sno);
		if(qdRecord.getSno()==null){
			return 1;
		}
		else {
			qdRecord.setQdstate(Integer.parseInt(qddao.isSign(sno,qdate)));
			if (qdRecord.getQdstate() == 1) {
				return 2;
			} else {
				qddao.changeSign(1, qdRecord.getSno(), qdate,qrtime);
				return 3;
			}
		}
	}

	@Override
	public Page<QdRecord> page(int pageNo, int pageSize, int resultnum,String cid) {
		Page<QdRecord> page = new Page<QdRecord>();
		String[] st={"未签到","已签到"};
		// 设置每页显示的数量
		page.setPageSize(pageSize);
		//设置是否签到
		page.setResult(st[resultnum]);
		// 求总记录数
		Object object1=qddao.queryForPageTotalCount(resultnum,Integer.parseInt(cid));
		Integer pageTotalCount=0;
		if(object1!=null)
			pageTotalCount =Integer.parseInt(object1.toString());
		// 设置总记录数
		page.setPageTotalCount(pageTotalCount);
		// 求总页码
		Integer pageTotal = pageTotalCount / pageSize;
		if (pageTotalCount % pageSize > 0) {
			pageTotal+=1;
		}
		// 设置总页码
		page.setPageTotal(pageTotal);

		// 设置当前页码
		page.setPageNo(pageNo);

		// 求当前页数据的开始索引
		int begin = (page.getPageNo() - 1) * pageSize;
		// 求当前页数据
		//List<QdRecord> items = qddao.queryForPageItems(begin,pageSize,resultnum,Integer.parseInt(cid));
		List<Object[]> objectss = qddao.queryForPageItems(begin,pageSize,resultnum,Integer.parseInt(cid));
		// 设置当前页数据
		List<QdRecord> items =new LinkedList<QdRecord>();
		for (int i=0;i<objectss.size();i++)
		{
			QdRecord qdRecord=new QdRecord();
			Object[] objects=objectss.get(i);
			qdRecord.setSno(objects[0].toString());
			qdRecord.setSname(objects[1].toString());
			qdRecord.setQdate(objects[2].toString());
			qdRecord.setQtime(objects[3].toString());
			qdRecord.setQdstate(Integer.parseInt(objects[4].toString()));
			items.add(qdRecord);
			//System.out.println(qingJiaRecord);
		}

		// 设置当前页数据
		page.setItems(items);

		return page;
	}

	@Override
	public boolean deleteAll(int state,String cid) {
		if (qddao.deleteAll(state,Integer.parseInt(cid))>=0)
			return true;
		else return false;
	}

	@Override
	public int queryCount(int qdstate, int cid) {
		return Integer.parseInt(qddao.queryForPageTotalCount(qdstate,cid).toString());
	}
}
