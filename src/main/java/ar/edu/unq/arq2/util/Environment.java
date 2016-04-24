package ar.edu.unq.arq2.util;

public class Environment {

    public static int portNumber() {
        return Integer.parseInt(ConfigVar.get("PORT"));
    }
}
