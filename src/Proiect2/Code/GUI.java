package Proiect2.Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    private ChessBoard chessBoard;
    private List<BoardPoz> boardPoz;
    private JButton button;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;


    public GUI() {
        super("Chess");
        chessBoard = new ChessBoard();
        boardPoz = new ArrayList<>();
        initGUI();
    }


    private void setImage(JLabel label, String url) {
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        Image image1 = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image1));
    }


    private void g(JLabel label) {
        label.setText("*");
    }


    private void initGUI() {
        button = new JButton("Muta");
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        Label label1 = new Label("X:");
        Label label2 = new Label("Y:");
        Label label3 = new Label("XTo:");
        Label label4 = new Label("YTo:");


        button.setBounds(680, 140, 130, 25);
        textField1.setBounds(680, 10, 130, 25);
        textField2.setBounds(680, 40, 130, 25);
        textField3.setBounds(680, 70, 130, 25);
        textField4.setBounds(680, 100, 130, 25);

        label1.setBounds(650, 10, 20, 25);
        label2.setBounds(650, 40, 20, 25);
        label3.setBounds(640, 70, 30, 25);
        label4.setBounds(640, 100, 30, 25);

        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("src\\Proiect2\\Image\\Tabla.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentPane(new ImagePanel(myImage));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(850, 650);


        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                movePiece(Integer.parseInt(textField1.getText()),
                        Integer.parseInt(textField2.getText()),
                        Integer.parseInt(textField3.getText()),
                        Integer.parseInt(textField4.getText())
                );
            }

        });


        boolean l = true;
        boolean colorPionA = true;
        boolean colorPionN = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JLabel label = new JLabel("");
                int x = 64 * i + 13 * i;
                int y = 64 * j + 13 * j;

                label.setBounds(x, y, 64, 64);


                if (j == 1) {
                    if (colorPionA) {
                        setImage(label, "src\\Proiect2\\Image\\PionAlb.png");
                        colorPionA = false;
                    } else {
                        setImage(label, "src\\Proiect2\\Image\\PionAlb.png");
                        colorPionA = true;

                    }
                } else if (j == 6) {
                    if (colorPionN) {
                        setImage(label, "src\\Proiect2\\Image\\PionNegru.png");
                        colorPionN = false;
                    } else {
                        setImage(label, "src\\Proiect2\\Image\\PionNegru.png");
                        colorPionN = true;

                    }

                } else if (j == 0) {
                    if (i == 0 || i == 7) {
                        setImage(label, "src\\Proiect2\\Image\\TuraAlba.png");
                    } else if (i == 1 || i == 6) {
                        setImage(label, "src\\Proiect2\\Image\\CalAlb.png");
                    } else if (i == 2 || i == 5) {
                        setImage(label, "src\\Proiect2\\Image\\NebunAlb.png");
                    } else if (i == 3) {
                        setImage(label, "src\\Proiect2\\Image\\RegeAlb.png");
                    } else {
                        setImage(label, "src\\Proiect2\\Image\\ReginaAlba.png");
                    }

                } else if (j == 7) {
                    if (i == 0 || i == 7) {
                        setImage(label, "src\\Proiect2\\Image\\TuraNeagra.png");
                    } else if (i == 1 || i == 6) {
                        setImage(label, "src\\Proiect2\\Image\\CalNegru.png");
                    } else if (i == 2 || i == 5) {
                        setImage(label, "src\\Proiect2\\Image\\NebunNegru.png");
                    } else if (i == 3) {
                        setImage(label, "src\\Proiect2\\Image\\RegeNegru.png");
                    } else {
                        setImage(label, "src\\Proiect2\\Image\\ReginaNeagra.png");
                    }

                }

                add(label);
                boardPoz.add(new BoardPoz(label, i, j));

                chessBoard.getPiece(i, j).setjLabel(label);
            }


        }


        add(button);
        add(textField1);
        add(textField2);
        add(textField3);
        add(textField4);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        setVisible(true);
    }

    private void movePiece(int x, int y, int toX, int toY) {
        try {
            if (chessBoard.getPiece(x, y).getName().equals("Pion Alb")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\PionAlb.png");
            } else if (chessBoard.getPiece(x, y).getName().equals("Pion Negru")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\PionNegru.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Tura Alba")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\TuraAlba.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Tura Neagra")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\TuraNeagra.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Cal Alb")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\CalAlb.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Cal Negru")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\CalNegru.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Nebun Alb")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\NebunAlb.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Nebun Negru")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\NebunNegru.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Regina Alba")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\ReginaAlba.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Regina Neagra")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\ReginaNeagra.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Rege Alb")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Image\\RegeAlb.png");
            }else if (chessBoard.getPiece(x, y).getName().equals("Rege Negru")) {

                setImage(chessBoard.getPiece(x, y).getjLabel(), null);
                setImage(chessBoard.getPiece(toX, toY).getjLabel(), "src\\Proiect2\\Imagea\\RegeNegru.png");
            }
        } catch (NullPointerException e) {

        }

    }


    private class ImagePanel extends JComponent {
        private Image image;

        public ImagePanel(Image image) {
            this.image = image;
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }
}
