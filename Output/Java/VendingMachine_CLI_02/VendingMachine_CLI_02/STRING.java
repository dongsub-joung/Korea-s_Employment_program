package VendingMachine_CLI_02;

class STRING
{
    public static final String E_OUT_RANCE=      "Out of option range.";
    public static final String E_OUT_OF_PRODUCT= "Out of Product range.";
    public static final String LEAK=             "Scant of money. Enter more money!";
    public static final String MORE=             "If you purchase a drink, enter more money! (Shortage: %d)  \n ";

    public static final String LINE=          "==================";
    public static final String RECHARGE=      "==>> Change: %d <<==\n";
    public static final String SELECTED=      "Enter a Number you choose  ";
    public static final String ENTER_COIN=    "Enter the coin in machine!";
    public static final String PRESENT_COIN=  "[ %d present entered money] \n";

    static class MAIN
    {
        public static final String WAKE_UP=   "WAKE UP";
        public static final String LOGIC=     "| Continue (1) | Exit (2) |";
        public static final String SHUT_DOWN= "Already Shut Down (err: Entered User Code 005)";
        public static final String EXIT=      "EXIT";
    }

    static class INIT
    {
        private static final String TOP_LINE = "====== TOP-MENU ======";
        private static final String INPUT_COIN  = "1. Enter Coin";
        private static final String PRINT_MENU  = "2. Print Menu";
        private static final String PRINT_COINS = "3. Print Present entered coin";
        private static final String SELECT      = "4. Select";
        private static final String EXIT        = "5. Exit";
        private static final String BNT_LINE = "====== Selecting ======";

        public static final String[] INIT= {TOP_LINE,INPUT_COIN,PRINT_MENU,PRINT_COINS,SELECT,EXIT,BNT_LINE};
    }

    static class MENU
    {
        private MENU(){}
        private static class innerINstanceClass { private static MENU instance= new MENU(); }
        public static MENU getInstance() { return innerINstanceClass.instance; }

        public static final String ZERO=  "0. Return to TOP-MENU";
        private static final String ONE=  "1. Americano (2000) ";
        private static final String TWO=  "2. Caffe     (3000) ";
        private static final String THERE="3. Caramel   (5000) ";
        private static final String FORE= "4. Today's  (4000) ";

        //        If you want to add something, enter String value here.
//        Then, push String-variable in MENU Array. && in OUTPUT Class
        public static final String[] ONLY_MENU= {LINE,ONE,TWO,THERE,FORE};
        public static final String[] MENU= {LINE,ZERO,ONE,TWO,THERE,FORE};
    }

    static class OUTPUT
    {
        private OUTPUT(){}
        private static class innerInstanceClass{ private static OUTPUT instance= new OUTPUT(); }
        public static OUTPUT getInstance() { return innerInstanceClass.instance; }

        public static final String AMERICANO= "  1. Americano (2000)";
        public static final String RATE=      "  2. Caffe     (3000)";
        public static final String CARAMEL=   "  3. Caramel   (5000)";
        public static final String TODAY=     "  4. Today's   (4000)";
    }
}