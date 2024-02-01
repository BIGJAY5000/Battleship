import java.util.Scanner;
public class Battleship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean done = false;
        boolean done2 = false;
        String s1;
        String s2;
        int row;
        int col;
        int len;
        int shoot;
        boolean horizontal;
        Board board = new Board();

        while (!done) {
            s1 = InputHelper.getNonZeroLenString(scan, "Choose: \na: Add Ship \nb: See Board \np: Play \nq: Quit Game");
            //input a
            if (s1.equalsIgnoreCase("a")) {
                System.out.println(board);
                row = InputHelper.getRangedInt(scan, "Please choose the row you would like the ship to be", 1, 10);
                col = InputHelper.getRangedInt(scan, "Please choose the column you would like the ship to be", 1, 10);
                len = InputHelper.getRangedInt(scan, "Please select the length of your ship [3-4]", 3, 4);
                horizontal = InputHelper.getYNConfirm(scan, "Select whether the ship is horizontal or not[Y/N]");
                if (board.addShip(row, col, len, horizontal)) {
                    System.out.println("Ship has been added to the board, call the UN!");
                } else {
                    System.out.println("You can't place a ship there lmfao");
                }
            }
            //input b
            else if (s1.equalsIgnoreCase("b")) {
                System.out.println(board);
            }
            //input p
            else if (s1.equalsIgnoreCase("p")) {
                if (board.foundShip(3) && board.foundShip(4)) {
                    System.out.println("Lets play shawty");
                    done = true;
                } else {
                    System.out.println("you need a ship of length 3 and 4 before starting silly goose");
                }
            } else if (s1.equalsIgnoreCase("q")) {
                done = true;
            }
        }
        while (!done2) {
            s2 = InputHelper.getNonZeroLenString(scan, "Choose: \ns: Shoot \nb: See Board \nq: Quit Game");

            if (s2.equalsIgnoreCase("s")) {
                row = InputHelper.getInt(scan, "Enter a row you want your shot to be in:");
                col = InputHelper.getInt(scan, "Enter a column you want your shot to be in:");
                shoot = board.shoot(row, col);
                if (shoot == -1) {
                    System.out.println("This board isn't the size of Wisconsin, invalid spot");
                } else if (shoot == 0) {
                    System.out.println("You couldn't hit the broad side of a barn with a tank if you tried, you missed");
                } else if (shoot == 1) {
                    System.out.println("you hit their ship, and KILLED THEM :(");
                    if (board.gameOver()) {
                        System.out.println("You win, like Oprah!");
                        System.out.println(board);
                        done2 = true;
                    }
                } else if (shoot == 2) {
                    System.out.println("The definition of insanity is doing the same thing over and over an expecting a different result, you already shot there point dexter");
                }
            }
                else if (s2.equalsIgnoreCase("b")) {
                    System.out.println(board);
                } else if (s2.equalsIgnoreCase("q")) {
                    done2 = true;
                }

        }
    }
}
