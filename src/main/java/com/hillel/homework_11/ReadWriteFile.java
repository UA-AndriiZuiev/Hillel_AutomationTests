package com.hillel.homework_11;

import java.io.*;

public class ReadWriteFile {
    public static void serialize(String filePath, UserData userData) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        String str = "Name: %s \nEmail: %s \nAge: %s \n";
        if (userData.getName() == "")
            str = "%sEmail: %s \nAge: %s \n";
        if (userData.getEmail() == "")
            str = "Name: %s \n%sAge: %s \n";
        if (userData.getAge() == "")
            str = "Name: %s \nEmail: %s \n%s";

        try {
            PrintStream printStream = new PrintStream(file);
            printStream.printf(str, userData.getName(), userData.getEmail(), userData.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserData deserialize(String filePath) throws IOException {
        File file = new File(filePath);
        UserData userData = new UserData();
        String line;

        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userData;
    }
}