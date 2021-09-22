public class Customer {

  private int laundryTimeSec;
  private String name;

  public Customer(int laundryTime, String name) {

    this.laundryTimeSec = laundryTime;
    this.name = name;
  }

  public int getLaundryTimeSec() {
    return laundryTimeSec;
  }

  public void setLaundryTimeSec(int laundryTimeSec) {
    this.laundryTimeSec = laundryTimeSec;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
