#!/bin/sh
set -e

# Start the MySQL server
mysqld --user=mysql --console --skip-name-resolve &
mysql_pid=$!

# Wait for the server to start
until mysqladmin ping >/dev/null 2>&1; do
  sleep 1
done

# Create a MySQL user and database
mysql -e "CREATE DATABASE vm_db;"
mysql -e "CREATE USER 'vm_root'@'%' IDENTIFIED BY 'hello@8383';"
mysql -e "GRANT ALL PRIVILEGES ON vm_db.* TO 'vm_root'@'%';"

# Stop the MySQL server
kill "$mysql_pid"

# Start the MySQL server in the foreground
exec mysqld --user=mysql --console --skip-name-resolve