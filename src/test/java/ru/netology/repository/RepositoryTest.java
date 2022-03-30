package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryTest {

    private TicketRepository repository = new TicketRepository();

    Ticket first = new Ticket(1, 1500, "ROV", "VOG", 70);
    Ticket second = new Ticket(2, 2000, "ROV", "VKO", 100);
    Ticket third = new Ticket(3, 2500, "ROV", "AER", 55);

    @Test
    void shouldSaveTicket() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Ticket expexted = first;
        Ticket ticket = repository.findById(1);
        assertEquals(expexted, ticket);
    }

    @Test
    void removeById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(1);

        Ticket[] expected = new Ticket[]{second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
}