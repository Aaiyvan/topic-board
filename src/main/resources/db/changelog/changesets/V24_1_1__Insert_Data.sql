insert into t_users (id, c_name, c_username, c_password)
values ('a9eaeed2-2aba-41ff-a8f2-67a48d66c2f2', 'John Doe', 'johnDoe', '$2a$04$7jJLEf909w6Rsuf1V4JVN.2Q9R8tgKlPhxpdyjiXJPoiUbI7oOU8.'),
       ('59c66ed3-04be-42e3-a47c-596f0c0d6cec', 'Mike Smith', 'mikeSmith', '$2a$04$xKQqnDClJPUt0BNWty4fjOLWiiKOeS2t36Z/TXM2nN7qpiJdiP6ma');

insert into t_messages (id, c_author_name, c_text, c_creation_date)
values ('44308ba1-0917-41ec-a333-9dce944d71bc', 'johnDoe', 'JohnDoe message1', '2024-04-10 02:53:58.528142'),
       ('46a9f6f7-8ca1-4ee6-963c-c8221dc89ca5', 'johnDoe', 'JohnDoe message2', '2024-04-10 02:55:27.784567'),
       ('b2baab12-7984-4b9c-a780-52c7391ddd25', 'mikeSmith', 'MikeSmith message', '2024-04-10 03:21:19.432425');

insert into t_topics (id, c_title)
values ('9ef94a2a-5a15-4247-a188-6553a5d04e6a', 'First Topic'),
       ('b89f5d17-3a52-4978-8dc0-3ee38d109414', 'Second Topic');

insert into t_topics_messages (message_id, topic_id)
values ('44308ba1-0917-41ec-a333-9dce944d71bc', '9ef94a2a-5a15-4247-a188-6553a5d04e6a'),
       ('b2baab12-7984-4b9c-a780-52c7391ddd25', '9ef94a2a-5a15-4247-a188-6553a5d04e6a'),
       ('46a9f6f7-8ca1-4ee6-963c-c8221dc89ca5', 'b89f5d17-3a52-4978-8dc0-3ee38d109414');

insert into t_users_messages (message_id, user_id)
values ('44308ba1-0917-41ec-a333-9dce944d71bc', 'a9eaeed2-2aba-41ff-a8f2-67a48d66c2f2'),
       ('46a9f6f7-8ca1-4ee6-963c-c8221dc89ca5', 'a9eaeed2-2aba-41ff-a8f2-67a48d66c2f2'),
       ('b2baab12-7984-4b9c-a780-52c7391ddd25', '59c66ed3-04be-42e3-a47c-596f0c0d6cec');

insert into t_users_roles (user_id, c_role)
values ('a9eaeed2-2aba-41ff-a8f2-67a48d66c2f2', 'ROLE_ADMIN'),
       ('a9eaeed2-2aba-41ff-a8f2-67a48d66c2f2', 'ROLE_USER'),
       ('59c66ed3-04be-42e3-a47c-596f0c0d6cec', 'ROLE_USER');