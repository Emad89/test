package domain;

public class CustomerRegistered implements Event {

    public final String customerID;
    public final String email;
    public final String personName;
    public final String confirmationHash;

    public CustomerRegistered(String customerID, String email, String personName, String confirmationHash) {
        this.customerID = customerID;
        this.email = email;
        this.personName = personName;
        this.confirmationHash = confirmationHash;
    }


}
