import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    JFrame frame = new JFrame("Gentleman tic tac toe");
    TicTacToe currentgame = new TicTacToe();
    JButton Bnewgame = new JButton("New Game");
    JButton Bmakebestmove = new JButton("Make Best Move");
    JButton Bmakerandommove = new JButton("Make Random move");

    // JPanel main
    JPanel buttonpanel = new JPanel();
    JPanel tttpanel = new JPanel();

    
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        frame.setSize(800,700);
        buttonpanel.add(Bnewgame, BorderLayout.WEST); buttonpanel.add(Bmakebestmove, BorderLayout.CENTER); buttonpanel.add(Bmakerandommove, BorderLayout.EAST);
        Bnewgame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                currentgame = new TicTacToe();
                for (Component c : tttpanel.getComponents()) {
                    if (c instanceof gamesquare) {
                        gamesquare square = (gamesquare) c;
                        square.currentgame = currentgame;
                    }
                }
                update();
            }
        });
        Bmakebestmove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                currentgame.makebestmove();
                update();
            }
        });
        Bmakerandommove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                currentgame.makerandommove();
                update();
            }
        });

        frame.add(buttonpanel,BorderLayout.NORTH); frame.add(tttpanel, BorderLayout.CENTER);
        tttpanel.setLayout(new GridLayout(3,3));
        for (short move : TicTacToe.moves) {
            gamesquare square = new gamesquare(move,currentgame);
            square.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    currentgame.makemove(move);
                    update();
                }
            });
            tttpanel.add(square);
        }
		frame.setVisible(true);
        // frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // timer
        // long start;
        // long end;
        // long total = 0;
        // for (int i = 0; i < 1; i++) {
        //     TicTacToe newgame = new TicTacToe();
        //     start = System.nanoTime();
        //     newgame.makebestmove();
        //     end = System.nanoTime();
        //     total += (end-start)/1000000;
        // }
        // System.out.println(total);


        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        // testgame.makebestmove();
        // drawboardtoconsole(testgame);
        
        // System.out.println(testgame.occupied+","+testgame.noughts+","+testgame.crosses);
    }

    public void drawboardtoconsole(TicTacToe Game) {
        char[] board = new char[9];
        int i = 0;
        for (short move : TicTacToe.moves) {
            if ((Game.noughts & move) == move) {
                board[i] = 'O';
            } else if ((Game.crosses & move) == move) {
                board[i] = 'X';
            } else {
                board[i] = ' ';
            }
            i++;
        }
        System.out.println(board[0]+"|"+board[1]+"|"+board[2]);
        System.out.println(board[3]+"|"+board[4]+"|"+board[5]);
        System.out.println(board[6]+"|"+board[7]+"|"+board[8]);
        System.out.println("");
    }

    public void update() {
        for (Component c : tttpanel.getComponents()) {
            if (c instanceof gamesquare) {
                gamesquare square = (gamesquare) c;
                square.update();
            }
        }
    }

}
