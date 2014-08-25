#!/usr/bin/env bash

function alert {
	echo ""
	echo $1
	echo ""
}

alert "Sandbox bootstrap. Running with args: < $@ >"

for script in $* ; do
	alert ">> Now running ${script}.sh"

	sh "/vagrant/$script.sh"

	alert "<< Done ${script}.sh"
done

sh "/vagrant/centos.sh"
 