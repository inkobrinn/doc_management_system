INSERT INTO doctype(type_name)
VALUES ('Driving License'),
       ('Insurance Card'),
       ('Social Security Card'),
       ('Trade License'),
       ('Lease Agreement');

INSERT INTO authority(authority_name)
VALUES ('Driving and Licensing Authority'),
       ('Alicon Insurance Company'),
       ('Social Security Department'),
       ('Business Licensing Authority'),
       ('ABC Brokers');

INSERT INTO users(name, surname, email, password)
VALUES ('Mathew', 'Smith', 'smith@mail.ru', '11111'),
       ('Kevin', 'Anderson', 'kev@mail.ru', '22222'),
       ('Rony', 'Ball', 'ron@mail.ru', '33333'),
       ('Jerri', 'Bailey', 'jer@mail.ru', '44444'),
       ('Martin', 'Barnes', 'bar@mail.ru', '55555'),
       ('Bob', 'Brown', 'bob@mail.ru', '66666'),
       ('Frank', 'Butler', 'frank@mail.ru', '77777'),
       ('Liza', 'Carter', 'carter@mail.ru', '88888'),
       ('Natali', 'Cole', 'cole@mail.ru', '99999');


INSERT INTO document(document_code, description, doctype_id, issue_date, expiry_date, authority_id, user_id)
VALUES ('1236544', 'Drivers License issued from Oxford and need to be transferred to London', 1, '2014-01-01',
        '2016-01-01', 1, 1),
       ('6746182', 'Insurance Card. Only Self medical is included', 2, '2015-04-12', '2020-01-01', 2, 1),
       ('9891922', 'Driving License issued from London', 1, '2015-09-12', '2020-06-01', 1, 2),
       ('6457810', 'Social Security Card', 3, '2019-02-08', '2024-01-01', 3, 3),
       ('8717162', 'Insurance Card', 2, '2020-01-01', '2021-01-01', 2, 4),
       ('1216211', 'Company Commercial License', 4, '2016-12-01', '2017-09-09', 4, 5),
       ('7876100', 'Shop Lease Agreement', 5, '2015-12-12', '2019-01-01', 5, 6),
       ('8009111', 'Driving License', 1, '2020-01-01', '2030-01-01', 1, 7),
       ('9009090', 'Insurance Card', 2, '2020-04-09', '2021-05-09', 2, 8),
       ('2871821', 'Social Security Card', 3, '2019-01-01', '2020-01-01', 3, 9);