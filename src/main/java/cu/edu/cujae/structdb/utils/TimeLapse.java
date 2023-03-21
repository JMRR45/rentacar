package cu.edu.cujae.structdb.utils;

import java.time.LocalDate;

public class TimeLapse {
    private LocalDate initDate;
    private LocalDate endDate;

    /**
     * @param initDate First date of the Lapse
     * @param endDate Final date of the Lapse
     * @throws IllegalArgumentException if initDate is bigger than endDate
     */
    public TimeLapse(LocalDate initDate, LocalDate endDate) {
        if (!(setInitDate(initDate) && setEndDate(endDate))) {
            throw new IllegalArgumentException("initDate is greater than endDate");
        }
    }

    public LocalDate getInitDate() {
        return LocalDate.ofEpochDay(initDate.toEpochDay());
    }

    public LocalDate getEndDate() {
        return LocalDate.ofEpochDay(endDate.toEpochDay());
    }

    /**
     * @param initDate
     * @return TRUE if initDate is bigger than endDate or endDate is unsetted
     *         FALSE if initDate is smaller than endDate
     */
    public boolean setInitDate(LocalDate initDate) {
        if (endDate != null && initDate.isAfter(endDate)) {
            return false;
        }
        this.initDate = LocalDate.ofEpochDay(initDate.toEpochDay());
        return true;
    }

    /**
     * @param endDate
     * @return TRUE if endDate is smaller than initDate or initDate is unsetted
     *         FALSE if endDate is smaller than initDate
     */
    public boolean setEndDate(LocalDate endDate) {
        if (initDate != null && endDate.isBefore(initDate)) {
            return false;
        }
        this.endDate = LocalDate.ofEpochDay(endDate.toEpochDay());
        return true;
    }

    @Override
    public Object clone() {
        return new TimeLapse(initDate, endDate);
    }
}
