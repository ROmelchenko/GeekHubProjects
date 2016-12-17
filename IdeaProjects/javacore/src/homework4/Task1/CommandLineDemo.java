package homework4.Task1;

import java.io.IOException;

public class CommandLineDemo {

    private static int command;

    public static void main(String[] args) throws IOException {

        CommandLineDemo commandLineDemo = new CommandLineDemo();
        commandLineDemo.chooseCommand();
    }

    private void chooseCommand() throws IOException {
        System.out.println("Choose any command like this: \"1 - cd\", \"2 - pwd\", \"3 - ls\", \"4 - find\" or \"5 - exit\": ");

        while (command != 5) {
            command = System.in.read();
            selectCommand(command);
        }
    }

    private static void selectCommand(int command2) {

        switch (command2) {
            case '1': {

                CdCommand cdCommand = new CdCommand();
                System.out.println(cdCommand.getDirectory());
                break;
            }

            case '2': {

                PwdCommand pwdCommand = new PwdCommand();
                pwdCommand.getWorkingDirectory();
                break;
            }

            case '3': {

                LsCommand.getFiles();
                break;
            }

            case '4': {

                FindCommand.getFilesWithFilter();
                break;
            }

            case '5': {

                System.exit(0);
                break;
            }
        }
    }
}
