package stationery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MM8 on 01.03.2017.
 */
public class OfficeWorker {
    private String workerName;
    private List Statoneries = new ArrayList<Stationery>();

    public OfficeWorker(String workerName){
        this.workerName = workerName;
    }

    public void addStationery(Stationery newStationery){
        Statoneries.add(newStationery);
    }

    public List<Stationery> getStationeries(){
        return Collections.unmodifiableList(Statoneries);
    }

}
