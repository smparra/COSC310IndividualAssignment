package chatbot;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class botFrame extends GUIbot implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel picture = new JLabel();
	JButton startButton = new JButton();
	JButton chatButton = new JButton();
	JTextField chatBox = new JTextField();
	JTextField outputBox = new JTextField();
	JTextArea test = new JTextArea();

	static String message = null;
	static String output = "";	
	
	botFrame(){
		createFrame();
		createStartButton();
	}
	
	public void createFrame() {
		frame.setTitle("Friend Chatbot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0xA9A9A9));
		frame.setLayout(null);
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void createStartButton() {
		frame.add(startButton);
		startButton.setBounds(250,400,100,50);
		startButton.setText("Chat With Me!");
		startButton.addActionListener(this);
	}
	
	public void createChatButton() {
		frame.add(chatButton);
		chatButton.setBounds(250,330,100,50);
		chatButton.setText("Enter");
		chatButton.addActionListener(this);
	}
	
	public void addChatBox() {
		frame.add(chatBox);
		chatBox.setBounds(60, 400, 500, 150);

		test.setEditable(false);
		frame.add(test);
		
		JScrollPane scrollOutputBox = new JScrollPane(test,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.add(scrollOutputBox);
		scrollOutputBox.setBounds(60, 50, 500, 150);


	}

	public static String getInput() {
		return message;
	}
	public void setOutput(String s) {
		output = s;
	}

	public void answer(String s) {
		test.append("Bot: " + s + "\n");
		chatBox.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			addChatBox();
			createChatButton();
			startButton.setVisible(false);
			chatButton.setVisible(true);
		}
		else if(e.getSource()==chatButton) {
			message = chatBox.getText();
			test.append("ME: " + message + "\n");
			chatBox.setText("");
			userResponded(message);
			
		}
		
	}

}
	