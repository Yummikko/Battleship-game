package view;

import board.Square;
import util.Input;

public class Display {
    Input input;

    public Display(Input input) {
        this.input = input;
    }

    public void showLogo() {

        System.out.println(Colors.ANSI_BLACK + "                                                                                                        ▄██");
        System.out.println(Colors.ANSI_BLACK + "                                                                                                        █▌█");
        System.out.println(Colors.ANSI_BLACK + "                                                                                                      ''█ █'");
        System.out.println(Colors.ANSI_BLACK + "                                                                                                    ,,,,█,█▄,,,");
        System.out.println(Colors.ANSI_BLACK + "                                                                                                   ╓█▀▀▀▀▀▀▀▀█▀");
        System.out.println(Colors.ANSI_BLACK + "                                                                                         ██▌      █▀         █Ç         ▌█");
        System.out.println(Colors.ANSI_BLACK + "                                                                                         ██      █,,,▄▄▄▄,,   █▄        █▐█");
        System.out.println(Colors.ANSI_BLACK + "                                                                                        ▐▌█   ,  ▀▀    █ ¬█ ▀▀▀▀N      ▐▌█▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                                ▄,,,    ▐C█    ██▀▀▀▓▓███████▀$ßMM╦▄   ██▐▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                                ▀▌══∞∞▄▄██▀▀▀▀▀══∞∞⌐           █▀      █▐▌▐▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                               ,█              -▐█▀           █▀     ▐▌█ ]▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                               █                █`           ▐▌      ██   █");
        System.out.println(Colors.ANSI_BLACK + "                                                                             ▐▌                █            █⌐     █▐▌   ╘▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                            ▐▌                █            █     ╒▌█     ▐█▄▄");
        System.out.println(Colors.ANSI_BLACK + "                                                                              ▌                ╘█           └█    ██████▀▀▀▀▀`");
        System.out.println(Colors.ANSI_BLACK + "                                                                               █⌐                ▐█▄▄▄▄▄▄▄▄▄, ▀▌  ▐▐▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                                █ ,▄▄▄4█▀█▀▀RN▄▄▄▄▐█ █   █  .▀▀▀▀]▌█,,,▄▄▄▄▄▄▄▄");
        System.out.println(Colors.ANSI_BLACK + "                                                                        ▀▀███▄▄▄▄█▄▄▄▄▄▌,█,        ▀▀█   █  ▐█▀▀▀▀▀▀▀▀▀`- -  █▌");
        System.out.println(Colors.ANSI_BLACK + "                                                                              ▀█████▄▄▄▄▄▄▄▄▄▀▀█▄  ,▐▌  ,█,▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄██");
        System.out.println(Colors.ANSI_BLACK + "                                                                                 ▀█▄     '`▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀''`  -`     ▐█");
        System.out.println(Colors.ANSI_BLACK + "                                                                                   ▀█                                   ,█");
        System.out.println(Colors.ANSI_BLACK + "                                                                                     ██                                 ▄█`");
        System.out.println(Colors.ANSI_BLACK + "                                                                                     █ , ▄▄ ,▄▄  ▄▄  ▄▄  ▄▄, ▄▄,  ▄▄  ██");
        System.out.println(Colors.CYAN_BOLD + "                                                                               ▀▀████▀▀-`▀████▀`▀██▄██▀'▀██▄██▀█▀▀`▀▀███▀▀▀██▄██▀");
        System.out.println(Colors.CYAN_BOLD + "                                                              ▀██▄██▀▀██▄██▀▀▀████▀▀-`▀████▀`▀██▄██▀'▀████▀▀`▀▀███▀▀▀▀████▀▀▀██▄██▀ ██▀▀▀██▄██▀");
        System.out.println(Colors.CYAN_BOLD + "                                                                          ▀██▄██▀ ▀▀████▀▀-`▀████▀`▀██▄██▀'▀████▀▀`▀▀███▀▀▀██▄██▀▀██▄██▀/\n");

        System.out.println(Colors.ANSI_BLACK + "                                                                ██████╗  █████╗ ████████╗████████╗██╗     ███████╗ ██████╗██╗  ██╗██╗██████╗ ");
        System.out.println(Colors.ANSI_BLACK + "                                                                ██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝██╔════╝██║  ██║██║██╔══██╗");
        System.out.println(Colors.ANSI_BLACK + "                                                                ██████╦╝███████║   ██║      ██║   ██║     █████╗  ╚█████╗ ███████║██║██████╔╝");
        System.out.println(Colors.ANSI_BLACK + "                                                                ██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝   ╚═══██╗█╔══ ██║██║██╔═══╝ ");
        System.out.println(Colors.ANSI_BLACK + "                                                                ██████╦╝██║  ██║   ██║      ██║   ███████╗███████╗██████╔╝██║  ██║██║██║     ");
        System.out.println(Colors.ANSI_BLACK + "                                                                ╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝    \n");
        System.out.println("\n");


    }

