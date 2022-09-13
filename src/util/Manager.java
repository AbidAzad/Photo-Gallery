package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *  Helper class carrying static variables commonly used amongst different classes 
 *  @author diegocastellanos
 */
public class Manager {
	/**
	 * 	used to get the current time and sends back a Date object
	 *	@return Date 
	 *	@author diegocastellanos
	 */
	public static Date getTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND,0);
		return cal.getTime();
	}
	
	/**
	 *	@param title String title of the alert
	 *	@param header String of the alert
	 *	@param content String message for the alert
	 *	@author diegocastellanos
	 */
    public static void showAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
		
    }
}
