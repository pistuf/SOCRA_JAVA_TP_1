package com.epita.socra.app;

import com.epita.socra.app.tools.*;

public final class App {
    private IOAdapter adapter;

    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Arabic number translate into Roman number.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    public void run(){
        adapter.write("Hello, what's your number ?");
        String name = adapter.read();
        String out = adapter.translation(name);
        adapter.write(out);
    }
}
