CREATE TABLE currencies (
    currency_code varchar PRIMARY KEY,
    currency_name text
);

CREATE TABLE countries (
    country_code varchar PRIMARY KEY,
    country_name text,
    capital_name text,
    phone_code varchar,
    flag_link text,
    currency_code varchar REFERENCES currencies(currency_code) ON DELETE CASCADE
);
