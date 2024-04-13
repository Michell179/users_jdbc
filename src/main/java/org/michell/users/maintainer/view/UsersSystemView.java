package org.michell.users.maintainer.view;

import org.michell.users.maintainer.models.User;
import org.michell.users.maintainer.repository.Repository;
import org.michell.users.maintainer.repository.UserRepositoryImpl;
import org.michell.users.maintainer.utils.ASCIIArtGenerator;


import java.util.*;

public class UsersSystemView {
    public static void app() throws Exception {
        /**
         * ASCII Art Generator in Java.
         * Prints a given text as an ASCII text art on the console.
         * This code is licensed under - CC Attribution CC BY 4.0.
         * @author www.quickprogrammingtips.com
         *
         */
        /*source: https://github.com/quickprogrammingtips/asciiart-java/tree/master*/

        ASCIIArtGenerator artGen = new ASCIIArtGenerator();

        Repository<User> repo = new UserRepositoryImpl();
        Scanner scan = new Scanner(System.in);
        int indexOption, choice = 0;
        boolean exit = true;

        System.out.println();
        artGen.printTextArt("U S E R S -  S Y S T E M", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_MONO, "*");
        System.out.println();

        do {
            Map<Integer, String> operations = new TreeMap<>();
            operations.put(1, "Update");
            operations.put(2, "Delete");
            operations.put(3, "Create");
            operations.put(4, "Show");
            operations.put(5, "Exit");

            System.out.println("\nSelect the next numbers options");
            operations.forEach((k,v) -> {
                int index = 12 - v.length();
                System.out.print("# " + v);
                System.out.println(" ".repeat(index)+"=> "+k);
            });

            System.out.print("\nType Number Option: ");
            indexOption = scan.nextInt();
            System.out.println();

            if (indexOption <= 0 || indexOption > 5) {
                System.out.println("Should select a correct option");
            } else {
                User user;
                switch (indexOption){
                    case 1:
                        user = TextComponentView.update();
                        repo.update(user);
                        break;
                    case 2:
                        Long id = TextComponentView.delete();
                        repo.delete(id);
                        break;
                    case 3:
                        user = TextComponentView.create();
                        repo.create(user);
                        break;
                    case 4:
                        TextComponentView.show(repo.show());
                        break;
                    case 5:
                        exit = false;
                        break;
                }

                if (indexOption != 5){
                    System.out.println("\nyou'll continue?...");
                    System.out.print("Type yes for exit or any key for continue: ");
                    exit = !scan.next().equals("yes");
                }
            }

        }while (exit);
        TextComponentView.exit();
    }


}
