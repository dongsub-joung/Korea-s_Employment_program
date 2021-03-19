import javax.swing.*;

// Example constructor
class wheel {
    private int size;
    private String material;
    private char color;
    { size= 10; material= "steel"; color= 'a'; }

    wheel() {}
    wheel(int size) { setSize(size);}
    wheel(String material) { setMaterial(material);}
    wheel(char color) { setColor(color); }

    wheel(int size, String material) { setSize(size); setMaterial(material); }
    wheel(String material, char color) { setMaterial(material); setColor(color); }
    wheel(int size, char color) { setSize(size); setColor(color); }

    wheel(int size, String material, char color) { setSize(size); setMaterial(material); setColor(color); }

    public void setSize(int size) { this.size= size; }
    public void setMaterial(String material) { this.material= material; }
    public void setColor(char color) { this.color= color; }

    public int getSize() { return size; }
    public String getMaterial() { return material; }
    public char getColor() { return color; }
}

class PrintPresentSpeed
{
    final String STOP= "정지 상태!";
    boolean direct= true;
    int present_speed;
    int max_speed;

//    Constructor
    { present_speed= 0; max_speed= 100; }
    PrintPresentSpeed() {}
    public PrintPresentSpeed(int speed) { this.present_speed = speed; }
    public PrintPresentSpeed(int present_speed, int max_speed) {
        this.present_speed = present_speed;
        this.max_speed = max_speed;
    }

//    Getter
    public int getMax_speed() { return max_speed; }
    public int getPresent_speed()
    {
        if (present_speed == 0) System.out.println(STOP);
        return present_speed;
    }

//    Setter
    public void setPresent_speed(int present_speed) { this.present_speed = present_speed; }
    public void setMax_speed(int max_speed) { this.max_speed = max_speed; }

//    Method
    public void speedUp(int speed)
    {
        present_speed+= speed;
        if (max_speed<present_speed)
        {
            System.out.println(present_speed-max_speed + " 만큼 초과한 속력입니다.");
            System.out.println("최고 속도를 유지합니다.");
            present_speed= max_speed;
        }
    }

    public void speedDown(int speed)
    {
        present_speed-= speed;
        if (present_speed<0)
        {
            System.out.println("반대 방향으로 가기!");
            direct= false;
        }
        else if (present_speed == 0) System.out.println(STOP);
        else direct= true;
    }

}

public class java19 {
    public static void main(String[] args) {
        PrintPresentSpeed ex= new PrintPresentSpeed();
        ex.setPresent_speed(50);
        System.out.println(ex.present_speed);
        ex.speedUp(60);
        System.out.println(ex.present_speed);
        System.out.println(ex.direct);
        System.out.println("=======");
        ex.speedDown(150);
        System.out.println(ex.present_speed);
        System.out.println(ex.direct);
    }
}
