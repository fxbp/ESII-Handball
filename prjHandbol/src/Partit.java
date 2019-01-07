
/**
 * \brief Representa el partit del joc de handbol
 * @file Partit.java
 */
public class Partit {
    
    // Atributs ----------------------------------------------------------------
    
    /** \brief identificador del partit*/
    private String _idPartit;
    
    /** \brief data d'inici del partit en format string*/
    private String _dataInici;
    
    /** \brief hora d'inici del partit en format string*/
    private String _horaInici;
    
    /** \brief representa el minut actual del partit*/
    private int _minut;
    
    /** \brief representa la part actual del partit     */
    private int _part;
    
     /** \brief representa el primer arbitre del partit*/
    private Arbitre _primerArbitre;
    
    
     /** \brief representa el segon arbitre del partit*/
    private Arbitre _segonArbitre;
    
     /** \brief Representa l'equip local del partit*/
    private Equip _local;
    
     /** \brief representa l'equip visitant del partit*/    
    private Equip _visitant;
    
    
    // Constructors ----------------------------------------------------------
    
    public Partit(String id, String data, String hora, int part, int minut, Arbitre primerArbitre, Arbitre segonArbitre, Equip local, Equip visitant){
        _idPartit = id;
        _dataInici = data;
        _horaInici = hora;
        _part = part;
        _minut = minut;
        _primerArbitre = primerArbitre;
        _segonArbitre = segonArbitre;
        _local = local;
        _visitant = visitant;
    }
}
