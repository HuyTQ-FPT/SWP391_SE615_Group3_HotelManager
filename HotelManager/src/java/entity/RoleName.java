
package entity;

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
