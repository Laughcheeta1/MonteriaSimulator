import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;

/**
 * Write a description of class MainMenu here.
 * 
 * @Stefany Hurtado y Santiago Yepes 
 * @18/10/2022
 */
public class MainMenu extends World
{
    private int anchura = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20;
    private int altura = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150;
    
    public MainMenu()
    {
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,
              (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150, 1);
        prepare();
        getBackground().scale(anchura, altura);
    }
    
    //Anadimos el boton para iniciar (Ir a ala seleccion de personaje.
    private void prepare()
    {
        GoToSeleccionPersonaje seleccionPersonaje = new GoToSeleccionPersonaje();
        addObject(seleccionPersonaje, (anchura / 2) - 120, (altura / 2) + 200);
        
        GoToScoreboard scoreBoard = new GoToScoreboard();
        addObject(scoreBoard, (anchura / 2) - 270, (altura / 2));
    }
}
