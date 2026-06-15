CREATE TYPE roles AS ENUM('CLIENT', 'COURIER', 'MANAGER');
CREATE TYPE vehicles AS ENUM('ON_FOOT', 'BICYCLE', 'CAR');
CREATE TYPE order_statuses AS ENUM(
    'CREATED',
    'PAID',
    'PREPARING',
    'READY',
    'DELIVERING',
    'DELIVERED',
    'CANCELLED'
);

CREATE TABLE users (
    id uuid PRIMARY KEY,
    email VARCHAR(254) UNIQUE NOT NULL,
    is_active BOOLEAN NOT NULL,
    phone_number VARCHAR(15) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
    user_id uuid NOT NULL,
    role roles NOT NULL,

    PRIMARY KEY (user_id, role),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE cities (
    id uuid PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE streets (
    id uuid PRIMARY KEY,
    city_id uuid,
    name VARCHAR(255) NOT NULL,

    UNIQUE (city_id, name),

    CONSTRAINT fk_streets_city FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE addresses (
    id uuid PRIMARY KEY,
    street_id uuid NOT NULL,

    building VARCHAR(20) NOT NULL,

    entrance VARCHAR(10),
    floor INT,
    intercom VARCHAR(20),
    apartment VARCHAR(20),

    latitude NUMERIC(10, 7),
    longitude NUMERIC(10, 7),

    CONSTRAINT fk_addresses_street FOREIGN KEY (street_id) REFERENCES streets(id)
);

CREATE TABLE client_profiles (
    id uuid PRIMARY KEY,
    user_id uuid UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    default_address_id uuid,
    rebate INT DEFAULT 0,

    CONSTRAINT fk_client_profiles_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_client_profiles_street FOREIGN KEY (default_address_id) REFERENCES addresses(id)
);

CREATE TABLE courier_profiles (
    id uuid PRIMARY KEY,
    user_id uuid UNIQUE NOT NULL,
    surname VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    additional_name VARCHAR(100) NOT NULL,
    vehicle_type vehicles NOT NULL,
    passport_num VARCHAR(10),

    CONSTRAINT fk_courier_profiles_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE banks (
    id uuid PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE foods (
    id uuid PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    calories INT NOT NULL,
    composition TEXT NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE restaurants (
    id uuid PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address_id uuid NOT NULL,

    CONSTRAINT fk_restaurants_address FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE menu_categories (
    id uuid PRIMARY KEY,
    restaurant_id uuid NOT NULL,
    name VARCHAR(50) NOT NULL,
    sort_order INT NOT NULL,

    CONSTRAINT fk_menu_category_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

CREATE TABLE menu_items (
    id uuid PRIMARY KEY,
    menu_category_id uuid NOT NULL,
    food_id uuid NOT NULL,
    name VARCHAR(50) NOT NULL,
    price NUMERIC(19, 4) NOT NULL,

    UNIQUE (menu_category_id, name),

    CONSTRAINT fk_menu_items_menu_category FOREIGN KEY (menu_category_id) REFERENCES menu_categories(id),
    CONSTRAINT fk_menu_food FOREIGN KEY (food_id) REFERENCES foods(id)
);

CREATE TABLE manager_profiles (
    id uuid PRIMARY KEY,
    user_id uuid UNIQUE NOT NULL,
    restaurant_id uuid NOT NULL,
    surname VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    additional_name VARCHAR(100) NOT NULL,
    passport_num VARCHAR(10),

    CONSTRAINT fk_manager_profiles_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_manager_profiles_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

CREATE TABLE orders (
    id uuid PRIMARY KEY,
    client_id uuid NOT NULL,
    restaurant_id uuid NOT NULL,
    courier_id uuid,

    status order_statuses NOT NULL DEFAULT 'CREATED',
    total_amount NUMERIC(19, 4) NOT NULL,

    delivery_address_id uuid NOT NULL,

    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    delivered_at TIMESTAMP,

    CONSTRAINT fk_orders_client FOREIGN KEY (client_id) REFERENCES client_profiles(id),
    CONSTRAINT fk_orders_restaurant FOREIGN KEY (restaurant_id) REFERENCES restaurants(id),
    CONSTRAINT fk_orders_courier FOREIGN KEY (courier_id) REFERENCES courier_profiles(id),
    CONSTRAINT fk_orders_delivery_address FOREIGN KEY (delivery_address_id) REFERENCES addresses(id)
);

CREATE TABLE order_items (
    id uuid PRIMARY KEY,
    order_id uuid NOT NULL,
    menu_item_id uuid NOT NULL,

    quantity INT NOT NULL CHECK (quantity > 0),
    price_at_purchase NUMERIC(19, 4) NOT NULL,

    UNIQUE (order_id, menu_item_id),

    CONSTRAINT fk_order_items_order FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT fk_order_items_menu_item FOREIGN KEY (menu_item_id) REFERENCES menu_items(id)
);
