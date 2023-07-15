import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Acpm here.
 * 
 * @Santiago Yepes Mesa, sprite: Julio Jose Jaller
 * 
 * @11/10/2022
 */
public class Acpm extends PaqueteDeVida
{
    public Acpm()
    {
        vidaAOtorgar = 5;
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
            Greenfoot.playSound("acpmRecogido.mp3");
            getWorld().removeObject(this);
        }
    }
}
