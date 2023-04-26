DELETE FROM customer;
INSERT INTO customer(FIRSTNAME, LASTNAME, EMAIL, PHONE, PASSWORD, BALANCE) VALUES
  ('Rui', 'Ferrão', 'mail1@gmail.com', '777888121', '123', '100'),
  ('Sergio', 'Gouveia', 'mail2@gmail.com', '77738882', '123', '100'),
  ('Bruno', 'Ferreira', 'mai3l@gmail.com', '77784883', '123', '100'),
  ('Messi', 'Ronaldo', 'mail4@gmail.com', '77788584', '123', '100');


DELETE FROM products;
INSERT INTO products(SUBTYPE, ID, DESCRIPTION, PRICE) VALUES
  ('MAX',1, 'a melhor merda', '100'),
  ('LIGHT', 2 , 'a merda mais ou menos', '50'),
  ('MEDIUM', 3 , 'a pior merda', '25');

