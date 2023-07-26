podman -c podman-machine-default \
    run \
    --rm \
    --userns keep-id:uid=999,gid=999 \
    -d \
    -e MYSQL_ROOT_PASSWORD=lab \
    -e MYSQL_DATABASE=lab \
    -e MYSQL_USER=lab \
    -e MYSQL_PASSWORD=lab \
    --security-opt label=disable \
    --name mysql \
    -v /Users/vmaridu/stuff/installation/mysql:/var/lib/mysql \
    -p 3306:3306 \
    mysql:latest