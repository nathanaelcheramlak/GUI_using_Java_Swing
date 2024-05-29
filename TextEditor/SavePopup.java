package TextEditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class SavePopup implements ActionListener{
	private HashMap<String,String> file;
	private String content;
	private boolean savedSuccessfully = false;
	JFrame saveFrame = new JFrame();
	JTextField title = new JTextField();
	JLabel saveLabel = new JLabel("Filename:");
	JLabel statusMessage = new JLabel();
	JButton confirmButton = new JButton("Confirm");
	SavePopup(HashMap<String,String> storage, String content) {
		file = storage;
		this.content = content;
		
		saveLabel.setBounds(25, 25, 60, 25);
		
		title.setBounds(90, 25, 200, 25);
		
		confirmButton.setBounds(200, 80, 90, 20);
		confirmButton.setFocusable(false);
		confirmButton.addActionListener(this);
		
		statusMessage.setBounds(50, 75, 150, 20);
		
		saveFrame.add(title);
		saveFrame.add(saveLabel);
		saveFrame.add(confirmButton);
		saveFrame.add(statusMessage);
		
		saveFrame.setTitle("Save");
		saveFrame.setSize(350, 150);
		saveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		saveFrame.setLayout(null);
		saveFrame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmButton) {
			String text = title.getText();
			if (text.isEmpty() || text.length() >= 50) {
				statusMessage.setText("Invalid Title!");
			}
			else {
				file.put(text, content);
				statusMessage.setText("Saved successfully!");
				savedSuccessfully = true;
				statusMessage.setForeground(Color.green);
				System.out.println(file.get(text));
				saveFrame.setVisible(false);
				return;
			}
		}
	}
	
	public boolean getSavedSuccessfully() {
		return savedSuccessfully;
	}
	
	public String getTitle() {
		return title.getText();
	}
}
