import java.awt.EventQueue;

import javax.swing.JFrame;

import com.ispbu.scoring.Frame;
import com.ispbu.scoring.Game;
import com.ispbu.scoring.GameStats;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;


public class MainWindow {

	private JFrame frmIsbpuOfficialDesktop;
	public static Game g = new Game();
	private GameView gameView;
	private JButton btnSpare;
	private JButton btnStrike;
	private JButton button1;
	private JButton button4;
	private JButton button2;
	private JButton button3;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button0;
	private JButton button5;
	private JButton btnNewGame;
	private JLabel labelStats;
	private JPanel panel;
	private JLabel lblScoreVal;
	private JLabel lblMarksVal;
	private JLabel lblStrikesVal;
	private JLabel lblSparesVal;
	private JLabel lblBPPMVal;
	private JLabel lblSPFVal;
	private JLabel lblNineSpare;
	private JButton btnBackspace;

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
		frmIsbpuOfficialDesktop.setResizable(false);
		frmIsbpuOfficialDesktop.setTitle("ISBPU Official Desktop Scorer");
		frmIsbpuOfficialDesktop.setBounds(100, 100, 845, 795);
		frmIsbpuOfficialDesktop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 75, 0, 0, 0, 0, 0, 0, 0, 105, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(1);
				gameView.updateGame();
				updateButtons();
			}
		});
		button1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 1;
		gbc_button1.gridy = 3;
		frmIsbpuOfficialDesktop.getContentPane().add(button1, gbc_button1);
		
		button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(2);
				gameView.updateGame();
				updateButtons();
			}
		});
		button2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 2;
		gbc_button2.gridy = 3;
		frmIsbpuOfficialDesktop.getContentPane().add(button2, gbc_button2);
		
		button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(3);
				gameView.updateGame();
				updateButtons();
			}
		});
		button3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.insets = new Insets(0, 0, 5, 5);
		gbc_button3.gridx = 3;
		gbc_button3.gridy = 3;
		frmIsbpuOfficialDesktop.getContentPane().add(button3, gbc_button3);
		
		button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(4);
				gameView.updateGame();
				updateButtons();
			}
		});
		button4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.insets = new Insets(0, 0, 5, 5);
		gbc_button4.gridx = 1;
		gbc_button4.gridy = 4;
		frmIsbpuOfficialDesktop.getContentPane().add(button4, gbc_button4);
		
		button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(5);
				gameView.updateGame();
				updateButtons();
			}
		});
		button5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.insets = new Insets(0, 0, 5, 5);
		gbc_button5.gridx = 2;
		gbc_button5.gridy = 4;
		frmIsbpuOfficialDesktop.getContentPane().add(button5, gbc_button5);
		
		button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(6);
				gameView.updateGame();
				updateButtons();
			}
		});
		button6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.fill = GridBagConstraints.BOTH;
		gbc_button6.insets = new Insets(0, 0, 5, 5);
		gbc_button6.gridx = 3;
		gbc_button6.gridy = 4;
		frmIsbpuOfficialDesktop.getContentPane().add(button6, gbc_button6);
		
		button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(7);
				gameView.updateGame();
				updateButtons();
			}
		});
		button7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.fill = GridBagConstraints.BOTH;
		gbc_button7.insets = new Insets(0, 0, 5, 5);
		gbc_button7.gridx = 1;
		gbc_button7.gridy = 5;
		frmIsbpuOfficialDesktop.getContentPane().add(button7, gbc_button7);
		
		button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(8);
				gameView.updateGame();
				updateButtons();
			}
		});
		button8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.fill = GridBagConstraints.BOTH;
		gbc_button8.insets = new Insets(0, 0, 5, 5);
		gbc_button8.gridx = 2;
		gbc_button8.gridy = 5;
		frmIsbpuOfficialDesktop.getContentPane().add(button8, gbc_button8);
		
		button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(9);
				gameView.updateGame();
				updateButtons();
			}
		});
		button9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.fill = GridBagConstraints.BOTH;
		gbc_button9.insets = new Insets(0, 0, 5, 5);
		gbc_button9.gridx = 3;
		gbc_button9.gridy = 5;
		frmIsbpuOfficialDesktop.getContentPane().add(button9, gbc_button9);
		
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
		
		button0 = new JButton("-");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.makeThrow(0);
				gameView.updateGame();
				updateButtons();
			}
		});
		button0.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_button0 = new GridBagConstraints();
		gbc_button0.fill = GridBagConstraints.BOTH;
		gbc_button0.insets = new Insets(0, 0, 5, 5);
		gbc_button0.gridx = 2;
		gbc_button0.gridy = 6;
		frmIsbpuOfficialDesktop.getContentPane().add(button0, gbc_button0);
		
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
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g = new Game();
				gameView.setGame(g);
				resetButtons();
			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.gridwidth = 2;
		gbc_btnNewGame.fill = GridBagConstraints.BOTH;
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewGame.gridx = 1;
		gbc_btnNewGame.gridy = 7;
		frmIsbpuOfficialDesktop.getContentPane().add(btnNewGame, gbc_btnNewGame);
		
		btnBackspace = new JButton("\u2190");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.undoThrow();
				gameView.updateGame();
				updateButtons();
			}
		});
		GridBagConstraints gbc_btnBackspace = new GridBagConstraints();
		gbc_btnBackspace.fill = GridBagConstraints.BOTH;
		gbc_btnBackspace.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackspace.gridx = 3;
		gbc_btnBackspace.gridy = 7;
		frmIsbpuOfficialDesktop.getContentPane().add(btnBackspace, gbc_btnBackspace);
		
		labelStats = new JLabel("Game Stats:");
		labelStats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelStats.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_labelStats = new GridBagConstraints();
		gbc_labelStats.fill = GridBagConstraints.BOTH;
		gbc_labelStats.insets = new Insets(0, 0, 5, 5);
		gbc_labelStats.gridx = 1;
		gbc_labelStats.gridy = 8;
		frmIsbpuOfficialDesktop.getContentPane().add(labelStats, gbc_labelStats);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 9;
		frmIsbpuOfficialDesktop.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(50dlu;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblScore, "2, 2");
		
		lblScoreVal = new JLabel();
		panel.add(lblScoreVal, "4, 2, fill, fill");
		
		JLabel lblAverageMarkBonus = new JLabel("Average Mark Bonus:");
		lblAverageMarkBonus.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblAverageMarkBonus, "8, 2");
		
		lblBPPMVal = new JLabel();
		panel.add(lblBPPMVal, "10, 2, fill, fill");
		
		JLabel lblMarks = new JLabel("Marks:");
		lblMarks.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblMarks, "2, 4");
		
		lblMarksVal = new JLabel();
		panel.add(lblMarksVal, "4, 4, fill, fill");
		
		JLabel lblAvaerageScorePer = new JLabel("Average Score per Frame:");
		lblAvaerageScorePer.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblAvaerageScorePer, "8, 4");
		
		lblSPFVal = new JLabel();
		panel.add(lblSPFVal, "10, 4, fill, fill");
		
		JLabel lblStrikes = new JLabel("Strikes:");
		lblStrikes.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblStrikes, "2, 6");
		
		lblStrikesVal = new JLabel();
		panel.add(lblStrikesVal, "4, 6, fill, fill");
		
		JLabel lblspareConversion = new JLabel("9-Spare Conversion %:");
		lblspareConversion.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblspareConversion, "8, 6");
		
		lblNineSpare = new JLabel();
		panel.add(lblNineSpare, "10, 6, fill, fill");
		
		JLabel lblSpares = new JLabel("Spares:");
		lblSpares.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblSpares, "2, 8");
		
		lblSparesVal = new JLabel();
		panel.add(lblSparesVal, "4, 8, fill, fill");
		
		registerBindings();
		updateButtons();
	}
	
	private void registerBindings(){
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if(e.getID() == KeyEvent.KEY_TYPED){
					char c = Character.toLowerCase(e.getKeyChar());
					switch(c){
					case '0':
					case '-':
						button0.doClick();
						break;
					case '1':
						button1.doClick();
						break;
					case '2':
						button2.doClick();
						break;
					case '3':
						button3.doClick();
						break;
					case '4':
						button4.doClick();
						break;
					case '5':
						button5.doClick();
						break;
					case '6':
						button6.doClick();
						break;
					case '7':
						button7.doClick();
						break;
					case '8':
						button8.doClick();
						break;
					case '9':
						button9.doClick();
						break;
					case '/':
						btnSpare.doClick();
						break;
					case 'x':
						btnStrike.doClick();
						break;
					}
				}
				else if(e.getID() == KeyEvent.KEY_PRESSED){
					if(	e.getKeyCode() == KeyEvent.VK_N && e.isControlDown()){
						btnNewGame.doClick();
					}
					if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE){
						btnBackspace.doClick();
					}
				}
				return false;
			}
		});
	}

	private boolean wasFinished = false;
	
	private void updateButtons() {
		btnSpare.setEnabled(g.canSpare());
		btnStrike.setEnabled(g.canStrike());
		if(g.isFinished()){
			wasFinished = true;
			button0.setEnabled(false);
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			button4.setEnabled(false);
			button5.setEnabled(false);
			button6.setEnabled(false);
			button7.setEnabled(false);
			button8.setEnabled(false);
			button9.setEnabled(false);
			GameStats stats = g.getStats();
			lblScoreVal.setText(stats.getScore() + "");
			lblMarksVal.setText(stats.getMarks() + "");
			lblStrikesVal.setText(stats.getStrikes() + "");
			lblSparesVal.setText(stats.getSpares()+"");
			lblBPPMVal.setText(String.format("%.3f", stats.getAvgBonus()));
			lblSPFVal.setText(String.format("%.3f", stats.getAvgFrameScore()));
			lblNineSpare.setText(String.format("%.2f%%", stats.getNineConvert()*100));
		}
		else if(wasFinished){
			wasFinished = false;
			resetButtons();
		}
	}
	
	private void resetButtons(){
		button0.setEnabled(true);
		button1.setEnabled(true);
		button2.setEnabled(true);
		button3.setEnabled(true);
		button4.setEnabled(true);
		button5.setEnabled(true);
		button6.setEnabled(true);
		button7.setEnabled(true);
		button8.setEnabled(true);
		button9.setEnabled(true);
		lblScoreVal.setText("");
		lblMarksVal.setText("");
		lblStrikesVal.setText("");
		lblSparesVal.setText("");
		lblBPPMVal.setText("");
		lblSPFVal.setText("");
		lblNineSpare.setText("");
		updateButtons();
	}
}
