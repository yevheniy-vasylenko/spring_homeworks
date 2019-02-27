package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;

public class RatedBook extends Book {

    private int stars;

    public RatedBook(Long id, String author, String title, int stars) {
        super(id, author, title);
        this.stars = stars;
    }

    public RatedBook(Book book, int stars) {
        super(book.getId(), book.getAuthor(), book.getTitle());
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
