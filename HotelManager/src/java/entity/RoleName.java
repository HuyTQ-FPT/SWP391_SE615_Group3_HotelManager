/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class RoleName {
    private int RoleID ;
	private String RoleName ;

    public RoleName() {
    }

    public RoleName(int RoleID, String RoleName) {
        this.RoleID = RoleID;
        this.RoleName = RoleName;
    }

    @Override
    public String toString() {
        return "RoleName{" + "RoleID=" + RoleID + ", RoleName=" + RoleName + '}';
    }
        
}
