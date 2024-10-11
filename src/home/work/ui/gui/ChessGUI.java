package home.work.ui.gui;

import home.work.UI;
import home.work.game.client.GameClient;
import home.work.ui.gui.internal.Cell;
import home.work.ui.gui.internal.ChessMove;
import home.work.ui.gui.internal.Constants;
import home.work.ui.gui.internal.Sprites;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Optional;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;

public class ChessGUI implements UI {
    private final int IMG_SIZE = 64;
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private final JLabel[] chessBoardLabels = new JLabel[8];
    private final JLabel[] row = new JLabel[9];
    private final Cell[][] chessBoardSquares = new Cell[8][8];
    private final Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    public static final int BLACK = 1, WHITE = 0;

    private final ChessMove move;
    private final GameClient game;

    public ChessGUI(GameClient game) {
        initializeGui();
        move = new ChessMove(game, chessBoardSquares);
        this.game = game;
    }

    public final void initializeGui() {
        // create the images for the chess pieces
        createImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("replay") {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.addSeparator();
        tools.add(message);
        chessBoard = new JPanel(new GridLayout(9, 9));
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);
    }

    public final JComponent getGui() {
        return gui;
    }

    private void createImages() {
        try {
            BufferedImage bi = ImageIO.read(Objects.requireNonNull(getClass().getResource("internal/pngegg64.png")));
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * IMG_SIZE, ii * IMG_SIZE, IMG_SIZE, IMG_SIZE);
                }
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }

    /**
     * Initializes the icons of the initial chess board piece places
     */
    public final void setupNewGame() {
        move.reset();
        game.restartGame();
    }

    @Override
    public void printMessage(String message) {
        this.message.setText(message);
    }

    @Override
    public void setCell(String symbol, int line, int column) {
        if (chessBoardSquares[line][column] == null) {
            Cell b;
            if ((column % 2 == 1 && line % 2 == 1) || (column % 2 == 0 && line % 2 == 0)) {
                b = new Cell(move, Constants.WHITE);
            } else {
                b = new Cell(move, Constants.BLACK);
            }
            b.setActionCommand(column + ":" + line);
            chessBoardSquares[line][column] = b;
            chessBoard.add(b);
        }
        if (symbol != null) {
            Optional<Sprites> s = Sprites.fromString(symbol.substring(0, 1));
            int color = symbol.charAt(1) == 'w' ? WHITE : BLACK;
            s.ifPresent(sptires -> chessBoardSquares[line][column].setIcon(new ImageIcon(
                    chessPieceImages[color][sptires.ordinal()])));
            chessBoardSquares[line][column].repaint();
        } else {
            chessBoardSquares[line][column].setIcon(null);
//            chessBoardSquares[line][column].setEnabled(false);
        }
    }

    @Override
    public void setLabel(String label, int line) {
        if (chessBoardLabels[line] == null) {
            JLabel l = new JLabel(label, SwingConstants.CENTER);
            chessBoardLabels[line] = l;
            chessBoard.add(l);
        }
    }

    @Override
    public void setRow(String label) {
        String[] l = label.split(" ");
        for (int i = 0; i < l.length; i++) {
            if (row[i] == null) {
                JLabel ls = new JLabel(l[i], SwingConstants.CENTER);
                row[i] = ls;
                chessBoard.add(ls);
            }
        }
    }
}