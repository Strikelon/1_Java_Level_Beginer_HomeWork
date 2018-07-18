package hm7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_HUM_VS_HUM = 0;
    public static final int MODE_HUM_VS_AI = 1;

    private static final Random RANDOM = new Random();
    private static final int AI_DOT = 1;
    private static final int HUMAN_DOT = 2;
    private static final int EMPTY_DOT = 0;
    private static final int PADDING = 5;

    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUM = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String STR_HUM_WIN = "Победил игрок!";
    private static final String STR_AI_WIN = "Победил компьютер!";
    private static final String STR_DRAW = "Ничья!";

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean gameOver;
    private int stateGameOver;
    private boolean initialized;

    Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
                repaint();
            }
        });
        gameOver = true;
    }

    private void update(MouseEvent e) {
        if (gameOver) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY))
            return;
        field[cellY][cellX] = HUMAN_DOT;
        if (checkWin(HUMAN_DOT)) {
            stateGameOver = STATE_WIN_HUM;
            gameOver = true;
            return;
        }
        if (isMapFull()) {
            stateGameOver = STATE_DRAW;
            gameOver = true;
            return;
        }
        aiTurn();
        repaint();
        if (checkWin(AI_DOT)) {
            stateGameOver = STATE_WIN_AI;
            gameOver = true;
            return;
        }
        if (isMapFull()) {
            stateGameOver = STATE_DRAW;
            gameOver = true;
        }

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeY = fieldSizeY;
        this.fieldSizeX = fieldSizeX;
        this.winLength = winLen;
        field = new int[fieldSizeY][fieldSizeX];
        gameOver = false;
        initialized = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!initialized) return;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight/ fieldSizeY;
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) continue;

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.drawLine(x*cellWidth+ PADDING, y*cellHeight+ PADDING, (x+1)*cellWidth-PADDING, (y+1)*cellHeight-PADDING);
                    g.drawLine((x+1)*cellWidth-PADDING, y*cellHeight+PADDING, x*cellWidth+PADDING, (y+1)*cellHeight-PADDING);
                } else if(field[y][x] == AI_DOT) {
                    g.setColor(new Color(255, 0, 0));
                    g.drawOval(x * cellWidth + PADDING,
                            y * cellHeight + PADDING,
                            cellWidth - PADDING * 2,
                            cellHeight - PADDING * 2);
                } else {
                    throw new RuntimeException("Can't recognize cell: " + field[y][x]);
                }
//
//                g.drawOval(x * cellWidth + PADDING,
//                        y * cellHeight + PADDING,
//                        cellWidth - PADDING * 2,
//                        cellHeight - PADDING * 2);
            }
        }
        if (gameOver) showOverMessage(g);
    }

    private void showOverMessage(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString(STR_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(STR_AI_WIN, 20, getHeight() / 2);
                break;
            case STATE_WIN_HUM:
                g.drawString(STR_HUM_WIN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unknown game over state: " + stateGameOver);
        }
    }

    // Ход компьютера
    private void aiTurn() {
        if(turnAIWinCell()) return;		// проверим, не выиграет-ли игрок на следующем ходу
        if(turnHumanWinCell()) return;	// проверим, не выиграет-ли комп на следующем ходу
        int x, y;
        do {							// или комп ходит в случайную клетку
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }
    // Проверка, может ли выиграть комп
    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {				// поставим нолик в каждую клетку поля по очереди
                    field[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) return true;	// если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    field[i][j] = EMPTY_DOT;			// если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }
    // Проверка, выиграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = HUMAN_DOT;			// поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {			// если игрок победит
                        field[i][j] = AI_DOT;			// поставить на то место нолик
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;			// в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }
    // проверка на победу
    private boolean checkWin(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {			// ползём по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, dot)) return true;	// проверим линию по х
                if (checkLine(i, j, 1, 1, winLength, dot)) return true;	// проверим по диагонали х у
                if (checkLine(i, j, 0, 1, winLength, dot)) return true;	// проверим линию по у
                if (checkLine(i, j, 1, -1, winLength, dot)) return true;	// проверим по диагонали х -у
            }
        }
        return false;
    }
    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        final int far_x = x + (len - 1) * vx;			// посчитаем конец проверяемой линии
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;	// проверим не выйдет-ли проверяемая линия за пределы поля
        for (int i = 0; i < len; i++) {					// ползём по проверяемой линии
            if (field[y + i * vy][x + i * vx] != dot) return false;	// проверим одинаковые-ли символы в ячейках
        }
        return true;
    }
    // ничья?
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    // ячейка-то вообще правильная?
    private boolean isValidCell(int x, int y) { return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY; }
    // а пустая?
    private boolean isEmptyCell(int x, int y) { return field[y][x] == EMPTY_DOT; }

}
