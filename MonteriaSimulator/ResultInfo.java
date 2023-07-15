import java.io.Serializable;

/**
 * This is for storing efectively the results of games
 * 
 * @Santiago Yepes Mesa
 * @14/7/2023
 */
public class ResultInfo implements Comparable<ResultInfo>, Serializable 
{
    // instance variables - replace the example below with your own
    private String userName;
    private String character;
    private int points;
    private String time;

    /**
     * Constructor for objects of class ResultInfo
     */
    public ResultInfo(String userName, String character, int points, String time)
    {
        this.userName = userName;
        this.character = character;
        this.points = points;
        this.time = time;
    }
    
    public String getUsername()
    {
        return userName;
    }
    
    public String getCharacter()
    {
        return character;
    }
    
    public int getPoints()
    {
        return points;
    }

    public String getTime()
    {
        return time;
    }
    
    @Override
    public int compareTo(ResultInfo r1)
    {
        return this.points - r1.getPoints();
    }
}
