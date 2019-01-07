
/**
 *
 * @author Francesc
 */
public class ArbitreCSVEntity implements CSVEntity
{

    final static int NOM=0;
    final static int COGNOM=1;
    final static int NUM_LLICENCIA=2;
       
       
    @Override
    public  Arbitre create(String linia, String separador) throws Exception{
           
        String camps[]=linia.split(separador);
        return new Arbitre(camps[NOM],camps[COGNOM],camps[NUM_LLICENCIA]);
   }
    
}
