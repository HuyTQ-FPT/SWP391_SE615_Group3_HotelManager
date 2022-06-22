/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.User;
import java.sql.Date;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class UserDAOImplTest {

    public UserDAOImplTest() {
    }

    /**
     * Test of updateUser method, of class UserDAOImpl.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        User User = new User(1, 1, "hieu", "123456789", "SWP391@gmail.com", 1, Date.valueOf("06/12/2001"), "Hai Duong", "032001002500", "user1.jpg");

        UserDAOImpl instance = new UserDAOImpl();
        int expResult = 1;
        int result = instance.updateUser(User);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of updateUserEcept method, of class UserDAOImpl.
     */
    @Test
    public void testUpdateUserEcept() throws Exception {
        System.out.println("updateUserEcept");
        User User = new User(1, 1, "hieu", "123456789", "SWP391@gmail.com", 1, Date.valueOf("06/12/2001"), "Hai Duong", "032001002500", "user1.jpg");

        UserDAOImpl instance = new UserDAOImpl();
        instance.updateUserEcept(User);

    }

    /**
     * Test of checkUser method, of class UserDAOImpl.
     */
    @Test
    public void testCheckUser() throws Exception {
        System.out.println("checkUser");
        String uGmail = "SWP391@gmail.com";
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.checkUser(uGmail);
        assertNotEquals(expResult, result);

    }

}
