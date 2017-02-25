package epam.hw.pen;

/**
 * Created by MM8 on 25.02.2017.
 */
public class Pen {
    private int penId;
    private PenManufacturer manufacturer;
    private int price;
    protected static final int maxInkLevel = 100;
    private boolean ableToWrite;
    private int inkLevel;
    private double inkConsumption;

    public void prepareToWrite(){
        setAbleToWrite(true);
    }

    public void write(){

    }

    public void endWriting(){
        setAbleToWrite(false);
    }

    public void refillPen(){
        inkLevel = maxInkLevel;
    }

    public boolean isAbleToWrite() {
        return ableToWrite;
    }

    public int checkInkLevel() {
        return inkLevel;
    }

    public void setAbleToWrite(boolean ableToWrite) {
        this.ableToWrite = ableToWrite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (penId != pen.penId) return false;
        return manufacturer == pen.manufacturer;

    }

    @Override
    public int hashCode() {
        int result = penId;
        result = 31 * result + manufacturer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "penId=" + penId +
                ", manufacturer=" + manufacturer +
                '}';
    }

    protected void setManufacturer(PenManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected void setInkLevel(int inkLevel) {
        this.inkLevel = inkLevel;
    }

    protected void setInkConsumption(double inkConsumption) {
        this.inkConsumption = inkConsumption;
    }
}
