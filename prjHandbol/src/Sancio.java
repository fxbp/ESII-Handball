

/**
 * \brief Representa una sancio que pot tenir un jugador
 * @file Sancio.java
 */
public class Sancio {
    
    public enum TipusSancio {
        Groga,
        Vermella,
        Exclusio,
        Expulsio
    }
    
    // Atributs ---------------------------------------------------------------
    
    /* \brief Representa el moment del partit en que se li ha posat la sancio al jugador, en minuts */
    private int _minut;
    
    /* \brief Representa la part del partit en que que s'ha posta la sancio al jugador */
    private int _part; 
    
    /* \brief tipus de sancio que ha rebut el jugador */
    private TipusSancio _tipus;
    
    // Constructors -----------------------------------------------------------
    
    public Sancio(int minut, int part, TipusSancio tipus){
        _minut=minut;
        _part=part;
        _tipus=tipus;
    }
}
