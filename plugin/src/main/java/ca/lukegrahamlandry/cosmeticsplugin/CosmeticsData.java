package ca.lukegrahamlandry.cosmeticsplugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CosmeticsData {
    public static Map<UUID, Parts> TO_DISPLAY = new HashMap<>();

    public static class Parts {
        public String head = "none";
        public String chest = "none";
        public String legs = "none";
        public String feet = "none";

        @Override
        public String toString() {
            return "Parts{" +
                    "head='" + head + '\'' +
                    ", chest='" + chest + '\'' +
                    ", legs='" + legs + '\'' +
                    ", feet='" + feet + '\'' +
                    '}';
        }
    }
}
