import java.util.*;
import java.io.*;
import java.text.*;
import java.time.*;

public class Time{
   public String date;
   public String time;
   public String name;

   public Time(){
      this.date = LocalDateTime.now().getMonthValue()
         + "/" + LocalDateTime.now().getDayOfMonth();
      this.time = LocalDateTime.now().getHour()*100 + LocalDateTime.now().getMinute() + "";
   }
   @Override
      public String toString(){
         return ("Date: " + this.date + " " + "Time: " + 
               this.time);
      }
   public static void main(String[] args){
      Time test = new Time();
      System.out.println(test.toString());
   }
}

