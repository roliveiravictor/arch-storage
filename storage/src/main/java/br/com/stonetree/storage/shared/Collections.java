package br.com.stonetree.storage.shared;

import android.text.TextUtils;

import java.util.Collection;
import java.util.Map;

public class Collections {

    public static boolean isNullOrEmpty(final Collection<?> c) {
        return c == null || c.isEmpty();
    }

    public static boolean isNullOrEmpty(final Map<?, ?> m) {
        return m == null || m.isEmpty();
    }

    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNullOrEmpty(final int[] a) {
        return a == null || a.length == 0;
    }

    public static boolean isNullOrEmpty(final Double d) {
        return d == null || d == 0.00;
    }

    public static boolean isNullOrEmpty(final CharSequence s) {
        return s == null || TextUtils.isEmpty(s);
    }

    public static boolean isNotNullOrEmpty(final CharSequence s) {
        return s != null && !TextUtils.isEmpty(s);
    }

    public static boolean isNotNullOrEmpty(final String s) {
        return s != null && !s.isEmpty();
    }

    public static boolean isNotNullOrEmpty(final Collection<?> c) {
        return c != null && !c.isEmpty();
    }

}
