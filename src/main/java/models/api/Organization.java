package models.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {
    private long
            id,
            org_size,
            user_counts,
            realtime_tests_lifetime,
            realtime_tests_this_month,
            automation_tests_lifetime,
            automation_tests_this_month,
            automation_test_timeouts,
            automation_test_lambda_errors,
            screenshot_tests_lifetime,
            screenshot_tests_this_month,
            responsive_tests_lifetime,
            responsive_tests_this_month
    ;

    private String
            name,
            bill_to,
            avatar,
            org_status,
            priorityBucket,
            registered_under_program,
            country,
            subscription_type,
            plan,
            current_subscription_started_at,
            subscription_plan_changed_at,
            current_subscription_ends_at,
            org_created_at,
            ondemand_pass_availed,
            is_overprovisioning_allowed,
            is_root_org,
            is_sub_org,
            new_lums_ui_enabled,
            enforce_mfa,
            show_header_toggle
                    ;


    private boolean
            is_group_enabled,
            is_reseller_customer,
            helpdesk_login_allowed,
            is_or_been_paid_customer,
            is_sso_enabled,
            is_compliance,
            is_automation_fetch_all_cmd_logs,
            wallet_credit,
            region,
            real_device_allocation,
            current_subscription_type,
            current_subscription_status,
            current_plan_name,
            current_interval,
            stripe_subscription_id,
            next_invoice_amount,
            last_invoice_status,
            last_invoice_coupon_code,
            previous_subscription_type,
            previous_plan_name,
            previous_interval,
            churn_reason,
            churn_feedback,
            ondemand_pass_status,
            current_licenses_subscribed
    ;
    private PlanAttributes planattributes;

}
