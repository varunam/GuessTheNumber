import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.TextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;


public class GuessTheNumber {
	static int temp2, count=0;
	private JFrame frmGuessTheNumber;
	private JTextField textInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Random guess = new Random();
		temp2 = guess.nextInt(100);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessTheNumber window = new GuessTheNumber();
					window.frmGuessTheNumber.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuessTheNumber() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuessTheNumber = new JFrame();
		frmGuessTheNumber.setBackground(Color.RED);
		frmGuessTheNumber.setAlwaysOnTop(true);
		frmGuessTheNumber.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Varun\\Desktop\\images.png"));
		frmGuessTheNumber.setForeground(Color.WHITE);
		frmGuessTheNumber.setTitle("Guess the Number!");
		frmGuessTheNumber.setBounds(100, 100, 606, 452);
		frmGuessTheNumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessTheNumber.getContentPane().setLayout(null);
		
		TextField textField2 = new TextField();
		textField2.setBackground(SystemColor.window);
		textField2.setEnabled(false);
		textField2.setEditable(false);
		textField2.setBounds(318, 245, 232, 22);
		frmGuessTheNumber.getContentPane().add(textField2);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuess.setIcon(null);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int temp1,answered=0;
								
				try{
					temp1 = Integer.parseInt(textInput.getText());
					if (temp1>100){
						/* using the below block of code to make pop ups happen on top rather than behind. old line of code is mentioned below */
						final JDialog dialog = new JDialog();
						dialog.setAlwaysOnTop(true);    
						JOptionPane.showMessageDialog(dialog, "I asked you to enter a number lesser than 100!");
						//JOptionPane.showMessageDialog(null, "I asked you to enter a number lesser than 100!"); (this pane will pop up behind main window.
						
					} else if (temp1 > temp2){
						final JDialog dialog = new JDialog();
						dialog.setAlwaysOnTop(true);    
						JOptionPane.showMessageDialog(dialog, "Answer is lesser than your choice!");
							//JOptionPane.showMessageDialog(null, "Answer is lesser than your choice!");
							count++;
						}
						else if(temp1 < temp2){
							final JDialog dialog = new JDialog();
							dialog.setAlwaysOnTop(true);    
							JOptionPane.showMessageDialog(dialog, "Answer is greater than your choice!");
							//JOptionPane.showMessageDialog(null, "Answer is greater than your choice!");
							count++;
								}
							else if(temp1 == temp2){
								final JDialog dialog = new JDialog();
								dialog.setAlwaysOnTop(true);    
								JOptionPane.showMessageDialog(dialog, "Congratulations! \n You Guessed it right!");
								//JOptionPane.showMessageDialog(null, "Congratulations! \n You Guessed it right!");
								count++;
								answered=1;
								frmGuessTheNumber.dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "GAME OVER!");
								
					
					textField2.setText(temp2 + "Chances Left to Guess: " + (5-count));
					
					if(count==5){
						if(answered!=1){
							final JDialog dialog = new JDialog();
							dialog.setAlwaysOnTop(true);    
							JOptionPane.showMessageDialog(dialog, " GAME OVER! \n Correct Answer: " + temp2 + "\n Good Bye!");
						//JOptionPane.showMessageDialog(null, "Correct Answer: " + temp2 + "\n Good Bye!");
						frmGuessTheNumber.dispose();
						}
					}
										
				}catch (Exception e){
					final JDialog dialog = new JDialog();
					dialog.setAlwaysOnTop(true);    
					JOptionPane.showMessageDialog(dialog, "Enter a number to start the Game!");
				//	JOptionPane.showMessageDialog(null, "Enter a number to start the Game!");
				}
			}
		});
		btnGuess.setBounds(356, 102, 118, 40);
		frmGuessTheNumber.getContentPane().add(btnGuess);
		
		textInput = new JTextField();
		textInput.setFont(new Font("Sylfaen", Font.PLAIN, 10));
		textInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textInput.setBounds(334, 167, 172, 20);
		frmGuessTheNumber.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(280, 134, -152, 22);
		frmGuessTheNumber.getContentPane().add(textArea);
		
		JTextArea txtrEnterANumber = new JTextArea();
		txtrEnterANumber.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrEnterANumber.setForeground(SystemColor.activeCaptionText);
		txtrEnterANumber.setWrapStyleWord(true);
		txtrEnterANumber.setBackground(UIManager.getColor("CheckBox.light"));
		txtrEnterANumber.setToolTipText("");
		txtrEnterANumber.setLineWrap(true);
		txtrEnterANumber.setEnabled(false);
		txtrEnterANumber.setEditable(false);
		txtrEnterANumber.setText(" (Enter a number within 100)");
		txtrEnterANumber.setBounds(307, 186, 232, 22);
		frmGuessTheNumber.getContentPane().add(txtrEnterANumber);
		
		JButton btnNewButton = new JButton("How to Play?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				JOptionPane.showMessageDialog(dialog, "1. Enter a number within given limit in the text box given. \n2. If your number matches with system generated Random number, you will win the Game. \n3. If your number doesn't match, you will be notified whether your number is greater or lesser than System generated number. \n4. You are supposed to Guess The Number within given number of chances. \nNote: Make use of Clues if any. ");
				//JOptionPane.showMessageDialog(null, "1. Enter a number within given limit in the text box given. \n2. If your number matches with system generated Random number, you will win the Game. \n3. If your number doesn't match, you will be notified whether your number is greater or lesser than System generated number. \n4. You are supposed to Guess The Number within given number of chances. \nNote: Make use of Clues if any. ");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton.setBounds(474, 374, 106, 28);
		frmGuessTheNumber.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		Image Images = new ImageIcon(this.getClass().getResource("/Guess.png")).getImage();
		label.setIcon(new ImageIcon(Images));
		label.setBounds(18, 11, 256, 256);
		frmGuessTheNumber.getContentPane().add(label);
		
		
	}
}
