import javax.swing.*;
import java.awt.*;

public class GradeCalculator {
    public static void main (String [] args) {
        SwingUtilities.invokeLater(GradeCalculator::createWindow);
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Student Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField first = new JTextField();
        JTextField second = new JTextField();
        JTextField third = new JTextField();
        JButton calculate = new JButton("Calculate Average Grade");
        JLabel result = new JLabel("");
        JLabel gradeResult = new JLabel("");

        calculate.addActionListener(event -> {
            try {
                double a = Double.parseDouble(first.getText().trim());
                double b = Double.parseDouble(second.getText().trim());
                double c = Double.parseDouble(third.getText().trim());

                if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                    result.setText("Grades must be between 0 and 100.");
                    gradeResult.setText("");
                    return;
                }

                double average = ((a + b + c) / 3);

                if (average < 60) {
                    result.setText("Average Grade: " + average);
                    gradeResult.setText("You have an F, you should study harder!");
                }
                else if (average >= 60 && average < 70) {
                    result.setText("Average Grade: " + average);
                    gradeResult.setText("You have a D, you should study harder!");
                }
                else if (average >= 70 && average < 80) {
                    result.setText("Average Grade: " + average);
                    gradeResult.setText("You have a C, I suppose that's alright.");
                }
                else if (average >= 80 && average < 90) {
                    result.setText("Average Grade: " + average);
                    gradeResult.setText("You have a B, not bad!");
                }
                else if (average >= 90 && average < 100) {
                    result.setText("Average Grade: " + average);
                    gradeResult.setText("You have an A, keep up the good work!");
                }

            } catch (NumberFormatException ex) {
                result.setText("Enter three valid grades.");
                gradeResult.setText("");
            }
        });

        panel.add(first);
        panel.add(second);
        panel.add(third);
        panel.add(calculate);
        panel.add(result);
        panel.add(gradeResult);
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}