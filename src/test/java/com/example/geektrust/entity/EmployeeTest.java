package com.example.geektrust.entity;
import com.sidd.coursescheduling.entities.Employee;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeTest {
    @Test
    public void testEmployee() throws IOException {
        String email = null;
        try {
            new Employee(email);
        }catch (InvalidInputException e){
            assertNotNull(e.getMessage());
        }
    }
}
