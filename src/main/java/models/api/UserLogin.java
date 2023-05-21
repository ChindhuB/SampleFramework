/*Can design as model  / dto (Data Transfer Objective) package */
package models.api;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLogin  {
    private String type;
    private String title;
    private String name;
    private String  phone;
    private String  message;
    private String   uuid;
    private String brand_host;
    private boolean is_mfa_enabled;
    private boolean  enforce_mfa;

}
