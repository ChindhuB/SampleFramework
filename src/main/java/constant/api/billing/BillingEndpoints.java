package constant.api.billing;

import constant.api.Endpoints;

public enum BillingEndpoints implements Endpoints {
    BASE_URI("https://billing-api.<>.com/api/v1");

    private String url;

    BillingEndpoints(String url) {
        this.url = url;
    }

    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }
}
