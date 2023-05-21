package constant.api.forms;

import constant.api.Endpoints;

public enum FormEndpoints implements Endpoints {
    BASE_URI("https://forms.<>.com/api");
    private String url;

    FormEndpoints(String url) {
        this.url = url;
    }

    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }
}
