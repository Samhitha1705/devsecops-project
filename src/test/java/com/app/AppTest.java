package com.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAdd() {
        App app = new App();
        assertEquals(5, app.add(2, 3));
    }


   @Test
public void testMultiply() {
    App app = new App();
    assertEquals(6, app.multiply(2, 3));
}
}
