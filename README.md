# KYC Case Study

## Database logins
- mysql.username = test
- mysql.password = test

## Vault configurations
- set VAULT_TOKEN = 00000000-0000-0000-0000-000000000000
- set VAULT_ADDR = http://127.0.0.1:8200
- vault kv put secret/mysql-config mysql.username=test mysql.password=test

#check
