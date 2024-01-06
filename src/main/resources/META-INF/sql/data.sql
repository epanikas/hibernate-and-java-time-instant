insert into MY_SCHEMA.users
(id, name, email1, date_val, timestamp_val)
values
(123, 'alice', 'alice@domain.com', to_date('2024-01-17 22:45:12', 'YYYY-MM-DD HH24:MI:SS'), to_timestamp('2024-01-17 22:45:12.456', 'YYYY-MM-DD HH24:MI:SSXFF3'));