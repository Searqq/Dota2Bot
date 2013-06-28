import org.jibble.pircbot.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

public class Dota2Bot extends PircBot {

    private ArrayList<String> valid = new ArrayList<String>();

    public Dota2Bot() 
    {
        this.setName("Dota2Bot");
    }
    
    public void onConnect()
    {
        identify("1337b0t");
    }

    public void onKick(String channel, String kickerNick, String kickerLogin, String kickerHostname, String recipientNick, String reason) 
    {
        if (recipientNick.equalsIgnoreCase("dota2bot"))
        {
            joinChannel(channel);
        }
    }

    public void onInvite(String targetNick, String sourceNick, String sourceLogin, String sourceHostname, String channel)
    {
        joinChannel(channel);
        sendMessage(channel, "Hi " + sourceNick);
    }

    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) 
    {
       JSONParser parser = new JSONParser();
       ArrayList<String> heroes = new ArrayList<String>();
       JSONObject jsonObject = new JSONObject();

       try 
       {
            //original from http://dotaheroes.herokuapp.com/heroes/all, accessed June 24, 2013, with edits
            Object obj = parser.parse(new FileReader("/home/lemonade/Desktop/GitProjects/Dota2Bot/src/allDota2Heroes.json"));
            jsonObject = (JSONObject) obj;
            for (int i = 0; i <= 100; i++)
            {
                String count = (String) Integer.toString(i+1);
                JSONObject test1 = (JSONObject) jsonObject.get(count);

                String name = test1.get("Name").toString().toLowerCase();
                heroes.add(name);
            }
        }
        
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }

