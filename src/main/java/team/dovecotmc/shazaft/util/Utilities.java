package team.dovecotmc.shazaft.util;

import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;

import java.util.HashMap;
import java.util.Map;

public class Utilities {
    private static final Map<String, Component> musicNameCache = new HashMap<>();

    public static Component getMusicName(String rl) {
        if (!musicNameCache.containsKey(rl)) {
            final String langKey = rl.replace(':', '.').replace('/', '.');
            if (Language.getInstance().has(langKey)) {
                final Component result = Component.translatable(langKey);
                musicNameCache.put(rl, result);
                return result;
            }
            final int lastIndex = rl.lastIndexOf('/');
            final Component result = Component.literal(toCamelCase(lastIndex == -1 ? rl : rl.substring(lastIndex + 1)));
            musicNameCache.put(rl, result);
            return result;
        }
        return musicNameCache.get(rl);
    }

    private static String toCamelCase(String input) {
        if (input == null || input.isEmpty()) return input;
        final StringBuilder builder = new StringBuilder();
        boolean toUpperCase = false;
        boolean first = true;
        for (char ch : input.toCharArray()) {
            if (ch == '_' || ch == '-') {
                toUpperCase = true;
            } else {
                if (first) {
                    builder.append(Character.toUpperCase(ch));
                    first = false;
                    toUpperCase = false;
                } else if (toUpperCase) {
                    builder.append(" ");
                    builder.append(Character.toUpperCase(ch));
                    toUpperCase = false;
                } else {
                    builder.append(ch);
                }
            }
        }
        return builder.toString();
    }
}
