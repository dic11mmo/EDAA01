import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SolveButton extends JButton implements ActionListener{
	private Sudoku model;
	private SudokuGui sudo;
	
	public SolveButton(Sudoku model, SudokuGui sudo){
		super("Solve");
		this.model = model;
		this.sudo = sudo;
		addActionListener(this);
	}
	/**
	 * Om Sudokumatrisen inte ska uppdateras och Sudoku model ska inte gå att lösas Skriver ut fel
	 */
	public void actionPerformed(ActionEvent e) {
		if (sudo.gridUpdate()) {
			if (model.solve()) {
				sudo.textUpdate();
			} else {
				System.out.println("Det finns Fel");
			}
		}
	}
}