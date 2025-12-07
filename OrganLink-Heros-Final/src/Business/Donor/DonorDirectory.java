package Business.Donor;

import java.util.ArrayList;

public class DonorDirectory {
    private ArrayList<Donor> donorList;

    public DonorDirectory() {
        donorList = new ArrayList<>();
    }

    public ArrayList<Donor> getDonorList() {
        return donorList;
    }

    public void addDonor(Donor donor) {
        donorList.add(donor);
    }

    public void removeDonor(Donor donor) {
        donorList.remove(donor);
    }
}
