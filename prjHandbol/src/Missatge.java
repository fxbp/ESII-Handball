
/**
 *
 * \brief Representa un missatge d'Entrenador
 * @file Missatge.java
 */
public class Missatge {
    
    // Atributs ---------------------------------------------------------------
    
    /** \brief identificador del missatge */    
    private String _id;
    
    /** \brief instruccio del missatge */
    private String _descripcio;
    
    // Constructors -----------------------------------------------------------
    
    
    /**
     * Constructor d'un missatge
     * @param id identificador del missatge
     * @param descripcio instruccio del missatge
     */
    public Missatge(String id, String descripcio){
        _id=id;
        _descripcio=descripcio;
    }
    
    @Override
    public String toString()
    {
        return _descripcio;
    }

}
