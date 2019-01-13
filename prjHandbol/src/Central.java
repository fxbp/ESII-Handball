

/**
 * \brief Classe que serveix perque tots els Rols de central pugin xutar de la mateixa manera
 * @file Central.java
 */
public abstract class Central implements Rol {
    
    
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
