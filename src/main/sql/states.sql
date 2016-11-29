CREATE TABLE states
(
  id uuid NOT NULL,
  currentmapelementid uuid,
  currentmapelementname character varying,
  flowid uuid NOT NULL,
  flowversionid uuid NOT NULL,
  flowname character varying NOT NULL,
  done boolean NOT NULL,
  tenantid uuid NOT NULL,
  currentuseremail character varying,
  datemodified timestamp with time zone NOT NULL,
  CONSTRAINT pk_states PRIMARY KEY (id)
);

CREATE TABLE statevalues
(
  stateid uuid NOT NULL,
  elementid uuid NOT NULL,
  key character varying NOT NULL,
  value jsonb NOT NULL,
  CONSTRAINT pk_statevalues PRIMARY KEY (stateid, elementid),
  CONSTRAINT fk_statevalues_state FOREIGN KEY (stateid)
      REFERENCES states (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);