    public void showMenu() {
        System.out.println(Colors.CYAN_BOLD + "press: \n" + Colors.ANSI_BLACK +
                "\t 0 - Player vs player game! \n" +
                "\t 1 - AI vs AI! \n" +
                "\t 2 - Player vs AI! \n" +
                "\t 3 - Print game rules \n" +
                "\t 4 - Exit game\n");
    }

    public void gameRules() {
        System.out.println(Colors.CYAN_BOLD + "Here are some rules of the game: ");
        System.out.println(Colors.ANSI_BLACK + "1. Each ship must be placed horizontally or vertically across grid spaces—not diagonally—and the ships can't hang off the grid.");
        System.out.println(Colors.ANSI_BLACK + "2. Ships can't touch each other (touching corners are okay)");
        System.out.println(Colors.ANSI_BLACK + "3. You cannot change the position of the ships after the game begins.\n");
    }


    public void printRedMessages(String message) {
        System.out.println(Colors.ANSI_RED + message);
    }

    public void printBlueMessages(String message) {
        System.out.println(Colors.CYAN_BOLD + message);
    }

    public void printBlackMessages(String message) {
        System.out.println(Colors.ANSI_BLACK + message);
    }

    public void clickToContinue() {
        System.out.println(Colors.CYAN_BOLD + "Please click any button on Your keyboard to continue\n");
    }


    public void waitingScreen() {
        System.out.println(Colors.ANSI_BLACK + "\n                                                ██████╗███████╗ █████╗  █████╗ ███╗  ██╗██████╗ ██╗ ██████╗   ██████╗ ██╗      █████╗ ██╗   ██╗███████╗██████╗ ");
        System.out.println(Colors.ANSI_BLACK + "                                               ██╔════╝██╔════╝██╔══██╗██╔══██╗████╗ ██║██╔══██╗╚█║██╔════╝   ██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██╔════╝██╔══██╗");
        System.out.println(Colors.ANSI_BLACK + "                                               ╚█████╗ █████╗  ██║  ╚═╝██║  ██║██╔██╗██║██║  ██║ ╚╝╚█████╗    ██████╔╝██║     ███████║ ╚████╔╝ █████╗  ██████╔╝");
        System.out.println(Colors.ANSI_BLACK + "                                                ╚═══██╗██╔══╝  ██║  ██╗██║  ██║██║╚████║██║  ██║    ╚═══██╗   ██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██╔══╝  ██╔══██╗");
        System.out.println(Colors.ANSI_BLACK + "                                               ██████╔╝███████╗╚█████╔╝╚█████╔╝██║ ╚███║██████╔╝    ██████╔╝  ██║     ███████╗██║  ██║   ██║   ███████╗██║  ██║");
        System.out.println(Colors.ANSI_BLACK + "                                              ╚═════╝ ╚══════╝ ╚════╝  ╚════╝ ╚═╝  ╚══╝╚═════╝    ╚═════╝    ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝\n");

        System.out.println("                                                                                 ████████╗██╗   ██╗██████╗ ███╗  ██╗");
        System.out.println("                                                                                 ╚══██╔══╝██║   ██║██╔══██╗████╗ ██║");
        System.out.println("                                                                                    ██║   ██║   ██║██████╔╝██╔██╗██║");
        System.out.println("                                                                                    ██║   ██║   ██║██╔══██╗██║╚████║");
        System.out.println("                                                                                    ██║   ╚██████╔╝██║  ██║██║ ╚███║");
        System.out.println("                                                                                    ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚══╝\n");
        System.out.println(Colors.CYAN_BOLD + "\nClick enter to start");
    }

    public void shootingPhase() {
        System.out.println(Colors.ANSI_BLACK + "\n                                                  ██████╗██╗  ██╗ █████╗  █████╗ ████████╗██╗███╗  ██╗ ██████╗   ██████╗ ██╗  ██╗ █████╗  ██████╗███████╗");
        System.out.println(Colors.ANSI_BLACK + "                                                 ██╔════╝██║  ██║██╔══██╗██╔══██╗╚══██╔══╝██║████╗ ██║██╔════╝   ██╔══██╗██║  ██║██╔══██╗██╔════╝██╔════╝");
        System.out.println(Colors.ANSI_BLACK + "                                                 ╚█████╗ ███████║██║  ██║██║  ██║   ██║   ██║██╔██╗██║██║  ██╗   ██████╔╝███████║███████║╚█████╗ █████╗  ");
        System.out.println(Colors.ANSI_BLACK + "                                                  ╚═══██╗██╔══██║██║  ██║██║  ██║   ██║   ██║██║╚████║██║  ╚██╗  ██╔═══╝ ██╔══██║██╔══██║ ╚═══██╗██╔══╝  ");
        System.out.println(Colors.ANSI_BLACK + "                                                 ██████╔╝██║  ██║╚█████╔╝╚█████╔╝   ██║   ██║██║ ╚███║╚██████╔╝  ██║     ██║  ██║██║  ██║██████╔╝███████╗");
        System.out.println(Colors.ANSI_BLACK + "                                                 ╚═════╝ ╚═╝  ╚═╝ ╚════╝  ╚════╝    ╚═╝   ╚═╝╚═╝  ╚══╝ ╚═════╝   ╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝\n");

    }

