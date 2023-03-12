package study.object.reservation.discount;

import study.object.reservation.Money;
import study.object.reservation.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
