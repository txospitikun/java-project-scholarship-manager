# REST API CALLS
```
/api/create_professor
Payload:
{
    "jwt": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInByaXZpbGVnZSI6IjMiLCJpYXQiOjE3MTY5NzQ0NDIsImV4cCI6MTcxNzgzODQ0Mn0.Gp4MXNiWFXnYjMiP2akUbJrwXMdoO7EjsxR1PIIDuBjnL12AD_yDecYTISSj14-y6bxLfpksm0VEKksinUP1vw",
    "firstname": "hadambu",
    "lastname": "stelian",
    "rank": "profesor doctor",
    "username": "stelian06",
    "password": "123",
    "courses": [
        "Matematica",
        "Informatica"
    ]
}
Response:
{"Response":"successful"} - 200
Invalid JWT - 401
```

```
/api/login
Payload:
{
    "username":"dennis",
    "password":"123"
}

Response:
{
    "JWT": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJVc2VybmFtZVwiOlwiZGVubmlzXCIsXCJQcml2ZWxlZ2VcIjpcIjBcIn0iLCJpYXQiOjE3MTY5MjUwNDUsImV4cCI6MTcxNzc4OTA0NX0.DwzqrGo51HyJhG-pRaPLrlUnH9-6fMb3s0shTsLiFAGt2jiQbl10TPIcnnXHVCzYuhxjmzd9A5OWKh9sXipCCQ"
}
```

```
/api/register
Payload:
{           "jwt":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJVc2VybmFtZVwiOlwiZGVubmlzXCIsXCJQcml2ZWxlZ2VcIjpcIjBcIn0iLCJpYXQiOjE3MTY5MjUwMjksImV4cCI6MTcxNzc4OTAyOX0.YRRYD8n_s8iaAOWTsRBkTbDiF3yV1QrGSyikpgmm8Eatu2T00SlD94CiW8xrzvbmwQaGxwA4drSVHf7-EYOcwQ",
    "username":"luca",
    "password":"1234"
}

Response:
Inregistrare cu succes:
{"RegisterStatus":"sucessful"}

Inregistrare (user-ul deja exista)
{"RegisterStatus":"user_already_exists"}

Inregistrare (format invalid)
{"RegisterStatus":"user_register_form_invalid"}
```


# SQL TABELS

```
CREATE TABLE Users (
    ID SERIAL PRIMARY KEY,
    USERNAME VARCHAR NOT NULL UNIQUE,
    PASSWORD VARCHAR NOT NULL,
    PRIVILEGE INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE Grades (
    ID SERIAL PRIMARY KEY,
    NR_MATRICOL VARCHAR NOT NULL,
    ID_COURSE INTEGER NOT NULL,
    VALUE SMALLINT CHECK (value >= 1 AND value <= 10),
    NOTATION_DATE DATE
);

CREATE TABLE Courses (
    ID SERIAL PRIMARY KEY,
    COURSE_TITLE VARCHAR NOT NULL,
    YEAR SMALLINT CHECK (year >= 0 AND year <= 9),
    SEMESTER SMALLINT CHECK (semester >= 0 AND semester <= 2),
    CREDITS SMALLINT CHECK (credits >= 0 AND credits <= 10),
    UNIQUE (YEAR, SEMESTER, COURSE_TITLE)
);

CREATE TABLE Professors (
    ID SERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR,
    LAST_NAME VARCHAR,
    RANK VARCHAR,
    USER_ID INTEGER,
    FOREIGN KEY (USER_ID) REFERENCES Users(ID)
);

CREATE TABLE Schedule (
    ID SERIAL PRIMARY KEY,
    ID_PROFESSOR INTEGER NOT NULL,
    WEEK_DAY VARCHAR NOT NULL,
    TIME_DAY TIME NOT NULL,
    GROUP_ID INTEGER NOT NULL,
    COURSE_ID INTEGER NOT NULL
);

CREATE TABLE Didactic (
    ID SERIAL PRIMARY KEY,
    ID_PROFESSOR INTEGER NOT NULL,
    ID_COURSE INTEGER NOT NULL,
    UNIQUE (ID_PROFESSOR, ID_COURSE)
);

CREATE TABLE Students (
    ID SERIAL PRIMARY KEY,
    NR_MATRICOL VARCHAR NOT NULL,
    FIRST_NAME VARCHAR,
    LAST_NAME VARCHAR
);

CREATE TABLE StudentYears (
    ID SERIAL PRIMARY KEY,
    ID_STUDENT INTEGER NOT NULL,
    SERIAL_NUMBER VARCHAR NOT NULL,
    YEAR INTEGER CHECK (year >= 1900 AND year <= 2100),
    STUDY_YEAR INTEGER CHECK (study_year >= 1 AND study_year <= 10),
    GROUP_ID INTEGER NOT NULL,
    FOREIGN KEY (ID_STUDENT) REFERENCES Students(ID),
    UNIQUE (SERIAL_NUMBER, YEAR, STUDY_YEAR)
);

CREATE TABLE Announcements (
    ID SERIAL PRIMARY KEY,
    ANNOUNCEMENT_CONTENT VARCHAR NOT NULL,
    UPLOAD_DATE DATE
    
);
```
