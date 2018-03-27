package net.albertoi.singleton;

class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Do dumb stuff
        singleton1.sayBye();
        singleton2.sayBye();
    }
}