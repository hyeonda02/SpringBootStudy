package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGraed() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
