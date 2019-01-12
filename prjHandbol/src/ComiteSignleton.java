
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Francesc
 */
public class ComiteSignleton  implements SubjectArbitre {
    
    
    // Atributs ----------------------------------------------------------------
    
    /** \breif Instancia unica del comite Per fer el singleton. Es pot inicialitzar al inici perque no ocupa molta memoria*/    
    private static ComiteSignleton _instanciaUnica = new ComiteSignleton();
    
     /* \brief Reprsenta tots els objectes que observen les decicions arbitrals */
    private List<ObserverArbitre> _observers;
    
    
    
    // Constructors ------------------------------------------------------------
    
    /**
     * \brief Crea un nou comite.
     * @pre True
     * @post Ha creat un nou comite
     */
    private ComiteSignleton(){
        _observers = new ArrayList();
    }
    
    
    
    // Metodes publics ---------------------------------------------------------
    
    
    /**
     * \brief El comite registra la amonestacio realitzant les accions pertinents
     * @pre dorsal > 0 && tipus != null && part > 0 && minut > 0
     * @post Ha registrat l'amonestacio
     * @param dorsal dorsal del jugador a qui s'ha amonestat
     * @param idEquip identificador del equip del jugador
     * @param tipus tipus d'amonestacio
     * @param part part en la qual s'ha realitzat l'amonestacio
     * @param minut minut en el qual s'ha realitzat l'amonestacio
     * @throws Exception si no es poden realitzar correctament les accions
     */
    public void registrarAmonestacio(int dorsal, String idEquip, Utils.TipusSancio tipus, int part, int minut) throws Exception {
        notificar(dorsal, idEquip, tipus, part, minut);
    }
    
    
    
    
    // Metodes estatics Singleton ---------------------------------------------
    
    public static ComiteSignleton getInstance(){
        return _instanciaUnica;
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
    public void notificar(int dorsal, String idEquip,Utils.TipusSancio tipus, int part, int minut) throws Exception {
        Iterator itObservers = _observers.iterator();
        
        while (itObservers.hasNext()){
            ((ObserverArbitre)itObservers.next()).updateAmonestacio(dorsal, idEquip, tipus, part, minut);
        }
    }
    
}
