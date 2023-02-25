package com.hillel.homework_11;

import java.io.IOException;

public class FileStream {
    private static String filePath = "./src/test/UserData.txt";

    public static void main(String[] args) throws IOException {
        UserData userData = new UserData("Andrey", "zuevandrey1979@gmail.com", String.valueOf(36));
        ReadWriteFile.serialize(filePath, userData);
        ReadWriteFile.deserialize(filePath);
    }
}