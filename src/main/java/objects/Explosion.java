package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import utility.VectorX;

public class Explosion {

  private ArrayList<Dot> dots = new ArrayList<Dot>();
  private VectorX position;

  public Explosion (VectorX position) {
    this.position = position;
    for(int i=0;i<10;i++) {
      dots.add(new Dot(3));
      dots.get(i).setPosition(position);
      VectorX vel = new VectorX(0,0);
      vel.VectorX1(Math.toRadians((Math.random() * (360 - 0)) + 0),4);
      dots.get(i).setVelocity(vel);
    }
  }
  public void render(Graphics2D g) {
    g.setColor(Color.cyan);
    for(Dot dot : dots) {
      dot.render(g);
    }
  }
  public void update() {
    for(int i=dots.size()-1 ; i>=0 ; i--) {
      dots.get(i).update();
      if(dots.get(i).outOfBounds()) {
        dots.remove(i);
      }
    }
  }
}

