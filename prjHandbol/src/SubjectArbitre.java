

/**
 * \brief Interficie que farà de subject en el Patro Observer per el cas de les notificacions de l'arbitre
 * @file SubjectArbitre.java
 */
public interface SubjectArbitre {
    
    /**
     * @pre observer != null
     * @post Ha afegit observer als objectes a notificar
     * @param observer objecte observador que vol ser notificat
     */
    public void subscriure(ObserverArbitre observer);    
   
    /**
     * @pre observer != null
     * @post Ha eliminat observer dels observadors a notificar
     * @param observer observador que ja no vol rebre notificacions
     */
    public void desubscriure(ObserverArbitre observer);
    
    /**
     * @pre dorsal > 0 && tipus != null && part > 0 && minut > 0
     * @post Ha enviat la notificacio a tots els observers subscrits
     * @param dorsal dorsal del jugador a qui s'ha amonestat
     * @param tipus tipus d'amonestacio
     * @param part part en la qual s'ha realitzat l'amonestacio
     * @param minut minut en el qual s'ha realitzat l'amonestacio
     * @throws Exception si no es poden realitzar correctament les accions
     */
    public void notificar(int dorsal, Sancio.TipusSancio tipus, int part, int minut) throws Exception;
}
