INSERT INTO T_USER (id, username, firstname, lastname, email, password, phone, status) VALUES ('EC444374-A6D9-4B78-BB4A-A26FB3B90D28', 'zaferfatih', 'zafer', 'fatih', 'zaferfatih@gmail.com', 'qwe123', '0630331942', '1');
INSERT INTO T_USER (id, username, firstname, lastname, email, password, phone, status) VALUES ('cee9a576-4722-11e8-842f-0ed5f89f718b', 'tolunaytoprakkaya', 'tolunay', 'toprakkaya', 'tolunaytoprakkaya@gmail.com', 'tt123', '0630331947', '1');

INSERT INTO T_CATEGORY (id, name) VALUES ('cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Cat');
INSERT INTO T_CATEGORY (id, name) VALUES ('cee9abc0-4722-11e8-842f-0ed5f89f718b', 'Dog');
INSERT INTO T_CATEGORY (id, name) VALUES ('cee9acf6-4722-11e8-842f-0ed5f89f718b', 'Bird');
INSERT INTO T_CATEGORY (id, name) VALUES ('cee9ae22-4722-11e8-842f-0ed5f89f718b', 'Fish');

INSERT INTO T_TAG (id, name) VALUES ('b20f7408-4727-11e8-842f-0ed5f89f718b', 'United Kingdom');
--INSERT INTO T_TAG VALUES ('b6f0ee2a-4727-11e8-842f-0ed5f89f718b', 'United Kingdom');
INSERT INTO T_TAG (id, name) VALUES ('f8b427a6-4726-11e8-842f-0ed5f89f718b', 'USA');
INSERT INTO T_TAG (id, name) VALUES ('fd758e2e-4726-11e8-842f-0ed5f89f718b', 'Japan');
INSERT INTO T_TAG (id, name) VALUES ('018e4a14-4727-11e8-842f-0ed5f89f718b', 'Russia');

INSERT INTO T_PET (id, category_id, name, photo_url, tag_id, status) VALUES ('d0497088-4d42-11e8-9c2d-fa7ae01bbebc', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Devon Rex', 'http://cdn3-www.cattime.com/assets/uploads/gallery/bombay-cats-and-kittens_1/devon-rex-cats-and-kittens-1.jpg', 'b20f7408-4727-11e8-842f-0ed5f89f718b',1 );
INSERT INTO T_PET (id, category_id, name, photo_url, tag_id, status) VALUES ('cee9b8fe-4722-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Havana Brown', 'http://cdn1-www.cattime.com/assets/uploads/gallery/havana-brown-cats-and-kittens/havana-brown-cats-kittens-5.png', 'b20f7408-4727-11e8-842f-0ed5f89f718b',1 );
INSERT INTO T_PET (id, category_id, name, photo_url, tag_id, status) VALUES ('cee9ba2a-4722-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Maine Coon', 'http://cdn1-www.cattime.com/assets/uploads/gallery/maine-coon-cats-and-kittens/maine-coon-cats-and-kittens-5.jpg', 'f8b427a6-4726-11e8-842f-0ed5f89f718b',1 );
INSERT INTO T_PET (id, category_id, name, photo_url, tag_id, status) VALUES ('73161866-4726-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Japanese Bobtail', 'http://cdn3-www.cattime.com/assets/uploads/gallery/japanese-bobtail-cats-and-kittens/japanese-bobtail-cats-kittens-1.jpg', 'fd758e2e-4726-11e8-842f-0ed5f89f718b',1 );
INSERT INTO T_PET (id, category_id, name, photo_url, tag_id, status) VALUES ('7ce19afa-4726-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Siberian', 'http://cdn3-www.cattime.com/assets/uploads/gallery/siberian-cats-and-kittens/siberian-cats-kittens-1.jpg', '018e4a14-4727-11e8-842f-0ed5f89f718b',1 );


INSERT INTO T_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES ('d3fc00a5-8bd1-47dd-8a6a-d153b4e99c0d','d0497088-4d42-11e8-9c2d-fa7ae01bbebc', '10', '2018-04-23 00:00:00', '1', TRUE );
INSERT INTO T_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES ('269da09e-4d2f-11e8-9c2d-fa7ae01bbebc','cee9b8fe-4722-11e8-842f-0ed5f89f718b', '5', '2018-04-23 00:00:00', '1', TRUE );
INSERT INTO T_ORDER (id, pet_id, quantity, ship_date, status, complete) VALUES ('2c38e4aa-4d2f-11e8-9c2d-fa7ae01bbebc','cee9ba2a-4722-11e8-842f-0ed5f89f718b', '4', '2018-04-23 00:00:00', '1', FALSE );
