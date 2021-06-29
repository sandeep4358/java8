import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.stingray.Calculator;

class TestCalculater {
	private Calculator calculator;

	@Test                                               
    @DisplayName("Simple multiplication should work")   
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4,5),      
        "Regular multiplication should work");          
    }

}
