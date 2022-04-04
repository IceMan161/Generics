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
    Ticket second = new Ticket(2, 2700, "ROV", "VKO", 100);
    Ticket third = new Ticket(3, 2500, "ROV", "AER", 55);
    Ticket fourth = new Ticket(4, 1600, "ROV", "AER", 3000);
    Ticket fifth = new Ticket(5, 3500, "ROV", "ADH", 3110);
    Ticket sixth = new Ticket(6, 1000, "ROV", "AMV", 3200);

    @Test
    void shouldAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Ticket[] expected = new Ticket[]{first, second, third, fourth, fifth, sixth};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByOneCoincidence() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Ticket[] expected = new Ticket[]{second};
        Ticket[] product = manager.searchBy("ROV", "VKO");

        assertArrayEquals(expected,product);
    }

    @Test
    void shouldSearchByTwoCoincidence() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Ticket[] expected = new Ticket[]{fourth,third};
        Ticket[] product = manager.searchBy("ROV", "AER");
        assertArrayEquals(expected, product);
    }

    @Test
    void shouldSearchByNoMatch() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Ticket[] expected = new Ticket[]{};
        Ticket[] product = manager.searchBy("ROV", "SAD");

        assertArrayEquals(expected,product);
    }

    @Test
    void shouldSortByCost() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Ticket[] expected = new Ticket[]{first, second, third, fourth, fifth, sixth};
        Ticket[] actual = new Ticket[]{sixth, first, fourth, third, second, fifth};

        Arrays.sort(expected);

        assertArrayEquals(expected, actual);
    }



}