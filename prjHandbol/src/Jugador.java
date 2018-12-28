

/**
 * \brief Representa un jugador del joc de handbol
 *  *   * @file Jugador.java
 */
public class Jugador extends Personatge{
  
    // Atributs ----------------------------------------------------------------
    
    
    /** \brief Pes en KG del jugador */
    private double _pes;
    
    /** \brief alçada en cm del Jugador*/
    private int _alcada;
    
    /** \brief dorsal del jugador durant el partit*/
    private int _dorsal;
    
    /** \brief numero de gols que ha fet el jugador durant el partit*/
    private int _gols;
    
    
    // Constructors -----------------------------------------------------------
    
    public Jugador(String id, String nom, String cognom, String numLlicencia, double pes, int alcada, int dorsal) {
        super(id, nom, cognom, numLlicencia);
        
        _pes=pes;
        _alcada=alcada;
        _dorsal=dorsal;
        _gols=0;
        
    }
    
    
    
    
    // Metodes Publics --------------------------------------------------------
    
    /**
     * \brief el Jugador s'anota un gol
     * @pre True
     * @post el nombre de gols del jugador ha estat incrementat en 1
     */
    public void anotarGol(){
        _gols++;
    }
    
}
