package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    Pattern pattern;
    Matcher matcher;

    public Validate() {
    }

    public void validateChoice(String choice) {

    }

    public boolean validateDate(String date) {
        String DATE_REGEX = "^([0-9]|[0-2][0-9]|3[0-1])[/](0[0-9]|1[0-2]|[0-9])[/]([0-9][0-9])?[0-9][0-9]$";
        pattern = Pattern.compile(DATE_REGEX);
        matcher = pattern.matcher(date);
        return matcher.find();
    }


}
