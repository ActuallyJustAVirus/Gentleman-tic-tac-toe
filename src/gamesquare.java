import javax.swing.ImageIcon;
import javax.swing.JButton;

public class gamesquare extends JButton {
    public final short move;
    private final static ImageIcon cross = new ImageIcon("rsc/cross.png");
    private final static ImageIcon nought = new ImageIcon("rsc/nought.png");
    public TicTacToe currentgame;
    
    public gamesquare(short move, TicTacToe currentgame) {
        this.move = move;
        this.currentgame = currentgame;
        setText("");
    }
    public void update() {
        if ((currentgame.crosses & move) == move) {
            setText("");
            setIcon(cross);
        } else if ((currentgame.noughts & move) == move) {
            setText("");
            setIcon(nought);
        } else {
            String text;
            if (currentgame.crossturn) {
                byte score = TicTacToe.minimax((short)(currentgame.occupied | move), (short)(currentgame.crosses | move), currentgame.noughts, false);
                text = Byte.toString(score);
            } else {
                byte score = TicTacToe.minimax((short)(currentgame.occupied | move), currentgame.crosses, (short)(currentgame.noughts | move), true);
                text = Byte.toString(score);
            }
            setIcon(null);
            setText(text);
        }
    }
}
