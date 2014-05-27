import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;
import java.util.Random;


public class Asteroid extends Obstacle{
	String arc;
	Asteroid(Game game){
		this.game = game;
		x = setRandomX();
		y = setRandomY();
		sizeX = setRandomSize();
		speedX = setRandomSpeed();
		speedY = setRandomSpeed();
				
	}
	public void paint(Graphics2D g){
		g.setColor(Color.orange);
		g.fillOval(x, y, sizeX, sizeX);
		
	}
	
	public int setRandomSize(){
		int randSize = randomGenerator.nextInt(14);
		randSize += 12;
		
		return randSize;
	}
	public int setRandomSpeed(){
		int randSpeed = randomGenerator.nextInt(6);
		randSpeed -= 3;
		return randSpeed;
	}
	public void move(){
		x += speedX;
		y += speedY;
		this.outBounds();
		if(bodycollision()){
			speedX = -speedX;
			speedY = -speedY;
		}
	}
	public void outBounds(){
		if (x > game.getWidth()) {
			x = 0;
		}
		if (x < 0) {
			x = game.getWidth();
		}
		if (y > game.getHeight()){
			y = 0;
		}
		if (y < 0) {
			y = game.getHeight();
		}
	}

}
