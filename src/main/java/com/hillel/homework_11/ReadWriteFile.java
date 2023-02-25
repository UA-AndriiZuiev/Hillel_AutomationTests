package com.hillel.homework_11;

import java.io.*;

public class ReadWriteFile {
    public static void serialize(String filePath, UserData userData) throws IOException {
        File file = new File(filePath);
        String str = "Name: %s \nEmail: %s \nAge: %s \n";

        if (!file.exists()) {
            file.createNewFile();
        }
        PrintStream printStream = new PrintStream(file);

        if (userData.getName() == "")
            str = "%sEmail: %s \nAge: %s \n";
        if (userData.getEmail() == "")
            str = "Name: %s \n%sAge: %s \n";
        if (userData.getAge() == "")
            str = "Name: %s \nEmail: %s \n%s";
        printStream.printf(str, userData.getName(), userData.getEmail(), userData.getAge());
        printStream.close();
    }

    public static UserData deserialize(String filePath) throws IOException {
        UserData userData = new UserData();
        String line;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();

        while (line != null) {
            if (line.contains("Name:")) {
                userData.setName(line);
            } else if (line.contains("Email:")) {
                userData.setEmail(line);
            } else if (line.contains("Age:")) {
                userData.setAge(line);
            } else {
                System.out.println("Unknown format data");
                return userData;
            }
            line = bufferedReader.readLine();
        }
        fileReader.close();
        return userData;
    }
}