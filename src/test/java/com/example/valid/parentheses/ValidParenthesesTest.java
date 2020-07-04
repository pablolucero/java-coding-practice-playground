package com.example.valid.parentheses;

import org.junit.jupiter.api.Test;

import static com.example.valid.parentheses.ValidParentheses.isValid;
import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {

    @Test
    void isValidReturnCorrectly() {

        assertThat(isValid("(qwe123_/[]{})")).isTrue();
        assertThat(isValid("([])")).isTrue();
        assertThat(isValid("([]{})")).isTrue();
        assertThat(isValid("([]{}())")).isTrue();
        assertThat(isValid("([]{()}())")).isTrue();
        assertThat(isValid("(([]{()}([{}])))")).isTrue();

        assertThat(isValid("())")).isFalse();
        assertThat(isValid("([(])")).isFalse();
        assertThat(isValid("([]({)})")).isFalse();
        assertThat(isValid("([]{{}())")).isFalse();
        assertThat(isValid("([]{(})}())")).isFalse();
        assertThat(isValid("(([]{()}([{}]))))")).isFalse();
    }
}
