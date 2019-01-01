
import java.util.HashMap;
import java.util.Map;


/**
 * \brief Representa els jugadors que estan a la banqueta d'un equip
 * @file Banqueta.java
 */
public class Banqueta {
    
     // Atributs ---------------------------------------------------------------
   
    /* \brief Jugadors que estan a pista guardats en format  <DORSAL,JUGADOR> */
    private Map _jugadors;
    
    
    // Constructors ------------------------------------------------------------
    
    public Banqueta(){
        _jugadors = new HashMap();
    }
}
