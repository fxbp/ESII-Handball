
/**
 *
 * \brief Interficie que farà de observer en el Patro Observer per el cas de les notificacions de l'arbitre
 * @file ObserverArbitre.java
 */
public interface ObserverArbitre {
    
    /**
     * @pre tipus != null && minut > 0 && part > 0
     * @post S'ha enviat la amonestació als observadors
     * @param dorsal dorsal del jugador a qui s'ha amonestat
     * @param tipus tipus d'amonestacio
     * @param part part en la qual s'ha realitzat l'amonestacio
     * @param minut minut en el qual s'ha realitzat l'amonestacio
     * @throws Exception si no es pot amonestar correctament
     */
    public void updateAmonestacio(int dorsal, Utils.TipusSancio tipus, int part, int minut) throws Exception;
}
