package model;

public class UserDTO {
	 private String userId;
     private String userPassword;
     private String userName;
     
     public UserDTO(String userId, String userPassword, String userName) {
    	 this.userId = userId;
    	 this.userPassword = userPassword;
    	 this.userName = userName;
     }
     
     public String getUserId() {
    	 return userId;
     }
}
