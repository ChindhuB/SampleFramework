package models.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResendEmailVerify {
    private String id,
            email,
            otp_verification_token;
}
