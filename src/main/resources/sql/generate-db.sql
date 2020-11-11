create table client (
  id serial,
  first_name varchar(255) not null,
  last_name varchar(255) not null,
  passport_number varchar(16) unique not null,
  primary key(id)
);
create table destination (
  id serial,
  name varchar(255) unique not null,
  primary key(id)
);
create table guide (
  id serial,
  first_name varchar(255) not null,
  last_name varchar(255) not null,
  primary key(id)
);
create table trip (
  id serial,
  start_date date not null,
  end_date date not null,
  default_price decimal(10,2) not null,
  guide_id int,
  destination_id int,
  primary key(id),
  foreign key(guide_id) references guide(id),
  foreign key(destination_id) references destination(id)
);
create table reservation (
  id serial,
  price decimal(10,2),
  trip_id int,
  client_id int,
  primary key(id),
  foreign key(trip_id) references trip(id),
  foreign key(client_id) references client(id)
);
