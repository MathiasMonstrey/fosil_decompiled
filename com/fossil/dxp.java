package com.fossil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

final class dxp {
    static File kY(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                kY(file.getParentFile().getAbsolutePath());
            }
            file.mkdir();
        }
        return file;
    }

    static List<String> m10266z(File file) {
        Reader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
        }
    }
}
