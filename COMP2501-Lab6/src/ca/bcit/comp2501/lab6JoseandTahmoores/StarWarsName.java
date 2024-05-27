package ca.bcit.comp2501.lab6JoseandTahmoores;

import java.util.Scanner;

public class StarWarsName
{
    private final String inputString;
    //Static members
    private static int FIRST_NAME_INDEX=0;
    private static int LAST_NAME_INDEX=1;
    private static int MAIDEN_NAME_INDEX=2;
    private static int CITY_INDEX=3;

    public StarWarsName(final String input)
    {
        this.inputString=input;
    }

    public String generateStarWarsName()
    {
        String starWarsFirstName=null;
        String starWarsLastName=null;
        if(this.inputString!=null)
        {
            String[] stringArray=this.inputString.split("|");
            String firstName = stringArray[FIRST_NAME_INDEX];
            String lastName = stringArray[LAST_NAME_INDEX];
            String maidenName =stringArray[MAIDEN_NAME_INDEX];
            String city = stringArray[CITY_INDEX];
            starWarsFirstName = firstName.substring(0,3)+lastName.substring(0,2);
            starWarsLastName = maidenName.substring(0,2)+city.substring(0,3);

        }
        return  String.format("%s %s",starWarsFirstName,starWarsLastName);
    }

    public static void main (String[] args)
    {
        System.out.println("Enter your Star Wars data in the format\n");
        System.out.println("First Name|Last Name|Mother Maiden Name|City of birth");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        StarWarsName starWarsName= new StarWarsName(inputString);
        System.out.println(starWarsName.generateStarWarsName());


    }
}
