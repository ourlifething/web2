package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductLogic {
	public void execute(Product product, List<Product> data) {
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateTime = sdf.format(today);
		product.setDateTime(dateTime);
		data.add(0,product);
	}

}
