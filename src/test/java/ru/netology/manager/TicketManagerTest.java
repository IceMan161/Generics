package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    Ticket first = new Ticket(1, 1500, "ROV", "VOG", 70);
    Ticket second = new Ticket(2, 2000, "ROV", "VKO", 100);
    Ticket third = new Ticket(3, 2500, "ROV", "AER", 55);

    @BeforeEach
    public void initEach() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldAdd() {
        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        Ticket[] expected = new Ticket[]{third};
        Ticket[] product = manager.searchBy("ROV", "AER");
        assertArrayEquals(expected, product);
    }

    @Test
    void shouldSortByCost() {
        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = new Ticket[]{first,second,third};

        Arrays.sort(expected);

        assertArrayEquals(expected, actual);
    }

}