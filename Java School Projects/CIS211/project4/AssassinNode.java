/*    */ package project4;
/*    */ 
/*    */ public class AssassinNode
/*    */ {
/*    */   public String name;
/*    */   public String killer;
/*    */   public AssassinNode next;
/*    */ 
/*    */   public AssassinNode(String name)
/*    */   {
/* 13 */     this(name, null);
/*    */   }
/*    */ 
/*    */   public AssassinNode(String name, AssassinNode next) {
/* 17 */     this.name = name;
/* 18 */     this.killer = null;
/* 19 */     this.next = next;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     project4.AssassinNode
 * JD-Core Version:    0.6.0
 */