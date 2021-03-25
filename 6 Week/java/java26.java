import java.io.IOException;

class Character {
    int rx; int cy; boolean life;
    Character() {}
    public void initPos() { rx= 0; cy= 0;}
}

class Rabbit extends Character {
    Rabbit() {
        super();
        life= true;
    }
    @Override
    public void initPos() { rx= 11/2; cy= 11/2; }
    public void initPos(int w, int h) { rx= w/2; cy= h/2; }
}

class Grass extends Character {
    String color;
    { color= "Green"; }
    Grass() { super(); life= false; }
    Grass(String color) { super(); life= false; this.color= color; }

    public void initPos(int n)
    {
        rx= (int)(Math.random()*n)+1;
        cy= (int)(Math.random()*n)+1;
    }
    public void initPos(int w, int h)
    {
        rx= (int)(Math.random()*w)+1;
        cy= (int)(Math.random()*h)+1;
    }
}

class Visualization
{
    final static char SPACE= '•';
    final static char RABBIT= '✰';
    final static char GRASS= '✿';
    static int width= 5;
    static int height= 5;
    static int[][] map= new int[width][height];
    static
    {
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
                map[i][j]= 0;
        }
    }
    public static void  DrawMap()
    {
        for (int r=0; r<width; r++)
        {
            for (int c=0; c<height; c++)
            {
                if (map[r][c] == 0) System.out.print(SPACE);
                else if (map[r][c] == 1) System.out.print(RABBIT);
                else if (map[r][c] == 2) System.out.print(GRASS);
            }
            System.out.println();
        }
    }

    public static void changeMapByRabbit(Rabbit rabbit)
    {
        map[rabbit.rx][rabbit.cy]= 1;
    }
    public static void changeMapByGrass(Grass grass)
    {
        map[grass.rx][grass.cy]= 2;
    }
}

public class java26 extends Visualization {

    public final static void clearConsole()
    {
//        Worked on Mac OS X
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        int time= 100;
        Rabbit bucks= new Rabbit();
        Grass flower= new Grass();

        for (time=100; time<=200; time++)
        {
            changeMapByRabbit(bucks);
            changeMapByGrass(flower);

            bucks.initPos();
            flower.initPos(Visualization.width, Visualization.height);

            DrawMap();
            System.out.printf("현재 time value %d\n", time);
            System.out.printf("bucks X,Y: %d , %d\n", bucks.rx, bucks.cy);
            System.out.printf("flower X,Y: %d , %d\n" ,flower.rx , flower.cy);

            clearConsole();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
