import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

    public class SudokuGui {
    private JTextField[][] sudo;
    private Sudoku model;
 
         public SudokuGui(Sudoku model){
          this.model = model;
          JFrame fram = new JFrame("Solver");
          fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          fram.setLayout(new BorderLayout());
          JPanel gridPanel = new JPanel(new GridLayout(9, 9));
          JPanel buttonPanel = new JPanel();

          fram.add(gridPanel, BorderLayout.CENTER);
          fram.add(buttonPanel, BorderLayout.NORTH);
          
          ClearButton clearbutton = new ClearButton(model, this);
          SolveButton solvebutton = new SolveButton(model, this);
          buttonPanel.add(clearbutton);
          buttonPanel.add(solvebutton);
          
          sudo = new JTextField[9][9];
          for (int i = 0; i <9; i++){
        	  for (int j = 0; j < 9; j++){
        		  JTextField text = new JTextField(null, 4);
        		  sudo[i][j] = text;
        		  gridPanel.add(text);
        	  }
          }
          
          fram.setVisible(true);
		  fram.pack();

         }
         /**
          * updaterar Jtextfield
          */
         public void textUpdate(){
        	 for (int i = 0; i < 9; i++) {
     			for (int j = 0; j < 9; j++) {
     				if (model.get(i, j) == 0) {
     					sudo[i][j].setText(null);
     				} else {
     					sudo[i][j].setText(new Integer(model.get(i, j)).toString());
     				}
     			}
     		}
        	 
         }
         /**
          * uppdaterar Sudokumatrisen
          * @return
          */
         public boolean gridUpdate(){
     		for (int i = 0; i < 9; i++) {
    			for (int j = 0; j < 9; j++) {
    				if (!sudo[i][j].getText().equals("")) {
    					if (sudo[i][j].getText().length() == 1) {
    						Character value = sudo[i][j].getText().charAt(0);
    						if (value.compareTo('1') >= 0 && value.compareTo('9') <= 0) {
    							int nbr = value - '0';
    					
    							if(model.tryInt(i,j,nbr)){
        							model.set(i, j, nbr);
    							}else{
    		
    								JOptionPane.showMessageDialog(null, "Tyvärr fanns ingen lösning:( \n Vänligen väja två olika tal");
    							
    						  return false;
    							}
    						}
    					}
    				}
    			}
     		}
    		return true;
         } 
}

