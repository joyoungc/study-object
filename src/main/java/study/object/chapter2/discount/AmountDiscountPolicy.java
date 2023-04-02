package study.object.chapter2.discount;

import study.object.Money;
import study.object.chapter2.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
