import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es la que muestra cuanto tiempo a transcurrido tras el inicio del
 * juego
 * 
 * (No funciona por ahora)
 * 
 * @Santiago Yepes Mesa
 * @28/09/2022
 */
public class Temporizador extends Actor
{
    private Color color = Color.BLACK;
    private boolean stop;
    private SimpleTimer timer;
    private int minutos = 0;
    private int segundos = 0;
    private long tiempo;
    
    //Constructor
    public Temporizador()
    {        
        setImage(new GreenfootImage("Tiempo:  " + 0, 50, color, null));
    }
    
    //Creamos un objeto de la clase SimpleTimer, y empezamos a contar
    protected void addedToWorld(World world)
    {
        timer = new SimpleTimer();
        timer.mark();
        tiempo = 0;
    }
    
    //Actualizamos la imagen del temporizador
    public void act()
    {
        setImage(new GreenfootImage("Tiempo  " + mostrarTiempo(), 50, color, null));
    }
    
    
    //Hacemos que se muestre el tiempo por minutos y segundos.
    private String mostrarTiempo()
    {
        if(tiempo != (int)timer.millisElapsed() && !stop)
        {
            segundos ++;
            tiempo = (int) timer.millisElapsed();
            
            if(segundos >= 60)
            {
                minutos ++;
                segundos = 0;
            }
        }
        
        if(segundos < 10)
        {
            return minutos + ":0" + segundos;
        }  
        else
        {
            return minutos + ":" + segundos;
        }
    }
    
    public long getTiempo()
    {
        return this.tiempo;
    }
    
    public SimpleTimer getTimer()
    {
        return timer;
    }
    
    public void timerStop()
    {
        stop = true;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public String getTiempoString()
    {
        return mostrarTiempo();
    }
}
