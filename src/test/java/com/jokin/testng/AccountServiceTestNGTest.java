/**
 * 
 */
package com.jokin.testng;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import AccountService.Account;
import AccountService.AccountService;

/**
 * @author lenovo
 *
 */

@ContextConfiguration("Spring-config.xml") 
//给该方法添加事物管理功能
@Transactional
@ActiveProfiles("test") 
//新建的测试类继承AbstractTransactionalTestNGSpringContextTests是使用Spring的测试的关键
public class AccountServiceTestNGTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired 
    //@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性, 这样就不用用户主动去new对象了
    private AccountService service; 
    
    @org.testng.annotations.Test 
    public void testGetAcccountById() { 
        Account acct = Account.getAccount(1, "user01", 18, "M"); 
        service.insertIfNotExist(acct); 
        Account acct2 = service.getAccountById(1); 
        System.out.println("我执行到这里！！！");
        assertEquals(acct,acct2); 
    } 
}
