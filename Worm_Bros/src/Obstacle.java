import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;


public abstract class Obstacle {
	protected int x;
	protected int y;
	protected int speedX;
	protected int speedY;
	protected int sizeX;
	protected int sizeY;
	protected Game game;
	Random randomGenerator = new Random();
	
	
	public boolean headcollision(){
		return game.worm.getBounds().intersects(getBounds());
	}
	public boolean bodycollision(){
		for (Worm b : game.body){
			return b.getBounds().intersects(getBounds());
			
			}
		return false;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,sizeX,sizeX);
	}

	public void move(){
	
	}
	public void paint(Graphics2D g){
		
	}
	 public int setRandomX(){
			
		 int randomInt = randomGenerator.nextInt(450);
		 return randomInt;
	 }
	 public int setRandomY(){
		
		 int randomInt = randomGenerator.nextInt(450);
		 return randomInt;
	 }
		
	
	

}
