import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Startup {

    private static boolean fileWasCreated = false;
    private static String fileName="listaMieszkancow.txt";

    public static void main(String[] args) throws IOException {
        deleteExistingFile();
        while (true){
            PersonInfo personInfo = getInformationsFromUser();
            if (Validator.validatePesel(personInfo.getPesel())){
                savePersonDataToFile(personInfo);
            }
            else {
                System.out.println("Podany pesel jest nieprawidłowy. Spróbuj jeszcze raz");
            }
        }
    }

    private static void deleteExistingFile() {
        File file = new File(fileName);
        if (file.exists()){
            file.delete();
        }
    }

    private static void savePersonDataToFile(PersonInfo personInfo) throws IOException {
        File file = createFileIfNotExist();
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(String.format("\n%s\n %s %s %s",personInfo.getCity(),personInfo.getFirstName(),personInfo.getLastName(),personInfo.getPesel()));
        fileWriter.close();
    }

    private static File createFileIfNotExist() throws IOException {
       File file = new File(fileName);
        if (!fileWasCreated){
            fileWasCreated = file.createNewFile();
        }
        return file;
    }

    private static PersonInfo getInformationsFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("Podaj nazwę miasta");
        String city = scanner.nextLine();
        System.out.println("Podaj swoje imię");
        String firstName = scanner.nextLine();
        System.out.println("Podaj swoje nazwisko");
        String lastName = scanner.nextLine();
        System.out.println("Podaj Pesel");
        String pesel = scanner.nextLine();
        return new PersonInfo(city,firstName,lastName,pesel);
    }



}
