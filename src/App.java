import javax.swing.JFrame;

public class App {
    JFrame frame = new JFrame("Gentleman tic tac toe");
    game testgame = new game();

    
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        frame.setSize(800,700);
		frame.setVisible(true);
        // frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        for (short board : game.testwinstates) {
            System.out.println(game.checkthreeinarow(board)); 
        }
        long start;
        long end;
        drawboardtoconsole(testgame);
        start = System.nanoTime();
        testgame.makebestmove();
        end = System.nanoTime();
        System.out.println((end-start)/1000000);
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

    public void drawboardtoconsole(game game) {
        char[] board = new char[9];
        int i = 0;
        for (short move : game.moves) {
            if ((game.noughts & move) == move) {
                board[i] = 'O';
            } else if ((game.crosses & move) == move) {
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
