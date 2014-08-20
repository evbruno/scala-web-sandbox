#!/usr/bin/env bash

cd /opt/
echo "### Current directory: $(pwd)"
echo "### Downloading jdk8 from oracle !"

wget --no-cookies --no-check-certificate  --header 'Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie' -O jdk-8-oracle.tar.gz 'http://download.oracle.com/otn-pub/java/jdk/8u20-b26/jdk-8u20-linux-x64.tar.gz' 

tar xzvf jdk-8-oracle.tar.gz
# rm -rf jdk-8-oracle.tar.gz

echo 'export JAVA_HOME=/opt/jdk1.8.0_20' >> /etc/profile
echo 'export PATH=$PATH:/opt/jdk1.8.0_20/bin' >> /etc/profile

echo '### Done !'
