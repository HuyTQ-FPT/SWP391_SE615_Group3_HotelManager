/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Post;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface PostDAO {
    public Vector<Post> getAllPost();
    public void insertPost(int pID,Post insertPost);
    public void updatePost(int pID,Post updatePost);
    public void deletePost(int pID);
}
