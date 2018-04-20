package abook.service;

import abook.db.JDBCUtil;
import abook.pojo.Friend;
import abook.pojo.User;
import java.sql.ResultSet;
import java.util.Vector;

/**
*
* @author Pankaj Sharma
*/
public class ABService {

    JDBCUtil jdbcu = new JDBCUtil();

    public User authanticateUser(String loginName, String password) throws Exception {
        String sql = "select userId,name from user where loginName='" + loginName + "' and password='" + password + "'";
        System.out.println(sql);
        ResultSet rs = jdbcu.select(sql);
        if (rs.next()) {
            int userId = rs.getInt("userId");
            String name = rs.getString("name");
            //String name=rs.getString(2);
            User u = new User();
            u.setUserId(userId);
            u.setName(name);

            return u;
        } else {
            throw new Exception("Please provide valid login name and password");
        }
    }
    //in a profession app this code goes inside DAO layer

    public void registerUser(User u) {
        String sql = "insert into user(name,loginName,password,address,phone) values('" + u.getName() + "','" + u.getLoginName() + "','" + u.getPassword() + "','" + u.getAddress() + "','" + u.getPhone() + "')";
        System.out.println(sql);
        jdbcu.update(sql);
    }

    public Vector<Vector> getAllFriends(int userId) throws Exception {
        String sql = "select friendId, name, address, phone, email from friend where userId=" + userId;
        ResultSet rs = jdbcu.select(sql);

        Vector<Vector> data = new Vector<Vector>();

        while (rs.next()) {
            Vector row = new Vector();
            row.add(false);//check box
            row.add(rs.getInt("friendId"));
            row.add(rs.getString("name"));
            row.add(rs.getString("phone"));
            row.add(rs.getString("email"));
            row.add(rs.getString("address"));
            data.add(row);
        }
        return data;
    }

    public void deleteFriend(Integer fid) {
        String sql = "delete from friend where friendId=" + fid;
        System.out.println(sql);
        jdbcu.update(sql);//DML
    }

    public void saveNewFriend(Friend f) {
        String sql = "insert into friend(userId, name,phone,email,address) values(" + f.getUserId() + ",'" + f.getName() + "','" + f.getPhone() + "','" + f.getEmail() + "','" + f.getAddress() + "')";
        jdbcu.update(sql);
    }

    public Friend getFriendById(int friendId) throws Exception {
        String sql = "select friendId, name, address, phone, email from friend where friendId=" + friendId;
        ResultSet rs = jdbcu.select(sql);
        if (rs.next()) {
            Friend f = new Friend();
            f.setFriendId(rs.getInt("friendId"));
            f.setName(rs.getString("name"));
            f.setPhone(rs.getString("phone"));
            f.setEmail(rs.getString("email"));
            f.setAddress(rs.getString("address"));
            return f;
        } else {
            return null;
        }
    }

    public Vector<Vector> search(String key,int userId) throws Exception{
        String sql = "select friendId, name, address, phone, email from friend where userId=" + userId+" and (name like('%"+key+"%') or phone like('%"+key+"%'))";
        ResultSet rs = jdbcu.select(sql);

        Vector<Vector> data = new Vector<Vector>();

        while (rs.next()) {
            Vector row = new Vector();
            row.add(false);//check box
            row.add(rs.getInt("friendId"));
            row.add(rs.getString("name"));
            row.add(rs.getString("phone"));
            row.add(rs.getString("email"));
            row.add(rs.getString("address"));
            data.add(row);
        }
        return data;
    }
}
