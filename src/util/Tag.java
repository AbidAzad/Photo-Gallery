package util;
import java.io.*;
import java.util.*;
/**
 * Class that holds all the attributes of a Tag. 
 * @author AbidAzad aa2177
 */
public class Tag  implements Serializable{
	/**
	 * tagType String
	 */
	private String tagType;
	/**
	 *	value String
	 */
    private String value;
    /**
     * Initializes the class. 
     * @param  tagType the Album it is translating.
     * @param Value String value
     * @author AbidAzad aa2177
     */
	public Tag(String tagType, String Value){
		this.value = Value;
		this.tagType = tagType;
	}
	
	/**
     * Returns the type of the Tag. 
     * @author AbidAzad aa2177
     * @return String
     */
    public String getTagType() {
        return tagType;
    }
    /**
     * Changes the type of the Tag. 
     * @param  newTag a String value of the new Tag Type.
     * @author AbidAzad aa2177
     */
    public void setTagType(String newTag) {
        this.tagType = newTag;
    }

    /**
     * Returns the value of the Tag. 
     * @author AbidAzad aa2177
     * @return String
     */
    public String getValue() {
        return value;
    }
    /**
     * Changes the value of the Tag. 
     * @param  value a String value of the new Value.
     * @author AbidAzad aa2177
     */
    public void setTagValue(String value) {
        this.value = value;
    }

}