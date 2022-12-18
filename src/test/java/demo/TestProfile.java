package demo;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestProfile {

    @ConfigProperty(name = "key")
    String value;

    @Test
    void shouldReadProfiledValue() {
        Assertions.assertEquals("profiled_value", value);
    }
}
