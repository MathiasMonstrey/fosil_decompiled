package com.fossil;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class ebd implements FileFilter {
    ebd() {
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
