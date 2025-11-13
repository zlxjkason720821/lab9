import java.util.ArrayList;
import java.util.List;

public class checkTimes extends PillCounterFir {

  private int count = 0;
  private List<Integer> times = new ArrayList<>();

  public checkTimes(PillCounter delegate) {
    super(delegate);
  }

  @Override
  public void addPill(int c) {
    count += c;
    super.addPill(c);
  }

  public void reset() {
    times.add(count);
    count = 0;
    super.reset();
  }

  public List<Integer> getAddCounts() {
    return times;
  }
}
