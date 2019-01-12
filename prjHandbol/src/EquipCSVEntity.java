
/**
 *
 * @author Francesc
 */
public class EquipCSVEntity implements CSVEntity {
    
       final static int ID_EQUIP=0;
       final static int NOM=1;
       final static int CIUTAT=2;
       
       
       @Override
       public  Equip create(String linia, String separador){
           
            String camps[]=linia.split(separador);
            return new Equip(camps[ID_EQUIP],camps[NOM],camps[CIUTAT]);
       }
    
    
}
