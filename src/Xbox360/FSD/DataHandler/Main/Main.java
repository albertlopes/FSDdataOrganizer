package Xbox360.FSD.DataHandler.Main;

import Xbox360.FSD.DataHandler.DAO.*;
import Xbox360.FSD.DataHandler.Objects.*;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class Main {

    public static void main(String args[]) {

        if (args.length > 0) {

            boolean exists = (new File(args[0])).exists();
            String path = args[0];

            if (exists) {

                boolean listItems = false;
                boolean noSort = false;
                boolean caps = false;
                boolean delfav = false;
                boolean delrat = false;
                boolean delrec = false;

                for (String vars : args) {

                    if (vars.equalsIgnoreCase("caps")) {
                        caps = true;
                    }

                    if (vars.equalsIgnoreCase("nosort")) {
                        System.out.println("Starting with NoSort, nothing will be done in your libraries");
                        noSort = true;
                    }

                    if (vars.equalsIgnoreCase("list")) {
                        listItems = true;
                    }

                    if (vars.equalsIgnoreCase("clrfav")) {
                        delfav = true;
                    }

                    if (vars.equalsIgnoreCase("clrrat")) {
                        delrat = true;
                    }

                    if (vars.equalsIgnoreCase("clrrec")) {
                        delrec = true;
                    }
                }

                if (!noSort) {

                    AssetsDAO assets = new AssetsDAO(path);
                    ContentItemsDAO contentItems = new ContentItemsDAO(path);

                    ArrayList<ContentItems> contentItemsArray = contentItems.get();
                    ArrayList<Assets> assetsArray = assets.get();

                    System.out.println("Updating: Libraries");
                    contentItems.update(contentItemsArray);

                    System.out.println("Updating: Art Paths");
                    assets.update(contentItemsArray, assetsArray);
                    assetsArray.clear();

                    if (!delfav) {
                        System.out.println("Updating: Favorites ");
                        FavoritesDAO favorites = new FavoritesDAO(path);
                        ArrayList<Favorites> favoritesArray = favorites.get();
                        favorites.update(contentItemsArray, favoritesArray);
                        favoritesArray.clear();
                    }
                    if (!delrat) {
                        System.out.println("Updating: Ratings ");
                        UserRatingsDAO rating = new UserRatingsDAO(path);
                        ArrayList<UserRatings> ratingArray = rating.get();
                        rating.update(contentItemsArray, ratingArray);
                        ratingArray.clear();
                    }
                    if (!delrec) {
                        System.out.println("Updating: Recents ");
                        RecentlyPlayedDAO recents = new RecentlyPlayedDAO(path);
                        ArrayList<RecentlyPlayed> recentsArray = recents.get();
                        recents.update(contentItemsArray, recentsArray);
                        recentsArray.clear();
                    }
                    contentItemsArray.clear();
                }

                if (delfav) {
                    System.out.println("Deleting: Favorites ");
                    FavoritesDAO favorites = new FavoritesDAO(path);
                    favorites.clean();
                }

                if (delrat) {
                    System.out.println("Deleting: Ratings ");
                    UserRatingsDAO rating = new UserRatingsDAO(path);
                    rating.clean();
                }

                if (delrec) {
                    System.out.println("Deleting: Recents ");
                    RecentlyPlayedDAO recents = new RecentlyPlayedDAO(path);
                    recents.clean();
                }

                if (caps) {
                    System.out.println("Capitalizing Titles");
                    ContentItemsDAO contentItems = new ContentItemsDAO(path);
                    contentItems.capitalize();
                }
                if (listItems) {
                    System.out.println("Showing Items:\n");
                    ContentItemsDAO contentItems = new ContentItemsDAO(path);
                    contentItems.list();
                }
                
                System.out.println("\nThe End");

            } else {
                System.out.println(
                        "File " + args[0] + " Not Found"
                        + "\nPlease write the full path + filename with extension and quotes, "
                        + "ex: \"c:\\myDir\\fsd2data.db\"");
            }

        } else {
            System.out.println(
                    "\n--------\n"
                    + "\n- :Usage: java -jar [jarName.jar] [Full fsd2data.db Path] [params] \nEx: "
                    + "java -jar fsd2dataOrganizer.jar \"c:\\myDir\\fsd2data.db\" caps clrrec list\n"
                    + "\n- :Parameters: (there's no order for usage)\n\n"
                    + "caps: This option will capitalize the titles of each game Ex:\n\n"
                    + "  GAME TITLE = Game Title\n"
                    + "  GaME tiTlE = Game Title\n"
                    + "  game title = Game Title\n\n"
                    + "nosort: Will not organize your games index.\n"
                    + "list: List your libraries items after finish all others tasks.\n\n"
                    + "clrfav: clean all Favorites data.\n"
                    + "clrrec: clean all Recent played data.(I recommend this)\n"
                    + "clrrat: clean all Users Ratting data.\n\n"
                    + "All three parametres above will delete only references for all profiles to clean your dataBase, not the game.\n"
                    + "\n\n--");
            System.out.println("ALWAYS BACKUP your fsd2data.db file and close any other application using it before you try this\n");
            System.out.println("It takes 2 minutes for sort my DB with 100 game titles, be patience if your games libraries contains too many items.\n");
        }
    }
}
