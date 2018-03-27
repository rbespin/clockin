import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class GuiTimer extends Application{

   public static GridPane pane = new GridPane();
   public BorderPane mainPane; //main pane to add everything to
   public static Button btEnter = new Button("Add");;
   public static Button clockIn = new Button("Clock in");
   public static Button clockOut = new Button("Clock out");

   public static Button btClockIn1 = new Button();
   public static Button btClockOut1 = new Button();
   public static int pubRow1 = 2;


   public static Button btClockIn2 = new Button();
   public static Button btClockOut2 = new Button();
   public static int pubRow2 = 3;

   public static Button btClockIn3 = new Button();
   public static Button btClockOut3 = new Button();
   public static int pubRow3 = 4;

   public static Button btClockIn4 = new Button();
   public static Button btClockOut4 = new Button();
   public static int pubRow4 = 5;

   public static Button btClockIn5 = new Button();
   public static Button btClockOut5 = new Button();
   public static int pubRow5 = 6;

   public static Button btClockIn6 = new Button();
   public static Button btClockOut6 = new Button();
   public static int pubRow6 = 7;

   public static TextField addEl = new TextField();
   public static int finalRow;

   public static Button btClockInEnter = new Button("Clock in");
   public static Button btClockOutEnter = new Button("Clock out");
   public static Label enterL = new Label();

   public static Label addLa = new Label();

   public static Label lab = new Label();

   public static HashMap<String, Integer> map = new HashMap<>();


   @Override
      public void start(Stage primaryStage)
      {
         //SETTING SCENE
         mainPane = new BorderPane();
         Scene scene = new Scene(mainPane);
         primaryStage.setTitle("Clock in");
         primaryStage.setScene(scene);

         //HBOX TOP TITLE
         HBox titleBox = new HBox();
         Text titleText = new Text();
         titleText.setText("Punch-In");
         titleBox.getChildren().add(titleText);
         titleBox.setAlignment(Pos.CENTER);
         titleBox.setPadding(new Insets(15,15,15,15));

         //CENTER GRIDPANE  
         pane.setPrefSize(500,500);
         pane.setPadding(new Insets(15,15,15,15));

         //GRIDPANE ELEMENTS
         addLa = new Label("Click to add new Task");
         addEl = new TextField();
         btClockInEnter.setDisable(true);
         btClockOutEnter.setDisable(true);
         //ADDING GRIDPANE ELEMENTS

         pane.add(addLa,0,0);
         pane.add(addEl,0,1);
         pane.add(btEnter, 3,1);
         pane.add(btClockInEnter, 1,1);
         pane.add(btClockOutEnter, 2, 1);
         pane.setHgap(15);
         pane.setVgap(15);
         //EVENTS


         btClockIn3.setOnAction(e ->{
               btClockIn3.setDisable(true);
               btClockOut3.setDisable(false);
               });
         btClockOut3.setOnAction(e ->{
               btClockOut3.setDisable(true);
               btClockIn3.setDisable(false);
               });
         btClockIn4.setOnAction(e ->{
               btClockIn4.setDisable(true);
               btClockOut4.setDisable(false);
               });
         btClockOut4.setOnAction(e ->{
               btClockOut4.setDisable(true);
               btClockIn4.setDisable(false);
               });
         btClockIn5.setOnAction(e ->{
               btClockIn5.setDisable(true);
               btClockOut5.setDisable(false);
               });
         btClockOut5.setOnAction(e ->{
               btClockOut5.setDisable(true);
               btClockIn5.setDisable(false);
               });
         btClockIn6.setOnAction(e ->{
               btClockIn6.setDisable(true);
               btClockOut6.setDisable(false);
               });
         btClockOut6.setOnAction(e ->{
               btClockOut6.setDisable(true);
               btClockIn6.setDisable(false);
               });
         finalRow++;
         //ADDING ELEMENTS TO MAINPANE
         mainPane.setCenter(pane);
         mainPane.setTop(titleBox);
         primaryStage.show();
      }

   public  static void initialize() throws IOException{
      File dataFile = new File("data");
      File[] list = dataFile.listFiles();
      int row = 1;
      int i = 0;
      for (File fil : list){
         Scanner scanner = new Scanner(fil);
         int outCount = 0;
         int inCount = 0;
         i++;
         if(scanner.hasNext()){
            scanner.nextLine();
         }
         while(scanner.hasNext()){
            if(scanner.hasNext()){
               scanner.nextLine();
               inCount++;
            }
            if(scanner.hasNext()){
               scanner.nextLine();
               outCount++;
            }
         }
         scanner.close();
         if(inCount > outCount){
            System.out.println("punching out");
            //GRIDPANE ELEMENTS
            Label addLa2 = new Label(fil.getName());
            if(i==1){
               //FILE SAVING

               //GUI
               btClockOut1 = new Button("Clock out");
               Button btPtr = btClockOut1;
               btClockIn1 = new Button("Clock in");
               btClockIn1.setDisable(true);
               pane.add(btClockIn1, 1, pubRow1);
               pane.add(addLa2,0,pubRow1);
               pane.add(btPtr, 2, pubRow1);
               btClockOut1.setOnAction(e -> {
                     try{
                     btClockOut1.setDisable(true);
                     btClockIn1.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     Scanner myScanner = new Scanner(fil);
                     myScanner.nextLine();
                     int counter = 0;
                     while(myScanner.hasNext()){
                     String display = myScanner.next();
                     counter++;
                     }
                     int k = counter - 5;
                     int u = 0;
                     myScanner.close();
                     Scanner myScanner2 = new Scanner(fil);
                     if(myScanner2.hasNext()){
                        myScanner2.nextLine();
                     }
                     while(u<k){
                        u++;
                        myScanner2.next();
                     }
                     int timeIn = myScanner2.nextInt();
                     System.out.println("Last Clock-In: " + timeIn);

                     myScanner2.close();
                     Scanner myScanner3 = new Scanner(fil);
                     if(myScanner3.hasNext()){
                        myScanner3.nextLine();
                     }
                     u = 0;
                     k = counter;
                     while(u<counter-1){
                        u++;
                        myScanner3.next();
                     }

                     int timeOut = myScanner3.nextInt();
                     System.out.println("CLOCKING OUT AT: " + timeOut);

                     myScanner3.close();
                     File newFile2 = new File("data/totaldata/total" + fil.getName().toLowerCase());
                     Scanner totalScanner = new Scanner(newFile2);
                     PrintWriter pw2 = new PrintWriter(new FileOutputStream(newFile2, true));
                     int totalCount = 0;
                     while(totalScanner.hasNext()){
                        if(totalScanner.next().toLowerCase().equals(fil.getName().toLowerCase())){

                           int totalTime = totalScanner.nextInt();
                           totalTime = totalTime + (timeOut - timeIn);
                           totalCount++;

                        }
                     }
                     if(totalCount == 0){
                        pw2.println(fil.getName().toLowerCase() + " " + (timeOut - timeIn));
                        pw2.close();
                     }
                     }
                     catch(IOException ex){
                     }
               }); 
               btClockIn1.setOnAction(e ->{
                     try{
                     btClockIn1.setDisable(true);
                     btClockOut1.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     }
                     catch(IOException ex){}
                     });

            }
            else if(i==2){
               btClockOut2 = new Button("Clock out");
               Button btPtr = btClockOut2;
               btClockIn2 = new Button("Clock in");
               btClockIn2.setDisable(true);
               pane.add(btClockIn2, 1, pubRow2);
               pane.add(addLa2,0,pubRow2);
               pane.add(btPtr, 2, pubRow2);
               btClockIn2.setOnAction(e ->{
                     try{
                     btClockIn2.setDisable(true);
                     btClockOut2.setDisable(false);
                     System.out.println(fil.getName());

                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     }
                     catch(IOException ex){}
                     });
               btClockOut2.setOnAction(e ->{
                     try{
                     btClockOut2.setDisable(true);
                     btClockIn2.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText()); 
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     Scanner myScanner = new Scanner(fil);
                     myScanner.nextLine();
                     int counter = 0;
                     while(myScanner.hasNext()){
                     String display = myScanner.next();
                     counter++;
                     }
                     int k = counter - 5;
                     int u = 0;
                     myScanner.close();
                     Scanner myScanner2 = new Scanner(fil);
                     if(myScanner2.hasNext()){
                        myScanner2.nextLine();
                     }
                     while(u<k){
                        u++;
                        myScanner2.next();
                     }
                     int timeIn = myScanner2.nextInt();
                     System.out.println("Last Clock-In: " + timeIn);

                     myScanner2.close();
                     Scanner myScanner3 = new Scanner(fil);
                     if(myScanner3.hasNext()){
                        myScanner3.nextLine();
                     }
                     u = 0;
                     k = counter;
                     while(u<counter-1){
                        u++;
                        myScanner3.next();
                     }
                     int timeOut = myScanner3.nextInt();
                     System.out.println("CLOCKING OUT AT: " + timeOut);

                     myScanner3.close();
                     File newFile2 = new File("data/totaldata/total" + fil.getName().toLowerCase());
                     Scanner totalScanner = new Scanner(newFile2);
                     PrintWriter pw2 = new PrintWriter(newFile2);
                     int totalCount = 0;
                     while(totalScanner.hasNext()){
                        if(totalScanner.next().toLowerCase().equals(fil.getName().toLowerCase())){
                           totalScanner.next();
                           int totalTime = totalScanner.nextInt();
                           totalTime = totalTime + (timeOut - timeIn);
                           totalCount++;

                        }
                     }
                     if(totalCount == 0){
                        pw2.println(fil.getName().toLowerCase() + " " + (timeOut - timeIn));
                        pw2.close();
                     }
                     }
                     catch(IOException ex){
                     }

               });     
            }
            else if(i==3){
               btClockOut3 = new Button("Clock out");
               Button btPtr = btClockOut3;
               btClockIn3 = new Button("Clock in");
               btClockIn3.setDisable(true);
               pane.add(btClockIn3, 1, pubRow3);
               pane.add(addLa2,0,pubRow3);
               pane.add(btPtr, 2, pubRow3);
            }
            else if(i==4){
               btClockOut4 = new Button("Clock out");
               Button btPtr = btClockOut4;
               btClockIn4 = new Button("Clock in");
               btClockIn4.setDisable(true);
               pane.add(btClockIn4, 1, pubRow4);
               pane.add(addLa2,0,pubRow4);
               pane.add(btPtr, 2, pubRow4);
            }
            else if(i==5){
               btClockOut5 = new Button("Clock out");
               Button btPtr = btClockOut5;
               btClockIn5 = new Button("Clock in");
               btClockIn5.setDisable(true);
               pane.add(btClockIn5, 1, pubRow5);
               pane.add(addLa2,0,pubRow5);
               pane.add(btPtr, 2, pubRow5);
            }
            else if(i==6){
               btClockOut6 = new Button("Clock out");
               Button btPtr = btClockOut6;
               btClockIn6 = new Button("Clock in");
               btClockIn6.setDisable(true);
               pane.add(btClockIn6, 1, pubRow6);
               pane.add(addLa2,0,pubRow6);
               pane.add(btPtr, 2, pubRow6);
            }

         }
         if(outCount >= inCount){
            System.out.println("punching in...");
            //GRIDPANE ELEMENTS
            Label addLa2 = new Label(fil.getName());
            if(i==1){

               btClockIn1 = new Button("Clock in");
               btClockOut1 = new Button("Clock out");
               btClockOut1.setDisable(true);
               Button btPtr = btClockIn1;
               pane.add(btClockOut1, 2, pubRow1);
               pane.add(addLa2,0,pubRow1);
               pane.add(btPtr, 1,pubRow1);
               btClockIn1.setOnAction(e ->{
                     try{
                     btClockIn1.setDisable(true);
                     btClockOut1.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     }
                     catch(IOException ex){};
                     }); 


               btClockOut1.setOnAction(e ->{
                     try{
                     btClockOut1.setDisable(true);
                     btClockIn1.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();

                     Scanner myScanner = new Scanner(fil);
                     myScanner.nextLine();
                     int counter = 0;
                     while(myScanner.hasNext()){
                     String display = myScanner.next();
                     counter++;
                     }
                     int k = counter - 5;
                     int u = 0;
                     myScanner.close();
                     Scanner myScanner2 = new Scanner(fil);
                     if(myScanner2.hasNext()){
                        myScanner2.nextLine();
                     }
                     while(u<k){
                        u++;
                        myScanner2.next();
                     }
                     int timeIn = myScanner2.nextInt();
                     System.out.println("Last Clock-In: " + timeIn);

                     myScanner2.close();
                     Scanner myScanner3 = new Scanner(fil);
                     if(myScanner3.hasNext()){
                        myScanner3.nextLine();
                     }
                     u = 0;
                     k = counter;
                     while(u<counter-1){
                        u++;
                        myScanner3.next();
                     }
                     int timeOut = myScanner3.nextInt();
                     System.out.println("CLOCKING OUT AT: " + timeOut);

                     myScanner3.close();

                     File newFile2 = new File("data/totaldatal/total" + fil.getName().toLowerCase());

                     Scanner totalScanner = new Scanner(newFile2);
                     PrintWriter pw2 = new PrintWriter(new FileOutputStream(newFile2, true));
                     int totalCount = 0;
                     while(totalScanner.hasNext()){
                        if(totalScanner.next().toLowerCase().equals(fil.getName().toLowerCase())){
                           //  totalScanner.next();
                           int totalTime = totalScanner.nextInt();
                           totalTime = totalTime + (timeOut - timeIn);
                           totalCount++;

                        }
                     }
                     if(totalCount == 0){
                        pw2.println(fil.getName().toLowerCase() + " " + (timeOut - timeIn));
                        pw2.close();
                     }


                     } 
                     catch(IOException ex){}
               });
            }
            else if(i==2){
               btClockIn2 = new Button("Clock in");
               Button btPtr = btClockIn2;
               btClockOut2 = new Button("Clock out");
               btClockOut2.setDisable(true);
               pane.add(btClockOut2, 2, pubRow2);
               pane.add(addLa2,0,pubRow2);
               pane.add(btPtr, 1,pubRow2);
               btClockIn2.setOnAction(e ->{
                     try{
                     btClockIn2.setDisable(true);
                     btClockOut2.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     }
                     catch(IOException ex){}

                     });
               btClockOut2.setOnAction(e ->{

                     try{
                     btClockOut2.setDisable(true);
                     btClockIn2.setDisable(false);
                     System.out.println(fil.getName());
                     File newFile = new File("data/" + addLa2.getText());
                     PrintWriter pw = new PrintWriter(new FileOutputStream(newFile, true));
                     Time clockInTime = new Time();
                     pw.println(clockInTime.toString());
                     pw.close();
                     Scanner myScanner = new Scanner(fil);
                     myScanner.nextLine();
                     int counter = 0;
                     while(myScanner.hasNext()){
                     String display = myScanner.next();
                     counter++;
                     }
                     int k = counter - 5;
                     int u = 0;
                     myScanner.close();
                     Scanner myScanner2 = new Scanner(fil);
                     if(myScanner2.hasNext()){
                        myScanner2.nextLine();
                     }
                     while(u<k){
                        u++;
                        myScanner2.next();
                     }
                     int timeIn = myScanner2.nextInt();
                     System.out.println("Last Clock-In: " + timeIn);

                     myScanner2.close();
                     Scanner myScanner3 = new Scanner(fil);
                     if(myScanner3.hasNext()){
                        myScanner3.nextLine();
                     }
                     u = 0;
                     k = counter;
                     while(u<counter-1){
                        u++;
                        myScanner3.next();
                     }
                     int timeOut = myScanner3.nextInt();
                     System.out.println("CLOCKING OUT AT: " + timeOut);

                     myScanner3.close();
                     File newFile2 = new File("totaldata/total" + fil.getName().toLowerCase());
                     Scanner totalScanner = new Scanner(newFile2);
                     PrintWriter pw2 = new PrintWriter(new FileOutputStream(newFile2, true));
                     int totalCount = 0;
                     while(totalScanner.hasNext()){
                        if(totalScanner.next().toLowerCase().equals(fil.getName().toLowerCase())){
                           int totalTime = totalScanner.nextInt();
                           totalTime = totalTime + (timeOut - timeIn);
                           totalCount++;

                        }
                     }
                     if(totalCount == 0){
                        pw2.println(fil.getName().toLowerCase() + " " + (timeOut - timeIn));
                        pw2.close();
                     }
                     }
                     catch(IOException ex){
                     }


               });     

            }
            else if(i==3){
               btClockIn3 = new Button("Clock in");
               Button btPtr = btClockIn3;
               btClockOut3 = new Button("Clock out");
               btClockOut3.setDisable(true);
               pane.add(btClockOut3, 2, pubRow3);
               pane.add(addLa2,0,pubRow3);
               pane.add(btPtr, 1,pubRow3);
            }
            else if(i==4){
               btClockIn4 = new Button("Clock in");
               Button btPtr = btClockIn4;
               btClockOut4 = new Button("Clock out");
               btClockOut4.setDisable(true);
               pane.add(btClockOut4, 2, pubRow4);
               pane.add(addLa2,0,pubRow4);
               pane.add(btPtr, 1,pubRow4);
            }
            else if(i==5){
               btClockIn5 = new Button("Clock in");
               Button btPtr = btClockIn5;
               btClockOut5 = new Button("Clock out");
               btClockOut5.setDisable(true);
               pane.add(btClockOut5, 2, pubRow5);
               pane.add(addLa2,0,pubRow5);
               pane.add(btPtr, 1,pubRow5);
            }
            else if(i==6){
               btClockIn6 = new Button("Clock in");
               Button btPtr = btClockIn6;
               btClockOut6 = new Button("Clock out");
               btClockOut6.setDisable(true);
               pane.add(btClockOut6, 2, pubRow6);
               pane.add(addLa2,0,pubRow6);
               pane.add(btPtr, 1,pubRow6);
            }

         } 
         scanner.close();
         int finalRow = i+2;


         {
            btEnter.setOnAction(e ->{
                  for(File fil2: list){
                  String filComp = addEl.getText() + ".txt";
                  filComp = filComp.toLowerCase();
                  if(filComp.equals(fil2.getName()) || filComp.equals(".txt")){
                  pane.getChildren().remove(enterL);
                  enterL = new Label("Please enter a new task");
                  btClockInEnter.setDisable(true);
                  pane.getChildren().remove(addLa);
                  pane.add(enterL, 0,0);
                  return;
                  }
                  }
                  {
                  String filComp = addEl.getText() + ".txt";
                  filComp = filComp.toLowerCase();
                  btEnter.setDisable(true);
                  btClockInEnter.setDisable(false);
                  pane.getChildren().remove(addEl);
                  pane.getChildren().remove(addLa);
                  pane.getChildren().remove(enterL);
                  lab = new Label(filComp);
                  lab.setMinWidth(150);
                  lab.setMinHeight(25);
                  pane.add(lab, 0,1);
                  System.out.println(lab.getText());
                  }

            });
            btClockOutEnter.setOnAction(e ->{
                  btClockInEnter.setDisable(false);
                  btClockOutEnter.setDisable(true);
                  System.out.println(lab.getText());
                  }); 
            btClockInEnter.setOnAction(e ->{
                  btClockInEnter.setDisable(true);
                  btClockOutEnter.setDisable(false);
                  System.out.println(lab.getText());
                  }); 
         }


         //}

   }
}

public static void main(String[] args) throws IOException{
   initialize();
   launch(args);

}


}
