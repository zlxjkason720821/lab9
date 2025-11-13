import java.util.Objects;

public class BatchAddingDecorator extends PillCounterFir {

  private int time = 0;

  public BatchAddingDecorator(PillCounter delegate) {
    super(delegate);
  }

  @Override
  public void addPill(int n) {
    time += n;
  }

  private void write() {
    if (time > 0) {
      delegate.addPill(time);
      time = 0;
    }
  }

  @Override
  public int getPillCount() {
    write();
    return delegate.getPillCount();
  }

  @Override
  public void reset() {
    write();
    delegate.reset();
  }
}