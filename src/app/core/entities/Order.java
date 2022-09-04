package app.core.entities;

import java.util.Calendar;
import java.util.Objects;

public class Order implements Comparable {

    private Calendar readyOn;
    private String name;
    private String description;
    private boolean important;
    private boolean popped;

    public Order() {
    }

    public Calendar getReadyOn() {
        return readyOn;
    }

    public void setReadyOn(Calendar readyOn) {
        this.readyOn = readyOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean isPopped() {
        return popped;
    }

    public void setPopped(boolean popped) {
        this.popped = popped;
    }

    // TODO -- Choose parameters to compare to
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return isImportant() == order.isImportant() && isPopped() == order.isPopped() && getReadyOn().equals(order.getReadyOn()) && getName().equals(order.getName()) && getDescription().equals(order.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReadyOn(), getName(), getDescription(), isImportant(), isPopped());
    }

}

