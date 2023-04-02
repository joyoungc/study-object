package study.object.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheaterTest {

    @Test
    void enter() {
        // given
        Ticket ticket1 = new Ticket(100L);
        Ticket ticket2 = new Ticket(200L);
        Ticket ticket3 = new Ticket(300L);
        TicketOffice ticketOffice = new TicketOffice(0L, ticket1, ticket2, ticket3);
        Theater theater = new Theater(new TicketSeller(ticketOffice));
        Audience audience1 = new Audience(new Bag(1000L, null));
        Audience audience2 = new Audience(new Bag(500L, new Invitation()));
        Audience audience3 = new Audience(new Bag(700L, null));

        // when
        theater.enter(audience1);

        // then
        assertEquals(audience1.getBag().getAmount(), 900L);
        assertEquals(ticketOffice.getAmount(), 100L);

        // when
        theater.enter(audience2);

        // then
        assertEquals(audience2.getBag().getAmount(), 500L);
        assertEquals(ticketOffice.getAmount(), 100L);

        // when
        theater.enter(audience3);

        // then
        assertEquals(audience3.getBag().getAmount(), 400L);
        assertEquals(ticketOffice.getAmount(), 400L);
    }
}