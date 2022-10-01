INSERT INTO bill (bill_id, bill_amount, bill_date, bill_description)
VALUES (1, 505.63, CURRENT_DATE, 'Some description of Bill 1'),
       (2, 704.78, CURRENT_DATE, 'Some description of Bill 2'),
       (3, 1001.98, CURRENT_DATE, 'Some description of Bill 3');

INSERT INTO patient (patient_id, patient_name, patient_surname)
VALUES (1, 'Joe', 'Roe'),
       (2, 'Jack', 'Ross'),
       (3, 'Sarah', 'Flem');

INSERT INTO medical_aid (claim_id, claim_date, claim_type, medical_aid_name, medical_aid_no)
VALUES (1, CURRENT_DATE, 'ClaimType1', 'Name1', 123456),
       (2, CURRENT_DATE, 'ClaimType2', 'Name2', 123456),
       (3, CURRENT_DATE, 'ClaimType3', 'Name3', 123456);

INSERT INTO login_credentials (id, email, `password`, `role`)
VALUES (1, 'admin@email.com', '$2y$12$qs3gqib1vHNqaXWbzvIlI.46LsFeria7c6hoFXiRVB4UzdVSv50WC', 'ADMIN'),
       (2, 'user@email.com', 'somepassword2', 'USER'),
       (3, 'curstin@email.com', 'somepassword3', 'USER');
