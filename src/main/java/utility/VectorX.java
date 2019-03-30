package utility;

public class VectorX {
  private double x;
  private double y;
  private double angle;
  private double magnitude;

  public VectorX(double x,double y) {
    this.x = x;
    this.y = y;
    this.angle = Math.atan2(y, x);
    this.magnitude = getMagnitude();
  }
  public void setXandY(double x, double y) {
    this.x = x;
    this.y = y;
    this.angle = Math.atan2(y, x);
    this.magnitude = getMagnitude();
  }
  public double getMagnitude() {
    double addition = (x * x) + (y * y);
    return Math.sqrt(addition);
  }
  public void VectorX1(double angle, double magnitude) {
    this.angle = angle;
    this.magnitude = magnitude;
    setXY();
  }
  public VectorX additionVector(VectorX vector1, VectorX vector2) {
    return new VectorX(vector1.getX()+vector2.getX(), vector1.getY()+vector2.getY());
  }
  public VectorX subtractionVector(VectorX vector1, VectorX vector2) {
    return new VectorX(vector1.getX()-vector2.getX(), vector1.getY()-vector2.getY());
  }
  public void setXY() {
    this.x  = this.magnitude * Math.cos(angle);
    this.y = this.magnitude * Math.sin(angle);
  }
  public double getX() {
    return x;
  }
  public void setX(double x) {
    this.x = x;
  }
  public double getY() {
    return y;
  }
  public void setY(double y) {
    this.y = y;
  }
  public double getAngle() {
    return angle;
  }
  public void setAngle(double angle) {
    this.angle = angle;
  }
  public void setMagnitude(double magnitude) {
    this.magnitude = magnitude;
  }
}

