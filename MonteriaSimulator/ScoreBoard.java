import greenfoot.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.Collections;
import java.io.IOException;

/**
 *
 * @Santiago Yepes
 * solo falta hacer que aparezca la tabla
 */
public class ScoreBoard extends World {
    private final int anchura = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20;
    private final int altura = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150;
    
    private ArrayList<ResultInfo> results = new ArrayList<>();
    
    public ScoreBoard()
    {
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-20,
              (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150, 1);
        prepare();
        getBackground().scale(anchura, altura);
    }
    
    //Anadimos el boton para iniciar (Ir a ala seleccion de personaje y conectamos la base de datos, para hacer la tabla.
    private void prepare()
    {
        addObject(new GoToMainMenu(), anchura/2, 100);
        leerFichero();
        Collections.sort(results);
        generarTabla();
    }
    
    private void generarTabla()
    {
        int nAncho = (anchura - 300)/4;
        int nAltura = (altura - 300)/70;
        
        int times;
        
        if(results.size() < nAltura)
        {
            times = results.size();
        }
        else
        {
            times = nAltura;
        }
        
        for(int i = 0; i < times; i++)
        {
            Texto nombre = new Texto(results.get(i).getUsername(), false);
            Texto pj = new Texto(results.get(i).getCharacter(), false);
            Texto puntaje = new Texto(Integer.toString(results.get(i).getPoints()), false);
            Texto tiempoDurado = new Texto(results.get(i).getTime(), false); 
            
            addObject(nombre, 340, 225 + 70*i);
            addObject(pj, 340 + nAncho, 225 + 70*i);
            addObject(puntaje, 340 + nAncho * 2, 225 + 70*i);
            addObject(tiempoDurado, 340 + nAncho * 3, 225 + 70*i);            
        }
    }
    
    private void leerFichero()
    {
        String direccion = System.getProperty("user.dir") + "\\Puntajes";
        
        File f = new File(direccion);
        File[] listF = f.listFiles(new Filter(".score"));
        
        try
        {
            int x = listF.length;
            
            for (int i = 0; i < x; i++)
            {
                FileInputStream in = new FileInputStream(listF[i]);
                ObjectInputStream o = new ObjectInputStream(in);
                
                results.add((ResultInfo)o.readObject());
                
                o.close();
                in.close();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
