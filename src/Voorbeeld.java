import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Voorbeeld {
    public static int count = 0;
    public static String[][] board = new String[3][3];

    public static void buttonClicked(JButton button) {
        if(button.getText().equals("")) {
            count++;
            if(count % 2 == 1) {
                button.setText("X");
            }
            if(count % 2 == 0) {
                button.setText("O");
            }
        }
    }


    public static void gameRules(JButton button) {
        //"X" or "O"?
        String string = button.getText();

        //Gives coordinates of the button
        int x = Character.getNumericValue(button.getName().charAt(0));
        int y = Character.getNumericValue(button.getName().charAt(1));
        board[x][y] = string;

        //diagonal
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            JOptionPane.showMessageDialog(null,string + " won.");

        }

        //other diagonal
        else if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            JOptionPane.showMessageDialog(null,string + " won.");

        }

        //draw?
        else if(count==9) {
            JOptionPane.showMessageDialog(null,"draw.");

        }

        else {

            //row
            for(int i = 0; i < 3; i++) {
                if(board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                    JOptionPane.showMessageDialog(null,string + " won.");

                }
            }

            //column
            for(int j = 0; j < 3; j++) {
                if(board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                    JOptionPane.showMessageDialog(null,string + " won.");

                }
            }
        }
    }
}