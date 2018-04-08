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
public class AccountServiceTestNGTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired 
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
