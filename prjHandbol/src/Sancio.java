

/**
 * \brief Representa una sancio que pot tenir un jugador
 * @file Sancio.java
 */
public class Sancio {
    
    public enum TipusSancio {
        Groga,
        Vermella,
        Exclusio
    }
    
    // Atributs ---------------------------------------------------------------
    
    /* \brief Representa el moment del partit en que se li ha posat la sancio al jugador, en minuts */
    private int _minut;
    
    /* \brief Representa la part del partit en que que s'ha posta la sancio al jugador */
    private int _part; 
    
    /* \brief tipus de sancio que ha rebut el jugador */
    private TipusSancio _tipus;
    
    // Constructors -----------------------------------------------------------
    
    
    /**
     * Construeix una nova Sancio
     * @param minut minut en que es produeix la sanció
     * @param part part en que es produeix la sanció
     * @param tipus Tipus de la sancio (Groga, Vermella o Exclusió)
     */
    public Sancio(int minut, int part, TipusSancio tipus){
        _minut=minut;
        _part=part;
        _tipus=tipus;
    }
    
    
    // Metodes Publics ---------------------------------------------------------
    
    /**
     * @pre True
     * @return El número enter que representa la part de la Sancio
     */
    public int getPart(){
        return _part;
    }
    
    /**
     * @pre True
     * @return El tipus de sancio (Groga, Vermella o Exclusio)
     */
    public TipusSancio getTipus(){
        return _tipus;
    }
}
