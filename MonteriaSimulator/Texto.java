import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Actor
{
    private String texto;
    private SimpleTimer timer;
    private boolean titilar;
    private boolean si = false;
    
    public Texto (String texto, boolean titilar)
    {
        this.texto = texto;
        this.titilar = titilar;
        timer = new SimpleTimer();
        timer.mark();
    }
    
    public void act()
    {
        if(titilar)
        {
            if (timer.millisElapsed() >= 0.5)
            {
                si = !si;
                timer.mark();    
            }
        
            if(si)
            {
                setImage(new GreenfootImage(texto, 50, Color.WHITE, null));
            }
            else 
            {
                setImage(new GreenfootImage(texto, 50, Color.BLACK, null));
            }
        }
        else
        {
            setImage(new GreenfootImage(texto, 50, Color.BLACK, null));
        }
    }
    
    public void setTexto(String texto)
    {
        this.texto = texto;
    }
}
