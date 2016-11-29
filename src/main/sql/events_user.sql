-- Table: public.events_user

-- DROP TABLE public.events_user;

CREATE TABLE public.events_user
(
  id uuid NOT NULL,
  type character varying(60) NOT NULL,
  occurred_at timestamp with time zone NOT NULL,
  tenant_id uuid NOT NULL,
  user_id uuid NOT NULL,
  data jsonb,
  CONSTRAINT pk_events_user PRIMARY KEY (id, tenant_id)
);

-- Index: public.idx_events_user_occurred_at_asc

-- DROP INDEX public.idx_events_user_occurred_at_asc;

CREATE INDEX idx_events_user_occurred_at_asc
  ON public.events_user
  USING btree
  (occurred_at);

-- Index: public.idx_events_user_occurred_at_desc

-- DROP INDEX public.idx_events_user_occurred_at_desc;

CREATE INDEX idx_events_user_occurred_at_desc
  ON public.events_user
  USING btree
  (occurred_at DESC);

-- Index: public.idx_events_user_tenant_id

-- DROP INDEX public.idx_events_user_tenant_id;

CREATE INDEX idx_events_user_tenant_id
  ON public.events_user
  USING btree
  (tenant_id);

-- Index: public.idx_events_user_type

-- DROP INDEX public.idx_events_user_type;

CREATE INDEX idx_events_user_type
  ON public.events_user
  USING btree
  (type COLLATE pg_catalog."default");

-- Index: public.idx_events_user_user_id

-- DROP INDEX public.idx_events_user_user_id;

CREATE INDEX idx_events_user_user_id
  ON public.events_user
  USING btree
  (user_id);

