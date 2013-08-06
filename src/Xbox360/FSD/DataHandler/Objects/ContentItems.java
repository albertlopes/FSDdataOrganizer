package Xbox360.FSD.DataHandler.Objects;

import java.util.ArrayList;

/**
 *
 * @author Albert_Dark
 */
public class ContentItems {

    private ArrayList<Integer> assets = new ArrayList();
    private ArrayList<Integer> favorites = new ArrayList();
    private ArrayList<Integer> recentPlayed = new ArrayList();
    private ArrayList<Integer> userRatings = new ArrayList();
    private int ContentItemId;
    private int ContentItemIdOrdered;
    private String ContentItemName;

    public void setContentItemId(int ContentItemId) {
        this.ContentItemId = ContentItemId;
    }

    public int getContentItemId() {
        return ContentItemId;
    }

    public void setContentItemName(String ContentItemName) {
       this.ContentItemName = ContentItemName;
    }

    public String getContentItemName() {
        return ContentItemName.replace("'", "''");
    }

    public void setContentItemIdOrdered(int ContentItemIdOrdered) {
        this.ContentItemIdOrdered = ContentItemIdOrdered;
    }

    public int getContentItemIdOrdered() {
        return ContentItemIdOrdered;
    }

    public ArrayList getAssets() {
        return assets;
    }

    public void setAssets(Integer asset) {
        assets.add(asset);
    }

    public ArrayList getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites.add(favorites);
    }

    public ArrayList getRecentPlayed() {
        return recentPlayed;
    }

    public void setRecentPlayed(int recentPlayed) {
        this.recentPlayed.add(recentPlayed);
    }

    public ArrayList getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(int userRatings) {
        this.userRatings.add(userRatings);
    }
}
