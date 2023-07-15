import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Personaje de Obrero.
 * 
 * @author (Santiago Yepes) 
 * @version (a version number or a date)
 */
public class Obrero extends Usuario
{
    private boolean pressed = false;
    private boolean charged = false;
    private SimpleTimer timer = new SimpleTimer();
    private boolean coolDown = false;
    public Obrero()
    {
        setRotation(270);
        velocidad = 7;
        vidaOg = 10;
        vida = vidaOg;
    }

    public void act()
    {
        mouse  = Greenfoot.getMouseInfo();
        Move();
        moverMouseAtacar();
        tocaObjeto(); 
    }

    protected void Attack()
    {
        if(Greenfoot.mousePressed(null)){
            pressed = true;
        }else if (Greenfoot.mouseClicked(null)){
            pressed = false;
        }

        if (pressed && !coolDown && !charged){
            timer.mark();
            setImage("ObreroPreparado.png");
            charged = true;
        }else if (charged && !pressed){
            setImage("ObreroAtacando.png");
            Greenfoot.playSound("SonidoDePala.mp3");
            getWorld().addObject(new Pala(getRotation(),timer.millisElapsed()),getX(),getY());
            coolDown = true;
            timer.mark();
            pressed = false;
            charged = false;
        }else if( coolDown && timer.millisElapsed()>=0.5){
            setImage("ObreroStandard.png");
            coolDown = false;
        }
    }
}
