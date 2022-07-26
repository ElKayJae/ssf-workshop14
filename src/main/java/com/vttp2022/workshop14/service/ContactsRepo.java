package com.vttp2022.workshop14.service;

import com.vttp2022.workshop14.model.Contact;

public interface ContactsRepo {
    public void save (final Contact ctc);

    public Contact findbyId(final String contactId);


}
