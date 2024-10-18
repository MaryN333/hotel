package cz.wz.marysidy;

public enum VacationType {
    WORK ("pracovní"),
    LEASURE("rekreační");
    private String description;

    VacationType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
