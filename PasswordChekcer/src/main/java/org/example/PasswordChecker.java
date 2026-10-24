package org.example;

public class PasswordChecker {
    public static final int PASSWORD_OK = 0;
    public static final int ERR_LENGTH = 1;
    public static final int ERR_DIGITS = 2;
    public static final int ERR_UPPERS = 3;
    public static final int ERR_LOWERS = 4;
    public static final int ERR_BLANK = 5;
    public static final int ERR_NO_MATCH = 6;

    private int minLength;
    private int maxLength;

    private boolean checkDigits;
    private boolean checkUppers;
    private boolean checkLowers;

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException();
        }

        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
    public void setMaxLength(int maxLength) {
        if (maxLength < minLength) {
            throw new IllegalArgumentException();
        }

        this.maxLength = maxLength;
    }

    public boolean getCheckDigits() {
        return checkDigits;
    }

    public void setCheckDigits(boolean checkDigits) {
        this.checkDigits = checkDigits;
    }

    public boolean getCheckUppers() {
       return checkUppers;
    }
    public boolean getCheckLowers() {
        return checkLowers;
    }

    public void setCheckUppers(boolean checkUppers) {
        this.checkUppers = checkUppers;
    }
    public void setCheckLowers(boolean checkLowers) {
        this.checkLowers = checkLowers;
    }

    public int check(String password, String repeatPassword){

    }

}
