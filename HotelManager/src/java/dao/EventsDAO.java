/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Events;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface EventsDAO {
     public ArrayList<Events> getEventsList() throws Exception;

    public void insertEvents(Events event) throws Exception;

    public int updateEvents(int id) throws Exception;

    public void deleteEvents(int id) throws Exception;

}
