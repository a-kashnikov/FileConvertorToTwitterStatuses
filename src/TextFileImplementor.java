import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Антон on 20.06.2017.
 */
public class TextFileImplementor {
    public static void main (String [] args){
        System.out.println("Enter the name of file\n");
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());

        try {
            scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()){
                stringBuilder.append(scanner.nextLine());
            }
            String [] strings = stringBuilder.toString().split("\\. ");
            File newFile = new File("new_" + file.getName());
            FileWriter fileWriter = new FileWriter(newFile, true);
            for (String string :
                    strings) {
                if (string.length()<141&&string.length()>10){
                    fileWriter.write(string + "\n");
                }
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
