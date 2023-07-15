import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sancocho here.
 * 
 * @Santiago Yepes Mesa, sprite: Julio Jose Jaller
 * 
 * @11/10/2022
 */
public class Sancocho extends PaqueteDeVida
{
    public Sancocho()
    {
        vidaAOtorgar = 1;
    }
    
    public void act()
    {
        recogido();
    }
    
    //Revisar si el personaje principal a recogido (tocado el paquete)
    protected void recogido()
    {
        Actor actor = getOneIntersectingObject(Usuario.class);
        
        if (actor instanceof Usuario)
        {
            myWorld = (MyWorld)getWorld();
            myWorld.getUsuario().actualizarVida(vidaAOtorgar);
            Greenfoot.playSound("sancochoRecogido.mp3");
            getWorld().removeObject(this);
        }
    }
}
