package com.api.dealership.pages;

import java.util.List;
import java.util.Objects;

public class PaginationData<T> {

    private List<T> contentPage;
    private Integer totalElements;

    public PaginationData(List<T> contentPage, Integer totalElements) {
        this.contentPage = contentPage;
        this.totalElements = totalElements;
    }

    public List<T> getContentPage() {
        return contentPage;
    }

    public void setContentPage(List<T> contentPage) {
        this.contentPage = contentPage;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaginationData<?> that = (PaginationData<?>) o;
        return Objects.equals(contentPage, that.contentPage) && Objects.equals(totalElements, that.totalElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentPage, totalElements);
    }
}
