import java.util.*;
import java.io.*;
import java.text.*;
import java.time.*;

public class Test{
   public static void main(String[] args){

      System.out.println("Date: " + LocalDateTime.now().getMonthValue()  +
            "/" + LocalDateTime.now().getDayOfMonth() + " " + "Time: " + 
            LocalDateTime.now().getHour() 
            + "" + LocalDateTime.now().getMinute());
   }
}
