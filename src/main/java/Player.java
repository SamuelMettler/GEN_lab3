public class Player {
    private String name;
    private Piece owns;
    private Cup cup;
    private Board board;
    private int cash;

    /**
     * Constructor of player
     * @param name : name of the player
     */
    Player(String name) {
        this.name = name;
        this.cash = 1500;
    }

    /**
     * Get the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Emulate the turn of a player. Rolling the cup and changing square accordingly
     */
    public void takeTurn() {
        this.cup.roll();
        int totFV = this.cup.getTotal();

        if(totFV > 10){
            System.out.println('\n' + this.name + " rolled a magnificient " + totFV + " !");
        }
        else System.out.println('\n' + this.name + " rolled " + totFV + " !");

        Square oldLoc = this.owns.getLocation();
        Square newLoc = this.board.getSquare(oldLoc, totFV);
        this.owns.setLocation(newLoc);
        this.owns.getLocation().landedOn(this);

        System.out.println("Moved from " + oldLoc.getName() + " to " + newLoc.getName());
        if(newLoc != this.owns.getLocation()){
            System.out.println("Stop right there, you criminal scum !");
            System.out.println("Moved from " + newLoc.getName() + " to " + this.owns.getLocation().getName());
        }

    }

    /**
     * Give the player some cup to play with
     * @param cup : list of cup
     */
    public void setCup(Cup cup) {
        this.cup = cup;
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

    /**
     * Function to increment current Cash with givn param
     * @param amount amount to add
     */
    public void addCash(int amount){
        this.cash += amount;
    }

    /**
     * Function to decrement the current cash with given param
     * @param amountToPay amount to substract to current cash
     */
    public void reduceCash(int amountToPay) {
        this.cash -= amountToPay;
    }

    /**
     * Getter for the board
     * @return the board of the player
     */
    public Board getBoard(){
        return this.board;
    }

    /**
     * Get the current cash of this player
     * @return amount in the bank
     */
    public int getNetWorth() {
        return this.cash;
    }
}
