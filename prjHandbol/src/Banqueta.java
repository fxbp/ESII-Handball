
/**
 * \brief Representa els jugadors que estan a la banqueta d'un equip
 * @file Banqueta.java
 */
public class Banqueta extends AgrupacioJugadors {
    
    // Constants --------------------------------------------------------------
    
    final static int MAX_JUGADORS_BANQUETA=12;
    
    // Atributs Singleton ------------------------------------------------------
    // no podem fer atributs static ja que necessitem l'equip, de moment no esta preparat per multithreading
    
    private static Banqueta _banquetaLocal;  
    private static Banqueta _banquetaVisitant;
    


    // Constructors ------------------------------------------------------------
        
    /**
     * \brief Construeix una nova Banqueta
     * @param equip Identifica l'equip del qual son els jugadors
     */
    private Banqueta(Equip equip){
        super(equip, MAX_JUGADORS_BANQUETA);
        
    }
    
    
    // Metodes Singleton
    
    public static Banqueta getInstance(Equip equip, boolean local){
        
        if (local){
            return getInstance(_banquetaLocal, equip);
        }
        else{
            return getInstance(_banquetaVisitant,equip);
        }
    }
    
    private static Banqueta getInstance(Banqueta b, Equip equip){
        if (b == null){
                b=new Banqueta(equip);
        }
        return b;
    }
    
    
}
