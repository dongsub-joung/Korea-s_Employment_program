public class java03 {
    public boolean checkingPass(boolean army, int h)
    {
        final int MIN_H= 170;
        if (army && h>MIN_H) return true;
        else return false;
    }

    public static void main(String[] args) {

        String name= "c";
        java03 jv= new java03();
        boolean result= jv.checkingPass(true, 180);
        String passOrNot= "";
        if (result == true) passOrNot= "통과";
        else passOrNot="탈락";
        System.out.println("회사" + name + "의 면접결과는 " + passOrNot + "입니다.");
    }
}

