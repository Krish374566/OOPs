import javax.swing.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(120, 30, 165, 25);
        frame.add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(120, 70, 165, 25);
        frame.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 80, 25);
        frame.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(30, 140, 250, 25);
        frame.add(messageLabel);

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    messageLabel.setText("Login successful!");
                } else {
                    messageLabel.setText("Invalid username or password.");
                }
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
