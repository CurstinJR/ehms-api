INSERT INTO role (`id`, `name`, `description`)
VALUES (1, 'ADMIN', 'Root user'),
       (2, 'USER', 'Normal User'),
       (3, 'DOCTOR', 'A registered doctor'),
       (4, 'NURSE', 'A registered nurse'),
       (5, 'RECEPTIONIST', 'A registered receptionist');

INSERT INTO employee (`id`, `first_name`, `last_name`, `role_id`)
VALUES (1, 'Joe', 'Roe', 1),
       (2, 'Jack', 'Ross', 2),
       (3, 'Sarah', 'Flem', 3),
       (4, 'Zack', 'Synder', 4),
       (5, 'Ruby', 'Flame', 5);

INSERT INTO patient (`id`, `first_name`, `last_name`, `blood_pressure`, `height`, `temperature`, `weight`)
VALUES (1, 'Joe', 'Roe', 'Normal', 165, 37.4, 78.6),
       (2, 'Jack', 'Ross', 'Normal', 170, 35.4, 80.5),
       (3, 'Sarah', 'Flem', 'Irregular', 172, 35.4, 87.5),
       (4, 'Zack', 'Synder', 'High', 169, 35.4, 80.5),
       (5, 'Ruby', 'Flame', 'Blood High', 171, 38.4, 74.5);

INSERT INTO appointment (appointment_id, appointment_date, appointment_time, patient_id)
    VALUE (1, CURRENT_DATE, CURRENT_TIME, 1),
    (2, CURRENT_DATE, CURRENT_TIME, 1),
    (3, CURRENT_DATE, CURRENT_TIME, 2);

INSERT INTO login_credentials (`id`, `email`, `password`, `employee_id`)
VALUES (1, 'joe@email.com', '$2a$12$P4PEgsHUUdpy4Eg2pZ5EAOkmsaKPkH9oNxQko3kVNBtSB.uNmdWRe', 1),
       (2, 'jack@email.com', '$2a$12$RHOBI1hXxiEsccmJSLiJJuzB8F.mF./aRIFmCq1kYo5k0QimjY9VS', 2),
       (3, 'sarah@email.com', '$2a$12$AYeBemlxC6Zuo3mO6IiZfef6xwLk8TsW/vpJryakiStZ2NvBVpmZq', 3),
       (4, 'zack@email.com', '$2a$12$EyEJhuOTWID4TUeKu4gNUu1P8W6kV5q7tx9KSABU73B6vIukG0XYW', 4),
       (5, 'ruby@email.com', '$2a$12$y6WyvlkN89.TsvBa9JUQaeBWJ66/DM0OvCE9f59w6EM/HJhXIaRym', 5);

INSERT INTO medical_aid (`claim_id`, `claim_date`, `claim_type`, `medical_aid_name`, `medical_aid_no`)
VALUES (1, CURRENT_DATE, 'ClaimType1', 'Name1', 123456),
       (2, CURRENT_DATE, 'ClaimType2', 'Name2', 123456),
       (3, CURRENT_DATE, 'ClaimType3', 'Name3', 123456);

INSERT INTO bill (`bill_id`, `bill_amount`, `bill_date`, `bill_description`)
VALUES (1, 505.63, CURRENT_DATE, 'Some description of Bill 1'),
       (2, 704.78, CURRENT_DATE, 'Some description of Bill 2'),
       (3, 1001.98, CURRENT_DATE, 'Some description of Bill 3');
