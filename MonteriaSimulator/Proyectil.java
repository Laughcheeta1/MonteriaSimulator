import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Proyectil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Proyectil extends Armas
{
    public Proyectil(int rotationAngle)
    {
        //le damos la direccion en la que el proyectil se va a mover
        setRotation(rotationAngle);
    }
    public void act()
    {
    }
    
    //Si el proyectil esta en los limites de la pantalla, se quita del mundo
    protected void Desaparecer()
    {
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
