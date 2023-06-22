DROP USER c##board_dev CASCADE ;
CREATE USER c##board_dev IDENTIFIED by oracle01 DEFAULT TABLESPACE USERS TEMPORARY TABLESPACE TEMP PROFILE DEFAULT;
GRANT CONNECT,RESOURCE to c##board_dev;
ALTER USER c##board_dev ACCOUNT UNLOCK;


DROP TABLE BOARD_LIKES;
DROP SEQUENCE BOARD_LIKES_NUM_SEQ;
DROP TABLE  BOARDS;
DROP SEQUENCE BOARDS_NUM_SEQ;
DROP TABLE USERS;

CREATE TABLE USERS(
    u_id VARCHAR2(255) PRIMARY KEY,
    name VARCHAR2(255) not null,
    pw VARCHAR2(255) not null,
    hire_date TIMESTAMP default CURRENT_TIMESTAMP,
    birth DATE not null,
    profile_path VARCHAR2(255),
    gender CHAR not null ,
    state VARCHAR2(10) default 'SIGNUP' not null ,
    private CHAR(1) default '0' not null ,
    constraint users_gender_check check ( gender in ('M','F') ),
    constraint users_state_check check ( state in ('SIGNUP','LEAVE','BLOCK') )
);

-- Insert dummy data for USERS table
BEGIN
    FOR i IN 1..60 LOOP
            INSERT INTO USERS (u_id, name, pw, birth, profile_path, gender)
            VALUES (
                           'U' || LPAD(i, 3, '0'), -- Generate u_id
                           'User ' || i, -- Generate name
                           'password' || i, -- Generate pw
                           TO_DATE('1990-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 10000)), -- Generate random birth date between 1990-01-01 and 2009-12-31
                           '/public/users/profile/' || 'U' || LPAD(i, 3, '0') || '.jpg', -- Generate profile_path
                           CASE WHEN MOD(i, 2) = 0 THEN 'M' ELSE 'F' END -- Generate gender (alternate between M and F)
                   );
        END LOOP;
    COMMIT;
END;
CREATE TABLE BOARDS(
    b_num NUMBER PRIMARY KEY,
    title VARCHAR2(255) not null,
    content VARCHAR2(255) not null,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    private CHAR(1) default '0',
    views NUMBER default 0,
    u_id VARCHAR2(255) not null,
    CONSTRAINT BOARDS_FK_USERS FOREIGN KEY (u_id) REFERENCES USERS(u_id) ON DELETE CASCADE
);
CREATE SEQUENCE BOARDS_NUM_SEQ INCREMENT BY 1 START WITH 1;

BEGIN
    FOR i IN 1..60 LOOP
            INSERT INTO BOARDS (b_num, title, content, u_id)
            VALUES (
                            BOARDS_NUM_SEQ.nextval,
                           '게시글 제목입니다~ ' || i,
                           '게시글 내용입니다~ 우왕~ 게시판이다~' || i,
                           'U' || LPAD(i, 3, '0')

                   );
        END LOOP;
    COMMIT;
END;

-- BOARDS : LIKES = 1: N
CREATE TABLE BOARD_LIKES(
    bl_num NUMBER PRIMARY KEY,
    state VARCHAR2(10) NOT NULL,
    u_id VARCHAR2(255) NOT NULL,
    b_num NUMBER NOT NULL,
    CONSTRAINT BOARD_LIKES_STATE_CHECK CHECK ( state in ('LIKE','BAD','BEST','SAD') ),
    CONSTRAINT BOARD_LIKES_UK_U_ID_B_NUM UNIQUE (u_id,b_num)
);
CREATE SEQUENCE BOARD_LIKES_NUM_SEQ;
BEGIN
    FOR i IN 1..30 LOOP
            INSERT INTO BOARD_LIKES (bl_num, state, u_id, b_num)
            VALUES (
                       BOARD_LIKES_NUM_SEQ.nextval,
                       'LIKE',
                       'U' || LPAD(i, 3, '0'),
                        1
                   );
        END LOOP;
    COMMIT;
END;
BEGIN
    FOR i IN 31..40 LOOP
            INSERT INTO BOARD_LIKES (bl_num, state, u_id, b_num)
            VALUES (
                       BOARD_LIKES_NUM_SEQ.nextval,
                       'BAD',
                       'U' || LPAD(i, 3, '0'),
                       1

                   );
        END LOOP;
    COMMIT;
END;
BEGIN
    FOR i IN 41..45 LOOP
            INSERT INTO BOARD_LIKES (bl_num, state, u_id, b_num)
            VALUES (
                       BOARD_LIKES_NUM_SEQ.nextval,
                       'SAD',
                       'U' || LPAD(i, 3, '0'),
                       1

                   );
        END LOOP;
    COMMIT;
END;
BEGIN
    FOR i IN 46..60 LOOP
            INSERT INTO BOARD_LIKES (bl_num, state, u_id, b_num)
            VALUES (
                       BOARD_LIKES_NUM_SEQ.nextval,
                       'BEST',
                       'U' || LPAD(i, 3, '0'),
                       1

                   );
        END LOOP;
    COMMIT;
END;

commit;