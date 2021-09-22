import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Laundry {

  private List<WashingMachine> washingMachines;

  private Queue<Customer> customers;

  public Laundry(List<WashingMachine> washingMachines, Queue<Customer> customers) {
    this.washingMachines = washingMachines;
    this.customers = customers;
  }

  public static Laundry generateLaundry(int[] customerLaundryTime, int washingMachinesNumber) {

    Queue<Customer> customers = new ConcurrentLinkedQueue<>();

    for (int i = 0; i < customerLaundryTime.length; i++) {

      customers.add(new Customer(customerLaundryTime[i], "customer #" + i));
    }

    List<WashingMachine> washingMachines = new ArrayList<>();

    for (int i = 0; i < washingMachinesNumber; i++) {

      washingMachines.add(new WashingMachine(customers, "стиральная машина #" + i));
    }

    Laundry laundry = new Laundry(washingMachines, customers);

    return laundry;
  }

  public List<WashingMachine> getWashingMachines() {
    return washingMachines;
  }

  public void setWashingMachines(List<WashingMachine> washingMachines) {
    this.washingMachines = washingMachines;
  }

  public Queue<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(Queue<Customer> customers) {
    this.customers = customers;
  }

}
