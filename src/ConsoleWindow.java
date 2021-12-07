import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

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
        int buttonWidth = 80;
        int buttonHeight = 40;
        int LoginX = 50;
        int LoginY = 50;
        Random rand = new Random();
        setBounds(100, 100, frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(null);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(LoginX,LoginY,buttonWidth,buttonHeight);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(e.getX() < loginButton.getWidth()-1){
                    loginButton.setLocation(rand.nextInt(frameWidth-buttonWidth-60)+30,rand.nextInt(frameHeight-buttonHeight-60)+30);
                }
            }
        });
        mainPanel.add(loginButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(700,510,buttonWidth,buttonHeight);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.setLocation(LoginX,LoginY);
            }
        });
        mainPanel.add(cancelButton);

        add(mainPanel);
    }
}