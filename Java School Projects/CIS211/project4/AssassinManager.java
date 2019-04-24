/*     */ package project4;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class AssassinManager
/*     */ {
/*     */   private AssassinNode headKillRing;
/*     */   private AssassinNode headGraveyard;
/*     */ 
/*     */   public AssassinManager(String[] names)
/*     */     throws IllegalArgumentException
/*     */   {
/*  25 */     if (names.length <= 0) {
/*  26 */       throw new IllegalArgumentException("Error :: List File Invalid or Had no Names");
/*     */     }
/*  28 */     for (int i = 0; i < names.length; i++)
/*     */     {
/*  30 */       appendToKillRing(names[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void appendToKillRing(String n)
/*     */   {
/*  41 */     AssassinNode node = new AssassinNode(n);
/*  42 */     if (this.headKillRing == null)
/*     */     {
/*  44 */       this.headKillRing = node;
/*     */     }
/*     */     else {
/*  47 */       AssassinNode current = this.headKillRing;
/*  48 */       while (current.next != null) {
/*  49 */         current = current.next;
/*     */       }
/*  51 */       current.next = node;
/*     */     }
/*     */   }
/*     */ 
/*     */   void printKillRing()
/*     */   {
/*  62 */     String result = "";
/*  63 */     AssassinNode current = this.headKillRing;
/*  64 */     AssassinNode curNext = this.headKillRing.next;
/*  65 */     int i = 1;
/*     */ 
/*  67 */     while (curNext != null) {
/*  68 */       result = result + "\t" + i + " :: " + current.name + " is stalking " + curNext.name + "\n";
/*  69 */       current = current.next;
/*  70 */       curNext = curNext.next;
/*  71 */       i++;
/*     */     }
/*     */ 
/*  75 */     if (this.headKillRing.name.equalsIgnoreCase(current.name))
/*  76 */       result = result + "\t" + i + " :: " + current.name + " is stalking themselves \n";
/*     */     else {
/*  78 */       result = result + "\t" + i + " :: " + current.name + " is stalking " + this.headKillRing.name + "\n";
/*     */     }
/*  80 */     System.out.println(result);
/*     */   }
/*     */ 
/*     */   void printGraveyard()
/*     */   {
/*  92 */     String result = "";
/*     */ 
/*  94 */     if (this.headGraveyard == null) {
/*  95 */       System.out.println("\t Graveyard is Empty!");
/*     */     }
/*     */ 
/*  98 */     AssassinNode curNext = this.headGraveyard;
/*  99 */     int i = 1;
/* 100 */     while (curNext != null) {
/* 101 */       result = "\t" + i + " :: " + curNext.name + " was killed by " + curNext.killer + "\n" + result;
/* 102 */       curNext = curNext.next;
/* 103 */       i++;
/*     */     }
/* 105 */     System.out.println(result);
/*     */   }
/*     */ 
/*     */   public void kill(String name)
/*     */     throws IllegalStateException, IllegalArgumentException
/*     */   {
/* 121 */     if (gameOver())
/* 122 */       throw new IllegalStateException("Game is Over! There is no one to Kill!");
/* 123 */     if (!killRingContains(name)) {
/* 124 */       throw new IllegalArgumentException("Name is not in the kill ring!");
/*     */     }
/*     */ 
/* 128 */     AssassinNode targetNode = this.headKillRing;
/* 129 */     AssassinNode killerNode = this.headKillRing;
/* 130 */     int i = -1;
/*     */ 
/* 133 */     if (this.headKillRing.name.equalsIgnoreCase(name)) {
/* 134 */       while (killerNode.next != null) {
/* 135 */         killerNode = killerNode.next;
/*     */       }
/*     */ 
/* 138 */       targetNode.killer = killerNode.name;
/* 139 */       this.headKillRing = targetNode.next;
/* 140 */       AssassinNode temp = targetNode;
/* 141 */       appendToGraveyard(temp);
/*     */     }
/*     */     else
/*     */     {
/*     */       do {
/* 146 */         if (i >= 0) {
/* 147 */           killerNode = killerNode.next;
/*     */         }
/* 149 */         i++;
/* 150 */         targetNode = targetNode.next;
/*     */       }
/* 144 */       while (!targetNode.name.equalsIgnoreCase(name));
/*     */ 
/* 153 */       targetNode.killer = killerNode.name;
/* 154 */       killerNode.next = targetNode.next;
/* 155 */       AssassinNode temp = targetNode;
/* 156 */       appendToGraveyard(temp);
/*     */     }
/*     */ 
/* 159 */     System.out.println(targetNode.killer + " Killed " + targetNode.name);
/*     */   }
/*     */ 
/*     */   private void appendToGraveyard(AssassinNode node)
/*     */   {
/* 164 */     node.next = null;
/*     */ 
/* 166 */     if (this.headGraveyard == null)
/*     */     {
/* 168 */       this.headGraveyard = node;
/*     */     }
/*     */     else {
/* 171 */       AssassinNode current = this.headGraveyard;
/* 172 */       while (current.next != null) {
/* 173 */         current = current.next;
/*     */       }
/* 175 */       current.next = node;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean killRingContains(String name)
/*     */   {
/* 186 */     AssassinNode current = this.headKillRing;
/* 187 */     while (current != null) {
/* 188 */       if (current.name.equalsIgnoreCase(name)) {
/* 189 */         return true;
/*     */       }
/* 191 */       current = current.next;
/*     */     }
/*     */ 
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean graveyardContains(String name)
/*     */   {
/* 205 */     AssassinNode current = this.headGraveyard;
/* 206 */     while (current != null) {
/* 207 */       if (current.name.equalsIgnoreCase(name)) {
/* 208 */         return true;
/*     */       }
/* 210 */       current = current.next;
/*     */     }
/*     */ 
/* 214 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean gameOver()
/*     */   {
/* 224 */     return this.headKillRing.next == null;
/*     */   }
/*     */ 
/*     */   public String winner()
/*     */   {
/* 236 */     if (gameOver()) {
/* 237 */       return this.headKillRing.name;
/*     */     }
/* 239 */     return null;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 249 */     return "Manager toString does not exist! Use printGraveyard of printKillRing";
/*     */   }
/*     */ }

/* Location:           C:\Users\Jaxyral\Documents\workspace Eclipse\CIS 212\src\
 * Qualified Name:     project4.AssassinManager
 * JD-Core Version:    0.6.0
 */