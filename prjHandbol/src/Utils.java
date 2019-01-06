
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author Francesc
 */
public class Utils {
    
    
    /**
     * @pre T implementa la interficie Identificable
     * @param <T> Objecte que implementa la interficie Identificable
     * @param llista llista de objectes on s'ha de buscar
     * @param id identificador que es fara servir per trobar l'objecte 
     * @return l'objecte de llista que comples o.hasID(id)
     * @throws Exception llança excepcio si no troba cap objecte que compleixi la condicio
     */
    public static <T> T obtenirIdentificable(List<T> llista, String id) throws Exception{
        Iterator it = llista.iterator();
        T result=null;
        while (it.hasNext() && !((Identificable)(result = (T)it.next())).hasID(id));
       
        if (result == null || !((Identificable)result).hasID(id)){
            throw new Exception("No s'ha trobat l¡equip corresponent");
        }
              
        return result;
    }
    
}
