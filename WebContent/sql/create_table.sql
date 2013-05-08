-- Create and drop tables:**********************************************************************

drop table users
create table users
(
  user_id serial not null,
  email varchar(150) not null,
  password varchar(150) not null,
  unique(user_id, email),
  constraint user_pk primary key(user_id)
);

drop table customer
create table customer
(
  customer_id serial not null,
  name varchar(150) not null,
  phone varchar(150) not null,
  address varchar(150) not null,
  email varchar(150) not null,
  observation varchar(1000) not null,
  unique(customer_id, email),
  constraint customer_pk primary key(customer_id)
); 

drop table sale
create table sale
(
  sale_id serial not null,
  sales_type varchar(150) not null,
  situation varchar(150) not null,
  description varchar(1000) not null,
  sales_date varchar(50) not null,
  customer_id integer not null,
  unique(sale_id),
  constraint sale_pk primary key(sale_id),
  constraint customer_fk foreign key(customer_id) references customer(customer_id) on delete cascade
);

drop table parcel
create table parcel
(
  parcel_id serial not null,
  payment_day varchar(50) not null,
  situation varchar(150) not null,
  price varchar(150) not null,
  description varchar(1000) not null,
  sale_id integer not null,
  unique(parcel_id),
  constraint parcel_pk primary key(parcel_id),
  constraint sale_fk foreign key(sale_id) references sale(sale_id) on delete cascade
);

drop table provider
create table provider
(
  provider_id serial not null,
  name varchar(200) not null,       
  address varchar(300) not null,
  phone varchar(100) not null,
  description varchar(1000) not null,
  unique(provider_id),
  constraint provider_pk primary key(provider_id)
);

drop table product
create table product
(
  product_id serial not null,
  name varchar(200) not null,
  code varchar(200) not null,
  purchase_value varchar(150) not null,
  purchase_value2 varchar(150) not null,
  sales_value varchar(150) not null,
  description varchar(1000) not null,
  unique(product_id),
  constraint product_pk primary key(product_id)
);

drop table product_type
create table product_type
(
  product_type_id serial not null,
  name varchar(200) not null,
  description varchar(1000) not null,
  unique(product_type_id),
  constraint product_type_pk primary key(product_type_id)
);

drop table sale_product
create table sale_product
(
  sale_id integer not null,
  product_id integer not null,
  constraint sale_fk foreign key(sale_id) references sale(sale_id) on delete cascade,
  constraint product_fk foreign key(product_id) references product(product_id) on delete cascade
);

drop table provider_product
create table provider_product
(
  provider_id integer not null,
  product_id integer not null,
  constraint provider_fk foreign key(provider_id) references provider(provider_id) on delete cascade,
  constraint product_fk foreign key(product_id) references product(product_id) on delete cascade
);

-- Queries and insert***************************************************************************
select * from users
insert into users(email, password)
values('everson.figueiro@gmail.com', 'scorpion');

-- Insert for page
select * from page
insert into page(title, url, status, description, creation_date)
values('Create Page', '/modules/page/create.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Retrieve Page', '/modules/page/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Create Profile', '/modules/profile/create.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Retrieve Profile', '/modules/profile/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Create User', '/modules/user/create.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Retrieve User', '/modules/user/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Create Project', '/modules/project/create.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Retrieve Project', '/modules/project/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012');

insert into page(title, url, status, description, creation_date)
values('Forum(Topics)', '/modules/topic/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012');

-- Insert for profile
select * from profile
insert into profile(title, status, description, creation_date)
values('Admin', 'activated', 'desc', 'teste');

-- Insert for profile_page
insert into profile_page(profile_id, page_id)
values(1,1);

insert into profile_page(profile_id, page_id)
values(1,2);

insert into profile_page(profile_id, page_id)
values(1,3);

insert into profile_page(profile_id, page_id)
values(1,4);

insert into profile_page(profile_id, page_id)
values(1,5);

insert into profile_page(profile_id, page_id)
values(1,6);

insert into profile_page(profile_id, page_id)
values(1,7);

insert into profile_page(profile_id, page_id)
values(1,8);

insert into profile_page(profile_id, page_id)
values(1,9);

-- selects
select * from users
select * from profile
select * from page
select * from project
select * from topic
select * from post

select * from profile_page
select * from users_project
