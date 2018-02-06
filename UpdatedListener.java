import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.PreUpdate;

import eztravel.pbo.models.Record;


/**
 * The listener interface for receiving updated events. The class that is interested in processing a
 * updated event implements this interface, and the object created with that class is registered
 * with a component using the component's <code>addUpdatedListener<code> method. When the updated
 * event occurs, that object's appropriate method is invoked.
 *
 * @see UpdatedEvent
 */
public class UpdatedListener {

  /**
   * On update.
   *
   * @param obj the obj
   */
  @PreUpdate
  public void onUpdate(Object obj) {
    try {
      Field recordField = obj.getClass().getDeclaredField("record");
      Method recordMethod = recordField.getType().getDeclaredMethod("setUpdatedTime", Date.class);
      Method method = obj.getClass().getDeclaredMethod("setRecord", Record.class);
      recordField.setAccessible(true);
      if (recordField.get(obj) == null) {
        Object record = recordField.getType().newInstance();
        recordMethod.invoke(record, new Date());
        method.invoke(obj, record);
      } else {
        recordMethod.invoke(recordField.get(obj), new Date());
        method.invoke(obj, recordField.get(obj));
      }
    } catch (Exception ex) {
      play.Logger.error(ex.getMessage());
    }
  }

}
