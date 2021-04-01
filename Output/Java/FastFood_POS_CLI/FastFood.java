package FastFood_POS_CLI;

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

class BurgerSelf extends FastFood_POS_CLI.FoodSelf
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
    FastFood_POS_CLI.MENU_STRINGS strs_menu;
    private class Main
    {
        private static final int big_mac= 4500;
//        ...

        private int[] MENUS= {big_mac};
        protected int getMENUS(int index) { return MENUS[index]; }
    }
    private class Drink
    {
        private static final int coka_cola= 2000;
        //        ...
        private int[] MENUS= {coka_cola};
        protected int getMENUS(int index) { return MENUS[index]; }
    }
    private class Side
    {
        private static final int sake_ice_cream= 1500;
        //        ...
        private int[] MENUS= {sake_ice_cream};
        protected int getMENUS(int index) { return MENUS[index]; }
    }

    private FastFood_POS_CLI.Price.Main M;
    private FastFood_POS_CLI.Price.Drink D;
    private FastFood_POS_CLI.Price.Side S;

    //    Singleton
    protected Price(){}
    private static class InnerInstanceClazz{ private static final FastFood_POS_CLI.Price instance= new FastFood_POS_CLI.Price(); }
    protected static FastFood_POS_CLI.Price getInstance()   { return FastFood_POS_CLI.Price.InnerInstanceClazz.instance; }

    /**
     *  Key(Food name)-Value(Food price)  =>  "map"
     * */
    private int e_String() { System.out.println(STRING.E_STRING); return -1; }
    //    Main
    protected int getMain(String str)
    {
        String[] menu= strs_menu.getMainMenu();
        int index= strs_menu.getIndex(menu, str);
        if (index >= 0) return M.getMENUS(index);
        else { return e_String(); } // -1
    }

    //    Drink
    protected int getDrink(String str)
    {
        String[] menu= strs_menu.getDRINK();
        int index= strs_menu.getIndex(menu, str);
        if (menu[index].equals(str)) return D.coka_cola;
//        else if (str == menu[i]) return D.something;
        else { return e_String(); } // -1
    }

    //    Side
    protected int getSide(String str) {
        String[] menu= strs_menu.getSideMenu();
        int index= strs_menu.getIndex(menu, str);
        if (menu[index].equals(str)) return S.sake_ice_cream;
//        else if (str == menu[i]) return S.something;
        else { return e_String(); } // -1
    }
}
class Separate extends FastFood_POS_CLI.Price
{
    private Separate() {}
    private static class InnerInstanceClass { private static final FastFood_POS_CLI.Separate instance= new FastFood_POS_CLI.Separate(); }
    public static FastFood_POS_CLI.Separate getInstance() {
        return FastFood_POS_CLI.Separate.InnerInstanceClass.instance;
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

    public static void main(String[] args) {
        boolean isSet= false;
        int order_count= 1;

        FastFood_POS_CLI.Separate separate= FastFood_POS_CLI.Separate.getInstance();
        FastFood_POS_CLI.MENU_STRINGS STRS= new FastFood_POS_CLI.MENU_STRINGS();
        Scanner sc= new Scanner(System.in);

//        Progress Order
//        Main
        String s_main_menu= setFood(STRING.MAIN, STRS.getMainMenu(), "M ");
        System.out.println(STRING.UPGRADE);
        isSet= checkSet(sc.nextLine());

//        Drink
        String s_drink= setFood(STRING.DRINK, STRS.getDRINK(),"D ");
        System.out.println(s_drink);

//        Side menu
        String s_side_menu= setFood(STRING.SIDE,STRS.getSideMenu(),"S ");
        System.out.println(s_side_menu);

//        Init && Save
        Vector<Object> order_A= new Vector<>();
        final int INDEX_main= 0; final int INDEX_drink= 1; final int INDEX_side= 2;
        order_A.add(new FastFood_POS_CLI.BurgerSelf(isSet, s_main_menu, separate.getMain(s_main_menu)));
        order_A.add(new FastFood_POS_CLI.FoodSelf(s_drink, separate.getDrink(s_drink)));
        order_A.add(new FastFood_POS_CLI.FoodSelf(s_side_menu, separate.getSide(s_side_menu)));

        FastFood_POS_CLI.BurgerSelf a_main= (FastFood_POS_CLI.BurgerSelf) order_A.get(INDEX_main);
        FastFood_POS_CLI.FoodSelf a_drink = (FastFood_POS_CLI.FoodSelf) order_A.get(INDEX_drink);
        FastFood_POS_CLI.FoodSelf a_side  = (FastFood_POS_CLI.FoodSelf) order_A.get(INDEX_side);

//        Output
        final int ORDER_LEN = order_A.size();
        int[] menu_prices   = new int[ORDER_LEN];
        String[] menu_names = new String[ORDER_LEN];

//        Remove separate-tag && Get each a price-value
        menu_names[INDEX_main] = a_main.getName();
        menu_names[INDEX_drink]= a_drink.getName();
        menu_names[INDEX_side] = a_side.getName();
        menu_prices[INDEX_main] = separate.initSeparate(menu_names[INDEX_main]);
        menu_prices[INDEX_drink]= separate.initSeparate(menu_names[INDEX_drink]);
        menu_prices[INDEX_side] = separate.initSeparate(menu_names[INDEX_side]);

        System.out.printf(STRING.ORDER, countOrder(order_count));
        if (a_main.isSet()) { menu_names[INDEX_main]+= " Set"; }
        System.out.printf ("Burger: %s\n", menu_names[INDEX_main].substring(2));
        System.out.printf ("Drink:  %s\n", menu_names[INDEX_drink].substring(2));
        System.out.printf ("Side:   %s\n", menu_names[INDEX_side].substring(2));
        System.out.println(STRING.LINE);
        for (int price:menu_prices) System.out.printf("/ %d ", price);
        System.out.println();
        System.out.printf ("Amount: %d", Arrays.stream(menu_prices).sum());
    }
}
