package napakalaki;

/**
 *
 * @author carlos
 */
public class Treasure {
    private String name;
    private int bonus;
    private int gold_coins;
    private TreasureKind treasure;
    
    
    Treasure(String n, int g, int bonus1, TreasureKind t){
        name=n;
        bonus=bonus1;
        gold_coins=g;
        treasure=t;
    }
    
    
    
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    public TreasureKind getType(){
        return treasure;
    }
}
