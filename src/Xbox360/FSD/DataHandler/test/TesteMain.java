package xbox360.fsd.dataHandler.test;

import Xbox360.FSD.DataHandler.DAO.*;
import Xbox360.FSD.DataHandler.Objects.*;
import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class TesteMain {

    public static void main(String args[]) {

        String path = "D:\\Arquivos\\Databases\\man\\fsd2data.db";

        UserRatingsDAO rating = new UserRatingsDAO(path);
        RecentlyPlayedDAO recents = new RecentlyPlayedDAO(path);
        FavoritesDAO favorites = new FavoritesDAO(path);
        AssetsDAO assets = new AssetsDAO(path);
        ContentItemsDAO contentItems = new ContentItemsDAO(path);

        ArrayList<ContentItems> contentItemsArray = contentItems.get();
        ArrayList<Assets> assetsArray = assets.get();
        ArrayList<UserRatings> ratingArray = rating.get();
        ArrayList<RecentlyPlayed> recentsArray = recents.get();
        ArrayList<Favorites> favoritesArray = favorites.get();

        System.out.println("Updating: Content Itens ");
        contentItems.update(contentItemsArray);

        System.out.println("Updating: Assets ");
        assets.update(contentItemsArray, assetsArray);
        assetsArray.clear();

        System.out.println("Updating: Ratings ");
        rating.update(contentItemsArray, ratingArray);
        ratingArray.clear();

        System.out.println("Updating: Recents ");
        recents.update(contentItemsArray, recentsArray);
        recentsArray.clear();

        System.out.println("Updating: Favorites ");
        favorites.update(contentItemsArray, favoritesArray);
        favoritesArray.clear();

        contentItemsArray.clear();

        System.out.println("Done");

    }
}
