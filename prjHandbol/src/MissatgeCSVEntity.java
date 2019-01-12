
import java.util.List;


/**
 *
 * @author Francesc
 */
public class MissatgeCSVEntity implements CSVEntity{
    
    final static int ENTRENADOR=0;
    final static int ID=1;
    final static int DESCRIPCIO=2;
    
    
    private List<Entrenador> _entrenadors;
    private SubjectArbitre _subject;
    
    public MissatgeCSVEntity(List<Entrenador> entrenadors){
       _entrenadors = entrenadors;
    }
    
    
    @Override
    public Missatge create(String linia, String separador) throws Exception {
       String camps[]=linia.split(separador);

       Missatge result = new Missatge(camps[ID], camps[DESCRIPCIO]);
       Entrenador entrenador = Utils.obtenirIdentificable(_entrenadors, camps[ENTRENADOR]);
       entrenador.addMissatge(result);
       return result;
    }
    
}
