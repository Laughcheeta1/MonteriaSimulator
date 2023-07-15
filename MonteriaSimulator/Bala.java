import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es el objeto bala, el cual sale disparado del personaje policia
 * 
 * @Santiago Yepes Mesa
 * @17/09/2022
 */
public class Bala extends Proyectil
{
    public Bala(int rotationAngle)
    {
        super(rotationAngle);
        dano = 1;
    }
    
    public void act()
    {
        move(20);
        Desaparecer();
    }
}
