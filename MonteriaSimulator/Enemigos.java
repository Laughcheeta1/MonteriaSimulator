import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Esta es la Super clase de todos los enemigos, aqui se declaran algunos
 * metdodos que estos usara, junto con el constructor. Es un metodo abstracto
 * 
 * @Santiago Yepes
 * @17/9/2022
 */
public abstract class Enemigos extends Actor
{
    protected int vidas;
    protected int dano;
    protected Usuario player;
    protected Counter counter;
    SimpleTimer timer = new SimpleTimer();
    private long lastMark;
    public void mark(){
        lastMark = System.currentTimeMillis();
    }

    public float millisElapsed(){
        return (float) (System.currentTimeMillis()-lastMark)/1000;
    }

    public void act()
    {
      
    }

    //Con esto nos encargamos de que el enemigo mire al usuario
    protected void mirarAlUsuario()
    {
        turnTowards(player.getX(), player.getY());
    }

    //si el enemigo no tiene vida, se elimina    
    protected void eliminarEnemigo()
    {
        if(vidas == 0)
        {
            counter.anadirPunto(dano);
            getWorld().removeObject(this);
        }
    }

    //le quitamos la vida al enemigo
    protected void golpeadoPorArma()
    {
        Actor actor = getOneIntersectingObject(Armas.class);

        if(actor != null)
        {   
            if(actor instanceof Armas)
            {
                Armas arma = (Armas)actor;
                Greenfoot.playSound("hitOnEnemySoundEffect.mp3");
                
                //Si es una bala, removemos esa bala de la existencia y
                //ponemos un sonido en especial
                if(arma instanceof Bala)
                {
                    vidas -= arma.getDano();
                    
                    getWorld().removeObject(actor);
                        
                }

                if(arma instanceof Pala){
                    counter.anadirPunto(this.getDano());
                    getWorld().removeObject(this);
                    
                }
            }
        }
    }

    protected int getDano()
    {
        return dano;
    }

    protected abstract void moverse();
}