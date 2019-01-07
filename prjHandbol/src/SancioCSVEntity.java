
import java.util.List;



/**
 *
 * @author fbullich
 */
public class SancioCSVEntity implements CSVEntity {
    
    final static int EQUIP=0;
    final static int DORSAL=1;
    final static int TIPUS=2;
    final static int PART=3;
    final static int MINUT=4;
   
    
    private List<Equip> _equips;
    
    public SancioCSVEntity(List<Equip> equips){
        _equips = equips;
    }
    
    
    @Override
    public Sancio create(String linia, String separador) throws Exception {
       String camps[]=linia.split(separador);
       
       Equip equip = Utils.obtenirIdentificable(_equips, camps[EQUIP]);
       int minut = Integer.parseInt(camps[MINUT]);
       int part = Integer.parseInt(camps[PART]);
       int dorsal = Integer.parseInt(camps[DORSAL]);
       Sancio result = new Sancio(minut, part, Utils.TipusSancio.valueOf(camps[TIPUS]));
       
       equip.getJugador(dorsal).afegirSancioInicial(result);
      
       return result;
    }
}
