import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Write a description of class SeleccionPersonaje here.
 * 
 * @Santiago Yepes y Stefany Hurtado
 * @10/18/2022
 */
public class SeleccionPersonaje extends World
{
    private int anchura = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20;
    private int altura = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150;
    private String nombreUsuario = "";
    private Texto texto;
    
    public SeleccionPersonaje()
    {    
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,
              (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150, 1);
        prepare();
        getBackground().scale(anchura , altura);
    }
    
    
    //Mostrar los botones para la seleccion de la policia y el obrero.
    private void prepare()
    {
        int i = -1;
        boolean tieneEspacio = false;
        while (i < 0 || nombreUsuario.length() > 12 || tieneEspacio)
        {
            nombreUsuario = JOptionPane.showInputDialog("Entre nombre de usuario" +
                "\n(No puede superar los 12 caracteres)\n(El nombre no puede contener espacios)");
            
            
                
            if(nombreUsuario != null && nombreUsuario.length() > 0)
            {
                i++;
                
                int x = nombreUsuario.length();
                for(int u = 0; u < x; u++)
                {
                    if(nombreUsuario.charAt(u) == ' ')
                    {
                        tieneEspacio = true;
                    }
                
                }
            }
        }
        addObject(new SeleccionPolicia(nombreUsuario), anchura / 3, altura / 2);
        addObject(new SeleccionObrero(nombreUsuario), (anchura / 3) * 2, altura / 2);
        addObject(new Texto("ESCOGE EL PERSONAJE A USAR", true), (anchura / 2), (altura / 2) + 200);
    }
}
