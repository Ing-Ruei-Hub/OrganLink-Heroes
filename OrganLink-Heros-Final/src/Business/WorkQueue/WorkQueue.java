package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

public class WorkQueue {

    private List<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void addWorkRequest(WorkRequest request) {
        this.workRequestList.add(request);
    }

    public void removeWorkRequest(WorkRequest request) {
        this.workRequestList.remove(request);
    }
}
