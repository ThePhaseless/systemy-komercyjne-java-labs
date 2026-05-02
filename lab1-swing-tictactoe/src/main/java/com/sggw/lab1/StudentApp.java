package com.sggw.lab1;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

public class StudentApp extends JFrame implements Runnable {
    @Override
    public void run() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student App - Tic Tac Toe");
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);

        Image icon = loadImage("/images/icon.png");
        if (icon != null) {
            setIconImage(icon);
        }

        setContentPane(new GamePanel());
        setVisible(true);
    }

    private Image loadImage(String path) {
        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            if (inputStream == null) {
                return null;
            }
            return ImageIO.read(inputStream);
        } catch (IOException exception) {
            return null;
        }
    }
}
