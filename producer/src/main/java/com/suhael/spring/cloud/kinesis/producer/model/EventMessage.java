package com.suhael.spring.cloud.kinesis.producer.model;

import java.util.Objects;

public class EventMessage {

    private String foo;

    public EventMessage() {
    }

    public EventMessage(String foo) {
        this.foo = foo;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventMessage that = (EventMessage) o;
        return Objects.equals(foo, that.foo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foo);
    }

    @Override
    public String toString() {
        return "EventMessage{" +
            "foo='" + foo + '\'' +
            '}';
    }
}
