package com.lautarobravo.aune_interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void basicFilter(){
        var defaultText = "A rainbow is an optical.";
        var app = new AppReader();

        var result = app.evaluate(defaultText);

        assertEquals( 1, result.get("rainbow"));
        assertEquals(1, result.get("optical"));
        assertTrue(!result.containsKey("a"));
        assertTrue(!result.containsKey("is"));
        assertTrue(!result.containsKey("an"));
        assertTrue(!result.containsKey("."));

    }

    @Test
    public void lowercaseWords(){
        var defaultText = """
                    # Rainbow
                    ## Overview
                """;

        var app = new AppReader();
        var result = app.evaluate(defaultText);

        assertEquals(1, result.get("rainbow"));
        assertEquals(1, result.get("overview"));
        assertTrue(!result.containsKey("#"), "# amount");
        assertTrue(!result.containsKey("##"), "## amount");
        assertTrue(!result.containsKey("\n"), "/n amount");
    }

    @Test
    public void filterOnlyCommonArticles(){
        var defaultText = "the Sun to the observer's eye.";

        var app = new AppReader();
        var result = app.evaluate(defaultText);

        assertEquals(1, result.get("observer's"), "observer");
        assertEquals(1, result.get("eye"), "eye");
        assertEquals(1, result.get("sun"), "sun");
        assertTrue(!result.containsKey("the"), "the amount");
        assertTrue(!result.containsKey("to"), "to amount");
    }
}
