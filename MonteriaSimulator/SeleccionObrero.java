import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeleccionObrero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeleccionObrero extends Botones
{
    private String nombreUsuario;
    
    public SeleccionObrero(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void act()
    {
        checkMouse();
        checkClick(new MyWorld(2, nombreUsuario));
    }
}
