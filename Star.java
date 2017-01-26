import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

public class Star {
	public double x;
	public double y;
	public int size;
	public double speed;
	public Color color;
	
	Star(boolean b, Dimension d) {
		Random r = new Random();
		if (b) {
			x = r.nextInt((int) d.getWidth());
		} else
		{
			x = d.getWidth();
		}
		y = r.nextInt((int) d.getHeight());
		size = r.nextInt(8);
		speed = r.nextDouble() * 8 + 1;
		color = new Color(255, r.nextInt(155) + 100, r.nextInt(225) + 30, r.nextInt(205) + 50);
		
		int starType = r.nextInt(50);
		if (starType == 0) {
			//yellowstar
			color = new Color(r.nextInt(10) + 245, r.nextInt(10) + 245, 0, r.nextInt(225) + 30);
		} else if (starType == 1) {
			//redstar
			color = new Color(r.nextInt(10) + 245, r.nextInt(10), r.nextInt(10), r.nextInt(100) + 20);
		} else if (starType == 2) {
			//bluestar
			color = new Color(r.nextInt(10), r.nextInt(10), r.nextInt(10) + 245, r.nextInt(100) + 20);
		} else {
			//whitestar
			color = new Color(255, 255, r.nextInt(10) + 245, r.nextInt(155) + 100);
		}
	}
}
