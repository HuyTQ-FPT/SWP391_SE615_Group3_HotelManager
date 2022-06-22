
package dao.impl;

import entity.Account;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Minh Hiếu
 */
public class AccountDAOImplTest {

    public AccountDAOImplTest() {
    }

   

    /**
     * Test of getAccount method, of class AccountDAOImpl.
     */
    @Test
    public void testGetAccount() throws Exception {
        System.out.println("getAccount");
        String aName = "user1";
        String aPass = "12345678";
        Account ac = new Account(1, 1, aName, aPass);
        AccountDAOImpl instance = new AccountDAOImpl();
        Account expResult = ac;
        Account result = instance.getAccount(aName, aPass);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of updateAccount method, of class AccountDAOImpl.
     */
    @Test
    public void testUpdateAccount() throws Exception {
        System.out.println("updateAccount");
        String aUser = "";
        String aPassword = "";
        AccountDAOImpl instance = new AccountDAOImpl();
        int expResult = 0;
        int result = instance.updateAccount(aUser, aPassword);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkAccount method, of class AccountDAOImpl.
     */
    @Test
    public void testCheckAccount() throws Exception {
        System.out.println("checkAccount");
        String aName = null;
        AccountDAOImpl instance = new AccountDAOImpl();
        Account expResult = null;
        Account result = instance.checkAccount(aName);
        assertEquals(expResult, result);

    }


    /**
     * Test of Register method, of class AccountDAOImpl.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("Register");
        Account ac = new Account(10, "hieu", "hieu");
        String name = "ok";
        String email = "ok@gmail.com";
        AccountDAOImpl instance = new AccountDAOImpl();
        int expResult = 1;
        int result = instance.Register(ac, name, email);
        assertEquals(expResult, result);

    }

}
