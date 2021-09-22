public class Test {

  public static void main(String[] args) throws InterruptedException {

    // для ускорения времени работы программы время стирки указывается в секундах
    // для проверки сравнивается суммарное время работы всех машин, вычисляемое в ходе выполнения, и время стирки всех клиентов

  Laundry laundry = Laundry.generateLaundry(new int[]{5, 8, 20, 3, 15, 2}, 4);

   // Laundry laundry = Laundry.generateLaundry(new int[]{3, 15, 2, 6}, 2);

    int totalCustomerTime = laundry.getCustomers().stream().map(c -> c.getLaundryTimeSec())
        .reduce((s1, s2) -> s1 + s2).get(); // проверка

    long start = System.currentTimeMillis();

    for (int i = 0; i < laundry.getWashingMachines().size(); i++) {

      laundry.getWashingMachines().get(i).start();

    }

    while (!laundry.getWashingMachines().stream()
        .allMatch(t -> t.getState().toString().equals("TERMINATED"))) {

      Thread.sleep(100);
    }

    long finish = System.currentTimeMillis();

    int totalMachineTime = laundry.getWashingMachines().stream().map(w -> w.getTotalTime())
        .reduce((s1, s2) -> s1 + s2).get(); // проверка

    System.out.println(
        "проверка: суммарное время работы всех машин равно времени всех клиентов " + (
            totalMachineTime == totalCustomerTime));

    System.out.printf("прачечная работала %d секунд", (finish - start) / 1000);

  }

}
