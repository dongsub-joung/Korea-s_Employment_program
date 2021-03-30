 README.md

# VendingMachine, 自販機

## class

```
- STRINGS class  
	L static MACHINE class  
	L static MAIN_STRING class  
	L static PRODUCT_STRING class  
	L static COIN_STRING class  

- Product class  

- VendingMachine class  

- VendingMachineMain class
```

---  

## Variable, method

### Product  

```
**Class variable**  
 L private final int strob= 3000  
 L private final int vanilla= 3500  
 L private final int choco= 4000  
 L private final int blueb= 4500  

 - Getter  
```

---  
### VendingMachine  
```
** Class variable **  
 L private int g_coin= 0  

** Method **  
 L public void setCoin(int coin)
 L public int printRemainMoney()
 L public void addCoin(int calculated)
 L public void buy(int g_price)
```


---  
### public VendingMachineMain  

```
**Class variable**  
 L  private static int g_selected_menu= 0  
 L  private static int g_selected_price= 0  
 L  private static boolean g_introBTN= false  
 L  private static boolean g_break_menu= false  

**Method**  
 L  static public void selectProduct(int menu)  
 L  private static int startIntroQuestion()  
 L  private static void setG_selected_price(int price)  
 L  private static void setSelectedMenu(int number)  
 L  public static void setG_coin(int coin)  
 L  private static void printPresentCoin()  


**progress control method: public static void main(String[] args)**  
 L private static void responseQuestion(int kind)  
 L private static void startVending()  
 L private static void selectMenu()  
 L private static void paidPrice()  
 L private static void accounting()  

```
