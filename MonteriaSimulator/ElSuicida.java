import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ElSuicida here.
 * 
 * Stefanny Hurtado 
 * @version (a version number or a date)
 */
public class ElSuicida extends Enemigos
{
    /**
     * Act - do whatever the ElSuicida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected void addedToWorld(World world)
    {
        MyWorld myWorld = (MyWorld)world;
        player = (Usuario)myWorld.getUsuario();
        counter = myWorld.getCounter();
        mirarAlUsuario();
        vidas = 1;
        dano = 2;
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
        move(6);
    }
    
    @Override
    protected void eliminarEnemigo()
    {
        if(vidas == 0)
        {
            counter.anadirPunto(dano);
            World mundo = getWorld();
            mundo.addObject(new Explosion (this.getRotation()), getX(), getY());
            Greenfoot.playSound("ExplosionSoundEffect.mp3");
            mundo.removeObject(this);
        }
    }
}
