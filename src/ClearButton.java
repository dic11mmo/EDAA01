import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener{
	private Sudoku model;
	private SudokuGui sudo;
	
	public ClearButton(Sudoku model, SudokuGui sudo){
		super("Clear");
		this.model = model;
		this.sudo = sudo;
		addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		model.Clear();
		sudo.textUpdate();
	}
}