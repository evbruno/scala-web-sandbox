# Vagrant

:computer: Tries to mimic a tiny/micro server to deploy our application.

```bash
# booting up
$ vagrant up

# box ssh
$ vagrant ssh

# halting / starting
$ vagrant halt
$ vagrant up --provision
$ vagrant reload --provision

# if you get some error like : "vboxsf" file system is not available
# try this commands
$ vagrant plugin install vagrant-vbguest
$ vagrant reload
```

## Troubleshooting

- [Vagrant error : Failed to mount folders in Linux guest](http://stackoverflow.com/questions/22717428/vagrant-error-failed-to-mount-folders-in-linux-guest)
- If the port forwarding does't work on CentOS, look at [centos.sh](centos.sh)
