package model;

public class LoginLogic {
	public boolean login(LoginJB login) {
		if(login.getPass().equals("1234")) {
			return true;
		}
		return false;
	}

}
