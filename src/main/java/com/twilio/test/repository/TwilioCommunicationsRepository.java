package com.twilio.test.repository;

import com.twilio.test.data.models.SMSModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TwilioCommunicationsRepository extends JpaRepository<SMSModel, Long> {
}
