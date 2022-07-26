package com.vttp2022.workshop14.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vttp2022.workshop14.model.Contact;

@Service
public class ContactsRedis implements ContactsRepo{
    private static final Logger logger = LoggerFactory.getLogger(ContactsRedis.class);
    
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public void save(final Contact ctc) {
        redisTemplate.opsForValue().set(ctc.getId(), ctc);
        
    }

    @Override
    public Contact findbyId(String contactId) {
        Contact result = (Contact) redisTemplate.opsForValue().get(contactId);
        logger.info(">>> " + result.getEmail());
        return result;
    }

    
}
