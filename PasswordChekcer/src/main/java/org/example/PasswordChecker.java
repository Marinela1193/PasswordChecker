package org.example;

import java.util.regex.Pattern;

public class PasswordChecker {
    public static final int PASSWORD_OK = 0;
    public static final int ERR_LENGTH = 1;
    public static final int ERR_DIGITS = 2;
    public static final int ERR_UPPERS = 3;
    public static final int ERR_LOWERS = 4;
    public static final int ERR_BLANK = 5;
    public static final int ERR_NO_MATCH = 6;
    public static final String ERR_INVALID_MIN_LENGTH = "La longitud mínima del password no puede ser cero o menor";
    public static final String ERR_INVALID_MAX_LENGTH = "Longitud máxima inferior a la mínima";
    static final String REGEX_DIGITO = "^.*\\d.*$";
    static final String REGEX_MINUSCULA = "^.*[a-z].*$";
    static final String REGEX_MAYUSCULA = "^.*[A-Z].*$";
    private int minLength = 8;
    private int maxLength = Integer.MAX_VALUE;
    private boolean checkDigits = false;
    private boolean checkUppers = false;
    private boolean checkLowers = false;

    public int getMinLength() {
        return this.minLength;
    }

    public void setMinLength(int minLength) throws IllegalArgumentException {
        if (minLength <= 0) {
            throw new IllegalArgumentException("La longitud mínima del password no puede ser cero o menor");
        } else {
            this.minLength = minLength;
        }
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(int maxLength) throws IllegalArgumentException {
        if (maxLength < this.getMinLength()) {
            throw new IllegalArgumentException("Longitud máxima inferior a la mínima");
        } else {
            this.maxLength = maxLength;
        }
    }

    public boolean getCheckDigits() {
        return this.checkDigits;
    }

    public void setCheckDigits(boolean checkDigits) {
        this.checkDigits = checkDigits;
    }

    public boolean getCheckUppers() {
        return this.checkUppers;
    }

    public void setCheckUppers(boolean checkUppers) {
        this.checkUppers = checkUppers;
    }

    public boolean getCheckLowers() {
        return this.checkLowers;
    }

    public void setCheckLowers(boolean checkLowers) {
        this.checkLowers = checkLowers;
    }

    public int check(String password, String repeatPassword) {
        if (password.isBlank()) {
            return 5;
        } else if (password.length() < this.getMinLength()) {
            return 1;
        } else if (this.getCheckDigits() && !Pattern.matches("^.*\\d.*$", password)) {
            return 2;
        } else if (this.getCheckLowers() && !Pattern.matches("^.*[a-z].*$", password)) {
            return 4;
        } else if (this.getCheckUppers() && !Pattern.matches("^.*[A-Z].*$", password)) {
            return 3;
        } else {
            return !password.equals(repeatPassword) ? 6 : 0;
        }
    }
}
