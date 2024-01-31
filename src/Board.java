
public class Board {
    public static void main(String[] args) {
        Board board = new Board();
    }
    private String [][] squares = new String[10][10];

    public Board(){
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                System.out.print("-" + " ");
            }
            System.out.println();
        }
    }

    public String toString(){
        String s = "";
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                s = s + (squares[r][c] + " ");
            }
            s = s + "\n";
        }
        return s;
    }

    public boolean addShip(int row,int col,int len,boolean horizontal){
        boolean validSpot = true;
        if (horizontal) {
            if (row <= 9 && row >= 0 && col <= 9 && col >= 0) {
                if (col + len <= 10) {
                    for (int c = col; c < col + len; c++) {
                        if (!squares[row][c].equals("-")) {
                            validSpot = false;
                        }
                    }
                    if (validSpot) {
                        for (int c = col; c < col + len; c++) {
                            squares[row][c] = "b";
                        }
                        return true;
                    }
                }

            }
        }
        else{
            if (row <= 9 && row >= 0 && col <= 9 && col >= 0) {
                if (row + len <= 10) {
                    for (int r = row; r < row + len; r++) {
                        if (!squares[r][col].equals("-")) {
                            validSpot = false;
                        }
                    }
                    if (validSpot) {
                        for (int r = row; r < col + len; r++) {
                            squares[r][col] = "b";
                        }
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public boolean foundShip(int len){
        boolean shipFound = false;
        int count = 0;
        for (int r = 0; r < squares.length; r++){
            count = 0;
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c].equals("b")) {
                    count++;
                }
            }
        }
        if (count == len) {
            shipFound = true;
        }
        for (int c = 0; c < squares.length; c++){
            count = 0;
            for (int r = 0; r < squares[0].length; r++) {
                if (squares[r][c].equals("b")) {
                    count++;
                }
            }
        }
        if (count == len) {
            shipFound = true;
        }
        return shipFound;
    }
    public int shoot(int row, int col) {
        int doggyBags = -1;
        if (row <= 10 && row > 0 && col <= 10 && col > 0) {
            if (squares[row - 1][col - 1].equals("-")) {
                squares[row - 1][col - 1] = "m";
                doggyBags = 0;
            }
            if (squares[row][col].equals("b")) {
                squares[row - 1][col - 1] = "x";
                doggyBags = 1;
            }
            if (squares[row - 1][col - 1].equals("m") || squares[row - 1][col - 1].equals("x")) {
                doggyBags = 2;
            }
        }
        return doggyBags;
    }
    public boolean gameOver() {
        boolean over = true;
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c] == "b") {
                    over = false;
                    break;
                }
            }
        }
        return over;
    }
}
