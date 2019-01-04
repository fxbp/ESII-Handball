
/**
 * \brief Representa els jugadors que estan a la pista d'un equip
 * @file Pista.java
 */
public class Pista extends AgrupacioJugadors {
    // Constants --------------------------------------------------------------
    static final int MAX_JUGADORS_PISTA=7;
    
       
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor d'una nova Pista
     * @param equip Identifica l'equip del qual son els jugadors
     */
    public Pista(Equip equip){
        super(equip,MAX_JUGADORS_PISTA);
 
    }
          
}
