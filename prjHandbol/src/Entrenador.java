
import java.util.List;


/**
 * \brief Representa el personatge "Entrenador" de l'equip dins del joc de Handbol
 * @file Entrenador.java
 */
public class Entrenador extends Personatge{
    
    // Atributs ---------------------------------------------------------------
    
    /** \brief Representa la llista de missatges que l'entrenador pot enviar als jugadors del seu equip*/
    private List<Missatge> _missatges;
    
    
    private Equip _equip;
    
    // Constructors -----------------------------------------------------------
    
    
    /**
     * Constructor de Entrenador, Crea un entrenador amb els parametres d'un personatge i la seva llista de missatges
     * @param nom nom de l'entrenador
     * @param cognom cognom de l'entrenador
     * @param numLlicencia numero de llicencia de l'entrenador
     * @param missatges llista de missatges que l'entrenador pot enviar als jugadors
     * @param equip Equip el qual entrena
     */
    public Entrenador(String nom, String cognom, String numLlicencia, List<Missatge> missatges, Equip equip) {
        super(nom, cognom, numLlicencia);
        
        _missatges = missatges;
        _equip = equip;
    }
    
}
