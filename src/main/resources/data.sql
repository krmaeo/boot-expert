DROP TABLE IF EXISTS question;

CREATE TABLE question (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  question_text VARCHAR(250) NOT NULL,
  additional_info VARCHAR(250) NOT NULL,
  device_id INT NOT NULL
);
 
INSERT INTO question (question_text, additional_info, device_id) VALUES
  ('How many children have ProEkspert workers in total?', 'Around 180 says Priit',1),
  ('How many exits has Tallinn office', 'We believe there is no correct answer in this maze',1),
  ('How fun was bootcamp', 'Results are based on the faces of bootcampers',1),
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
('21', 0,1),
('76', 0,1),
('180', 1,1),
('3', 0,2),
('4', 1,2),
('5', 0,2),
('What bootcamp?', 0,3),
('Super-duper awesome', 1,3),
('Boring', 0,3),
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
  ('Bootcamp awesome device', 'Pick me!','https://images2.minutemediacdn.com/image/upload/c_crop,h_1193,w_2121,x_0,y_175/f_auto,q_auto,w_1100/v1554921998/shape/mentalfloss/549585-istock-909106260.jpg'),
  ('Bootcamp less awesome device', 'Do not pick me','https://pbs.twimg.com/profile_images/1080855598298611713/lTS-u1Iu.jpg'),
  ('Bootcamp rather boring part', 'Can not solve in one line','https://i.kym-cdn.com/photos/images/newsfeed/001/237/748/a8e.jpg');