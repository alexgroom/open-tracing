package org.acme.people.model;

import java.io.Serializable;
import java.util.List;
import org.acme.people.utils.Sleep;
import javax.enterprise.context.ApplicationScoped;
import io.opentelemetry.instrumentation.annotations.WithSpan;

@ApplicationScoped
public class DataTable implements Serializable {

    private static final long serialVersionUID = -7304814269819778382L;
    public long draw;
    public long recordsTotal;
    public long recordsFiltered;
    public List<Person> data;
    public String error;

    @WithSpan
    public DataTable() {

    }

    @WithSpan
    public void setDraw(int draw) {
        this.draw = draw;
    }
    @WithSpan
    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
    @WithSpan
    public void setRecordsFiltered(long recordsFiltered) {
        Sleep.pause(200);
        this.recordsFiltered = recordsFiltered;
    }
    @WithSpan
    public void setData(List<Person> data) {
        this.data = data;
    }
    @WithSpan
    public void setError(String error) {
        this.error = error;
    }

    @WithSpan
    public long getDraw() {
        return this.draw;
    }
    @WithSpan
    public long getRecordsTotal() {
        return this.recordsTotal;
    }
    @WithSpan
    public long getRecordsFiltered() {
        return this.recordsFiltered;
    }
    @WithSpan
    public List<Person> getData() {
        return this.data;
    }
    @WithSpan
    public String getError() {
        return this.error;
    }


}