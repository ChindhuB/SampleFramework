package constant.api.auth;

import constant.api.Endpoints;

public enum AuthEndpoints implements Endpoints {
    BASE_URI("https://auth.<>.com/api"),
    LOGIN("/login"),
   EMAIL_VERIFY_RESEND( "/user/password/email-verify"),
    USER("/user")


    ;

    private String url;

    AuthEndpoints(String url) {
        this.url = url;
    }

    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }
}

