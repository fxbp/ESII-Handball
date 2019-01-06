
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author Francesc
 */
public class EntrenadorCSVParser implements CSVParser {

    final static int NOM=0;
    final static int COGNOM=1;
    final static int NUM_LLICENCIA=2;
    final static int EQUIP=3;
    
    private List<Equip> _equips;
    private SubjectArbitre _subject;
    
    public EntrenadorCSVParser(List<Equip> equips, SubjectArbitre subject){
        _equips = equips;
        _subject = subject;
    }
    
    
    @Override
    public Entrenador create(String linia, String separador) throws Exception {
       String camps[]=linia.split(separador);

       Entrenador result = new Entrenador(camps[NOM], camps[COGNOM], camps[NUM_LLICENCIA], Utils.obtenirIdentificable(_equips, camps[EQUIP]));
       result.setSubject(_subject);
       return result;
    }
    
    
    
    
    
}
