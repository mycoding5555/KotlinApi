-- Reset all tables
DELETE FROM attendances;
DELETE FROM students;
DELETE FROM users;

-- Insert users
INSERT INTO users (id, email, name, password) VALUES (1, 'alice@example.com', 'Alice', 'Alice123');
INSERT INTO users (id, email, name, password) VALUES (2, 'bob@example.com', 'Bob', 'Bob123');
INSERT INTO users (id, email, name, password) VALUES (3, 'jone@example.com', 'Joma', 'Joma123');

-- Insert students
INSERT INTO students (id, name, age, class_name, phone, user_id) VALUES (1, 'StudentA', 20, 'A1', '0123456789', 1);
INSERT INTO students (id, name, age, class_name, phone, user_id) VALUES (2, 'StudentB', 21, 'A2', '0987654321', 2);
INSERT INTO students (id, name, age, class_name, phone, user_id) VALUES (3, 'StudentC', 22, 'A3', '0112233445', 3);


-- Insert attendances
INSERT INTO attendances (user_id, student_id, check_in_time, check_out_time, status) VALUES (1, 1, '2025-08-18T08:00:00', '2025-08-18T17:00:00', 'PRESENT');
INSERT INTO attendances (user_id, student_id, check_in_time, check_out_time, status) VALUES (2, 2, '2025-08-18T09:00:00', '2025-08-18T18:00:00', 'PRESENT');
INSERT INTO attendances (user_id, student_id, check_in_time, check_out_time, status) VALUES (3, 3, '2025-08-19T08:30:00', '2025-08-19T17:15:00', 'PRESENT');
INSERT INTO attendances (user_id, student_id, check_in_time, check_out_time, status) VALUES (1, 1, '2025-08-20T08:05:00', '2025-08-20T17:00:00', 'PRESENT');
INSERT INTO attendances (user_id, student_id, check_in_time, check_out_time, status) VALUES (2, 2, '2025-08-20T09:10:00', '2025-08-20T18:10:00', 'PRESENT');
INSERT INTO attendances (user_id, student_id, check_in_time, check_out_time, status) VALUES (3, 3, '2025-08-21T08:00:00', '2025-08-21T17:00:00', 'PRESENT');

