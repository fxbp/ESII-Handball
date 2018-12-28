

/**
 * \brief Representa un personatge qualsevol identificat i amb numero de llicencia
 * @file Personatge.java
 */
public abstract class Personatge {
    
    //Atributs ----------------------------------------------------------------
    
    /** \brief identificador del personatge */
    private String _id;
    /** \brief nom del personatge */
    private String _nom;
    /** \brief cognom del personatge */
    private String _cognom;
    /** \brief numero de llicencia del personatge */
    private String _numLlicencia;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor de la classe abstracta per que el cridin les subclases
     * @param id identificador del personatge
     * @param nom nom del personatge
     * @param cognom cognom del personatge
     * @param numLlicencia numero de llicencia del personatge
     */
    public Personatge(String id, String nom, String cognom, String numLlicencia){
        _id=id;
        _nom=nom;
        _cognom=cognom;
        _numLlicencia=numLlicencia;
    }
    
    
       
}
