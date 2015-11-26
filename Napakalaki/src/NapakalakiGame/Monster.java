package napakalaki;

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
    
    //Constructor
    Monster(String name, int level, BadConsequence bc, Prize price){
        setName(name);
        setCombatLevel(level);
        setBadConsequence(bc);
        setPrize(price);
    }
    
    // Modificadores
    private void setName(String name_1){
        name = name_1;
    }
    
    private void setCombatLevel(int combat_level){
        combatLevel = combat_level;
    }
    
    private void setBadConsequence(BadConsequence Bad_c){
        bc = Bad_c;
    }
    
    private void setPrize(Prize price_1){
        price = price_1;
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
    
    // Método Consulta monstruos con niveles igual o superior a 10
    public boolean LevelExceeding10(){
        if(combatLevel>=10)
            return true;
        else
            return false;
    }
    
    // Método Consulta monstruos cuyo mal rollo solo implique pérdida de niveles
    public boolean OnlyLevelsBadConsequence(){
        if((bc.getLevels()>0) && (bc.getNVisibleTreasures()==0) && (bc.getNHiddenTreasures()==0))
            return true;
        else
            return false;
    }
    
    // Método Consulta monstruos cuyo buen rollo tenga un nivel mayor que 1
    public boolean PrizeLevelsExceeding1(){
        if(price.getLevel()>1)
            return true;
        else
            return false;
    }
    
    /* Método Consulta monstruos cuyo mal rollo implique perdida de un determinado
    de tesoro ya sea visible u oculto */
    public boolean LoseSpecificTreasures(){
        if(bc.TieneTesoros())
            return true;
        else
            return false;
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
        return " Name = " + name + ". Levels = " + Integer.toString(combatLevel);
    }
    
    
}
