
# Populating ALBUM

INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( '',                   NULL );
INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( 'Vanilla Time',          1 );
INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( 'Greatest Hits',         1 );
INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( 'Until the end of time', 1 );
INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( 'Vanilla Time',          2 );
INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( 'Greatest Hits',         2 );
INSERT INTO locker.ALBUM( DESC1, USER_ID ) VALUES ( 'Until the end of time', 2 );


# Populating APPLICATION

INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Files',   '/modules/files/img/folder.gif',           '/files/StartFiles.none'   );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Trash',   '/modules/trash/img/trashcan_empty.gif',   '/trash/StartTrash.none'   );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Email',   '/modules/email/img/email.gif',            '/email/StartEmail.none'   );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Music',   '/modules/music/img/kmix.gif',             '/music/StartMusic.none'   );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'IM',      '/modules/im/img/kuser.gif',               '/im/StartIM.none'         );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'HTML',    '/modules/html/img/favorites.gif',         '/html/StartHTML.none'     );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Photos',  '/modules/photos/img/camera.gif',          '/photos/StartPhotos.none' );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Phone',   '/modules/phone/img/sms_protocol.gif',     '/phone/StartPhone.none'   );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Bills',   '/modules/bills/img/kwallet.gif',          '/bills/StartBills.none'   );
INSERT INTO locker.APPLICATION( DESC1, DEFAULTICON, TARGETURL ) VALUES ( 'Notes',   '/modules/notes/img/korganizer.gif',       '/notes/StartNotes.none'   );


# Populating SHORTCUT

INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Files',  '/modules/files/img/folder.gif',          0,   5, 1,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Trash',  '/modules/trash/img/trashcan_empty.gif', 95,   5, 2,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Email',  '/modules/email/img/email.gif',           0,  63, 3,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Music',  '/modules/music/img/kmix.gif',           95,  63, 4,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'IM',     '/modules/im/img/kuser.gif',              0, 121, 5,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'HTML',   '/modules/html/img/favorites.gif',       95, 121, 6,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Photos', '/modules/photos/img/camera.gif',         0, 179, 7,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Phone',  '/modules/phone/img/sms_protocol.gif',   95, 179, 8,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Bills',  '/modules/bills/img/kwallet.gif',         0, 237, 9,  1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Notes',  '/modules/notes/img/korganizer.gif',     95, 237, 10, 1 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Files',  '/modules/files/img/folder.gif',          0,   5, 1,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Trash',  '/modules/trash/img/trashcan_empty.gif', 95,   5, 2,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Email',  '/modules/email/img/email.gif',           0,  63, 3,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Music',  '/modules/music/img/kmix.gif',           95,  63, 4,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'IM',     '/modules/im/img/kuser.gif',              0, 121, 5,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'HTML',   '/modules/html/img/favorites.gif',       95, 121, 6,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Photos', '/modules/photos/img/camera.gif',         0, 179, 7,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Phone',  '/modules/phone/img/sms_protocol.gif',   95, 179, 8,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Bills',  '/modules/bills/img/kwallet.gif',         0, 237, 9,  2 );
INSERT INTO locker.SHORTCUT( DESC1, ICON, XCOORD, YCOORD, APPLICATION_ID, USER_ID ) VALUES ( 'Notes',  '/modules/notes/img/korganizer.gif',     95, 237, 10, 2 );


# Populating ARTIST

INSERT INTO locker.ARTIST( DESC1, USER_ID ) VALUES ( 'Vanilla Ice',                  1 );
INSERT INTO locker.ARTIST( DESC1, USER_ID ) VALUES ( 'Kevin Lyttle f. Alison Hinds', 1 );
INSERT INTO locker.ARTIST( DESC1, USER_ID ) VALUES ( '2 Pac',                        1 );
INSERT INTO locker.ARTIST( DESC1, USER_ID ) VALUES ( 'Vanilla Ice',                  2 );
INSERT INTO locker.ARTIST( DESC1, USER_ID ) VALUES ( 'Kevin Lyttle f. Alison Hinds', 2 );
INSERT INTO locker.ARTIST( DESC1, USER_ID ) VALUES ( '2 Pac',                        2 );


