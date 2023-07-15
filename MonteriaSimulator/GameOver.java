import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;


/**
 * Write a description of class GameOver here.
 * 
 * @Santiago Yepes 
 * @18/10/2022
 */
public class GameOver extends World
{
    private Counter counter;
    private Temporizador temporizador;
    private int anchura = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-30;
    private int altura = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150;
    
    //recibimos el counter y temporizador para poder mostrar sus valores 
    //finales
    public GameOver(Counter counter, Temporizador temporizador)
    {    
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,
              (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150, 1);
        this.counter = counter;
        this.counter.setColor(Color.WHITE);
        this.temporizador = temporizador;
        this.temporizador.setColor(Color.WHITE);
        getBackground().scale(anchura, altura);
        prepare();
    }
    
    public void act()
    {
        
    }
    
    //Anadimos el puntaje final, tiempo sobrevivido, y un boton para regresar
    //al menu principal
    private void prepare()
    {
        addObject(counter, anchura / 2, altura / 2);
        addObject(temporizador, anchura / 2, (altura / 2) - 50 );
        addObject(new GoToMainMenu(), anchura / 2, (altura / 2) - 150);
        conectarFichero();
        Greenfoot.playSound("SonidoDeMuerte.mp3");
    }
    
    private void conectarFichero()
    {
        String direccion = System.getProperty("user.dir") + "\\Puntajes";
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssZ");
        try
        {
            FileOutputStream f = new FileOutputStream(direccion + "\\" + sdf.format(d) + ".score");
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            o.writeObject(new ResultInfo(counter.getUsername(), counter.getNombrePersonaje(), 
                counter.getScore(), temporizador.getTiempoString()));
            
            o.close();
            f.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
  
}
