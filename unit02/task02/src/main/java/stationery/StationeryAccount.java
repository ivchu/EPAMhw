package stationery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MM8 on 01.03.2017.
 */
public class StationeryAccount {
    List<OfficeWorker> workers = new ArrayList<>();

    public void addWorker(OfficeWorker worker) {
        if (worker == null){
            throw new NullPointerException();
        }
        workers.add(worker);
    }

    public List getWorkers() {
        return Collections.unmodifiableList(workers);
    }

    public int getAllStationeryCost() {
        int cost = 0;
        for (OfficeWorker worker : workers) {
            for (Stationery statipnery : worker.getStationeries()){
                cost += statipnery.getCost();
            }
        }
        return cost;
    }
}