# Populating CONTACT

INSERT INTO locker.CONTACT( NAME, NICKNAME, PHONE, EMAIL, USER_ID ) VALUES ( 'Petek Pekgoz',   'Petek',  '703-599-7232', 'petek@zlocker.com',  1);
INSERT INTO locker.CONTACT( NAME, NICKNAME, PHONE, EMAIL, USER_ID ) VALUES ( 'Adrian Szabadi', 'Adri',   '202-285-3299', 'ekszer@freemail.hu', 1);
INSERT INTO locker.CONTACT( NAME, NICKNAME, PHONE, EMAIL, USER_ID ) VALUES ( 'Pannon',         'Pannon', '202-285-3299', NULL,                 1);
INSERT INTO locker.CONTACT( NAME, NICKNAME, PHONE, EMAIL, USER_ID ) VALUES ( 'Ayda Elgun',     'Ayda',   '555-555-5555', 'ayda@museum.ny',     2);
INSERT INTO locker.CONTACT( NAME, NICKNAME, PHONE, EMAIL, USER_ID ) VALUES ( 'Elif Arsalbek',  'Elif',   '666-666-6666', 'elif@turkey.com',    2);
INSERT INTO locker.CONTACT( NAME, NICKNAME, PHONE, EMAIL, USER_ID ) VALUES ( 'Ipek Pekgoz',    'Mom',    '703-812-3840', 'fipek@hotmail.com',  2);


# Populating COUNTRY

INSERT INTO locker.COUNTRY( DESC1 ) VALUES ( 'United States' );
INSERT INTO locker.COUNTRY( DESC1 ) VALUES ( 'Hungary' );
INSERT INTO locker.COUNTRY( DESC1 ) VALUES ( 'Poland' );
INSERT INTO locker.COUNTRY( DESC1 ) VALUES ( 'Turkey' );
INSERT INTO locker.COUNTRY( DESC1 ) VALUES ( 'Mexico' );


# Populating FILETYPE

INSERT INTO locker.FILETYPE( DESC1 ) VALUES ( 'mp3' );
INSERT INTO locker.FILETYPE( DESC1 ) VALUES ( 'wav' );
INSERT INTO locker.FILETYPE( DESC1 ) VALUES ( 'txt' );
INSERT INTO locker.FILETYPE( DESC1 ) VALUES ( 'doc' );
INSERT INTO locker.FILETYPE( DESC1 ) VALUES ( 'xls' );


# Populating GENRE

INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( '',       NULL );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Rock',      1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Rap',       1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Dance',     1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'England',   1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'German',    1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Hungarian', 1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Hip-hop',   1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Etc',       1 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Rock',      2 );
INSERT INTO locker.GENRE( DESC1, USER_ID ) VALUES ( 'Other',     2 );


# Populating LANGUAGE

INSERT INTO locker.LANGUAGE( LOC, FLAG ) VALUES ( 'en_US', 'USA_flag.gif' );
INSERT INTO locker.LANGUAGE( LOC, FLAG ) VALUES ( 'hu_HU', 'HUN_flag.gif' );
INSERT INTO locker.LANGUAGE( LOC, FLAG ) VALUES ( 'tr_TR', 'TUR_flag.gif' );


# Populating SECRETQUESTION

INSERT INTO locker.SECRETQUESTION( DESC1 ) VALUES ( 'What''s your mother''s maiden name?' );
INSERT INTO locker.SECRETQUESTION( DESC1 ) VALUES ( 'What was your nickname in high school?' );
INSERT INTO locker.SECRETQUESTION( DESC1 ) VALUES ( 'What''s your favorite movie?' );


# Populating USERTYPE