/* 

        if (message.equalsIgnoreCase("!help"))
        {            sendMessage(channel, "Commands! 
                !attr: returns base attributes and gain / level; 
                !ehp: returns the EHP of the hero; 
                !hpm: returns the HP and Mana of the hero; 
                !movespeed or !ms: returns the movespeed of the hero; 
                !range: returns the range of the hero; 
                !vision: returns the day and night vision of the hero;
                !turnrate or !tr: returns the turnrate fo the hero");
   
            sendMessage(channel, "Stuffs");
            sendMessage(channel, "!attr: returns base attributes and gain / level");
            sendMessage(channel, "!movespeed or !ms: retruns movespeed of the hero");
            sendMessage(channel, "!ehp: returns the ehp of the hero");
            sendMessage(channel, "!vision: returns day vision and night vision of the hero");
            sendMessage(channel, "!range: returns the attack range of the hero");
            sendMessage(channel, "!hpm: returns the staring HP and Mana of the hero");
            // base attack time
            sendMessage(channel, "more to come");  
        } 

        if (message.equalsIgnoreCase("!about"))
        {
            sendMessage(channel, "");
        }*/       


        if (message.startsWith("!"))
        {
            int spaceind = message.indexOf(" ");
            String precommand = message.substring(0,spaceind);
            String command = precommand.replace("!","");
            String heroselect = message.substring(spaceind+1,message.length()).toLowerCase();
            String heroIDnum = new String();

            switch(heroselect)
            {
                case "am":
                    heroIDnum = Integer.toString(heroes.indexOf("anti-mage")+1);
                break;

                case "aa":
                    heroIDnum = Integer.toString(heroes.indexOf("ancient apparition")+1);
                break;

                case "np":
                    heroIDnum = Integer.toString(heroes.indexOf("nature's prophet")+1);
                break;

                case "furion":
                    heroIDnum = Integer.toString(heroes.indexOf("nature's prophet")+1);
                break;

                case "bh":
                    heroIDnum = Integer.toString(heroes.indexOf("bounty hunter")+1);
                break;

                case "gondar":
                    heroIDnum = Integer.toString(heroes.indexOf("bounty hunter")+1);
                break;

                case "drow":
                    heroIDnum = Integer.toString(heroes.indexOf("drow ranger")+1);
                break;

                case "doom bringer":
                    heroIDnum = Integer.toString(heroes.indexOf("doom")+1);
                break;

                case "mag":
                    heroIDnum = Integer.toString(heroes.indexOf("magnus")+1);
                break;

                case "kotl":
                    heroIDnum = Integer.toString(heroes.indexOf("keeper of the light")+1);
                break;

                case "qop":
                    heroIDnum = Integer.toString(heroes.indexOf("queen of pain")+1);
                break;

                case "bs":
                    heroIDnum = Integer.toString(heroes.indexOf("bloodseeker")+1);
                break;

                case "centaur":
                    heroIDnum = Integer.toString(heroes.indexOf("centaur warrunner")+1);
                break;

                case "es":
                    heroIDnum = Integer.toString(heroes.indexOf("earthshaker")+1);
                break;

                case "ld":
                    heroIDnum = Integer.toString(heroes.indexOf("lone druid")+1);
                break;

                case "sylla":
                    heroIDnum = Integer.toString(heroes.indexOf("lone druid")+1);
                break;

                case "cm":
                    heroIDnum = Integer.toString(heroes.indexOf("crystal maiden")+1);
                break;

                case "morph":
                    heroIDnum = Integer.toString(heroes.indexOf("morphling")+1);
                break;

                case "naga":
                    heroIDnum = Integer.toString(heroes.indexOf("naga siren")+1);
                break;

                case "pl":
                    heroIDnum = Integer.toString(heroes.indexOf("phantom lancer")+1);
                break;

                case "treant":
                    heroIDnum = Integer.toString(heroes.indexOf("treant protector")+1);
                break;

                case "tree":
                    heroIDnum = Integer.toString(heroes.indexOf("treant protector")+1);
                break;

                case "wisp":
                    heroIDnum = Integer.toString(heroes.indexOf("io")+1);
                break;

                case "alch":
                    heroIDnum = Integer.toString(heroes.indexOf("alchemist")+1);
                break;

                case "potm":
                    heroIDnum = Integer.toString(heroes.indexOf("mirana")+1);
                break;

                case "troll":
                    heroIDnum = Integer.toString(heroes.indexOf("troll warlord")+1);
                break;

                case "gyro":
                    heroIDnum = Integer.toString(heroes.indexOf("gyrocopter")+1);
                break;

                case "ss":
                    sendMessage(channel, "For Storm Spirit, use ss. For Shadow Shaman, use rhasta or shaman");
                    command = command + " ";
                break;

                case "storm":
                    heroIDnum = Integer.toString(heroes.indexOf("storm spirit")+1);
                break;

                case "shaman":
                    heroIDnum = Integer.toString(heroes.indexOf("shadow shaman")+1);
                break;

                case "wr":
                    heroIDnum = Integer.toString(heroes.indexOf("windrunner")+1);
                break;

                case "clock":
                    heroIDnum = Integer.toString(heroes.indexOf("clockwerk")+1);
                break;

                case "dk":
                    heroIDnum = Integer.toString(heroes.indexOf("dragon knight")+1);
                break;

                case "bb":
                    heroIDnum = Integer.toString(heroes.indexOf("bristleback")+1);
                break;

                case "ta":
                    heroIDnum = Integer.toString(heroes.indexOf("templar assassin")+1);
                break;

                case "venge":
                    heroIDnum = Integer.toString(heroes.indexOf("vengeful spirit")+1);
                break;

                case "vs":
                    heroIDnum = Integer.toString(heroes.indexOf("vengeful spirit")+1);
                break;

                case "ogre":
                    heroIDnum = Integer.toString(heroes.indexOf("ogre magi")+1);
                break;

                case "jak":
                    heroIDnum = Integer.toString(heroes.indexOf("jakiro")+1);
                break;

                case "thd":
                    heroIDnum = Integer.toString(heroes.indexOf("jakiro")+1);
                break;

                case "rhasta":
                    heroIDnum = Integer.toString(heroes.indexOf("")+1);
                break;

                case "skywrath":
                    heroIDnum = Integer.toString(heroes.indexOf("skywrath mage")+1);
                break;

                case "ck":
                    heroIDnum = Integer.toString(heroes.indexOf("chaos knight")+1);
                break;

                case "ls":
                    heroIDnum = Integer.toString(heroes.indexOf("lifestealer")+1);
                break;

                case "naix":
                    heroIDnum = Integer.toString(heroes.indexOf("lifestealer")+1);
                break;
            
                case "brood":
                    heroIDnum = Integer.toString(heroes.indexOf("broodmother")+1);
                break;

                case "nyx":
                    heroIDnum = Integer.toString(heroes.indexOf("nyx assassin")+1);
                break;

                case "ds":
                    heroIDnum = Integer.toString(heroes.indexOf("dark seer")+1);
                break;

                case "dp":
                    heroIDnum = Integer.toString(heroes.indexOf("death prophet")+1);
                break;

                case "lycan":
                    heroIDnum = Integer.toString(heroes.indexOf("lycanthrope")+1);
                break;

                case "ns":
                    heroIDnum = Integer.toString(heroes.indexOf("night stalker")+1);
                break;

                case "pa":
                    heroIDnum = Integer.toString(heroes.indexOf("phantom assassin")+1);
                break;

                case "sf":
                    heroIDnum = Integer.toString(heroes.indexOf("shadow fiend")+1);
                break;

                case "necro":
                    heroIDnum = Integer.toString(heroes.indexOf("necrolyte")+1);
                break;

                case "sk":
                    sendMessage(channel, "For Sand King, use sand. For Skeleton King, use skelly");    
                    command = command + " ";
                break;

                case "sand":
                    heroIDnum = Integer.toString(heroes.indexOf("sand king")+1);
                break;

                case "skelly":
                    heroIDnum = Integer.toString(heroes.indexOf("skeleton king")+1);
                break;

                case "veno":
                    heroIDnum = Integer.toString(heroes.indexOf("venomancer")+1);
                break;

                case "od":
                    heroIDnum = Integer.toString(heroes.indexOf("outworld devourer")+1);
                break;

                case "sd":
                    heroIDnum = Integer.toString(heroes.indexOf("shadow demon")+1);
                break;

                case "tide":
                    heroIDnum = Integer.toString(heroes.indexOf("tidehunter")+1);
                break;

                case "sb":
                    heroIDnum = Integer.toString(heroes.indexOf("spirit breaker")+1);
                break;

                case "cow":
                    heroIDnum = Integer.toString(heroes.indexOf("spirit breaker")+1);
                break;

                case "void":
                    heroIDnum = Integer.toString(heroes.indexOf("faceless void")+1);
                break;

                case "faceless":
                    heroIDnum = Integer.toString(heroes.indexOf("faceless void")+1);
                break;

                case "bat":
                    heroIDnum = Integer.toString(heroes.indexOf("batrider")+1);
                break;

                case "wd":
                    heroIDnum = Integer.toString(heroes.indexOf("witch doctor")+1);
                break;
            
                case "titan":
                    heroIDnum = Integer.toString(heroes.indexOf("elder titan")+1);
                break;

                default:
                heroIDnum = Integer.toString(heroes.indexOf(heroselect)+1);
            }  

            JSONObject selectedHero = (JSONObject) jsonObject.get(heroIDnum);

            if (selectedHero == null && isValidcommand().contains(command))
            {
                sendMessage(channel, "That is not a hero. Are you using the correct spelling?");   
            }
            
            String renji = selectedHero.get("Range").toString();
            String movespeed = selectedHero.get("Movespeed").toString();
            String armor = selectedHero.get("Armor").toString();
            String health = selectedHero.get("HP").toString();
            String mana = selectedHero.get("Mana").toString();
            double armord = Double.parseDouble(armor);
            double healthd = Double.parseDouble(health);
            double ehp = healthd * (1 + 0.06 * armord);
            String bsstr = selectedHero.get("BaseStr").toString();
            String bsagi = selectedHero.get("BaseAgi").toString();
            String bsint = selectedHero.get("BaseInt").toString();
            String strgain = selectedHero.get("StrGain").toString();
            String agigain = selectedHero.get("AgiGain").toString();
            String intgain = selectedHero.get("IntGain").toString();
            String dayv = selectedHero.get("DayVision").toString();
            String nightv = selectedHero.get("NightVision").toString();
            String baseat = selectedHero.get("BaseAttackTime").toString();
            String turnr8 = selectedHero.get("Turnrate").toString();
            switch (command)
            {
               /* case "help":
                    sendMessage(channel, "Commands! !attr: returns base attributes and gain / level; !ehp: returns the EHP of the hero; !hpm: returns the HP and Mana of the hero; !movespeed or !ms: returns the movespeed of the hero; !range: returns the range of the hero; !vision: returns the day and night vision of the hero;");
                break; */

                case "range": 
                    sendMessage(channel, renji);
                break;

                case "attr":
                    sendMessage(channel, "Strength: " + bsstr + " + " + strgain + "/level; " + "Agility: " + bsagi + " + " + agigain + "/level; " + "Intelligence: " + bsint + " + " + intgain + "/level");
                break;

                case "movespeed":
                    sendMessage(channel, movespeed);                  
                break;

                case "ms":
                    sendMessage(channel,movespeed);
                break;

                case "ehp":
                    sendMessage(channel, String.valueOf(ehp)+1);
                break;

                case "armor":
                    sendMessage(channel, armor);
                break;

                case "hpm":
                    sendMessage(channel, "HP: " + health + "; " + "Mana: " + mana);
                break;

                case "vision":
                    sendMessage(channel, "Day Vision: " + dayv + "; " + "Night Vision: " + nightv);
                break;

                case "bat":
                    sendMessage(channel, baseat);
                break;

                case "turnrate":
                    sendMessage(channel, turnr8);
                break;

                case "tr":
                    sendMessage(channel, turnr8);
                break;

                default:
                //sendMessage(channel, "Are you using the right command? Ask !help for more information.");
            }
        }       
    }     
        public ArrayList<String> isValidcommand()
        {
            valid.add("attr");
            valid.add("movespeed");
            valid.add("ms");
            valid.add("ehp");
            valid.add("vision");
            valid.add("range");
            valid.add("hpm");
            valid.add("bat");
            valid.add("armor");
            //valid.add("help");
            return valid;
        }
}