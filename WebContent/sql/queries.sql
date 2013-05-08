-- queries

select * from users
select * from profile
select * from page
select * from project
select * from topic
select * from post

select * from users_project;
select * from profile_page

-- queries com join
select * from profile
where profile_id in(
select profile_id from users where user_id = 1);

-- queries com join
select * from menu
where menu_id in(select menu_id from profile where profile_id = 1)

-- queries com join
select * from page
where page_id 
in(select page_id from profile_page where profile_id = 1)
order by url asc;

-----------------------

INSERT INTO page (title, url, status, description, creation_date) 
	VALUES ('Create User', '/modules/user/create.xhtml', 'activated', 'desc', '09/04/2012')
INSERT INTO page (title, url, status, description, creation_date) 
	VALUES ('Retrieve User', '/modules/user/retrieve.xhtml', 'activated', 'desc', '09/04/2012')
INSERT INTO page (title, url, status, description, creation_date) 
	VALUES ('Create Profile', '/modules/profile/create.xhtml', 'activated', 'desc', '09/04/2012')
INSERT INTO page (title, url, status, description, creation_date) 
	VALUES ('Retrieve Profile', '/modules/profile/retrieve.xhtml', 'activated', 'desc', '09/04/2012')
INSERT INTO page (title, url, status, description, creation_date) 
	VALUES ('Create Page', '/modules/page/create.xhtml', 'activated', 'desc', '09/04/2012')
INSERT INTO page (title, url, status, description, creation_date) 
	VALUES ('Retrieve Page', '/modules/page/retrieve.xhtml', 'activated', 'desc', '09/04/2012')
----------

INSERT INTO profile (title, status, description, creation_date) 
	VALUES ('Admin', 'activated', 'desc', '09/04/2012')
INSERT INTO profile (title, status, description, creation_date) 
	VALUES ('User', 'activated', 'desc', '09/04/2012')

----------

INSERT INTO users (user_name, email, password, status, creation_date, profile_id) 
	VALUES ('everson.figueiro', 'everson.figueiro@gmail.com', 'scorpion', 'hold', '09/04/2012', 1)
INSERT INTO users (user_name, email, password, status, creation_date, profile_id) 
	VALUES ('carlos.figueiro', 'carlos.figueiro@york.com', 'carlos', 'hold', '09/04/2012', 2)

----------

INSERT INTO profile_page (profile_id, page_id) 
	VALUES (1, 1)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (1, 2)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (1, 3)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (1, 4)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (1, 5)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (1, 6)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (2, 5)
INSERT INTO profile_page (profile_id, page_id) 
	VALUES (2, 6)
