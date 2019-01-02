
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * \brief Representa el personatge Arbitre del partit del joc de Handbol
 * @file Arbitre.java
 */
public class Arbitre extends Personatge 
    implements SubjectArbitre {
    
    // Atributs ----------------------------------------------------------------
    
    /* \brief Reprsenta tots els objectes que observen l'aribre */
    private List<ObserverArbitre> _observers;
    
    
    // Constrctors -------------------------------------------------------------
    
    /**
     * Constructor per un arbitre
     * @param nom nom de l'arbitre
     * @param cognom cognom de l'arbitre
     * @param numLlicencia numero de llicencia de l'arbitre
     */
    public Arbitre(String nom, String cognom, String numLlicencia) {
        super( nom, cognom, numLlicencia);
        _observers = new ArrayList();
    }

    /**
     * @pre dorsal > 0 && tipus != null && part > 0 && minut > o
     * @post s'ha enviat la amonestacio al jugador corresponent
     * @param dorsal numero de dorsal del jugador amonestat
     * @param tipus tipus d'amonestació que rep el jugador
     * @param part part en que es produeix l'amonestació
     * @param minut minut en que es produeix l'amonestació
     * @throws Exception Si no es poden realitzar les operacions derivades de l'amonestacio al jugador
     */
    public void AmonestarJugador(int dorsal, Sancio.TipusSancio tipus, int part, int minut) throws Exception{
        // l'arbitre que amonesta rep la informació necessaria per fer-ho. S'utilitza l'observer i el jugador implicat realitzara les accions pertinents
        notificar(dorsal,tipus,part,minut);
        
    }
    
    
    // Metodes de la interficie Observer ---------------------------------------
    
    @Override
    public void subscriure(ObserverArbitre observer) {
        if(_observers.indexOf(observer) < 0);
            _observers.add(observer);
    }

    @Override
    public void desubscriure(ObserverArbitre observer) {
       int index = _observers.indexOf(observer);
       if (index>=0){
           _observers.remove(index);
       }
    }

    @Override
    public void notificar(int dorsal, Sancio.TipusSancio tipus, int part, int minut) throws Exception {
        Iterator itObservers = _observers.iterator();
        
        while (itObservers.hasNext()){
            ((ObserverArbitre)itObservers.next()).updateAmonestacio(dorsal, tipus, part, minut);
        }
    }
    
    
}
