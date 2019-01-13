
/**
 * \brief Representa el Rol Porter
 * @file Porter.java
 */
public class Porter implements Rol{
    
    
    
    // Metodes de la interficie Rol
    
    @Override
    public boolean xutar(){
        //implementar el metode xutar
        return false;
    }
    
    @Override
    public String toString()
    {
        return this.getClass().getName();
    }
}
