import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;

/**
 * Write a description of class PantallaInicio here.
 * 
 * @Santiago Yepes 
 * @version (a version number or a date)
 */
public class PantallaInicio extends World
{ 
    private boolean flag = true;
    private SimpleTimer timer;
    public PantallaInicio()
    {    
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,
              (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150, 1); 
        timer = new SimpleTimer();
        getBackground().scale((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-30,
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150);
    }
    
    @Override
    public void act()
    {
        if(flag)
        {
            Greenfoot.playSound("MusicaFondoPantallaInicio.mp3");
            timer.mark();
            flag = false;
        }
        if(timer.millisElapsed() >= 10)
        {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
