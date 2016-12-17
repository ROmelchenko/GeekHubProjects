package homework4.Task1;

import java.io.File;
import java.io.FilenameFilter;

abstract class FindCommand {

    static void getFilesWithFilter() {

        File f;
        File[] paths;

        try {

            f = new File(LsCommand.getCurrentPath());
            FilenameFilter fileNameFilter = (dir, name) -> {

                if (name.lastIndexOf('.') > 0) {

                    int lastIndex = name.lastIndexOf('.');
                    String str = name.substring(lastIndex);

                    if (str.equals(".docx")) {

                        return true;
                    }
                }
                return false;
            };

            paths = f.listFiles(fileNameFilter);

            for (File path : paths) {

                System.out.println(path);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

