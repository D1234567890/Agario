import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

public class Player {

	private int x, y;
	private Color color;
	private double mass;
	private double vx, vy;
	private int rad;
	Rectangle world = new Rectangle(0, 0, Driver.worldSize, Driver.worldSize);

	public Player(int rad) {

		this.rad = rad;

		x = (Driver.worldSize / 2) - rad;
		y = (Driver.worldSize / 2) - rad;

		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);

		color = new Color(r, g, b);

	}

	public void paint(Graphics g) {

		g.setColor(color);
		g.fillOval(x, y, rad * 2, rad * 2);

		double vectorX = MouseInfo.getPointerInfo().getLocation().getX() - (x + rad);
		double vectorY = MouseInfo.getPointerInfo().getLocation().getY() - (y + rad);

		double magnitude = Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2));

		if (magnitude != 0) {

			double unitVectorX = vectorX / magnitude;
			double unitVectorY = vectorY / magnitude;

			vx = unitVectorX * 5;
			vy = unitVectorY * 5;

		}

		update();

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

	public double getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public double getVy() {
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
