package Business.WorkQueue;

import Business.Donor.Donor; // Assuming Donor class exists in Business.Donor package
import Business.UserAccount.UserAccount;
import java.util.Date;

public class DonorRegistrationRequest extends WorkRequest {

    private Donor donor; // Reference to the Donor object being registered
    // Add any other specific attributes for a donor registration request
    private String requestID;
    private String reviewComments;
    private UserAccount resolver;

    public DonorRegistrationRequest(String message, UserAccount sender, UserAccount receiver, Donor donor) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Pending Hospital Review"); // Initial status
        this.donor = donor;
        
        this.requestID = "REQ" + System.currentTimeMillis();
    }
    
    /**
     * 无参构造函数
     */
    public DonorRegistrationRequest() {
        super();
        this.requestID = "REQ" + System.currentTimeMillis();
        setStatus("Pending Hospital Review");
    }
    
    // ========== Donor 对象相关 ==========
    
    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    // ========== Request ID ==========
    
    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

     // ========== 从 Donor 对象获取信息 ==========
    
    public String getDonorName() {
        return donor != null ? donor.getName() : "N/A";
    }

    public String getBloodType() {
        return donor != null ? donor.getBloodType() : "N/A";
    }

    public String getOrganType() {
        return donor != null ? donor.getOrganToDonate() : "N/A";
    }
    
    public int getAge() {
        return donor != null ? donor.getAge() : 0;
    }
    
    public String getContact() {
        return donor != null ? donor.getContactNumber() : "N/A";
    }
    
    public String getMedicalHistory() {
        return donor != null ? donor.getMedicalHistory() : "N/A";
    }

    // ========== 审核相关 ==========
    
    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }
    
    public UserAccount getResolver() {
        return resolver;
    }

    public void setResolver(UserAccount resolver) {
        this.resolver = resolver;
    }

    @Override
    public String toString() {
        return donor != null ? donor.getName() + " - " + getStatus() : super.toString();
    }

   
}
