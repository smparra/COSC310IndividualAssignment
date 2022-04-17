package chatbot;
public class GUIbot {
	
	public static String input = "";
	public static String response = null;
	public static boolean uResponded;
	static Bot jerry;
	static botFrame frame;

	public void userResponded(String s) {
		uResponded = true;
		if (Bot.isQuit(s)) {
			frame.answer("It's very nice to chat with you. Looking forward to talking with you next time!");
		} else {
			try {
				Bot.prepData(s);
				response = Bot.generateResponse(s);
				Bot.clearAllAL();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			frame.answer(response);
		}
		
	}
	
	
	public static void main(String[] args) {
		frame = new botFrame();
		
	}
}
