import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        List<Student> students = new ArrayList<>();
//
//        students.add(new Student(
//                "S001",
//                "Anna Kowalska",
//                "12c",
//                120));
//
//        students.add(new Student(
//                "S002",
//                "Marek Nowak",
//                "12c",
//                40));
//
//        students.add(new Student(
//                "S003",
//                "Julia Zielińska",
//                "13a",
//                0));
//
//        List<Equipment> equipment = new ArrayList<>();
//
//        equipment.add(new LaptopSet(
//                "E001",
//                "Lenovo ThinkPad Lab",
//                80,
//                32,
//                true));
//
//        equipment.add(new LaptopSet(
//                "E002",
//                "Dell XPS Demo",
//                100,
//                16,
//                false));
//
//        equipment.add(new CameraKit(
//                "E003",
//                "Sony Content Kit",
//                90,
//                3,
//                true));
//
//        equipment.add(new CameraKit(
//                "E004",
//                "Canon Interview Kit",
//                70,
//                1,
//                true));
//
//        ReservationService service =
//                new ReservationService(
//                        students,
//                        equipment,
//                        new LoyaltyDiscountPolicy());
//
//        int choice;
//
//        do {
//
//            System.out.println("\n1. Lista studentów");
//            System.out.println("2. Lista sprzętu");
//            System.out.println("3. Utwórz rezerwację");
//            System.out.println("4. Zwróć sprzęt");
//            System.out.println("5. Aktywne rezerwacje");
//            System.out.println("6. Raport");
//            System.out.println("0. Wyjście");
//
//            choice = scanner.nextInt();
//            scanner.nextLine();
//
//            try {
//
//                switch (choice) {
//
//                    case 1:
//                        students.forEach(System.out::println);
//                        break;
//
//                    case 2:
//                        equipment.forEach(
//                                e -> System.out.println(
//                                        e.getDisplayText()));
//                        break;
//
//                    case 3:
//
//                        System.out.print("ID studenta: ");
//                        String sid = scanner.nextLine();
//
//                        System.out.print("ID sprzętu: ");
//                        String eid = scanner.nextLine();
//
//                        System.out.print("Liczba dni: ");
//                        int days = scanner.nextInt();
//                        scanner.nextLine();
//
//                        Reservation reservation =
//                                service.createReservation(
//                                        sid,
//                                        eid,
//                                        days);
//
//                        double cost =
//                                reservation.calculateTotalCost(
//                                        new LoyaltyDiscountPolicy());
//
//                        System.out.println(
//                                "Utworzono "
//                                        + reservation.getId());
//
//                        System.out.println(
//                                "Koszt: "
//                                        + cost
//                                        + " PLN");
//
//                        break;
//
//                    case 4:
//
//                        System.out.print(
//                                "ID rezerwacji: ");
//
//                        String rid =
//                                scanner.nextLine();
//
//                        service.returnEquipment(rid);
//
//                        break;
//
//                    case 5:
//
//                        for (Reservation r :
//                                service.getReservations()) {
//
//                            if (r.getStatus()
//                                    == ReservationStatus.ACTIVE) {
//
//                                System.out.println(
//                                        r.getDisplayText());
//                            }
//                        }
//
//                        break;
//
//                    case 6:
//
//                        System.out.println(
//                                "Zakończone rezerwacje:");
//
//                        for (Reservation r :
//                                service.getReservations()) {
//
//                            if (r.getStatus()
//                                    == ReservationStatus.RETURNED) {
//
//                                System.out.println(
//                                        r.getDisplayText());
//                            }
//                        }
//
//                        System.out.println(
//                                "Przychód: "
//                                        + service.getRevenue()
//                                        + " PLN");
//
//                        System.out.println(
//                                "Najlepszy student: "
//                                        + service.getBestStudent());
//
//                        break;
//                }
//
//            } catch (Exception e) {
//                System.out.println(
//                        "Błąd: "
//                                + e.getMessage());
//            }
//
//        } while (choice != 0);
//
//        scanner.close();
    }
}