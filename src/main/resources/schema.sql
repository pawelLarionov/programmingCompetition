CREATE TABLE TASK
(
    id               BIGINT        NOT NULL AUTO_INCREMENT,
    global_id        VARCHAR(36)   NOT NULL,
    name             VARCHAR(128)  NOT NULL,
    description      VARCHAR(1024) NOT NULL,
    input_parameter  VARCHAR(64)   NOT NULL,
    output_parameter VARCHAR(64)   NOT NULL,
    PRIMARY KEY (id)
);
CREATE SEQUENCE TASK_SEQ;
CREATE UNIQUE INDEX UX_TASK_GLOBAL_ID ON TASK (global_id);

COMMENT ON TABLE TASK IS 'Task to solve';
COMMENT ON COLUMN TASK.id IS 'Task inner id';
COMMENT ON COLUMN TASK.global_id IS 'Task global id';
COMMENT ON COLUMN TASK.name IS 'Task name';
COMMENT ON COLUMN TASK.description IS 'Task description';
COMMENT ON COLUMN TASK.input_parameter IS 'Task input_parameter';
COMMENT ON COLUMN TASK.output_parameter IS 'Task output_parameter';

CREATE TABLE USER
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    nick_name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE USER_SEQ;
CREATE UNIQUE INDEX UX_USER_NICK_NAME ON USER (nick_name);

COMMENT ON TABLE USER IS 'User who solve the task';
COMMENT ON COLUMN USER.id IS 'User inner id';
COMMENT ON COLUMN USER.nick_name IS 'User nick name';

CREATE TABLE USER_TASK
(
    user_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, task_id),
    FOREIGN KEY (user_id) REFERENCES USER (id),
    FOREIGN KEY (task_id) REFERENCES TASK (id)
);

COMMENT ON TABLE USER_TASK IS 'Tasks solved by the user';
COMMENT ON COLUMN USER_TASK.user_id IS 'foreign key on User';
COMMENT ON COLUMN USER_TASK.task_id IS 'foreign key on Task';
