import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la barra de vida
 * 
 * Hay que pensar si quitar la barra de vida, para dejar el UI mas depurado,
 * y mas bien que sea a partir de los sonidos que se sepa lo de la vida
 * 
 * Ya se arreglo el problema de que sea la barra de vida, la cual determine la vida, ahora es la clase personaje el que lo hace
 * 
 * Youtuber Promedio
 * 23/09/2022
 */
public class BarraDeVida extends Actor
{
    private Usuario usuario;
    private int healthBarWidth = 80;
    private int healthBarHeight = 10;
    private int pixelsPerHealthPoint;
    
    public BarraDeVida()
    {
        actualizar();
    }
    
    protected void addedToWorld(World world)
    {
        MyWorld myWorld = (MyWorld)world;
        usuario = myWorld.getUsuario();
        pixelsPerHealthPoint = healthBarWidth/usuario.getVidaOg();
    }
    
    public void act()
    {
        actualizar();
        pierdes();
    }
    
    //Se crea la barra de vida con la informacion actualizada del estado 
    //usuario
    public void actualizar()
    {        
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        try
        {
            myImage.fillRect(1, 1, usuario.getVida() * pixelsPerHealthPoint, 
            healthBarHeight);
        }
        catch(Exception e)
        {
        }
        
    }
    
    //Si la barra de vida llega a 0, el juego termina
    public void pierdes()
    {
        if (usuario.getVida() <= 0)
        {
            MyWorld myWorld = (MyWorld)getWorld();
            myWorld.getTemporizador().timerStop();
            Greenfoot.setWorld(new GameOver(myWorld.getCounter(), myWorld.getTemporizador()));
        }
    }
}
