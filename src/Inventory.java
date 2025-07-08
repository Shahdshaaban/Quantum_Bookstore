import java.util.*;
public class Inventory {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook (Book book){
        books.add(book);
        System.out.println("Quantum book store: Book added - " + book.getTitle());
    }

    public List<Book> removeOutdatedBooks(int maxYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();

        books.removeIf(book -> {
            boolean outdated = currentYear - book.getPublishYear() > maxYears;
            if (outdated) {
                removed.add(book);
                System.out.println("Quantum book store: this is outdated book - (" + book.getTitle() + ") removed it");
                System.out.println("------------------------------------------");

            }
                return outdated;
        });

        return removed;
    }

    // shippable books
    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isPurchasable()) {
                    throw new Exception("This book is not for sale - Book: " + book.getTitle());
                }
                double totalPrice = book.buy(quantity, email, address);
                System.out.println("Quantum book store: Purchase successful for \"" + book.getTitle() + "\". Paid: " + totalPrice);
                System.out.println("------------------------------------------");
                return totalPrice;
            }
        }
         throw new Exception("Book with ISBN " + isbn + " not found.");

    }

    // non-shippable books
    public double buyBook(String isbn, int quantity, String email) throws Exception {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isPurchasable()) {
                    throw new Exception("Quantum book store: This Demo book (" + book.getTitle() +  ") is not for sale");

                }
                double totalPrice = book.buy(quantity, email, null);
                System.out.println("Quantum book store: Purchase successful for \"" + book.getTitle() + "\". Paid: " + totalPrice);
                System.out.println("------------------------------------------");
                return totalPrice;

            }
        }
        throw new Exception("Quantum book store: Book with ISBN " + isbn + " not found.");

    }


}
