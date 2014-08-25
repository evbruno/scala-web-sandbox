#!/usr/bin/env bash

echo "### Installing MongoDB !"

read -d '' repo <<- EOF
[mongodb]
name=MongoDB Repository
baseurl=http://downloads-distro.mongodb.org/repo/redhat/os/x86_64/
gpgcheck=0
enabled=1
EOF

echo "$repo" > /etc/yum.repos.d/mongodb.repo

yum install --assumeyes mongodb-org

service mongod start

chkconfig mongod on

# error on restarting

touch /lib/tmpfiles.d/mongodb.conf
echo 'd /var/run/mongodb 0755 mongod mongod' > /lib/tmpfiles.d/mongodb.conf

# systemd-tmpfiles --create mongodb.conf