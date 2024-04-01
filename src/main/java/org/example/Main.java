package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> digits = new ArrayList<>();

        while (digits.size() < 4) {
            int random_int = (int)Math.floor(Math.random() * 10);
            boolean isDigitExist = isDigitExist(digits, random_int);
            if(!isDigitExist){
                digits.add(random_int);
            }
        }

        String randomCode = "";
        for (int digit : digits) {
            randomCode += digit;
        }

        System.out.println("Write your guess:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int attempts = 1;

        while (true) {
            String userCode = bufferedReader.readLine();

            if(userCode.length() != 4) {
                System.out.println("You should insert only four digit code! Write your guess:");
                continue;
            }

            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < userCode.length(); i++) {
                int userDigit = Integer.parseInt(userCode.substring(i, i + 1));
                int randomDigit = Integer.parseInt(randomCode.substring(i, i + 1));
                if (userDigit == randomDigit) {
                    bulls++;
                } else if (randomCode.contains(String.valueOf(userDigit))) {
                    cows++;
                }
            }

            if(bulls == 4) {
                System.out.println("Congratulations! You guessed the secret number: " + randomCode);
                System.out.println("You try " + attempts + " times!");
                break;
            }

            attempts++;

            System.out.println("bulls: " + bulls + " cows: " + cows);
        }
    }

    public static boolean isDigitExist(List<Integer> list, int digit) {
        if(list.isEmpty()) {
            return false;
        }

        boolean isExisting = false;

        for(int in : list) {
            if (in == digit) {
                isExisting = true;
                break;
            }
        }

        return isExisting;
    }
}