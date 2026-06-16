public class CameraKit extends Equipment {

    private int lensCount;
    private boolean hasTripod;

    public CameraKit(String id, String name, double basePrice,
                     int lensCount, boolean hasTripod) {

        super(id, name, basePrice);
        this.lensCount = lensCount;
        this.hasTripod = hasTripod;
    }

    @Override
    public double calculateDailyPrice() {

        return getBaseDailyPrice()
                + lensCount * 10
                + (hasTripod ? 15 : 0);
    }

    @Override
    public String getDetails() {
        return lensCount + " obiektywy, statyw: "
                + (hasTripod ? "TAK" : "NIE");
    }

    @Override
    public String getDisplayText() {
        return getId() + " | CameraKit | " + getName()
                + " | Cena/dzień: " + calculateDailyPrice()
                + " PLN | Dostępny: "
                + (isAvailable() ? "TAK" : "NIE");
    }
}