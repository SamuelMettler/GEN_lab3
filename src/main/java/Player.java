import java.util.ArrayList;

public class Player {
    private String name;
    private Piece owns;
    private ArrayList<Die> dice;
    private Board board;

    /**
     * Constructor of player
     * @param name : name of the player
     */
    Player(String name) {
        this.name = name;
    }

    /**
     * Get the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Emulate the turn of a player. Rolling the dice and changing square accordingly
     */
    public void takeTurn() {
        int totFV = 0;
        for (Die die : this.dice) {
            die.roll();
            totFV += die.getFaceValue();
        }
        if(totFV > 10){
            System.out.println(this.name + " rolled a magnificient " + totFV + " !");
        }
        else
            System.out.println(this.name + " rolled " + totFV + " !");

        Square oldLoc = this.owns.getLocation();
        Square newLoc = this.board.getSquare(oldLoc, totFV);
        this.owns.setLocation(newLoc);
        System.out.println("Moved from " + oldLoc.getName() + " to " + newLoc.getName());
    }

    /**
     * Give the player some dice to play with
     * @param dice : list of dice
     */
    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }

    /**
     * Give the player his piece
     * @param owns : the piece he owns
     */
    public void setPiece(Piece owns) {
        this.owns = owns;
    }

    /**
     * Get the piece of the player
     * @return his piece
     */
    public Piece getOwns(){
        return this.owns;
    }

    /**
     * Set the board on which the Player is playing
     * @param board : played on
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}
