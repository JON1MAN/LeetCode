package codewars.kata5.paginationhelper;

import java.util.List;

public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;
    private final int totalPages;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.totalPages = calculateTotalPages();
    }

    private int calculateTotalPages() {
        var flooredPages = Math.floor((double) itemCount() / itemsPerPage);
        return  (int) (itemCount() % itemsPerPage != 0 ? flooredPages + 1 : flooredPages);
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return totalPages;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     * <p>
     * 1 2 3 4 5 6 7, 2
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= totalPages || pageIndex < 0) {
            return -1;
        }
        return pageIndex == totalPages - 1 ? itemCount() - (pageIndex * itemsPerPage) : itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex >= itemCount() || itemIndex < 0)
            return -1;
        return itemIndex / itemsPerPage;
    }
}
