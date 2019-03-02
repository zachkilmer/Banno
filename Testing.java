import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Zach Kilmer
 *
 */
public class Testing {

	/**
	 * @param args
	 */
	public static void financialCountTest() {
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests</title></head>"
				  + "<body>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  + "<a href=\"https://twitter.com/kilmer_zach\" </a> "
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.financialCount(),2);
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  + "<a href=\"https://twitter.com/kilmer_zach\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.financialCount(),4);
		System.out.println("all financialCount tests pass");
	}
	
	public static void twitterHandlerTests() {
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  + "<a href=\"https://twitter.com/kilmer_zach\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.twitterHandle(),"kilmer_zach");
		
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  + "<a href=\"https://twitter.com/elonmusk\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.twitterHandle(),"elonmusk");
		System.out.println("all twitter Handle tests Pass");
	}
	
	public static void numOfPhotosTester() {
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  +"<img cool image that i dont want to creat a link for >"
				  + "<a href=\"https://twitter.com/elonmusk\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.numOfPhotos(), 1);
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<img something cool>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  +"<img cool image that i dont want to creat a link for >"
				  + "<a href=\"https://twitter.com/elonmusk\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.numOfPhotos(), 2);
		System.out.println("all numOfPhotos tests pass");
	}
	
	public static void githubAccountTester() {
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<img something cool>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  +"<img cool image that i dont want to creat a link for >"
				  + "<a href=\"https://github.com/zachkilmer\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.githubAccount(),"zachkilmer");
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<img something cool>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  +"<img cool image that i dont want to creat a link for >"
				  + "<a href=\"https://github.com/zkilmer\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		assertEquals(Reader.githubAccount(),"zkilmer");
		System.out.println("all github account tests work.");
	}
	
	public static void top3CharTester() {
		Reader.Testfiller("<html><head><title>This is a testing string for my Unit tests financial institution </title></head>"
				  + "<body>"
				  + "<img something cool>"
				  + "<p> This is a test to see if financial institution is being recongised in financial institution test "
				  + " </p> "
				  +"<img cool image that i dont want to creat a link for >"
				  + "<a href=\"https://github.com/zkilmer\" </a> "
				  +"<p> this is another use of financial institution and not financial institutions </p>"
				  + "</body>"
				  + "</html>");
		Pair[] tests = Reader.top3char();
		// the confirmed top 3 should be I with 39, ' ' with 37 and T with 31. using another charcter counter online to confirm.
		assertTrue(tests[0].getItem() == 'i');
		assertTrue(tests[0].getValue() == 39);
		
		assertTrue(tests[1].getItem() == ' ');
		assertTrue(tests[1].getValue() == 37);
		
		assertTrue(tests[2].getItem() == 't');
		assertTrue(tests[2].getValue() == 31);
		System.out.println("all top3Char tests work");
	}
	
	public static void main(String[] args) {
		financialCountTest();
		twitterHandlerTests();
		numOfPhotosTester();
		githubAccountTester();
		top3CharTester();
	}

}
