package lld.parkinglot.model.gate;

public interface Gate {
    void open();
    void close();
    void allowPassage();
    String toString();
}
