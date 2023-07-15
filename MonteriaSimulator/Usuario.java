import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase padre de todos los personajes jugables.
 * 
 * @Santiago Yepes Mesa 
 * @09/10/2022
 */
public abstract class Usuario extends Actor
{
    protected int vidaOg;
    protected int vida;
    protected MouseInfo mouse;
    protected int velocidad;
    
    public void act()
    {
        
    }
    
    protected void moverMouseAtacar()
    {
        if(mouse!=null)
        {
            ChangeRotation();
            Attack();
        }
    }
    
    //Aqui se mueve
    protected void Move()
    {
            if(Greenfoot.isKeyDown("w"))
            {
                setLocation(getX(), getY() - velocidad); 
            }
            if(Greenfoot.isKeyDown("s"))
            {
                setLocation(getX(), getY() + velocidad); 
            }
            if(Greenfoot.isKeyDown("a"))
            {
                setLocation(getX() - velocidad, getY()); 
            }
            if(Greenfoot.isKeyDown("d"))
            {
                setLocation(getX() + velocidad, getY()); 
            }
    }
    
    //Para cambiar la direccion en la que el personaje mira
    protected void ChangeRotation()
    {
        turnTowards(mouse.getX(), mouse.getY());
    }
    
    //Si el personaje es alcanzado por un enemigo, se le quita vida
    public void tocaObjeto()
    {
        Actor actor = getOneIntersectingObject(null);
        
        if(actor != null)
        {   
            if(actor instanceof Enemigos)
            {
                Enemigos enemigo = (Enemigos)actor;
                Greenfoot.playSound("robloxSoundEffect.mp3");
                //Le quitamos la al enemigo, y actualizamos el
                //counter
                getWorld().removeObject(enemigo);
                actualizarVida(-(enemigo.getDano()));
            }
        } 
    }
    
    //Subirle o quitarle vida al personaj
    public void actualizarVida(int vida)
    {
        this.vida += vida;
        if (this.vida > vidaOg)
        {
            this.vida = vidaOg;
        }
    }
    
    public int getVida()
    {
        return vida;
    }
    
    public int getVidaOg()
    {
        return vidaOg;
    }
    
    //todos los personajes deben poder atacar
    protected abstract void Attack();
    
    
}
