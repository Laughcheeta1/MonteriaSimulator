import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La superclase de los botones, se encarga del funcionamiento de los botones
 * a grandes rasgos.
 * 
 * @ManEnYotube
 * @
 */
public abstract class Botones extends Actor
{
    public void act()
    {
        
    }
    
    private boolean mouseOver=false;
    private static int MAX_TRANS = 255;
    
    //Aumentar la transparencia de la imagen si el mouse esta encima
    protected void checkMouse ()
    {
        if (Greenfoot.mouseMoved(null))
        {
            mouseOver = Greenfoot.mouseMoved(this);
        }
        
        if (mouseOver)
        {
            adjTrans (MAX_TRANS/2);
            
        }
        else
        {
            adjTrans(MAX_TRANS);
        }
        
        
    }
    
    //Cambiar de mundo cuando se clickee
    protected void checkClick(World world)
    {
        if (Greenfoot.mouseClicked (this))
        {
            Greenfoot.playSound("botonPresionado.mp3");
            Greenfoot.setWorld(world);
        }
    }
    
    //Ajustar la transparencia
    protected void adjTrans (int adjust)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency (adjust);
        setImage (tempImage);
    }
}
