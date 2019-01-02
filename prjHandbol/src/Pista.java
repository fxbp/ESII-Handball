
import java.util.HashMap;
import java.util.Map;



/**
 * \brief Representa els jugadors que estan a la pista d'un equip
 * @file Pista.java
 */
public class Pista {
    // Constants --------------------------------------------------------------
    static final int MAX_JUGADORS_PISTA=7;
    
    
    // Atributs ---------------------------------------------------------------
   
    /* \brief Jugadors que estan a pista guardats en format  <DORSAL,JUGADOR> */
    private Map _jugadors;
    
    
    // Constructors ------------------------------------------------------------
    
    public Pista(){
        _jugadors = new HashMap();
 
    }
    
    // Metodes publics ----------------------------------------------------------
    
    public boolean plena(){
        return _jugadors.size()>=MAX_JUGADORS_PISTA;
    }
    
    public void AfegirJugador(Jugador jug) throws Exception{
        if(plena())
            throw new Exception("La pista ja esta plena. Ho hi caben més jugadors");
        _jugadors.put(jug.getDorsal(), jug);
    }
    
    public void treureJugador(Jugador jug){
        if (_jugadors.containsKey(jug.getDorsal()))
            _jugadors.remove(jug.getDorsal());
    }   
    
}
