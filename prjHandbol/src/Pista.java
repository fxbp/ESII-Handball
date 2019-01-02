
import java.util.HashMap;
import java.util.Iterator;
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
    
    /* \brief Equip dels jugadors que conte la Pista */
    private Equip _equip;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor d'una nova Pista
     * @param equip Identifica l'equip del qual son els jugadors
     */
    public Pista(Equip equip){
        _jugadors = new HashMap();
        _equip = equip;
 
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
    
    /**
     * @pre Cert
     * @post S'ha enviat missatge a tots els jugadors 
     * @param missatge String que s'ha d'enviar als jugadors
     */
    public void enviarMissatge(String missatge){
        Iterator itJugadors= _jugadors.values().iterator();
        
        while(itJugadors.hasNext()){
            ((Jugador)itJugadors.next()).rebreMissatgeEntrenador(missatge);
        }
    }
}
