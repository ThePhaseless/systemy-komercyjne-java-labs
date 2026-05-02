package com.sggw.lab1;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private final TicTacToeGame game = new TicTacToeGame();
    private final JButton[] buttons = new JButton[9];
    private final JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
    private final Image backgroundImage = loadBackgroundImage();

    public GamePanel() {
        setLayout(new BorderLayout(16, 16));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        statusLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        statusLabel.setForeground(Color.WHITE);
        add(statusLabel, BorderLayout.NORTH);
        add(createBoard(), BorderLayout.CENTER);
        add(createFooter(), BorderLayout.SOUTH);

        updateView();
    }

    private JPanel createBoard() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(new EmptyBorder(20, 120, 20, 120));

        JPanel board = new JPanel(new GridLayout(3, 3, 12, 12));
        board.setOpaque(false);

        for (int i = 0; i < buttons.length; i++) {
            int index = i;
            JButton button = new JButton();
            button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
            button.setFocusPainted(false);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setBackground(new Color(255, 255, 255, 225));
            button.addActionListener(event -> handleMove(index));
            buttons[i] = button;
            board.add(button);
        }

        wrapper.add(board, BorderLayout.CENTER);
        return wrapper;
    }

    private JPanel createFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setOpaque(false);

        JButton restartButton = new JButton("Restart game");
        restartButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        restartButton.addActionListener(event -> {
            game.reset();
            updateView();
        });

        footer.add(restartButton, BorderLayout.CENTER);
        return footer;
    }

    private void handleMove(int index) {
        if (game.makeMove(index)) {
            updateView();
        }
    }

    private void updateView() {
        for (int i = 0; i < buttons.length; i++) {
            char value = game.getCell(i);
            buttons[i].setText(value == ' ' ? "" : String.valueOf(value));
            buttons[i].setEnabled(value == ' ' && !game.isFinished());
        }
        statusLabel.setText(game.getStatusText());
    }

    private Image loadBackgroundImage() {
        try (InputStream inputStream = getClass().getResourceAsStream("/images/background.png")) {
            if (inputStream == null) {
                return null;
            }
            return ImageIO.read(inputStream);
        } catch (IOException exception) {
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (backgroundImage != null) {
            graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            graphics.setColor(new Color(40, 60, 110));
            graphics.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
