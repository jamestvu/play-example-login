import models.UserInfo;
import play.Application;
import play.GlobalSettings;


/**
 * Provide initialization code for the digits application.
 * @author Philip Johnson
 */
public class Global extends GlobalSettings {

  /**
   * Initialize the system with some sample contacts.
   * @param app The application.
   */
  public void onStart(Application app) {
    UserInfo user = new UserInfo("john", "smith@example.com", "password");
    user.save();
    //UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
  }
}
