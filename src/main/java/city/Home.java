package city;

public class Home extends Building {

    static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, Address address) {
        super(area, address);
    }

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        if (levels > 3) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return getFullArea() / SQUARE_METERS_NEED_PER_PERSON;
    }
}
