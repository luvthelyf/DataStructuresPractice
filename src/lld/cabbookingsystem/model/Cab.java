package lld.cabbookingsystem.model;

public class Cab {

    private final int id;

    public Cab(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                '}';
    }
}
