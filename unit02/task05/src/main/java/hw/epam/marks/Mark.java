package hw.epam.marks;

/**
 * Created by MM8 on 02.03.2017.
 */
public abstract class Mark<T extends Number> {
    private T value;

    public Mark(T value){
        checkValueType(value);
        this.value = value;
    }

    protected abstract void checkValueType(T value) throws NullPointerException, IllegalArgumentException;

    public T getValue() {
        return value;
    }
}
