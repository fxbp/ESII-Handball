
import java.util.HashMap;
import java.util.Map;


/**
 * \brief Representa els jugadors que estan a la banqueta d'un equip
 * @file Banqueta.java
 */
public class Banqueta {
    
    // Constants --------------------------------------------------------------
    
    final static int MAX_JUGADORS_BANQUETA=12;
    
    
    // Atributs ---------------------------------------------------------------
   
    /* \brief Jugadors que estan a pista guardats en format  <DORSAL,JUGADOR> */
    private Map _jugadors;
    
    
    // Constructors ------------------------------------------------------------
    
    public Banqueta(){
        _jugadors = new HashMap();
    }
    
    
    // Metodes Publics -------------------------------------------------------
    
    public boolean plena(){
        return _jugadors.size()>=MAX_JUGADORS_BANQUETA;
    }
    
    public void AfegirJugador(Jugador jug) throws Exception{
        if(plena())
            throw new Exception("La banqueta ja esta plena. Ho hi caben més jugadors");
        
        _jugadors.put(jug.getDorsal(), jug);
    }
    
    public void treureJugador(Jugador jug){
        if (_jugadors.containsKey(jug.getDorsal()))
            _jugadors.remove(jug.getDorsal());
    }
}
