CREATE TABLE IF NOT EXISTS todos (
    id IDENTITY NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(511) NOT NULL,
    deadline DATE NOT NULL,
    done BOOLEAN NOT NULL
);
