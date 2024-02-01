public class Board {
    public static void main(String[] args) {
        Board board = new Board();
    }
    private String [][] squares;

    public Board() {
        squares = new String[10][10];
        for (int c = 0; c < squares[0].length; c++) {
            for (int r = 0; r < squares.length; r++) {
                squares[r][c] = "-" + " ";
            }
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
        boolean validSpot = false;
        if (horizontal) {
            if (row <= 9 && row >= 0 && col <= 9 && col >= 0) {
                if (col + len <= 10) {
                    for (int c = col; c < col + len; c++) {
                        if (!squares[row - 1][c - 1].equals("-")) {
                            validSpot = true;
                        }
                    }
                    if (validSpot) {
                        for (int c = col; c < col + len; c++) {
                            squares[row - 1][c - 1] = "b";
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
                        if (!squares[r - 1][col - 1].equals("-")) {
                            validSpot = true;
                        }
                    }
                    if (validSpot) {
                        for (int r = row; r < col + len; r++) {
                            squares[r - 1][col - 1] = "b";
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
                } else if (count == len) {
                    shipFound = true;
                }
                else{
                    count = 0;
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
                else if (count == len) {
                    shipFound = true;
                }
                else{
                    count = 0;
                }
            }
        }
        if (count == len) {
            shipFound = true;
        }
        return shipFound;
    }
    public int shoot (int row, int col){
        int doggyBags = 0;
        if (row>= 0 && row<=10 && col>=0 && col<=10){
            if (squares[row - 1][col - 1].equals("-")){
                squares[row - 1][col - 1] = "m";
                doggyBags = 0;
            } else if(squares[row - 1][col - 1].equals("b")){
                squares[row - 1][col - 1] = "x";
                doggyBags = 1;
            } else if (squares[row - 1][col - 1].equals("x") || (squares[row - 1][col - 1].equals("m"))){
                doggyBags = 2;
            }
        } else{
            doggyBags = -1;
        }
        return doggyBags;
    }
    public boolean gameOver() {
        boolean over = true;
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[0].length; c++) {
                if (squares[r][c].equals("b")) {
                    over = false;
                    break;
                }
            }
        }
        return over;
    }
}
