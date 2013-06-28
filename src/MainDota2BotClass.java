import org.jibble.pircbot.*;

public class MainDota2BotClass {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        Dota2Bot bot = new Dota2Bot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.synirc.net", 6661); 

        bot.joinChannel("#testla");
        //bot.joinChannel("#smogdota");
        
    }
    
}