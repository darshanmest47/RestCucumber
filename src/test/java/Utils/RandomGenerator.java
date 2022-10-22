package Utils;

import java.util.Random;

public class RandomGenerator {

    Random random = new Random();
    public String randomString(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class

        // specify length of random string
        int length = 5;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }


    public int randomInteger(){
       return random.nextInt(200);
    }


    public int getShippingData(){
        return randomInteger();
    }

    public String getUPCData(){
        return randomString();
    }

    public String getDescription(){
        return "Description"+randomString();
    }

    public String getManufacturer(){
        return "Manufacturer"+randomString();
    }

    public String getModel(){
        return "Model"+randomString();
    }

    public String getURL(){
        return "https://www."+randomString()+".com";
    }

    public String getImage(){
      return "https://"+randomString()+".jpg";
    }



}
