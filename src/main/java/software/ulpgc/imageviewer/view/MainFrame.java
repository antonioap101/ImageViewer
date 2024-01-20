package software.ulpgc.imageviewer.view;

import software.ulpgc.imageviewer.interfaces.Command;
import software.ulpgc.imageviewer.interfaces.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final Map<String, Command> commands;

    public MainFrame()  {
        this.commands = new HashMap<>();
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(createImageDisplay());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }


    private Component createToolbar() {
        JPanel panel = new JPanel();

        panel.setBackground(new Color(0x939693));

        panel.add(createButton("<", "/assets/Left.png"));
        panel.add(createButton(">", "/assets/Right.png"));
        return panel;
    }


    private Component createButton(String label, String iconPath) {
        JButton button = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource(iconPath))));
        button.addActionListener(e -> commands.get(label).execute());

        button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(true);
        button.setOpaque(false);

        return button;
    }


    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }
}
