CREATE TABLE SERVICES (
                          SERVICE_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
                          NAME VARCHAR UNIQUE,
                          PRICE NUMBER(12,2)
);

CREATE TABLE CUSTOMERS (
                           CUSTOMER_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
                           FIRST_NAME VARCHAR,
                           LAST_NAME VARCHAR,
                           EMAIL VARCHAR,
                           PHONE VARCHAR,
                           ADDRESS VARCHAR
);

CREATE TABLE VENDORS (
                         VENDOR_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
                         NAME VARCHAR NOT NULL,
                         CONTACT VARCHAR,
                         PHONE VARCHAR,
                         EMAIL VARCHAR,
                         ADDRESS VARCHAR
);

CREATE TABLE PRODUCTS (
                          PRODUCT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                          NAME VARCHAR UNIQUE,
                          PRICE NUMBER (12,2),
                          VENDOR_ID BIGINT NOT NULL,
                          FOREIGN KEY (VENDOR_ID) references VENDORS(VENDOR_ID)
)
