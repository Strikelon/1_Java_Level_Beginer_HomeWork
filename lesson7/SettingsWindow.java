package hm7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private GameWindow gameWindow;
    private JRadioButton humVsAi;
    private JRadioButton humVsHum;
    private JSlider slFieldSize;
    private JSlider slWinLength;

    SettingsWindow(GameWindow gameWindow){
        this.gameWindow=gameWindow;
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH/2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT/2;
        setLocation(posX,posY);
        setResizable(false);
        setTitle("New game settings");
        setLayout(new GridLayout(10,1));
        addGameModeControls();
        addGameControlsField();
        JButton btnStart = new JButton("Start right now");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnStartClick();
            }
        });
        add(btnStart);
    }

    private void addGameModeControls(){
        add(new JLabel("Choose game mode"));
        humVsAi= new JRadioButton("Human vs. AI");
        humVsHum = new JRadioButton("Human vs. Human");
        humVsAi.setSelected(true);
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVsAi);
        gameMode.add(humVsHum);
        add(humVsAi);
        add(humVsHum);
    }

    private void addGameControlsField(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX+MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX+MIN_WIN_LENGTH);
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX+slWinLength.getValue());
            }
        });
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue=slFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX+currentValue);
                slWinLength.setMaximum(currentValue);
            }
        });
        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slFieldSize);
        add(new JLabel("Choose winning length"));
        add(lbWinLength);
        add(slWinLength);
    }

    private void onBtnStartClick(){

        int mode;
        int fieldSizeX=slFieldSize.getValue();
        int winLen = slWinLength.getValue();

        if(humVsAi.isSelected()){
            mode=Map.MODE_HUM_VS_AI;
        }else if(humVsHum.isSelected()){
            mode=Map.MODE_HUM_VS_HUM;
        }else {
            throw new RuntimeException("Unexpected game mode!");
        }

        gameWindow.startNewGame(mode,fieldSizeX,fieldSizeX,winLen);
        setVisible(false);

    }

}
