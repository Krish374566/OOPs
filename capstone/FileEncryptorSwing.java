import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryptorSwing extends JFrame {

    private JTextField pathField;
    private JComboBox<String> actionBox;

    public FileEncryptorSwing() {
        setTitle("File/Folder Encryptor");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        pathField = new JTextField(35);
        JButton browseFileButton = new JButton("Browse File");
        JButton browseFolderButton = new JButton("Browse Folder");
        String[] actions = {"Encrypt", "Decrypt"};
        actionBox = new JComboBox<>(actions);
        JButton executeButton = new JButton("Execute");

        add(new JLabel("File/Folder Path:"));
        add(pathField);
        add(browseFileButton);
        add(browseFolderButton);
        add(actionBox);
        add(executeButton);

        browseFileButton.addActionListener(e -> browseFile());
        browseFolderButton.addActionListener(e -> browseFolder());
        executeButton.addActionListener(e -> processAction());
    }

    private void browseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            pathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void browseFolder() {
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = folderChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            pathField.setText(folderChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void processAction() {
        String path = pathField.getText();
        String action = (String) actionBox.getSelectedItem();

        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid path.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File file = new File(path);
        if (file.isFile()) {
            if ("Encrypt".equals(action)) {
                encryptFile(file);
            } else {
                decryptFile(file);
            }
        } else if (file.isDirectory()) {
            if ("Encrypt".equals(action)) {
                encryptFolder(file);
            } else {
                decryptFolder(file);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid path.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    private void saveKey(SecretKey key, File keyFile) throws IOException {
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        Files.write(keyFile.toPath(), encodedKey.getBytes());
    }

    private SecretKey loadKey(File keyFile) throws IOException {
        byte[] encoded = Files.readAllBytes(keyFile.toPath());
        byte[] decoded = Base64.getDecoder().decode(encoded);
        return new SecretKeySpec(decoded, 0, decoded.length, "AES");
    }

    private void encryptFile(File file) {
        try {
            SecretKey key = generateKey();
            File keyFile = new File(file.getAbsolutePath() + "_key.txt");
            saveKey(key, keyFile);

            byte[] data = Files.readAllBytes(file.toPath());
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(data);
            Files.write(file.toPath(), encrypted);

            JOptionPane.showMessageDialog(this, "File encrypted successfully!\nKey saved as: " + keyFile.getAbsolutePath());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Encryption failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void decryptFile(File file) {
        try {
            File keyFile = new File(file.getAbsolutePath() + "_key.txt");
            SecretKey key = loadKey(keyFile);

            byte[] encrypted = Files.readAllBytes(file.toPath());
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(encrypted);
            Files.write(file.toPath(), decrypted);

            JOptionPane.showMessageDialog(this, "File decrypted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Decryption failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void encryptFolder(File folder) {
        try {
            SecretKey key = generateKey();
            File keyFile = new File(folder.getAbsolutePath() + "_key.txt");
            saveKey(key, keyFile);

            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    byte[] data = Files.readAllBytes(file.toPath());
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    byte[] encrypted = cipher.doFinal(data);
                    Files.write(file.toPath(), encrypted);
                }
            }

            JOptionPane.showMessageDialog(this, "Folder encrypted successfully!\nKey saved as: " + keyFile.getAbsolutePath());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Folder encryption failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void decryptFolder(File folder) {
        try {
            File keyFile = new File(folder.getAbsolutePath() + "_key.txt");
            SecretKey key = loadKey(keyFile);

            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    byte[] encrypted = Files.readAllBytes(file.toPath());
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    byte[] decrypted = cipher.doFinal(encrypted);
                    Files.write(file.toPath(), decrypted);
                }
            }

            JOptionPane.showMessageDialog(this, "Folder decrypted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Folder decryption failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FileEncryptorSwing().setVisible(true);
        });
    }
}