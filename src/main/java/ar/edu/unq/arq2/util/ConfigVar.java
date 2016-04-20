package ar.edu.unq.arq2.util;

import java.util.HashMap;
import java.util.Map;

public class ConfigVar {
    public static Map<String, String> DEFAULTS = new HashMap<>();

    public static void initialize() {
        DEFAULTS.put("PORT", "8080");
        DEFAULTS.put("MONGO_URI", "mongodb://localhost:27017/app");
        DEFAULTS.put("ENV", "development");
    }

    public static String get(String variableName) {
        String var = System.getenv(variableName);
        if (isNotDefined(var)) {
            var = System.getProperty(variableName);
            if (isNotDefined(var)) {
                var = DEFAULTS.get(variableName);
                if (isNotDefined(var)) {
                    throw new RuntimeException("Variable de entorno no encontrada");
                }
            }
        }
        return var;
    }

    private static boolean isNotDefined(String var) {
        return var == null || var.isEmpty();
    }
}
