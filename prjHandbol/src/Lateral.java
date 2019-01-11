
/**
 * \brief Represena el Rol de lateral dret o esquerra
 * @file Lateral.java
 */
public class Lateral implements Rol {
    
    // Atributs -----------------------------------------------------------
    
    /** \brief Diu si el lateral es juga per la dreta(True) o per l'esquerra(False) */
    private boolean _dret;
    
    // Constructors ------------------------------------------------------
    
    /**
     * Construeix un nou lateral dret
     * @pre True
     * @Post S'ha creat un nou objecte Lateral que juga per la dreta
     */
    public Lateral(){
        this(true);
    }
    
    
    /**
     * Construeix un nou lateral
     * @pre True
     * @post S'ha creat un nou Lateral que juga segons drat. Si dret juga per la dreta si !dret juga per l'esquerra
     * @param dret si dret, el jugador utilitzara la posicio dreta, si !dret Jugara per l'esquerra
     */
    public Lateral(boolean dret){
        _dret = dret;
    }
    
    
    // Metodes de la interficie Rol
    
    @Override
    public boolean xutar(){
       return true;
    }
        
}
