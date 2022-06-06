/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Blog;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface BlogDAO {
    public Blog getBlogList(int bID);
    public void insertBlog(int aID, Blog newBlog);
    public void updateBlog(int bID, Blog updateBlog);
    public void deleteBlog(int bID);
    public Vector<Blog> getBlog(String sql);
     public int getPage();
      public Vector<Blog> getBlogByPage(int n);
}
