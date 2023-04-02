package study.object.chapter2.discount;

import study.object.Money;
import study.object.chapter2.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
