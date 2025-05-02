import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch {
    private static int elapsedTime = 0;
    private static Timer timer;

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Stopwatch");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Time display label
        JLabel timeLabel = new JLabel("Elapsed Time: 0 s");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(timeLabel);

        // Start button
        JButton startButton = new JButton("Start");
        frame.add(startButton);

        // Stop button
        JButton stopButton = new JButton("Stop");
        frame.add(stopButton);

        // Reset button
        JButton resetButton = new JButton("Reset");
        frame.add(resetButton);

        // Timer: Fires every 1000 ms (1 second)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                timeLabel.setText("Elapsed Time: " + elapsedTime + " s");
            }
        });

        // Start action
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        // Stop action
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        // Reset action
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                elapsedTime = 0;
                timeLabel.setText("Elapsed Time: 0 s");
            }
        });

        frame.setVisible(true);
    }
}
