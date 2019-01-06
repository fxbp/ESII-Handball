
/**
 * \brief Representa els jugadors que estan a la banqueta d'un equip
 * @file Banqueta.java
 */
public class Banqueta extends AgrupacioJugadors {
    
    // Constants --------------------------------------------------------------
    
    final static int MAX_JUGADORS_BANQUETA=12;
    
    // Constructors ------------------------------------------------------------
        
    /**
     * \brief Construeix una nova Banqueta
     * @param equip Identifica l'equip del qual son els jugadors
     */
    public Banqueta(Equip equip){
        super(equip, MAX_JUGADORS_BANQUETA);
        
    }    
    
}
