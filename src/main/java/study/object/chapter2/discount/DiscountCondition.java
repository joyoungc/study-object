package study.object.chapter2.discount;

import study.object.chapter2.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
