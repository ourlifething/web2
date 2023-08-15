package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeLogic {
	public String dateTime() {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M");
		String dateTime = sdf.format(today);
		return dateTime;
	}
}
