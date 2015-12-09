package NapakalakiGame;

/**
 *
 * @author carlos
 */
public class Monster {
    // Atributos privados
    private String name;
    private int combatLevel;
    private BadConsequence bc;
    private Prize price;
    
    // Para sectario
    private int levelChangeAgainstCultistPlayer=0;
    
    //Constructor
    Monster(String name, int level, BadConsequence bc, Prize price){
        this.name=name;
        this.combatLevel=level;
        this.bc=bc;
        this.price=price;
        levelChangeAgainstCultistPlayer=0;
    }
    
    Monster(String name, int level, BadConsequence bc, Prize price, int LC){
        this.name=name;
        this.combatLevel=level;
        this.bc=bc;
        this.price=price;
        levelChangeAgainstCultistPlayer=LC;
    }
   
    
    //Consultores
    public String getName(){  //Consultor de Name
        return name;
    }
    
    public int getCombatLevel(){  //Consultor de CombatLevel
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){  //Consultor de BadConsequence
        return bc;
    }
    
    public Prize getPrize(){  //Consultor de Prize
        return price;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return (combatLevel+levelChangeAgainstCultistPlayer);
    }
    
    public int getLevelsGained(){
        return price.getLevel();
    }
    
    public int getTreasuresGained(){
        return price.getTreasure();
    }
    
    // Método toString
    @Override   //Estamos sobreescibribiendo un método padre de Java
    public String toString(){
        return name + ". Nivel: " + Integer.toString(combatLevel);
    }
    
    
}
