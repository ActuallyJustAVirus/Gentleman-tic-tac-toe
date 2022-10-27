import javax.swing.JFrame;

public class App {
    JFrame frame = new JFrame("Gentleman tic tac toe");

    
    public static void main(String[] args) throws Exception {
        App app = new App();
    }
    public App() {
        frame.setSize(800,700);
		frame.setVisible(true);
        // frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }
}
