package study.core.discount;

import study.core.member.Grade;
import study.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) // enum 타입은 == 사용이 맞다.
        {
            return discountFixAmount;
        }else
        {
            return 0;
        }
    }
}
