package hw.epam.marks;

/**
 * Created by MM8 on 02.03.2017.
 */
public enum Disciplines {
    PHYSICS(Double.class),
    MATH(Double.class),
    PHILOSOPHY(Integer.class),
    ENGLISH(Integer.class),
    PROGRAMMING(Double.class);

    private Class markType;

    Disciplines(Class markType){
        this.markType = markType;
    }

    /**
     *
     * @param discipline
     * @param mark
     * @return true, if discipline can accept this kind of mark, other way exception
     * @throws IllegalArgumentException
     */
    public boolean canDisciplineAcceptThisKindOfMark(Disciplines discipline, Mark mark) throws IllegalArgumentException {
        if (discipline.markType.equals(mark.getValue().getClass())){
            return true;
        } else throw new IllegalArgumentException("This discipline mark has other type");
    }

}
