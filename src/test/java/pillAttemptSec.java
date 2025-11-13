import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class represents the system that is using the pill counter.
 * What this class does is illustrated in a test only so
 * that you can run this. In reality, this usage is
 * embedded deep into a larger system, interfacing with actual
 * conveyer belts that are bottling pills.
 */
public class pillAttemptSec {

  /**
   * You may think of this as representative of the client
   * of a pill counter. It represents a heavy usage of the
   * pill counter, responding to an actual conveyer belt
   * that is bottling a large quantity of pill bottles of varying capacities.
   */

  @Test
  public void usage() {
    LoggingPillCounter real = new LoggingPillCounter();

    checkTimes monitor = new checkTimes(real);

    boolean result = conveyorBelt(monitor);
    assertTrue(result);

    System.out.println(monitor.getAddCounts());
  }

  private boolean conveyorBelt(PillCounter counter) {

    for (int bottle = 0; bottle < 100; bottle++) {
      for (int pill = 0; pill < 100; pill++) {
        counter.addPill(1);
      }
      assertEquals(100, counter.getPillCount());
      counter.reset();
    }

    for (int bottle = 0; bottle < 1000; bottle++) {
      for (int pill = 0; pill < 20; pill += 4) {
        counter.addPill(4);
      }
      assertEquals(20, counter.getPillCount());
      counter.reset();
    }

    for (int bottle = 0; bottle < 500; bottle++) {
      for (int pill = 0; pill < 200; pill += 2) {
        counter.addPill(2);
      }
      assertEquals(200, counter.getPillCount());
      counter.reset();
    }

    return true;
  }
}