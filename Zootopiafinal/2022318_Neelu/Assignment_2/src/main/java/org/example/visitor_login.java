package org.example;
import java.util.Map;


import static org.example.zoo.dictionary_members;

public class visitor_login {
    private  String email;
    private  String password;

    public visitor_login(String email,String password) {
        this.email = email;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static boolean login_check(String email_1, String password_1) {
        for (Map.Entry<Integer, Register_visitor> entry : dictionary_members.entrySet()) {
            Register_visitor visitor = entry.getValue();
            if (visitor.getEmail().equals(email_1) && visitor.getPassword().equals(password_1)) {
                int visitorID = entry.getKey(); // Get the visitor ID (key)
                System.out.println("Your visitor_id is: " + visitorID);
                return true;
            }
        }
        return false;
    }


}
