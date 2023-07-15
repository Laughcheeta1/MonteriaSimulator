import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoToMainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoToMainMenu extends Botones
{
    public void act()
    {
        checkMouse();
        checkClick(new MainMenu());
    }
}
