import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeleccionPolicia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeleccionPolicia extends Botones
{
    private String nombreUsuario;
    
    public SeleccionPolicia(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void act()
    {
        checkMouse();
        checkClick(new MyWorld(1, nombreUsuario));
    }
}
