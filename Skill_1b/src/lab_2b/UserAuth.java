package lab_2b;

public class UserAuth {


 private static UserAuth instance;

 private boolean isAuthenticated;

 private UserAuth() {
     this.isAuthenticated = false;
 }

 public static synchronized UserAuth getInstance() {
     if (instance == null) {
         instance = new UserAuth();
     }
     return instance;
 }

 public void authenticateUser(String username, String password) {
     this.isAuthenticated = "user".equals(username) && "pass".equals(password);
     System.out.println(this.isAuthenticated ? "User authenticated." : "Authentication failed.");
 }

 public boolean isAuthenticated() {
     return isAuthenticated;
 }

 public void logout() {
     this.isAuthenticated = false;
     System.out.println("User logged out.");
 }
}

