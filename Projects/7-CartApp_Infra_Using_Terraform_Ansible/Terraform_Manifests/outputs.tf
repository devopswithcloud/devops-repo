output "instance_ips" {
  # Public and Private IPS of the vms creted 
  value = {
    jenkins_master = {
        public_ip = aws_instance.tf-ec2["jenkins-master"].public_ip
        private_ip = aws_instance.tf-ec2["jenkins-master"].private_ip
    },
    jenkins_slave = {
        public_ip = aws_instance.tf-ec2["jenkins-slave"].public_ip
        private_ip = aws_instance.tf-ec2["jenkins-slave"].private_ip 
    },
    ansible = {
        public_ip = aws_instance.tf-ec2["ansible"].public_ip
        private_ip = aws_instance.tf-ec2["ansible"].private_ip 
    },
    sonarqube = {
        public_ip = aws_instance.tf-ec2["sonarqube"].public_ip
        private_ip = aws_instance.tf-ec2["sonarqube"].private_ip 
    }
  }

}

// These are ephemiral ipss

// Modify the script to get the static ips, rather than epemeral ips ???