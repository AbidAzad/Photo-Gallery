package util;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class that holds all the attributes of a Album.
 * @author DiegoCastellanos dac392
 * @author AbidAzad aa2177
 */
public class Album implements Serializable{
	/**
	 *	title
	 */
	private String title;
	/**
	 *	ArrayList of photos
	 */
	private ArrayList<Photo> photos;


/**
 * Initializes the album.
 * @param title String value for the title of album.
 * @author AbidAzad aa2177
 */
	public Album(String title) {
		this.title = title;
//		this.dateRange = "N/A";
		this.photos = new ArrayList<Photo>();
	}
	/**
	 * Returns the title of album
	 * @author AbidAzad aa2177
	 * @return String
	 */	
	public String getName() {
		return title;
	}
	/**
	 * Renames the album.
	 * @param newName String value for the new title of album.
	 * @author AbidAzad aa2177
	 */	
	public void setName(String newName) {
		title = newName;
	}
	/**
	 * Adds to the list of photos the album holds.
	 * @param title String value for the title of photo.
	 * @param caption String value for the caption of photo.
	 * @param date String value for the date of photo.
	 * @param tags String value for the filePath of photo.
	 * @param filePath String value of absolute path for a given image
	 * @author AbidAzad aa2177
	 *
	 */		
	public void addPhoto(String title, String caption, Date date, ArrayList<Tag> tags, String filePath) {
		Photo addition = new Photo(title, caption, date, tags, filePath);
		photos.add(addition);
	}
	/**
	 *	get the ArrayList of Photos that live within a given album
	 *	@return ArrayList array list of photos
	 *	@author diegocastellanos
	 */
	public ArrayList<Photo> getPhotos(){
		return photos;
	}
	/**
	 * Returns the number of photos an album holds
	 * @author AbidAzad aa2177
	 * @return int
	 */	
	public int getPhotoCount(){
		return photos.size();
	}
	/**
	 * Returns the range from earliest to latest for an album's given images.
	 * @author diegocastellanos
	 * @return String
	 */
	public String getDateRange() {
		if(photos.isEmpty())
			return "N/A";
		
		Date earliest = null;
		Date latest = null;
		for(Photo photo : photos) {
			if(earliest == null) 
				earliest = photo.getDate();
			if(latest == null)
				latest = photo.getDate();
			
			if(earliest.compareTo(photo.getDate()) > 0)
				earliest = photo.getDate();
			if(latest.compareTo(photo.getDate()) < 0)
				latest = photo.getDate();
		}
		if(earliest.equals(latest))
			return getDisplayDate(earliest);
		String first = getDisplayDate(earliest);
		String last = getDisplayDate(latest);
		String dateRange = first+" - "+last;
		return dateRange;
	}
	
	/**
	 *	helper method to displays the album's data in a yyyy/mm/dd format which is just nicer to look at
	 *	@param d method still needs to be given a Date object though. 
	 *	@return String
	 */
	private String getDisplayDate(Date d) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		return format1.format(d);
	}
	
	/**
	 *	checks if an image lives within a given album
	 *	@param filepath the String filepath of the image in questions
	 *	@return boolean
	 *	@author diegocastellanos 
	 */
	public boolean containsImage(String filepath) {
		for(Photo photo : photos) {
			if(photo.getFilePath().equals(filepath))
				return true;
		}
		return false;
	}
}
