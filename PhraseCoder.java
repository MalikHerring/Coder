import javax.swing.JFrame;

/**
 * Driver Class for PhraseCoderPanel
 * @author Malik Herring
 *
 */
public class PhraseCoder {

	public static void main(String[] args) {

		JFrame frame = new JFrame("PhraseCoder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new PhraseCoderPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
