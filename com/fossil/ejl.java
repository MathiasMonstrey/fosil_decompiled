package com.fossil;

import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.Privacy.Level;

public class ejl {

    static /* synthetic */ class C34241 {
        static final /* synthetic */ int[] dJr = new int[Level.values().length];

        static {
            try {
                dJr[Level.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dJr[Level.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dJr[Level.PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static ejm m10786a(Level level) {
        switch (C34241.dJr[level.ordinal()]) {
            case 1:
                return new ejm(Level.PRIVATE, "Private. Do Not Share");
            case 2:
                return new ejm(Level.FRIENDS, "Friends. Share With All My Friend");
            case 3:
                return new ejm(Level.PUBLIC, "Public. Share With Everyone");
            default:
                ecq.error("This state is not supported.");
                return null;
        }
    }

    public static Level oy(int i) {
        switch (i) {
            case 0:
                return Level.PRIVATE;
            case 1:
                return Level.FRIENDS;
            case 3:
                return Level.PUBLIC;
            default:
                ecq.error("This ID is not supported.");
                return null;
        }
    }

    public static Privacy oz(int i) {
        Level oy = oy(i);
        if (oy != null) {
            return m10786a(oy);
        }
        return null;
    }
}
