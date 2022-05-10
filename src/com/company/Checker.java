package com.company;

public class Checker {
    public boolean checkerPassword(String password) { // password verification
        int a = 0, b = 0, d = 0;
        if (password.length() < 8) { // the password must be at least 8 characters long
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) { // password must have one capital letter
                a++;
            }
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) { // password must have one lowercase letter
                b++;
            }

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) { // password must be one digit
                d++;
            }

        }
        if (a > 0 && b > 0 && d > 0 ) { // if all variables are greater than 0, then the password was created
                                                // correctly
            return true;
        } else {
             // output if the password was not created correctly
            return false;
        }
    }



}
