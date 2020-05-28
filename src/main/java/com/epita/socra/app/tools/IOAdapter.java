package com.epita.socra.app.tools;

public interface IOAdapter {
    String read();

    String translation(String input);

    boolean error_test(Integer number);

    String Mille(Integer number);

    String cent(Integer number);

    String dix(Integer number);

    String unit(Integer number);

    void write(String message);

    void write_err(String msg);
}
