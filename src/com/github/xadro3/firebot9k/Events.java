package com.github.xadro3.firebot9k;


import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.io.IOException;

import static com.github.xadro3.firebot9k.BotUtils.BOT_PREFIX;


public class Events {


    @EventSubscriber
    public void messageReceived(MessageReceivedEvent event) throws IOException {

        String message = event.getMessage().getContent();

        SwearJar swearJar = new SwearJar();

        swearJar.isItASwearWord(event);


        /**  if(message.startsWith(BOT_PREFIX+"ChangePrefix")&& checkPermission(event.getAuthor(), "Prefix")){

         String[] strarray = event.getMessage().getContent().split(" ");

         if(strarray.length == 2){
         BOT_PREFIX = event.getMessage().getContent();

         BotUtils.sendMessage(event.getChannel(),"```Bot Prefix changed to "+BOT_PREFIX);
         }
         else {
         BotUtils.sendMessage(event.getChannel(),"@"+event.getAuthor().toString()+" Cannot Change prefix, Use `!ChangePrefix <NewPrefix>`.");
         }

         }
         else {
         BotUtils.sendMessage(event.getChannel(), "@"+event.getAuthor().toString()+"No such command or insufficient Permissions, see your local Mod to get more.");
         }**/


        if (message.toUpperCase().equals("!HELP")) {

            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.withTitle("Looks like you want help for Botcommands try:");
            embedBuilder.withColor(255, 127, 71);
            embedBuilder.appendField("Commands", "**" + BOT_PREFIX + "firehelp**     "
                    + '\n' + "**!bot help**           "
                    + '\n' + "**b>help**              "
                    + '\n' + "**;;help**              "
                    + '\n' + "**?help**               "
                    + '\n' + "**@RemindMeBot help**   "
                    + '\n' + "**-mod help**           "
                    + '\n' + "-> Normal Users ------> "
                    + '\n' + "**!stats help**         "
                    + '\n' + "**.help**               ", true);
            embedBuilder.appendField("Bots", "FireBot9K" +
                    '\n' + "TheAwesomeBot" +
                    '\n' + "beattie-bot" +
                    '\n' + "FredBoat♪♪" +
                    '\n' + "Dynobot(Programming Discussions)" +
                    '\n' + "RemindMeBot" +
                    '\n' + "Safety Jim(Only for Mod Users)" +
                    '\n' + "use **@Safety Jim#9254 commands**" +
                    '\n' + "StabbyStats(Only Usable by helpers and above)" +
                    '\n' + "KatBot.", true);
            embedBuilder.withFooterText("***PLEASE DO NOT ABUSE THIS COMMAND, OR SAFETY JIM WILL COME AFTER YOU***");

            RequestBuffer.request(() -> event.getChannel().sendMessage(embedBuilder.build()));
            LoggerService.log("successfully responded to !help");
        }


        if (message.toUpperCase().equals(BOT_PREFIX + "FIREHELP")) {

            String s = "```Help for FireBot9K:" + '\n' +
                    "!Reddit <Subreddit> <Number of Submissions(opt)>." +
                    '\n' + "!Torrents, posts a torrent info."
                    + '\n' + "!ThinkingWirhGlitches: Posts the Meme."
                    + '\n' + "!ThinkingSpinner: Posts the Meme.```";

            BotUtils.sendMessage(event.getChannel(), s);
        }

        if (message.toUpperCase().startsWith(BOT_PREFIX + "REDDIT")) {

            RedditCommand rcmd = new RedditCommand();
            rcmd.reddit(event);
        }

        if (message.toUpperCase().equals(BOT_PREFIX + "THINKINGSPINNER")) {


            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.withColor(255, 127, 71);
            embedBuilder.withImage("https://cdn.discordapp.com/attachments/238691387015430146/326378112801701890/spinner6.gif");

            RequestBuffer.request(() -> event.getChannel().sendMessage(embedBuilder.build()));


        }
        if (message.toUpperCase().equals(BOT_PREFIX + "THINKINGWITHGLITCHES")) {

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.withColor(255, 127, 71);
            embedBuilder.withImage("https://68.media.tumblr.com/dda8ecf306902967689763009cd4df09/tumblr_inline_omcxyekc8h1slb94s_500.gif");

            RequestBuffer.request(() -> event.getChannel().sendMessage(embedBuilder.build()));
        }
        if (message.toUpperCase().equals(BOT_PREFIX + "TORRENTS")) {

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.withColor(255, 127, 71);

            embedBuilder.withImage("http://i.imgur.com/fcl201Q.gif");
            embedBuilder.withTitle("We do not talk about Torrents or Piracy, or any other illegal/shady things. ");
            embedBuilder.withFooterText(" Safety jim will Come after you!");

            RequestBuffer.request(() -> event.getChannel().sendMessage(embedBuilder.build()));

        }

        if (message.toUpperCase().equals(BOT_PREFIX + "JAR STATS")) {


            swearJar.checkStats(event);


        }

        if (message.toUpperCase().contains(BOT_PREFIX + "JAR ADD")) {


            swearJar.addWord(event);


        }


        /** if(message.toUpperCase().equals(BOT_PREFIX+"FIRE MATH")){

         FireMath fireMath = new FireMath();

         fireMath.fireMath(message);

         EmbedBuilder embedBuilder = new EmbedBuilder();
         embedBuilder.withColor(255, 127, 71);
         embedBuilder.withTitle((String.valueOf(fireMath.fireMath(message))));

         RequestBuffer.request(() -> event.getChannel().sendMessage(embedBuilder.build()));

         }

         }


         /** public boolean checkPermission(IUser user, String command){




         boolean permission;








         return permission;
         }**/

    }
}
