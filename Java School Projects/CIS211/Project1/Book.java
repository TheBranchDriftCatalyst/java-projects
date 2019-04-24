/*    */ package Project1;
/*    */ 
/*    */ public class Book extends LibraryItem
/*    */ {
/*    */   private String firstName;
/*    */   private String lastName;
/*    */   private int pages;
/*    */ 
/*    */   public Book(String title, int year, String firstName, String lastName, int pages)
/*    */   {
/* 17 */     super(title, year);
/* 18 */     this.firstName = firstName;
/* 19 */     this.lastName = lastName;
/* 20 */     this.pages = pages;
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 25 */     return "Book";
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 29 */     return super.toString() + " -- Author: " + this.lastName + ", " + this.firstName + ". " + this.pages + " pages.";
/*    */   }
/*    */ 
/*    */   public String getAuthorFirst() {
/* 33 */     return this.firstName;
/*    */   }
/* 35 */   public String getAuthorLast() { return this.lastName; } 
/*    */   public int getNumPages() {
/* 37 */     return this.pages;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     Project1.Book
 * JD-Core Version:    0.6.0
 */