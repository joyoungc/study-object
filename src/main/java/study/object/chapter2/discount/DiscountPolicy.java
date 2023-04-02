package study.object.chapter2.discount;

import study.object.Money;
import study.object.chapter2.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
