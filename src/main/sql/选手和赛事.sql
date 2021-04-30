
create table players
(
    player_id int primary key auto_increment,
    group_id  int
);

create table matches
(
    match_id      int primary key auto_increment,
    first_player  int,
    second_player int,
    first_score   int,
    second_score  int,
    group_id      int
);

create table players
(
    player_id int primary key auto_increment,
    group_id  int
);

create table matches
(
    match_id      int primary key auto_increment,
    first_player  int,
    second_player int,
    first_score   int,
    second_score  int,
    group_id      int
);

insert into players
values (15, 1),
       (25, 1),
       (30, 1),
       (45, 1),
       (10, 2),
       (35, 2),
       (50, 2),
       (20, 3),
       (40, 3);

insert into matches
values (2, 30, 25, 1, 2, 1),
       (3, 30, 15, 2, 0, 1),
       (4, 40, 20, 5, 2, 3),
       (5, 35, 50, 1, 1, 2);

select MS.group_id, min(GS2.player_id) as player_id
from (
         select group_id, max(score) as max_score
         from (
                  select P.group_id, P.player_id, ifnull(PS.tatal_score, 0) as score
                  from players as P
                           left join
                       (
                           select player_id, sum(score) as tatal_score
                           from (
                                    select first_player as player_id, sum(first_score) as score
                                    from matches
                                    group by first_player
                                    union
                                    select second_player as player_id, sum(second_score) as score
                                    from matches
                                    group by second_player
                                ) as PST
                           group by player_id
                       ) as PS
                       on PS.player_id = P.player_id
              ) as GS
         group by group_id
     ) as MS,
     (
         select P.group_id, P.player_id, ifnull(PS.tatal_score, 0) as score
         from players as P
                  left join
              (
                  select player_id, sum(score) as tatal_score
                  from (
                           select first_player as player_id, sum(first_score) as score
                           from matches
                           group by first_player
                           union
                           select second_player as player_id, sum(second_score) as score
                           from matches
                           group by second_player
                       ) as PST
                  group by player_id
              ) as PS
              on PS.player_id = P.player_id
     ) as GS2
where MS.group_id = GS2.group_id
  and MS.max_score = GS2.score
group by group_id
order by group_id;


select group_id, max(score) as max_score
from (
         select P.group_id, P.player_id, ifnull(PS.tatal_score, 0) as score
         from players as P
                  left join
              (
                  select player_id, sum(score) as tatal_score
                  from (
                           select first_player as player_id, sum(first_score) as score
                           from matches
                           group by first_player
                           union
                           select second_player as player_id, sum(second_score) as score
                           from matches
                           group by second_player
                       ) as PST
                  group by player_id
              ) as PS
              on PS.player_id = P.player_id
     ) as GS
group by group_id;



select P.group_id, P.player_id, ifnull(PS.tatal_score, 0) as score
from players as P
         left join
     (
         select player_id, sum(score) as tatal_score
         from (
                  select first_player as player_id, sum(first_score) as score
                  from matches
                  group by first_player
                  union
                  select second_player as player_id, sum(second_score) as score
                  from matches
                  group by second_player
              ) as PST
         group by player_id
     ) as PS
     on PS.player_id = P.player_id;
