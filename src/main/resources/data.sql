INSERT INTO T_USER VALUES ('EC444374-A6D9-4B78-BB4A-A26FB3B90D28', 'zaferfatih', 'zafer', 'fatih', 'zaferfatih@gmail.com', 'qwe123', '0630331942', 1);
INSERT INTO T_USER VALUES ('cee9a576-4722-11e8-842f-0ed5f89f718b', 'tolunaytoprakkaya', 'tolunay', 'toprakkaya', 'tolunaytoprakkaya@gmail.com', 'tt123', '8547905738', 1);

INSERT INTO T_CATEGORY VALUES ('cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Cat');
INSERT INTO T_CATEGORY VALUES ('cee9abc0-4722-11e8-842f-0ed5f89f718b', 'Dog');
INSERT INTO T_CATEGORY VALUES ('cee9acf6-4722-11e8-842f-0ed5f89f718b', 'Bird');
INSERT INTO T_CATEGORY VALUES ('cee9ae22-4722-11e8-842f-0ed5f89f718b', 'Fish');

INSERT INTO T_ORDER VALUES ('cee9ae22-4722-11e8-842f-0ed5f89f718b', '10', '04/23/2018', '1', TRUE );
INSERT INTO T_ORDER VALUES ('cee9acf6-4722-11e8-842f-0ed5f89f718b', '5', '04/23/2018', '1', TRUE );
INSERT INTO T_ORDER VALUES ('cee9abc0-4722-11e8-842f-0ed5f89f718b', '4', '04/23/2018', '1', FALSE );

INSERT INTO T_PET VALUES ('cee9af58-4722-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Korat', 'http://cdn3-www.cattime.com/assets/uploads/gallery/korat-cats-and-kittens/korat-cats-kittens-1.jpg', 'b20f7408-4727-11e8-842f-0ed5f89f718b','1' );
INSERT INTO T_PET VALUES ('cee9b8fe-4722-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Havana Brown', 'http://cdn1-www.cattime.com/assets/uploads/gallery/havana-brown-cats-and-kittens/havana-brown-cats-kittens-5.png', 'b6f0ee2a-4727-11e8-842f-0ed5f89f718b','1' );
INSERT INTO T_PET VALUES ('cee9ba2a-4722-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Maine Coon', 'http://cdn1-www.cattime.com/assets/uploads/gallery/maine-coon-cats-and-kittens/maine-coon-cats-and-kittens-5.jpg', 'f8b427a6-4726-11e8-842f-0ed5f89f718b','1' );
INSERT INTO T_PET VALUES ('73161866-4726-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Japanese Bobtail', 'http://cdn3-www.cattime.com/assets/uploads/gallery/japanese-bobtail-cats-and-kittens/japanese-bobtail-cats-kittens-1.jpg', 'fd758e2e-4726-11e8-842f-0ed5f89f718b','1' );
INSERT INTO T_PET VALUES ('7ce19afa-4726-11e8-842f-0ed5f89f718b', 'cee9aa58-4722-11e8-842f-0ed5f89f718b', 'Ocicat', 'http://cdn1-www.cattime.com/assets/uploads/2011/12/file_2736_ocicat-460x290-460x290.jpg', '018e4a14-4727-11e8-842f-0ed5f89f718b','1' );

INSERT INTO T_TAG VALUES ('b20f7408-4727-11e8-842f-0ed5f89f718b', 'Thailand');
INSERT INTO T_TAG VALUES ('b6f0ee2a-4727-11e8-842f-0ed5f89f718b', 'United Kingdom');
INSERT INTO T_TAG VALUES ('f8b427a6-4726-11e8-842f-0ed5f89f718b', 'USA');
INSERT INTO T_TAG VALUES ('fd758e2e-4726-11e8-842f-0ed5f89f718b', 'Japan');
INSERT INTO T_TAG VALUES ('018e4a14-4727-11e8-842f-0ed5f89f718b', 'USA');