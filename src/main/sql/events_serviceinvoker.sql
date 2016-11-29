CREATE TABLE public.events_serviceinvoker
(
  id uuid NOT NULL,
  type character varying(60) NOT NULL,
  occurred_at timestamp with time zone NOT NULL,
  request_id uuid NOT NULL,
  tenant_id uuid NOT NULL,
  user_id uuid,
  flow_id uuid,
  flow_version_id uuid,
  state_id uuid,
  uri character varying NOT NULL,
  data jsonb,
  service_uri character varying NOT NULL,
  endpoint character varying NOT NULL,
  service_id uuid,
  size bigint NOT NULL,
  duration integer NOT NULL,
  CONSTRAINT pk_events_serviceinvoker PRIMARY KEY (id, tenant_id)
);

-- Index: public.idx_events_serviceinvoker_duration

-- DROP INDEX public.idx_events_serviceinvoker_duration;

CREATE INDEX idx_events_serviceinvoker_duration
  ON public.events_serviceinvoker
  USING btree
  (duration);

-- Index: public.idx_events_serviceinvoker_endpoint

-- DROP INDEX public.idx_events_serviceinvoker_endpoint;

CREATE INDEX idx_events_serviceinvoker_endpoint
  ON public.events_serviceinvoker
  USING btree
  (endpoint COLLATE pg_catalog."default");

-- Index: public.idx_events_serviceinvoker_flow_id

-- DROP INDEX public.idx_events_serviceinvoker_flow_id;

CREATE INDEX idx_events_serviceinvoker_flow_id
  ON public.events_serviceinvoker
  USING btree
  (flow_id);

-- Index: public.idx_events_serviceinvoker_flow_version_id

-- DROP INDEX public.idx_events_serviceinvoker_flow_version_id;

CREATE INDEX idx_events_serviceinvoker_flow_version_id
  ON public.events_serviceinvoker
  USING btree
  (flow_version_id);

-- Index: public.idx_events_serviceinvoker_occurred_at_asc

-- DROP INDEX public.idx_events_serviceinvoker_occurred_at_asc;

CREATE INDEX idx_events_serviceinvoker_occurred_at_asc
  ON public.events_serviceinvoker
  USING btree
  (occurred_at);

-- Index: public.idx_events_serviceinvoker_occurred_at_desc

-- DROP INDEX public.idx_events_serviceinvoker_occurred_at_desc;

CREATE INDEX idx_events_serviceinvoker_occurred_at_desc
  ON public.events_serviceinvoker
  USING btree
  (occurred_at DESC);

-- Index: public.idx_events_serviceinvoker_request_id

-- DROP INDEX public.idx_events_serviceinvoker_request_id;

CREATE INDEX idx_events_serviceinvoker_request_id
  ON public.events_serviceinvoker
  USING btree
  (request_id);

-- Index: public.idx_events_serviceinvoker_service_id

-- DROP INDEX public.idx_events_serviceinvoker_service_id;

CREATE INDEX idx_events_serviceinvoker_service_id
  ON public.events_serviceinvoker
  USING btree
  (service_id);

-- Index: public.idx_events_serviceinvoker_service_uri

-- DROP INDEX public.idx_events_serviceinvoker_service_uri;

CREATE INDEX idx_events_serviceinvoker_service_uri
  ON public.events_serviceinvoker
  USING btree
  (service_uri COLLATE pg_catalog."default");

-- Index: public.idx_events_serviceinvoker_size

-- DROP INDEX public.idx_events_serviceinvoker_size;

CREATE INDEX idx_events_serviceinvoker_size
  ON public.events_serviceinvoker
  USING btree
  (size);

-- Index: public.idx_events_serviceinvoker_state_id

-- DROP INDEX public.idx_events_serviceinvoker_state_id;

CREATE INDEX idx_events_serviceinvoker_state_id
  ON public.events_serviceinvoker
  USING btree
  (state_id);

-- Index: public.idx_events_serviceinvoker_tenant_id

-- DROP INDEX public.idx_events_serviceinvoker_tenant_id;

CREATE INDEX idx_events_serviceinvoker_tenant_id
  ON public.events_serviceinvoker
  USING btree
  (tenant_id);

-- Index: public.idx_events_serviceinvoker_type

-- DROP INDEX public.idx_events_serviceinvoker_type;

CREATE INDEX idx_events_serviceinvoker_type
  ON public.events_serviceinvoker
  USING btree
  (type COLLATE pg_catalog."default");

-- Index: public.idx_events_serviceinvoker_uri

-- DROP INDEX public.idx_events_serviceinvoker_uri;

CREATE INDEX idx_events_serviceinvoker_uri
  ON public.events_serviceinvoker
  USING btree
  (uri COLLATE pg_catalog."default");

-- Index: public.idx_events_serviceinvoker_user_id

-- DROP INDEX public.idx_events_serviceinvoker_user_id;

CREATE INDEX idx_events_serviceinvoker_user_id
  ON public.events_serviceinvoker
  USING btree
  (user_id);

