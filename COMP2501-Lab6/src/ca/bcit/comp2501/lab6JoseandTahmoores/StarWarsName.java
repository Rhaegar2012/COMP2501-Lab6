package ca.bcit.comp2501.lab6JoseandTahmoores;
/**
 * The StarWarsName class generates a Star Wars name based on the user's input.
 * @author Tahmoores and Jose Tellez
 * @version 1.0
 */

public class StarWarsName
{
    private static final int MIN_INPUT_NUMBER=4;
    private static final int FIRST_NAME_FIRST_PART_LENGTH          = 3;
    private static final int LAST_NAME_FIRST_PART_LENGTH           = 2;
    private static final int MOTHERS_MAIDEN_NAME_FIRST_PART_LENGTH = 2;
    private static final int CITY_BORN_FIRST_PART_LENGTH           = 3;
    private static final int FIRST_NAME_INDEX=0;
    private static final int LAST_NAME_INDEX=1;
    private static final int MOTHER_MAIDEN_NAME_INDEX=2;
    private static final int CITY_INDEX=3;
    private static final int FIRST_INDEX=0;
    private static final int SECOND_INDEX=1;

    public static void main(final String[] args)
    {
        if (args.length == 0 || args[FIRST_INDEX].trim().isEmpty())
        {
            throw new IllegalArgumentException("Missing Data Input");
        }


        String[] inputParts = args[FIRST_INDEX].split("\\|");
        if (inputParts.length != MIN_INPUT_NUMBER)
        {
            System.err.println("ERROR: Incorrect Number Of Words Provided.");
            return;
        }

        String firstName         = inputParts[FIRST_NAME_INDEX];
        String lastName          = inputParts[LAST_NAME_INDEX];
        String mothersMaidenName = inputParts[MOTHER_MAIDEN_NAME_INDEX];
        String cityBorn          = inputParts[CITY_INDEX];

        String starWarsFirstName = generateStarWarsFirstName(firstName, lastName);
        String starWarsLastName  = generateStarWarsLastName(mothersMaidenName, cityBorn);

        System.out.format("Your Star Wars Name Is: %s %s%n", starWarsFirstName, starWarsLastName);
    }

    /**
     * Generates the first part of the Star Wars name.
     *
     * @param firstName the user's first name.
     * @param lastName the user's last name.
     * @return the first part of the Star Wars name.
     */

    private static String generateStarWarsFirstName(final String firstName,
                                                    final String lastName)
    {
        String firstPart  = firstName.substring(FIRST_INDEX, Math.min(FIRST_NAME_FIRST_PART_LENGTH,
                                                firstName.length())).toLowerCase();
        String secondPart = lastName.substring(FIRST_INDEX, Math.min(LAST_NAME_FIRST_PART_LENGTH,
                                                lastName.length())).toLowerCase();
        return capitalize(firstPart + secondPart);
    }

    /**
     * Generates the second part of the Star Wars name.
     *
     * @param mothersMaidenName the user's mother's maiden name.
     * @param cityBorn the city where the user was born.
     * @return the second part of the Star Wars name.
     */

    private static String generateStarWarsLastName(final String mothersMaidenName,
                                                   final String cityBorn)
    {
        String firstPart  = mothersMaidenName.substring(FIRST_INDEX, Math.min(MOTHERS_MAIDEN_NAME_FIRST_PART_LENGTH,
                                                        mothersMaidenName.length())).toLowerCase();
        String secondPart = cityBorn.substring(FIRST_INDEX, Math.min(CITY_BORN_FIRST_PART_LENGTH,
                                                cityBorn.length())).toLowerCase();
        return capitalize(firstPart + secondPart);
    }

    /**
     * Capitalizes the first letter of the given string and makes all other letters lower case.
     *
     * @param str the string to be capitalized.
     * @return the capitalized string.
     */

    private static String capitalize(final String str) {
        if (str == null || str.isEmpty())
        {
            return str;
        }
        return str.substring(FIRST_INDEX, SECOND_INDEX).toUpperCase() + str.substring(SECOND_INDEX);
    }

}
