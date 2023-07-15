import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Armas
{
    private SimpleTimer timer = new SimpleTimer();
    
    public Explosion(int rotationAngle)
    {
        dano = 4;
    }
    
    protected void addedToWorld(World world)
    {
        timer.mark();
    }
    
    public void act()
    {
        danarJugador();
        if(timer.millisElapsed() >= 1)
        {
            getWorld().removeObject(this);
        }
    }
    
    private void danarJugador()
    {
        Usuario usuario = (Usuario)getOneIntersectingObject(Usuario.class);
        
        if(usuario != null)
        {
            usuario.actualizarVida(-dano);
        }
    }
}
