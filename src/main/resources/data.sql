DROP TABLE IF EXISTS question;

CREATE TABLE question (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  question_text VARCHAR(250) NOT NULL,
  additional VARCHAR(250) NOT NULL
);
 
INSERT INTO question (question_text, additional) VALUES
  ('Question 1', 'Additional 1'),
  ('Question 2', 'Additional 2'),
  ('Question 3', 'Additional 3');

DROP TABLE IF EXISTS answer;

CREATE TABLE answer (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          answer_text VARCHAR(250) NOT NULL,
                          isCorrect BOOL NOT NULL,
                          questionId INT NOT NULL
);

INSERT INTO answer (answer_text, isCorrect,questionId) VALUES
('Answer 1', 0,1),
('Answer 2', 0,1),
('Answer 3', 1,1),
('Answer 4', 0,2),
('Answer 5', 0,2),
('Answer 6', 1,2),
('Answer 7', 0,3),
('Answer 8', 0,3),
('Answer 9', 1,3);