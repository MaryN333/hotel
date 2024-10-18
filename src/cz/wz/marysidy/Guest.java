package cz.wz.marysidy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Guest {
    private String name;
    private String surname;
    private LocalDate birth;

    public Guest(String name, String surname, LocalDate birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        return name + " " + surname +
//                " (" + birth.getYear() + "-" + birth.getMonth() + "-"+ birth.getDayOfMonth() + ")";
        return name + " " + surname + " (" + birth.format(formattedDate) + ")";
    }
}
