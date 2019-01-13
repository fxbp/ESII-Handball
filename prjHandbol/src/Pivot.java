
/**
 * \brief Representa el Rol Pivot
 * @file Pivot.java
 */
public class Pivot implements Rol{
       
    
    // Metodes de la interficie Rol
    
    @Override
    public boolean xutar(){
        return false;
    }
    
    @Override
    public String toString()
    {
        return this.getClass().getName();
    }
}
