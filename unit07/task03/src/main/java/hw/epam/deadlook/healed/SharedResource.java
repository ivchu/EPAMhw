package hw.epam.deadlook.healed;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new CopyOnWriteArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

}
