import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicTacToe {
    short occupied = 0;
    short noughts = 0;
    short crosses = 0;
    boolean crossturn = true;

    final static public short draw = binaryToBase10("111 111 111");

    final static public short[] inarowstates = {
        binaryToBase10("111 000 000"),
        binaryToBase10("000 111 000"),
        binaryToBase10("000 000 111"),
        binaryToBase10("100 100 100"),
        binaryToBase10("010 010 010"),
        binaryToBase10("001 001 001"),
        binaryToBase10("001 010 100"),
        binaryToBase10("100 010 001")
    };

    final static public Short[] moves = {
        1 << 0,
        1 << 1,
        1 << 2,
        1 << 3,
        1 << 4,
        1 << 5,
        1 << 6,
        1 << 7,
        1 << 8
    };
    
    static public boolean checkthreeinarow(short board) {
        for (short inrow : inarowstates) {
            if ((board & inrow) == inrow) {
                return true;
            }
        }
        return false;
    }

    public boolean makemove(short move) {
        if ((move & occupied) != 0) {
            return false;
        }
        if (crossturn) {
            crosses |= move;
            crossturn = false;
        } else {
            noughts |= move;
            crossturn = true;
        }
        occupied |= move;
        return true;
    }

    public void makerandommove() { //dumb bot
        List<Short> list = Arrays.asList(moves);
        Collections.shuffle(list);
        Short[] allmoves = new Short[9];
        list.toArray(allmoves);
        for (short move : allmoves) {
            if (makemove(move)) {
                return;
            }
        }
        throw new Error();
    }

    public void makebestmove() { //clever bot
        byte bestscore;
        short bestmove = 0;
        if (crossturn) bestscore = -2;
        else bestscore = 2;

        for (short move : moves) {
            if ((move & occupied) == 0) {
                if (crossturn) {
                    byte score = minimax((short)(occupied | move), (short)(crosses | move), noughts, !crossturn);
                    if (score > bestscore) {
                        bestscore = score;
                        bestmove = move;
                    }
                } else {
                    byte score = minimax((short)(occupied | move), crosses, (short)(noughts | move), !crossturn);
                    if (score < bestscore) {
                        bestscore = score;
                        bestmove = move;
                    }
                }
            }
        }
        makemove(bestmove);
    }
    
    
    static public byte minimax(short all, short max, short min, boolean ismax) {
        if (ismax) {
            if (TicTacToe.checkthreeinarow(min)) {
                return 1;
            }
            if ((all & draw) == draw) return 0;
            byte bestscore = -2;
            
            for (short move : moves) {
                if ((move & all) == 0) {
                    byte score = minimax((short)(all | move), (short)(max | move), min, !ismax);
                    if (score > bestscore) {
                        bestscore = score;
                    }
                }
            }
            return bestscore;
        } else {
            if (TicTacToe.checkthreeinarow(max)) {
                return -1;
            }
            if ((all & draw) == draw) return 0;
            byte bestscore = 2;

            for (short move : moves) {
                if ((move & all) == 0) {
                    byte score = minimax((short)(all | move), max, (short)(min | move), !ismax);
                    if (score < bestscore) {
                        bestscore = score;
                    }
                }
            }
            return bestscore;
        }
    }

    final static short binaryToBase10(String binaryString) {
        String binstr = binaryString.replaceAll(" ", "");
        short val = 0;
        for (char c : binstr.toCharArray()) {
            val <<= 1;
            val += c-'0';
        }
        return val;
    }
}
