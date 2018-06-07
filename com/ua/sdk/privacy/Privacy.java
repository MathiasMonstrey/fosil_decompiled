package com.ua.sdk.privacy;

import com.fossil.ecb;

public interface Privacy extends ecb {

    public enum Level {
        PRIVATE(0),
        FRIENDS(1),
        PUBLIC(3);
        
        public final int id;

        private Level(int i) {
            this.id = i;
        }
    }

    Level aEa();
}
