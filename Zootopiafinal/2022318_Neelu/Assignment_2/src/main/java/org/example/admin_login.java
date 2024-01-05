package org.example;

import java.util.HashMap;
import java.util.Map;

public class admin_login {
    static String username;
    static String user_password;

    private static final String usernames="admin";
    private static final String user_passwords="admin123";

    public admin_login(String username,String password) {
        this.username = username;
        this.user_password=password;
    }

    public static boolean Login_check(){
        if(usernames.equals(username) && user_passwords.equals(user_password)){
            return true;
        }
        else{
            return false;
        }
    }



}
