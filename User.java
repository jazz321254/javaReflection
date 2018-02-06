import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import play.data.validation.Constraints;

/**
 *
 * @author shawn
 */
@Entity
@EntityListeners({CreatedListener.class, UpdatedListener.class})
@Table(name = "user")
public class User {

  @Id
  @Column(nullable = false, length = 32)
  @Constraints.Required
  private String name;
  
  @Column(name = "user_name", length = 64)
  private String userName;
  
  @Embedded
  private Record record;

  public User() {}

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public Record getRecord() {
    return record;
  }

  public void setRecord(Record record) {
    this.record = record;
  }
}
