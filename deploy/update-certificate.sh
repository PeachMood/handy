certbot certonly --webroot --webroot-path /var/www/html -d handy-notes.ru -d www.handy-notes.ru
docker exec handy_server_1 nginx -s reload
