set search_path to laptrinhjavaweb;

CREATE TABLE email
(
  id bigserial NOT NULL,
  createdby character varying(255),
  createddate timestamp without time zone,
  modifiedby character varying(255),
  modifieddate timestamp without time zone,
  fullname character varying(255),
  email character varying(255)
)