import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
 * @Santiago Yepes Mesa
 * @28/09/2022
 */
public abstract class PaqueteDeVida extends Actor
{
    //la vida que va a otorgar
    protected int vidaAOtorgar;
    protected MyWorld myWorld;
    
    public void act()
    {
    }
    
    //Chequear si un Usuario lo toca
    protected abstract void recogido();
    
    public int getVidaAOtorgar()
    {
        return this.vidaAOtorgar;
    }
}
