
/**
 * \brief Representa el personatge Arbitre del partit del joc de Handbol
 * @file Arbitre.java
 */
public class Arbitre extends Personatge  {
    
    // Atributs ----------------------------------------------------------------
    
    private Comite _comite;
    
    
    // Constrctors -------------------------------------------------------------
    
    /**
     * Constructor per un arbitre
     * @param nom nom de l'arbitre
     * @param cognom cognom de l'arbitre
     * @param numLlicencia numero de llicencia de l'arbitre
     */
    public Arbitre(String nom, String cognom, String numLlicencia) {
        super( nom, cognom, numLlicencia);
        _comite = Comite.getInstance();
    }

    /**
     * @pre dorsal > 0 && tipus != null && part > 0 && minut > o
     * @post s'ha enviat la amonestacio al jugador corresponent
     * @param dorsal numero de dorsal del jugador amonestat
     * @param idEquip identificador de l'equip del jugador
     * @param tipus tipus d'amonestació que rep el jugador
     * @param part part en que es produeix l'amonestació
     * @param minut minut en que es produeix l'amonestació
     * @throws Exception Si no es poden realitzar les operacions derivades de l'amonestacio al jugador
     */
    public void AmonestarJugador(int dorsal, String idEquip, Utils.TipusSancio tipus, int part, int minut) throws Exception{
        // l'arbitre que amonesta rep la informació necessaria per fer-ho. S'utilitza l'observer i el jugador implicat realitzara les accions pertinents
        _comite.registrarAmonestacio(dorsal, idEquip, tipus, part, minut);
        
    }
    
    
   
    
    
}
