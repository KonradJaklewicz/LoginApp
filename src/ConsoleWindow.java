import javax.swing.*;
import java.awt.*;

public class ConsoleWindow extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConsoleWindow mainWindow = new ConsoleWindow();
                    mainWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }


    public ConsoleWindow() throws HeadlessException {
        this("App");
    }

    public ConsoleWindow(String title) throws HeadlessException {
        super(title);
        buildFrame();
    }

    protected void buildFrame() {
        int frameWidth = 800;
        int frameHeight = 600;
        setBounds(100, 100, frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canva mainCanva = new Canva();
        add(mainCanva);
    }
}