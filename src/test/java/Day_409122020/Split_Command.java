package Day_409122020;

public class Split_Command {

    public static void main(String[] args) {
// declare and define a string variable
 String message = "My name is John";

 //print out only the word John string message
        //by using split command
        String[] result = message.split(" ");
        //now print out the index for John
        System.out.println("my result is " + result[0] + " and " + result[3]);

    }//end of main method



}//end of java class
