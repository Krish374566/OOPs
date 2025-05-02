import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Text field for task input
        JTextField taskField = new JTextField();
        frame.add(taskField, BorderLayout.NORTH);

        // List model and JList
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add task action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Remove selected task(s)
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndices = taskList.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    taskListModel.removeElementAt(selectedIndices[i]);
                }
            }
        });

        frame.setVisible(true);
    }
}
