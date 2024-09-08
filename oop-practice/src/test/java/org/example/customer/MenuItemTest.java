package org.example.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuItemTest {

    @Test
    @DisplayName("메뉴 항목 생성")
    void createTest() {
        assertThatCode(() -> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
