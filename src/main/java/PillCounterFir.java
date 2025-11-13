public class PillCounterFir implements PillCounter {
  protected final PillCounter delegate;

  public PillCounterFir(PillCounter delegate) {
    this.delegate = delegate;
  }

  @Override
  public void addPill(int c) {
    delegate.addPill(c);
  }

  @Override
  public int getPillCount() {
    return delegate.getPillCount();
  }

  @Override
  public void reset() {
    delegate.reset();
  }

  @Override
  public void removePill() {
    delegate.removePill();
  }
}