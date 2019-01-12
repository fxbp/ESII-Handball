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
    
    public void mostrarRols()
    {
        for(int i= 0; i<arrayRols.length; i++)
        {
            System.out.println(i+ ": "+arrayRols[i]);
        }
    }
}
