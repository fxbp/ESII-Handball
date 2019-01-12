
import java.util.List;


/**
 *
 * @author fbullich
 */
public class PartitCSVEntity implements CSVEntity {
    
    
    final static int ID=0;
    final static int DATA=1;
    final static int HORA=2;
    final static int ARBITRE1=3;
    final static int ARBITRE2=4;
    final static int LOCAL = 5;
    final static int VISITANT = 6;
    final static int MINUT = 7;
    final static int PART = 8;
   
    private List<Arbitre> _arbitres;
    private List<Equip> _equips;
    
    public PartitCSVEntity(List<Arbitre> arbitres, List<Equip> equips){
        _equips = equips;
        _arbitres = arbitres;
    }
    
    
    @Override
    public Partit create(String linia, String separador) throws Exception {
       String camps[]=linia.split(separador);
       
       Equip local = Utils.obtenirIdentificable(_equips, camps[LOCAL]);
       Equip visitant = Utils.obtenirIdentificable(_equips, camps[VISITANT]);
       Arbitre arbitre1 = Utils.obtenirIdentificable(_arbitres, camps[ARBITRE1]);
       Arbitre arbitre2 = Utils.obtenirIdentificable(_arbitres, camps[ARBITRE2]);   
       int minut = Integer.parseInt(camps[MINUT]);
       int part = Integer.parseInt(camps[PART]);
       Partit result = new Partit(camps[ID],camps[DATA], camps[HORA], part, minut, arbitre1, arbitre2, local, visitant);
            
      
       return result;
    }
    
}
