CREATE TABLE IF NOT EXISTS public.transaction
(
    transcation_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    source_account_id bigint NOT NULL,
    currency character varying(100) COLLATE pg_catalog."default" NOT NULL,
    amount money NOT NULL,
    created_at timestamp without time zone,
    CONSTRAINT transaction_pkey PRIMARY KEY (transcation_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction
    OWNER to postgres;