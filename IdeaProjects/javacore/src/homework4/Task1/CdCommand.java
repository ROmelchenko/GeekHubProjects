package homework4.Task1;

import java.io.File;
import java.util.Scanner;

public class CdCommand {

    public static File getDirectory() {

        File directory;

        do {
            System.out.print("Input path to folder: ");
            Scanner inputDirectory = new Scanner(System.in);
            directory = new File(inputDirectory.nextLine());

        }
        while (!directory.exists() || !directory.isDirectory());

        LsCommand.setCurrentPath(directory.toString());
        return directory;
    }

}
