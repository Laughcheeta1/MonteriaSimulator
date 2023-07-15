import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Motorista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Motorista extends Enemigos
{
    protected void addedToWorld(World world)
    {
        MyWorld myWorld = (MyWorld)world;
        player = (Usuario)myWorld.getUsuario();
        counter = myWorld.getCounter();
        mirarAlUsuario();
        vidas = 1;
        dano = 1;
    }
    
    public void act()
    {
        chocarPared();
        moverse();
        golpeadoPorArma();
        eliminarEnemigo();
    }
    
    //mira al usuario cada vez que choca una pared
    private void chocarPared()
    {
        if(isAtEdge())
        {
            mirarAlUsuario();
        }
    }
    
    //Se mueve
    protected void moverse()
    {
        move(12);
    }
}
