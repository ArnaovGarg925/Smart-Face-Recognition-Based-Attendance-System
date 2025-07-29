import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Face Attendance System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start Attendance");
        startButton.addActionListener(e -> {
            FaceDetector.startCamera();
        });

        frame.add(startButton);
        frame.setVisible(true);
    }
}
