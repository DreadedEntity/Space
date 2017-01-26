import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class Screen extends JPanel implements MouseInputListener, KeyListener {

	public static int[] tiles = new int[1590];
	public static ArrayList<Point> strings = new ArrayList<Point>();
	public static ArrayList<Point> points = new ArrayList<Point>();
	private static ArrayList<Star> stars = new ArrayList<Star>(Collections.synchronizedCollection(new ArrayList<Star>()));
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static Screen screen = new Screen();
	
	public static void main(String[] args) {
		JFrame frame = createAndShowGUI(screen);
		
		Random r = new Random();
		for (int i = 0; i < 200; i++) {
			stars.add(new Star(true, screenSize));
		}

		boolean escape = false;
		while (!escape) {
			screen.validate();
			screen.repaint();
			animateStars();
			
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	public static void changeNumberOfStars(int i) {
		if (i == 0) {
			stars.remove(0);
		} else if (i == 1) {
			stars.add(new Star(true, screenSize));
		} else {
			//should never get here
		}
	}

	private static void animateStars() {
		for (int i = 0; i < stars.size(); i++) {
			stars.get(i).x -= stars.get(i).speed;
			if (stars.get(i).x < 0) {
				stars.remove(i);
				
				//Toolkit.getDefaultToolkit().beep();
				stars.add(new Star(false, screenSize));
				stars.trimToSize();
			}
		}
	}

	private static JFrame createAndShowGUI(Screen screen) {
		JFrame f = new JFrame("Starry Space");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(screen);
		f.pack();

		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setVisible(true);

		f.addMouseListener(screen);
		f.addMouseMotionListener(screen);
		f.addKeyListener(screen);
		
		return f;
	}

	public Screen() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

    	for (int i = 0; i < stars.size(); i++) {
    		g.setColor(stars.get(i).color);
    		g.fillOval((int)stars.get(i).x, (int)stars.get(i).y, stars.get(i).size, stars.get(i).size);
    	}
    	
    	g.setColor(Color.YELLOW);
    	g.drawString("Stars: " + stars.size(), 0, 10);
	}
	@Override
	public void mouseClicked(MouseEvent m) {
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 37) {
			stars.remove(0);
		}
		if (e.getKeyCode() == 39) {
			stars.add(new Star(false, screenSize));
		}
		if (e.getKeyCode() == 38) {
			for (int i = 0; i < 10; i++) {
				stars.add(new Star(false, screenSize));
			}
		}
		if (e.getKeyCode() ==  40) {
			int i = 0;
			while (i < 10 && stars.size() > 9) {
				stars.remove(0);
				i++;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
