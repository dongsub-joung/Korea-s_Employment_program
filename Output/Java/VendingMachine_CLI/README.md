 README.md

# VendingMachine, 自販機

## class

- STRINGS class  
	- static MACHINE class  
	- static MAIN_STRING class  
	- static PRODUCT_STRING class  
	- static COIN_STRING class  

- Product class  

- VendingMachine class  

- VendingMachineMain class


## Variable, method

### Product  

**Class variable**
- private final int strob= 3000  
- private final int vanilla= 3500  
- private final int choco= 4000  
- private final int blueb= 4500  

**Method**
- Getter

### VendingMachine  

**Class variable**  
- private int g_coin= 0  

**Method**  
- public void setCoin(int coin)
- public int printRemainMoney()
- public void addCoin(int calculated)
- public void buy(int g_price)

### public VendingMachineMain

**Class variable**  
- private static int g_selected_menu= 0  
- private static int g_selected_price= 0  
- private static boolean g_introBTN= false  
- private static boolean g_break_menu= false  

**Method**  
static public void selectProduct(int menu)  
private static int startIntroQuestion()  
private static void setG_selected_price(int price)  
private static void setSelectedMenu(int number)  
public static void setG_coin(int coin)  
private static void printPresentCoin()  

**progress control method: public static void main(String[] args)**
private static void responseQuestion(int kind)
private static void startVending()
private static void selectMenu()
private static void paidPrice()
private static void accounting()