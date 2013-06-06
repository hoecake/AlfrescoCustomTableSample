CREATE TABLE aegif_custom_table
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    run_date DATETIME NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;