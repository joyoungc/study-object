package study.object.reservation.discount;

import study.object.reservation.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
