import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author shawn
 */
@Embeddable
public class Record {

  /** The created time. */
  @Column(name = "created_time", insertable = true, updatable = false)
  private Date createdTime;

  /** The updated time. */
  @Column(name = "updated_time", insertable = false, updatable = true)
  private Date updatedTime;
  
  /** The ip. */
  @Column(name = "ip")
  private String ip;

  /**
   * Gets the ip.
   *
   * @return the ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * Sets the ip.
   *
   * @param ip the new ip
   */
  public void setIp(String ip) {
    this.ip = ip;
  }

  /**
   * Gets the created time.
   *
   * @return the created time
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * Sets the created time.
   *
   * @param createdTime the new created time
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * Gets the updated time.
   *
   * @return the updated time
   */
  public Date getUpdatedTime() {
    return updatedTime;
  }

  /**
   * Sets the updated time.
   *
   * @param updatedTime the new updated time
   */
  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
