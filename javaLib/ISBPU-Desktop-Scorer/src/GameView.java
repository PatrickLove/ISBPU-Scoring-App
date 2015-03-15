import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.SwingConstants;

import com.ispbu.scoring.Frame;
import com.ispbu.scoring.Game;
import com.ispbu.scoring.GameScore;
import com.ispbu.scoring.Score;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Font;
import java.awt.Dimension;

public class GameView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7050565487881797181L;
	private JLabel[][] lblThrow = new JLabel[][] { new JLabel[2],
			new JLabel[2], new JLabel[2], new JLabel[2], new JLabel[2],
			new JLabel[2], new JLabel[2], new JLabel[2], new JLabel[2],
			new JLabel[3], };
	private JLabel[] lblScore = new JLabel[10];
	private JLabel lblTotal;
	private Game game;

	/**
	 * Create the panel.
	 */
	public GameView() {
		setMinimumSize(new Dimension(700, 50));
		setPreferredSize(new Dimension(800, 75));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(5dlu;default):grow"),
				ColumnSpec.decode("max(35dlu;default):grow(5)"),},
			new RowSpec[] {
				RowSpec.decode("max(5dlu;default):grow"),
				RowSpec.decode("max(10dlu;default):grow(3)"),}));

		lblThrow[0][0] = new JLabel();
		lblThrow[0][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[0][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[0][0], "1, 1, fill, fill");

		lblThrow[0][1] = new JLabel();
		lblThrow[0][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[0][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[0][1], "2, 1, fill, fill");

		lblThrow[1][0] = new JLabel();
		lblThrow[1][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[1][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[1][0], "3, 1, fill, fill");

		lblThrow[1][1] = new JLabel();
		lblThrow[1][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[1][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[1][1], "4, 1, fill, fill");

		lblThrow[2][0] = new JLabel();
		lblThrow[2][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[2][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[2][0], "5, 1, fill, fill");

		lblThrow[2][1] = new JLabel();
		lblThrow[2][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[2][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[2][1], "6, 1, fill, fill");

		lblThrow[3][0] = new JLabel();
		lblThrow[3][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[3][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[3][0], "7, 1, fill, fill");

		lblThrow[3][1] = new JLabel();
		lblThrow[3][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[3][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[3][1], "8, 1, fill, fill");

		lblThrow[4][0] = new JLabel();
		lblThrow[4][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[4][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[4][0], "9, 1, fill, fill");

		lblThrow[4][1] = new JLabel();
		lblThrow[4][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[4][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[4][1], "10, 1, fill, fill");

		lblThrow[5][0] = new JLabel();
		lblThrow[5][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[5][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[5][0], "11, 1, fill, fill");

		lblThrow[5][1] = new JLabel();
		lblThrow[5][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[5][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[5][1], "12, 1, fill, fill");

		lblThrow[6][0] = new JLabel();
		lblThrow[6][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[6][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[6][0], "13, 1, fill, fill");

		lblThrow[6][1] = new JLabel();
		lblThrow[6][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[6][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[6][1], "14, 1, fill, fill");

		lblThrow[7][0] = new JLabel();
		lblThrow[7][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[7][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[7][0], "15, 1, fill, fill");

		lblThrow[7][1] = new JLabel();
		lblThrow[7][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[7][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[7][1], "16, 1, fill, fill");

		lblThrow[8][0] = new JLabel();
		lblThrow[8][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[8][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[8][0], "17, 1, fill, fill");

		lblThrow[8][1] = new JLabel();
		lblThrow[8][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[8][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[8][1], "18, 1, fill, fill");

		lblThrow[9][0] = new JLabel();
		lblThrow[9][0].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[9][0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[9][0], "19, 1, fill, fill");

		lblThrow[9][1] = new JLabel();
		lblThrow[9][1].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[9][1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[9][1], "20, 1, fill, fill");

		lblThrow[9][2] = new JLabel();
		lblThrow[9][2].setHorizontalAlignment(SwingConstants.CENTER);
		lblThrow[9][2].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblThrow[9][2], "21, 1, fill, fill");

		lblTotal = new JLabel();
		lblTotal.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTotal, "22, 1, 1, 2, fill, fill");

		lblScore[0] = new JLabel();
		lblScore[0].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[0].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[0], "1, 2, 2, 1, fill, fill");

		lblScore[1] = new JLabel();
		lblScore[1].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[1].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[1], "3, 2, 2, 1, fill, fill");

		lblScore[2] = new JLabel();
		lblScore[2].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[2].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[2], "5, 2, 2, 1, fill, fill");

		lblScore[3] = new JLabel();
		lblScore[3].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[3].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[3], "7, 2, 2, 1, fill, fill");

		lblScore[4] = new JLabel();
		lblScore[4].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[4].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[4], "9, 2, 2, 1, fill, fill");

		lblScore[5] = new JLabel();
		lblScore[5].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[5].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[5], "11, 2, 2, 1, fill, fill");

		lblScore[6] = new JLabel();
		lblScore[6].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[6].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[6], "13, 2, 2, 1, fill, fill");

		lblScore[7] = new JLabel();
		lblScore[7].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[7].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[7], "15, 2, 2, 1, fill, fill");

		lblScore[8] = new JLabel();
		lblScore[8].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[8].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[8], "17, 2, 2, 1, fill, fill");

		lblScore[9] = new JLabel();
		lblScore[9].setHorizontalAlignment(SwingConstants.CENTER);
		lblScore[9].setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblScore[9], "19, 2, 3, 1, fill, fill");

	}

	public void setGame(Game g) {
		this.game = g;
		updateGame();
	}

	public void updateGame() {
		GameScore score = game.score();
		for (int i = 0; i < 10; i++) {
			Frame f = game.getFrame(i);
			String fStr = f.toString();
			lblThrow[i][0].setText(fStr.charAt(0) + "");
			lblThrow[i][1].setText(fStr.charAt(1) + "");
			if (f.isTenth()) {
				lblThrow[i][2].setText(fStr.charAt(2) + "");
			}
			lblScore[i].setText(score.getFrameScores()[i] + "");
		}
		lblTotal.setText(score.getTotalValue() + "");
	}

}
