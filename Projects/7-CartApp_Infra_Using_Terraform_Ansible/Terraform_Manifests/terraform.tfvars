vpc_cidr_blocks = "10.0.0.0/16"
subnet_cidr_blocks = "10.0.10.0/24"
availability_zone = "us-east-1a"
public_ip = "0.0.0.0/0"
env_prefix = "dev"
instances_configs = {
    jenkins-master = {
        amiid = "ami-053b0d53c279acc90"
        instance_type = "t2.micro" 
        key_name = "project-key"
    }
    jenkins-slave = {
        amiid = "ami-053b0d53c279acc90"
        instance_type = "t2.micro" #"t3.medium" 
        key_name = "project-key"
    }
    ansible = {
        amiid = "ami-053b0d53c279acc90"
        instance_type = "t2.micro" 
        key_name = "project-key"
    }
    sonarqube = {
        amiid = "ami-053b0d53c279acc90"
        instance_type = "t3.medium" 
        key_name = "project-key"
    }
}
