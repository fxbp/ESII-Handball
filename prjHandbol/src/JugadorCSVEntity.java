
import java.util.List;


/**
 *
 * @author fbullich
 */
public class JugadorCSVEntity implements CSVEntity{

    final static int NOM=0;
    final static int COGNOM=1;
    final static int NUM_LLICENCIA=2;
    final static int PES=3;
    final static int ALCADA=4;
    final static int TITULAR=5;
    final static int ROL=6;
    final static int DORSAL=7;
    final static int EQUIP=8;
    
    private List<Equip> _equips;
    private SubjectArbitre _subject;
    
    public JugadorCSVEntity(List<Equip> equips, SubjectArbitre subject){
        _equips = equips;
        _subject = subject;
    }
    
    
    @Override
    public Jugador create(String linia, String separador) throws Exception {
       String camps[]=linia.split(separador);
       
       Equip equip = Utils.obtenirIdentificable(_equips, camps[EQUIP]);
       Rol rol = Utils.obtenirRol(Utils.Rols.valueOf(camps[ROL]));
       double pes = Double.parseDouble(camps[PES]);
       int alcada = Integer.parseInt(camps[ALCADA]);
       int dorsal = Integer.parseInt(camps[DORSAL]);
       int titular = Integer.parseInt(camps[TITULAR]);
       Jugador result = new Jugador(camps[NOM], camps[COGNOM], camps[NUM_LLICENCIA], pes, alcada, dorsal,equip.getBanqueta(),equip.getPista(),rol);
       
       if (titular == 1){
           result.entrarPista();
       }
       else
           result.entrarBanqueta();
       
       result.setSubject(_subject);
       return result;
    }
    
}
