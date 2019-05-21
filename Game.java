package minePackage;

public class Game {
	
	// for the engine
	          //private Handler h;
	
	// GAME OBJECTS
	             //private Deck d;
	               //private TextBox tb;
	
	// players
	             //private Player p1;
	       //private Player p2;
	
	// hands
	            //private Hand h1;
	            //private Hand h2;
	           //private Hand mid;
	
	// GAME VARIABLES
	private int turnPhase;
	private int turn;
	private boolean enterText;
	private boolean playerTurn;
	
	public static int mouseX;
	public static int mouseY;
	
	
	
	
//	private Text mouseCoord;
	
/**
	public Game(Handler h)
	{
		enterText = false;
		d = new Deck();
		p1 = new Player(false);
		p2 = new Player(true);
		h1 = new Hand(200, 600);
		h2 = new Hand(200, 200);
		mid = new Hand(200,400);
		tb = new TextBox(900, 500, 200, 30);
		
		p1.setHand(h1);
		p2.setHand(h2);
		playerTurn = true;
		this.h = h;
	}
	
	public void start()
	{
		setup();
		h.add(h1);
		h.add(h2);
		h.add(mid);
		h.add(tb);
	}
	
	public void setup() {
		turn = 0;
		turnPhase = 0;
		mid.drawCards(d, 3);
		h1.drawCards(d, 6);
		h2.drawCards(d, 2);
		h2.setHidden(true);
	}
	
	public void drawCard() {
		mid.drawCards(d, 1);
	}
	
	public boolean canDraw() {
		return turnPhase == 0;
	}
	
	public void registerKey(String key) {
		if(p1.getSelectedObject() != null && p1.getSelectedObject() instanceof TextBox) {
			
			TextBox t = (TextBox) p1.getSelectedObject();
			t.setText(t.getText() + key);
			
			
		} else if(key.equalsIgnoreCase("d") && canDraw()) {
			drawCard();
		} else if(key.equalsIgnoreCase("s")) {
			h1.shuffleCards(d);
			h2.shuffleCards(d);
			mid.shuffleCards(d);
			setup();
		} else if(key.equalsIgnoreCase("h")) {
			h2.setHidden(!h2.isHidden());
		}
		
	}
	*/
	public void registerMouse(int x, int y) {
//		System.out.println("Move: " + x + " " + y);
//		if(mouseCoord == null)
//		{
//			mouseCoord = new Text("X: " + x + ", Y: " + y, 500, 500);
//			h.add(mouseCoord);
//		}
//		mouseCoord.setString("X: " + x + ", Y: " + y);
		

		mouseX = x;
		mouseY = y;
		/**
		GameObject go = h.hoverObject(x, y);
		if(go != null) {
			p1.setHoverObject(go);
			go.setHovering(true);
		} else if(p1.getHoverObject() != null) {
			p1.getHoverObject().setHovering(false);
			p1.setHoverObject(null);
		}
		*/
		
		
		
//		if(go != null && go instanceof Hand) {
//			p1.setHoverObject((Hand) go);
//			int index = habs.getHit(x, y);
//			if(index != -1) {
//				Card c = habs.get(habs.getHit(x, y));
//				c.setHighlight(true);
//				p1.setSelectedCard(c);
//				p1.setSelectedCardIndex(index);
//				p1.setHovering(true);
//			} else if(p1.isHovering()){
//				for(int i = 0; i < habs.numCards(); i++) {
//					Card c = habs.get(i);
//					p1.setSelectedCard(null);
//					p1.setSelectedCardIndex(-1);
//					c.setHighlight(false);
//				}
//				p1.setHovering(false);
//			}
//		}
		
	}
	
	public void registerClick(int x, int y) {
		
		// TODO fix null pointer
		/**
		if(p1.getSelectedObject() != null)
		{
			p1.getSelectedObject().setSelected(false);
		}
		p1.setSelectedObject(p1.getHoverObject());
		p1.getHoverObject().setSelected(true);
		if(p1.getHoverObject() instanceof Hand) {
			Hand h = (Hand)p1.getHoverObject();
			int i = h.getLastSelectedIndex();
			Card c = h.remove(i);
			d.add(c);
			d.shuffle();
			h.drawCards(d, 1);
			registerMouse(x,y);
		}
		*/
	}
}