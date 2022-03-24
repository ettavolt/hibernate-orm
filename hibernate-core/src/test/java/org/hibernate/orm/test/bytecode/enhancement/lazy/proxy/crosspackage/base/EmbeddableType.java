package org.hibernate.orm.test.bytecode.enhancement.lazy.proxy.crosspackage.base;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbeddableType {

    @Column
    private String field;

    public String getField() {
        return field;
    }

    public void setField(final String field) {
        this.field = field;
    }
}
