package greetingejb;

import javax.ejb.Stateless;

@Stateless
public class GreetingEJB {

    public String getGreeting(String name) {
        return "Hello " + name + ", best wishes from an EJB.";
    }

}
