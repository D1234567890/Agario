import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	private int x, y;
	private Color color;
	private double mass;
	private int vx, vy;
	private int rad;
	Rectangle world = new Rectangle(0, 0, Driver.worldSize, Driver.worldSize);

	public Enemy() {

		rad = (int) (Math.random() * 30) + 5;
		mass = Math.PI * rad * rad;

		while (vx == 0) {

			vx = (int) ((1 / mass) * 8000);
			vx *= (int) (Math.random() * 3) - 1;

		}
		
		while (vy == 0) {

			vy = (int) ((1 / mass) * 8000);
			vy *= (int) (Math.random() * 3) - 1;

		}

		x = (int) (Math.random() * (world.getMaxX() - (2 * rad)));
		y = (int) (Math.random() * (world.getMaxY() - (2 * rad)));

		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);

		color = new Color(r, g, b);

	}

	public void paint(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, rad * 2, rad * 2);

		update();

		if (x <= world.getMinX() || x >= world.getMaxX() - rad * 2) {

			vx *= -1;

		}

		if (y <= world.getMinY() || y >= world.getMaxY() - rad * 2) {

			vy *= -1;

		}
	}

	public void update() {
		x += vx;
		y += vy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

}
