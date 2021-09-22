import java.util.Queue;

public class WashingMachine extends Thread {

  private Queue<Customer> customers;

  private String id;

  private int totalTime = 0; // суммарное время работы этой стиральной машины

  public WashingMachine(Queue<Customer> customers, String name) {
    this.customers = customers;
    this.id = name;
  }

  @Override
  public void run() {

    while (true) {

      Customer currentCustomer = customers.poll();

      if (currentCustomer == null) {
        return;
      }

      int currentCustomerTime = currentCustomer.getLaundryTimeSec(); // для проверки

      System.out.println(
          "клиент " + currentCustomer.getName() + " будет стирать " + currentCustomerTime
              + " секунд в " + id);

      totalTime = totalTime + currentCustomerTime; // для проверки

      try {
        Thread.sleep(currentCustomerTime * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

  }

  public int getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(int totalTime) {
    this.totalTime = totalTime;
  }
}
