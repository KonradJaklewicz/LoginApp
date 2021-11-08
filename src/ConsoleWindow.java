import javax.swing.*;
import java.awt.*;

public class ConsoleWindow extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try{
                    ConsoleWindow mainWindow = new ConsoleWindow();
                    mainWindow.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public ConsoleWindow() throws HeadlessException{
        this("App");
    }

    public ConsoleWindow(String title) throws HeadlessException{
        super(title);
        buildFrame();
    }

    protected void buildFrame(){
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout verticalGrid = new GridLayout(3,1);
        JPanel verticalPanel = new JPanel(verticalGrid);

        GridLayout horizontalGrid = new GridLayout(1,2);
        JPanel horizontalPanel = new JPanel(horizontalGrid);

        JTextField userField = new JTextField();
        verticalPanel.add(userField);

        JPasswordField passField = new JPasswordField();
        verticalPanel.add(passField);

        JButton cancelButton = new JButton("Cancel");
        horizontalPanel.add(cancelButton);

        JButton loginButton = new JButton("Login");
        horizontalPanel.add(loginButton);

        verticalPanel.add(horizontalPanel);
        add(verticalPanel);
    }
}
