import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void testSortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","KZN",1000,90 );
        Ticket ticket2 = new Ticket(2,"MSK","SPB",1200,95 );
        Ticket ticket3 = new Ticket(3,"MSK","KZN",800,130 );
        Ticket ticket4 = new Ticket(4,"MSK","SPB",1400,80 );
        Ticket ticket5 = new Ticket(5,"MSK","UFA",1500,140 );
        Ticket ticket6 = new Ticket(6,"SPB","MSK",1200,95 );
        Ticket ticket7 = new Ticket(7,"MSK","KZN",800,135 );
        Ticket ticket8 = new Ticket(8,"UFA","MSK",2000,140 );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3,ticket7, ticket1};
        Ticket[] actual = manager.findAll("MSK","KZN");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testSortTicketsByDuration() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","KZN",1000,90 );
        Ticket ticket2 = new Ticket(2,"MSK","SPB",1200,95 );
        Ticket ticket3 = new Ticket(3,"MSK","KZN",800,130 );
        Ticket ticket4 = new Ticket(4,"MSK","SPB",1400,80 );
        Ticket ticket5 = new Ticket(5,"MSK","UFA",1500,140 );
        Ticket ticket6 = new Ticket(6,"SPB","MSK",1200,95 );
        Ticket ticket7 = new Ticket(7,"MSK","KZN",800,125 );
        Ticket ticket8 = new Ticket(8,"UFA","MSK",2000,140 );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1,ticket7, ticket3};
        Ticket[] actual = manager.findAll("MSK","KZN",new TicketByDurationAscComparator());

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void findAll() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","KZN",1000,90 );
        Ticket ticket2 = new Ticket(2,"MSK","SPB",1200,95 );
        Ticket ticket3 = new Ticket(3,"MSK","KZN",800,130 );
        Ticket ticket4 = new Ticket(4,"MSK","SPB",1400,80 );
        Ticket ticket5 = new Ticket(5,"MSK","UFA",1500,140 );
        Ticket ticket6 = new Ticket(6,"SPB","MSK",1200,95 );
        Ticket ticket7 = new Ticket(7,"MSK","KZN",800,125 );
        Ticket ticket8 = new Ticket(8,"UFA","MSK",2000,140 );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1,ticket2,ticket3,ticket4,ticket5,ticket6,ticket7,ticket8};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void findFewTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","KZN",1000,90 );
        Ticket ticket2 = new Ticket(2,"MSK","SPB",1200,95 );
        Ticket ticket3 = new Ticket(3,"MSK","KZN",800,130 );
        Ticket ticket4 = new Ticket(4,"MSK","SPB",1400,80 );
        Ticket ticket5 = new Ticket(5,"MSK","UFA",1500,140 );
        Ticket ticket6 = new Ticket(6,"SPB","MSK",1200,95 );
        Ticket ticket7 = new Ticket(7,"MSK","KZN",800,125 );
        Ticket ticket8 = new Ticket(8,"UFA","MSK",2000,140 );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3,ticket7,ticket1,};
        Ticket[] actual = manager.findAll("MSK","KZN");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void findOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","KZN",1000,90 );
        Ticket ticket2 = new Ticket(2,"MSK","SPB",1200,95 );
        Ticket ticket3 = new Ticket(3,"MSK","KZN",800,130 );
        Ticket ticket4 = new Ticket(4,"MSK","SPB",1400,80 );
        Ticket ticket5 = new Ticket(5,"MSK","UFA",1500,140 );
        Ticket ticket6 = new Ticket(6,"SPB","MSK",1200,95 );
        Ticket ticket7 = new Ticket(7,"MSK","KZN",800,125 );
        Ticket ticket8 = new Ticket(8,"UFA","MSK",2000,140 );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAll("SPB","MSK");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void ticketNotFound() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","KZN",1000,90 );
        Ticket ticket2 = new Ticket(2,"MSK","SPB",1200,95 );
        Ticket ticket3 = new Ticket(3,"MSK","KZN",800,130 );
        Ticket ticket4 = new Ticket(4,"MSK","SPB",1400,80 );
        Ticket ticket5 = new Ticket(5,"MSK","UFA",1500,140 );
        Ticket ticket6 = new Ticket(6,"SPB","MSK",1200,95 );
        Ticket ticket7 = new Ticket(7,"MSK","KZN",800,125 );
        Ticket ticket8 = new Ticket(8,"UFA","MSK",2000,140 );
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SPB","KZN");

        Assertions.assertArrayEquals(expected,actual);
    }
}