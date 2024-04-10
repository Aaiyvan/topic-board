create table if not exists t_users
(
    id         UUID primary key,
    c_name     varchar(255) not null,
    c_username varchar(255) not null unique,
    c_password varchar(255) not null
);

create table if not exists t_topics
(
    id      UUID primary key,
    c_title varchar(255) not null
);

create table if not exists t_messages
(
    id              UUID primary key,
    c_author_name   varchar(255) not null,
    c_text          varchar(255) null,
    c_creation_date timestamp    null
);

create table if not exists t_users_messages
(
    user_id    UUID not null,
    message_id UUID not null,
    primary key (user_id, message_id),
    constraint fk_users_messages_users foreign key (user_id) references t_users (id) on delete cascade on update no action,
    constraint fk_users_tasks_tasks foreign key (message_id) references t_messages (id) on delete cascade on update no action
);

create table if not exists t_topics_messages
(
    topic_id   UUID not null,
    message_id UUID not null,
    primary key (topic_id, message_id),
    constraint fk_topics_messages_topics foreign key (topic_id) references t_topics (id) on delete cascade on update no action,
    constraint fk_topics_tasks_tasks foreign key (message_id) references t_messages (id) on delete cascade on update no action
);

create table if not exists t_users_roles
(
    user_id UUID         not null,
    c_role  varchar(255) not null,
    primary key (user_id, c_role),
    constraint fk_users_roles_users foreign key (user_id) references t_users (id) on delete cascade on update no action
);




