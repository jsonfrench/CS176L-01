
/*
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
        for (int i = 0; i < Math.min(10, sortedPlayers.size()); i++) {
            System.out.println((i + 1) + ". " + sortedPlayers.get(i).getKey() + " (" + sortedPlayers.get(i).getValue() + " times)");        
        }
        System.out.println("hello?");

    }
}

*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FangraphTopTen {
    public static void main(String[] args) {
        // Store the URL of the batting leaderboard for the year 2022
        final String URL = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0&team=0&rost=0&age=0&filter=&players=0";

        try {
            // Connect to the URL and get the HTML document
            Document doc = Jsoup.connect(URL).get();

            // Select the rows of the batting table, skipping the header row
            Elements rows = doc.select("#LeaderBoard1_dg1 > tbody > tr:gt(0)");

            // Iterate over the rows and print the data for the top ten batters
            int count = 0;
            for (Element row : rows) {
                if (count == 10) {
                    break;
                }
                String name = row.select("td.player > a").text();
                String team = row.select("td.team > a").text();
                String position = row.select("td.pos").text();
                String plateAppearances = row.select("td:nth-child(7)").text();
                String battingAverage = row.select("td:nth-child(9)").text();
                String onBasePercentage = row.select("td:nth-child(11)").text();
                String sluggingPercentage = row.select("td:nth-child(13)").text();
                String weightedOnBaseAverage = row.select("td:nth-child(17)").text();
                System.out.println((count + 1) + ". " + name + " (" + team + ", " + position + "): " + battingAverage + " AVG, " + onBasePercentage + " OBP, " + sluggingPercentage + " SLG, " + weightedOnBaseAverage + " wOBA");
                count++;
                System.out.println("Hey there!");
            }
        } catch (IOException e) {
            System.out.println("Error connecting to Fangraphs: " + e.getMessage());
        }
    }
}
