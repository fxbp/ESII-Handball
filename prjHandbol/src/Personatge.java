

/**
 * \brief Representa un personatge qualsevol identificat i amb numero de llicencia
 * @file Personatge.java
 */
public abstract class Personatge implements Identificable {
    
    //Atributs ----------------------------------------------------------------
    
    /** \brief nom del personatge */
    private String _nom;
    /** \brief cognom del personatge */
    private String _cognom;
    /** \brief numero de llicencia del personatge */
    private String _numLlicencia;
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Constructor de la classe abstracta per que el cridin les subclases
     * @param nom nom del personatge
     * @param cognom cognom del personatge
     * @param numLlicencia numero de llicencia del personatge
     */
    public Personatge( String nom, String cognom, String numLlicencia){
        _nom=nom;
        _cognom=cognom;
        _numLlicencia=numLlicencia;
    }
    
   

    // Metodes Interficie Identificable
    
    @Override
    public boolean hasID(String id) {
       return _numLlicencia.equals(id);
    }
       
}
