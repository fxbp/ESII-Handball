
/**
 * \brief Interficie que servira per el patro strategy
 * @file Rol.java
*/
 
public interface Rol {
           
    /**
     * @pre True
     * @post S'ha realitzat la accio de xutar
     */
    public void xutar();
    
    
    /**
     * @pre Cert 
     * @return la nova posicio per iniciar la formació
     */
    public Posicio3D posicionar();
}
