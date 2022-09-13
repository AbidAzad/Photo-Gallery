package util;

import java.io.*;
import java.util.*;


/**
 * Class that holds all the attributes of a phots
 * @author DiegoCastellanos dac392
 * @author AbidAzad aa2177
 */
public class Photo implements Serializable {
	/**
	 *	ArrayList of tag objects 
	 */
	private ArrayList<Tag> tags;
	/**
	 *	String title of the photo; "unnamed" if not set
	 */
	private String title;
	/**
	 *	String caption of the photo; "unnamed if not set"
	 */
	private String caption;
	/**
	 *	Date date of photo added
	 */
	private Date date;
	/**
	 *	String filePhat, the absolute path of an image
	 */
	private String filePath;

	/**
	 * Method that initializes a photo.
	 * @param title for the title, a String value.
	 * @param caption for the caption, a string value.
	 * @param date for the date, a String value.
	 * @param tags or the filePath of where the image is located, a String Value
	 * @param filePath String path of an image; absolute path
	 * @author AbidAzad aa2177
	 */
	public Photo(String title, String caption, Date date, ArrayList<Tag> tags, String filePath) {
		this.title = title;
		this.caption = caption;
		this.date = date;
		this.filePath = filePath;
		this.tags = tags;
		
	}


	/**
	 * Method that adds to the tags of a photo
	 * @param type for the type of tag, a String value.
	 * @param value for the value of the tag, a string value.
	 * @author AbidAzad aa2177
	 */
	public void addTag(String type, String value) {
		tags.add(new Tag(type, value));
	}
	/**
	 * Method that gets the caption of a photo
	 * @author AbidAzad aa2177
	 * @return String
	 */	
	public String getCaption() {
		return caption;
	}
	/**
	 * Method that set the caption of a photo
	 * @param caption String value of the new caption.
	 * @author AbidAzad aa2177
	 */		
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * Method that gets the date of a photo
	 * @author AbidAzad aa2177
	 * @return Date
	 */	
	public Date getDate() {
		return date;
	}
	/**
	 * Method that gets the filePath of a photo    
	 * @author AbidAzad aa2177
	 * @return String
	 */	
	public String getFilePath() {
		return filePath;
	}
	
	/**
	 * Method that sets the translation of a Photo class to string to be its caption.
	 * @author AbidAzad aa2177
	 * @return String
	 */	
	public String toString() {
		return caption;
	}
	/**
	 * Method that returns the tags associated with a Photo.
	 * @author AbidAzad aa2177
	 * @return ArrayList of tags
	 */		
	public ArrayList<Tag> getTags() {
		return tags;
	}
	
	/**
	 * Method that sets the Tags of a Photo.
	 * @param tags ArrayList of tags; tags of the new tags to be associated with the photo.
	 * @author AbidAzad aa2177
	 */			
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

/*	public String getStringTags() {

		Set<String> keys = this.tags.keySet();
		ArrayList<String> builder = new ArrayList<>();
		if(keys.size() == 0)
			return "*no tags set*";
		for(String id : keys) {
			String value = this.tags.get(id);
			if(value.contains(";")) {
				String[] sublist = value.split(";");
				for(String val : sublist) {
					builder.add("["+val+"]\t");
				}
			}else {
				builder.add("["+value+"]\t");
			}
		}
//		System.out.println(builder.toString());
//		System.out.println(String.join("", builder));
		return String.join("", builder);
	}*/
	
	/**
	 * Returns a string meant to be used as text for a label. 
	 * @author Diego Castellanos dac392
	 * @return String
	 */
	public String getStringTags() {
		
			if(!tags.isEmpty()){
			String builder = "";
			for(Tag x: tags) {
				builder = builder + "["+x.getTagType()+": "+x.getValue()+"] ";
			}
			return builder;
			}
			return "*no tags set*";
	}

	/**
	 * Returns a string meant to be used as text for a label. 
	 * @return String
	 * @author Diego Castellanos dac392
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * Changes the title of a photo. 
	 * @param title String value of the new title.
	 * @author Abid Azad aa2177
	 */	
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

}
