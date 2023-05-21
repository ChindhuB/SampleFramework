package models.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long
    id
    ;
    private String
         name,
         username,
         email,
         avatar,
         phone,
         status,
         organization_role,
         apiToken,
         intercom_user_hash,
         created_at,
         ml_dashboard_to_show,
         automation_analytics_ui,
         uuid,
         country_code,
         country_name,
         continent,
         domain_type,
         last_login_at,
         password_last_changed_at,
         common_header_version,
         real_devices
    ;
    private boolean
         email_verified,
         lt_browser_promo_shown,
         lt_browser_installed,
         native_app_screen_shown,
         show_realdevice_popup,
         onboarding_screen_shown,
         app_engine_onboarding_shown,
         chrome_extension_onboarding_shown,
         password_created,
         is_mfa_enabled
    ;
    private PromoDetails promodetails;
    private Organization organization;
    private IntendedRedirectDetails intredirectDet;



}
