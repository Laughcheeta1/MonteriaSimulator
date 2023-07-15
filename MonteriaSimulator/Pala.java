import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pala extends CuerpoCuerpo
{

    private SimpleTimer timer = new SimpleTimer();
    private float tiempoDeVida;

    public Pala (int rotationAngle, float tiempoDeVida)
    {
        dano = 2;
        setRotation(rotationAngle);
        this.tiempoDeVida = tiempoDeVida/2;
    }
    public void addedToWorld(World world){
        timer.mark();
    }
    public void act()
    {
        Permanecer();
    }

    public void Permanecer(){
       if(timer.millisElapsed()>tiempoDeVida){
           getWorld().removeObject(this);
       }
    }
}
