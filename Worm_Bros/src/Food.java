import java.awt.*;
import java.util.Random;
/**
 * Food class is a object that randomly relocates everytime it gets in a collision with the head worm
 * Can change the size with the DIAMETER 
 * @author Stephen
 *
 */
public class Food {

	public static int DIAMETER = 20;
	static int x = 50;
	static int y = 50;
	private Game game;
	 Random randomGenerator = new Random();
	/**
	 * Constuctor sets the x and y
	 * @param game
	 */
	public Food(Game game){
		this.game = game;
		x = setRandomX();
		y = setRandomY();
		
	}
	/**
	 * checks for collision returns true or false
	 * @return
	 */
	private boolean collision(){
		return game.worm.getBounds().intersects(getBounds());
	}
	/**
	 * if there is a collision randomly move on the screen
	 */
	public void move(){
		if (collision()){
		x = setRandomX();
		y = setRandomY();
		}
		
	}
 public int setRandomX(){
	
	 int randomInt = randomGenerator.nextInt(450);
	 return randomInt;
 }
 public int setRandomY(){
	
	 int randomInt = randomGenerator.nextInt(450);
	 return randomInt;
 }
 public void paint(Graphics2D g){
	 g.setColor(Color.RED);
	 g.fillOval(x,y,DIAMETER,DIAMETER);
		
 }
 /**
  * Gets bounds of the diameter and creates a rectangle to check for collisions with other objects
  * @return
  */
	public static Rectangle getBounds() {
		 return new Rectangle(x, y, DIAMETER, DIAMETER);
		 }
		
}
