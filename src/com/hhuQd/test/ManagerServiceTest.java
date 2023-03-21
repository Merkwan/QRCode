package com.hhuQd.test;

import com.hhuQd.service.ManagerService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerServiceTest {
    ManagerService managerService=new ManagerService();
    @Test
    public void repass() {
        managerService.repass("15862314569","123456","123456");
    }

    @Test
    public void login() {
        managerService.login("15862314569","123456");
    }
}