INSERT INTO locker.USERTYPE( DESC1 ) VALUES ( 'Basic'  );
INSERT INTO locker.USERTYPE( DESC1 ) VALUES ( 'Admin' );


# Populating USERSTATUS

INSERT INTO locker.USERSTATUS( DESC1 ) VALUES ( 'Trial'     );
INSERT INTO locker.USERSTATUS( DESC1 ) VALUES ( 'Active'    );
INSERT INTO locker.USERSTATUS( DESC1 ) VALUES ( 'Closed'    );
INSERT INTO locker.USERSTATUS( DESC1 ) VALUES ( 'Expired'   );
INSERT INTO locker.USERSTATUS( DESC1 ) VALUES ( 'Suspended' );


# Populating USER1

INSERT INTO locker.USER1( FIRSTNAME, MIDDLENAME, LASTNAME, GENDER, BIRTHDAY, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, USERNAME, PASSWORD, EMAIL, PHONE, SECRETANSWER, NOFLOGINS, DATECREATED, LASTLOGIN, LANGUAGE_ID, COUNTRY_ID, SECRETQUESTION_ID, USERTYPE_ID, USERSTATUS_ID, WALLPAPER_ID, SKIN_ID ) VALUES ( 'Peter', '', 'Szocs', 0, '1979-05-25 12:00:00', '7409 Allan Ave', '', 'Falls Church', 'VA', 22046, 'peter', 'peter', 'peter@zlocker.com', '202-285-3299', 'secret1', 0, NOW(), NULL, 1, 1, 1, 2, 2, 3, 4 );
INSERT INTO locker.USER1( FIRSTNAME, MIDDLENAME, LASTNAME, GENDER, BIRTHDAY, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, USERNAME, PASSWORD, EMAIL, PHONE, SECRETANSWER, NOFLOGINS, DATECREATED, LASTLOGIN, LANGUAGE_ID, COUNTRY_ID, SECRETQUESTION_ID, USERTYPE_ID, USERSTATUS_ID, WALLPAPER_ID, SKIN_ID ) VALUES ( 'Petek', '', 'Pekgoz', 1, '1978-12-17 12:00:00', '200 North Randolph Str.', '', 'Arlington', 'VA', 22203, 'petek', 'petek', 'petek@zlocker.com', '703-599-7232', 'secret2', 0, NOW(), NULL, 1, 1, 1, 1, 2, 0, 6 );
INSERT INTO locker.USER1( FIRSTNAME, MIDDLENAME, LASTNAME, GENDER, BIRTHDAY, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, USERNAME, PASSWORD, EMAIL, PHONE, SECRETANSWER, NOFLOGINS, DATECREATED, LASTLOGIN, LANGUAGE_ID, COUNTRY_ID, SECRETQUESTION_ID, USERTYPE_ID, USERSTATUS_ID, WALLPAPER_ID, SKIN_ID ) VALUES ( 'Ferenc', '', 'Vehmann', 0, '1982-07-21 12:00:00', 'Oreghegy u. 30.', '', 'Paks', 'Tolna', 7030, 'fatso', 'fatso', 'fatso@zlocker.com', '+36-75-313-973', 'secret3', 0, NOW(), NULL, 1, 1, 1, 1, 2, 0, 6 );
INSERT INTO locker.USER1( FIRSTNAME, MIDDLENAME, LASTNAME, GENDER, BIRTHDAY, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, USERNAME, PASSWORD, EMAIL, PHONE, SECRETANSWER, NOFLOGINS, DATECREATED, LASTLOGIN, LANGUAGE_ID, COUNTRY_ID, SECRETQUESTION_ID, USERTYPE_ID, USERSTATUS_ID, WALLPAPER_ID, SKIN_ID ) VALUES ( 'Hungary', 'Test', 'User', 0, '1979-05-25 12:00:00', '7409 Allan Ave', '', 'Falls Church', 'VA', 22046, 'hungary', 'hungary', 'peter@zlocker.com', '202-285-3299', 'secret8', 0, NOW(), NULL, 2, 1, 1, 2, 2, 0, 6 );
INSERT INTO locker.USER1( FIRSTNAME, MIDDLENAME, LASTNAME, GENDER, BIRTHDAY, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, USERNAME, PASSWORD, EMAIL, PHONE, SECRETANSWER, NOFLOGINS, DATECREATED, LASTLOGIN, LANGUAGE_ID, COUNTRY_ID, SECRETQUESTION_ID, USERTYPE_ID, USERSTATUS_ID, WALLPAPER_ID, SKIN_ID ) VALUES ( 'Turkey', '', 'Turkey', 0, '1980-02-20 12:00:00', '7409 Allan Ave', '', 'Falls Church', 'VA', 22046, 'turkey', 'turkey', 'petek@zlocker.com', '703-599-7232', 'secret9', 0, NOW(), NULL, 3, 1, 1, 2, 2, 0, 6 );


