package prog2.spring2024.exercise2;


public class BookStore 
{
    
    private String orderedBook; 
    private LocalDate orderDate; 
    private String orderID; 
    private double transactionAmount;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userID;
    private String orderType;   
    private BookDetails selectBook;
    int bookRent=5;
    
    public BookStore(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.orderDate = LocalDate.now();
        this.userID = generateUserID(firstName, lastName);
    }

    public enum BookDetails {
        Book1("001", "Carrie", "Stephen King", 272, "Horror", 3.98, 1974, "Wings", 14),
        Book2("002", "The Firm", "Robin Waterfield / John Grisham", 448, "Thriller", 4.01, 1991, "Addison Wesley Publishing Company", 25),
        Book3("003", "Slaughterhouse-Five", "Kurt Vonnegut Jr", 275, "Sci-Fi", 4.1, 1969, "Dial Press", 18),
        Book4("004", "The Great Gatsby", "F. Scott Fitzgerald", 188, "Classic", 3.91, 1925, "Scribner", 8),
        Book5("005", "American Gods", "Neil Gaiman", 635, "Fantasy", 4.11, 2001, "Harper Collins", 11);
        private String bookID;  
        private String bookName;    
        private String bookAuthor;  
        private int bookPages;   
        private String bookGenre;  
        private double bookRating; 
        private int bookPublishedYear;  
        private String bookPublisher;  
        public double bookPrice;  
 
        private BookDetails(String bookID, String bookName, String bookAuthor, int bookPages, String bookGenre
                , double bookRating, int bookPublishedYear, String bookPublisher, double bookPrice) {
            this.bookID = bookID;
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookPages = bookPages;
            this.bookGenre = bookGenre;
            this.bookRating = bookRating;
            this.bookPublishedYear = bookPublishedYear;
            this.bookPublisher = bookPublisher;
            this.bookPrice = bookPrice;
        }

        public String getBookID() {
            return bookID;
        }

        public String getBookName() {
            return bookName;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public int getBookPages() {
            return bookPages;
        }

        public String getBookGenre() {
            return bookGenre;
        }

        public double getBookRating() {
            return bookRating;
        }

        public int getBookPublishedYear() {
            return bookPublishedYear;
        }

        public String getBookPublisher() {
            return bookPublisher;
        }

        public double getBookPrice() {
            return bookPrice;
        }

        public void setBookID(String bookID) {
            this.bookID = bookID;
        }

        public void displayBookDetails() {
            System.out.println("Book ID: " + bookID);
            System.out.println("Book Name: " + bookName);
            System.out.println("Author: " + bookAuthor);
            System.out.println("Pages: " + bookPages);
            System.out.println("Genre: " + bookGenre);
            System.out.println("Rating: " + bookRating);
            System.out.println("Published Year: " + bookPublishedYear);
            System.out.println("Publisher: " + bookPublisher);
            System.out.println("Price: $" + bookPrice);
            System.out.println(); // Empty line for better formatting
        }
    }

    public String generateOrderID() {

        String formattedDate = orderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    

        String bookTitlePrefix = orderedBook.length() >= 3 ?   
                orderedBook.substring(0, 3).toUpperCase() :
                orderedBook.toUpperCase();

   
        return "TANLOD" + formattedDate + bookTitlePrefix;
    }


    public String generateUserID(String firstName, String lastName) {
        String combinedName = firstName.toUpperCase() + lastName.toUpperCase();  
        if (combinedName.length() > 5) {  
            combinedName = combinedName.substring(0, 5);  
        }  
  
        return "TANLUS" + combinedName;  

    }
    
    public String getOrderedBook() {
        return orderedBook;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUserID() {
        return userID;
    }

    public String getOrderType() {
        return orderType;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmailAddress(String EmailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserID() {
        this.userID = generateUserID(firstName,lastName);
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public BookDetails getSelectBook() {
        return selectBook;
    }

    public void setSelectBook(BookDetails selectBook) {
        this.selectBook = selectBook;
    }

    public void setOrderedBook(String orderedBook) {
        this.orderedBook = orderedBook;
    }

    public BookDetails searchBook(String bookID) {
        
        if (BookDetails.Book1.getBookID().equals(bookID)) {
            selectBook = BookDetails.Book1;
        } else if (BookDetails.Book2.getBookID().equals(bookID)) {
            selectBook = BookDetails.Book2;
        } else if (BookDetails.Book3.getBookID().equals(bookID)) {
            selectBook = BookDetails.Book3;
        } else if (BookDetails.Book4.getBookID().equals(bookID)) {
            selectBook = BookDetails.Book4;
        } else if (BookDetails.Book5.getBookID().equals(bookID)) {
            selectBook = BookDetails.Book5;
        }
        this.transactionAmount = selectBook.getBookPrice();
        return selectBook;
    }

   
    public void orderBook(int type) {
        if (type == 1) {
            //如果是租书
            this.orderType = "Rent";
            this.transactionAmount = bookRent;
            System.out.println("You have chosen to rent the book \"" + orderedBook + "\" for one month at a cost of"+bookRent+ "EUR.");
        } else if (type == 2) {
        
            this.orderType = "Purchase";
            
            System.out.println("You have chosen to purchase the book \"" + orderedBook + "\" at a cost of " + transactionAmount + " EUR.");
        } else {
            System.out.println("invalid：");
            Scanner sc = new Scanner(System.in);
            int nextType = sc.nextInt();
            orderBook(nextType);
        }
    }

    public void orderConfirmation() {
        System.out.println("Dear, " + getFirstName()+" " + getLastName());
        System.out.println("Thank you for ordering "+getOrderedBook()+" from Turn-A-New-Leaf. Following are your order details");
        System.out.println("Order ID: " + getUserID());
        System.out.println("Order Date: " + getOrderDate());
        System.out.println("User ID: " + getOrderID());
        System.out.println("User contact: " + getEmailAddress());
        System.out.println("Transaction type: " + getOrderType());
        System.out.println("Transaction amount: €" + getTransactionAmount());
        
        
    }

    
}


