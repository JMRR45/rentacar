package cu.edu.cujae.structdb.dto;

import java.time.LocalDate;

public abstract class AbstractDTO {
    private LocalDate date;

    public AbstractDTO (LocalDate date) {
        this.date = LocalDate.ofEpochDay(date.toEpochDay());
    }

    public LocalDate getDate(){return date;}

    public void setDate(LocalDate date) {this.date = LocalDate.ofEpochDay(date.toEpochDay());}
}
