package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import utility.VectorX;

public class Dot {
  private VectorX position;
  private VectorX velocity;
  private VectorX accelaration;
  private VectorX wind;

  private VectorX gravity = new VectorX(0,0);

  private int size;

  private boolean exploded = false;

  private double diceRoll;

  private Color color;

  private Explosion explosion;

  public Dot(int size) {
    position = new VectorX(250,400);
    velocity = new VectorX(0,0);
    velocity.VectorX1(-Math.toRadians(90), 10);
    gravity.VectorX1(Math.toRadians(90), 0.3);
    accelaration = new VectorX(0,0);
    diceRoll = Math.random();
    color = new Color((int)((Math.random() * (255 - 0)) + 0),(int)((Math.random() * (255 - 0)) + 0),(int)((Math.random() * (255 - 0)) + 0));
    this.size = size;
  }
  public void render(Graphics2D G) {
    if(!exploded) {
      G.setColor(color);
      G.fillOval((int)position.getX(), (int)position.getY(), size, size);
    }else {
      explosion.render(G);
    }
  }
  public void update() {
    if(!exploded) {
      velocity = velocity.additionVector(gravity, velocity);
      accelaration = accelaration.additionVector(velocity, accelaration);
      position = position.additionVector(position, accelaration);
      accelaration.setXandY(0, 0);
      if(velocity.getMagnitude() < 2 && diceRoll < 0.8) {
        explosion = new Explosion(position);
        exploded = true;
      }
    }else {
      explosion.update();
    }
  }
  public boolean outOfBounds() {
    return this.position.getX() > 500 || this.position.getY() > 500 || this.position.getX() < 0 || this.position.getY() < 0;
  }
  public VectorX getPosition() {
    return position;
  }
  public void setPosition(VectorX position) {
    this.position = position;
  }
  public VectorX getVelocity() {
    return velocity;
  }
  public void setVelocity(VectorX velocity) {
    this.velocity = velocity;
  }
  public VectorX getAccelaration() {
    return accelaration;
  }
  public void setAccelaration(VectorX accelaration) {
    this.accelaration = accelaration;
  }
  public VectorX getWind() {
    return wind;
  }
  public void setWind(VectorX wind) {
    this.wind = wind;
  }
  public VectorX getGravity() {
    return gravity;
  }
  public void setGravity(VectorX gravity) {
    this.gravity = gravity;
  }
  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }
  public boolean isExploded() {
    return exploded;
  }
  public void setExploded(boolean exploded) {
    this.exploded = exploded;
  }

}

