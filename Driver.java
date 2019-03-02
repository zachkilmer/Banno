import java.util.Scanner;

/**
 * @author Zach Kilmer
 */	
public class Driver {
	
	/*
	 * 	This Standard driver constructor is Banno specific
	 */
	public Driver() {
		Reader.filler("https://banno.com");
		System.out.println("Banno's twitter handle is : " + Reader.twitterHandle());
		System.out.println("Bannos git hub account is " + Reader.githubAccount());
		System.out.println("The number of photos on the webpage is : " + Reader.numOfPhotos());
		System.out.println("The amount of times financial institution is said is : " + Reader.financialCount());
		System.out.println("The top character is '" + Reader.top3char()[0].getItem() + "' and it is used " + Reader.top3char()[0].getValue() + " times");
		System.out.println("The second most used character is '" +Reader.top3char()[1].getItem() + "' and it is used " + Reader.top3char()[1].getValue() + " times");
		System.out.println("The third most used chracter is '" + Reader.top3char()[2].getItem() + "' and it is used " + Reader.top3char()[2].getValue() + " times" );
		System.out.println("The amount of products banno has is " + Reader.productsOffered()+ "\n");
	}
	
	/*
	 * This driver can be used for any link
	 * @param String link
	 * 
	 */
	public Driver(String link) {
		Reader.filler(link);
		System.out.println( link + " twitter handle is : " + Reader.twitterHandle());
		System.out.println("Their git hub account is " + Reader.githubAccount());
		System.out.println("The number of photos on the webpage is : " + Reader.numOfPhotos());
		System.out.println("The amount of times financial institution is said is : " + Reader.financialCount());
		System.out.println("The top chracter is '" + Reader.top3char()[0].getItem() + "' and it is used " + Reader.top3char()[0].getValue() + " times");
		System.out.println("The second most used character is '" +Reader.top3char()[1].getItem() + "' and it is used " + Reader.top3char()[1].getValue() + " times");
		System.out.println("The third most used chracter is '" + Reader.top3char()[2].getItem() + "' and it is used " + Reader.top3char()[2].getValue() + " times \n");
	}
	/*
	 * Takes in HTML from the user and supplies it to the non-Banno driver
	 */
	public static void userDriver() {
		System.out.println("please enter a new URL ");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		System.out.println("");
		if(Reader.filler(input)) {
			new Driver(input);
		}
		
	}
	
	public static void main(String[] args) {
		 new Driver();
		 //uncomment this line to insert your very own html link
		 //new Driver("https://en.wikipedia.org/wiki/Battleship");
		 //new Driver("https://www.crnrstone.com/our-team/sam-kilmer/?__hstc=242444893.7c21c85effd0deb6164f5c7abbaf8c4d.1549327652539.1549327652539.1550957641787.2&__hssc=242444893.1.1550957641787&__hsfp=2135526856");
		 userDriver();
	}

	
}
