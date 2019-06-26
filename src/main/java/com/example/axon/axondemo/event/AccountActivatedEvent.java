package com.example.axon.axondemo.event;


import com.example.axon.axondemo.aggregate.Status;

public class AccountActivatedEvent extends BaseEvent<String> {
    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
