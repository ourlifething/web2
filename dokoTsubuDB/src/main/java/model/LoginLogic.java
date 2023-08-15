package model;

public class LoginLogic {
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) {
			System.out.println("ログ:Loginlogic"+"ok");
			return true;
		}
		return false;
	}

}
