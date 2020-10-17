package Day_209052020;

public class for_loop {

    public static void main(String[] args) {
    //dynamic array example with string data
        String[] zipcode = new String[6]; //defining and setting boundary for array values
        zipcode[0] = "11218";
        zipcode[1] = "11219";
        zipcode[2] = "10001";
        zipcode[3] = "11201";
        zipcode[4] = "11217";
        zipcode[5] = "11216";

                //iterate through all of zipcode data and print each one
        for(int i = 0;i < 6; i++) { // ++ is same as +1
            //code goes here
            System.out.println("My zipcode is " + zipcode[i]);


            //i = i+1; //this is to skip specific index(s) from array
        }// end of for loop

    }//end of main method

// what does the i mean? and how can there be int value if your not using any numbers?






}//end of main class
