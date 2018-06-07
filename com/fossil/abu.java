package com.fossil;

import java.util.Random;

class abu implements eoa {
    final eoa aHx;
    final Random aHy;
    final double aHz;

    public abu(eoa com_fossil_eoa, double d) {
        this(com_fossil_eoa, d, new Random());
    }

    public abu(eoa com_fossil_eoa, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (com_fossil_eoa == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.aHx = com_fossil_eoa;
            this.aHz = d;
            this.aHy = random;
        }
    }

    public long eS(int i) {
        return (long) (xn() * ((double) this.aHx.eS(i)));
    }

    double xn() {
        double d = 1.0d - this.aHz;
        return d + (((this.aHz + 1.0d) - d) * this.aHy.nextDouble());
    }
}
