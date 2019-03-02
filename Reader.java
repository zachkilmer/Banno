import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
  * @author Zach Kilmer
  */
public class Reader {
	public static Document doc;
	
	/*
	 * Jsoup client use using URL to convert to Document doc for class use
	 * False if connect fails to find the web page
	 * @param String url
	 * @return Boolean
	 */
	public static Boolean filler(String Url)  {
		try {
			doc = Jsoup.connect(Url).get();
			return true;
		} catch (Exception e) { 
			System.out.println("Sorry thats a invalid URL or not fully completed link");
			return false;
		}
	}
	
	/*
	 * Function for local testing of the method, allows for static input instead of connecting to Jsoup
	 * @param String HTML
	 * @return void
	 */
	public static void Testfiller(String Html) {
		doc = Jsoup.parse(Html);
	}
	
	/*
	 * I was unable to implement this with my current html-to-java 
	 * client, in the future I would choose a different html client with better documentation.
	 * What i would do is check how many items are detected in the Products Sub menu.
	 * This is as close as I could get with the one I chose.
	 * @return int
	 */
	public static int productsOffered() {
		int productCounter = -1;
		Elements listItem = doc.select("li");
		for(Element item: listItem) {
			if(item.text().contains("Products")) {
				//this if is used to get in the products menu
				if(item.text().contains("Product")) {
					//This if records all the use of product in the menu - 1 because "products" doesn't count
					productCounter++;
				}
			}
		}
		return productCounter;
	}
	
	/*
	 * Finds the amount of images in the HTML using the image links
	 * @return int
	 */
	public static int numOfPhotos() {
		return doc.select("img").size();
		
	}
	

	/*
	 * Searches HTML document by adding chars to a Hashmap, returning the top three in a Pair array
	 * @return Pair[] 
	 */
	public static Pair[] top3char(){
		Pair[] top3 = new Pair[3];
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String texts= doc.text();
		char[] letters = texts.toLowerCase().toCharArray();
		//filling the hashmap 
		for(char letter: letters){
			if( map.containsKey(letter)) {
				map.put(letter, map.get(letter) + 1);
			}else {
				map.put(letter, 1);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			char currentTop = topCharInHash(map);
			top3[i] = new Pair(currentTop,map.get(currentTop));
			map.remove(currentTop);
		}
		return top3;
	}
	
	/*
	 * Auxiliary function to find the top three characters
	 * @param HashMap<Character, Integer> map
	 * @return char
	 */
	private static char topCharInHash( HashMap<Character, Integer> map ) {
		int maxVal = 0;
		char maxChar = 0;
		for(char item : map.keySet() ) {
			if(map.get(item) > maxVal) {
				maxVal = map.get(item);
				maxChar = item;
			}
		}
		return maxChar;
	}
	
	/*
	 * Finds twitter handle finding "href" and then matching for "twitter.com/"
	 * @return String
	 */
	public static String twitterHandle() {
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			String currentLink = link.attr("href");
			if(currentLink.contains("twitter.com/")) {
				//start of the twitter handle
				// + 12 is to account for the twitter.com/ 
				int start = currentLink.lastIndexOf("twitter.com/") + 12;
				String handle = currentLink.substring(start);
					if(handle.contains("/")) {
						//this is not a twitter handle, just a link
						break;
					}
				return handle;
			}
		}
		return "no Twitter handle detected";
	}
	
	/*
	 * Finds github account looking for "href" and then checking for "github.com/"
	 * @return String
	 */
	public static String githubAccount() {
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			String currentLink = link.attr("href");
			if(currentLink.contains("github.com/")) {
				int start = currentLink.lastIndexOf("github.com/") + 11;
				String handle = currentLink.substring(start);
					if(handle.contains("/")) {
						//this is not a github account, just a link
						break;
					}
				return handle;
			}
		}
		return "not detected";
	}
	//
	//also note i was not sure if you wanted financial institutions to be included in the search results
	/*
	 * Looks for anything on the page that includes the word "financial institution" 
	 * needs lowercase to make capitalization is not affected
	 * In this I had to decide if it it wanted "financial institutions" to be included, I decided to not include
	 * those values, so the count reflects only "financial institution" with no s
	 * @return int
	 */
	public static int financialCount() {
		String item = " financial institution ";
		String texts = doc.text();
		int count = 0;
		int fromIndex = 0;
		while(  fromIndex != -1) {
			fromIndex = texts.indexOf(item, fromIndex);
			
			if(fromIndex != -1) {
				count++;
				fromIndex += item.length();
			}
			
		}
		return count;
	}

}
