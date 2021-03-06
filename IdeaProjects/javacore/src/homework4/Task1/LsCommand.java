package homework4.Task1;

import java.io.File;

abstract class LsCommand {

    private static String currentPath = System.getProperty("user.dir");

    static void getFiles() {

        File file;
        File[] paths;

        try {

            file = new File(getCurrentPath());
            paths = file.listFiles();

            for (File path : paths) {
                System.out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentPath() {
        return currentPath;
    }

    public static void setCurrentPath(String currentPath) {
        LsCommand.currentPath = currentPath;
    }
}

