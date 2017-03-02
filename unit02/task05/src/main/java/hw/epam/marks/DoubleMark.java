package hw.epam.marks;

import java.util.Objects;

/**
 * Created by MM8 on 02.03.2017.
 */
public class DoubleMark<T extends Double> extends Mark<Double>{
    public DoubleMark(T value) {
        super(value);
    }

    @Override
    protected void checkValueType(Double value) throws IllegalArgumentException {
        if (Objects.isNull(value)){
            throw new NullPointerException("Mark can`t be null");
        }
        if (value < 0){
            throw  new IllegalArgumentException("Mark must be greater than 0");
        }
    }
}
