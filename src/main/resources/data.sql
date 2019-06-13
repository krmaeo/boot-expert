DROP TABLE IF EXISTS question;

CREATE TABLE question (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  question_text VARCHAR(250) NOT NULL,
  additional_info VARCHAR(250) NOT NULL,
  device_id INT NOT NULL
);
 
INSERT INTO question (question_text, additional_info, device_id) VALUES
  ('Question 1', 'Additional 1',1),
  ('Question 2', 'Additional 2',1),
  ('Question 3', 'Additional 3',1),
    ('Question 4', 'Additional 4',2),
  ('Question 5', 'Additional 5',2),
  ('Question 6', 'Additional 6',2),
    ('Question 7', 'Additional 7',3),
  ('Question 8', 'Additional 8',3),
  ('Question 9', 'Additional 9',3);

DROP TABLE IF EXISTS answer;

CREATE TABLE answer (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          answer_text VARCHAR(250) NOT NULL,
                          is_Correct BOOL NOT NULL,
                          question_Id INT NOT NULL
);

INSERT INTO answer (answer_text, is_Correct,question_Id) VALUES
('Answer 1', 0,1),
('Answer 2', 0,1),
('Answer 3', 1,1),
('Answer 4', 0,2),
('Answer 5', 0,2),
('Answer 6', 1,2),
('Answer 7', 0,3),
('Answer 8', 0,3),
('Answer 9', 1,3),
('Answer 10', 0,4),
('Answer 11', 0,4),
('Answer 12', 1,4),
('Answer 13', 0,5),
('Answer 14', 0,5),
('Answer 15', 1,5),
('Answer 16', 0,6),
('Answer 17', 0,6),
('Answer 18', 1,6),
('Answer 19', 0,7),
('Answer 20', 0,7),
('Answer 21', 1,7),
('Answer 22', 0,8),
('Answer 23', 0,8),
('Answer 24', 1,8),
('Answer 25', 0,9),
('Answer 26', 0,9),
('Answer 27', 1,9);

DROP TABLE IF EXISTS device;

CREATE TABLE device (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  url VARCHAR(250) NOT NULL
);

INSERT INTO device (title, description,url) VALUES
  ('Title 1', 'Description 1','https://images2.minutemediacdn.com/image/upload/c_crop,h_1193,w_2121,x_0,y_175/f_auto,q_auto,w_1100/v1554921998/shape/mentalfloss/549585-istock-909106260.jpg'),
  ('Title 2', 'Description 2','https://images2.minutemediacdn.com/image/upload/c_crop,h_1193,w_2121,x_0,y_175/f_auto,q_auto,w_1100/v1554921998/shape/mentalfloss/549585-istock-909106260.jpg'),
  ('Title 3', 'Description 3','https://images2.minutemediacdn.com/image/upload/c_crop,h_1193,w_2121,x_0,y_175/f_auto,q_auto,w_1100/v1554921998/shape/mentalfloss/549585-istock-909106260.jpg');