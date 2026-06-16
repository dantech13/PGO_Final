public class LaptopSet extends Equipment {

    private int ramGb;
    private boolean hasDockingStation;

    public LaptopSet(String id, String name, double basePrice,
                     int ramGb, boolean hasDockingStation) {

        super(id, name, basePrice);
        this.ramGb = ramGb;
        this.hasDockingStation = hasDockingStation;
    }

    @Override
    public double calculateDailyPrice() {

        double price = getBaseDailyPrice();

        if (hasDockingStation) {
            price += 15;
        }

        if (ramGb >= 32) {
            price += 25;
        }

        return price;
    }

    @Override
    public String getDetails() {
        return ramGb + " GB RAM, stacja dokująca: "
                + (hasDockingStation ? "TAK" : "NIE");
    }

    @Override
    public String getDisplayText() {
        return getId() + " | LaptopSet | " + getName()
                + " | Cena/dzień: " + calculateDailyPrice()
                + " PLN | Dostępny: "
                + (isAvailable() ? "TAK" : "NIE");
    }
}