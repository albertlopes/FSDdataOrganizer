package Xbox360.FSD.DataHandler.Objects;

/**
 *
 * @author Albert_Dark
 */
public class RecentlyPlayed {

    private int ContentItemId;
    private int RecentlyPlayedTitleId;

    public int getContentItemId() {
        return ContentItemId;
    }

    public void setRecentlyPlayedTitleContentId(int ContentItemId) {
        this.ContentItemId = ContentItemId;
    }

    public int getRecentlyPlayedTitleId() {
        return RecentlyPlayedTitleId;
    }

    public void setRecentlyPlayedTitleId(int Id) {
        this.RecentlyPlayedTitleId = Id;
    }
}
