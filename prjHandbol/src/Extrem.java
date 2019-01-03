
/**
 * \brief Representa el Rol Extrem dret o esquerra
 * @file Exterm.java
 */
public class Extrem implements Rol {
    
     // Atributs -----------------------------------------------------------
    
    /** \brief Diu si l'extrem  juga per la dreta(True) o per l'esquerra(False) */
    private boolean _dret;
    
    // Constructors ------------------------------------------------------
    
    /**
     * Construeix un nou extrem dret
     * @pre True
     * @Post S'ha creat un nou objecte Extrem que juga per la dreta
     */
    public Extrem(){
        this(true);
    }
    
    
    /**
     * Construeix un nou extrem
     * @pre True
     * @post S'ha creat un nou Extrem que juga segons drat. Si dret juga per la dreta si !dret juga per l'esquerra
     * @param dret si dret, el jugador utilitzara la posicio dreta, si !dret Jugara per l'esquerra
     */
    public Extrem(boolean dret){
        _dret = dret;
    }
    
    
    // Metodes de la interficie Rol
    
    @Override
    public void xutar(){
        //implementar el metode xutar
    }
    
     @Override
    public Posicio3D posicionar(){
        // Mirar quina posiio hauria de tornar
        return new Posicio3D();
    }
    
}
