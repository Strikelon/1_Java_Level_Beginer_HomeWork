package hm7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame{

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 450;
    private static final int WINDOW_POS_Y = 10;

    private Map map;
    private SettingsWindow settingsWindow;

    GameWindow(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Tic tac toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setResizable(false);

        JButton btnStart = new JButton("Start new game");
        JButton btnExit = new JButton("Exit");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1,2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        map = new Map();
        settingsWindow = new SettingsWindow(this);

        add(panelBottom, BorderLayout.SOUTH);
        add(map, BorderLayout.CENTER);

        setVisible(true);

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLen);
    }

}
