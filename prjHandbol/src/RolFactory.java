/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adria
 */
public class RolFactory {
      
    private final String[] arrayRols = {
        "CentralAvancat",
        "CentralCentre",
        "CentralDret",
        "CentralEsquerra",
        "ExtremDret",
        "ExtremEsquerra",
        "LateralDret",
        "LateralEsquerra",
        "Pivot",
        "Porter"
    };
    
    public RolFactory()
    {
        //
    }
    
    public void mostrarRols()
    {
        System.out.println("Rols a escollir:");
        for(int i= 1; i<=arrayRols.length; i++)
        {
            System.out.println(i+ ": "+arrayRols[i-1]);
        }
    }
    
    public Rol getRol(int rolIndex)
    {
        return Utils.obtenirRol(arrayRols[rolIndex-1]);
    }
}
