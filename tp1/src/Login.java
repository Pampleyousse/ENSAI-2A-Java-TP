import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        HashMap<String, String> userDatabase = loadUserDatabase("../data/user_hashpwd.csv");
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            if (userDatabase.containsKey(username)) {
                int attempts = 0;
                boolean passwordCorrect = false;
                while (attempts < 3 && !passwordCorrect) {
                    System.out.print("Enter password: ");
                    String mdp = scanner.nextLine();
                    if (userDatabase.get(username).equals(mdp)) {
                        System.out.print("Login successful !");
                        isLoggedIn = true;
                        passwordCorrect = true;
                    }   else {
                        attempts++;
                        System.out.println("Incorrect password. You have " + (3 - attempts) + " attempts left.");
                    }
                }
            }

            scanner.close();
        }
    }

    /**
     * Loads a user database from a CSV file.
     * The CSV file is expected to have two columns: username and hashed password.
     * 
     * @param filename The path to the CSV file containing user data.
     * @return A HashMap where keys are usernames and values are hashed passwords.
     * 
     * @throws IOException If an error occurs while reading the file.
     */
    public static HashMap<String, String> loadUserDatabase(String filename) {
        HashMap<String, String> userDatabase = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userDatabase.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return userDatabase;
    }
}
