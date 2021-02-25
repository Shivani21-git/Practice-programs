package interview;

public final class CarImmutableObject {
    final String name;

    public CarImmutableObject(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
