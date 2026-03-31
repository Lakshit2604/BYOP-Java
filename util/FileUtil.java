package util;
import java.io.*;
import java.util.*;

public class FileUtil {

    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Map<String, T>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>(); // return empty if file not found or corrupted
        }
    }

    public static <T> void saveData(Map<String, T> data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}