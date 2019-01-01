
import java.sql.Time;
import java.util.Date;



/**
 * \brief Representa el partit del joc de handbol
 * @file Partit.java
 */
public class Partit {
    
    // Atributs ----------------------------------------------------------------
    
    /** \brief identificador del partit*/
    private String _idPartit;
    
    /** \brief data d'inici del partit*/
    private Date _dataInici;
    
    /** \brief hora d'inici del partit*/
    private Time _horaInici;
    
    /** \brief representa el temps transcorregut del partit en segons*/
    private int _rellotge;
    
     /** \brief representa el primer arbitre del partit*/
    private Arbitre _primerArbitre;
    
    
     /** \brief representa el segon arbitre del partit*/
    private Arbitre _segonArbitre;
    
     /** \brief Representa l'equip local del partit*/
    private Equip _local;
    
     /** \brief representa l'equip visitant del partit*/    
    private Equip _visitant;
    
}
