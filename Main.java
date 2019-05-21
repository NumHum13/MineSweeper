
package minePackage;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6087532263145303794L;
	//engine settings
	private boolean running = true;
	private int fps = 60;
	private int frameCount = 0;
	
	//graphical settings
	private final int SCREEN_WIDTH = 1000;
	private final int SCREEN_HEIGHT = 2000;
	
	//general settings
	private boolean fpsVisible = true;
	
	//instance variables
					//private Handler h;
	
	//static variables
					//public static Game g;
	
	public Main()
	{
		super("Card Game");
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		
				//h = new Handler();
				//this.addKeyListener(new KeyInput());
				//this.addMouseListener(new MouseInput());
				//this.addMouseMotionListener(new MouseMovement());
				//g = new Game(h);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
		main.start();
    }
	
	//this is the rendering method
    public void paint(Graphics g) {
    	g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    	
        			//h.renderObjects(g);
        
        //FPS counter
        if(fpsVisible)
        {
        	g.setColor(Color.BLACK);
            g.drawString("FPS: " + fps, 10, 42);
        }
        frameCount++;
    }
    
    //updates game objects
    public void update()
    {
    				//h.updateObjects();
    }
    
    
    public void start()
    {
    	Thread loop = new Thread()          
        {                                   
           public void run()                
           {                                
              gameLoop();                   
           }                                
        };                                  
        loop.start();         
        			//g.start();            
    }
    
    /* credit goes to "http://www.java-gaming.org/index.php?topic=24220.0"
     * for this game loop
     */
    private void gameLoop()
    {
       //This value would probably be stored elsewhere.
       final double GAME_HERTZ = 30.0;
       //Calculate how many ns each frame should take for our target game hertz.
       final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
       //At the very most we will update the game this many times before a new render.
       //If you're worried about visual hitches more than perfect timing, set this to 1.
       final int MAX_UPDATES_BEFORE_RENDER = 5;
       //We will need the last update time.
       double lastUpdateTime = System.nanoTime();
       //Store the last time we rendered.
       double lastRenderTime = System.nanoTime();
       
       //If we are able to get as high as this FPS, don't render again.
       final double TARGET_FPS = 30;
       final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
       
       //Simple way of finding FPS.
       int lastSecondTime = (int) (lastUpdateTime / 1000000000);
       
       while (running)
       {
          double now = System.nanoTime();
          int updateCount = 0;
          
          //Do as many game updates as we need to, potentially playing catchup.
         while( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER )
         {
            update();
            lastUpdateTime += TIME_BETWEEN_UPDATES;
            updateCount++;
         }

         //If for some reason an update takes forever, we don't want to do an insane number of catchups.
         //If you were doing some sort of game that needed to keep EXACT time, you would get rid of this.
         if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES)
         {
            lastUpdateTime = now - TIME_BETWEEN_UPDATES;
         }
      
         //Render. To do so, we need to calculate interpolation for a smooth render.
         //float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES) );
         
         repaint();
         lastRenderTime = now;
      
         //Update the frames we got.
         int thisSecond = (int) (lastUpdateTime / 1000000000);
         if (thisSecond > lastSecondTime)
         {
            //System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
            fps = frameCount;
            frameCount = 0;
            lastSecondTime = thisSecond;
         }
      
         //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
         while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
         {
            Thread.yield();
         
            //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
            //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
            //FYI on some OS's this can cause pretty bad stuttering. Scroll down and have a look at different peoples' solutions to this.
            try {Thread.sleep(1);} catch(Exception e) {} 
         
            now = System.nanoTime();
         }
       }
    }
    
}
