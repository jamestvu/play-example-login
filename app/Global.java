import models.UserInfo;
import play.Application;
import play.GlobalSettings;
import play.db.ebean.Model;
import play.db.ebean.EbeanPlugin;
import play.db.ebean.TransactionalAction;

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
    String email = "smith@example.com";
    String password = "password";
    //Deletes any references before creating it again
    boolean itemExists = (UserInfo.find().where().eq("email", email).findRowCount() == 1) ? true : false;
    if (itemExists) {
      UserInfo.find().ref(email).delete();
    }

    new UserInfo("john", email, password).save();
    //UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
  }
}
