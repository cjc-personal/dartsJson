package org.LaunchCode.darts.Data;

import org.LaunchCode.darts.Model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Users {
    private static Map<Integer, Player> players= new HashMap<>();
    private static Boolean dataLoaded = false;






    public static Collection<Player> getAll() {
        return players.values();
    }

    public static Player getById(int id) {
        return players.get(id);
    }

    public static void add(Player player) {
        players.put(player.getId(), player);
    }

    public static void remove(int id) {
        players.remove(id);
    }





    public static void loadData() {
        if(!dataLoaded){
            try {
                File file = new File ("src/main/java/org/LaunchCode/darts/Data/users.txt");
                Scanner fileReader = new Scanner(file);

                try {
                    Scanner backupCreator = new Scanner(file);
                    PrintWriter backup = new PrintWriter("src/main/java/org/LaunchCode/darts/Data/usersBackup.txt");
                    while(backupCreator.hasNextLine()) {
                        backup.println(backupCreator.nextLine());
                    }
                    backup.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    String[] dataArray = data.split(",");
                    if (dataArray.length > 2) {
                        Integer gamesPlayed;
                        Integer gamesWon;
                        try {
                            gamesPlayed = Integer.parseInt(dataArray[1]);
                        } catch (NumberFormatException e) {
                            gamesPlayed = 0;
                        }
                        try {
                            gamesWon = Integer.parseInt(dataArray[2]);
                        } catch (NumberFormatException e) {
                            gamesWon = 0;
                        }
                        Users.add(new Player(dataArray[0], gamesPlayed, gamesWon));
                    } else {
                        Users.add(new Player(dataArray[0]));
                    }
                    dataLoaded = true;
                }
                fileReader.close();
            } catch (FileNotFoundException e) {

            }
        }
    }


    public static void updateData() {
        if(dataLoaded) {
            try {
                PrintWriter file = new PrintWriter ("src/main/java/org/LaunchCode/darts/Data/users.txt");
                for(Player player : Users.getAll()) {
                    file.println(player.getName() + "," + player.getGamesPlayed() + "," + player.getGamesWon());
                }
                file.close();
            } catch (IOException e) {

            }
        }
    }



   /* private JSONObject userData;
    private static Boolean dataLoaded = false;


    public Boolean loadData () {
        if(!dataLoaded) {
            Object userFile = new JSONParser().parse(new FileReader(users.json));
            userData = (JSONObject) userFile;
        }
    }

    public Object getUserData () {
        return userData;
    }
    public Boolean getDataLoaded () {
        return dataLoaded;
    }
*/

}
