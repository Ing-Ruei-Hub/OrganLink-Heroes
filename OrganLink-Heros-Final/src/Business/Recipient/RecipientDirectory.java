package Business.Recipient;

import java.util.ArrayList;

public class RecipientDirectory {
    private ArrayList<Recipient> recipientList;

    public RecipientDirectory() {
        recipientList = new ArrayList<>();
    }

    public ArrayList<Recipient> getRecipientList() {
        return recipientList;
    }

    public void addRecipient(Recipient recipient) {
        recipientList.add(recipient);
    }

    public void removeRecipient(Recipient recipient) {
        recipientList.remove(recipient);
    }
}
