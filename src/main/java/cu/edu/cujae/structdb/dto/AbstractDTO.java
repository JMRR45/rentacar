package cu.edu.cujae.structdb.dto;

import java.time.LocalDate;

/**
 * Base Class for every CrudDTO, this class provides a Date, represented as
 * {@link LocalDate}, for having a record of every report.
 */
public abstract class AbstractDTO {
    private LocalDate date;

    public AbstractDTO() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.ofEpochDay(date.toEpochDay());
    }
}
