/*Can design as model  / dto (Data Transfer Objective) package */
package models.api;
import lombok.Builder;
import lombok.Data;

@Builder(setterPrefix = "set")
@Data
public class Login {
    private String email;
    private String password;


}
