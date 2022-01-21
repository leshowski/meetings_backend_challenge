INSERT INTO building (id,name) VALUES (1,	'building N°1');
INSERT INTO building (id,name) VALUES (2,	'building N°2');

INSERT INTO floor (id, name, building_id) values (101,'B1 GF', 1);
INSERT INTO floor (id, name, building_id) values (102,'B1 F2', 1);
INSERT INTO floor (id, name, building_id) values (103,'B1 F3', 1);
INSERT INTO floor (id, name, building_id) values (201,'B2 GF', 2);
INSERT INTO floor (id, name, building_id) values (202,'B2 F2', 2);

INSERT INTO Room(id,name,max_Allocation,floor_id) values (10101,'B1 GF ROOM1',10,101);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (10102,'B1 GF ROOM2',20,101);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (10103,'B1 GF ROOM3',30,101);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (10201,'B1 F2 ROOM1',40,102);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (10202,'B1 F2 ROOM2',50,102);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (10301,'B1 F3 ROOM1',100,103);

INSERT INTO Room(id,name,max_Allocation,floor_id) values (20101,'B2 GF ROOM1',50,201);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (20102,'B2 GF ROOM2',50,201);
INSERT INTO Room(id,name,max_Allocation,floor_id) values (20103,'B2 F2 ROOM1',100,202);



INSERT INTO Capability(id,name) values (01,'Computer');
INSERT INTO Capability(id,name) values (02,'Whiteboard');
INSERT INTO Capability(id,name) values (03,'TV');
INSERT INTO Capability(id,name) values (04,'Projector Screen');
INSERT INTO Capability(id,name) values (05,'Microphone');
INSERT INTO Capability(id,name) values (06,'Telephone');


insert into rel_room_capability (fk_room,fk_capability) values (10101,01);
insert into rel_room_capability (fk_room,fk_capability) values (10101,02);
insert into rel_room_capability (fk_room,fk_capability) values (10102,01);
insert into rel_room_capability (fk_room,fk_capability) values (10102,03);
insert into rel_room_capability (fk_room,fk_capability) values (10102,04);
insert into rel_room_capability (fk_room,fk_capability) values (10103,01);
insert into rel_room_capability (fk_room,fk_capability) values (10103,03);

insert into rel_room_capability (fk_room,fk_capability) values (10201,01);
insert into rel_room_capability (fk_room,fk_capability) values (10201,02);
insert into rel_room_capability (fk_room,fk_capability) values (10201,03);
insert into rel_room_capability (fk_room,fk_capability) values (10201,04);

insert into rel_room_capability (fk_room,fk_capability) values (10202,04);
insert into rel_room_capability (fk_room,fk_capability) values (10103,05);
insert into rel_room_capability (fk_room,fk_capability) values (10103,06);

