package Proiect2.Code;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    private int width = 8;
    private int height = 8;
    private List<Piece> pieceList;

    public ChessBoard() {
        pieceList = new ArrayList<>();
        initBoard();
    }

    private void initBoard() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if (j == 1) {
                    Piece piece = new Piece("Pion Alb");
                    piece.setPoint(i, j);
                    pieceList.add(piece);
                } else if (j == 6) {
                    Piece piece = new Piece("Pion Negru");
                    piece.setPoint(i, j);
                    pieceList.add(piece);
                } else if (j == 0) {
                    if (i == 0 || i == 7) {
                        Piece piece = new Piece("Tura Alba");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else if (i == 1 || i == 6) {
                        Piece piece = new Piece("Cal Alb");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else if (i == 2 || i == 5) {
                        Piece piece = new Piece("Nebun Alb");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else if (i == 3) {
                        Piece piece = new Piece("Rege Alb");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else {
                        Piece piece = new Piece("Regina Alba");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    }
                } else if (j == 7) {
                    if (i == 0 || i == 7) {
                        Piece piece = new Piece("Tura Neagra");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else if (i == 1 || i == 6) {
                        Piece piece = new Piece("Cal Negru");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else if (i == 2 || i == 5) {
                        Piece piece = new Piece("Nebun Negru");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else if (i == 3) {
                        Piece piece = new Piece("Rege Negru");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    } else {
                        Piece piece = new Piece("Regina Neagra");
                        piece.setPoint(i, j);
                        pieceList.add(piece);
                    }
                } else {
                    Piece piece = new Piece("Spatiu");
                    piece.setPoint(i, j);
                    pieceList.add(piece);
                }
            }
        }
    }


    public List<Piece> getPieceList() {
        return pieceList;
    }

    public Piece getPiece(int x, int y) {
        Piece p = null;
        for (Piece piece : pieceList) {
            if (piece.getPoint().getY() == y && piece.getPoint().getX() == x) {
                p = piece;
                //    System.out.println(x + ": " + y);
            }
        }
        return p;
    }
}
