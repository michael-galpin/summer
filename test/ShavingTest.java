import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ShavingTest {

    @Test
    public void testToday() {
        Calendar startDate = new Calendar.Builder()
                .setDate(2022, 6,9)
                .build();
        Shaving shaving = new Shaving(startDate, Shaving.FULL_SHAVE);
        assertEquals(Shaving.FULL_SHAVE, shaving.getShaveType(startDate));
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(Shaving.NO_SHAVE, shaving.getShaveType(startDate));
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(Shaving.PARTIAL_SHAVE, shaving.getShaveType(startDate));
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(Shaving.NO_SHAVE, shaving.getShaveType(startDate));
        startDate.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(Shaving.FULL_SHAVE, shaving.getShaveType(startDate));
    }
}