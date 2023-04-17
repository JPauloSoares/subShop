DELETE FROM customer;
INSERT INTO customer(FIRSTNAME, LASTNAME, EMAIL, PHONE, PASSWORD, BALANCE) VALUES
  ('Rui', 'Ferrão', 'mail1@gmail.com', '77788812', '123', '100'),
  ('Sergio', 'Gouveia', 'mail2@gmail.com', '7773888', '123', '100'),
  ('Bruno', 'Ferreira', 'mai3l@gmail.com', '7778488', '123', '100'),
  ('No Accounts', 'No name', 'mail4@gmail.com', '7778858', '123', '100');


DELETE FROM products;
INSERT INTO products(SUBTYPE, ID, DESCRIPTION, PRICE) VALUES
  ('MAX',1, 'a melhor merda', '100'),
  ('LIGHT', 2 , 'a merda mais ou menos', '50'),
  ('MEDIUM', 3 , 'a pior merda', '25');

