CREATE TABLE public.events_api
(
  id uuid NOT NULL,
  type character varying(60) NOT NULL,
  occurred_at timestamp with time zone NOT NULL,
  uri character varying NOT NULL,
  data jsonb,
  ip_address inet NOT NULL,
  tenant_id uuid,
  method character varying NOT NULL,
  size bigint,
  duration integer,
  CONSTRAINT pk_events_api PRIMARY KEY (id, occurred_at)
);

CREATE INDEX idx_events_api_method
  ON public.events_api
  USING btree
  (method COLLATE pg_catalog."default");

-- Index: public.idx_events_api_occurred_at_asc

-- DROP INDEX public.idx_events_api_occurred_at_asc;

CREATE INDEX idx_events_api_occurred_at_asc
  ON public.events_api
  USING btree
  (occurred_at);

-- Index: public.idx_events_api_occurred_at_desc

-- DROP INDEX public.idx_events_api_occurred_at_desc;

CREATE INDEX idx_events_api_occurred_at_desc
  ON public.events_api
  USING btree
  (occurred_at DESC);

-- Index: public.idx_events_api_tenant_id

-- DROP INDEX public.idx_events_api_tenant_id;

CREATE INDEX idx_events_api_tenant_id
  ON public.events_api
  USING btree
  (tenant_id);

-- Index: public.idx_events_api_type

-- DROP INDEX public.idx_events_api_type;

CREATE INDEX idx_events_api_type
  ON public.events_api
  USING btree
  (type COLLATE pg_catalog."default");

-- Index: public.idx_events_api_uri

-- DROP INDEX public.idx_events_api_uri;

CREATE INDEX idx_events_api_uri
  ON public.events_api
  USING btree
  (uri COLLATE pg_catalog."default");
