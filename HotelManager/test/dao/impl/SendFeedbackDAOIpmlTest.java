
package dao.impl;

import entity.sendFeedback;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Minh Hiếu
 */
public class SendFeedbackDAOIpmlTest {
    
    public SendFeedbackDAOIpmlTest() {
    }

    /**
     * Test of getMessage method, of class SendFeedbackDAOIpml.
     */
    @Test
    public void testGetMessage() throws Exception {
        System.out.println("getMessage");
        SendFeedbackDAOIpml instance = new SendFeedbackDAOIpml();
        Vector<sendFeedback> expResult = null;
        Vector<sendFeedback> result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class SendFeedbackDAOIpml.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        sendFeedback message = null;
        SendFeedbackDAOIpml instance = new SendFeedbackDAOIpml();
        instance.insert(message);
        
    }

    /**
     * Test of updateRead method, of class SendFeedbackDAOIpml.
     */
    @Test
    public void testUpdateRead() throws Exception {
        System.out.println("updateRead");
        int id = 20;
        String isread = "0";
        SendFeedbackDAOIpml instance = new SendFeedbackDAOIpml();
        int expResult = 0;
        int result = instance.updateRead(id, isread);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getMessageById method, of class SendFeedbackDAOIpml.
     */
    @Test
    public void testGetMessageById() throws Exception {
        System.out.println("getMessageById");
        int Id = 3;
        SendFeedbackDAOIpml instance = new SendFeedbackDAOIpml();
        sendFeedback expResult = null;
        sendFeedback result = instance.getMessageById(Id);
        assertNotEquals(expResult, result);
    
    }


   

    /**
     * Test of searchName method, of class SendFeedbackDAOIpml.
     */
    @Test
    public void testSearchName() throws Exception {
        System.out.println("searchName");
        int index = 0;
        String title = "SWp";
        SendFeedbackDAOIpml instance = new SendFeedbackDAOIpml();
        Vector<sendFeedback> expResult = null;
        Vector<sendFeedback> result = instance.searchName(index, title);
        assertEquals(expResult, result);

    }

  
    /**
     * Test of getMessageOfTitle method, of class SendFeedbackDAOIpml.
     */
    @Test
    public void testGetMessageOfTitle() throws Exception {
        System.out.println("getMessageOfTitle");
        String title = "okla";
        SendFeedbackDAOIpml instance = new SendFeedbackDAOIpml();
        Vector<sendFeedback> expResult = null;
        Vector<sendFeedback> result = instance.getMessageOfTitle(title);
        assertNotEquals(expResult, result);
      
    }
    
}
