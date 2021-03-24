import java.io.IOException;
import java.util.Scanner;

class Character {
    int rx; int cy; boolean life;
    Character() {}
    public void initPos() { rx= 0; cy= 0;}
}

class Physic {
    private double energy;
    Physic() {}
    public void setEnergy(double energy) {
        this.energy = energy;
    }
    public double getEnergy() {
        return energy;
    }
}

class Rabbit extends Character {
    Rabbit() {
        super();
        life= true;
    }
//    다중 상속 대체
    Physic py;

    @Override
    public void initPos() { rx= 11/2; cy= 11/2; }
    public void initPos(int w, int h) { rx= w/2; cy= h/2; }
}

class Grass extends Character {
    String color;

    Grass(String color) { super(); life= false; this.color= color; }

    public void initPos(int n)
    {
        rx= (int)(Math.random()*n)+1;
        cy= (int)(Math.random()*n)+1;;
    }
    public void initPos(int w, int h)
    {
        rx= (int)(Math.random()*w)+1;
        cy= (int)(Math.random()*h)+1;;
    }
}

public class java23 {
    public final static void clearConsole()
    {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        int time= 100;
//        System.out.println(System.getProperty("os.name"));
        for (time=100; time<=200; time++)
        {
            System.out.println("현재 time value "+ time);
            clearConsole();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        init();
//        Rabbit rabbit= new Rabbit();
//        rabbit.py.setEnergy(0.5);
//        System.out.println(rabbit.py.getEnergy());
//        System.out.println(rabbit.rx);
//        System.out.println(rabbit.cy);
//        System.out.println(rabbit.life);
    }
}
