package domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {


    @Test
    public void testRegisterCustomer() {
        RegisterCustomer command = new RegisterCustomer("email@test.com", "personName");

        // WHEN
        Customer customer = Customer.register(command);


        // THEN
        Assert.assertNotNull(customer);
        List<Event> events = customer.getRecordedEvents();
        Assert.assertNotNull(events);
        Assert.assertEquals(events.size(), 1);
        Assert.assertTrue(events.get(0) instanceof CustomerRegistered);
        CustomerRegistered customerRegistered = (CustomerRegistered) events.get(0);

        Assert.assertEquals(customerRegistered.customerID, command.customerID);
        Assert.assertEquals(customerRegistered.email, command.email);
        Assert.assertEquals(customerRegistered.confirmationHash, command.confirmationHash);
        Assert.assertEquals(customerRegistered.personName, command.personName);


    }


}
