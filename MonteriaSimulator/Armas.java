import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase padre de todas la armas
 * 
 * @Santiago Yepes
 * @19/9/20022
   */
public abstract class Armas extends Actor
{   
    protected int dano;
    
    public void act()
    {
        
    }
    
    public int getDano(){
        return dano;
    }
}
