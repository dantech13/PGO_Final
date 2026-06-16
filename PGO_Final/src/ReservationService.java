import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private List<Student> students;
    private List<Equipment> equipmentList;
    private List<Reservation> reservations;

    private DiscountPolicy discountPolicy;

    private int reservationCounter = 1;

    public ReservationService(
            List<Student> students,
            List<Equipment> equipmentList,
            DiscountPolicy discountPolicy) {

        this.students = students;
        this.equipmentList = equipmentList;
        this.discountPolicy = discountPolicy;
        this.reservations = new ArrayList<>();
    }

    public Reservation createReservation(
            String studentId,
            String equipmentId,
            int days) {

        if (days < 1 || days > 14) {
            throw new IllegalArgumentException(
                    "Liczba dni musi być od 1 do 14.");
        }

        Student student = findStudent(studentId);
        Equipment equipment = findEquipment(equipmentId);

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student nie istnieje.");
        }

        if (equipment == null) {
            throw new IllegalArgumentException(
                    "Sprzęt nie istnieje.");
        }

        if (!equipment.isAvailable()) {
            throw new IllegalArgumentException(
                    "Sprzęt nie jest dostępny.");
        }

        String reservationId =
                String.format("R%03d", reservationCounter++);

        Reservation reservation =
                new Reservation(
                        reservationId,
                        student,
                        equipment,
                        days);

        equipment.setAvailable(false);

        reservations.add(reservation);

        return reservation;
    }

    public void returnEquipment(String reservationId) {

        Reservation reservation = findReservation(reservationId);

        if (reservation == null) {
            throw new IllegalArgumentException(
                    "Rezerwacja nie istnieje.");
        }

        if (reservation.getStatus()
                != ReservationStatus.ACTIVE) {

            throw new IllegalArgumentException(
                    "Rezerwacja nie jest aktywna.");
        }

        reservation.setStatus(
                ReservationStatus.RETURNED);

        reservation.getEquipment()
                .setAvailable(true);

        int points =
                (int) (reservation.calculateTotalCost(
                        discountPolicy) / 10);

        reservation.getStudent()
                .addLoyaltyPoints(points);

        System.out.println(
                "Student otrzymał "
                        + points
                        + " punktów.");
    }

    public Student findStudent(String id) {

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    public Equipment findEquipment(String id) {

        for (Equipment equipment : equipmentList) {
            if (equipment.getId().equalsIgnoreCase(id)) {
                return equipment;
            }
        }

        return null;
    }

    public Reservation findReservation(String id) {

        for (Reservation reservation : reservations) {
            if (reservation.getId().equalsIgnoreCase(id)) {
                return reservation;
            }
        }

        return null;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public double getRevenue() {

        double revenue = 0;

        for (Reservation reservation : reservations) {
            if (reservation.getStatus()
                    == ReservationStatus.RETURNED) {

                revenue += reservation.calculateTotalCost(
                        discountPolicy);
            }
        }

        return revenue;
    }

    public Student getBestStudent() {

        Student best = students.get(0);

        for (Student student : students) {
            if (student.getLoyaltyPoints()
                    > best.getLoyaltyPoints()) {

                best = student;
            }
        }

        return best;
    }
}