    public void shipSizeVisualisation() {
        System.out.println(Colors.ANSI_BLACK + "Carrier: ◯ ◯ ◯ ◯ ◯        Cruiser: ◯ ◯ ◯ ◯    Battleship: ◯ ◯ ◯    Submarine: ◯ ◯    Destroyer: ◯\n\n");
    }

    public void showShips() {
        System.out.println("\n  __|__ |___| |\\" + "\t\t\t   __[]__" + "\t\t\t    _~ " + "\t\t\t\t    . ");
        System.out.println("  |___| |___| |o \\" + "\t\t\t _|_o_o_o\\__" + "\t\t _~ )_)_~" + "\t\t\t   /|\\");
        System.out.println(" _|___| |___| |__o\\" + "\t\t\t__|_o_o_o\\__" + "\t\t )_))_))_)" + "\t\t\t  /_|_\\");
        System.out.println("/...\\_____|___|____\\  " + "\t\t\\          /" + "\t\t _!__!__!_" + "\t\t    ____|____\t\t\t__/\\__");
        System.out.println("\\   o * o * * o o  /" + "\t\t \\......../" + "\t\t\t \\_______/" + "\t\t    \\_______/\t\t\t\\____/");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void showBoard(Square[][] ocean, Boolean isFighting) {

        String tableRowStart = "  +-----";
        String tableRow = "+-----";
        String tableRowEnd = "+-----+";

        for (int i = 0; i < ocean.length; ++i)
            System.out.format(Colors.ANSI_BLACK + "    %2s", (char) (i + 'A'));
        System.out.println();

        for (int i = 0; i < ocean.length; i++) {
            System.out.print(Colors.ANSI_BLACK + tableRowStart);
            System.out.print(Colors.ANSI_BLACK + tableRow.repeat(ocean.length - 2));
            System.out.println(Colors.ANSI_BLACK + tableRowEnd);
            System.out.print(i + 1);

            for (int j = 0; j < ocean[i].length; j++) {
                if (i < 9) {
                    if (!isFighting) {
                        System.out.format(Colors.ANSI_BLACK + " |  %2s", ocean[i][j].getSquareStatus().getCharacter());
                    } else {
                        if (ocean[i][j].getSquareStatus().getCharacter() == "H") {
                            System.out.format(Colors.ANSI_BLACK + " |  %2s", "\uD83D\uDC80");
                        } else if (ocean[i][j].getSquareStatus().getCharacter() == "M") {
                            System.out.format(Colors.ANSI_BLACK + " |  %2s", "◯");
                        } else {
                            System.out.format(Colors.ANSI_BLACK + " |  %2s", " ");
                        }
                    }
                } else {
                    if (!isFighting) {
                        System.out.format(Colors.ANSI_BLACK + "| %2s  ", ocean[i][j].getSquareStatus().getCharacter());
                    } else {
                        if (ocean[i][j].getSquareStatus().getCharacter() == "H" ) {
                            System.out.format(Colors.ANSI_BLACK + "| %2s  ", "\uD83D\uDC80");
                        } else if (ocean[i][j].getSquareStatus().getCharacter() == "M") {
                            System.out.format(Colors.ANSI_BLACK + "| %2s  ", "◯");
                        } else {
                            System.out.format(Colors.ANSI_BLACK + "| %2s  ", " ");
                        }
                    }
                }

                if (j == ocean.length - 1) {
                    if (i < 9) {
                        System.out.print(Colors.ANSI_BLACK + " |");
                    } else {
                        System.out.print(Colors.ANSI_BLACK + "|");
                    }
                }
            }
            System.out.println();
            if (i == ocean.length - 1) {
                System.out.print(Colors.ANSI_BLACK + tableRowStart);
                System.out.print(Colors.ANSI_BLACK + tableRow.repeat(ocean.length - 2));
                System.out.println(Colors.ANSI_BLACK + tableRowEnd);
            }
        }
    }

    public void printPlacementMode() {
        System.out.println(Colors.CYAN_BOLD + "\nIf you want to place your ships manually please select 1.");
        System.out.println(Colors.CYAN_BOLD + "If you want to place your ships automatically, please select 2.\n");
    }
}
