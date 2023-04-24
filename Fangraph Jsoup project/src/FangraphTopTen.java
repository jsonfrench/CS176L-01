import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class FangraphTopTen {
    public static void main(String[] args) {
        // Store the base URL of Fangraphs
        final String BASE_URL = "https://www.fangraphs.com";
        
        // Store the URLs for the batting leaderboards for the years 2022, 2021, and 2020
        String[] urls = {
            "/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0&team=0&rost=0&age=0&filter=&players=0",
            "/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2021&month=0&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0",
            "/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=0&season1=2020&ind=0&team=0&rost=0&age=0&filter=&players=0"
        };
        
        // Store the list of players for each year
        List<String>[] playerLists = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            playerLists[i] = new ArrayList<>();
        }
        
        // Scrape the player names from each leaderboard and add them to the corresponding player list
        for (int i = 0; i < 3; i++) {
            try {
                Document doc = Jsoup.connect(BASE_URL + urls[i]).get();
                Elements players = doc.select("td.player > a");
                for (Element player : players) {
                    playerLists[i].add(player.text());
                }
            } catch (IOException e) {
                System.out.println("Error connecting to Fangraphs: " + e.getMessage());
            }
        }
        
        // Combine the player lists and count the occurrences of each player
        Map<String, Integer> playerCounts = new HashMap<>();
        for (List<String> playerList : playerLists) {
            for (String player : playerList) {
                playerCounts.put(player, playerCounts.getOrDefault(player, 0) + 1);
            }
        }
        
        // Sort the player counts in descending order and print the top ten players
        List<Map.Entry<String, Integer>> sortedPlayers = new ArrayList<>(playerCounts.entrySet());
        sortedPlayers.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("Top ten batting leaders for 2022, 2021, and 2020:");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + sortedPlayers.get(i).getKey() + " (" + sortedPlayers.get(i).getValue() + " times)");
        }
    }
}