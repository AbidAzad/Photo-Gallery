package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 *	Static Parser class used for parsing related functions that may be needed. Used to be used by search, idk what might have happend to it by now
 *	@author diegocastellanos 
 */
public class Parser {
	/**
	 *	Arraylist of Strings, this is the set of tokens that you generate
	 */
	private static ArrayList<String> expr;
	/**
	 *	helps you keep track of where the next token is 
	 */
	public static int iterator;
	/**
	 *	variable that holds the current token that you're looking at 
	 */
	private static String token;
	
	/**
	 *	Gets the tags from a tag expression in the form tagtype=tagvalue,...
	 *	@param expression the tag statement as given by the user
	 *	@return HashMap  
	 *	@author diegocastellanos
	 */
	public static HashMap<String, String> getTags(String expression) {
		iterator = 0;
		HashMap<String, String> tags = new HashMap<String, String>();
		
		expr = Normalize((expression+" ."));
		System.out.println(expr.toString());
		if(Program(tags))
			return tags;
		
		return null;
	}
	/**
	 *	initiates the parsing process. can be thought of as a "drive" or S' to S in a CFL
	 *	@param tags a hashmap to keep any valid tags that you may encounter
	 *	@return boolean
	 *	@author diegocastellanos
	 */
	private static boolean Program(HashMap<String, String> tags) {
		nextToken();
		System.out.println("token @progran: "+token);
		StatementList(tags);
		
		if(token.equals(".") && iterator == expr.size())
			return true;
		
		return false;
	}
	
	/**
	 *	in CFL: Program: StatementList . where StatementList is a nonterminal
	 *	@param tags a hashmap to keep any valid tags that you may encounter
	 *	@return boolean
	 *	@author diegocastellanos 
	 */
	private static boolean StatementList(HashMap<String, String> tags) {
		boolean valid = Statement(tags);
		if(!valid)
			return false;
		valid = NextStatement(tags);
		if(valid)
			return true;
		
		return false;
	}
	
	/**
	 *	in a CFG: StatementList : Statement NextStatement Statement evaluates your nonterminals to find if you have a valid tag
	 *	@param tags a hashmap to keep any valid tags that you may encounter
	 *	@return boolean
	 *	@author diegocastellanos 
	 */
	private static boolean Statement(HashMap<String, String> tags) {
		String id = token;
		nextToken();
		System.out.println("token @Statement: "+token);
		if(token.equals("=")) {
			nextToken();
			System.out.println("token @Statement: "+token);
			String value = token;
			if(tags.containsKey(id)) {
				String old_value = tags.get(id);
				tags.put(id, old_value+";"+value);
			}else {
				tags.put(id, value);
			}
			
			nextToken();
			System.out.println("token @Statement: "+token);
			return true;
		}
		return false;
	}
	
	/**
	 *	can be either a StatementList or epsilin. the continuation step in the CFG
	 *	@param a hashmap to keep any valid tags that you may encounter
	 *	@return boolean
	 *	@author diegocastellanos 
	 */
	private static boolean NextStatement(HashMap<String, String> tags) {
		boolean valid;
		if(token.equals(",")) {
			nextToken();
			System.out.println("token @NextStatement: "+token);
			return StatementList(tags);
		}else if(token.equals(".")) {
			return true;
		}
		return false;
	}
	
	/**
	 *	sets up your expression string to a token list help by global expr
	 *	@param expression the user expression String
	 *	@return boolean
	 *	@author diegocastellanos 
	 */
	private static ArrayList<String> Normalize(String expression) {
		ArrayList<String> list = new ArrayList<>(); 
		int begining = 0;
		for(int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			int end = expression.length();
			if(c == '=' || c == ',' || c == '.') {
				end = i;
				list.add((expression.substring(begining, end)).strip());
				begining = i+1;
				list.add(String.valueOf(c));
			}
		}
		return list;
	}
	
	/**
	 *	gives you your next token from the token list
	 *	@author diegocastellanos 
	 */
	private static void nextToken() {
		if(iterator < expr.size()) {
			token = expr.get(iterator++);
		}else {
			token = ".";
		}
	}
	

}
