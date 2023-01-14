package study.object.ticket;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 매표소 : 관람객에게 판매할 티켓과 티켓의 판매금액을 보관
 */
@Getter
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = new ArrayList<>(Arrays.asList(tickets));
    }

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

}
