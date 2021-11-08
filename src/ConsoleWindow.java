import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public ArrayList<String> loginData = new ArrayList<>();
    public ArrayList<String> passwordData = new ArrayList<>();

    public ConsoleWindow() throws HeadlessException {
        this("App");
    }

    public ConsoleWindow(String title) throws HeadlessException {
        super(title);
        loginData.add("Konrad");
        passwordData.add("123");
        loginData.add("Piotr");
        passwordData.add("qwerty");
        loginData.add("admin");
        passwordData.add("abcdefgh");
        buildFrame();
    }

    protected void buildFrame() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GridLayout mainGrid = new GridLayout(1, 2);
        mainGrid.setVgap(50);
        mainGrid.setHgap(50);
        JPanel mainPanel = new JPanel(mainGrid);

        GridLayout verticalGrid2 = new GridLayout(3, 1);
        verticalGrid2.setVgap(50);
        verticalGrid2.setHgap(50);
        JPanel verticalPanelLeft = new JPanel(verticalGrid2);

        GridLayout verticalGrid3 = new GridLayout(3, 1);
        verticalGrid3.setVgap(50);
        verticalGrid3.setHgap(50);
        JPanel verticalPanelRight = new JPanel(verticalGrid3);

        GridLayout horizontalGrid = new GridLayout(1, 2);
        horizontalGrid.setHgap(20);
        JPanel horizontalPanel = new JPanel(horizontalGrid);

        verticalPanelLeft.add(new JLabel("User name"));
        JTextField loginField = new JTextField();
        verticalPanelRight.add(loginField);

        verticalPanelLeft.add(new JLabel("Password"));
        JPasswordField passField = new JPasswordField();
        verticalPanelRight.add(passField);

        JButton cancelButton = new JButton("Cancel");
        horizontalPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginField.setText("");
                passField.setText("");
            }
        });

        JButton loginButton = new JButton("Login");
        horizontalPanel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    if (loginField.getText().equals(loginData.get(i))) {
                        if (passField.getText().equals(passwordData.get(i))) {
                            JOptionPane.showMessageDialog(null,
                                    "Udało się zalogować",
                                    "Komunikat",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null,
                        "Nie udało się zalogować",
                        "Komunikat",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        verticalPanelRight.add(horizontalPanel);
        mainPanel.add(verticalPanelLeft);
        mainPanel.add(verticalPanelRight);
        add(mainPanel);
    }
}