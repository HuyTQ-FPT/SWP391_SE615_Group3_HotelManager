package dao.impl;

import entity.User;
import java.sql.Date;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Minh Hiếu
 */
public class ReceptionistDAOImplTest {

    public ReceptionistDAOImplTest() {
    }

    /**
     * Test of getCustomerListByReceptionist method, of class
     * ReceptionistDAOImpl.
     */
    @Test
    public void testGetCustomerListByReceptionist() throws Exception {
        System.out.println("getCustomerListByReceptionist");
        ReceptionistDAOImpl instance = new ReceptionistDAOImpl();
        Vector<User> expResult = null;
        Vector<User> result = instance.getCustomerListByReceptionist();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of updateCustomerByReceptionist method, of class
     * ReceptionistDAOImpl.
     */
    @Test
    public void testUpdateCustomerByReceptionist() {
        System.out.println("updateCustomerByReceptionist");
        User User = null;
        ReceptionistDAOImpl instance = new ReceptionistDAOImpl();
        instance.updateCustomerByReceptionist(User);

    }

    /**
     * Test of getReceptionist method, of class ReceptionistDAOImpl.
     */
    @Test
    public void testGetReceptionist() {
        System.out.println("getReceptionist");
        int uid = 7;
        ReceptionistDAOImpl instance = new ReceptionistDAOImpl();
  
        User expResult = new User(7, 7, "Martynne", "4482170929", "tplacido6@gmail.com", 1, Date.valueOf("2001/06/12"), "Chive Park", "658 322 9770", "user7.jpg");
        User result = instance.getReceptionist(uid);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getSearchNameCustomerListByReceptionist method, of class
     * ReceptionistDAOImpl.
     */
    @Test
    public void testGetSearchNameCustomerListByReceptionist() throws Exception {
        System.out.println("getSearchNameCustomerListByReceptionist");
        String uName = "";
        ReceptionistDAOImpl instance = new ReceptionistDAOImpl();
        Vector<User> expResult = null;
        Vector<User> result = instance.getSearchNameCustomerListByReceptionist(uName);
        assertNotEquals(expResult, result);

    }

}
