package FastFood_POS_CLI;

import java.time.LocalDate;
import java.time.LocalTime;
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
    }

    public boolean isSet() {
        return isSet;
    }
}

class MENU_STRINGS
{
    private static final String[] MAIN_MENU= { "big mac" };
    private static final String[] DRINK    = { "coka cola" };
    private static final String[] SIDE_MENU= { "sake ice cream" };

    public static String[] getMainMenu() { return MAIN_MENU; }
    public static String[] getDRINK()    { return DRINK; }
    public static String[] getSideMenu() { return SIDE_MENU; }

    public static int getIndex(String[] str_arr, String str)
    {
        int index= 0;
        for (int i = 0; i < str_arr.length; i++)
        {
            if (str_arr[i].equals(str)) index= i;
            else index= -1;
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

        private int[] MENUS= {big_mac};
    }
    private class Drink
    {
        private static final int coka_cola= 2000;
//        ...
        private int[] MENUS= {coka_cola};
    }
    private class Side
    {
        private static final int sake_ice_cream= 1500;
//        ...
        private int[] MENUS= {sake_ice_cream};
    }

    private Main M= new Main();
    private Drink D= new Drink();
    private Side S= new Side();

    //    Singleton
    protected Price(){}
    private static class InnerInstanceClazz{ private static final Price instance= new Price(); }
    protected static Price getInstance()   { return InnerInstanceClazz.instance; }

    /**
     *  Key(Food name)-Value(Food price)  =>  "map"
     * */
    private int e_String() { System.out.println(STRING.E_STRING); return -1; }
    //    Main
    protected int getMain(String str)
    {
        str= str.toLowerCase();
        String[] menu= strs_menu.getMainMenu();
        int index= strs_menu.getIndex(menu, str);
        if (index >= 0) return M.MENUS[index];
        else { return e_String(); } // -1
    }

    //    Drink
    protected int getDrink(String str)
    {
        str= str.toLowerCase();
        String[] menu= strs_menu.getDRINK();
        int index= strs_menu.getIndex(menu, str);
        if (index >= 0) return D.MENUS[index];
        else { return e_String(); } // -1
    }

    //    Side
    protected int getSide(String str)
    {
        str= str.toLowerCase();
        String[] menu= strs_menu.getSideMenu();
        int index= strs_menu.getIndex(menu, str);
        if (index >= 0) return S.MENUS[index];
        else { return e_String(); } // -1
    }
}
class Separate extends Price
{
    private Separate() {}
    private static class InnerInstanceClass { private static final Separate instance= new Separate(); }
    public static Separate getInstance() {
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


public class FastFood
{
    private static char countOrder(int order_count)
    {
        return (char) ('A'+ order_count-1);
    }

    private static boolean checkSet(String set)
    {
        final char SET= '1'; final char NOT_SET= '2';
        if (set.charAt(0) == SET) {  return true; }
        else if (set.charAt(0) == NOT_SET) { return false; }
        else { return false; }
    }

    private static String setFood(String start_str, String[] menu_strs, String slide)
    {
        System.out.printf(start_str);
        System.out.printf(STRING.OPEN);
        for (String element : menu_strs) System.out.printf("/ " + element + " ");
        System.out.printf(STRING.CLOSE);
        return slide + new Scanner(System.in).nextLine();
    }

    public static void printOrders(String order, String name)
    {
        System.out.printf(order, name.substring(2));
    }

    public static void printTime()
    {
        LocalDate today= LocalDate.now();
        LocalTime now= LocalTime.now();

        System.out.println(today);
        System.out.println(now);
    }

    public static void main(String[] args) {
        boolean isSet= false;
        int order_count= 1;

        Separate separate= Separate.getInstance();
        MENU_STRINGS STRS= new MENU_STRINGS();
        Scanner sc= new Scanner(System.in);

        String s_main_menu= ""; String s_drink= ""; String s_side_menu= "";
        boolean pass_main= false; boolean pass_drink= false; boolean pass_side= false;

        while (true)
        {
//        Progress Order
            String[] mains= STRS.getMainMenu();
            s_main_menu= setFood(STRING.MAIN, mains, "M ");
            int a_index= STRS.getIndex(mains, s_main_menu.substring(2));
            if (a_index == -1) { System.out.println(STRING.E_STRING); continue;}
            else
            {
                System.out.println(STRING.UPGRADE);
                isSet= checkSet(sc.nextLine());
                pass_main= true;
            }

            String[] drinks= STRS.getDRINK();
            s_drink= setFood(STRING.DRINK, drinks,"D ");
            int b_index= STRS.getIndex(drinks,s_drink.substring(2));
            if (b_index == -1) { System.out.println(STRING.E_STRING); continue;}
            else { pass_drink= true; }

            String[] sides= STRS.getSideMenu();
            s_side_menu= setFood(STRING.SIDE,STRS.getSideMenu(),"S ");
            int c_index= STRS.getIndex(sides, s_side_menu.substring(2));
            if (c_index == -1) { System.out.println(STRING.E_STRING); continue;}
            else { pass_side= true; }

            if (pass_main && pass_drink && pass_side) { break; }
        }

//        Init && Save
        Vector<Object> order_A= new Vector<>();
        final int INDEX_main= 0; final int INDEX_drink= 1; final int INDEX_side= 2;
        order_A.add(new BurgerSelf(isSet, s_main_menu, separate.initSeparate(s_main_menu)));
        order_A.add(new FoodSelf(s_drink, separate.initSeparate(s_drink)));
        order_A.add(new FoodSelf(s_side_menu, separate.initSeparate(s_side_menu)));

        BurgerSelf a_main= (BurgerSelf) order_A.get(INDEX_main);
        FoodSelf a_drink = (FoodSelf) order_A.get(INDEX_drink);
        FoodSelf a_side  = (FoodSelf) order_A.get(INDEX_side);

//        Output
        final int ORDER_LEN = order_A.size();

//        Remove separate-tag && Get each a price-value
        String[] menu_names = new String[ORDER_LEN];
        menu_names[INDEX_main] = a_main.getName();
        menu_names[INDEX_drink]= a_drink.getName();
        menu_names[INDEX_side] = a_side.getName();

        int[] menu_prices   = new int[ORDER_LEN];
        menu_prices[INDEX_main] = separate.initSeparate(menu_names[INDEX_main]);
        menu_prices[INDEX_drink]= separate.initSeparate(menu_names[INDEX_drink]);
        menu_prices[INDEX_side] = separate.initSeparate(menu_names[INDEX_side]);

        System.out.printf(STRING.ORDER, countOrder(order_count)); printTime();
        if (a_main.isSet()) { menu_names[INDEX_main]+= " Set"; }
        printOrders("Burger: %s\n", menu_names[INDEX_main]);
        printOrders("Drink:  %s\n", menu_names[INDEX_drink]);
        printOrders("Side:   %s\n", menu_names[INDEX_side]);
        System.out.println(STRING.LINE);
        for (int price:menu_prices) System.out.printf("/ %d ", price);
        System.out.println();
        System.out.printf ("Amount: %d", Arrays.stream(menu_prices).sum());
    }
}
