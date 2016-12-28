import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Creates the GUI for Phrase Coder
 * 
 * @author Malik
 *
 */
@SuppressWarnings("serial")
public class PhraseCoderPanel extends JPanel implements ActionListener {

	private JPanel phrasePanel = new JPanel(), codingPanel = new JPanel(), southPanel = new JPanel();
	private JButton encode, decode;
	private JTextArea shiftControl;
	private JTextField enterPhrase;
	private int shift;
	private final int DEFAULT_SHIFT = 5;
	private String input = "", output = "";
	private int letter, codedLetter;

	/**
	 * Creates the Panel for the PhraseCoder class
	 */
	public PhraseCoderPanel() {
		shift = DEFAULT_SHIFT;
		this.setLayout(new BorderLayout());

		codingPanel.setLayout(new GridLayout(1, 3));

		//creates the text area for the character shifts
		shiftControl = new JTextArea();
		shiftControl.setEditable(true);
		shiftControl.setText("5");
		shiftControl.setBorder(BorderFactory.createTitledBorder("Shift"));

		codingPanel.add(shiftControl);

		//creates the buttons for encode and decode
		encode = new JButton("Encode");
		encode.addActionListener(this);
		codingPanel.add(encode);

		decode = new JButton("Decode");
		decode.addActionListener(this);
		codingPanel.add(decode);

		southPanel.add(codingPanel);
		this.add(southPanel, BorderLayout.SOUTH);

		//creates the text field for the phrase to be entered
		enterPhrase = new JTextField();
		enterPhrase.setPreferredSize(new Dimension(300, 50));
		enterPhrase.setEditable(true);
		enterPhrase.setText("Please enter your phrase here");
		enterPhrase.setBorder(BorderFactory.createTitledBorder("Phrase"));

		phrasePanel.add(enterPhrase);
		this.add(phrasePanel, BorderLayout.CENTER);
	}

	/**
	 * Encodes a phrase
	 */
	public void encode() {
		shift = Integer.parseInt(shiftControl.getText().trim());
		input = enterPhrase.getText().trim();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') { // prints a space if the character is
											// a space
				output += " ";
			} else {
				char character = input.charAt(i);
				letter = (int) character;
				codedLetter = (letter + shift); // reverts character change
				output += (char) codedLetter; // prints out decoded message
			}
		}
		enterPhrase.setText(output);
		output = " ";
	}

	/**
	 * Decodes a phrase
	 */
	public void decode() {
		shift = Integer.parseInt(shiftControl.getText().trim());
		input = enterPhrase.getText().trim();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') { // prints a space if the character is
											// a space
				output += " ";
			} else {
				char character = input.charAt(i);
				letter = (int) character;
				codedLetter = (letter - shift); // reverts character change
				output += (char) codedLetter; // prints out decoded message
			}
		}
		enterPhrase.setText(output);
		output = " ";
	}

	/**
	 * Controls all actions for the program.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton source = (JButton) e.getSource();

		if (source.getText().equals("Encode")) {
			encode();
		}

		if (source.getText() == "Decode") {
			decode();
		}
	}

}