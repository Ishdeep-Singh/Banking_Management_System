
public class Validation {
	public boolean passwordValidate(String password) {
		if(password.matches("[A-Za-z]{3,15}[0-9]{1,}[.@#!$%&*]{1,}")) {
			return true;
		}
			
		return false;
	}
	public boolean nameValidate(String name) {
		if(name.matches("[A-Za-z ]{1,30}")) {
			return true;
		}
		return false;
	}
}