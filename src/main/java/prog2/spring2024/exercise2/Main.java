package prog2.spring2024.exercise2;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import prog2.spring2024.exercise2.BookStore.BookDetails;
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("firstname？");
        String fname = scanner.nextLine();

        System.out.println("lastname？");
        String lname = scanner.nextLine();

        System.out.println("address？");
        String adrs = scanner.nextLine();

     
        BookStore bookstore = new BookStore(fname,lname,adrs);

    
        for (BookDetails book : BookDetails.values()) {
            book.displayBookDetails();
        }
    
        System.out.println("Which book do you want?");
        String bkid = scanner.nextLine();
      
        bookstore.setSelectBook(bookstore.searchBook(bkid));
     
        bookstore.setOrderedBook(bookstore.getSelectBook().getBookName());

        System.out.println("Lend:input 1 ; Buy:input 2");
        int type = scanner.nextInt();
        bookstore.orderBook(type);

        
        bookstore.setOrderID(bookstore.generateOrderID());

        bookstore.orderConfirmation();

    }
}


