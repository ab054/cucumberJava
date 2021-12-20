package support;

import io.cucumber.java.ParameterType;
import org.openqa.selenium.Keys;

public class ParameterTypes {

    @ParameterType("ENTER|RETURN")
    public Keys key(String keysValue) {
        return Keys.valueOf(keysValue);
    }

}
