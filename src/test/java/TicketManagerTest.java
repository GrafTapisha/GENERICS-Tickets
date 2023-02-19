import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketManagerTest {


    @Test

    public void testFindAllFewTicketsFond() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(100, 30_000, "SVX", "DME", 90);
        Ticket ticket2 = new Ticket(500, 10_000, "DYR", "BCX", 360);
        Ticket ticket3 = new Ticket(600, 12_000, "DME", "SVX", 100);
        Ticket ticket4 = new Ticket(1, 1_000, "SVX", "DME", 60);
        Ticket ticket5 = new Ticket(76, 6_000, "SVX", "DME", 70);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("SVX", "DME");
        Ticket[] expected = {ticket4, ticket5, ticket1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testFindAllNonTicketsFond() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(100, 30_000, "SVX", "DME", 90);
        Ticket ticket2 = new Ticket(500, 10_000, "DYR", "BCX", 360);
        Ticket ticket3 = new Ticket(600, 12_000, "DME", "SVX", 100);
        Ticket ticket4 = new Ticket(1, 1_000, "SVX", "DME", 60);
        Ticket ticket5 = new Ticket(76, 6_000, "SVX", "BCX", 70);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("NAL", "GOJ");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testFindAllOneTicketFond() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(100, 30_000, "SVX", "DME", 90);
        Ticket ticket2 = new Ticket(500, 10_000, "DYR", "BCX", 360);
        Ticket ticket3 = new Ticket(600, 12_000, "DME", "SVX", 100);
        Ticket ticket4 = new Ticket(1, 1_000, "SVX", "DME", 60);
        Ticket ticket5 = new Ticket(76, 6_000, "SVX", "BCX", 70);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("DYR", "BCX");
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testFindAllFewTicketsFondSorted() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(100, 3_000, "SVX", "DME", 90);
        Ticket ticket2 = new Ticket(500, 10_000, "SVX", "DME", 360);
        Ticket ticket3 = new Ticket(600, 12_000, "PWE", "SVX", 100);
        Ticket ticket4 = new Ticket(1, 1_000, "ROV", "DME", 60);
        Ticket ticket5 = new Ticket(76, 6_000, "DME", "ROV", 70);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("SVX", "DME");
        Ticket[] expected = {ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testFindAllFewTicketsFondNotSorted() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(100, 33_000, "SVX", "DME", 90);
        Ticket ticket2 = new Ticket(500, 10_000, "SVX", "DME", 360);
        Ticket ticket3 = new Ticket(600, 12_000, "PWE", "SVX", 100);
        Ticket ticket4 = new Ticket(1, 1_000, "ROV", "DME", 60);
        Ticket ticket5 = new Ticket(76, 6_000, "DME", "ROV", 70);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll("SVX", "DME");
        Ticket[] expected = {ticket2, ticket1};

        Assertions.assertArrayEquals(expected, actual);

    }

}