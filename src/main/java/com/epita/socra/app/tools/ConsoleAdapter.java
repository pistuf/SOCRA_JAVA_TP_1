package com.epita.socra.app.tools;

import java.util.Scanner;

public class ConsoleAdapter implements IOAdapter {

    private Scanner scan = new Scanner(System.in);

    @Override
    public String read() {
        return scan.nextLine();
    }

    @Override
    public boolean error_test(Integer number) {
        if (number <= 0) {
            write("Too high");
            return false;
        }
        if (number > 3000) {
            write("Too low");
            return false;
        }
        return true;
    }

    @Override
    public String Mille(Integer number) {
        switch (number) {
            case 3:
                return "MMM";
            case 2:
                return "MM";
            case 1:
                return "M";
            default:
                break;
        }
        return "";
    }

    @Override
    public String cent(Integer number) {
        switch (number) {
            case 9:
                return "CM";
            case 8:
                return "DCCC";
            case 7:
                return "DCC";
            case 6:
                return "DC";
            case 5:
                return "D";
            case 4:
                return "CD";
            case 3:
                return "CCC";
            case 2:
                return "CC";
            case 1:
                return "C";
            default:
                break;
        }
        return "";
    }

    @Override
    public String dix(Integer number) {
        switch (number) {
            case 9:
                return "XC";
            case 8:
                return "LXXX";
            case 7:
                return "LXX";
            case 6:
                return "LX";
            case 5:
                return "L";
            case 4:
                return "XL";
            case 3:
                return "XXX";
            case 2:
                return "XX";
            case 1:
                return "X";
            default:
                break;
        }
        return "";
    }

    @Override
    public String unit(Integer number) {
        switch (number) {
            case 9:
                return "IX";
            case 8:
                return "VIII";
            case 7:
                return "VII";
            case 6:
                return "VI";
            case 5:
                return "V";
            case 4:
                return "IV";
            case 3:
                return "III";
            case 2:
                return "II";
            case 1:
                return "I";
            default:
                break;
        }
        return "";
    }

    Integer pow(Integer a, Integer b) {
        if (b.equals(0)) {
            return 1;
        }
        Integer res = 1;
        for (Integer i = 0; i < b; ++i) {
            res *= a;
        }
        return res;
    }

    @Override
    public String translation(String input) {

        Integer number = Integer.parseInt(input);
        if (!error_test(number))
            return "err";
        StringBuilder res = new StringBuilder();
        Integer size = 0;
        Integer tp = number;
        while (tp / 10 != 0) {
            size += 1;
            tp /= 10;
        }
        while (size >= 0) {
            Integer puiss = pow(10, size);
            Integer tmp = number / puiss;
            //obtenir centaine, dizaine , etc.
            switch (size) {
                case 3:
                    res.append(Mille(tmp));
                    break;
                case 2:
                    res.append(cent(tmp));
                    break;
                case 1:
                    res.append(dix(tmp));
                    break;
                case 0:
                    res.append(unit(tmp));
                    break;
                default:
                    break;
            }
            number = number % puiss;
            // on baisse d'un cran
            size -= 1;
        }
        return res.toString();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

}
