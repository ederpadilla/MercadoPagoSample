package androiddeveloper.eder.padilla.mercadopagosample.mercadopago.util;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by vaserber on 1/9/17.
 */

public class FontCache {

    public static final String CUSTOM_REGULAR_FONT = "custom_regular";
    public static final String CUSTOM_LIGHT_FONT = "custom_light";

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static void setTypeface(String fontName, Typeface typeFace) {
        fontCache.put(fontName, typeFace);
    }

    public static Typeface getTypeface(String fontName) {
        return fontCache.get(fontName);
    }

    public static boolean hasTypeface(String fontName) {
        return fontCache.containsKey(fontName);
    }

    public static Typeface createTypeface(String fontName, Context context) {
        Typeface typeFace;
        if (hasTypeface(fontName)) {
            typeFace = getTypeface(fontName);
        } else {
            try {
                typeFace = Typeface.createFromAsset(context.getAssets(), fontName);
            } catch (Exception e) {
                return null;
            }
            setTypeface(fontName, typeFace);
        }
        return typeFace;
    }
}