import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vagabundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vagabundo extends Enemigos
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
        moverse();
        golpeadoPorArma();
        eliminarEnemigo();
    }
    
    //El Vagabundo se mueve de manera aleatoria por todo el mapa
    //cambiando su direccion aleatoriamente, y moviendose subsecuentemente
    protected void moverse()
    {
        if(Greenfoot.getRandomNumber(200) < 1)
        {
            setRotation(Greenfoot.getRandomNumber(360));
            
        }
        move(2);
    }
}
