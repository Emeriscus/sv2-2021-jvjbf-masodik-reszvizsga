package city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;

        if (!numberOfTablesValidator(getArea(), numberOfTablesPerLevel)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean numberOfTablesValidator(int area, int numberOfTablesPerLevel) {
        return (area >= numberOfTablesPerLevel * 2 && area <= numberOfTablesPerLevel * 5);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * getNumberOfTablesPerLevel();
    }
}
