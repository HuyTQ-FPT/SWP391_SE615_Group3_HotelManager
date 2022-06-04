/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Entity.Account;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class AccountDAOImplTest {
    
    public AccountDAOImplTest() {
    }

    /**
     * Test of checkAccount method, of class AccountDAOImpl.
     */
    @Test
    public void testCheckAccount() {
        System.out.println("checkAccount");
        String aName = "";
        AccountDAOImpl instance = new AccountDAOImpl();
        String expResult = null;
        Account result = instance.checkAccount(aName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckAccount1() {
        System.out.println("checkAccount1");
        String aName = "123";
        AccountDAOImpl instance = new AccountDAOImpl();
        String expResult = null;
        Account result = instance.checkAccount(aName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckAccount2() {
        System.out.println("checkAccount2");
        String aName = "shjerih2";
        AccountDAOImpl instance = new AccountDAOImpl();
        String expResult = null;
        Account result = instance.checkAccount(aName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckAccount3() {
        System.out.println("checkAccount3");
        String aName = "shjerih253463463434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434343434";
        AccountDAOImpl instance = new AccountDAOImpl();
        String expResult = null;
        Account result = instance.checkAccount(aName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckAccount4() {
        System.out.println("checkAccount4");
        String aName = "user1";
        AccountDAOImpl instance = new AccountDAOImpl();
        String expResult = "user1";
        Account result = instance.checkAccount(aName);
        assertEquals(expResult, result.getUser());
    }
//=================================================================================================////////////////////////

//    @Test
//    public void testRegister() {
//        System.out.println("Register");
//        Account ac = new Account(1, "Hieu", "Jisoo");
//        String name = "";
//        String email = "";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        int expResult = 1;
//        int result = instance.Register(ac, name, email);
//        assertEquals(expResult, result);
//     
//    }
//    @Test
//    public void testRegister1() {
//        System.out.println("Register1");
//        Account ac = null;
//        String name = "";
//        String email = "";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        int expResult = 0;
//        int result = instance.Register(ac, name, email);
//        assertEquals(expResult, result);
//     
//    }
//    @Test
//    public void testRegister5() {
//        System.out.println("Register1");
//        Account ac = null;
//        String name = "123";
//        String email = "hieu@gmail.com";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        int expResult = 0;
//        int result = instance.Register(ac, name, email);
//        assertEquals(expResult, result);
//     
//    }
//    @Test
//    public void testRegister2() {
//        System.out.println("Register2");
//        Account ac = new Account(1, "", "");
//        String name = "";
//        String email = "";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        int expResult = 1;
//        int result = instance.Register(ac, name, email);
//        assertEquals(expResult, result);
//     
//    }
//  
//    @Test
//    public void testRegister3() {
//        System.out.println("Register4");
//        Account ac = new Account(1, "SWPFroup3", "hieu");
//        String name = "Hieu";
//        String email = "hieulbmhe151429@fpr.edu.vn";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        int expResult = 1;
//        int result = instance.Register(ac, name, email);
//        assertEquals(expResult, result);
//     
//    }
    /**
     * Test of getAccountList method, of class AccountDAOImpl.
     */
//    @Test
//    public void testGetAccountList() {
//        System.out.println("getAccountList");
//        int aID = 0;
//        AccountDAOImpl instance = new AccountDAOImpl();
//        Vector<Account> expResult = null;
//        Vector<Account> result = instance.getAccountList(aID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getAccount method, of class AccountDAOImpl.
     */
    @Test
    public void testGetAccount() {
        System.out.println("getAccount");
        String aName = "";
        String aPass = "";
        AccountDAOImpl instance = new AccountDAOImpl();
        Account expResult = null;
        Account result = instance.getAccount(aName, aPass);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetAccount3() {
        System.out.println("getAccount3");
        String aName = "user2";
        String aPass = "";
        AccountDAOImpl instance = new AccountDAOImpl();
        Account expResult = null;
        Account result = instance.getAccount(aName, aPass);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetAccount1() {
        System.out.println("getAccount1");
        String aName = "";
        String aPass = "12345678";
        AccountDAOImpl instance = new AccountDAOImpl();
        Account expResult = null;
        Account result = instance.getAccount(aName, aPass);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetAccount2() {
        System.out.println("getAccount2");
        String aName = null;
        String aPass = null;
        AccountDAOImpl instance = new AccountDAOImpl();
        
        Account expResult = null;
        Account result = instance.getAccount(aName, aPass);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testGetAccount4() {
        System.out.println("getAccount4");
        String aName = "user1";
        String aPass = "12345678";
        AccountDAOImpl instance = new AccountDAOImpl();
        
        Account expResult = instance.checkAccount(aName);
        Account result = instance.getAccount(aName, aPass);
        assertEquals(expResult.getUser(), result.getUser());
        
    }

    /**
     * Test of insertAccount method, of class AccountDAOImpl.
     */
//    @Test
//    public void testInsertAccount() {
//        System.out.println("insertAccount");
//        int aRole = 0;
//        String aName = "";
//        String aPass = "";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        instance.insertAccount(aRole, aName, aPass);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of updateAccount method, of class AccountDAOImpl.
     */
//    @Test
//    public void testUpdateAccount() {
//        System.out.println("updateAccount");
//        String aUser = "";
//        String aPassword = "";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        int expResult = 0;
//        int result = instance.updateAccount(aUser, aPassword);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
    @Test
    public void testUpdateAccount5() {
        System.out.println("updateAccount5");
        String aUser = null;
        String aPassword = null;
        AccountDAOImpl instance = new AccountDAOImpl();
        int expResult = 0;
        int result = instance.updateAccount(aUser, aPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void testUpdateAccount1() {
        System.out.println("updateAccount1");
        String aUser = "123";
        String aPassword = "group";
        AccountDAOImpl instance = new AccountDAOImpl();
        int expResult = 0;
        int result = instance.updateAccount(aUser, aPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void testUpdateAccount2() {
        System.out.println("updateAccount2");
        String aUser = "heiu123";
        String aPassword = "123";
        AccountDAOImpl instance = new AccountDAOImpl();
        int expResult = 0;
        int result = instance.updateAccount(aUser, aPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void testUpdateAccount3() {
        System.out.println("updateAccount3");
        String aUser = "user1";
        String aPassword = "12345678";
        AccountDAOImpl instance = new AccountDAOImpl();
        int expResult = 1;
        int result = instance.updateAccount(aUser, aPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of deleteAccount method, of class AccountDAOImpl.
     */
//    @Test
//    public void testDeleteAccount() {
//        System.out.println("deleteAccount");
//        String aName = "";
//        AccountDAOImpl instance = new AccountDAOImpl();
//        instance.deleteAccount(aName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getAccountByRole method, of class AccountDAOImpl.
     */
//    @Test
//    public void testGetAccountByRole() {
//        System.out.println("getAccountByRole");
//        int aRole = 0;
//        AccountDAOImpl instance = new AccountDAOImpl();
//        Vector<Account> expResult = null;
//        Vector<Account> result = instance.getAccountByRole(aRole);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
