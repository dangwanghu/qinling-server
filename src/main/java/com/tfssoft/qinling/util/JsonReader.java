package com.tfssoft.qinling.util;

import java.io.File;
import java.util.Scanner;

public class JsonReader {

	public static String read(File file) {
		Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {
            
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        String jsonStr = buffer.toString();
        return jsonStr.substring(1);
	}
}