# Populating MUSICFILE

INSERT INTO locker.MUSICFILE( ARTIST_ID, SONGTITLE, ALBUM_ID, LENGTH, DATECREATED, LINK, NOFPLAYED, GENRE_ID, FILETYPE_ID, USER_ID ) VALUES ( 1, 'Ice Ice Baby',                2, 273, NOW(), 'Vanilla_Ice_-_Ice_Ice_Baby.mp3', 0, 3,  1, 1 );
INSERT INTO locker.MUSICFILE( ARTIST_ID, SONGTITLE, ALBUM_ID, LENGTH, DATECREATED, LINK, NOFPLAYED, GENRE_ID, FILETYPE_ID, USER_ID ) VALUES ( 2, 'Turn Me On (Extended Remix)', 3, 304, NOW(), 'Kevin_Lyttle_-_Turn_me_on.mp3',  0, 9,  1, 1 );
INSERT INTO locker.MUSICFILE( ARTIST_ID, SONGTITLE, ALBUM_ID, LENGTH, DATECREATED, LINK, NOFPLAYED, GENRE_ID, FILETYPE_ID, USER_ID ) VALUES ( 3, 'California Love',             4, 241, NOW(), 'California_Love.mp3',            0, 3,  1, 1 );
INSERT INTO locker.MUSICFILE( ARTIST_ID, SONGTITLE, ALBUM_ID, LENGTH, DATECREATED, LINK, NOFPLAYED, GENRE_ID, FILETYPE_ID, USER_ID ) VALUES ( 4, 'Ice Ice Baby',                5, 273, NOW(), 'Vanilla_Ice_-_Ice_Ice_Baby.mp3', 0, 11, 1, 2 );
INSERT INTO locker.MUSICFILE( ARTIST_ID, SONGTITLE, ALBUM_ID, LENGTH, DATECREATED, LINK, NOFPLAYED, GENRE_ID, FILETYPE_ID, USER_ID ) VALUES ( 5, 'Turn Me On (Extended Remix)', 6, 304, NOW(), 'Kevin_Lyttle_-_Turn_me_on.mp3',  0, 11, 1, 2 );
INSERT INTO locker.MUSICFILE( ARTIST_ID, SONGTITLE, ALBUM_ID, LENGTH, DATECREATED, LINK, NOFPLAYED, GENRE_ID, FILETYPE_ID, USER_ID ) VALUES ( 6, 'California Love',             7, 241, NOW(), 'California_Love.mp3',            0, 11, 1, 2 );


# Populating MIXES

