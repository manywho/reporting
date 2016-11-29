CREATE TABLE public.events_flow
(
  id uuid NOT NULL,
  type character varying(60) NOT NULL,
  occurred_at timestamp with time zone NOT NULL,
  tenant_id uuid NOT NULL,
  user_id uuid NOT NULL,
  flow_id uuid NOT NULL,
  flow_version_id uuid NOT NULL,
  data jsonb,
  CONSTRAINT pk_events_flow PRIMARY KEY (id, tenant_id)
);

-- Index: public.idx_events_flow_flow_id

-- DROP INDEX public.idx_events_flow_flow_id;

CREATE INDEX idx_events_flow_flow_id
  ON public.events_flow
  USING btree
  (flow_id);

-- Index: public.idx_events_flow_flow_version_id

-- DROP INDEX public.idx_events_flow_flow_version_id;

CREATE INDEX idx_events_flow_flow_version_id
  ON public.events_flow
  USING btree
  (flow_version_id);

-- Index: public.idx_events_flow_occurred_at_asc

-- DROP INDEX public.idx_events_flow_occurred_at_asc;

CREATE INDEX idx_events_flow_occurred_at_asc
  ON public.events_flow
  USING btree
  (occurred_at);

-- Index: public.idx_events_flow_occurred_at_desc

-- DROP INDEX public.idx_events_flow_occurred_at_desc;

CREATE INDEX idx_events_flow_occurred_at_desc
  ON public.events_flow
  USING btree
  (occurred_at DESC);

-- Index: public.idx_events_flow_tenant_id

-- DROP INDEX public.idx_events_flow_tenant_id;

CREATE INDEX idx_events_flow_tenant_id
  ON public.events_flow
  USING btree
  (tenant_id);

-- Index: public.idx_events_flow_type

-- DROP INDEX public.idx_events_flow_type;

CREATE INDEX idx_events_flow_type
  ON public.events_flow
  USING btree
  (type COLLATE pg_catalog."default");

-- Index: public.idx_events_flow_user_id

-- DROP INDEX public.idx_events_flow_user_id;

CREATE INDEX idx_events_flow_user_id
  ON public.events_flow
  USING btree
  (user_id);

