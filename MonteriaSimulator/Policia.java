import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es el personaje policia
 * 
 * @Santiago Yepes Mesa 
 * @17/09/2022
 */
public class Policia extends Usuario
{
    
    public Policia()
    {
        setRotation(270);
        velocidad = 10;
        vidaOg = 5;
        vida = vidaOg;
    }
    
    protected void addedToWorld(World world)
    {
        
    }
    
    public void act()
    {
        mouse  = Greenfoot.getMouseInfo();
        Move();
        moverMouseAtacar();
        tocaObjeto();        
    }
    
    //Disparar
    protected void Attack()
    {
        if(Greenfoot.mouseClicked(null))
        {
            getWorld().addObject(new Bala(getRotation()), getX(), getY());
                Greenfoot.playSound("gunshotSoundEffect.mp3");
        }
    }
}
