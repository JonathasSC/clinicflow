CREATE TABLE addresses (
    id BIGSERIAL PRIMARY KEY,
    street VARCHAR(255),
    number VARCHAR(50),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(100),
    zip_code VARCHAR(20)
);

CREATE TABLE clinics (
    id BIGSERIAL PRIMARY KEY,
    tenant_id UUID NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    address_id BIGINT,
    CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES addresses(id)
);

