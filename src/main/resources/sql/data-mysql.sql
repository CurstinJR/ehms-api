INSERT INTO role (`id`, `name`, `description`)
VALUES (1, 'ADMIN', 'Root user'),
       (2, 'USER', 'Normal User');

INSERT INTO staff (id, first_name, last_name, role_id)
VALUES (1, 'Joe', 'Roe', 1),
       (2, 'Jack', 'Ross', 2),
       (3, 'Sarah', 'Flem', 2);

INSERT INTO login_credentials (`id`, `email`, `password`, `staff_id`)
VALUES (1, 'joe@email.com', '$2a$12$P4PEgsHUUdpy4Eg2pZ5EAOkmsaKPkH9oNxQko3kVNBtSB.uNmdWRe', 1),
       (2, 'jack@email.com', '$2a$12$RHOBI1hXxiEsccmJSLiJJuzB8F.mF./aRIFmCq1kYo5k0QimjY9VS', 2),
       (3, 'sarah@email.com', '$2a$12$AYeBemlxC6Zuo3mO6IiZfef6xwLk8TsW/vpJryakiStZ2NvBVpmZq', 3);

INSERT INTO medical_aid (claim_id, claim_date, claim_type, medical_aid_name, medical_aid_no)
VALUES (1, CURRENT_DATE, 'ClaimType1', 'Name1', 123456),
       (2, CURRENT_DATE, 'ClaimType2', 'Name2', 123456),
       (3, CURRENT_DATE, 'ClaimType3', 'Name3', 123456);

INSERT INTO bill (bill_id, bill_amount, bill_date, bill_description)
VALUES (1, 505.63, CURRENT_DATE, 'Some description of Bill 1'),
       (2, 704.78, CURRENT_DATE, 'Some description of Bill 2'),
       (3, 1001.98, CURRENT_DATE, 'Some description of Bill 3');
