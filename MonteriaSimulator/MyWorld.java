import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    private boolean anadirTemporizador = true;
    private Usuario usuario;
    private Counter counter;
    private BarraDeVida barraDeVida;
    private Temporizador temporizador;
    private int tiempo;
    private int altura = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -150;
    private int anchura = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 20;
    
    public MyWorld(int personaje, String nombreUsuario)
    {    
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,
              (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150, 1);
        getBackground().scale(anchura, altura);
        prepare(personaje, nombreUsuario);
    }
    
    public void act()
    {
        if(anadirTemporizador)
        {
            temporizador = new Temporizador();
            addObject(temporizador, 200, 50);
            anadirTemporizador = false;
        }
        tiempo = (int) temporizador.getTiempo();
        
        anadirPaquetesDeVida();
        anadirEnemigos();
    }
    
    //anadimos paquetes de vida
    private void anadirPaquetesDeVida()
    {
        if(Greenfoot.getRandomNumber(1000)<1)
        {
            Greenfoot.playSound("spawnSancocho.mp3");
            addObject(new Sancocho(), Greenfoot.getRandomNumber(anchura - 1), 
                Greenfoot.getRandomNumber(altura - 1));
        }
        
        
        
        //Aparece un Acpm cada 30 segundos
        //No se exactamente como funciona este tiempo, lo hice yo, pero pense 
        //que funcionaria diferente, pues, consigue lo que quiero, pero no 
        //exactamente como pensaba que iba a ser
        //Mi teoria es que se genera cada 30 segundos (a partir del segundo 1)
        //debido a que justo cuando el tiempo cambia al multiplo de 30, cambia 
        //por aproximacion, por ende haciendo que tiempo != millisElapsed().
        //(Esa es mi teoria)
        if(tiempo % 30 == 0 && tiempo != (int)temporizador.getTimer().millisElapsed())
        {
            Greenfoot.playSound("spawnAcpm.mp3");
            addObject(new Acpm(), Greenfoot.getRandomNumber(anchura - 1), 
                Greenfoot.getRandomNumber(altura - 1));
                
        }
        
    }
    
    //Anade los enemigos dependiendo si ya han pasado cierta cantidad de
    //segundos
    private void anadirEnemigos()
    {
        if (tiempo < 120)
        {
            anadirMaleanteComun();
        }
        
        if(tiempo > 45)
        {
            anadirMotorista();
        }
        
        if(tiempo > 90)
        {
            anadirVagabundo();
        }
        
        if(tiempo > 120)
        {
            anadirSuicida();
        }
    }
    
    //anadimos enemigos
    private void anadirMaleanteComun()
    {
        if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new MaleanteComun(), Greenfoot.getRandomNumber(anchura - 1), 1);
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new MaleanteComun(), 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new MaleanteComun(), anchura - 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new MaleanteComun(), Greenfoot.getRandomNumber(anchura - 1), altura - 1);
        }
    }
    
    //anadirmos enemigos
    private void anadirMotorista()
    {
        if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Motorista(), Greenfoot.getRandomNumber(anchura - 1), 1);
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Motorista(), 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Motorista(), anchura - 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Motorista(), Greenfoot.getRandomNumber(anchura - 1), altura - 1);
        }
    }
    
    //anadirmos enemigos
    private void anadirVagabundo()
    {
        if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Vagabundo(), Greenfoot.getRandomNumber(anchura - 1), 1);
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Vagabundo(), 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Vagabundo(), anchura - 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new Vagabundo(), Greenfoot.getRandomNumber(anchura - 1), altura - 1);
        }
    }
    
    private void anadirSuicida()
    {
        if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new ElSuicida(), Greenfoot.getRandomNumber(anchura - 1), 1);
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new ElSuicida(), 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new ElSuicida(), anchura - 1, Greenfoot.getRandomNumber(altura - 1));
        }
        else if(Greenfoot.getRandomNumber(400)<1)
        {
            addObject(new ElSuicida(), Greenfoot.getRandomNumber(anchura - 1), altura - 1);
        }
    }
    
    //aqui creamos lo basico que va a tener el mundo desde el inicio
    private void prepare(int pj, String nombreUsuario)
    {           
        if(pj == 1)
        {
            usuario = new Policia();
            counter = new Counter(nombreUsuario, "Policia");
        }
        else if(pj == 2)
        {    
            usuario = new Obrero();
            counter = new Counter(nombreUsuario, "Obrero");
        }
        addObject(usuario, anchura / 2, altura / 2);
        
        int number = nombreUsuario.length();
        addObject(counter, anchura - 200 - (number * 10), 50);
                
        barraDeVida = new BarraDeVida();
        addObject(barraDeVida, 100, altura - 50);
    }
    
    //devuelve el objeto usuario para su uso
    public Usuario getUsuario()
    {
        return usuario;
    }
    
    //devuelve el objeto counter para su uso
    public Counter getCounter()
    {
        return this.counter;
    }
    
    public Temporizador getTemporizador()
    {
        return this.temporizador;
    }
    
    //devuelve el objeto bara de vida para su uso
    public BarraDeVida getBarraVida()
    {
        return this.barraDeVida;
    }
}
