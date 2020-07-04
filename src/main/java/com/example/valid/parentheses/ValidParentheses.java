package com.example.valid.parentheses;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    protected static final Map<Character, Character> OPENING_CLOSING_PARENTHESES_MAP
            = ImmutableMap.of('(', ')', '[', ']', '{', '}');

    private ValidParentheses() {
    }

    public static boolean isValid(String input) {
        final char[] parentheses = selectParentheses(input);

        final Deque<Character> stack = new ArrayDeque<>();

        try {
            for (Character aParenthesis : parentheses) {
                if (isAnOpener(aParenthesis)) {
                    addToStack(aParenthesis, stack);
                } else {
                    removeFromStackAnOpenerParenthesisOfTheSameType(aParenthesis, stack);
                }
            }
        } catch (MismatchParenthesesException e) {
            return false;
        }

        return stack.isEmpty();
    }

    private static char[] selectParentheses(String input) {
        final String onlyParentheses = input.replaceAll("[^(){}\\[\\]]", "");
        return onlyParentheses.toCharArray();
    }

    private static void removeFromStackAnOpenerParenthesisOfTheSameType(Character aClosingParentheses, Deque<Character> stack) {
        verifyOrFail(stack.isEmpty() || !isAClosing(aClosingParentheses));
        final Character poppedOpener = stack.pop();
        verifyOrFail(!parenthesesHaveTheSameType(aClosingParentheses, poppedOpener));
    }

    private static void verifyOrFail(boolean condition) {
        if (condition) throw new MismatchParenthesesException();
    }

    private static boolean parenthesesHaveTheSameType(Character aClosingParentheses, Character anOpenerParentheses) {
        return OPENING_CLOSING_PARENTHESES_MAP.get(anOpenerParentheses).equals(aClosingParentheses);
    }

    private static void addToStack(Character aChar, Deque<Character> stack) {
        stack.push(aChar);
    }

    public static boolean isAnOpener(Character aChar) {
        return OPENING_CLOSING_PARENTHESES_MAP.containsKey(aChar);
    }

    public static boolean isAClosing(Character aChar) {
        return OPENING_CLOSING_PARENTHESES_MAP.containsValue(aChar);
    }
}
