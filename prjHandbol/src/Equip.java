

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
    private Banqueta _banqueta;
    
    /** \brief representa els jugadors que son a pista*/
    private Pista _pista;
    
    
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
        
        _pista = new Pista(this);
        _banqueta = new Banqueta(this);
    }
    
    
    // Metodes Publics ---------------------------------------------------------
    
    
    public Jugador getJugador(int dorsal){
        Jugador result = null;
        
        result = _pista.getJugador(dorsal);
        if (result == null){
           result = _banqueta.getJugador(dorsal);
        }
        
        
        return result;
    }
    
    /**
     * @pre Cert
     * @return la Banqueta de l'equip
     */
    public Banqueta getBanqueta(){
         return _banqueta;
    }
    
    /**
     * @pre Cert
     * @return la pista de l'equip
     */
    public Pista getPista(){
        return _pista;
    }
    
    /**
     * @pre Cert
     * @post Ha afegit l'entrenador a l'equip
     * @param entrenador  Personatge entrenador actual de l'equip
     */
    public void setEntrenador(Entrenador entrenador){
        _entrenador = entrenador;
    }
    
    /**
     * @pre pista ha estat afegida
     * @param missatge String que s'envia als jugadors que estan a pista
     * @throws Exception si la pista no està afegida o es null no es pot enviar el missatge
     */
    public void EnviarMissatgePista(String missatge) throws Exception{
        if (_pista == null)
            throw new Exception("La pista no està assignada a l'equip");
        _pista.enviarMissatge(missatge);
    }
    
    /**
     * @pre banqueta ha estat afegida
     * @post s'ha enviat el missatge a tots els jugadors que son a la banqueta
     * @param missatge String que s'envia als jugadors que estan a banqueta
     * @throws Exception Si la banqueta no està afegida o és null no es pot enviar el missatge
     */
    public void EnviarMissatgeBanqueta(String missatge) throws Exception{
        if (_banqueta == null)
            throw new Exception("La banqueta no està assignada a l'equip");
        _banqueta.enviarMissatge(missatge);
    }
    
    
    // Metodes Interficie identificable
    
    @Override
    public boolean hasID(String id){
        return _idEquip.equals(id);
    }
}
