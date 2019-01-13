
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Francesc
 */
public class Utils {
    
    public enum Rols{
        CentralAvancat,
        CentralCentre,
        CentralDret,
        CentralEsquerra,
        ExtremDret,
        ExtremEsquerra,
        LateralDret,
        LateralEsquerra,
        Pivot,
        Porter
    }
    
    public enum TipusSancio {
        Groga,
        Vermella,
        Exclusio
    }
    
    
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
            throw new Exception("No s'ha trobat l'objecte corresponent");
        }
              
        return result;
    }
    
     public static Rol obtenirRol(String act){
         return obtenirRol(Rols.valueOf(act));
     }
        
    public static Rol obtenirRol(Rols rol){
       
        Rol result = null;
         
        switch (rol){
            case Porter:
                result = new Porter();
                break;
            case CentralAvancat:
                result = new CentralAvancat();
                break;
            case CentralCentre:
                result = new CentralCentre();
                break;
            case CentralDret:
                result = new CentralDret();
                break;
            case CentralEsquerra:
                result = new CentralEsquerra();
                break;
            case ExtremDret:
                result = new Extrem(true);
                break;
            case ExtremEsquerra:
                result = new Extrem(false);
                break;
            case LateralDret:
                result = new Lateral(true);
                break;
            case LateralEsquerra:
                result = new Lateral(false);
                break;
            case Pivot:
                result = new Pivot();
                break;
            default:
                result = null;
                break;                
        }
        
        return result;
    }
    
}
