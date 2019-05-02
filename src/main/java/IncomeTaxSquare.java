import static java.lang.Math.min;

public class IncomeTaxSquare extends Square {
    // The max amount we can grab from the player
    private final int MAXTOPAY = 200;

    /**
     * Constructor of IncomeTaxSquare with its name
     * @param name
     */
    public IncomeTaxSquare(String name){
        super(name);
    }


    /**
     * When landed on the player will lose money because of tax
     * @param player player landing on
     */
    @Override
    public void landedOn(Player player) {
        int worth = player.getNetWorth();
        // Reduce player's money by choosing the minimum between 10% of the player's NetWorth or value MAXTOPAY (200)
        player.reduceCash(min(worth / 10, MAXTOPAY));
    }
}
