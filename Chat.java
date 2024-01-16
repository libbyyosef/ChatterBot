import java.util.Scanner;

public class Chat {
    static int numOfBots = 2;

    public static void main(String[] args) {

        String[] bot1Response = {"what " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + " ",
                "say I should say " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + " "};
        String[] bot2Response = {"say say " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + " ",
                "whaaat is " + ChatterBot.ILLEGAL_REQUEST_PLACEHOLDER + "? "};
        ChatterBot chatterBot1 = new ChatterBot("libby",
                new String[]{"you want me to say " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? okay: " +
                        ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + " "}, bot1Response);
        ChatterBot chatterBot2 = new ChatterBot("ido",
                new String[]{"say " + ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + "? okay: " +
                        ChatterBot.REQUESTED_PHRASE_PLACEHOLDER + " "}, bot2Response);
        ChatterBot[] chatterBots = {chatterBot1, chatterBot2};

        String statement = "do you love";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (ChatterBot bot : chatterBots) {
                statement = bot.replyTo(statement);
                System.out.println(bot.getName() + ": " + statement);
                scanner.nextLine();
            }
        }
    }
}
