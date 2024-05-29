package TextEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class TextEditor extends JFrame implements ActionListener{
	HashMap<String,String> files = new HashMap<String,String>();
	JTextArea textField = new JTextArea();
	JButton saveButton = new JButton("Save");
	JLabel message = new JLabel();
	TextEditor() {
 		
		textField.setLineWrap(true);
		textField.setBounds(5, 100, 675, 500);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		saveButton.setBounds(10, 610, 80, 30);
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		
		message.setBounds(150, 610, 250, 30);
		message.setFont(new Font(null, Font.ITALIC, 15));
		
		this.add(textField);
		this.add(saveButton);
		this.add(message);
		
		this.setTitle("NotePad+PRO");
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setSize(700, 700);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	 }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) {
			String userText = textField.getText();
			if (userText.isEmpty()) {
				message.setText("Content cannot be empty!");
				message.setForeground(Color.red);
			}
			else {
				SavePopup saveFrame = new SavePopup(files, userText);
				// textField.setText("");
				System.out.println(saveFrame.getSavedSuccessfully());
				if (saveFrame.getSavedSuccessfully()) {
					String title = saveFrame.getTitle();
					textField.setText("");
					message.setText(title + " is saved successfully.");
				}
			}
		}
	}
}
