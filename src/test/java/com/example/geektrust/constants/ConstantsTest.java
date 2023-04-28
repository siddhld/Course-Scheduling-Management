package com.example.geektrust.constants;

import com.sidd.coursescheduling.constant.Constants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstantsTest {

    @Test
    public void testGetValues(){
        assertEquals("ADD_COURSE_OFFERING",Constants.getValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",Constants.getValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",Constants.ACCEPTED);
    }

}
