package study.object.reservation;

import org.junit.jupiter.api.Test;
import study.object.reservation.discount.*;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {

    @Test
    void create_movie() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(20000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                )
        );

        Screening screening1 = new Screening(avatar, 3, LocalDateTime.of(2023, Month.MARCH, 13, 10, 0));
        Money money = avatar.calculateMovieFee(screening1);
        assertThat(money.getAmount().intValue()).isEqualTo(19200);

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(15000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                )
        );

        Screening screening2 = new Screening(titanic, 2, LocalDateTime.of(2023, Month.MARCH, 13, 10, 0));
        Money money2 = titanic.calculateMovieFee(screening2);
        assertThat(money2.getAmount().intValue()).isEqualTo(13500);

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy()
        );

        Screening screening3 = new Screening(starWars, 2, LocalDateTime.of(2023, Month.MARCH, 15, 10, 0));
        Money money3 = starWars.calculateMovieFee(screening3);
        assertThat(money3.getAmount().intValue()).isEqualTo(10000);

        starWars.changeDiscountPolicy(
                new PercentDiscountPolicy(0.1,
                        new SequenceCondition(3),
                        new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                )
        );

        Screening screening4 = new Screening(starWars, 3, LocalDateTime.of(2023, Month.MARCH, 15, 10, 0));
        Money money4 = starWars.calculateMovieFee(screening4);
        assertThat(money4.getAmount().intValue()).isEqualTo(9000);
    }
}
