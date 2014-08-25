# verify if the activator exists AND its on the $PATH

if hash activator 2>/dev/null; then
	echo "### activator found"
	activator --version
	exit 1
fi

cd /home/vagrant/
echo "### Current directory: $(pwd)"
echo "### Downloading Typesafe Activator 1.2.7 !"

runuser -l vagrant -c 'wget --no-cookies -q "http://downloads.typesafe.com/typesafe-activator/1.2.7/typesafe-activator-1.2.7.zip"'
runuser -l vagrant -c 'unzip typesafe-activator-1.2.7.zip'

echo 'export PATH=$PATH:/home/vagrant/activator-1.2.7/' >> /etc/profile

echo '### Done !'
