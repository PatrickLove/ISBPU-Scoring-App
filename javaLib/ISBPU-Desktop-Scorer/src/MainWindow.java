import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import com.ispbu.scoring.Frame;
import com.ispbu.scoring.Game;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;


public class MainWindow {

	private JFrame frmIsbpuOfficialDesktop;
	public static Game g = new Game();
	private GameView gameView;
	/**
	 * @wbp.nonvisual location=1249,54
	 */
	private final JButton button_11 = new JButton("New button");
	private JButton btnSpare;
	private JButton btnStrike;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmIsbpuOfficialDesktop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsbpuOfficialDesktop = new JFrame();
		frmIsbpuOfficialDesktop.setTitle("ISBPU Official Desktop Scorer");
		frmIsbpuOfficialDesktop.setBounds(100, 100, 850, 694);
		frmIsbpuOfficialDesktop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 75, 0, 0, 0, 0, 0, 0, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		frmIsbpuOfficialDesktop.getContentPane().setLayout(gridBagLayout);
		
		gameView = new GameView();
		GridBagConstraints gbc_gameView = new GridBagConstraints();
		gbc_gameView.gridwidth = 3;
		gbc_gameView.fill = GridBagConstraints.BOTH;
		gbc_gameView.insets = new Insets(0, 0, 5, 5);
		gbc_gameView.gridx = 1;
		gbc_gameView.gridy = 1;
		frmIsbpuOfficialDesktop.getContentPane().add(gameView, gbc_gameView);
		gameView.setGame(g);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(1);
				gameView.updateGame();
				updateButtons();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 3;
		frmIsbpuOfficialDesktop.getContentPane().add(button, gbc_button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(2);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 3;
		frmIsbpuOfficialDesktop.getContentPane().add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(3);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 3;
		frmIsbpuOfficialDesktop.getContentPane().add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(4);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.BOTH;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 4;
		frmIsbpuOfficialDesktop.getContentPane().add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(5);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.BOTH;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 2;
		gbc_button_4.gridy = 4;
		frmIsbpuOfficialDesktop.getContentPane().add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(6);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.BOTH;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 3;
		gbc_button_5.gridy = 4;
		frmIsbpuOfficialDesktop.getContentPane().add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(7);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.BOTH;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 1;
		gbc_button_6.gridy = 5;
		frmIsbpuOfficialDesktop.getContentPane().add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(8);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.fill = GridBagConstraints.BOTH;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 2;
		gbc_button_7.gridy = 5;
		frmIsbpuOfficialDesktop.getContentPane().add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(9);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.BOTH;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 3;
		gbc_button_8.gridy = 5;
		frmIsbpuOfficialDesktop.getContentPane().add(button_8, gbc_button_8);
		
		btnSpare = new JButton("/");
		btnSpare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(Frame.MAKE_SPARE);
				gameView.updateGame();
				updateButtons();
			}
		});
		btnSpare.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnSpare = new GridBagConstraints();
		gbc_btnSpare.fill = GridBagConstraints.BOTH;
		gbc_btnSpare.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpare.gridx = 1;
		gbc_btnSpare.gridy = 6;
		frmIsbpuOfficialDesktop.getContentPane().add(btnSpare, gbc_btnSpare);
		
		JButton button_9 = new JButton("-");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(0);
				gameView.updateGame();
				updateButtons();
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.fill = GridBagConstraints.BOTH;
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 2;
		gbc_button_9.gridy = 6;
		frmIsbpuOfficialDesktop.getContentPane().add(button_9, gbc_button_9);
		
		btnStrike = new JButton("X");
		btnStrike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(10);
				gameView.updateGame();
				updateButtons();
			}
		});
		btnStrike.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnStrike = new GridBagConstraints();
		gbc_btnStrike.fill = GridBagConstraints.BOTH;
		gbc_btnStrike.insets = new Insets(0, 0, 5, 5);
		gbc_btnStrike.gridx = 3;
		gbc_btnStrike.gridy = 6;
		frmIsbpuOfficialDesktop.getContentPane().add(btnStrike, gbc_btnStrike);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g = new Game();
				gameView.setGame(g);
				updateButtons();
			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.gridwidth = 3;
		gbc_btnNewGame.fill = GridBagConstraints.BOTH;
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewGame.gridx = 1;
		gbc_btnNewGame.gridy = 7;
		frmIsbpuOfficialDesktop.getContentPane().add(btnNewGame, gbc_btnNewGame);
		
		updateButtons();
	}

	protected void updateButtons() {
		btnSpare.setEnabled(g.canSpare());
		btnStrike.setEnabled(g.canStrike());
	}
}
