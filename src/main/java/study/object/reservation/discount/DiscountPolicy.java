package study.object.reservation.discount;

import study.object.reservation.Money;
import study.object.reservation.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
