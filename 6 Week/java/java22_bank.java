class Bank {
    private int balance;
    private static double rateY= 0.05;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static double getRateY() {
        return rateY;
    }

    public static void setRateY(double rateY) {
        Bank.rateY = rateY;
    }
}

public class java22_bank {
    public static void main(String[] args) {
        Bank kakaoB= new Bank();
        Bank naverB= new Bank();
        kakaoB.setBalance(10000);
        naverB.setBalance(20000);

        int k_amount= kakaoB.getBalance();
        int n_amount= naverB.getBalance();
        double k_perARate= kakaoB.getRateY()/12;
        double n_perARate= naverB.getRateY()/12;
        int first_kakao= (int)(k_amount * k_perARate);
        int first_naver= (int)(n_amount * n_perARate);
        System.out.printf("카카오 계좌의 첫달 이자는 %d원\n", first_kakao);
        System.out.printf("네이버 계좌의 첫달 이자는 %d원\n", first_naver);
        System.out.println("=============================");
        System.out.println("연이자 6%");
        Bank.setRateY(0.06);
        double a= kakaoB.getRateY()/12;
        double b= naverB.getRateY()/12;
        first_kakao= (int)(a*k_amount);
        first_naver= (int)(b*n_amount);
        System.out.printf("카카오 계좌의 이자는 %d원\n", first_kakao);
        System.out.printf("네이버 계좌의 이자는 %d원\n", first_naver);
    }
}
