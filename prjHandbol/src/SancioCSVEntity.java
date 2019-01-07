
import java.util.List;



/**
 *
 * @author fbullich
 */
public class SancioCSVEntity implements CSVEntity {
    
    final static int ID_JUGADOR=0;
    final static int TIPUS=1;
    final static int PART=2;
    final static int MINUT=3;
   
    
    private List<Jugador> _jugadors;
    
    public SancioCSVEntity(List<Jugador> jugadors){
        _jugadors = jugadors;
    }
    
    
    @Override
    public Sancio create(String linia, String separador) throws Exception {
       String camps[]=linia.split(separador);
       
       Jugador jugador = Utils.obtenirIdentificable(_jugadors, camps[ID_JUGADOR]);
       int minut = Integer.parseInt(camps[MINUT]);
       int part = Integer.parseInt(camps[PART]);
       
       Sancio result = new Sancio(minut, part, Utils.TipusSancio.valueOf(camps[TIPUS]));
       
       jugador.afegirSancioInicial(result);
      
       return result;
    }
}
