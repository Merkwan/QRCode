package com.hhuQd.test;

import com.hhuQd.dao.ManagerDao;
import com.hhuQd.entity.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerDaoTest {
    ManagerDao managerDao=new ManagerDao();
    Manager manager=new Manager(5,"18955653215","123456","张三");
    @Test
    public void existPhone() {
        System.out.println(managerDao.existPhone(manager.getMphone()));
    }

    @Test
    public void getPassByPhoneNo() {
        System.out.println(managerDao.getPassByPhoneNo(manager.getMphone()));
    }

    @Test
    public void repass() {
       managerDao.repass(manager.getMphone(),manager.getMpass());
    }
}