-- Table: public.events_tenant

-- DROP TABLE public.events_tenant;

CREATE TABLE public.events_tenant
(
  id uuid NOT NULL,
  type character varying(60) NOT NULL,
  occurred_at timestamp with time zone NOT NULL,
  tenant_id uuid NOT NULL,
  data jsonb,
  CONSTRAINT pk_events_tenant PRIMARY KEY (id, tenant_id)
);

-- Index: public.idx_events_tenant_occurred_at_asc

-- DROP INDEX public.idx_events_tenant_occurred_at_asc;

CREATE INDEX idx_events_tenant_occurred_at_asc
  ON public.events_tenant
  USING btree
  (occurred_at);

-- Index: public.idx_events_tenant_occurred_at_desc

-- DROP INDEX public.idx_events_tenant_occurred_at_desc;

CREATE INDEX idx_events_tenant_occurred_at_desc
  ON public.events_tenant
  USING btree
  (occurred_at DESC);

-- Index: public.idx_events_tenant_tenant_id

-- DROP INDEX public.idx_events_tenant_tenant_id;

CREATE INDEX idx_events_tenant_tenant_id
  ON public.events_tenant
  USING btree
  (tenant_id);

-- Index: public.idx_events_tenant_type

-- DROP INDEX public.idx_events_tenant_type;

CREATE INDEX idx_events_tenant_type
  ON public.events_tenant
  USING btree
  (type COLLATE pg_catalog."default");

