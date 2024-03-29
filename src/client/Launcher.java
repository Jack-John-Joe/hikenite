import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("hikenite launcher");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 75);

            // Create a panel with a PLAY NOW button
            JPanel panel = new JPanel();
            JButton playButton = new JButton("PLAY NOW");
            playButton.setFont(new Font("Ubuntu Sans", Font.BOLD, 20));
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Process process = Runtime.getRuntime().exec("cd .. && cd hikenite && java hikenite.class"); // it refused to run launch.sh
                        process.waitFor();
                    } catch (IOException | InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            panel.add(playButton);

            // Add the panel to the frame
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
