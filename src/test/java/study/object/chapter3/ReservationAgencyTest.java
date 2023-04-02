package study.object.chapter3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.object.Money;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

class ReservationAgencyTest {

    @Test
    void test_reserve() {
        ReservationAgency reservationAgency = new ReservationAgency();

        // DiscountCondition
        DiscountCondition condition = new DiscountCondition();
        condition.setDayOfWeek(DayOfWeek.MONDAY);
        condition.setStartTime(LocalTime.of(10, 0));
        condition.setEndTime(LocalTime.of(20, 59));
        condition.setType(DiscountConditionType.PERIOD);

        // Movie
        Movie movie = new Movie();
        movie.setTitle("아바타");
        movie.setMovieType(MovieType.AMOUNT_DISCOUNT);
        movie.setDiscountAmount(Money.wons(800));
        movie.setFee(Money.wons(20000));
        movie.setRunningTime(Duration.ofMinutes(120));
        movie.setDiscountConditions(List.of(condition));

        // Screening
        Screening screening = new Screening();
        screening.setMovie(movie);
        screening.setWhenScreened(LocalDateTime.of(2023,1,3,10,30));

        // Customer
        Customer customer = new Customer("Aiden", "1");

        Reservation reserve = reservationAgency.reserve(screening, customer, 1);
        Assertions.assertThat(reserve).isNotNull();
    }

}