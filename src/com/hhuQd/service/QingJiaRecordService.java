package com.hhuQd.service;


import java.util.LinkedList;
import java.util.List;

import com.hhuQd.dao.QingJiaRecordDao;
import com.hhuQd.entity.Page;
import com.hhuQd.entity.QJrecord;
import com.hhuQd.entity.QingJiaRecord;
import com.hhuQd.service.inf.QingJiaRecordServiceInf;

public class QingJiaRecordService implements QingJiaRecordServiceInf {

	
	private QingJiaRecordDao qdao = new QingJiaRecordDao();
	public void save(QJrecord q) {
		qdao.save(q);
	}

	public List<QJrecord> queryStudentQJrecord(int stuno) {
		return qdao.queryStudentQJrecord(stuno);
	}

	@Override
	public Page<QingJiaRecord> page(int pageNo, int pageSize,String cid) {
		Page<QingJiaRecord> page = new Page<QingJiaRecord>();

		// 设置每页显示的数量
		page.setPageSize(pageSize);
		// 求总记录数
		Integer pageTotalCount = qdao.queryForPageTotalCount(Integer.parseInt(cid));
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
		List<Object[]> objectss = qdao.queryForPageItems(begin,pageSize,Integer.parseInt(cid));
		// 设置当前页数据
		List<QingJiaRecord> items =new LinkedList<QingJiaRecord>();
		for (int i=0;i<objectss.size();i++)
		{
			QingJiaRecord qingJiaRecord=new QingJiaRecord();
			Object[] objects=objectss.get(i);
			qingJiaRecord.setQid(Integer.parseInt(objects[0].toString()));
			qingJiaRecord.setSno(objects[1].toString());
			qingJiaRecord.setSname(objects[2].toString());
			qingJiaRecord.setQdate(objects[3].toString());
			qingJiaRecord.setQresult(Integer.parseInt(objects[4].toString()));
			qingJiaRecord.setQreason(objects[5].toString());
			items.add(qingJiaRecord);
			//System.out.println(qingJiaRecord);
		}
		page.setItems(items);
		//System.out.println("items="+items);
		return page;
	}

	@Override
	public int  isAgreeeQingJia(int id,int qresult){
		return qdao.updateQresult(id,qresult);
	}

	@Override
	public boolean deleteAll(String cid) {
		return qdao.deleteAll(Integer.parseInt(cid)) >= 0;
	}

	@Override
	public int queryCount(int cid) {
		return qdao.queryForPageTotalCount(cid);
	}
}
