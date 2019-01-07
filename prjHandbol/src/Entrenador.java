
import java.util.ArrayList;
import java.util.List;


/**
 * \brief Representa el personatge "Entrenador" de l'equip dins del joc de Handbol
 * @file Entrenador.java
 */
public class Entrenador extends Personatge
        implements ObserverArbitre{
    
    // Atributs ---------------------------------------------------------------
    
    /** \brief Representa la llista de missatges que l'entrenador pot enviar als jugadors del seu equip*/
    private List<Missatge> _missatges;
    
    /** \brief Representa l'objecte que fa de Subject en el patro observer de l'arbitre al qual es pot subscriure l'entrenador */
    private SubjectArbitre _subject;
    
    /** \brief Equip el que pertany l'entrenador */
    private Equip _equip;
    
    // Constructors -----------------------------------------------------------
    
    
    /**
     * Constructor de Entrenador, Crea un entrenador amb els parametres d'un personatge i la seva llista de missatges
     * @param nom nom de l'entrenador
     * @param cognom cognom de l'entrenador
     * @param numLlicencia numero de llicencia de l'entrenador
     * @param equip Equip el qual entrena
     */
    public Entrenador(String nom, String cognom, String numLlicencia, Equip equip) {
        super(nom, cognom, numLlicencia);
        
        _missatges = new ArrayList();
        _equip = equip;
    }
    
    
    
    // Metodes publics --------------------------------------------------------
    
    /**
    * @pre subject != null
    * @post S'ha assignat el subject del patro observer arbitre. L'entrenador sempre estara atent a l'arbitre en aquesta implementacio
    * @param subject Objecte al qual es pot subscriure l'observer
    */
    public void setSubject(SubjectArbitre subject){
        _subject=subject;
        _subject.subscriure(this);
    }
    
    
    /**
     * @pre missatge != null
     * @post s'ha afegit el missatge a l'entrenador
     * @param missatge missagte que l'entrenador pot donar als jugadors
     */
    public void addMissatge(Missatge missatge){
        
        _missatges.add(missatge);
    }
    
    
    // Metodes observer
    
    @Override
    public void updateAmonestacio(int dorsal, Utils.TipusSancio tipus, int part, int minut){
        // Realitzar les accions de l'entrenador segons 1 jugador seu ha estat sancionat
    }

    
    
    
}
