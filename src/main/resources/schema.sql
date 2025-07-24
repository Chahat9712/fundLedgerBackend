-- Base User Table
CREATE TABLE "user" (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255),
    user_role VARCHAR(50)
);

-- Admin Table (inherits from User)
CREATE TABLE admin (
    user_id BIGINT PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES "user"(user_id)
);

-- Participant Table (inherits from User)
CREATE TABLE participant (
    user_id BIGINT PRIMARY KEY,
    balance DOUBLE,
    loaned_amount DOUBLE,
    FOREIGN KEY (user_id) REFERENCES "user"(user_id)
);

-- Fund Table
CREATE TABLE fund (
    fund_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fund_name VARCHAR(255),
    fund_type VARCHAR(100),
    fund_value DOUBLE,
    loan_value DOUBLE,
    admin_id BIGINT NOT NULL,
    FOREIGN KEY (admin_id) REFERENCES admin(user_id)
);

-- Many-to-Many Join Table for Fund and Participant
CREATE TABLE fund_participants (
    fund_id BIGINT NOT NULL,
    participant_id BIGINT NOT NULL,
    PRIMARY KEY (fund_id, participant_id),
    FOREIGN KEY (fund_id) REFERENCES fund(fund_id),
    FOREIGN KEY (participant_id) REFERENCES participant(user_id)
);

-- Transaction Table (linked to Fund and Participant)
CREATE TABLE transaction (
    transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    transaction_amount DOUBLE,
    transaction_date TIMESTAMP,
    participant_id BIGINT NOT NULL,
    fund_id BIGINT NOT NULL,
    FOREIGN KEY (participant_id) REFERENCES participant(user_id),
    FOREIGN KEY (fund_id) REFERENCES fund(fund_id)
);