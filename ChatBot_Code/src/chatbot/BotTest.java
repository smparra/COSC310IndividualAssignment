package chatbot;

// import JUnit libraries
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *  This is a JUnit unit test file that check against the methods in the Bot.java class
 */
class BotTest 
{

	/**
	 * This test method checks the display output of DiscussFeeling method in the Bot.java class
	 */
	@Test
	void testDiscussFeeling() throws Exception
	{
		// parse input "not so good" for analyze
		Bot.tokens = Bot.parse("Not so good");
		
		// calls method to analyze input
		Bot.POSTagging();	
		Bot.personNER();
		Bot.locationNER();
		Bot.lemmatize(Bot.tokens, Bot.tags);
		
		// test output
		assertEquals("I'm sorry to hear that. I hope chatting with me will make you feel better.", Bot.discussFeeling("Not so good")); 
	}

	@Test
	void testDiscussLocation() throws Exception
	{
		Bot.tokens = Bot.parse("I live in Ontario");
		
		// calls method to analyze input
		Bot.POSTagging();
		Bot.locationNER();
		
		String response = Bot.discussLocation("I live in Ontario");
		
		// test output
		assertEquals("Oh! We live in the same country!", response);
	}


	@Test
	void testHobbyResponse() throws Exception
	{
		Bot.tokens = Bot.parse("Which movie do you like the most?");
		
		// calls method to analyze input
		Bot.POSTagging();
        Bot.personNER();
        Bot.locationNER();
        Bot.lemmatize(Bot.tokens, Bot.tags);
        
        // possible responses
        String response1 = "My favourite movie is 'The Godfather'. Which movie do you like the most?";
        String response2 = "I like 'The Godfather' the most. Which movie do you like the most?";
        String response3 = "I really like 'The Godfather'. Which movie do you like the most?";
                
        String output = Bot.hobbyResponse("Which movie do you like the most?");
        
        // tset output
        assertTrue(((response1.equals(output)) ||(response2.equals(output)) || (response3.equals(output))));
       	}

	

}
