/*Can design as model  / dto (Data Transfer Objective) package */
package models.api;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Login {
    private String email;
    private String password;


}
