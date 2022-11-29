import javax.swing.JFrame;

public class App {
    JFrame frame = new JFrame("Gentleman tic tac toe");
    TicTacToe testgame = new TicTacToe();

    
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        frame.setSize(800,700);
		frame.setVisible(true);
        // frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        long start;
        long end;
        long total = 0;
        for (int i = 0; i < 100; i++) {
            TicTacToe newgame = new TicTacToe();
            start = System.nanoTime();
            newgame.makebestmove();
            end = System.nanoTime();
            total += (end-start)/1000000;
        }
        System.out.println(total);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        testgame.makebestmove();
        drawboardtoconsole(testgame);
        
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

}
