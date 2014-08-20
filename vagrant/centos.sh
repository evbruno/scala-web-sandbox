#!/usr/bin/env bash

echo "CentOS perks: disabling firewalld"
echo

service firewalld stop
chkconfig --del firewalld
