
import java.util.List;


/**
 * \brief Representa el personatge "Entrenador" de l'equip dins del joc de Handbol
 * @file Entrenador.java
 */
public class Entrenador extends Personatge{
    
    // Atributs ---------------------------------------------------------------
    
    /** \brief Representa la llista de missatges que l'entrenador pot enviar als jugadors del seu equip*/
    private List<Missatge> _missatges;
    
    
    // Constructors -----------------------------------------------------------
    
    
    /**
     * Constructor de Entrenador, Crea un entrenador amb els parametres d'un personatge i la seva llista de missatges
     * @param id identificador de l'entrenador
     * @param nom nom de l'entrenador
     * @param cognom cognom de l'entrenador
     * @param numLlicencia numero de llicencia de l'entrenador
     * @param missatges llista de missatges que l'entrenador pot enviar als jugadors
     */
    public Entrenador(String id, String nom, String cognom, String numLlicencia, List<Missatge> missatges) {
        super(id, nom, cognom, numLlicencia);
        
        _missatges=missatges;
    }
    
}
