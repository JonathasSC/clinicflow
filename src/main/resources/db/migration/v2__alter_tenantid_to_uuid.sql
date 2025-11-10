ALTER TABLE clinics
ALTER COLUMN tenant_id TYPE uuid
USING tenant_id::uuid;
