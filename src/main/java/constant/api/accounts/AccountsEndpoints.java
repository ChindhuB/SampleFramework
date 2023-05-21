package constant.api.accounts;

import constant.api.Endpoints;

public enum AccountsEndpoints implements Endpoints {
    BASE_URI("");
private String url;
    AccountsEndpoints(String url) {
        this.url=url;
    }

    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }
}
