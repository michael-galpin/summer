import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShavingTest {

    @Test
    public void testToday() {
        LocalDate startDate = LocalDate.of(2022, 6, 9);
        Shaving shaving = new Shaving(startDate, Shaving.FULL_SHAVE);
        assertEquals(Shaving.FULL_SHAVE, shaving.getShaveType(startDate));
        LocalDate friday = startDate.plusDays(1);
        assertEquals(Shaving.NO_SHAVE, shaving.getShaveType(friday));
        LocalDate saturday = friday.plusDays(1);
        assertEquals(Shaving.PARTIAL_SHAVE, shaving.getShaveType(saturday));
        LocalDate sunday = saturday.plusDays(1);
        assertEquals(Shaving.NO_SHAVE, shaving.getShaveType(sunday));
        LocalDate monday = sunday.plusDays(1);
        assertEquals(Shaving.FULL_SHAVE, shaving.getShaveType(monday));
    }
}