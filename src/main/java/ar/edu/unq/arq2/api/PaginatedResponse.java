package ar.edu.unq.arq2.api;

import ar.edu.unq.arq2.api.v1.resources.Paging;

import java.util.List;

public class PaginatedResponse<T> extends Envelop<T> {

    private Paging paging;

    public static <T> PaginatedResponse paginate(List<T> items, Paging paging) {
        return new PaginatedResponse(items, paging);
    }

    public PaginatedResponse() {}

    public PaginatedResponse(List<T> items, Paging paging) {
        this.setItems(items);
        this.setPaging(paging);
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
