package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerID;
    private String emailAddress;
    private String confirmationHash;
    private String personName;
    private List<Event> recordedEvents;


    private Customer() {

        this.recordedEvents = new ArrayList<>();
    }


    public static Customer register(RegisterCustomer command){
        Event event = new CustomerRegistered(
                command.customerID,
                command.email,
                command.personName,
                command.confirmationHash

        );
        Customer customer = new Customer();
        customer.recordThat(event);
        return customer;
    }

    private void recordThat(Event event) {
        recordedEvents.add(event);
        apply(event);
    }

    public static Customer reconstitute(List<Event> events){
        Customer customer = new Customer();
        customer.apply(events);
        return customer;
    }

    private void apply(Event event){

    }
    private void apply(List<Event> events){
        events.forEach(event -> apply(event));
    }


    public List<Event> getRecordedEvents() {
        return recordedEvents;
    }
}
