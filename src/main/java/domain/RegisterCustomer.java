package domain;

import java.util.UUID;

public class RegisterCustomer {

    public final String customerID;
    public final String email;
    public final String personName;
    public final String confirmationHash;

    public RegisterCustomer(String email, String personName) {
        this.customerID = UUID.randomUUID().toString();
        this.email = email;
        this.personName = personName;
        this.confirmationHash = UUID.randomUUID().toString();
    }
}
