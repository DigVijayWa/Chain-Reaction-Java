package objects;

import java.awt.Graphics2D;

public class Loading {
  Dot dot = new Dot(5);

  public void render(Graphics2D g) {
    dot.render(g);
  }
  public void update() {
    dot.update();
  }
}
