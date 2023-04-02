package study.object.chapter1;

import lombok.Getter;

/**
 * 관람객
 */
@Getter
public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
