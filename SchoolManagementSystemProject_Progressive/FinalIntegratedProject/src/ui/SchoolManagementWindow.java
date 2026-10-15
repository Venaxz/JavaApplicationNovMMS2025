package ui;
import service.StudentService;
import javax.swing.*;
import java.awt.*;
public class SchoolManagementWindow {
    private final StudentService service;
    public SchoolManagementWindow(StudentService service) { this.service=service; }
    public void showWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame=new JFrame("School Management System");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTextArea output=new JTextArea(18,70); output.setEditable(false);
            JButton refresh=new JButton("Refresh Student List");
            refresh.addActionListener(e -> output.setText(service.getAllStudents().isEmpty() ? "No students registered." : String.join("\n", service.getAllStudents().stream().map(Object::toString).toList())));
            frame.add(new JScrollPane(output), BorderLayout.CENTER); frame.add(refresh, BorderLayout.SOUTH);
            frame.pack(); frame.setLocationRelativeTo(null); frame.setVisible(true); refresh.doClick();
        });
    }
}
