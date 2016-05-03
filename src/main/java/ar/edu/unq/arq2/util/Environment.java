package ar.edu.unq.arq2.util;

public class Environment {

    public static int portNumber() {
        return Integer.parseInt(ConfigVar.get("PORT"));
    }

    public static String databaseConnectionUri() {
        return ConfigVar.get("MONGO_URI");
    }

    public static String host() {
        return ConfigVar.get("HOST");
    }
}
