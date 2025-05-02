import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form {
    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Registration Form");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 180, 25);
        frame.add(nameField);

        JLabel nameError = new JLabel();
        nameError.setBounds(150, 50, 200, 15);
        nameError.setForeground(Color.RED);
        frame.add(nameError);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 25);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 180, 25);
        frame.add(emailField);

        JLabel emailError = new JLabel();
        emailError.setBounds(150, 90, 200, 15);
        emailError.setForeground(Color.RED);
        frame.add(emailError);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 110, 100, 25);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 180, 25);
        frame.add(passField);

        JLabel passError = new JLabel();
        passError.setBounds(150, 130, 200, 15);
        passError.setForeground(Color.RED);
        frame.add(passError);

        // Confirm Password
        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setBounds(30, 150, 120, 25);
        frame.add(confirmLabel);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(150, 150, 180, 25);
        frame.add(confirmField);

        JLabel confirmError = new JLabel();
        confirmError.setBounds(150, 170, 200, 15);
        confirmError.setForeground(Color.RED);
        frame.add(confirmError);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 100, 30);
        frame.add(registerButton);

        // Success Message
        JLabel successLabel = new JLabel();
        successLabel.setBounds(100, 240, 300, 25);
        successLabel.setForeground(new Color(0, 128, 0));
        frame.add(successLabel);

        // Action Listener for Register Button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset errors
                nameError.setText("");
                emailError.setText("");
                passError.setText("");
                confirmError.setText("");
                successLabel.setText("");

                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = new String(passField.getPassword());
                String confirmPassword = new String(confirmField.getPassword());

                boolean valid = true;

                if (name.isEmpty()) {
                    nameError.setText("Name is required");
                    valid = false;
                }

                if (email.isEmpty()) {
                    emailError.setText("Email is required");
                    valid = false;
                } else if (!email.contains("@")) {
                    emailError.setText("Invalid email format");
                    valid = false;
                }

                if (password.isEmpty()) {
                    passError.setText("Password is required");
                    valid = false;
                }

                if (confirmPassword.isEmpty()) {
                    confirmError.setText("Confirm your password");
                    valid = false;
                } else if (!password.equals(confirmPassword)) {
                    confirmError.setText("Passwords do not match");
                    valid = false;
                }

                if (valid) {
                    successLabel.setText("Registration successful!");
                }
            }
        });

        frame.setVisible(true);
    }
}
