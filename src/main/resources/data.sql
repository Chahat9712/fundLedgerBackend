-- Insert 1 Admin
INSERT INTO user_table (user_id, user_name, user_role) VALUES (1, 'Admin A', 'ADMIN');
INSERT INTO admin (user_id) VALUES (1);

-- Insert 10 Participants
INSERT INTO user_table (user_id, user_name, user_role) VALUES (2, 'Alice', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (2, 10000, 2000);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (3, 'Bob', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (3, 9500, 1000);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (4, 'Charlie', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (4, 8000, 1500);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (5, 'Daisy', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (5, 7200, 1200);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (6, 'Ethan', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (6, 6700, 700);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (7, 'Fiona', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (7, 5600, 600);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (8, 'George', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (8, 8800, 0);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (9, 'Hannah', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (9, 9300, 500);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (10, 'Ian', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (10, 6100, 1100);

INSERT INTO user_table (user_id, user_name, user_role) VALUES (11, 'Jenny', 'PARTICIPANT');
INSERT INTO participant (user_id, balance, loaned_amount) VALUES (11, 7900, 950);

-- Insert 3 Funds (created by Admin ID 1)
INSERT INTO fund (fund_name, fund_type, fund_value, loan_value, admin_id)
VALUES
  ('Education Fund', 'Monthly', 50000, 10000, 1),
  ('Medical Fund', 'Emergency', 75000, 15000, 1),
  ('Community Fund', 'Yearly', 100000, 20000, 1),
  ('Education_Fund', 'Yearly', 8000, 20000, 1);

-- Map participants to funds (fund_participants)
INSERT INTO fund_participants (fund_id, participant_id) VALUES
  (1, 2), (1, 3), (1, 4), (1, 5),
  (2, 6), (2, 7), (2, 8), (2, 9),
  (3, 10), (3, 11), (3, 2), (3, 5);

-- Insert ~60 Transactions
-- For Fund 1
INSERT INTO transaction (transaction_amount, transaction_date, participant_id, fund_id)
VALUES
  (1000, CURRENT_TIMESTAMP, 2, 1),
  (1500, CURRENT_TIMESTAMP, 3, 1),
  (1200, CURRENT_TIMESTAMP, 4, 1),
  (1300, CURRENT_TIMESTAMP, 5, 1),
  (1100, CURRENT_TIMESTAMP, 2, 1),
  (1150, CURRENT_TIMESTAMP, 3, 1),
  (900, CURRENT_TIMESTAMP, 4, 1),
  (1000, CURRENT_TIMESTAMP, 5, 1),
  (950, CURRENT_TIMESTAMP, 2, 1),
  (1400, CURRENT_TIMESTAMP, 3, 1),
  (1250, CURRENT_TIMESTAMP, 4, 1),
  (1100, CURRENT_TIMESTAMP, 5, 1),
  (1050, CURRENT_TIMESTAMP, 2, 1),
  (1000, CURRENT_TIMESTAMP, 3, 1),
  (950, CURRENT_TIMESTAMP, 4, 1),
  (1200, CURRENT_TIMESTAMP, 5, 1),
  (1150, CURRENT_TIMESTAMP, 2, 1),
  (1300, CURRENT_TIMESTAMP, 3, 1),
  (1350, CURRENT_TIMESTAMP, 4, 1),
  (1250, CURRENT_TIMESTAMP, 5, 1);

-- For Fund 2
INSERT INTO transaction (transaction_amount, transaction_date, participant_id, fund_id)
VALUES
  (2000, CURRENT_TIMESTAMP, 6, 2),
  (2500, CURRENT_TIMESTAMP, 7, 2),
  (1800, CURRENT_TIMESTAMP, 8, 2),
  (2300, CURRENT_TIMESTAMP, 9, 2),
  (1950, CURRENT_TIMESTAMP, 6, 2),
  (2100, CURRENT_TIMESTAMP, 7, 2),
  (2200, CURRENT_TIMESTAMP, 8, 2),
  (2250, CURRENT_TIMESTAMP, 9, 2),
  (2400, CURRENT_TIMESTAMP, 6, 2),
  (2450, CURRENT_TIMESTAMP, 7, 2),
  (1900, CURRENT_TIMESTAMP, 8, 2),
  (2150, CURRENT_TIMESTAMP, 9, 2),
  (2350, CURRENT_TIMESTAMP, 6, 2),
  (2500, CURRENT_TIMESTAMP, 7, 2),
  (2000, CURRENT_TIMESTAMP, 8, 2),
  (2050, CURRENT_TIMESTAMP, 9, 2),
  (2100, CURRENT_TIMESTAMP, 6, 2),
  (2150, CURRENT_TIMESTAMP, 7, 2),
  (2200, CURRENT_TIMESTAMP, 8, 2),
  (2250, CURRENT_TIMESTAMP, 9, 2);

-- For Fund 3
INSERT INTO transaction (transaction_amount, transaction_date, participant_id, fund_id)
VALUES
  (3000, CURRENT_TIMESTAMP, 10, 3),
  (3200, CURRENT_TIMESTAMP, 11, 3),
  (3100, CURRENT_TIMESTAMP, 2, 3),
  (3300, CURRENT_TIMESTAMP, 5, 3),
  (3400, CURRENT_TIMESTAMP, 10, 3),
  (3450, CURRENT_TIMESTAMP, 11, 3),
  (3100, CURRENT_TIMESTAMP, 2, 3),
  (3050, CURRENT_TIMESTAMP, 5, 3),
  (3350, CURRENT_TIMESTAMP, 10, 3),
  (3250, CURRENT_TIMESTAMP, 11, 3),
  (3150, CURRENT_TIMESTAMP, 2, 3),
  (3400, CURRENT_TIMESTAMP, 5, 3),
  (3000, CURRENT_TIMESTAMP, 10, 3),
  (3300, CURRENT_TIMESTAMP, 11, 3),
  (3200, CURRENT_TIMESTAMP, 2, 3),
  (3100, CURRENT_TIMESTAMP, 5, 3),
  (3500, CURRENT_TIMESTAMP, 10, 3),
  (3450, CURRENT_TIMESTAMP, 11, 3),
  (3250, CURRENT_TIMESTAMP, 2, 3),
  (3350, CURRENT_TIMESTAMP, 5, 3);