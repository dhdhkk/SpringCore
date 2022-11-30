package study.core.singleton;

// 테스트 바로 만들기 단축키 : cmd + shift + T
public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price)
    {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!
    }

    public int getPrice() {
        return price;
    }


}
