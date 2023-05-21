package models.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoDetails {
    private String celebration_message,
            code,
            discount_price_message,
            duration_message,
            ends_at,
           redirect_url,
            starts_at;
}
