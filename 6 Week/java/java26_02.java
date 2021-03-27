import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class FoodSelf
{
    private String name;
    private int price;

    protected FoodSelf(){}
    public FoodSelf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //    Setter
    public void setName(String name) { this.name = name; }
    public void setPrice(int price) {  this.price = price; }

    //    Getter
    public int getPrice() { return price; }
    public String getName() { return name; }
}

class BurgerSelf extends FoodSelf
{
    private boolean isSet;

    BurgerSelf(String name, int price){ super(name, price);}
    BurgerSelf(boolean isSet, String name, int price)
    {
        super(name, price);
        this.isSet= isSet;
        if (isSet) setPrice(price+3000);
//        if (isSet) setName(name);
    }

    public boolean isSet() {
        return isSet;
    }

}

class MENU_STRINGS
{
    private static final String[] MAIN_MENU= {"big mac"};
    private static final String[] DRINK= {"coka cola"};
    private static final String[] SIDE_MENU= {"sake ice cream"};

    public static String[] getMainMenu() {
        return MAIN_MENU;
    }

    public static String[] getDRINK() {
        return DRINK;
    }

    public static String[] getSideMenu() {
        return SIDE_MENU;
    }
    public static int getIndex(String[] str_arr, String str)
    {
        int index= 0;
        for (int i = 0; i < str_arr.length; i++)
        {
            if (str_arr[i].equals(str)) index= i;
        }
        return index;
    }
}
class Price
{
    MENU_STRINGS strs_menu;
    private class Main
    {
        private static final int big_mac= 4500;
//        ...
    }
    private class Drink
    {
        private static final int coka_cola= 2000;
//        ...
    }
    private class Side
    {
        private static final int sake_ice_cream= 1500;
//        ...
    }

    private Main M;
    private Drink D;
    private Side S;

    //    Singleton
    protected Price(){}
    private static class InnerInstanceClazz{
        private static final Price instance= new Price();
    }
    protected static Price getInstance() { return InnerInstanceClazz.instance; }

//    Getter


    //    Main
    protected int getMain(String str) {
        String[] menu= strs_menu.getMainMenu();
        int index= strs_menu.getIndex(menu, str);
        if (menu[index].equals(str)) return M.big_mac;
//        else if (str == menu[i]) return M.something;
        else
        {
//            System.out.println("E: Incorrect String");
            return 0;
        }
    }

    //    Drink
    protected int getDrink(String str) {
        String[] menu= strs_menu.getDRINK();
        if (menu[0].equals(str)) return D.coka_cola;
//        else if (str == menu[i]) return D.something;
        else {
//            System.out.println("E: Incorrect String");
            return 0;
        }
    }

    //    Side
    protected int getSide(String str) {
        String[] menu= strs_menu.getSideMenu();
        if (menu[0].equals(str)) return S.sake_ice_cream;
//        else if (str == menu[i]) return S.something;
        else {
//            System.out.println("E: Incorrect String");
            return 0;
        }
    }
}
class Separate extends Price
{
    private Separate() {}
    private static class InnerInstanceClass {
        private static final Separate instance= new Separate();
    }
    public  static Separate getInstance() {
        return InnerInstanceClass.instance;
    }

    public int initSeparate(String str)
    {
        switch (str.charAt(0))
        {
            case 'M':
                return getMain(str.substring(2));
            case 'D':
                return getDrink(str.substring(2));
            case 'S':
                return getSide(str.substring(2));
            default:
                return 0;
        }
    }
}


public class java26_02 {
    public static boolean checkSet(String set)
    {
        if (set.charAt(0) == '1') {  return true; }
        else if (set.charAt(0) == '2') { return false; }
        else { return false; }
    }

    public static void main(String[] args) {
        MENU_STRINGS STRS= new MENU_STRINGS();
        Separate separate= Separate.getInstance();
        Scanner sc= new Scanner(System.in);
        boolean isSet= false;

//        Progress Order
//        Main
        System.out.printf("Order: Main Menu  ");
        System.out.printf("[");
        for (String element : STRS.getMainMenu()) System.out.printf("/ " + element + " ");
        System.out.printf("]\n");
        String s_main_menu= "M " + sc.nextLine();
        System.out.println("Upgrade set? (YES 1, NO 2)");
        isSet= checkSet(sc.nextLine());

//        Drink
        System.out.printf("Order: Drink  ");
        System.out.printf("[");
        for (String element : STRS.getDRINK()) System.out.printf("/ " + element + " ");
        System.out.printf("]\n");
        String s_drink= "D " + sc.nextLine();

//        Side menu
        System.out.printf("Order: Side menu  ");
        System.out.printf("[");
        for (String element : STRS.getSideMenu()) System.out.printf("/ " + element + " ");
        System.out.printf("]\n");
        String s_side_menu= "S " + sc.nextLine();

//        Init
        BurgerSelf burger= new BurgerSelf(isSet, s_main_menu, separate.getMain(s_main_menu));
        FoodSelf drink= new FoodSelf(s_drink, separate.getDrink(s_drink));
        FoodSelf side= new FoodSelf(s_side_menu, separate.getSide(s_side_menu));

//        Save
        Vector<Object> order_A= new Vector<>();
        order_A.add(burger); order_A.add(drink); order_A.add(side);
        BurgerSelf a_main= (BurgerSelf) order_A.get(0);
        FoodSelf a_drink= (FoodSelf) order_A.get(1);
        FoodSelf a_side= (FoodSelf) order_A.get(2);

//        Output
        String print_main_menu= a_main.getName();
        String print_drink= a_drink.getName();
        String print_side_menu= a_side.getName();
        int price_main= separate.initSeparate(print_main_menu);
        int price_drink= separate.initSeparate(print_drink);
        int price_side= separate.initSeparate(print_side_menu);

        System.out.println("========= Order A =========");
        if (a_main.isSet()) { print_main_menu+= " Set"; }
        System.out.printf("Burger: %s\n", print_main_menu.substring(2));
        System.out.printf("Drink:  %s\n", print_drink.substring(2));
        System.out.printf("Side:   %s\n", print_side_menu.substring(2));
        System.out.println("===========================");
        System.out.printf("/ %d / %d / %d /\n", price_main, price_drink, price_side);
        System.out.printf("Amount: %d", price_main+price_drink+price_side);
    }
}
