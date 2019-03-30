package frame;

import Explosion.App;
import javax.swing.JFrame;

public class FrameSetter {
  private JFrame jframe;
  public FrameSetter(int width,int height, App mainClass) {
    this.jframe = new JFrame("GameModeOn");
    jframe.setSize(width, height);
    jframe.setVisible(true);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.add(mainClass);
    mainClass.start();
  }
}
