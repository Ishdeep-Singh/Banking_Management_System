import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class Validation {
	public boolean passwordValidate(String password) {
		if(password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#!$%&*])[a-zA-Z0-9.@#!$%&*]{7,15}")) {
		//if(password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}")) {
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
	
	public boolean dobValidate(String date) {
		LocalDate todayDate = LocalDate.now();
		System.out.println(todayDate);
		System.out.println(date);
		LocalDate oldDate = null ;
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
			oldDate = LocalDate.parse(date, formatter);
			oldDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.println(oldDate);
		} catch (DateTimeParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Period p= Period.between(todayDate, oldDate);
		int years = Math.abs(p.getYears());
		System.out.println(years);
		if(years >= 18) {
			return true;
		}
		
		return false;
	}
	
	public boolean mobileValidate(String num) {
		if(num.matches("[0-9]{10}")) {
			return true;
		}
		return false;
	}
}