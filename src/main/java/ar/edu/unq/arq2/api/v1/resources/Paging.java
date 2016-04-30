package ar.edu.unq.arq2.api.v1.resources;

public class Paging {
    private Integer offset;
    private Integer limit;
    private Long total;

    public Paging() {

    }

    public Paging(Integer offset, Integer limit, Long total) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
