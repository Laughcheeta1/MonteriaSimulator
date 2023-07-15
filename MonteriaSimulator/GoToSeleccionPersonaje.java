import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoToSeleccionPersonaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoToSeleccionPersonaje extends Botones
{      
    public void act()
    {
        checkMouse();
        checkClick();
    }
    
    protected void checkClick()
    {
        if (Greenfoot.mouseClicked (this))
        {
            Greenfoot.playSound("botonPresionado.mp3");
            Greenfoot.setWorld(new SeleccionPersonaje());
        }
    }
}
