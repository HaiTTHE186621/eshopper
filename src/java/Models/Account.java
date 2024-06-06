/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Account {
    int uid;
    String username;
    String password;
    int roleid;

    public Account() {
    }

    public Account(int uid, String username, String password, int roleid) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.roleid = roleid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Account{" + "uid=" + uid + ", username=" + username + ", password=" + password + ", roleid=" + roleid + '}';
    }
    
    
    
}