INSERT INTO locker.MIXES( TITLE, LENGTH, DATECREATED, NOFPLAYED, GENRE_ID ) VALUES ( 'Peter Mix 1', 273, NOW(), 1, 2);
INSERT INTO locker.MIXES( TITLE, LENGTH, DATECREATED, NOFPLAYED, GENRE_ID ) VALUES ( 'Peter Mix 2', 577, NOW(), 2, 3);
INSERT INTO locker.MIXES( TITLE, LENGTH, DATECREATED, NOFPLAYED, GENRE_ID ) VALUES ( 'Peter Mix 3', 818, NOW(), 3, 9);
INSERT INTO locker.MIXES( TITLE, LENGTH, DATECREATED, NOFPLAYED, GENRE_ID ) VALUES ( 'Petek Mix 1', 273, NOW(), 0, 10);
INSERT INTO locker.MIXES( TITLE, LENGTH, DATECREATED, NOFPLAYED, GENRE_ID ) VALUES ( 'Petek Mix 2', 577, NOW(), 3, 11);


# Populating RELMUSICMIXES

INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 1, 1, 1 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 1, 2, 1 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 2, 2, 2 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 1, 3, 1 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 2, 3, 2 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 3, 3, 3 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 4, 4, 1 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 4, 5, 1 );
INSERT INTO locker.RELMUSICMIXES( MUSICFILEID, MIXESID, ORDERINMIX ) VALUES ( 5, 5, 2 );


# Populating SKIN

INSERT INTO locker.SKIN( NAME, FILENAME ) VALUES ( 'Blue',   'blue.css'   );
INSERT INTO locker.SKIN( NAME, FILENAME ) VALUES ( 'Green',  'green.css'  );
INSERT INTO locker.SKIN( NAME, FILENAME ) VALUES ( 'Grey',   'grey.css'   );
INSERT INTO locker.SKIN( NAME, FILENAME ) VALUES ( 'Purple', 'purple.css' );
INSERT INTO locker.SKIN( NAME, FILENAME ) VALUES ( 'Red',    'red.css'    );
INSERT INTO locker.SKIN( NAME, FILENAME ) VALUES ( 'Yellow', 'yellow.css' );


# Populating PHOTO

INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Thailand', 'thailand3.jpg', NULL ); # Note: this is the default wallpaper!!!
UPDATE locker.PHOTO SET id=0 WHERE id=1;

INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Cruise 1', 'kruz2005_0003.jpg', 1 );
INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Cruise 2', 'kruz2005_0004.jpg', 1 );
INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Cruise 3', 'kruz2005_0005.jpg', 1 );
INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Cruise 4', 'kruz2005_0003.jpg', 2 );
INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Cruise 5', 'kruz2005_0004.jpg', 2 );
INSERT INTO locker.PHOTO( DESC1, LINK, USER_ID ) VALUES ( 'Cruise 6', 'kruz2005_0005.jpg', 2 );


# Populating PHOTOALBUM

INSERT INTO locker.PHOTOALBUM( TITLE, DESC1, DATECREATED, NOFVISITS, USER_ID ) VALUES ( 'Cruise 2003', 'Another great vacation, paid for by!', NOW(), 3,  1);
INSERT INTO locker.PHOTOALBUM( TITLE, DESC1, DATECREATED, NOFVISITS, USER_ID ) VALUES ( 'Cruise 2005', 'Sun and fun down under',               NOW(), 12, 1);
INSERT INTO locker.PHOTOALBUM( TITLE, DESC1, DATECREATED, NOFVISITS, USER_ID ) VALUES ( 'Cruise 2003', 'Another great vacation, paid for by!', NOW(), 2,  2);
INSERT INTO locker.PHOTOALBUM( TITLE, DESC1, DATECREATED, NOFVISITS, USER_ID ) VALUES ( 'Cruise 2005', 'Sun and fun down under',               NOW(), 7,  2);


# Populating RELPHOTOALBUM

INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 1, 1, 1 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 2, 1, 2 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 3, 1, 3 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 2, 2, 1 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 3, 2, 2 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 4, 3, 1 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 5, 3, 2 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 6, 3, 3 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 5, 4, 1 );
INSERT INTO locker.RELPHOTOALBUM( PHOTOID, ALBUMID, ORDERINALBUM ) VALUES ( 6, 4, 2 );
