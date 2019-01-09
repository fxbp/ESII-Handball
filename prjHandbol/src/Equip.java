
import java.util.HashMap;
import java.util.Map;



/**
 * \brief Representa un dels equips del joc de handbol
 * @file Equip.java
 */
public class Equip implements Identificable {
    
    // Atributs ---------------------------------------------------------------
    
    /** \brief identificador de l'equip */
    private String _idEquip;
    
    /** \brief ciutat d'on es l'equip */
    private String _ciutat;
    
    /** \brief nom oficial de l'equip */
    private String _nomEquip;
    
    /** \brief representa l'entrenador de l'equip */
    private Entrenador _entrenador;

    /** \brief representa els jugadors de la banqueta*/
    private Map<Integer,Jugador> _banqueta;
    
    /** \brief representa els jugadors que son a pista*/
    private Map<Integer,Jugador> _pista;
    
    
    // Constructors -----------------------------------------------------------
    
    /**
     * Construeix un nou Equip. S'haruà d'afegir la pista, banqueta i l'entrenador posteriorment
     * @param idEquip identificador de l'equip
     * @param nomEquip nom de l'equip
     * @param ciutat  ciutat de l'equip
     */
    public Equip(String idEquip, String nomEquip, String ciutat){
        _idEquip = idEquip;
        _nomEquip = nomEquip;
        _ciutat = ciutat;
        
        _pista = new HashMap();
        _banqueta = new HashMap();
    }
    
    
    // Metodes Publics ---------------------------------------------------------
        
    /**
     * @pre Cert
     * @post Ha afegit l'entrenador a l'equip
     * @param entrenador  Personatge entrenador actual de l'equip
     */
    public void setEntrenador(Entrenador entrenador){
        _entrenador = entrenador;
    }
    
    /**
     * @pre jugador != null
     * @post S'ha tret el jugador de la banqueta si hi era i s'ha posat a pista
     * @param jugador Jugador que es vol moura a la pista
     */
    public void moureAPista(Jugador jugador){
        int dorsal = jugador.getDorsal();
        if(_banqueta.containsKey(dorsal)){
            _banqueta.remove(dorsal);
        }
        if(!_pista.containsKey(dorsal)){
           _pista.put(dorsal, jugador);
        }
    }
    
    /**
     * @pre jugador != null
     * @post s'ha tret el jugador de pista i s'ha posat a banqueta si hi era
     * @param jugador jugador que ha d'anar a la banqueta
     */
    public void moureABanqueta(Jugador jugador){
         int dorsal = jugador.getDorsal();
        if(_pista.containsKey(dorsal)){
            _pista.remove(dorsal);
        }
        if(!_banqueta.containsKey(dorsal)){
           _banqueta.put(dorsal, jugador);
        }
    }
    
    /**
     * @pre jugador != nullç
     * @post s'ha tret el jugador de l'equip
     * @param jugador Jugador que s'ha de treure de l'equip
     */
    public void treureJugador(Jugador jugador){
       int dorsal = jugador.getDorsal();
        if(_banqueta.containsKey(dorsal)){
            _banqueta.remove(dorsal);
        }
        if(_pista.containsKey(dorsal)){
           _pista.remove(dorsal);;
        }
    }
    
    
    /**
     * @pre pista ha estat afegida
     * @param missatge String que s'envia als jugadors que estan a pista
     */
    public void enviarMissatgePista(String missatge) {
        enviarMissatge(missatge, _pista);
    }
    
    
    /**
     * @pre banqueta ha estat afegida
     * @post s'ha enviat el missatge a tots els jugadors que son a la banqueta
     * @param missatge String que s'envia als jugadors que estan a banqueta
     */
    public void enviarMissatgeBanqueta(String missatge) {
        enviarMissatge(missatge, _banqueta);
    }
    
    @Override
    public String toString()
    {
        return "Id "+ _idEquip + " Nom " + _nomEquip + " de " + _ciutat;
    }
    
    
    // Metodes Interficie identificable
    
    @Override
    public boolean hasID(String id){
        return _idEquip.equals(id);
    }
    
    // Metodes Privats --------------------------------------------------------
    
    /**
     * @pre missatge != null && desti !=null
     * @param missatge missatge que s'ha d'enviar als jugadors de desti
     * @param desti coleccio de jugadors que han de rebre el missatge
     */
    private void enviarMissatge(String missatge, Map<Integer,Jugador> desti){
        for(Jugador j : desti.values()){
            j.rebreMissatgeEntrenador(missatge);
        }
    }
}
