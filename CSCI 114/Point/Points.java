import java.awt.Point;
/**
 * CSCI 114 homework
 *  
 *
 * @Anthony Segarra
 * @2 Sept 2022
 */
public class Points
{

    public static void main (String[] args){
        
        // create variables
        Point pointA = new Point(0,10);
        Point pointB = new Point(20,30);
        
        //Print initial values
        System.out.println("pointA is: " + pointA.toString());
        System.out.println("pointB is: " + pointB.toString());
        
        // Change point A to Point B using setLocation()
        pointA.setLocation(pointB);
        System.out.println("\npointA\'s new location is: " + pointA.toString());
        
        // Translate Point B
        pointB.translate(70,50);
        System.out.println("\npointB\'s location after translation: " + pointB.toString());
        
    }
    

    
}
