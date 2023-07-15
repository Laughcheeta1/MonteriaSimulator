import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es el enemigo mas simple de todos, un maleante comun
 * 
 * @Santiago Yepes Mesa
 * @17/09/2022
 */
public class MaleanteComun extends Enemigos
{    
    protected void addedToWorld(World world)
    {
        MyWorld myWorld = (MyWorld)world;
        player = (Usuario)myWorld.getUsuario();
        counter = myWorld.getCounter();
        mirarAlUsuario();
        vidas = 2;
        dano = 1;
    }
    
    public void act()
    {
        moverse();
        golpeadoPorArma();
        eliminarEnemigo();
    }
    
    //Hacemos que el maleante siga al usuario de manera constante
    protected void moverse()
    {
        mirarAlUsuario();
        move(7);
    }
}
