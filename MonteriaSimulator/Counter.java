
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Es el Score board
 * 
 * Youtuber Promedio
 * @22/9/2022
 */
public class Counter extends Actor
{
    private Color color = Color.BLACK;
    private String username;
    private String nombrePersonaje;
    private int score = 0;
    
    //le damos la imagen og al contador
    public Counter(String username, String nombrePersonaje)
    {
        this.username = username;
        this.nombrePersonaje = nombrePersonaje;
        setImage(new GreenfootImage("Puntaje " + username + ": " + score, 50, color, null));
    }
    
    //vamos constantemente actualizando el contador
    public void act()
    {
        setImage(new GreenfootImage("Puntaje "+ username + ": " + score, 50, color, null));
    }
    
    //anadimos cierta cantidad de puntaje
    public void anadirPunto(int i)
    {
        score += i;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public String getNombrePersonaje()
    {
        return this.nombrePersonaje;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }
}
