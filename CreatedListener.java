import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.PrePersist;

import eztravel.pbo.models.Record;

/**
 *
 * @author shawn
 */
public class CreatedListener {

  /**
   * On created.
   *
   * @param obj the obj
   */
  @PrePersist
  protected void onCreated(Object obj) {
    try {
      Field f = obj.getClass().getDeclaredField("record");
      Method recordMethod = f.getType().getDeclaredMethod("setCreatedTime", Date.class);
      Object record = f.getType().newInstance();
      recordMethod.invoke(record, new Date());
      Method method = obj.getClass().getDeclaredMethod("setRecord", Record.class);
      method.invoke(obj, record);
    } catch (Exception ex) {
      play.Logger.error(ex.getMessage());
    }
  }
}
