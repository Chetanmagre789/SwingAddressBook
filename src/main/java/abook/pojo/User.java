package abook.pojo;

/**
*
* @author Pankaj Sharma
*/
public class User extends Person{
    private int userId;
  
    private String loginName;
    private String password;
   
   

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
