ALTER TYPE roles ADD VALUE 'ADMIN';

CREATE TABLE admin_profiles (
    id uuid PRIMARY KEY,
    user_id uuid UNIQUE NOT NULL,
    surname VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    additional_name VARCHAR(100),

    CONSTRAINT fk_admin_profiles_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);