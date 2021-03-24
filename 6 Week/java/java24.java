// Q1
class Shape2DVo
{
    private int x; private int y;

//    Getter
    public int getX() { return x; }
    public int getY() { return y; }
//    Setter
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}

class Shape3DVo extends Shape2DVo
{
    private int z;
    public int getZ() { return z; }
    public void setZ(int z) { this.z = z; }
}

class BallUtill extends Shape3DVo
{
    private int radius;
    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
    public double calVolume()
    {
        double a= 3.0/4.0;
        double r= Math.pow(radius,3);
        return a * Math.PI * r;
    }
}


// Q2
class CalUtils
{
    private int left; private int right; private int third;

    public void setOperand(int x, int y) { left = x; right = y; third=0; }
    public void setOperand(int x, int y, int z) { left= x; right= y; third= z; }
    public int sum() { return left+right+third; }
    public double avg()
    {
        if (third == 0) return sum() / 2.0;
        else return sum() / 3.0;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }
}

class NewCalUtil extends CalUtils
{
    @Override
    public double avg() { return Math.round(super.avg()); }
    public int substract() { return getLeft()-getRight(); }
}

public class java24 {
    public static void main(String[] args) {
        BallUtill bu= new BallUtill();
        bu.setX(4); bu.setY(3); bu.setZ(5); bu.setRadius(10);

        System.out.println("==========================");
        System.out.println("좌표 출력");
        System.out.printf("X (%d), Y (%d), Z (%d)\n", bu.getX(),bu.getY(),bu.getZ());
        System.out.printf("radius: %d\n", bu.getRadius());
        System.out.printf("volume: %f\n", bu.calVolume());

        System.out.println("==========================");
        NewCalUtil mc= new NewCalUtil();
        mc.setOperand(10,20);
        System.out.println(mc.sum());
        System.out.println(mc.avg());
        System.out.println(mc.substract());
    }
}
