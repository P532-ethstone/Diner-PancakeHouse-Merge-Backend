package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CustomerData;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Repository
public class CustomerRepository {
    public CustomerRepository(){
        File dataFolder = new File("data");
        if(!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File dataBaseFile = new File("data/customers.txt");
        if(!dataBaseFile.exists()) {
            try {
                dataBaseFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }
    }

    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "data/customers.txt";
    private static void appendTofile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public void add(CustomerData customer) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        String data = customer.username() + "," + customer.password() + "," + customer.email();
        appendTofile(path, data + NEW_LINE);
    }
}
