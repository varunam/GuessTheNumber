import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.TextField;


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
		frmGuessTheNumber.setBounds(100, 100, 450, 300);
		frmGuessTheNumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessTheNumber.getContentPane().setLayout(null);
		
		TextField textField2 = new TextField();
		textField2.setEnabled(false);
		textField2.setEditable(false);
		textField2.setBounds(113, 212, 232, 22);
		frmGuessTheNumber.getContentPane().add(textField2);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuess.setIcon(null);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int temp1,answered=0;
				count++;				
				try{
					temp1 = Integer.parseInt(textInput.getText());
					if (temp1 > temp2){
							JOptionPane.showMessageDialog(null, "Answer is lesser than your choice!");
						}
						else if(temp1 < temp2){
							JOptionPane.showMessageDialog(null, "Answer is greater than your choice!");
								}
							else if(temp1 == temp2){
								JOptionPane.showMessageDialog(null, "Congratulations! \n You Guessed it right!");
								answered=1;
								frmGuessTheNumber.dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "GAME OVER!");
					
					textField2.setText("Chances Left to Guess: " + (5-count));
					
					if(count==5){
						if(answered!=1){
						JOptionPane.showMessageDialog(null, "Correct Answer: " + temp2 + "\n Good Bye!");
						frmGuessTheNumber.dispose();
						}
					}
										
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "Enter a number to start the Game!");
				}
			}
		});
		btnGuess.setBounds(158, 73, 118, 40);
		frmGuessTheNumber.getContentPane().add(btnGuess);
		
		textInput = new JTextField();
		textInput.setFont(new Font("Sylfaen", Font.PLAIN, 10));
		textInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textInput.setBounds(138, 136, 172, 20);
		frmGuessTheNumber.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(280, 134, -152, 22);
		frmGuessTheNumber.getContentPane().add(textArea);
		
		JTextArea txtrEnterANumber = new JTextArea();
		txtrEnterANumber.setEnabled(false);
		txtrEnterANumber.setEditable(false);
		txtrEnterANumber.setText("Enter a number within 100");
		txtrEnterANumber.setBounds(113, 184, 232, 22);
		frmGuessTheNumber.getContentPane().add(txtrEnterANumber);
		
		
	}
}
