package codewars.kata5.paginationhelper;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
class TestPaginationHelper {
    private List<Character> collection = List.of('a', 'b', 'c', 'd', 'e', 'd', 'e');
    private PaginationHelper<Character> tested = new PaginationHelper<>(collection, 3);

    @Test
    void testPageCount() {
        assertEquals(3, tested.pageCount());
    }

    @Test
    void testItemCount() {
        assertEquals(6, tested.itemCount(), "itemCount is returning incorrect value");
    }

    @Test
    void testPageItemCount() {
        assertEquals( 4, tested.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals( 2, tested.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
        assertEquals(-1, tested.pageItemCount(2), "pageItemCount is returning incorrect value for page 2");
    }

    @Test
    void testPageIndex() {
        assertEquals( 1, tested.pageIndex(5), "pageIndex is returning incorrect value for index 5");
        assertEquals( 0, tested.pageIndex(2), "pageIndex is returning incorrect value for index 2");
        assertEquals(-1, tested.pageIndex(20), "pageIndex is returning incorrect value for index 20");
        assertEquals(-1, tested.pageIndex(-10), "pageIndex is returning incorrect value for index -10");
    }

    @Test
    void emptyCollection() {
        PaginationHelper<?> empty = new PaginationHelper<>(List.of(), 10);
        assertEquals( 0, empty.itemCount(), "itemCount is returning incorrect value");
        assertEquals( 0, empty.pageCount(), "pageCount is returning incorrect value");
        assertEquals(-1, empty.pageIndex(0), "pageIndex(0) called when there was an empty collection");
        assertEquals(-1, empty.pageIndex(1), "pageIndex(1) called when there was an empty collection");
        assertEquals(-1, empty.pageIndex(-1), "pageIndex(-1) called when there was an empty collection");
        assertEquals(-1, empty.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(-1, empty.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
    }
}
