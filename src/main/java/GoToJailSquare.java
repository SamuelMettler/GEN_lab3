public class GoToJailSquare extends Square {

    /**
     * Constructor of GoToJailSquare with its name
     * @param name
     */
    public GoToJailSquare(String name){
        super(name);
    }

    /**
     * When landed on the player will be send to jail
     * @param player player landing on this square
     */
    @Override
    public void landedOn(Player player) {
        player.getOwns().setLocation(player.getBoard().getPrison());
    }
}
