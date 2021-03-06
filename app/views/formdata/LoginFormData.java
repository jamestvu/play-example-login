package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfo;
import play.data.validation.ValidationError;

/**
 * Backing class for the login form.
 */
public class LoginFormData {

  /** The submitted email. */
  public String email = "";
  /** The submitted password. */
  public String password = "";

  /** Required for form instantiation. */
  public LoginFormData() {
  }

  /**
   * Validates Form<LoginFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    boolean valid = UserInfo.find().where().eq("email", email).eq("password", password).findRowCount() == 1;
    if (!valid) {
      errors.add(new ValidationError("email", ""));
      errors.add(new ValidationError("password", ""));
    }
    
    return (errors.size() > 0) ? errors : null;
  }

}
