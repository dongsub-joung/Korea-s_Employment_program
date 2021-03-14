// Java의 정석 p 320- 상속 예제

class Card {
    static final int KIND_MAX= 4;
    static final int NUM_MAX= 13;
    static final int SPADE= 4;
    static final int DIAMOND= 3;
    static final int HEART =2;
    static final int CLOVER= 1;

    int kind;
    int number;

    Card () { this(SPADE, 1); }
    Card (int kind, int number)
    {
        this.kind= kind;
        this.number= number;
    }
    public String toString()
    {
        String[] kinds= {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers= "0123456789XJQK";
        return "kind : " + kinds[this.kind] + ", nuber :" + numbers.charAt(this.number);
    }
}

class Deck {
    final int CARD_NUM= 52;
//    52개의 Card 객체 배열을 위한 공간 생성 && 참조, 아직 초기화 x
//    카드 객체배열은 참조변수 배열이고 실제로 저장된 것은 객체가 아니라 객체의 주소다.
//    객체 할당이 많으면 반복문을 이용해서 메모리에 올려야함. (new 할당)
    Card[] cardArr= new Card[CARD_NUM];

    Deck() {
        int i= 0;
        for (int k=Card.KIND_MAX; k>0; k--)
            for (int n=0; n<Card.NUM_MAX; n++)
                cardArr[i++]= new Card(k, n+1);
//            for문 돌리면서 new
    }
    Card pick(int index)
    {
        return cardArr[index];
    }
    Card pick()
    {
        int index= (int)(Math.random()*CARD_NUM);
        return pick(index);
    }
    void shuffle()
    {
        for (int i=0; i<cardArr.length; i++)
        {
            int r= (int)(Math.random()*CARD_NUM);

            Card temp= cardArr[i];
            cardArr[i]= cardArr[r];
            cardArr[r]= temp;
        }
    }
}

public class inheritance_ex {
    public static void main(String[] args) {
        Deck d= new Deck();
        Card c= d.pick(0);
//        = System.out.println(c.toString());
        System.out.println(c);

        d.shuffle();
        c= d.pick(0);
        System.out.println(c);
    }
}