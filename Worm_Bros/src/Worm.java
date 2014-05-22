import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.*;
/**
 * The Worm class builds a square that is able to eat and grow and have other squares follow it using a queue structure to 
 * store and allow for movement. you can set the width and height and speed of the worm.
 * @author Stephen Jones
 *
 */
public class Worm {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	int x = 200;
	int y = 200;
	int speed = 10;
	private Game game;
	static String direction = "l";
	static String fin = "l";
	static int size = 0;
	Queue<String> queue = new LinkedList<String>();
	public static Queue<String> lastQueue = new LinkedList<String>();
	public static boolean key = true;
	static Worm head;
	static Worm tail;
	static int eat;
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	void setX(int input){
		x = input;
	}
	void setY(int input){
		y = input;
	}
	/**
	 * Worm Constructor initializes the game object for references to the height and width and game functions This constructor
	 * builds a worm object right behind the previous worm object and allows them to stay in a line and sets up there queue for 
	 * direction and movement.
	 * @param game
	 * 
	 */
	public Worm(Game game){
		this.game = game;
		if (head == null) {
			head = this;
			this.queue.add(getDirection());
			lastQueue = this.queue;
			size ++;
			tail = this;
		}
		else{
			this.game = game;
			this.x = tail.x;
			this.y = tail.y;
			this.queue.addAll(lastQueue);
			this.queue.add(fin);
			String start = head.queue.peek();
			if(start.equals("l")){
				this.x += WIDTH;
			}
			if(start.equals("r")){
				this.x -= WIDTH;
			}
			if(start.equals("u")){
				this.y += HEIGHT;
			}
			if(start.equals("d")){
				this.y -= HEIGHT;
			}
		}
			lastQueue = this.queue;
			tail = this;			
			size ++;
		}
	public void setDirection(String input){
		direction = input;
	}
	public static String getDirection(){
		return direction;
	}
	public static void finalizedMove(){
		 fin = direction;
	}
	public void move(){
			queue.add(fin);
		String move = queue.remove();
		if (move.equals("u")){
			y -= speed;
		}
		else if (move.equals("l")){
			x -= speed;
		}
		else if (move.equals("r")){
			x += speed;
		}
		else if(move.equals("d")){
			y += speed;
		}
		this.outBounds();
		}
	public void paint(Graphics2D g){
			g.setColor(Color.white);
			g.fillRect(x, y, WIDTH, HEIGHT);
		}
	public void keyReleased(KeyEvent e){
			
	}
	public void keyPressed(KeyEvent e) {
	String next = fin;
	if (this.key == true) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			next = "l";
			}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			next ="r";
			}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			next = "u";
			}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			next =  "d";
			}
	}			
			setDirection(next);
			
			
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
	
	public boolean collision(){
		return game.food.getBounds().intersects(getBounds());
	}
	public Rectangle getBounds() {
	 return new Rectangle(x, y, WIDTH, HEIGHT);
	 }
	}


